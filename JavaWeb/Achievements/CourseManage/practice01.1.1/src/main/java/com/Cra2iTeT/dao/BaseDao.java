package com.Cra2iTeT.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class BaseDao {
    private static String url = null;
    private static String driver = null;
    private static String username = null;
    private static String password = null;

    //静态初始化
    static {
        Properties properties = new Properties();
        InputStream in = BaseDao.class.getClassLoader().getResourceAsStream("db.properties");

        try {
            properties.load(in);
            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
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
        Boolean flag = true;
        if (rs != null) {
            try {
                rs.close();
                rs = null;//GC回收
            } catch (SQLException e) {
                flag = false;
                e.printStackTrace();
            }
        }
        if (pstm != null) {
            try {
                pstm.close();
                pstm = null;//GC回收
            } catch (SQLException e) {
                flag = false;
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
                conn = null;//GC回收
            } catch (SQLException e) {
                flag = false;
                e.printStackTrace();
            }
        }

        return flag;
    }

    //公共查询
    public static ResultSet executeQuery(Connection conn, PreparedStatement pstm, ResultSet rs, String sql, Object[] params) {
        //conn = BaseDao.getConnection();
        System.out.println(sql);
        try {
            pstm = conn.prepareStatement(sql);

            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    pstm.setObject(i + 1, params[i]);
                    System.out.println(i + "  " +params[i]);
                }
            }

            rs = pstm.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    //公共增删改
    public static int execute(Connection conn, PreparedStatement pstm, String sql, Object[] params) {
        //conn = BaseDao.getConnection();
        int temp = 0;
        try {
            pstm = conn.prepareStatement(sql);

            System.out.println(sql);

            for (int i = 0; i < params.length; i++) {
                pstm.setObject(i + 1, params[i]);
                System.out.println(i + "  " +params[i]);
            }

            temp = pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return temp;
    }
}
