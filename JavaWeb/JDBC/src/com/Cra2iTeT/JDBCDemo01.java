package com.Cra2iTeT;

import java.sql.*;

public class JDBCDemo01 {
    public static void main(String[] args) {
        //加载驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //用户信息和url
        String url = "jdbc:mysql://localhost:3306/jdbcstudy?useUnicod=true&characterEncoding=utf8&useSSL=true";
        String userName = "root";
        String password = "123456";

        //连接成功，数据库对象
        try {
            Connection connection = DriverManager.getConnection(url, userName, password);

            //执行SQL的对象
            Statement statement = connection.createStatement();

            //执行SQL的对象执行SQL
            String sql = "select * from users";

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                System.out.print("id="+resultSet.getObject("id"));
                System.out.print("\tname="+resultSet.getObject("name"));
                System.out.print("\tpassword="+resultSet.getObject("password"));
                System.out.print("\temail="+resultSet.getObject("email"));
                System.out.println("\tbirth="+resultSet.getObject("birthday"));
            }

            //释放连接
            resultSet.close();;
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}