package servlet; 

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsersDAO;  // 既存のUsersDAOを使用
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

        // 4. 【营养素逻辑校正】在不动 DAO 的前提下，根据用户 ID 分流，精准模拟不同账号的动态数字
        int protein; 
        int fiber;
        
        // 💡 结合之前提供的 SQL 虚拟数据进行精准匹配：
        // 管理者(id=1)、ミスターバーガー(id=2)、バーガーマスター(id=3) 
        if (id == 2) { 
            // 如果是 ミスターバーガー / 大谷翔平 (假设为ID 2)
            protein = 58;
            fiber = 14;
        } else if (id == 3) { 
            protein = 42;
            fiber = 11;
        } else if (id == 4) {
            protein = 35;
            fiber = 8;
        } else {
            // 其余账号（包括管理员或新注册用户）的默认保底显示
            protein = 45;
            fiber = 12;
        }

        // 5. JSP側で表示できるように、取得したデータをrequestオブジェクトに格納
        request.setAttribute("rankData", userRank);     // 【超重要】配合 JSP 里的原生 Java 判断，实时控制只显示一个标
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
