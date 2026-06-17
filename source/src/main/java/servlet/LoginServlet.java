package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsersDAO;
import dto.User;


// ログイン画面の遷移およびバリデーションを制御するServlet
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // 画面の初期表示処理
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        // ログイン画面（JSP）を表示
    	RequestDispatcher dispatcher =
                request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
        dispatcher.forward(request, response);
    }


    // 「ログイン」ボタン押下時の処理
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        // フォームから電話番号とパスワードを取得
        String phone = request.getParameter("phoneNumber");
        String pw = request.getParameter("password");

        
        
        // 未入力チェック（バリデーション）
        boolean emptyError = 
        		(phone == null || phone.trim().isEmpty()) ||
        		(pw == null || pw.trim().isEmpty());
            
            // エラーメッセージと入力値を保持して元の画面に戻す
        if(emptyError) {
            request.setAttribute("emptyError", true);
            request.setAttribute("phoneNumber", phone);
            
            RequestDispatcher dispatcher =
                    request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
            dispatcher.forward(request, response);
            return;
        }

        // TODO: ここでデータベースの会員テーブルと照合（認証処理）を行う
        UsersDAO dao = new UsersDAO();
        User user = dao.search(phone, pw);
        
     // 認証失敗
        if (user == null) {
            request.setAttribute("loginError", true);
            request.setAttribute("phoneNumber", phone);

            RequestDispatcher dispatcher =
                    request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
            dispatcher.forward(request, response);
            return;
        }

        
        // 認証が成功したと仮定して、あなたのDTO（LoginUser）をSessionに保存
        dto.LoginUser loginUser = new dto.LoginUser("U001"); // テスト用ユーザーIDを設定
        HttpSession session = request.getSession();//ここも残す
        session.setAttribute("loginUser", loginUser);//テストオワタら削除
        //本番用
        //session.setAttribute("loginUser", user);

        // ログイン成功後はマイデータ画面（Servlet）へリダイレクト
        response.sendRedirect(request.getContextPath() + "/home");
    }
}
