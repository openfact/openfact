package org.openfact.services.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.openfact.models.RepeidSessionFactory;

@WebListener
public class OpenfactSessionDestroyListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        RepeidSessionFactory sessionFactory = (RepeidSessionFactory) sce.getServletContext().getAttribute(RepeidSessionFactory.class.getName());
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }

}
