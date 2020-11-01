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
 * @BelongsPackage: ${PACKAGE_NAME}
 * @Author: billzhang
 * @CreateTime: 2020-11-01
 * @Description: ${Description}
 */
@WebServlet(name = "Example2",urlPatterns = "/example2")
public class Example2 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("username","billzhang");
        String id = session.getId();
        System.out.println(id);



        response.getWriter().write(id);
    }
}
