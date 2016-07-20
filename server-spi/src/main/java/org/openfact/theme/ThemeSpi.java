package org.openfact.theme;

import org.openfact.provider.Provider;
import org.openfact.provider.ProviderFactory;
import org.openfact.provider.Spi;

public class ThemeSpi implements Spi {

	@Override
	public boolean isInternal() {
		return true;
	}

	@Override
	public String getName() {
		return "theme";
	}

	@Override
	public Class<? extends Provider> getProviderClass() {
		return ThemeProvider.class;
	}

	@Override
	public Class<? extends ProviderFactory> getProviderFactoryClass() {
		return ThemeProviderFactory.class;
	}
}
