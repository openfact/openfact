package org.openfact.services.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.openfact.models.OpenfactSessionFactory;

@WebListener
public class OpenfactSessionDestroyListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        OpenfactSessionFactory sessionFactory = (OpenfactSessionFactory) sce.getServletContext().getAttribute(OpenfactSessionFactory.class.getName());
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }

}
