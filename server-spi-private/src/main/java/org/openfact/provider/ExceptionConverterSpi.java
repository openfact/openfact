package org.openfact.provider;

public class ExceptionConverterSpi implements Spi {

    @Override
    public boolean isInternal() {
        return true;
    }

    @Override
    public String getName() {
        return "exception-converter";
    }

    @Override
    public Class<? extends Provider> getProviderClass() {
        return ExceptionConverter.class;
    }

    @Override
    public Class<? extends ProviderFactory> getProviderFactoryClass() {
        return ExceptionConverter.class;
    }

}
