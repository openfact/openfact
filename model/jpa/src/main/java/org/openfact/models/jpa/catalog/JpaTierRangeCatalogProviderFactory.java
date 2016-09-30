package org.openfact.models.jpa.catalog;

import org.openfact.Config.Scope;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;
import org.openfact.models.catalog.provider.AdditionalAccountIdCatalogProviderFactory;
import org.openfact.models.catalog.provider.TierRangeCatalogProvider;
import org.openfact.models.catalog.provider.TierRangeCatalogProviderFactory;

public class JpaTierRangeCatalogProviderFactory  implements TierRangeCatalogProviderFactory{

	@Override
	public TierRangeCatalogProvider create(OpenfactSession session) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(Scope config) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postInit(OpenfactSessionFactory factory) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

}
