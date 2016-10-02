package com.calldrink.dao;

import com.calldrink.entity.User;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by silvionetto on 9/11/16.
 */
public class UserDAO extends BaseDAO<User> {

    public UserDAO(Session session) {
        super(session);
    }

    @Override
    public List<User> findAll() {
        Query query = getSession().createQuery("from User");
        return query.list();
    }

    public User findByName(User user) {
        Query query = getSession().createQuery("from User where name = :name");
        query.setString("name", user.getName());
        return  (User) query.uniqueResult();
    }

    public User findByEmail(User user) {
        Query query = getSession().createQuery("from User where email = :email");
        query.setString("email", user.getEmail());
        return  (User) query.uniqueResult();
    }
}
