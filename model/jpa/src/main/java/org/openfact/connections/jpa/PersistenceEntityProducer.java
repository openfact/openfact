package org.openfact.connections.jpa;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import java.lang.reflect.Proxy;

public class PersistenceEntityProducer {

    @Produces
    public static EntityManager create(EntityManager em) {
        return (EntityManager) Proxy.newProxyInstance(EntityManager.class.getClassLoader(), new Class[]{EntityManager.class}, new PersistenceExceptionConverter(em));
    }

}
