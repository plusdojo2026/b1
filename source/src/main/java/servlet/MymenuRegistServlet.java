package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MaterialsDAO;
import dao.MymenusDAO;
import dto.LoginUser;
import dto.Material;
import dto.Mymenu;

/**
 * Servlet implementation class MymenuRegistServlet
 */
@WebServlet("/mymenuregist")
public class MymenuRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MymenuRegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		LoginUser loginUser =(LoginUser)session.getAttribute("loginUser");
		if (loginUser == null) {
		    response.sendRedirect(request.getContextPath() + "/login");
		    return;
		}
		int rank = (int) session.getAttribute("rank");
        if (rank!=3) { // 登録成功
			session.setAttribute("result_message", "マイメニューの登録はゴールドランクから可能です");
			response.sendRedirect(request.getContextPath() + "/home");
			return;
        }
		
		// マイメニュー登録ページにフォワードする
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
		if (loginUser == null) {
		    response.sendRedirect(request.getContextPath() + "/login");
		    return;
		}
		int user_id = loginUser.getId();
		
		String name = request.getParameter("name");
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
		
		MaterialsDAO mDao = new MaterialsDAO();
		
		Material m_buns1 = mDao.selectById(buns1);
		Material m_buns2 = mDao.selectById(buns2);
		Material m_patty1 = mDao.selectById(patty1);
		Material m_patty2 = mDao.selectById(patty2);
		Material m_patty3 = mDao.selectById(patty3);
		Material m_vege1 = mDao.selectById(vege1);
		Material m_vege2 = mDao.selectById(vege2);
		Material m_vege3 = mDao.selectById(vege3);
		Material m_topping1 = mDao.selectById(topping1);
		Material m_topping2 = mDao.selectById(topping2);
		Material m_topping3 = mDao.selectById(topping3);
		Material m_sauce = mDao.selectById(sauce);
		
		int price = 0;
		price = price + m_buns1.getPrice();
		price = price + m_buns2.getPrice();
		price = price + m_patty1.getPrice();
		price = price + m_patty2.getPrice();
		price = price + m_patty3.getPrice();
		price = price + m_vege1.getPrice();
		price = price + m_vege2.getPrice();
		price = price + m_vege3.getPrice();
		price = price + m_topping1.getPrice();
		price = price + m_topping2.getPrice();
		price = price + m_topping3.getPrice();
		price = price + m_sauce.getPrice();
		
		// 登録処理を行う
		MymenusDAO Dao = new MymenusDAO();
		if (Dao.insert(new Mymenu(0,name,user_id,buns1,buns2,patty1,patty2,patty3,vege1,vege2,vege3,topping1,topping2,topping3,sauce,price,null,null))) { // 登録成功
			session.setAttribute("result_message", "マイメニューに追加しました。");
			response.sendRedirect(request.getContextPath() + "/home");
		} else { // 登録失敗
			session.setAttribute("result_message", "登録に失敗しました。<br>もう一度やり直してください。");
			response.sendRedirect(request.getContextPath() + "/home");
		}
	}
}
