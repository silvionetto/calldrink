package com.calldrink.bo;

import com.calldrink.dao.UserDAO;
import com.calldrink.entity.User;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by silvionetto on 9/11/16.
 */
public class UserBO {

    private UserDAO userDAO;

    public UserBO(Session session) {
        userDAO = new UserDAO(session);
    }

    public void create(User entity) {
        userDAO.create(entity);
    }

    public void update(User entity) {
        userDAO.update(entity);
    }

    public User find(User entity) {
        return userDAO.findByName(entity);
    }

    public List<User> findAll() {
        return userDAO.findAll();
    }

    public boolean login(User entity) {
        User user = userDAO.findByEmail(entity);
        if (user != null) {
            return user.getPassword().equals(entity.getPassword());
        }
        return false;
     }
}
