package org.openfact.models.jpa.ubl.pe;

import javax.persistence.EntityManager;

import org.openfact.Config.Scope;
import org.openfact.connections.jpa.JpaConnectionProvider;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;
import org.openfact.models.ubl.provider.pe.VoidedDocumentsProvider;
import org.openfact.models.ubl.provider.pe.VoidedDocumentsProviderFactory;

public class JpaVoidedDocumentsProviderFactory implements VoidedDocumentsProviderFactory {

	@Override
	public VoidedDocumentsProvider create(OpenfactSession session) {
		EntityManager em = session.getProvider(JpaConnectionProvider.class).getEntityManager();
		return new JpaVoidedDocumentsProvider(session, em);
	}

	@Override
	public void init(Scope config) {
		
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
