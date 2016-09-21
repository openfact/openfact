package org.openfact.models.jpa.ubl;

import javax.persistence.EntityManager;

import org.openfact.Config;
import org.openfact.connections.jpa.JpaConnectionProvider;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;
import org.openfact.models.ubl.provider.CreditNoteProvider;
import org.openfact.models.ubl.provider.CreditNoteProviderFactory;

public class JpaCreditNoteProviderFactory implements CreditNoteProviderFactory {

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
    public CreditNoteProvider create(OpenfactSession session) {
        EntityManager em = session.getProvider(JpaConnectionProvider.class).getEntityManager();
        return new JpaCreditNoteProvider(session, em);
    }

    @Override
    public void close() {
    }

}
