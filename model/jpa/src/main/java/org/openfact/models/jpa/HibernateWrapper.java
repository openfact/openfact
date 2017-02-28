package org.openfact.models.jpa;

import javax.persistence.EntityManager;

import org.hibernate.Session;


public interface HibernateWrapper {

    EntityManager getEntityManager();

    default Session getSession() {
        return getEntityManager().unwrap(Session.class);
    }

}
