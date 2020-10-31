package my3.service;

import org.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @BelongsProject: WebApplicationSecondary
 * @BelongsPackage: my3.service
 * @Author: billzhang
 * @CreateTime: 2020-10-31
 * @Description:
 */
public abstract class GenericApi {
    protected HttpServletRequest request;
    protected HttpServletResponse response;

    public abstract Object execute(JSONObject jreq)throws Exception;
}
