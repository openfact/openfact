package org.openfact.models.catalog.provider;

import org.openfact.provider.Provider;
import org.openfact.provider.ProviderFactory;
import org.openfact.provider.Spi;

public class AdditionalAccountIdCatalogSpi implements Spi {

	@Override
	public boolean isInternal() {
		return false;
	}

	@Override
	public String getName() {
		return "additionalAccountIdCatalog";
	}

	@Override
	public Class<? extends Provider> getProviderClass() {
		return AdditionalAccountIdCatalogProvider.class;
	}

	@Override
	public Class<? extends ProviderFactory> getProviderFactoryClass() {
		return AdditionalAccountIdCatalogProviderFactory.class;
	}

}
