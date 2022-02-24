package lesson;

import com.Cra2iTeT.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo02 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;

        try {
            conn = JDBCUtils.getConnection();
            st = conn.createStatement();

            String sql = "insert into lesson(id,`teacher`,`position`)" +
                    "values(7,'Cra2iTeT','123456')";
            int i = st.executeUpdate(sql);
            if (i > 0) {
                System.out.println("插入成功");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
