package org.openfact.authentication;

import java.util.Map;

import org.openfact.provider.ProviderFactory;

public interface ClientAuthenticatorProviderFactory extends ProviderFactory<ClientAuthenticatorProvider> {

    Map<String, Object> getAdapterConfiguration();

}
