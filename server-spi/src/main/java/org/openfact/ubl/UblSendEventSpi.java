package org.openfact.ubl;

import org.openfact.provider.Provider;
import org.openfact.provider.ProviderFactory;
import org.openfact.provider.Spi;

public class UblSendEventSpi implements Spi {

	@Override
	public boolean isInternal() {
		return false;
	}

	@Override
	public String getName() {
		return "sendEvent";
	}

	@Override
	public Class<? extends Provider> getProviderClass() {		
		return UblSendEventProvider.class;
	}

	@Override
	public Class<? extends ProviderFactory> getProviderFactoryClass() {		
		return UblSendEventProviderFactory.class;
	}

}

