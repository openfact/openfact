package org.openfact.models.jpa.catalog;

import javax.persistence.EntityManager;

import org.openfact.Config.Scope;
import org.openfact.connections.jpa.JpaConnectionProvider;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;
import org.openfact.models.catalog.provider.PriceTypeCatalogProvider;
import org.openfact.models.catalog.provider.PriceTypeCatalogProviderFactory;

public class JpaPriceTypeCatalogProviderFactory implements PriceTypeCatalogProviderFactory {

	@Override
	public PriceTypeCatalogProvider create(OpenfactSession session) {
		  EntityManager em = session.getProvider(JpaConnectionProvider.class).getEntityManager();
	        return new JpaPriceTypeCatalogProvider(session, em);
	}

	@Override
	public void init(Scope config) {
	 
		
	}

	@Override
	public void postInit(OpenfactSessionFactory factory) {
	 
		
	}

	@Override
	public void close() {
		 
		
	}

	@Override
	public String getId() {
		 return "jpa";
	}

}
