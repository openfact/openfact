package org.openfact.models.jpa.ubl.pe;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.AbstractHibernateStorage;
import org.openfact.models.ubl.provider.pe.SummaryDocumentsProvider;

public class JpaSummaryDocumentsProvider extends AbstractHibernateStorage implements SummaryDocumentsProvider {

	protected static final Logger logger = Logger.getLogger(JpaSummaryDocumentsProvider.class);

	private final OpenfactSession session;
	protected EntityManager em;

	public JpaSummaryDocumentsProvider(OpenfactSession session, EntityManager em) {
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
