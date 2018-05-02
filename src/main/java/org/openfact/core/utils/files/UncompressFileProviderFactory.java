package org.openfact.core.utils.files;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.ServiceLoader;

public class UncompressFileProviderFactory {

    private static volatile UncompressFileProviderFactory instance;
    private static volatile Map<String, UncompressFileProvider> providers;

    private UncompressFileProviderFactory() {
        providers = new HashMap<>();
        for (UncompressFileProvider e : ServiceLoader.load(UncompressFileProvider.class)) {
            providers.put(e.getSupportedExtension(), e);
        }
    }

    public static UncompressFileProviderFactory getInstance() {
        if (instance == null) {
            synchronized (UncompressFileProvider.class) {
                if (instance == null) {
                    instance = new UncompressFileProviderFactory();
                }
            }
        }
        return instance;
    }

    public Optional<UncompressFileProvider> getProvider(String fileExtension) {
        return Optional.ofNullable(providers.get(fileExtension));
    }

}
