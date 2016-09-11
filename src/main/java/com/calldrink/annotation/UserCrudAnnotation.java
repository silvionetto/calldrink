package com.calldrink.annotation;

import com.calldrink.entity.User;
import com.calldrink.infra.HIbernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Calendar;

/**
 * Created by silvionetto on 9/11/16.
 */
public class UserCrudAnnotation {

    private final Session session;

    public UserCrudAnnotation(Session session) {
        this.session = session;
    }

    public void create(User user) {
        session.save(user);
    }

    public User read(User user) {
        return null;
    }

    public void update(User user) {
        session.update(user);
    }

    public void delete(User user) {
        session.delete(user);
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
        Session session = HIbernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        UserCrudAnnotation crudAnnotation = new UserCrudAnnotation(session);

        User user = new User();
        user.setEmail("silvio.netto@gmail.com");
        user.setEntered_date(Calendar.getInstance());
        user.setName("Silvio Netto");
        user.setPassword("senha");
        user.setUpdated_date(Calendar.getInstance());
        user.setVersion(0);
        crudAnnotation.create(user);

        User user2 = new User();
        user2.setEmail("deboracouttinho@gmail.com");
        user2.setEntered_date(Calendar.getInstance());
        user2.setName("Debora Coutinho");
        user2.setPassword("senha");
        user2.setUpdated_date(Calendar.getInstance());
        user2.setVersion(0);

        crudAnnotation.create(user2);
        transaction.commit();
    }
}
