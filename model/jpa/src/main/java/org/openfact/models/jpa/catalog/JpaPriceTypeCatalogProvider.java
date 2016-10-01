package org.openfact.models.jpa.catalog;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.catalog.provider.ConditionCatalogProvider;
import org.openfact.models.catalog.provider.PriceTypeCatalogProvider;

public class JpaPriceTypeCatalogProvider   implements PriceTypeCatalogProvider{
	protected static final Logger logger = Logger.getLogger(JpaPriceTypeCatalogProvider.class);
	private final OpenfactSession session;
	protected EntityManager em;
	
	public JpaPriceTypeCatalogProvider(OpenfactSession session, EntityManager em) {
		this.session = session;
		this.em = em;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

}
