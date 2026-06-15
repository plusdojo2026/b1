package servlet; 

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mydata") 
public class MydataServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // 1. 设置编码
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        // 2. 模拟从数据库中查询到的数据
        String userRank = "Gold";
        String userName = "ミスターバーガー";
        int protein = 45;
        int fiber = 12;

        // 3. 把数据存储到 request 对象中
        request.setAttribute("rankData", userRank);
        request.setAttribute("nameData", userName);
        request.setAttribute("proteinData", protein);
        request.setAttribute("fiberData", fiber);

        // 4. 【已修复】加上了 /WEB-INF/jsp/ 前缀，这样 Tomcat 才能精准找到你的文件
        request.getRequestDispatcher("/WEB-INF/jsp/mydata.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doGet(request, response);
    }
}
