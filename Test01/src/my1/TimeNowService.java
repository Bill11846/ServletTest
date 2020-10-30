package my1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @BelongsProject: WebApplicationSecondary
 * @BelongsPackage: ${PACKAGE_NAME}
 * @Author: billzhang
 * @CreateTime: 2020-10-30
 * @Description: ${Description}
 */
@WebServlet(name = "TimeNowService",urlPatterns = "/TimeNow")
public class TimeNowService extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String text = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());

        response.setContentType("text/plain;charset=utf-8");
        response.setHeader("Connection","Close");
        PrintWriter writer = response.getWriter();
        writer.write("当前时间" + text);
        writer.close();
    }
}
