package org.openfact.provider;

import java.util.List;

public interface ConfiguredProvider {
    String getHelpText();

    List<ProviderConfigProperty> getConfigProperties();
}
