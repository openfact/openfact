package org.openfact.provider;

import java.util.List;

public interface ProviderLoader {

    List<ProviderFactory> load(Spi spi);

}
