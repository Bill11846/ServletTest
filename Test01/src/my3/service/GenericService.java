package my3.service;

import my3.bizz.UserRegisterApi;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
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


    private void handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String webRootPath = request.getServletPath();
        int p1 = webRootPath.lastIndexOf('/');
        int p2 = webRootPath.lastIndexOf('.');
        String apiName = webRootPath.substring(p1 + 1, p2);
        System.out.println("Obtain Service Name:" + apiName);

        GenericApi instance = null;
        if ("UserRegister".equals(apiName))
            instance = new UserRegisterApi();
        else throw new Exception("Can't find the service name :" + apiName + ", pls. check the urlpattern");

        JSONObject jresp = new JSONObject();
        try {
            String textReq = readAsText(request.getInputStream(), charset);
            JSONObject jreq = null;
            if (textReq.length() > 0) jreq = new JSONObject(textReq);
            Object data = instance.execute(jreq);
            if (data == null) throw new Exception("unable to obtain the data from return，请检查biness code in bizz pck");
            else
                jresp.put("data", data);
            jresp.put("error", 0);
            jresp.put("reason", "OK");
        } catch (Exception e) {
            jresp.put("error", -1);
            jresp.put("reason", e.getMessage());
        }

        response.setContentType("text/plain;charset=utf-8");
        response.setHeader("Connection", "Close");
        PrintWriter writer = response.getWriter();
        writer.write(jresp.toString(2));
        writer.close();
    }


    private String readAsText(ServletInputStream in, String charset) throws Exception {
        ByteArrayOutputStream cache = new ByteArrayOutputStream(1024 * 16);
        byte[] data = new byte[1024];
        int numofWait = 0;
        while (true) {
            int n = in.read(data);
            if (n < 0) break;
            if (n == 0) {
                if (numofWait++ > 3) break;
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                continue;
            }
            numofWait = 0;
            cache.write(data, 0, n);
            if (cache.size() > MAX_REQUEST_SIZE) break;
        }
        return cache.toString(charset);
    }
}
