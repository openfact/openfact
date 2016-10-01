package org.openfact.models.jpa.catalog;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.catalog.provider.AdditionalAccountIdCatalogProvider;
import org.openfact.models.catalog.provider.ConditionCatalogProvider;

public class JpaConditionCatalogProvider  implements ConditionCatalogProvider {
	protected static final Logger logger = Logger.getLogger(JpaConditionCatalogProvider.class);
	private final OpenfactSession session;
	protected EntityManager em;
	
	public JpaConditionCatalogProvider(OpenfactSession session, EntityManager em) {		
		this.session = session;
		this.em = em;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

}
