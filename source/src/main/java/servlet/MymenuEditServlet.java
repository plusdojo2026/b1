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
import dto.Mymenu;
import dto.Result;

/**
 * Servlet implementation class MymenuRegistServlet
 */
@WebServlet("/mymenuedit")
public class MymenuEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MymenuEditServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		int id = Integer.parseInt(request.getParameter("id"));
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
		
		
		// 登録処理を行う
		MymenusDAO Dao = new MymenusDAO();;
		if (Dao.update(new Mymenu(id,name,user_id,buns1,buns2,patty1,patty2,patty3,vege1,vege2,vege3,topping1,topping2,topping3,sauce,price,null,null))) { // 登録成功
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