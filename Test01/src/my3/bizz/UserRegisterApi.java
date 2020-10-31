package my3.bizz;

import my3.service.GenericApi;
import org.json.JSONObject;

/**
 * @BelongsProject: WebApplicationSecondary
 * @BelongsPackage: my3.bizz
 * @Author: billzhang
 * @CreateTime: 2020-10-31
 * @Description:
 */
public class UserRegisterApi extends GenericApi {
    @Override
    public Object execute(JSONObject jreq) throws Exception {
        return "data already insert into DataBase";
    }

}
