package org.openfact.connections.jpa;

import org.openfact.models.OpenfactSession;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class JndiEntityManagerLookup {
    public static EntityManager getSessionEntityManager(OpenfactSession session, String entityManagerFactoryJndiName) {
        EntityManagerFactory factory = null;
        try {
            factory = (EntityManagerFactory) new InitialContext().lookup(entityManagerFactoryJndiName);
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
        EntityManager em = factory.createEntityManager();
        session.getTransactionManager().enlist(new JpaOpenfactTransaction(em));
        return em;
    }
}
