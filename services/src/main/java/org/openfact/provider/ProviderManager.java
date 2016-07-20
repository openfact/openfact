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

    private List<ProviderLoader> loaders = new LinkedList<ProviderLoader>();
    private Map<String, List<ProviderFactory>> cache = new HashMap<String, List<ProviderFactory>>();

    public ProviderManager(ClassLoader baseClassLoader, String... resources) {
        ServiceLoader<ProviderLoaderFactory> serviceLoader = ServiceLoader.load(ProviderLoaderFactory.class, getClass().getClassLoader());
                
        loaders.add(new DefaultProviderLoader(baseClassLoader));

        if (resources != null) {
            for (String r : resources) {
                String type = r.substring(0, r.indexOf(':'));
                String resource = r.substring(r.indexOf(':') + 1, r.length());

                Iterable<ProviderLoaderFactory> iterable = () -> serviceLoader.iterator();
                Stream<ProviderLoaderFactory> stream = StreamSupport.stream(iterable.spliterator(), false);

                ProviderLoaderFactory providerLoaderFactory = stream
                        .filter(f -> f.supports(type)).findFirst()
                        .orElseThrow(() -> new RuntimeException("Provider loader for " + r + " not found"));
                loaders.add(providerLoaderFactory.create(baseClassLoader, resource));
            }
        }
    }

//    public synchronized List<Spi> loadSpis() {
//        // Use a map to prevent duplicates, since the loaders may have
//        // overlapping classpaths.
//        Map<String, Spi> spiMap = new HashMap<>();
//        for (ProviderLoader loader : loaders) {            
//            List<Spi> spis = loader.loadSpis();
//            if (spis != null) {
//                for (Spi spi : spis) {
//                    spiMap.put(spi.getName(), spi);
//                }
//            }
//        }
//        return new LinkedList<>(spiMap.values());
//    }
    
    public synchronized List<ProviderFactory> load(Spi spi) {
        List<ProviderFactory> factories = cache.get(spi.getName());
        if (factories == null) {
            factories = new LinkedList<ProviderFactory>();
            IdentityHashMap factoryClasses = new IdentityHashMap();
            for (ProviderLoader loader : loaders) {
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
