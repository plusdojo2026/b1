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
import dao.VotesDAO;
import dto.Contest;
import dto.Contestmenu;
import dto.LoginUser;
import dto.Material;


@WebServlet("/joincontestview")
public class JoinContestViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("loginUser") == null) {
			response.sendRedirect("/b1/login");
			return;
		}
		
	// 一覧表示を行う
		// 2. 未ログインの場合はログイン画面へ強制遷移        
        LoginUser loginUser = (LoginUser) session.getAttribute("loginUser");

        if (loginUser == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }
        //ここにメニュー育成機能追加
        int user_id = loginUser.getId();

		ContestmenusDAO contestmenusDao = new ContestmenusDAO();
		List<Contestmenu> contestmenuList = contestmenusDao.selectByUserId(user_id);
		
		if (contestmenuList == null || contestmenuList.isEmpty()) {
		    request.setAttribute("menus", null);
		    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/view_contest.jsp");
		    dispatcher.forward(request, response);
		    return;
		}
		
		
		//一覧用のリストの方を作る
		List<Map<String, Object>> viewList = new ArrayList<>();

		// リストが終わりまでループ
		for(int i = 0; i < contestmenuList.size(); i++) {

		    Contestmenu contestmenu = contestmenuList.get(i);
		    
		    // mymenuList(i)の素材IDを取得
		    int id = contestmenu.getId();
		    String name = contestmenu.getName();
		    int price = contestmenu.getPrice();
		    
		    int patty1_Id = contestmenu.getPatty1();
		    int patty2_Id = contestmenu.getPatty2();
		    int patty3_Id = contestmenu.getPatty3();
		    int top1_Id = contestmenu.getTopping1();
		    int top2_Id = contestmenu.getTopping2();
		    int top3_Id = contestmenu.getTopping3();
		    int vege1_Id = contestmenu.getVege1();
		    int vege2_Id = contestmenu.getVege2();
		    int vege3_Id = contestmenu.getVege3();
		    int contest_Id = contestmenu.getContest_id();

		 // ★ contest_id が 0 のメニューはスキップ
		 if (contest_Id == 0) {
		     continue;
		 }


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
		    
		    ContestsDAO contestsDao = new ContestsDAO();
		    Contest contest = contestsDao.selectById(contest_Id);

		    String contest_name = "";
		    if (contest != null) {
		        contest_name = contest.getName();
		    } else {
		        contest_name = "未参加";
		    }
		    
		    VotesDAO votedao = new VotesDAO();
		    int vote = votedao.getCountByMenu(id);
		    // マップにメニュー情報・各素材情報を格納
		    Map<String, Object> map = new HashMap<>();
		    
		    map.put("id",id);
		    map.put("menu", contestmenu);
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
		    map.put("contest_name",contest_name);
		    map.put("vote", vote);

		    viewList.add(map);
		}

		// リクエストスコープに格納する
		request.setAttribute("menus", viewList);


		//マイメニュー一覧ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/view_contest.jsp");
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