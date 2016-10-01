package org.openfact.models.jpa.catalog;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.catalog.provider.AdditionalAccountIdCatalogProvider;
import org.openfact.models.jpa.ubl.JpaCreditNoteProvider;

public class JpaAdditionalAccountIdCatalogProvider implements AdditionalAccountIdCatalogProvider {
	
	protected static final Logger logger = Logger.getLogger(JpaAdditionalAccountIdCatalogProvider.class);
	private final OpenfactSession session;
	protected EntityManager em;
	

	public JpaAdditionalAccountIdCatalogProvider(OpenfactSession session, EntityManager em) {		
		this.session = session;
		this.em = em;
	}



	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

}
