/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates
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
 */

package org.openfact.models.utils;

import java.security.Key;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.UUID;

import javax.crypto.spec.SecretKeySpec;
import javax.transaction.InvalidTransactionException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;

import org.openfact.common.util.Base64Url;
import org.openfact.common.util.CertificateUtils;
import org.openfact.common.util.KeyUtils;
import org.openfact.common.util.PemUtils;
import org.openfact.component.ComponentFactory;
import org.openfact.component.ComponentModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;
import org.openfact.models.OpenfactSessionTask;
import org.openfact.models.OpenfactTransaction;
import org.openfact.models.OrganizationModel;
import org.openfact.provider.Provider;
import org.openfact.provider.ProviderFactory;
import org.openfact.representations.idm.CertificateRepresentation;
import org.openfact.transaction.JtaTransactionManagerLookup;

/**
 * Set of helper methods, which are useful in various model implementations.
 *
 * @author <a href="mailto:mposolda@redhat.com">Marek Posolda</a>
 */
public final class OpenfactModelUtils {

    private OpenfactModelUtils() {
    }

    public static String generateId() {
        return UUID.randomUUID().toString();
    }

    public static String generateSecret() {
        return generateSecret(32);
    }

    public static String generateSecret(int bytes) {
        byte[] buf = new byte[bytes];
        new SecureRandom().nextBytes(buf);
        return Base64Url.encode(buf);
    }

    public static PublicKey getPublicKey(String publicKeyPem) {
        if (publicKeyPem != null) {
            try {
                return PemUtils.decodePublicKey(publicKeyPem);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            return null;
        }
    }

    public static X509Certificate getCertificate(String cert) {
        if (cert != null) {
            try {
                return PemUtils.decodeCertificate(cert);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            return null;
        }
    }


    public static PrivateKey getPrivateKey(String privateKeyPem) {
        if (privateKeyPem != null) {
            try {
                return PemUtils.decodePrivateKey(privateKeyPem);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    public static Key getSecretKey(String secret) {
        return secret != null ? new SecretKeySpec(secret.getBytes(), "HmacSHA256") : null;
    }

    public static String getPemFromKey(Key key) {
        return PemUtils.encodeKey(key);
    }

    public static String getPemFromCertificate(X509Certificate certificate) {
        return PemUtils.encodeCertificate(certificate);
    }

    public static CertificateRepresentation generateKeyPairCertificate(String subject) {
        KeyPair keyPair = KeyUtils.generateRsaKeyPair(2048);
        X509Certificate certificate = CertificateUtils.generateV1SelfSignedCertificate(keyPair, subject);

        String privateKeyPem = PemUtils.encodeKey(keyPair.getPrivate());
        String certPem = PemUtils.encodeCertificate(certificate);

        CertificateRepresentation rep = new CertificateRepresentation();
        rep.setPrivateKey(privateKeyPem);
        rep.setCertificate(certPem);
        return rep;
    }

    public static String getDefaultClientAuthenticatorType() {
        return "client-secret";
    }

    public static String generateCodeSecret() {
        return UUID.randomUUID().toString();
    }    

    /**
     * Wrap given runnable job into OpenfactTransaction.
     *
     * @param factory
     * @param task
     */
    public static void runJobInTransaction(OpenfactSessionFactory factory, OpenfactSessionTask task) {
        OpenfactSession session = factory.create();
        OpenfactTransaction tx = session.getTransactionManager();
        try {
            tx.begin();
            task.run(session);

            if (tx.isActive()) {
                if (tx.getRollbackOnly()) {
                    tx.rollback();
                } else {
                    tx.commit();
                }
            }
        } catch (RuntimeException re) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw re;
        } finally {
            session.close();
        }
    }


    public static String getMasterOrganizationAdminApplicationClientId(String organizationName) {
        return organizationName + "-organization";
    }       

    // END USER FEDERATION RELATED STUFF

    public static String toLowerCaseSafe(String str) {
        return str==null ? null : str.toLowerCase();
    }            

    public static void suspendJtaTransaction(OpenfactSessionFactory factory, Runnable runnable) {
        JtaTransactionManagerLookup lookup = (JtaTransactionManagerLookup)factory.getProviderFactory(JtaTransactionManagerLookup.class);
        Transaction suspended = null;
        try {
            if (lookup != null) {
                if (lookup.getTransactionManager() != null) {
                    try {
                        suspended = lookup.getTransactionManager().suspend();
                    } catch (SystemException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            runnable.run();
        } finally {
            if (suspended != null) {
                try {
                    lookup.getTransactionManager().resume(suspended);
                } catch (InvalidTransactionException e) {
                    throw new RuntimeException(e);
                } catch (SystemException e) {
                    throw new RuntimeException(e);
                }
            }

        }

    }    


    public static void notifyCreated(OpenfactSession session, OrganizationModel organization, ComponentModel model) {
        Class<? extends Provider> providerClass = null;
        try {
            providerClass = (Class<? extends Provider>)Class.forName(model.getProviderType());
        } catch (ClassNotFoundException e) {
            return;
        }
        ProviderFactory factory = session.getOpenfactSessionFactory().getProviderFactory(providerClass, model.getProviderId());
        if (factory instanceof ComponentFactory && factory != null) {
            ((ComponentFactory)factory).onCreate(session, organization, model);
        }
    }
}
