package my4.bizz;

import af.web.restful.AfRestfulApi;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.json.JSONObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @BelongsProject: WebApplicationSecondary
 * @BelongsPackage: my4.bizz
 * @Author: billzhang
 * @CreateTime: 2020-10-31
 * @Description:
 */
public class UserRegisterApi extends AfRestfulApi {
    @Override
    public Object execute(JSONObject jreq) throws Exception {
        String username = jreq.getString("username");
        String password = jreq.getString("password");

        String sql = "insert into user (username,password,canRead,canPost,canReply,level,timeCreated)"
                + "values(?,?,?,?,?,?,?)";

        ComboPooledDataSource pooled = new ComboPooledDataSource();
        try (Connection conn = pooled.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setBoolean(3, true);
            pstmt.setBoolean(4, true);
            pstmt.setBoolean(5, true);
            pstmt.setInt(6, 0);
            pstmt.setObject(7, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(
                    LocalDateTime.now()));

            pstmt.executeUpdate();
        }
        return "successed to insert the " + username + "," + password + "to the User DataBase form";
    }
}
