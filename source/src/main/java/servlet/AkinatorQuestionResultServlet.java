package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 質問画面の表示と、結果画面（result_akinator.jsp）への転送を制御するサーブレット
@WebServlet("/AkinatorQuestionResultServlet")
public class AkinatorQuestionResultServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // 質問画面（Q.今日の気分は？）を初期表示する処理
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        // セッションからログイン状態を検証
        //HttpSession session = request.getSession();
        //dto.LoginUser loginUser = (dto.LoginUser) session.getAttribute("loginUser");

        //if (loginUser == null) {
            //response.sendRedirect(request.getContextPath() + "/login");
            //return;
        //}

        // 質問選択画面のJSPへフォワード
        request.getRequestDispatcher("/WEB-INF/jsp/question_akinator.jsp").forward(request, response);
    }

    // ユーザーが選択肢（A.ビーフ / B.チキン）をクリックした際の判定処理
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

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

