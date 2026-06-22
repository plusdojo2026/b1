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

import dao.ContestmenusDAO;
import dto.Contestmenu;
import dto.LoginUser;

@WebServlet("/joincontestview")
public class JoinContestViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// セッションからユーザーID取得
		HttpSession session = request.getSession();
//		Integer userId = (Integer) session.getAttribute("loginUser");

		// 未ログインの場合はログイン画面へ強制遷移
		LoginUser loginUser = (LoginUser)
				request.getSession().getAttribute("loginUser");
		
		// 未ログインの場合
        if (loginUser == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }
		
		int userId = loginUser.getId();
		
//		// テスト用
//		if (userId == null) {
//			userId = 1;
//		}
		
		
		// DAO呼び出し
		ContestmenusDAO dao = new ContestmenusDAO();
		List<Contestmenu> contestList = dao.selectByUserId(userId);

		// リクエストに格納
		request.setAttribute("contestList", contestList);

		// ユーザーコンテスト結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/view_contest.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}