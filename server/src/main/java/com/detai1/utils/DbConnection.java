/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.detai1.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author X507U-PC
 */
public class DbConnection {

    public static Connection conn;

    public static boolean Open() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String sql = "jdbc:sqlserver://KHANHQUI\\SQLEXPRESS:1433;databaseName=detai1;user=mylogin;password=mylogin";
            conn = DriverManager.getConnection(sql);
            System.out.println("connected");
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }

    public static boolean Close() {
        try {
            conn.close();
            System.out.println("disconnected");
            return true;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }
}
