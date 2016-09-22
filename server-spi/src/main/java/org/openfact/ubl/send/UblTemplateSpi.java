package org.openfact.ubl.send;

import org.openfact.provider.Provider;
import org.openfact.provider.ProviderFactory;
import org.openfact.provider.Spi;

public class UblTemplateSpi implements Spi {

	@Override
	public boolean isInternal() {
		return false;
	}

	@Override
	public String getName() {
		return "ublTemplate";
	}

	@Override
	public Class<? extends Provider> getProviderClass() {
		return UblTemplateProvider.class;
	}

	@Override
	public Class<? extends ProviderFactory> getProviderFactoryClass() {
		return UblSenderProviderFactory.class;
	}

}
