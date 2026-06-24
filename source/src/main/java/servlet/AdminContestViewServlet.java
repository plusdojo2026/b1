package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.VotesDAO;
import dto.Vote;
/**
 * Servlet implementation class AdminContestViewServlet
 */

@WebServlet("/admincontestview")
public class AdminContestViewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 文字コードは最初に設定
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        //セッションからログイン状態を検証
        HttpSession session = request.getSession();
        dto.LoginUser loginUser = (dto.LoginUser) session.getAttribute("loginUser");

        if (loginUser == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        // DAO呼び出し
        VotesDAO dao = new VotesDAO();

        // 上位3件を取得（DAOで作成するメソッド）
        List<Vote> rankList = dao.getTop3Votes();

        // JSPに渡す
        request.setAttribute("rankList", rankList);
        
        // フォワード
        RequestDispatcher dispatcher =
            request.getRequestDispatcher("/WEB-INF/jsp/result_admin_contest.jsp");

        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
