package org.openfact.models.jpa.ubl;

import javax.persistence.EntityManager;

import org.openfact.Config.Scope;
import org.openfact.connections.jpa.JpaConnectionProvider;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;
import org.openfact.ubl.UblSendEventProvider;
import org.openfact.ubl.UblSendEventProviderFactory;

public class JpaCreditNoteSendEventProviderFactory implements UblSendEventProviderFactory{

	@Override
	public UblSendEventProvider create(OpenfactSession session) {
		EntityManager em = session.getProvider(JpaConnectionProvider.class).getEntityManager();
		return new JpaCreditNoteSendEventProvider(session, em);
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
		return "creditnote";
	}

}
