package my3.service;

import javax.servlet.http.HttpServlet;
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



}
