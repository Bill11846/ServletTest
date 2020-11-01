package my4.bizz;

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
 * @BelongsPackage: my4.bizz
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

        ComboPooledDataSource pooled = new ComboPooledDataSource();
        try(Connection conn = pooled.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,username);
            ResultSet rs = pstmt.executeQuery();
           if(rs.next()){
             String username2 = rs.getString("username");
             String password2 = rs.getString("password");
             boolean canRead = rs.getBoolean("canRead");
             boolean canPost = rs.getBoolean("canPost");
             boolean canReply = rs.getBoolean("canReply");
             int level = rs.getInt("level");
             Object timeCreated = rs.getObject("timeCreated");

             user = new User(username2,password2,canRead,canPost,canReply,level,timeCreated);


               if(user == null)
                   throw new Exception("Can't retrieve the user:"+ username);
               else if(! user.password.equals(password))
                   throw new Exception("密码不匹配");

           }
        }catch (SQLException se){
            se.printStackTrace();
        }


        HttpSession session =this.httpReq.getSession();
        session.setAttribute("user",user);

        System.out.println("Username:" + user.username + ", password:" + user.password + ",level:" + user.level);
        return null;
    }
}
