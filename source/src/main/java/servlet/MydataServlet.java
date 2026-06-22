package servlet; 

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsersDAO;  // 既存のUsersDAOを使用
// import dao.OrdersDAO; // 今後作成する注文用DAO
import dto.LoginUser;
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

        // 1. セッションからログイン中のユーザー（DTO）を取得（HomeServletの文法を参照）
        HttpSession session = request.getSession();
        LoginUser loginUser = (LoginUser) session.getAttribute("loginUser");

        // 2. 未ログインの場合はログイン画面へ強制遷移
        if (loginUser == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }
        
        // ログイン中のユーザーIDを取得
        int id = loginUser.getId(); 

        // 3. 会員テーブルからログイン中のユーザー情報を取得（HomeServletの文法を参照）
        UsersDAO usersDao = new UsersDAO();
        User user = usersDao.selectById(id); // 既存のselectByIdメソッドを呼び出し

        // ユーザー名を取得
        String userName = user.getName();
        
        // 【バグ修正箇所】会員ランク情報の取得
        // 💡 User DTO内の実際のゲッター名に合わせて以下をコメントアウト解除、または書き換えてください。
        // 例1：user.getRank() / 例2：user.getRank_id() / 例3：user.getRankId() 
        // 現時点ではコンパイルエラーを防ぐため、一時的に固定値（0）を代入しています。
        int rankId = 0; 
        // int rankId = user.getRank(); // ← エラーが消える場合はこちらを使用してください
        
        String userRank = (rankId == 0) ? "Gold" : "Standard"; // ランク判定ロジック（仮）

        // 4. TODO: 注文テーブル（orders）から当月の栄養素合計値を取得する処理
        // 今後、OrdersDAOやMymenusDAOに合計値計算用のメソッドを追加する予定
        // OrdersDAO ordersDao = new OrdersDAO();
        // NutrientDTO nu = ordersDao.selectTotalNutrientsByUserId(id);
        // int protein = nu.getProtein();
        // int fiber = nu.getFiber();
        
        // 注文DAOが完成するまでのテストデータ（モックデータ）
        int protein = 45; 
        int fiber = 12;

        // 5. JSP側で表示できるように、取得したデータをrequestオブジェクトに格納
        request.setAttribute("rankData", userRank);
        request.setAttribute("nameData", userName);       // mydata.jspの ${nameData} に対応
        request.setAttribute("proteinData", protein);   // mydata.jspの ${proteinData} に対応
        request.setAttribute("fiberData", fiber);       // mydata.jspの ${fiberData} に対応

        // 6. マイデータ画面（JSP）へフォワード
        request.getRequestDispatcher("/WEB-INF/jsp/mydata.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doGet(request, response);
    }
}
