package org.openfact.provider;

import java.util.LinkedList;
import java.util.List;
import java.util.ServiceLoader;

import org.openfact.provider.ProviderFactory;
import org.openfact.provider.ProviderLoader;
import org.openfact.provider.Spi;

public class DefaultProviderLoader implements ProviderLoader {

	private ClassLoader classLoader;

	public DefaultProviderLoader(ClassLoader classLoader) {
		this.classLoader = classLoader;
	}

	@Override
	public List<ProviderFactory> load(Spi spi) {
		LinkedList<ProviderFactory> list = new LinkedList<>();
		for (ProviderFactory pf : ServiceLoader.load(spi.getProviderFactoryClass(), classLoader)) {
			list.add(pf);
		}
		return list;
	}

}
