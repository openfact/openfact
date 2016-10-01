package org.openfact.models.catalog.provider;

import org.openfact.provider.Provider;
import org.openfact.provider.ProviderFactory;
import org.openfact.provider.Spi;

public class TaxTypeCatalogSpi implements Spi {

	@Override
	public boolean isInternal() {
		return false;
	}

	@Override
	public String getName() {
		return "taxTypeCatalog";
	}

	@Override
	public Class<? extends Provider> getProviderClass() {
		return TaxTypeCatalogProvider.class;
	}

	@Override
	public Class<? extends ProviderFactory> getProviderFactoryClass() {
		return TaxTypeCatalogProviderFactory.class;
	}

}
