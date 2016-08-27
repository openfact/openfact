package org.openfact.provider;

import java.util.LinkedList;
import java.util.List;
import java.util.ServiceLoader;

import org.openfact.provider.ProviderFactory;
import org.openfact.provider.ProviderLoader;
import org.openfact.provider.Spi;

/**
 * @author carlosthe19916@gmail.com
 * @version 1.0.0.Final
 */
public class DefaultProviderLoader implements ProviderLoader {

    private ClassLoader classLoader;

    public DefaultProviderLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public List<Spi> loadSpis() {
        LinkedList<Spi> list = new LinkedList<>();
        for (Spi spi : ServiceLoader.load(Spi.class, classLoader)) {
            list.add(spi);
        }
        return list;
    }

    @Override
    public List<ProviderFactory> load(Spi spi) {
        LinkedList<ProviderFactory> list = new LinkedList<ProviderFactory>();
        for (ProviderFactory f : ServiceLoader.load(spi.getProviderFactoryClass(), classLoader)) {
            list.add(f);
        }
        return list;
    }

}
