package com.calldrink.dao;

import org.hibernate.Session;

import java.util.List;

/**
 * Created by silvionetto on 9/11/16.
 */
public abstract class BaseDAO<T> {
    private final Session session;

    public BaseDAO(Session session) {
        this.session = session;
    }

    public Session getSession() {
        return session;
    }

    public void create(T entity) {
        session.save(entity);
    }

    public abstract List<T> findAll();

    public void update(T entity) {
        session.update(entity);
    }

    public void delete(T entity) {
        session.delete(entity);
        session.flush();
    }
}
