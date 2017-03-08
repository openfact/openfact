package org.openfact.truststore;

import javax.annotation.PostConstruct;
import javax.ejb.*;
import javax.inject.Inject;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

@Startup
@Singleton
@DependsOn(value = {"FileTruststoreProvider"})
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
public class JSSETruststoreConfigurator {

    @Inject
    private TruststoreProvider provider;

    private javax.net.ssl.SSLSocketFactory sslFactory;
    private TrustManager[] tm;

    @PostConstruct
    private void init() {
        if (provider.getTruststore() != null) {
            // Init tm
            TrustManagerFactory tmf = null;
            try {
                tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                tmf.init(provider.getTruststore());
                tm = tmf.getTrustManagers();
            } catch (Exception e) {
                throw new RuntimeException("Failed to initialize TrustManager: ", e);
            }

            // Init sslFactory
            try {
                SSLContext sslctx = SSLContext.getInstance("TLS");
                sslctx.init(null, tm, null);
                sslFactory = sslctx.getSocketFactory();
            } catch (Exception e) {
                throw new RuntimeException("Failed to initialize SSLContext: ", e);
            }
        }
    }

    @Lock(LockType.READ)
    public javax.net.ssl.SSLSocketFactory getSSLSocketFactory() {
        return sslFactory;
    }

    @Lock(LockType.READ)
    public TrustManager[] getTrustManagers() {
        return tm;
    }

}
