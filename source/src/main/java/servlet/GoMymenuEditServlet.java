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
import dto.Mymenu;


/**
 * Servlet implementation class GoMymenueditServlet
 */
@WebServlet("/gomymenuedit")
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
		
		int mymenuId =
			    Integer.parseInt(request.getParameter("mymenuId"));
		MymenusDAO dao = new MymenusDAO();

		Mymenu mymenu =
		    dao.selectById(mymenuId);
		request.setAttribute("mymenu", mymenu);

		RequestDispatcher dispatcher =
		        request.getRequestDispatcher(
		            "/WEB-INF/jsp/edit_sim_mymenu.jsp");

		dispatcher.forward(request,response);
		
	}
}