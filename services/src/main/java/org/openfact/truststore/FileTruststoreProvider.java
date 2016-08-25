package org.openfact.truststore;

import org.openfact.truststore.HostnameVerificationPolicy;
import org.openfact.truststore.TruststoreProvider;

import java.security.KeyStore;

public class FileTruststoreProvider implements TruststoreProvider {

    private final HostnameVerificationPolicy policy;
    private final KeyStore truststore;

    FileTruststoreProvider(KeyStore truststore, HostnameVerificationPolicy policy) {
        this.policy = policy;
        this.truststore = truststore;
    }

    @Override
    public HostnameVerificationPolicy getPolicy() {
        return policy;
    }

    @Override
    public KeyStore getTruststore() {
        return truststore;
    }

    @Override
    public void close() {
    }
}
