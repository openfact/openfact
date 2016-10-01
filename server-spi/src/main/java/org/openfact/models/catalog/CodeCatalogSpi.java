package org.openfact.models.catalog;

import org.openfact.provider.Provider;
import org.openfact.provider.ProviderFactory;
import org.openfact.provider.Spi;

public class CodeCatalogSpi implements Spi {

	@Override
	public boolean isInternal() {
		return false;
	}

	@Override
	public String getName() {
		return "codeCatalog";
	}

	@Override
	public Class<? extends Provider> getProviderClass() {
		return CodeCatalogProvider.class;
	}

	@Override
	public Class<? extends ProviderFactory> getProviderFactoryClass() {
		return CodeCatalogProviderFactory.class;
	}

}
