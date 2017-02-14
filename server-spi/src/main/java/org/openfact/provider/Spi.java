package org.openfact.provider;

public interface Spi {

    boolean isInternal();

    String getName();

    Class<? extends Provider> getProviderClass();

    Class<? extends ProviderFactory> getProviderFactoryClass();
}
