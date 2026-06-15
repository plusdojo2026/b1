package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// ログイン画面の遷移およびバリデーションを制御するServlet
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // 画面の初期表示処理
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        // ログイン画面（JSP）を表示
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
    }

    // 「ログイン」ボタン押下時の処理
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        // フォームから電話番号とパスワードを取得
        String phone = request.getParameter("phoneNumber");
        String pass = request.getParameter("password");

        // 未入力チェック（バリデーション）
        if (phone == null || phone.trim().isEmpty() || 
            pass == null || pass.trim().isEmpty()) {
            
            // エラーメッセージと入力値を保持して元の画面に戻す
            request.setAttribute("errorMessage", "電話番号、パスワードを入力してください。");
            request.setAttribute("phoneNumber", phone);
            
            request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
            return;
        }

        // TODO: ここでデータベースの会員テーブルと照合（認証処理）を行う
        // 認証が成功したと仮定して、あなたのDTO（LoginUser）をSessionに保存
        dto.LoginUser loginUser = new dto.LoginUser("U001"); // テスト用ユーザーIDを設定
        HttpSession session = request.getSession();
        session.setAttribute("loginUser", loginUser);

        // ログイン成功後はマイデータ画面（Servlet）へリダイレクト
        response.sendRedirect(request.getContextPath() + "/mydata");
    }
}
