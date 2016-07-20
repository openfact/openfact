package org.openfact.models.cache;

import org.openfact.provider.Provider;
import org.openfact.provider.ProviderFactory;
import org.openfact.provider.Spi;

public class CacheOrganizationProviderSpi implements Spi {

	@Override
	public boolean isInternal() {
		return true;
	}

	@Override
	public String getName() {
		return "organizationCache";
	}

	@Override
	public Class<? extends Provider> getProviderClass() {
		return CacheOrganizationProvider.class;
	}

	@Override
	public Class<? extends ProviderFactory> getProviderFactoryClass() {
		return CacheOrganizationProviderFactory.class;
	}
}
