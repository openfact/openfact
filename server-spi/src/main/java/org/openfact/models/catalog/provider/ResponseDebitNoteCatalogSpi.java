package org.openfact.models.catalog.provider;

import org.openfact.provider.Provider;
import org.openfact.provider.ProviderFactory;
import org.openfact.provider.Spi;

public class ResponseDebitNoteCatalogSpi implements Spi {

	@Override
	public boolean isInternal() {
		return false;
	}

	@Override
	public String getName() {
		return "responseDebitNoteCatalog";
	}

	@Override
	public Class<? extends Provider> getProviderClass() {
		return ResponseDebitNoteCatalogProvider.class;
	}

	@Override
	public Class<? extends ProviderFactory> getProviderFactoryClass() {
		return ResponseDebitNoteCatalogProviderFactory.class;
	}

}
