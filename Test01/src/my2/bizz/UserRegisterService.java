package my2.bizz;

import my2.service.AfSimpleService;
import org.json.JSONObject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @BelongsProject: WebApplicationSecondary
 * @BelongsPackage: my2.bizz
 * @Author: billzhang
 * @CreateTime: 2020-10-30
 * @Description:
 */
@WebServlet(name="UserRegisterService",urlPatterns = "/UserRegister")
public class UserRegisterService extends AfSimpleService {
    @Override
    protected Object execute(HttpServletRequest request, HttpServletResponse response, JSONObject jreq) {
        return "Have Data return";
    }
}
