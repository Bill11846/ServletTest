package my3.db;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @BelongsProject: WebApplicationSecondary
 * @BelongsPackage: my3.db
 * @Author: billzhang
 * @CreateTime: 2020-10-30
 * @Description:
 */
public class TestDB {
    public static void main(String[] args)throws SQLException {
        ComboPooledDataSource pooled = new ComboPooledDataSource();
        Connection conn = pooled.getConnection();
        System.out.println("Test Successful");
        conn.close();
    }
}
