package servlet; 

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// @WebServlet アノテーションでブラウザからのアクセスURLを定義
@WebServlet("/mydata") 
public class MydataServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // ブラウザからリクエストを受け取った際に実行されるdoGetメソッド
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // 1. 文字化け防止のためのエンコーディング設定
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        // 2. ファストフード店データベースからの取得データを想定（テストデータ）
        String userRank = "Gold";
        String userName = "ミスターバーガー";
        int protein = 45;
        int fiber = 12;

        // 3. JSP側でデータを取得できるように、値をrequestオブジェクトに格納
        request.setAttribute("rankData", userRank);
        request.setAttribute("nameData", userName);
        request.setAttribute("proteinData", protein);
        request.setAttribute("fiberData", fiber);

        // 4. 指定したJSPファイル（mydata.jsp）へリクエストをフォワード
        request.getRequestDispatcher("/WEB-INF/jsp/mydata.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doGet(request, response);
    }
}
