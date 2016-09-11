package com.calldrink.jdbc;

import com.calldrink.entity.User;

import java.sql.*;

/**
 * Created by silvionetto on 9/11/16.
 */
public class UserCrudJDBC {
    public int create(User user) {
        int rows = 0;
        Connection con = getConnection();
        PreparedStatement pstm = null;
        String sql = "insert into entity(name, email, entered_date, updated_date, version) " +
                "values (?, ?, ?, ?, ?)";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, user.getName());
            pstm.setString(2, user.getEmail());
            pstm.setDate(3, user.getEntered_date());
            pstm.setDate(4, user.getUpdated_date());
            pstm.setInt(5, user.getVersion());
            rows = pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (pstm != null) {
                try {
                    pstm.close();
                    con.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return rows;
    }

    public User read(User user) {
        return null;
    }

    public int update(User user) {
        return 0;
    }

    public int delete(User user) {
        return 0;
    }

    public Connection getConnection() {
        Connection con = null;
        try {
            String url = "jdbc:mysql://192.168.99.100:6603/calldrink";
            String user = "root";
            String password = "calldrink";

            con = DriverManager.getConnection(url, user,password);
            System.out.println("Conectou");
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return con;
    }

    public static void main(String[] args) {
        UserCrudJDBC crudJDBC = new UserCrudJDBC();

        User user = new User();
        user.setEmail("silvio.netto@gmail.com");
        user.setEntered_date(new Date(System.currentTimeMillis()));
        user.setId(1);
        user.setName("Silvio Netto");
        user.setPassword("barradog");
        user.setUpdated_date(new Date(System.currentTimeMillis()));
        user.setVersion(0);
        crudJDBC.create(user);
    }

}
