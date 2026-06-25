package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsersDAO;
import dto.LoginUser;
import dto.User;

// 新規会員登録画面の遷移およびバリデーションを制御するServlet
@WebServlet("/regist_user")
public class UserRegistServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // 画面の初期表示処理
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        // 登録画面（JSP）を表示
        request.getRequestDispatcher("/WEB-INF/jsp/regist_user.jsp").forward(request, response);
    }

    // 「新規会員登録」ボタン押下時の処理
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        // 各入力フォームから値を取得
        String name = request.getParameter("userName");
        String phone = request.getParameter("phoneNumber");
        String pass = request.getParameter("password");
        String passConf = request.getParameter("passwordConfirm");
        String checked = request.getParameter("confirmCheck"); // チェックボックスの状態

        // 未入力チェック（バリデーション）
        if (name == null || name.trim().isEmpty() || 
            phone == null || phone.trim().isEmpty() || 
            pass == null || pass.trim().isEmpty() || 
            passConf == null || passConf.trim().isEmpty() || 
            checked == null) { // チェックボックスが未チェックの場合も含む
            
            // エラーメッセージと入力値を保持して元の画面に戻す
            request.setAttribute("errorMessage", "すべての項目を入力し、確認チェックを入れてください。");
            request.setAttribute("userName", name);
            request.setAttribute("phoneNumber", phone);
            
            request.getRequestDispatcher("/WEB-INF/jsp/regist_user.jsp").forward(request, response);
            return;
        }

        // パスワード一致チェック
        if (!pass.equals(passConf)) {
            request.setAttribute("errorMessage", "パスワードと確認用パスワードが一致しません。");
            request.setAttribute("userName", name);
            request.setAttribute("phoneNumber", phone);
            request.getRequestDispatcher("/WEB-INF/jsp/regist_user.jsp").forward(request, response);
            return;
        }
        
        // ユーザーネームの文字数チェック
        if (name.length() >= 11) {
            request.setAttribute("errorMessage", "ユーザー名は10文字以内で設定してください。");
            request.setAttribute("userName", name);
            request.setAttribute("phoneNumber", phone);
            request.getRequestDispatcher("/WEB-INF/jsp/regist_user.jsp").forward(request, response);
            return;
        }
        
        // 電話番号の文字チェック
        if (phone.length() >= 12 || !phone.matches("[0-9]+")) {
            request.setAttribute("errorMessage", "電話番号に誤りがあります。");
            request.setAttribute("userName", name);
            request.setAttribute("phoneNumber", phone);
            request.getRequestDispatcher("/WEB-INF/jsp/regist_user.jsp").forward(request, response);
            return;
        }
        
        // パスワードの文字数チェック
        if (pass.length() >= 21) {
            request.setAttribute("errorMessage", "パスワードは20文字以内で設定してください。");
            request.setAttribute("userName", name);
            request.setAttribute("phoneNumber", phone);
            request.getRequestDispatcher("/WEB-INF/jsp/regist_user.jsp").forward(request, response);
            return;
        }

        // TODO: ここでデータベースへの会員登録（Insert）処理を実行
        //DTO作成
        User user = new User(
        		0,     //id自動採番
        	    phone, //電話番号
        	    pass,    
        	    name,  //ユーザー名
        		1,  //ランクID
        		"bacon.png", //ここにアイコンまだない
        		5,    //vote
        		1,    //levelup_menu
        		null,
        		null
        		);
        		
        UsersDAO dao  = new UsersDAO();
        //boolean result = dao.insert(user);  
           // 戻り値を見ない
        boolean result = dao.insert(user);

		if (result) {
			// 登録成功
			HttpSession session = request.getSession();
			User user2 = dao.search(phone, pass);
			int id2=user2.getId();
			session.setAttribute("loginUser", new LoginUser(id2));
			int rank = user2.getRank_id();    
	        session.setAttribute("rank", rank);
			
			// homeへ
			//登録成功メッセージをスコープへ
	        session.setAttribute("result_message", "会員情報を登録しました。");
	        
	        // 登録成功後はログイン画面、またはホーム画面へ遷移
	        response.sendRedirect(request.getContextPath() + "/home");

		} else {
			// 登録失敗
			HttpSession session = request.getSession();
			session.setAttribute("errorMessage", "会員情報が登録できませんでした。");
			// 登録画面へ戻す
			request.getRequestDispatcher("/WEB-INF/jsp/regist_user.jsp").forward(request, response);
		}
    }
}
