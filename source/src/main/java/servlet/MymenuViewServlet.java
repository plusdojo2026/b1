package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MaterialsDAO;
import dao.MymenusDAO;
import dto.Material;
import dto.Mymenu;


@WebServlet("/mymenuview")
public class MymenuViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/b1/login");
			return;
		}
		
	// 一覧表示を行う
		String useridStr = (String) session.getAttribute("loginUser");
		int userid = Integer.parseInt(useridStr);

		MymenusDAO mymenusDao = new MymenusDAO();
		List<Mymenu> mymenuList = mymenusDao.select(userid);
		
		//一覧用のリストの方を作る
		List<Map<String, Object>> viewList = new ArrayList<>();

		// リストが終わりまでループ
		for(int i = 0; i < mymenuList.size(); i++) {

		    Mymenu mymenu = mymenuList.get(i);
		    
		    // mymenuList(i)の素材IDを取得
		    int patty1_Id = mymenu.getPatty1();
		    int patty2_Id = mymenu.getPatty2();
		    int patty3_Id = mymenu.getPatty3();
		    int top1_Id = mymenu.getTopping1();
		    int top2_Id = mymenu.getTopping2();
		    int top3_Id = mymenu.getTopping3();
		    int vege1_Id = mymenu.getVege1();
		    int vege2_Id = mymenu.getVege2();
		    int vege3_Id = mymenu.getVege3();

		    MaterialsDAO materialsDao = new MaterialsDAO();

		 // 素材IDから対応する素材カラムを取得
		    Material patty1 = materialsDao.selectById(patty1_Id);
		    Material patty2 = materialsDao.selectById(patty2_Id);
		    Material patty3 = materialsDao.selectById(patty3_Id);
		    Material top1 = materialsDao.selectById(top1_Id);
		    Material top2 = materialsDao.selectById(top2_Id);
		    Material top3 = materialsDao.selectById(top3_Id);
		    Material vege1 = materialsDao.selectById(vege1_Id);
		    Material vege2 = materialsDao.selectById(vege2_Id);
		    Material vege3 = materialsDao.selectById(vege3_Id);

		    // マップにメニュー情報・各素材情報を格納
		    Map<String, Object> map = new HashMap<>();

		    map.put("menu", mymenu);
		    map.put("patty1", patty1);
		    map.put("patty2", patty2);
		    map.put("patty3", patty3);
		    map.put("top1", top1);
		    map.put("top2", top2);
		    map.put("top3", top3);
		    map.put("vege1", vege1);
		    map.put("vege2", vege2);
		    map.put("vege3", vege3);

		    viewList.add(map);
		}

		// リクエストスコープに格納する
		request.setAttribute("menus", viewList);


		//マイメニュー一覧ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/view_mymenu.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
