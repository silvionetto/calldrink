package com.calldrink.test;

import com.calldrink.infra.HibernateUtil;
import org.hibernate.Session;
import org.junit.Before;

/**
 * Created by silvionetto on 9/11/16.
 */
public abstract class BaseTest {

    private Session session;

    @Before
    public void setup() {
        getSession();
    }

    public Session getSession() {
        if (session == null) {
            session = HibernateUtil.getSessionFactory().openSession();
            System.out.println("Connected");
        }

        return session;
    }
}
