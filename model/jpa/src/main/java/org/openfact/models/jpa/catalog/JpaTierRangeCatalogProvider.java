package org.openfact.models.jpa.catalog;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.catalog.provider.TierRangeCatalogProvider;

public class JpaTierRangeCatalogProvider   implements TierRangeCatalogProvider{
	protected static final Logger logger = Logger.getLogger(JpaTierRangeCatalogProvider.class);
	private final OpenfactSession session;
	protected EntityManager em;
	
	public JpaTierRangeCatalogProvider(OpenfactSession session, EntityManager em) {
		this.session = session;
		this.em = em;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

}
