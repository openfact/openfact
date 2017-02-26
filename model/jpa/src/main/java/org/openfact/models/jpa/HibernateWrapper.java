package org.openfact.models.jpa;

import org.hibernate.Session;

import javax.persistence.EntityManager;


public interface HibernateWrapper {

    EntityManager getEntityManager();

    default Session getSession() {
        return getEntityManager().unwrap(Session.class);
    }

}
