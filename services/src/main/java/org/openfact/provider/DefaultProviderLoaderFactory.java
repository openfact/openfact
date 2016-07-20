package org.openfact.provider;

import org.openfact.provider.ProviderLoader;
import org.openfact.provider.ProviderLoaderFactory;

public class DefaultProviderLoaderFactory implements ProviderLoaderFactory {

	@Override
	public boolean supports(String type) {
		return false;
	}

	@Override
	public ProviderLoader create(ClassLoader baseClassLoader, String resource) {
		return new DefaultProviderLoader(baseClassLoader);
	}

}
