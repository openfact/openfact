package org.openfact.truststore;

import org.openfact.provider.Provider;

import java.security.KeyStore;

public interface TruststoreProvider extends Provider {

    HostnameVerificationPolicy getPolicy();

    KeyStore getTruststore();
}
