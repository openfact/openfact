package org.openfact.models.jpa;

import org.openfact.Config;
import org.openfact.connections.jpa.JpaConnectionProvider;
import org.openfact.models.CertifiedProvider;
import org.openfact.models.CertifiedProviderFactory;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;

import javax.persistence.EntityManager;

/**
 * Created by Alex Pariona-"alexpariona@openfact.com" on 10/08/2016.
 */
public class JpaCertifiedProviderFactory implements CertifiedProviderFactory {
    @Override
    public CertifiedProvider create(OpenfactSession session) {
        EntityManager em = session.getProvider(JpaConnectionProvider.class).getEntityManager();
        return new JpaCertifiedProvider(session, em);
    }

    @Override
    public void init(Config.Scope config) {

    }

    @Override
    public void postInit(OpenfactSessionFactory factory) {

    }

    @Override
    public void close() {

    }

    @Override
    public String getId() {
        return "jpa";
    }
}