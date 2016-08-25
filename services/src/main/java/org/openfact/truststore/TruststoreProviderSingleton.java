package org.openfact.truststore;

import org.openfact.truststore.TruststoreProvider;

class TruststoreProviderSingleton {

    static private TruststoreProvider provider;

    static void set(TruststoreProvider tp) {
        provider = tp;
    }

    static TruststoreProvider get() {
        return provider;
    }
}
