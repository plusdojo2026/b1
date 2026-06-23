package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CategoriesDAO;
import dao.MaterialsDAO;
import dao.MenusDAO;
import dto.Category;
import dto.LoginUser;
import dto.Material;
import dto.Menu;

// 質問画面の表示と、結果画面（result_akinator.jsp）への転送を制御するサーブレット
@WebServlet("/AkinatorQuestionResultServlet")
public class AkinatorQuestionResultServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // 質問画面（Q.今日の気分は？）を初期表示する処理
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        //セッションからログイン状態を検証
        HttpSession session = request.getSession();
        dto.LoginUser loginUser = (dto.LoginUser) session.getAttribute("loginUser");

        if (loginUser == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }
        
        List<String> questionlist = new ArrayList<String>();
        List<Integer> list = new ArrayList<>(Arrays.asList(2, 3, 4, 5));
        Random random = new Random();
        int category_id = random.nextInt(4)+2;
        list.remove(Integer.valueOf(category_id));
        MaterialsDAO materialsdao = new MaterialsDAO();
        CategoriesDAO categoriesdao = new CategoriesDAO();
        for(int i : list) {
        	Category category = categoriesdao.selectById(i);
        	String categoryname = category.getName();
        	questionlist.add(categoryname);
        	List<Material> materiallist = materialsdao.selectByCategory(i);
        	if(materiallist.size() >= 2) {
        	    Collections.shuffle(materiallist);

        	    Material material1 = materiallist.get(0);
        	    Material material2 = materiallist.get(1);

        	    questionlist.add(material1.getName());
        	    questionlist.add(material2.getName());
        	}
        }
        request.setAttribute("category1", questionlist.get(0));
        request.setAttribute("material11", questionlist.get(1));
        request.setAttribute("material12", questionlist.get(2));
        request.setAttribute("category2", questionlist.get(3));
        request.setAttribute("material21", questionlist.get(4));
        request.setAttribute("material22", questionlist.get(5));
        request.setAttribute("category3", questionlist.get(6));
        request.setAttribute("material31", questionlist.get(7));
        request.setAttribute("material32", questionlist.get(8));


        // 質問選択画面のJSPへフォワード
        request.getRequestDispatcher("/WEB-INF/jsp/question_akinator.jsp").forward(request, response);
    }

    // ユーザーが選択肢（A.ビーフ / B.チキン）をクリックした際の判定処理
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
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
		String category1_name = request.getParameter("category1");
		String category2_name = request.getParameter("category2");
		String category3_name = request.getParameter("category3");
		String material11_name = request.getParameter("material11");
		String material12_name = request.getParameter("material12");
		String material21_name = request.getParameter("material21");
		String material22_name = request.getParameter("material22");
		String material31_name = request.getParameter("material31");
		String material32_name = request.getParameter("material32");
		
		CategoriesDAO categorydao = new CategoriesDAO();
		Category category1 = categorydao.selectByName(category1_name);
		int category1_id = category1.getId();
		Category category2 = categorydao.selectByName(category2_name);
		int category2_id = category2.getId();
		Category category3 = categorydao.selectByName(category3_name);
		int category3_id = category3.getId();
		MaterialsDAO materialdao = new MaterialsDAO();
		Material material11 = materialdao.selectByName(material11_name);
		int material11_id = material11.getId();
		Material material12 = materialdao.selectByName(material12_name);
		int material12_id = material12.getId();
		Material material21 = materialdao.selectByName(material21_name);
		int material21_id = material21.getId();
		Material material22 = materialdao.selectByName(material22_name);
		int material22_id = material22.getId();
		Material material31 = materialdao.selectByName(material31_name);
		int material31_id = material31.getId();
		Material material32 = materialdao.selectByName(material32_name);
		int material32_id = material32.getId();
		
		List<Menu> answerlist = new ArrayList<Menu>();
		List<Menu> ans1 = new ArrayList<Menu>();
		MenusDAO menudao = new MenusDAO();
		ans1 = menudao.selectByPatty(material11_id);
		answerlist.addAll(ans1);
		List<Menu> ans2 = new ArrayList<Menu>();
		MenusDAO menudao2 = new MenusDAO();
		ans2 = menudao2.selectBySauce(material11_id);
		answerlist.addAll(ans2);
		List<Menu> ans3 = new ArrayList<Menu>();
		MenusDAO menudao3 = new MenusDAO();
		ans3 = menudao3.selectByTopping(material11_id);
		answerlist.addAll(ans3);
		List<Menu> ans4 = new ArrayList<Menu>();
		MenusDAO menudao4 = new MenusDAO();
		ans4 = menudao4.selectByVege(material11_id);
		answerlist.addAll(ans4);
		List<Menu> ans5 = new ArrayList<Menu>();
		MenusDAO menudao5 = new MenusDAO();
		ans5 = menudao5.selectByPatty(material12_id);
		answerlist.addAll(ans5);
		List<Menu> ans6 = new ArrayList<Menu>();
		MenusDAO menudao6 = new MenusDAO();
		ans6 = menudao6.selectBySauce(material12_id);
		answerlist.addAll(ans6);
		List<Menu> ans7 = new ArrayList<Menu>();
		MenusDAO menudao7 = new MenusDAO();
		ans7 = menudao7.selectByTopping(material12_id);
		answerlist.addAll(ans7);
		List<Menu> ans8 = new ArrayList<Menu>();
		MenusDAO menudao8 = new MenusDAO();
		ans8 = menudao8.selectByVege(material12_id);
		answerlist.addAll(ans8);
		List<Menu> ans9 = new ArrayList<Menu>();
		MenusDAO menudao9 = new MenusDAO();
		ans9 = menudao9.selectByPatty(material21_id);
		answerlist.addAll(ans9);
		List<Menu> ans10 = new ArrayList<Menu>();
		MenusDAO menudao10 = new MenusDAO();
		ans10 = menudao10.selectBySauce(material21_id);
		answerlist.addAll(ans10);
		List<Menu> ans11 = new ArrayList<Menu>();
		MenusDAO menudao11 = new MenusDAO();
		ans11 = menudao11.selectByTopping(material21_id);
		answerlist.addAll(ans11);
		List<Menu> ans12 = new ArrayList<Menu>();
		MenusDAO menudao12 = new MenusDAO();
		ans12 = menudao12.selectByVege(material21_id);
		answerlist.addAll(ans12);
		List<Menu> ans13 = new ArrayList<Menu>();
		MenusDAO menudao13 = new MenusDAO();
		ans13 = menudao13.selectByPatty(material22_id);
		answerlist.addAll(ans13);
		List<Menu> ans14 = new ArrayList<Menu>();
		MenusDAO menudao14 = new MenusDAO();
		ans14 = menudao14.selectBySauce(material22_id);
		answerlist.addAll(ans14);
		List<Menu> ans15 = new ArrayList<Menu>();
		MenusDAO menudao15 = new MenusDAO();
		ans15 = menudao15.selectByTopping(material22_id);
		answerlist.addAll(ans15);
		List<Menu> ans16 = new ArrayList<Menu>();
		MenusDAO menudao16 = new MenusDAO();
		ans16 = menudao16.selectByVege(material22_id);
		answerlist.addAll(ans16);
		List<Menu> ans17 = new ArrayList<Menu>();
		MenusDAO menudao17 = new MenusDAO();
		ans17 = menudao17.selectByPatty(material31_id);
		answerlist.addAll(ans17);
		List<Menu> ans18 = new ArrayList<Menu>();
		MenusDAO menudao18 = new MenusDAO();
		ans18 = menudao18.selectBySauce(material31_id);
		answerlist.addAll(ans18);
		List<Menu> ans19 = new ArrayList<Menu>();
		MenusDAO menudao19 = new MenusDAO();
		ans19 = menudao19.selectByTopping(material31_id);
		answerlist.addAll(ans19);
		List<Menu> ans20 = new ArrayList<Menu>();
		MenusDAO menudao20 = new MenusDAO();
		ans20 = menudao20.selectByVege(material31_id);
		answerlist.addAll(ans20);
		List<Menu> ans21 = new ArrayList<Menu>();
		MenusDAO menudao21 = new MenusDAO();
		ans21 = menudao21.selectByPatty(material32_id);
		answerlist.addAll(ans21);
		List<Menu> ans22 = new ArrayList<Menu>();
		MenusDAO menudao22 = new MenusDAO();
		ans22 = menudao22.selectBySauce(material32_id);
		answerlist.addAll(ans22);
		List<Menu> ans23 = new ArrayList<Menu>();
		MenusDAO menudao23 = new MenusDAO();
		ans23 = menudao23.selectByTopping(material32_id);
		answerlist.addAll(ans23);
		List<Menu> ans24 = new ArrayList<Menu>();
		MenusDAO menudao24 = new MenusDAO();
		ans24 = menudao24.selectByVege(material32_id);
		answerlist.addAll(ans24);
		
		Map<Integer, Integer> countMap = new HashMap<>();

		for (Menu menu : answerlist) {
		    int menuId = menu.getId();

		    if (countMap.containsKey(menuId)) {
		        countMap.put(menuId, countMap.get(menuId) + 1);
		    } else {
		        countMap.put(menuId, 1);
		    }
		}
		
		int maxCount = 0;
		int bestMenuId = 0;

		for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
		    if (entry.getValue() > maxCount) {
		        maxCount = entry.getValue();
		        bestMenuId = entry.getKey();
		    }
		}
		
		Menu bestMenu = null;

		for (Menu menu : answerlist) {
		    if (menu.getId() == bestMenuId) {
		        bestMenu = menu;
		        break;
		    }
		}
		
		//一覧用のリストの方を作る
		
		
		if (bestMenu == null) {
			Random random = new Random();
	        int menu_id = random.nextInt(5)+1;
	        bestMenu = menudao.selectById(menu_id);
		}
		
		Menu answermenu = bestMenu;
		// bestmenuの素材IDを取得
	    int id = answermenu.getId();
	    String name = answermenu.getName();
	    int price = answermenu.getPrice();
	    
	    int patty1_Id = answermenu.getPatty1();
	    int patty2_Id = answermenu.getPatty2();
	    int patty3_Id = answermenu.getPatty3();
	    int top1_Id = answermenu.getTopping1();
	    int top2_Id = answermenu.getTopping2();
	    int top3_Id = answermenu.getTopping3();
	    int vege1_Id = answermenu.getVege1();
	    int vege2_Id = answermenu.getVege2();
	    int vege3_Id = answermenu.getVege3();

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
	    
	    map.put("id",id);
	    map.put("menu", answermenu);
	    map.put("name", name);
	    map.put("price", price);
	    map.put("patty1", patty1);
	    map.put("patty2", patty2);
	    map.put("patty3", patty3);
	    map.put("top1", top1);
	    map.put("top2", top2);
	    map.put("top3", top3);
	    map.put("vege1", vege1);
	    map.put("vege2", vege2);
	    map.put("vege3", vege3);
	    
	    // 決定した診断結果データをリクエストスコープに格納
	    request.setAttribute("menu", map);
		
        
        

        // 【バグ修正】呼び出すJSP名を正確な「result_akinator.jsp」に変更
        request.getRequestDispatcher("/WEB-INF/jsp/result_akinator.jsp").forward(request, response);
    }
}

