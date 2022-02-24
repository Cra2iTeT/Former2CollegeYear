package dao;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

public class BaseDao {
    private static String url = null;
    private static String driver = null;
    private static String username = null;
    private static String password = null;

    //初始化
    static {
        Properties properties = new Properties();
        InputStream is = BaseDao.class.getClassLoader().getResourceAsStream("db.properties");

        try {
            properties.load(is);
            url = properties.getProperty("url");
            driver = properties.getProperty("driver");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //建立连接
    public static Connection getConnection() {
        Connection conn = null;

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

    //释放连接
    public static boolean removeConnection(Connection conn, PreparedStatement pstm, ResultSet rs) {
        boolean flag = true;

        if (rs != null) {
            try {
                rs.close();
                rs = null;
            } catch (SQLException e) {
                flag = false;
                e.printStackTrace();
            }
        }
        if (pstm != null) {
            try {
                pstm.close();
                pstm = null;
            } catch (SQLException e) {
                flag = false;
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
                conn = null;
            } catch (SQLException e) {
                flag = false;
                e.printStackTrace();
            }
        }

        return flag;
    }

    //增加
    public static int execute(Connection conn, PreparedStatement pstm, String sql, Object[] params) {
        int temp = 0;

        try {
            pstm = conn.prepareStatement(sql);

            for (int i = 0; i < params.length; i++) {
                pstm.setObject(i + 1, params[i]);
            }

            temp = pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return temp;
    }

}
