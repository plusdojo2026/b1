package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// マイデータ画面の「ログアウト」ボタンから呼び出されるサーブレット
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // ボタンのonclickリンク（location.href）からリクエストを受け取る処理
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // 1. 現在のセッション（ログイン状態の保持エリア）を取得
        HttpSession session = request.getSession(false);
        
        if (session != null) {
            // 2. セッションを完全に無効化（中身のLoginUserオブジェクトなどを一括消去）
            session.invalidate();
        }

        // 3. 【バグ防止】ログアウト完了後は、安全にログイン画面のサーブレット（/login）へリダイレクト
        response.sendRedirect(request.getContextPath() + "/login");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doGet(request, response);
    }
}
