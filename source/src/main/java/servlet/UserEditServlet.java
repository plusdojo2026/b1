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

// 会員情報変更画面の遷移およびバリデーションを制御するServlet
@WebServlet("/edit_mydata")
public class UserEditServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // 画面の初期表示処理
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        // 1. セッションからログイン中のユーザー（DTO）を取得
        HttpSession session = request.getSession();
        
        // 2. 未ログインの場合はログイン画面へ強制遷移        
        LoginUser loginUser = (LoginUser) session.getAttribute("loginUser");

        if (loginUser == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }
        
        // ログインユーザーの情報を取得
        int user_id = loginUser.getId();
        
        UsersDAO dao = new UsersDAO();
        User user = dao.selectById(user_id);
        
        String name = user.getName();
        String phone = user.getPhone();
        String pw = user.getPw();
        
        
        request.setAttribute("userName", name);
        request.setAttribute("phoneNumber", phone);
        request.setAttribute("password", pw);
        
        request.getRequestDispatcher("/WEB-INF/jsp/edit_mydata.jsp").forward(request, response);
    }

    // 「会員情報を変更する」ボタン押下時の処理
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        // 1. セッションからログイン中のユーザー（DTO）を取得
        HttpSession session = request.getSession();
        
        // 2. 未ログインの場合はログイン画面へ強制遷移        
        LoginUser loginUser = (LoginUser) session.getAttribute("loginUser");

        if (loginUser == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        String name = request.getParameter("userName");
        String phone = request.getParameter("phoneNumber");
        String pw = request.getParameter("password");
        String pwConf = request.getParameter("passwordConf");

        // 未入力チェック（バリデーション）
        if (name == null || name.trim().isEmpty() || 
            phone == null || phone.trim().isEmpty() || 
            pw == null || pw.trim().isEmpty() ||
            pwConf == null || pwConf.trim().isEmpty()) {
            
            // エラーメッセージと入力値を保持して元の画面に戻す
            request.setAttribute("errorMessage", "ユーザー名、パスワード、電話番号を入力してください。");
            request.setAttribute("userName", name);
            request.setAttribute("phoneNumber", phone);
            
            request.getRequestDispatcher("/WEB-INF/jsp/edit_mydata.jsp").forward(request, response);
            return;
        }
        
        // ユーザーネームの文字数チェック
        if (name.length() >= 9) {
            request.setAttribute("errorMessage", "ユーザー名は8文字以内で設定してください。");
            request.setAttribute("userName", name);
            request.setAttribute("phoneNumber", phone);
            request.getRequestDispatcher("/WEB-INF/jsp/edit_mydata.jsp").forward(request, response);
            return;
        }
        
        // 電話番号の文字チェック
        if (phone.length() >= 12 || !phone.matches("[0-9]+")) {
            request.setAttribute("errorMessage", "電話番号に誤りがあります。");
            request.setAttribute("userName", name);
            request.setAttribute("phoneNumber", phone);
            request.getRequestDispatcher("/WEB-INF/jsp/edit_mydata.jsp").forward(request, response);
            return;
        }
        
        // パスワード一致チェック
        if (!pw.equals(pwConf)) {
            request.setAttribute("errorMessage", "パスワードと確認用パスワードが一致しません。");
            request.setAttribute("userName", name);
            request.setAttribute("phoneNumber", phone);
            request.getRequestDispatcher("/WEB-INF/jsp/edit_mydata.jsp").forward(request, response);
            return;
        }
        
        // ログインユーザーの情報を取得
        int user_id = loginUser.getId();
        
        UsersDAO dao = new UsersDAO();
        User user_info = dao.selectById(user_id);
        
        int rank_id = user_info.getRank_id();
        int vote = user_info.getVote();
        int level = user_info.getLevelup_menu();
        
        // TODO: ここでデータベースへの会員登録（Insert）処理を実行
        //DTO作成
        User user = new User(
        		loginUser.getId(),
        	    phone, //電話番号
        	    pw,    
        	    name,  //ユーザー名
        		rank_id,  //ランクID
        		"bacon.png", //ここにアイコンまだない
        		vote,    //vote
        		level,    //levelup_menu
        		null,
        		null
        		);
        		
        //boolean result = dao.insert(user);  
        dao.update(user);   // 戻り値を見ない

        // 更新成功後はマイデータ画面へリダイレクト
        response.sendRedirect(request.getContextPath() + "/mydata");
    }
}