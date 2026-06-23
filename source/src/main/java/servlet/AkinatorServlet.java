package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// 診断画面の遷移および診断ロジックを制御するServlet
@WebServlet("/akinator")
public class AkinatorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // 画面の初期表示処理
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        // 1. セッションからログインチェック（ガードロジック）
        HttpSession session = request.getSession();
        dto.LoginUser loginUser = (dto.LoginUser) session.getAttribute("loginUser");

        if (loginUser == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }
        
        // 2. 診断画面（JSP）へフォワード
        request.getRequestDispatcher("/WEB-INF/jsp/akinator.jsp").forward(request, response);
    }

    // 「診断する」ボタンが押されたときの処理（次の質問や結果画面への遷移など）
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        // TODO: ここでユーザーの選択に合わせたおすすめバーガーの診断アルゴリズムを実装
        
        // 次の質問画面、または結果画面へ遷移（ここでは一旦同じ画面に戻るか結果画面へリダイレクト）
        response.sendRedirect(request.getContextPath() + "/AkinatorQuestionResultServlet");
    }
}
