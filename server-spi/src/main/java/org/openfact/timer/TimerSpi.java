package org.openfact.timer;

import org.openfact.provider.Provider;
import org.openfact.provider.ProviderFactory;
import org.openfact.provider.Spi;

public class TimerSpi implements Spi {

    @Override
    public boolean isInternal() {
        return true;
    }

    @Override
    public String getName() {
        return "timer";
    }

    @Override
    public Class<? extends Provider> getProviderClass() {
        return TimerProvider.class;
    }

    @Override
    public Class<? extends ProviderFactory> getProviderFactoryClass() {
        return TimerProviderFactory.class;
    }

}
