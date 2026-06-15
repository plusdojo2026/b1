package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 会員情報変更画面の遷移およびバリデーションを制御するServlet
@WebServlet("/edit_mydata")
public class UserEditServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // 画面の初期表示処理
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        // テストデータを初期値として設定
        request.setAttribute("userName", "ミスターバーガー");
        request.setAttribute("phoneNumber", "09012345678");
        request.setAttribute("password", "123456");
        
        request.getRequestDispatcher("/WEB-INF/jsp/edit_mydata.jsp").forward(request, response);
    }

    // 「会員情報を変更する」ボタン押下時の処理
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String name = request.getParameter("userName");
        String phone = request.getParameter("phoneNumber");
        String pass = request.getParameter("password");

        // 未入力チェック（バリデーション）
        if (name == null || name.trim().isEmpty() || 
            phone == null || phone.trim().isEmpty() || 
            pass == null || pass.trim().isEmpty()) {
            
            // エラーメッセージと入力値を保持して元の画面に戻す
            request.setAttribute("errorMessage", "ユーザー名、パスワード、電話番号を入力してください。");
            request.setAttribute("userName", name);
            request.setAttribute("phoneNumber", phone);
            request.setAttribute("password", pass);
            
            request.getRequestDispatcher("/WEB-INF/jsp/edit_mydata.jsp").forward(request, response);
            return;
        }

        // 更新成功後はマイデータ画面へリダイレクト
        response.sendRedirect(request.getContextPath() + "/mydata");
    }
}