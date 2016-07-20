package org.openfact.connections.jpa;

import javax.persistence.EntityManager;

public class DefaultJpaConnectionProvider implements JpaConnectionProvider {

    private final EntityManager em;

    public DefaultJpaConnectionProvider(EntityManager em) {
        this.em = em;
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public void close() {
        em.close();
    }

}
