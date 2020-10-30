package my2.service;

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
 * @BelongsPackage: ${PACKAGE_NAME}
 * @Author: billzhang
 * @CreateTime: 2020-10-30
 * @Description: ${Description}
 */
public abstract class AfSimpleService extends HttpServlet {
    protected String charset = Charset.forName("UTF-8").toString();
    protected int MAX_REQUEST_SIZE = 1024 * 512;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            handleRequest(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(500, e.getMessage());
        }
    }

    private void handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        JSONObject jresp = new JSONObject();
        try {
            String textReq = readAsText(request.getInputStream(), charset);
            JSONObject jreq = null;
            Object data = execute(request, response, jreq);
            if (textReq.length() > 0) jreq = new JSONObject(textReq);
            jresp.put("error", 0);
            jresp.put("reason", "OK");
            if (data != null)
                jresp.put("data", data);
        } catch (Exception e) {
            jresp.put("error", -1);
            jresp.put("reason", e.getMessage());
        }

        response.setContentType("text/plainl;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.write(jresp.toString(2));
        writer.close();
    }

    protected abstract Object execute(HttpServletRequest request, HttpServletResponse response, JSONObject jreq);

    private String readAsText(ServletInputStream in, String charset) throws IOException {
        ByteArrayOutputStream cache = new ByteArrayOutputStream(1024 * 16);
        byte[] data = new byte[1024];
        int numOfWait = 0;
        while (true) {
            int n = in.read(data);
            if (n < 0) break;
            if (n == 0) {
                if (numOfWait++ >= 3) break;
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                continue;
            }
            numOfWait = 0;
            cache.write(data, 0, n);
            if (cache.size() > MAX_REQUEST_SIZE) break;
        }
        return cache.toString(charset);
    }
}
