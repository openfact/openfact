package org.openfact.models.jpa.catalog;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.catalog.provider.ResponseCreditNoteCatalogProvider;

public class JpaResponseCreditNoteCatalogProvider   implements ResponseCreditNoteCatalogProvider{
	protected static final Logger logger = Logger.getLogger(JpaResponseCreditNoteCatalogProvider.class);
	private final OpenfactSession session;
	protected EntityManager em;
	
	public JpaResponseCreditNoteCatalogProvider(OpenfactSession session, EntityManager em) {
		this.session = session;
		this.em = em;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

}
