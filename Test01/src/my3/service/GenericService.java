package my3.service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @BelongsProject: WebApplicationSecondary
 * @BelongsPackage: my3.service
 * @Author: billzhang
 * @CreateTime: 2020-10-31
 * @Description:
 */
public class GenericService extends HttpServlet {
    protected int MAX_REQUEST_SIZE = 1024 * 512;
    protected String charset = Charset.forName("UTF-8").toString();
    protected boolean enableErrorLog = false;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            handleRequest(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(500, e.getMessage());
        }
    }


    private void handleRequest(HttpServletRequest request,HttpServletResponse response)throws Exception{
        String webRootPath = request.getServletPath();
        int p1 = webRootPath.lastIndexOf('/');
        int p2 = webRootPath.lastIndexOf('.');
        String apiName = webRootPath.substring(p1+1,p2);
        System.out.println("Obtain Service Name:" + apiName);


    }

}
