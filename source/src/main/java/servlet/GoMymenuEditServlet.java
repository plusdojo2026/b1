package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.LoginUser;
import dto.Mymenu;


/**
 * Servlet implementation class GoMymenuRegistServlet
 */
@WebServlet("/gomymenuregist")
public class GoMymenuEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

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
		
		
		Mymenu mymenu = new Mymenu(0,name,user_id,buns1,buns2,patty1,patty2,patty3,vege1,vege2,vege3,topping1,topping2,topping3,sauce,price,null,null);
		request.setAttribute("mymenu",mymenu);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/regist_sim_mymenu.jsp");
		dispatcher.forward(request, response);
	}
}