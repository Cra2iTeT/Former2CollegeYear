package com.Cra2iTeT;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo03 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;

        try {

            conn = JDBCUtils2.getConnection();
            st = conn.createStatement();

            JDBCUtils2.insert(st);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
