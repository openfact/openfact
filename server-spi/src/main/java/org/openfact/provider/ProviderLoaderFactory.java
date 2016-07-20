package org.openfact.provider;

public interface ProviderLoaderFactory {

    /**
     * @param type can have classpath, directory, adapter values
     * @return true or false depending of the type support
     */
    boolean supports(String type);

    /**
     * @return ProviderLoader from resource
     */
    ProviderLoader create(ClassLoader baseClassLoader, String resource);

}
