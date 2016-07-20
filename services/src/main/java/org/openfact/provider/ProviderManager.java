package org.openfact.provider;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.jboss.logging.Logger;
import org.openfact.provider.ProviderFactory;
import org.openfact.provider.ProviderLoader;
import org.openfact.provider.ProviderLoaderFactory;
import org.openfact.provider.Spi;

public class ProviderManager {

	private static final Logger logger = Logger.getLogger(FileSystemProviderLoaderFactory.class);

    private List<ProviderLoader> providerLoaders = new LinkedList<ProviderLoader>();
    private Map<String, List<ProviderFactory>> cache = new HashMap<String, List<ProviderFactory>>();

    public ProviderManager(ClassLoader baseClassLoader, String... resources) {
        ServiceLoader<ProviderLoaderFactory> serviceLoader = ServiceLoader.load(ProviderLoaderFactory.class, getClass().getClassLoader());
                
        providerLoaders.add(new DefaultProviderLoader(baseClassLoader));

        if (resources != null) {
            for (String r : resources) {
                String type = r.substring(0, r.indexOf(':'));
                String resource = r.substring(r.indexOf(':') + 1, r.length());

                Iterable<ProviderLoaderFactory> iterable = () -> serviceLoader.iterator();
                Stream<ProviderLoaderFactory> stream = StreamSupport.stream(iterable.spliterator(), false);

                ProviderLoaderFactory providerLoaderFactory = stream
                        .filter(f -> f.supports(type)).findFirst()
                        .orElseThrow(() -> new RuntimeException("Provider loader for " + r + " not found"));
                providerLoaders.add(providerLoaderFactory.create(baseClassLoader, resource));
            }
        }
    }

    public synchronized List<ProviderFactory> load(Spi spi) {
        List<ProviderFactory> factories = cache.get(spi.getName());
        if (factories == null) {
            factories = new LinkedList<ProviderFactory>();
            IdentityHashMap factoryClasses = new IdentityHashMap();
            for (ProviderLoader loader : providerLoaders) {
                List<ProviderFactory> f = loader.load(spi);
                if (f != null) {
                    for (ProviderFactory pf : f) {
                        // make sure there are no duplicates
                        if (!factoryClasses.containsKey(pf.getClass())) {
                            factories.add(pf);
                            factoryClasses.put(pf.getClass(), pf);
                        }
                    }
                }
            }
        }
        return factories;
    }

    public synchronized ProviderFactory load(Spi spi, String providerId) {
        return load(spi).stream().filter(f -> f.getId().equals(providerId)).findFirst().orElse(null);
    }

}
