package com.calldrink.filter;

import com.calldrink.infra.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by silvionetto on 10/2/16.
 */
@WebFilter(urlPatterns = {"*.xhtml"})
public class HibernateConnectionFilter implements Filter {

    private SessionFactory sf;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        sf = HibernateUtil.getSessionFactory();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Session currentSession = sf.getCurrentSession();

        Transaction transaction = null;

        try {
            transaction = currentSession.beginTransaction();
            filterChain.doFilter(servletRequest, servletResponse);
            transaction.commit();
            if (currentSession.isOpen()) {
                currentSession.close();
            }
        } catch (Throwable e) {
            try {
                if (transaction.isActive()) {
                    transaction.rollback();
                }
            } catch (Throwable e1) {
                e1.printStackTrace();
            }
            throw new ServletException(e);
        }
    }

    @Override
    public void destroy() {

    }
}
