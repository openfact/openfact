package org.openfact.models.jpa.catalog;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.catalog.provider.ConditionCatalogProvider;
import org.openfact.models.catalog.provider.RegistrationAddressCatalogProvider;

public class JpaRegistrationAddressCatalogProvider  implements RegistrationAddressCatalogProvider {
	protected static final Logger logger = Logger.getLogger(JpaRegistrationAddressCatalogProvider.class);
	private final OpenfactSession session;
	protected EntityManager em;
	
	public JpaRegistrationAddressCatalogProvider(OpenfactSession session, EntityManager em) {
		this.session = session;
		this.em = em;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

}
