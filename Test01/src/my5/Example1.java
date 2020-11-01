package my5;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @BelongsProject: WebApplicationSecondary
 * @BelongsPackage: my5
 * @Author: billzhang
 * @CreateTime: 2020-11-01
 * @Description:
 */
@WebServlet(name="Example1",urlPatterns = "/example1")
public class Example1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String sessionId = session.getId();
        String username = (String) session.getAttribute("username");
        System.out.println(sessionId + "," + username);

        resp.getWriter().write(sessionId);
    }
}
