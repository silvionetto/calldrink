package com.calldrink.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by silvionetto on 9/11/16.
 */
public class MySQLConnect {

    public static void main(String[] args) {
        Connection con = null;
        try {
            String url = "jdbc:mysql://192.168.99.100:6603/calldrink";
            String user = "root";
            String password = "calldrink";

            con = DriverManager.getConnection(url, user,password);
            System.out.println("Conectou");
            con.close();
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
