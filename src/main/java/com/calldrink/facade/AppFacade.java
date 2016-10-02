package com.calldrink.facade;

import com.calldrink.bo.UserBO;
import com.calldrink.entity.User;
import com.calldrink.infra.HibernateUtil;
import org.hibernate.Session;

/**
 * Created by silvionetto on 10/2/16.
 */
public class AppFacade {

    public final Session session;

    private AppFacade(Session session) {
        this.session = session;
    }

    public static AppFacade getSessionFacade() {
        return new AppFacade(HibernateUtil.getSessionFactory().getCurrentSession());
    }

    public User saveUser(User user) {
        UserBO userBO = new UserBO(session);
        userBO.create(user);
        return userBO.find(user);
    }

    public boolean login(User user) {
        UserBO userBO = new UserBO(session);
        return userBO.login(user);
    }
}
