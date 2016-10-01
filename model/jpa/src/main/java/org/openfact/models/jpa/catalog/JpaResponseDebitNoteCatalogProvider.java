package org.openfact.models.jpa.catalog;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.catalog.provider.ConditionCatalogProvider;
import org.openfact.models.catalog.provider.ResponseDebitNoteCatalogProvider;

public class JpaResponseDebitNoteCatalogProvider  implements ResponseDebitNoteCatalogProvider {
	protected static final Logger logger = Logger.getLogger(JpaResponseDebitNoteCatalogProvider.class);
	private final OpenfactSession session;
	protected EntityManager em;
	
	public JpaResponseDebitNoteCatalogProvider(OpenfactSession session, EntityManager em) {
		this.session = session;
		this.em = em;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

}
