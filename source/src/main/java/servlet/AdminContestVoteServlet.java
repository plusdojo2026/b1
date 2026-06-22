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

import dao.ContestmenusDAO;
import dao.ContestsDAO;
import dao.MaterialsDAO;
import dao.UsersDAO;
import dto.Contest;
import dto.Contestmenu;
import dto.LoginUser;
import dto.Material;
import dto.User;


@WebServlet("/admincontestvote")
public class AdminContestVoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

	// コンテストの一覧表示を行う
		// 2. 未ログインの場合はログイン画面へ強制遷移        
        LoginUser loginUser = (LoginUser) session.getAttribute("loginUser");
        
        if (loginUser == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }
        
		// ログインユーザーの投票数を取得
	    int login_id = loginUser.getId();
	    
	    UsersDAO uDao = new UsersDAO();
	    User login_user = uDao.selectById(login_id);
	    
	    int vote = login_user.getVote();
	    
	    // リクエストスコープに投票数を格納
	    request.setAttribute("vote", vote);	

        //現在開催中のコンテストIDを取得
		ContestsDAO contestsDao = new ContestsDAO();
		Contest contest = contestsDao.selectByNowDate();
		
		int contest_id = contest.getId();
		
		//対象コンテストに登録されたメニュー表を取得
		ContestmenusDAO cmenusDao = new ContestmenusDAO();
		List<Contestmenu> cmenuList = cmenusDao.selectByContestId_Admin(contest_id);
		
		//一覧用のリストの方を作る
		List<Map<String, Object>> viewList = new ArrayList<>();

		// リストが終わりまでループ
		for(int i = 0; i < cmenuList.size(); i++) {

		    Contestmenu cmenu = cmenuList.get(i);
		    
		    // cmenuList(i)の素材IDを取得
		    int id = cmenu.getId();
		    String name = cmenu.getName();
		    int price = cmenu.getPrice();
		    
		    int patty1_Id = cmenu.getPatty1();
		    int patty2_Id = cmenu.getPatty2();
		    int patty3_Id = cmenu.getPatty3();
		    int top1_Id = cmenu.getTopping1();
		    int top2_Id = cmenu.getTopping2();
		    int top3_Id = cmenu.getTopping3();
		    int vege1_Id = cmenu.getVege1();
		    int vege2_Id = cmenu.getVege2();
		    int vege3_Id = cmenu.getVege3();

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
		    
		 // ユーザーネームを取得
		    int user_id = cmenu.getUser_id();
		    
		    User user = uDao.selectById(user_id);
		    
		    String user_name = user.getName();
		    

		    // マップにメニュー情報・各素材情報を格納
		    Map<String, Object> map = new HashMap<>();

		    map.put("menu", cmenu);
		    map.put("id", id);
		    map.put("name", name);
		    map.put("user_name", user_name);
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

		    viewList.add(map);
		}

		// リクエストスコープに格納する
		request.setAttribute("menus", viewList);		
		
		// 投票ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/vote_admin_contest.jsp");
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