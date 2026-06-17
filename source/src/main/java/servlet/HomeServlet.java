package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// ホーム画面の遷移およびデータ制御を行うServlet
@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        // 1. セッションからログイン中のユーザー（DTO）を取得
        // HttpSession session = request.getSession();
        // dto.LoginUser loginUser = (dto.LoginUser) session.getAttribute("loginUser");

        // 2. 未ログインの場合はログイン画面へ強制遷移
        // if (loginUser == null) {
        //    response.sendRedirect(request.getContextPath() + "/login");
        //    return;
        //}

        // 3. テストデータとして画像に合わせ「ミスターバーガー」「Gold」を設定
        request.setAttribute("userName", "ミスターバーガー");
        request.setAttribute("userRank", "Gold");
        
        // 4. ホーム画面（JSP）へフォワード
        request.getRequestDispatcher("/WEB-INF/jsp/home.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doGet(request, response);
    }
}
