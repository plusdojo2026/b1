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

/**
 * Servlet implementation class UserDeleteServlet
 */
@WebServlet("/UserDeleteServlet")
public class UserDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		//セッションからログイン中のユーザー情報を取得
		HttpSession session = request.getSession();
		LoginUser loginUser = (LoginUser) session.getAttribute("loginUser");
		
		//セッション切れ対策：もしログインしていなければログイン画面へ
		if (loginUser == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		
		//UsersDAOを使ってログイン中のユーザーIDでレコードを削除
		UsersDAO dao = new UsersDAO();
		boolean isDeleted = dao.delete(loginUser.getId());//通常パターン（こっちを表示させる）
		//boolean isDeleted = dao.delete(999999);//試用失敗パターン（OKだったら消す）
		
		// データ削除したときの処理
				if (isDeleted) {
					// 成功：セッションを消してログイン画面へ
					session.invalidate();
					response.sendRedirect(request.getContextPath() + "/login");
				} else {
					// 失敗：ホームの「URL」にリダイレクト
					session.setAttribute("result_message", "アカウント削除に失敗しました。");
				    // ホームの「URL」にリダイレクト
				    response.sendRedirect(request.getContextPath() + "/home");
				}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
