package org.openfact.models.jpa;

import org.openfact.Config;
import org.openfact.connections.jpa.JpaConnectionProvider;
import org.openfact.models.OrganizationProvider;
import org.openfact.models.OrganizationProviderFactory;
import org.openfact.models.RepeidSession;
import org.openfact.models.RepeidSessionFactory;

import javax.persistence.EntityManager;

public class JpaOrganizationProviderFactory implements OrganizationProviderFactory {

    @Override
    public void init(Config.Scope config) {
    }

    @Override
    public void postInit(RepeidSessionFactory factory) {

    }

    @Override
    public String getId() {
        return "jpa";
    }

    @Override
    public OrganizationProvider create(RepeidSession session) {
        EntityManager em = session.getProvider(JpaConnectionProvider.class).getEntityManager();
        return new JpaOrganizationProvider(session, em);
    }

    @Override
    public void close() {
    }

}
