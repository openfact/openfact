package org.openfact.connections.jpa;

import org.openfact.provider.Provider;

import javax.persistence.EntityManager;

public interface JpaConnectionProvider extends Provider {

    EntityManager getEntityManager();

}
