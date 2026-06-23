package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MymenusDAO;
import dto.LoginUser;

/**
 * Servlet implementation class MymenuRegistServlet
 */
@WebServlet("/mymenudelete")
public class MymenuDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MymenuDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// マイメニュー登録ページにフォワードする
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/regist_sim_mymenu.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		LoginUser loginUser =(LoginUser)session.getAttribute("loginUser");
		int id = Integer.parseInt(request.getParameter("mymenuId"));
		
		// 登録処理を行う
		MymenusDAO Dao = new MymenusDAO();;
		if (Dao.delete(id)) { // 登録成功
			session.setAttribute("result_message", "マイメニューを削除しました。");
			response.sendRedirect(request.getContextPath() + "/home");
		} else { // 登録失敗
			session.setAttribute("result_message", "削除に失敗しました。<br>もう一度やり直してください。");
			response.sendRedirect(request.getContextPath() + "/home");
		}
	}
}
