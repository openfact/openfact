package org.openfact.models.catalog.provider;

import org.openfact.provider.Provider;
import org.openfact.provider.ProviderFactory;
import org.openfact.provider.Spi;

public class InvoiceTypeCatalogSpi implements Spi {

	@Override
	public boolean isInternal() {
		return false;
	}

	@Override
	public String getName() {
		return "invoiceTypeCatalog";
	}

	@Override
	public Class<? extends Provider> getProviderClass() {
		return InvoiceTypeCatalogProvider.class;
	}

	@Override
	public Class<? extends ProviderFactory> getProviderFactoryClass() {
		return InvoiceTypeCatalogProviderFactory.class;
	}

}
