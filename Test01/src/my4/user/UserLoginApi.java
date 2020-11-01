package my4.user;

import af.web.restful.AfRestfulApi;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import my3.entity.User;
import org.json.JSONObject;

import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @BelongsProject: WebApplicationSecondary
 * @BelongsPackage: my4.user
 * @Author: billzhang
 * @CreateTime: 2020-11-01
 * @Description:
 */
public class UserLoginApi extends AfRestfulApi {
    @Override
    public Object execute(JSONObject jreq) throws Exception {
        String username = jreq.getString("username");
        String password = jreq.getString("password");

        String sql = "select * from user where `username` =?";
        User user = null;
        ResultSet rs = null;
        ComboPooledDataSource pooled = new ComboPooledDataSource();

        try{
           Connection conn = pooled.getConnection();
           PreparedStatement pstmt = conn.prepareStatement(sql);
           pstmt.setString(1,username);
           System.out.println(sql);
           rs = pstmt.executeQuery();
           if(rs.next()){
               user = new User(
                       rs.getString(2),
                       rs.getString(3),
                       rs.getBoolean(4),
                       rs.getBoolean(5),
                       rs.getBoolean(6),
                       rs.getInt(7),
                       rs.getObject(8)
               );
           }

            if(user == null)
                throw new Exception("无法找到此用户，用户名：" + username);
            else if(!user.password.equals(password))
                throw new Exception("密码不匹配");

            HttpSession session = this.httpReq.getSession();
           session.setAttribute("user",user);
        }catch (SQLException se){
            se.printStackTrace();
        }
        return null;
    }
}
