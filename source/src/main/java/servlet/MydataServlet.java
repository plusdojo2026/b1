package servlet; 

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MaterialsDAO;
import dao.MenusDAO;
import dao.MymenusDAO;
import dao.OrdersDAO;
import dao.UsersDAO;  // 既存のUsersDAOを使用
import dto.LoginUser;
import dto.Material;
import dto.Menu;
import dto.Mymenu;
import dto.Order;
import dto.User;

// マイデータ画面の遷移およびデータ制御を行うServlet
@WebServlet("/mydata") 
public class MydataServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // 画面の初期表示処理（マイデータ画面へアクセスした際）
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // 文字化け防止のためのエンコーディング設定
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        // 1. セッションからログイン中のユーザー（DTO）を取得
        HttpSession session = request.getSession();
        LoginUser loginUser = (LoginUser) session.getAttribute("loginUser");

        // 2. 未ログインの場合はログイン画面へ強制遷移
        if (loginUser == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }
        
        // ログイン中のユーザーIDを取得
        int id = loginUser.getId(); 

        // 3. 会員テーブルからログイン中のユーザー情報を取得
        UsersDAO usersDao = new UsersDAO();
        User user = usersDao.selectById(id); // 既存のselectByIdメソッドを呼び出し

        // ユーザー名を取得
        String userName = user.getName();
        
        // 【段位实时联动】调用 User DTO 内真实的ゲッターメソッド「getRank_id()」
        int rankId = user.getRank_id(); 
        
        // 根据数据库的 rank_id（1:Bronze, 2:Silver, 3:Gold）传递正确的字符串给 JSP
        String userRank;
        switch (rankId) {
            case 1:
                userRank = "Bronze";
                break;
            case 2:
                userRank = "Silver";
                break;
            case 3:
                userRank = "Gold";
                break;
            default:
                userRank = "Standard"; // 0や想定外の値が入っていた場合のセーフティ
                break;
        }
        
        OrdersDAO oDao = new OrdersDAO();
        List<Order> orderList = oDao.selectByUserId(id);
        
        MenusDAO mDao = new MenusDAO();
        MymenusDAO myDao = new MymenusDAO();
        
        MaterialsDAO maDao = new MaterialsDAO();
        
        int protein = 0; 
        int df = 0;
        
        //通常メニューの計算
        for(int i = 0; i < orderList.size(); i++) {
        	
        	Order order = orderList.get(i);
        	int menu_id = order.getMenu_id();
        	
            if (menu_id == 0) {
                continue;
            }
        	
        	Menu menu = mDao.selectById(menu_id);
        	
        	if (menu == null) {
        	    continue;
        	}
        	
        	int buns1_id = menu.getBuns1();
        	int buns2_id = menu.getBuns2();
        	int patty1_id = menu.getPatty1();
		    int patty2_id = menu.getPatty2();
		    int patty3_id = menu.getPatty3();
		    int vege1_id = menu.getVege1();
		    int vege2_id = menu.getVege2();
		    int vege3_id = menu.getVege3();
		    int top1_id = menu.getTopping1();
		    int top2_id = menu.getTopping2();
		    int top3_id = menu.getTopping3();
        	
		    Material mate_buns1 = maDao.selectById(buns1_id);
		    Material mate_buns2 = maDao.selectById(buns2_id);
		    Material mate_patty1 = maDao.selectById(patty1_id);
		    Material mate_patty2 = maDao.selectById(patty2_id);
		    Material mate_patty3 = maDao.selectById(patty3_id);
		    Material mate_vege1 = maDao.selectById(vege1_id);
		    Material mate_vege2 = maDao.selectById(vege2_id);
		    Material mate_vege3 = maDao.selectById(vege3_id);
		    Material mate_top1 = maDao.selectById(top1_id);
		    Material mate_top2 = maDao.selectById(top2_id);
		    Material mate_top3 = maDao.selectById(top3_id);
		    
		    
		    int pro_buns1 = mate_buns1.getProtein();
		    int df_buns1 = mate_buns1.getDf();
		    
		    int pro_buns2 = mate_buns2.getProtein();
		    int df_buns2 = mate_buns2.getDf();
		    
		    int pro_patty1 = mate_patty1.getProtein();
		    int df_patty1 = mate_patty1.getDf();
		    int pro_patty2 = mate_patty2.getProtein();
		    int df_patty2 = mate_patty2.getDf();
		    int pro_patty3 = mate_patty3.getProtein();
		    int df_patty3 = mate_patty3.getDf();
		    
		    int pro_top1 = mate_top1.getProtein();
		    int df_top1 = mate_top1.getDf();
		    int pro_top2 = mate_top2.getProtein();
		    int df_top2 = mate_top2.getDf();
		    int pro_top3 = mate_top3.getProtein();
		    int df_top3 = mate_top3.getDf();
		    
		    int pro_vege1 = mate_vege1.getProtein();
		    int df_vege1 = mate_vege1.getDf();
		    int pro_vege2 = mate_vege2.getProtein();
		    int df_vege2 = mate_vege2.getDf();
		    int pro_vege3 = mate_vege3.getProtein();
		    int df_vege3 = mate_vege3.getDf();
		    
		    int itemCount = order.getMenu_count();
		    
		    protein = protein + (pro_buns1 + pro_buns2 +
		    		pro_patty1 + pro_patty2 + pro_patty3 +
		    		pro_top1 + pro_top2 + pro_top3 +
		    		pro_vege1 + pro_vege2 + pro_vege3) * itemCount;
		    
		    df = df + (df_buns1 + df_buns2 +
	    		df_patty1 + df_patty2 + df_patty3 +
	    		df_top1 + df_top2 + df_top3 +
	    		df_vege1 + df_vege2 + df_vege3) * itemCount;
        	
        }
        
        for(int i = 0; i < orderList.size(); i++) {
        	
        	Order order = orderList.get(i);
        	int mymenu_id = order.getMymenu_id();
        	
            if (mymenu_id == 0) {
                continue;
            }
        	
        	Mymenu menu = myDao.selectById(mymenu_id);
        	
        	if (menu == null) {
        	    continue;
        	}
        	
        	int buns1_id = menu.getBuns1();
        	int buns2_id = menu.getBuns2();
        	int patty1_id = menu.getPatty1();
		    int patty2_id = menu.getPatty2();
		    int patty3_id = menu.getPatty3();
		    int vege1_id = menu.getVege1();
		    int vege2_id = menu.getVege2();
		    int vege3_id = menu.getVege3();
		    int top1_id = menu.getTopping1();
		    int top2_id = menu.getTopping2();
		    int top3_id = menu.getTopping3();
        	
		    Material mate_buns1 = maDao.selectById(buns1_id);
		    Material mate_buns2 = maDao.selectById(buns2_id);
		    Material mate_patty1 = maDao.selectById(patty1_id);
		    Material mate_patty2 = maDao.selectById(patty2_id);
		    Material mate_patty3 = maDao.selectById(patty3_id);
		    Material mate_vege1 = maDao.selectById(vege1_id);
		    Material mate_vege2 = maDao.selectById(vege2_id);
		    Material mate_vege3 = maDao.selectById(vege3_id);
		    Material mate_top1 = maDao.selectById(top1_id);
		    Material mate_top2 = maDao.selectById(top2_id);
		    Material mate_top3 = maDao.selectById(top3_id);
		    
		    int pro_buns1 = mate_buns1.getProtein();
		    int df_buns1 = mate_buns1.getDf();
		    
		    int pro_buns2 = mate_buns2.getProtein();
		    int df_buns2 = mate_buns2.getDf();
		    
		    int pro_patty1 = mate_patty1.getProtein();
		    int df_patty1 = mate_patty1.getDf();
		    int pro_patty2 = mate_patty2.getProtein();
		    int df_patty2 = mate_patty2.getDf();
		    int pro_patty3 = mate_patty3.getProtein();
		    int df_patty3 = mate_patty3.getDf();
		    
		    int pro_top1 = mate_top1.getProtein();
		    int df_top1 = mate_top1.getDf();
		    int pro_top2 = mate_top2.getProtein();
		    int df_top2 = mate_top2.getDf();
		    int pro_top3 = mate_top3.getProtein();
		    int df_top3 = mate_top3.getDf();
		    
		    int pro_vege1 = mate_vege1.getProtein();
		    int df_vege1 = mate_vege1.getDf();
		    int pro_vege2 = mate_vege2.getProtein();
		    int df_vege2 = mate_vege2.getDf();
		    int pro_vege3 = mate_vege3.getProtein();
		    int df_vege3 = mate_vege3.getDf();
		    
		    int itemCount = order.getMymenu_count();
		    
		    protein = protein + (pro_buns1 + pro_buns2 +
		    		pro_patty1 + pro_patty2 + pro_patty3 +
		    		pro_top1 + pro_top2 + pro_top3 +
		    		pro_vege1 + pro_vege2 + pro_vege3) * itemCount;
		    
		    df = df + (df_buns1 + df_buns2 +
	    		df_patty1 + df_patty2 + df_patty3 +
	    		df_top1 + df_top2 + df_top3 +
	    		df_vege1 + df_vege2 + df_vege3) * itemCount;
        	
        }

        // 5. JSP側で表示できるように、取得したデータをrequestオブジェクトに格納
        request.setAttribute("rankData", userRank);     // 【超重要】配合 JSP 里的原生 Java 判断，实时控制只显示一个标
        request.setAttribute("nameData", userName);       // mydata.jspの ${nameData} に対応
        request.setAttribute("proteinData", protein);   // mydata.jspの ${proteinData} に対応
        request.setAttribute("fiberData", df);       // mydata.jspの ${fiberData} に対応

        // 6. マイデータ画面（JSP）へフォワード
        request.getRequestDispatcher("/WEB-INF/jsp/mydata.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doGet(request, response);
    }
}
