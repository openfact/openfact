package org.openfact.models.jpa.catalog;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.catalog.provider.ConditionCatalogProvider;
import org.openfact.models.catalog.provider.TaxExemptionReasonCatalogProvider;

public class JpaTaxExemptionReasonCatalogProvider   implements TaxExemptionReasonCatalogProvider{
	protected static final Logger logger = Logger.getLogger(JpaTaxExemptionReasonCatalogProvider.class);
	private final OpenfactSession session;
	protected EntityManager em;
	
	public JpaTaxExemptionReasonCatalogProvider(OpenfactSession session, EntityManager em) {
		super();
		this.session = session;
		this.em = em;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

}
