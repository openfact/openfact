package org.openfact.models.jpa;

import org.hibernate.Session;

import javax.persistence.EntityManager;

public interface HibernateProvider {

    EntityManager getEntityManager();

    default Session getSession() {
        return getEntityManager().unwrap(Session.class);
    }

}
