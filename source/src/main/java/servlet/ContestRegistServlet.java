package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ContestmenusDAO;
import dao.ContestsDAO;
import dto.Contest;
import dto.Contestmenu;
import dto.LoginUser;
import dto.Result;

/**
 * Servlet implementation class MymenuRegistServlet
 */
@WebServlet("/contestregist")
public class ContestRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContestRegistServlet() {
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
		ContestsDAO contestdao = new ContestsDAO();
		Contest contest = contestdao.selectByNowDate();
		int contest_id = contest.getId();
		request.setAttribute("contest_id", contest_id);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/regist_sim_contest.jsp");
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
		String name = request.getParameter("name");
		int user_id = loginUser.getId();
		int buns1 = Integer.parseInt(request.getParameter("bunstop"));
		int buns2 = Integer.parseInt(request.getParameter("bunsbottom"));
		int patty1 = Integer.parseInt(request.getParameter("patty1"));
		int patty2 = Integer.parseInt(request.getParameter("patty2"));
		int patty3 = Integer.parseInt(request.getParameter("patty3"));
		int vege1 = Integer.parseInt(request.getParameter("vegetable1"));
		int vege2 = Integer.parseInt(request.getParameter("vegetable2"));
		int vege3 = Integer.parseInt(request.getParameter("vegetable3"));
		int topping1 = Integer.parseInt(request.getParameter("topping1"));
		int topping2 = Integer.parseInt(request.getParameter("topping2"));
		int topping3 = Integer.parseInt(request.getParameter("topping3"));
		int sauce = Integer.parseInt(request.getParameter("sauce"));
		int price = Integer.parseInt(request.getParameter("price"));
		int contest_id = Integer.parseInt(request.getParameter("contest_id"));
		
		// 登録処理を行う
		ContestmenusDAO Dao = new ContestmenusDAO();;
		if (Dao.insert(new Contestmenu(0,name,user_id,buns1,buns2,patty1,patty2,patty3,vege1,vege2,vege3,topping1,topping2,topping3,sauce,price,contest_id,null,null))) { // 登録成功
			request.setAttribute("result", new Result("登録成功！", "レコードを登録しました。", "/webapp/MenuServlet"));
			RequestDispatcher dispatcher = request.getRequestDispatcher("/home");
			dispatcher.forward(request, response);
		} else { // 登録失敗
			request.setAttribute("result", new Result("登録失敗！", "データを登録できませんでした。", "/webapp/MenuServlet"));
			RequestDispatcher dispatcher = request.getRequestDispatcher("/home");
			dispatcher.forward(request, response);
		}
	}
}