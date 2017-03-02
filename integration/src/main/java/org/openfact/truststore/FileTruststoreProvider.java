/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/

package org.openfact.truststore;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;

import javax.annotation.PostConstruct;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.jboss.logging.Logger;
import org.openfact.Config;

public class FileTruststoreProvider implements TruststoreProvider {

    private static final Logger logger = Logger.getLogger(FileTruststoreProvider.class);

    private KeyStore truststore;
    
    @PostConstruct
    private void init(Config.Scope config) {
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
        
        KeyStore truststore = null;

        if (storepath == null) {
            throw new RuntimeException("Attribute 'file' missing in 'truststore':'file' configuration");
        }
        if (pass == null) {
            throw new RuntimeException("Attribute 'password' missing in 'truststore':'file' configuration");
        }

        try {
            truststore = loadStore(storepath, pass == null ? null :pass.toCharArray());
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize TruststoreProviderFactory: " + new File(storepath).getAbsolutePath(), e);
        }
        
        TruststoreProviderSingleton.set(this);
        logger.debug("File trustore provider initialized: " + new File(storepath).getAbsolutePath());
    }      
    
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
