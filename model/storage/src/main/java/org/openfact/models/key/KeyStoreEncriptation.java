package org.openfact.models.key;

import java.io.*;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;


/**
 * Created by Alex Pariona-"alexpariona@openfact.com" on 09/08/2016.
 */
public class KeyStoreEncriptation {

    private static final String KEY_INSTANCE = "JSK";

    /**
     * Method used to get the generated Private Key
     *
     * @return PrivateKey
     */
    public PrivateKey getPrivateKey(String pathJSK, String signatureIdJSK, String passwordJSK)
            throws KeyStoreException, IOException, CertificateException, NoSuchAlgorithmException, UnrecoverableEntryException {
        KeyStore keystore = KeyStore.getInstance(KEY_INSTANCE);
        keystore.load(new FileInputStream(pathJSK), passwordJSK.toCharArray());
        KeyStore.PrivateKeyEntry keyEntry = (KeyStore.PrivateKeyEntry) keystore.getEntry(signatureIdJSK, new KeyStore.PasswordProtection(passwordJSK.toCharArray()));

        PrivateKey privateKey = keyEntry.getPrivateKey();
        return privateKey;
    }

    /**
     * Method used to get the generated Public Key
     *
     * @return PublicKey
     */
    public PublicKey getPublicKey(String pathJSK, String signatureIdJSK, String passwordJSK)
            throws KeyStoreException, IOException, CertificateException, NoSuchAlgorithmException, UnrecoverableEntryException {
        KeyStore keystore = KeyStore.getInstance(KEY_INSTANCE);
        keystore.load(new FileInputStream(pathJSK), passwordJSK.toCharArray());
        KeyStore.PrivateKeyEntry keyEntry = (KeyStore.PrivateKeyEntry) keystore.getEntry(signatureIdJSK, new KeyStore.PasswordProtection(passwordJSK.toCharArray()));

        X509Certificate cert;
        cert = (X509Certificate) keyEntry.getCertificate();
        PublicKey publicKey = cert.getPublicKey();
        return publicKey;
    }

    /**
     * Method used to get the generated Key Pairs
     *
     * @return KeyPair
     */
    public KeyPair getKeyPair(String pathJSK, String signatureIdJSK, String passwordJSK)
            throws KeyStoreException, IOException, CertificateException, NoSuchAlgorithmException, UnrecoverableEntryException {
        KeyStore keystore = KeyStore.getInstance(KEY_INSTANCE);
        keystore.load(new FileInputStream(pathJSK), passwordJSK.toCharArray());
        KeyStore.PrivateKeyEntry keyEntry = (KeyStore.PrivateKeyEntry) keystore.getEntry(signatureIdJSK, new KeyStore.PasswordProtection(passwordJSK.toCharArray()));
        PrivateKey privateKey = keyEntry.getPrivateKey();
        X509Certificate cert = (X509Certificate) keyEntry.getCertificate();
        PublicKey publicKey = cert.getPublicKey();

        return new KeyPair(publicKey, privateKey);
    }

    /**
     * Method used to get the generated Certificate
     *
     * @return X509Certificate
     */
    public X509Certificate getX509Certificate(String pathJSK, String signatureIdJSK, String passwordJSK)
            throws KeyStoreException, IOException, CertificateException, NoSuchAlgorithmException, UnrecoverableEntryException {
        KeyStore keystore = KeyStore.getInstance(KEY_INSTANCE);
        keystore.load(new FileInputStream(pathJSK), passwordJSK.toCharArray());
        KeyStore.PrivateKeyEntry keyEntry = (KeyStore.PrivateKeyEntry) keystore.getEntry(signatureIdJSK, new KeyStore.PasswordProtection(passwordJSK.toCharArray()));
        X509Certificate cert = (X509Certificate) keyEntry.getCertificate();

        return cert;
    }
}
