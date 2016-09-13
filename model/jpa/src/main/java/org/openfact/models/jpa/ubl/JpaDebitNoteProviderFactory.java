package org.openfact.models.jpa.ubl;

import org.openfact.Config;
import org.openfact.connections.jpa.JpaConnectionProvider;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;
import org.openfact.models.ubl.provider.DebitNoteProvider;
import org.openfact.models.ubl.provider.DebitNoteProviderFactory;

import javax.persistence.EntityManager;

public class JpaDebitNoteProviderFactory implements DebitNoteProviderFactory {

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
    public DebitNoteProvider create(OpenfactSession session) {
        EntityManager em = session.getProvider(JpaConnectionProvider.class).getEntityManager();
        return new JpaDebitNoteProvider(session, em);
    }

    @Override
    public void close() {
    }

}
