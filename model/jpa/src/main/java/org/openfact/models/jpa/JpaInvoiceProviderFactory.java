package org.openfact.models.jpa;

import org.openfact.Config;
import org.openfact.connections.jpa.JpaConnectionProvider;
import org.openfact.models.InvoiceProvider;
import org.openfact.models.InvoiceProviderFactory;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;

import javax.persistence.EntityManager;

public class JpaInvoiceProviderFactory implements InvoiceProviderFactory {

    @Override
    public void init(Config.Scope config) {
    }

    @Override
    public void postInit(OpenfactSessionFactory factory) {

    }

    @Override
    public String getId() {
        return "jpa";
    }

    @Override
    public InvoiceProvider create(OpenfactSession session) {
        EntityManager em = session.getProvider(JpaConnectionProvider.class).getEntityManager();
        return new JpaInvoiceProvider(session, em);
    }

    @Override
    public void close() {
    }

}
