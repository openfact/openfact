package org.openfact.models.jpa.ubl.pe;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.AbstractHibernateStorage;
import org.openfact.models.ubl.provider.pe.VoidedDocumentsProvider;

public class JpaVoidedDocumentsProvider extends AbstractHibernateStorage implements VoidedDocumentsProvider {

	protected static final Logger logger = Logger.getLogger(JpaVoidedDocumentsProvider.class);

	private final OpenfactSession session;
	protected EntityManager em;

	public JpaVoidedDocumentsProvider(OpenfactSession session, EntityManager em) {
		this.session = session;
		this.em = em;
	}

	@Override
	public void close() {
		
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

}
