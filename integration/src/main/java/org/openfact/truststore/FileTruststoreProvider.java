package org.openfact.truststore;

import org.jboss.logging.Logger;
import org.openfact.Config;

import javax.annotation.PostConstruct;
import javax.ejb.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;

@Startup
@Singleton(name = "FileTruststoreProvider")
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
public class FileTruststoreProvider implements TruststoreProvider {

    private static final Logger logger = Logger.getLogger(FileTruststoreProvider.class);

    private HostnameVerificationPolicy policy;
    private KeyStore truststore;

    @PostConstruct
    private void init() {
        Config.Scope config = Config.scope("truststore");
        if (config == null) {
            return;
        }

        String storepath = config.get("file");
        String pass = config.get("password");
        String policy = config.get("hostname-verification-policy");
        Boolean disabled = config.getBoolean("disabled", null);

        // if "truststore" . "file" is not configured then it is disabled
        if (storepath == null && pass == null && policy == null && disabled == null) {
            return;
        }

        // if explicitly disabled
        if (disabled != null && disabled) {
            return;
        }

        HostnameVerificationPolicy verificationPolicy = null;
        KeyStore truststore = null;

        if (storepath == null) {
            throw new RuntimeException("Attribute 'file' missing in 'truststore':'file' configuration");
        }
        if (pass == null) {
            throw new RuntimeException("Attribute 'password' missing in 'truststore':'file' configuration");
        }

        try {
            truststore = loadStore(storepath, pass == null ? null : pass.toCharArray());
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize TruststoreProviderFactory: " + new File(storepath).getAbsolutePath(), e);
        }
        if (policy == null) {
            verificationPolicy = HostnameVerificationPolicy.WILDCARD;
        } else {
            try {
                verificationPolicy = HostnameVerificationPolicy.valueOf(policy);
            } catch (Exception e) {
                throw new RuntimeException("Invalid value for 'hostname-verification-policy': " + policy + " (must be one of: ANY, WILDCARD, STRICT)");
            }
        }

        this.truststore = truststore;
        this.policy = verificationPolicy;
        logger.debug("File trustore provider initialized: " + new File(storepath).getAbsolutePath());
    }

    @Lock(LockType.READ)
    @Override
    public HostnameVerificationPolicy getPolicy() {
        return policy;
    }

    @Lock(LockType.READ)
    @Override
    public KeyStore getTruststore() {
        return truststore;
    }

    private KeyStore loadStore(String path, char[] password) throws Exception {
        KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
        InputStream is = new FileInputStream(path);
        try {
            ks.load(is, password);
            return ks;
        } finally {
            try {
                is.close();
            } catch (IOException ignored) {
            }
        }
    }

}
