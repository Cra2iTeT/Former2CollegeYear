package com.Cra2iTeT;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class JDBCUtils2 {
    public static String url = "jdbc:mysql://localhost:3306/jdbcstudy?&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true&useSSL=true";
    public static String user = "root";
    public static String driver = "com.mysql.cj.jdbc.Driver";
    public static String password = "123456";

    /*static {
        try {
            InputStream in = JDBCUtils2.class.getClassLoader().getResourceAsStream("db.properties");
            Properties properties = new Properties();
            properties.load(in);

            driver = properties.getProperty("driver");
            //System.out.println(driver);
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            url = properties.getProperty("url");

            Class.forName(driver);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    public static Connection getConnection() throws SQLException {
        //System.out.println(user);
        return DriverManager.getConnection(url, user, password);
    }

    public static void release(Connection conn, Statement st, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void insert(Statement st) {
        try {
            String name = null;
            String password = null;
            String email = null;
            String birthday = null;

            Scanner sc = new Scanner(System.in);


            System.out.print("??????????????????");
            name = sc.nextLine();
            System.out.print("??????????????????");
            password = sc.nextLine();
            System.out.print("??????????????????");
            email = sc.nextLine();
            System.out.print("??????????????????");
            birthday = sc.nextLine();

            String sql = "insert into `users`(`name`,`password`,`email`,`birthday`)" +
                    "values('" + name + "','" + password + "','" + email + "','" + birthday + "')";

            int i = st.executeUpdate(sql);

            if(i>0){
                System.out.println("????????????");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}