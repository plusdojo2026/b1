package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CategoriesDAO;
import dao.MaterialsDAO;
import dto.Category;
import dto.LoginUser;
import dto.Material;

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
		
        // フォームからユーザーの選択値（A または B）を取得
        String answer = request.getParameter("answer");
        
        // 診断アルゴリズム：選択に応じておすすめのバーガー名と画像名を動的に決定
        String burgerName = "";
        String burgerImage = "";

        if ("B".equals(answer)) {
            // B.チキンが選択された場合：照り焼きチキンバーガー
            burgerName = "照り焼きチキンバーガー";
            burgerImage = "teriyaki_chicken.png"; 
        } else {
            // A.ビーフが選択された場合：ビッグビーフバーガー
            burgerName = "ビッグビーフバーガー";
            burgerImage = "big_beef.png";
        }

        // 決定した診断結果データをリクエストスコープに格納
        request.setAttribute("burgerName", burgerName);
        request.setAttribute("burgerImage", burgerImage);

        // 【バグ修正】呼び出すJSP名を正確な「result_akinator.jsp」に変更
        request.getRequestDispatcher("/WEB-INF/jsp/result_akinator.jsp").forward(request, response);
    }
}

