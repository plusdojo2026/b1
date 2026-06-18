package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// 診断の質問および診断結果の制御を行うServlet
@WebServlet("/AkinatorQuestionResultServlet")
public class AkinatorQuestionResultServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // 質問画面（Q.今日の気分は？）を表示する処理
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        // セッションからログインチェック（ガードロジック）
        HttpSession session = request.getSession();
        dto.LoginUser loginUser = (dto.LoginUser) session.getAttribute("loginUser");

        if (loginUser == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        // 質問画面（JSP）へフォワード
        request.getRequestDispatcher("/WEB-INF/jsp/question_akinator.jsp").forward(request, response);
    }

    // 用户点击 A.ビーフ 或 B.チキン 按钮后提交答案的逻辑
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        // ユーザーが選択した回答（A または B）を取得
        String answer = request.getParameter("answer");
        
        // TODO: ここで選択された回答をセッション等に保存し、次の質問または結果画面へ遷移
        // テストとして、一旦同じ画面にリダイレクト
        response.sendRedirect(request.getContextPath() + "/AkinatorQuestionResultServlet");
    }
}