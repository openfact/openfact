package org.openfact.ubl;

import org.openfact.provider.Provider;
import org.openfact.provider.ProviderFactory;
import org.openfact.provider.Spi;

public class UblExtensionContentGeneratorSpi implements Spi {

	@Override
	public boolean isInternal() {
		return true;
	}

	@Override
	public String getName() {
		return "ublExtensionsGenerator";
	}

	@Override
	public Class<? extends Provider> getProviderClass() {
		return UblExtensionContentGeneratorProvider.class;
	}

	@Override
	public Class<? extends ProviderFactory> getProviderFactoryClass() {
		return UblExtensionContentGeneratorProviderFactory.class;
	}

}
