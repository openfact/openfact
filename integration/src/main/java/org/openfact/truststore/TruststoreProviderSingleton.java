package org.openfact.truststore;

class TruststoreProviderSingleton {

    static private TruststoreProvider provider;

    static void set(TruststoreProvider tp) {
        provider = tp;
    }

    static TruststoreProvider get() {
        return provider;
    }
}
