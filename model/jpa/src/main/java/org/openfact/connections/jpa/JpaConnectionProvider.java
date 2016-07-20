package org.openfact.connections.jpa;

import javax.persistence.EntityManager;

import org.openfact.provider.Provider;

public interface JpaConnectionProvider extends Provider {

    EntityManager getEntityManager();

}
