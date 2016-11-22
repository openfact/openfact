package org.openfact.ubl;

import org.openfact.provider.Provider;
import org.openfact.provider.ProviderFactory;
import org.openfact.provider.Spi;

public class UblSenderResponseSpi implements Spi {

	@Override
	public boolean isInternal() {
		return true;
	}

	@Override
	public String getName() {
		return "ulbSenderResponse";
	}

	@Override
	public Class<? extends Provider> getProviderClass() {
		return UblSenderResponseProvider.class;
	}

	@Override
	public Class<? extends ProviderFactory> getProviderFactoryClass() {
		return UblSenderResponseProviderFactory.class;
	}

}