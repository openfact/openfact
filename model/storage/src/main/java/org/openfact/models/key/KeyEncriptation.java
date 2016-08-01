package org.openfact.models.key;

import java.io.*;
import java.security.*;
import java.security.KeyStore.PrivateKeyEntry;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * Created by Alex Pariona-"alexpariona@openfact.com" on 27/07/2016.
 */
public class KeyEncriptation {
    private static final String ALGORITHM = "RSA";
    private static final String KEY_INSTANCE = "JSK";
    private PrivateKeyEntry keyEntry;
    private X509Certificate cert;
    private static final int INITIALIZE = 1024;


    /**
     * This method is used to generate key pair based upon the provided
     * algorithm
     *
     * @return KeyPair
     */
    private KeyPair generateKeyPairs() {
        KeyPair keyPair = null;
        KeyPairGenerator keyGen;
        try {
            keyGen = KeyPairGenerator.getInstance(ALGORITHM);
            keyGen.initialize(INITIALIZE);
            keyPair = keyGen.genKeyPair();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return keyPair;
    }

    /**
     * Method used to store Private and Public Keys inside a directory
     *
     * @param dirPath to store the keys
     */
    public void storeKeyPairs(String dirPath, String namePublicKey, String namePrivateKey) {
        KeyPair keyPair = generateKeyPairs();
        PrivateKey _privateKey = keyPair.getPrivate();
        PublicKey _publicKey = keyPair.getPublic();
        storeKeys(dirPath + File.separator + namePublicKey, _publicKey);
        storeKeys(dirPath + File.separator + namePrivateKey, _privateKey);
    }

    /**
     * Method used to store the key(Public/Private)
     *
     * @param filePath , name of the file
     * @param key
     */
    private void storeKeys(String filePath, Key key) {
        byte[] keyBytes = key.getEncoded();
        OutputStream outStream = null;
        try {
            outStream = new FileOutputStream(filePath);
            outStream.write(keyBytes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (outStream != null) {
                try {
                    outStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Method used to retrieve the keys in the form byte array
     *
     * @param filePath of the key
     * @return byte array
     */
    private byte[] getKeyData(String filePath) {
        File file = new File(filePath);
        byte[] buffer = new byte[(int) file.length()];
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            fis.read(buffer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return buffer;
    }

    /**
     * Method used to get the generated Private Key
     *
     * @param filePath of the PrivateKey file
     * @return PrivateKey
     */
    public PrivateKey getStoredPrivateKey(String filePath) {
        PrivateKey privateKey = null;
        byte[] keydata = getKeyData(filePath);
        PKCS8EncodedKeySpec encodedPrivateKey = new PKCS8EncodedKeySpec(keydata);
        KeyFactory keyFactory = null;
        try {
            keyFactory = KeyFactory.getInstance(ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        try {
            privateKey = keyFactory.generatePrivate(encodedPrivateKey);
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return privateKey;
    }

    /**
     * Method used to get the generated Public Key
     *
     * @param filePath of the PublicKey file
     * @return PublicKey
     */
    public PublicKey getStoredPublicKey(String filePath) {
        PublicKey publicKey = null;
        byte[] keydata = getKeyData(filePath);
        KeyFactory keyFactory = null;
        try {
            keyFactory = KeyFactory.getInstance(ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        X509EncodedKeySpec encodedPublicKey = new X509EncodedKeySpec(keydata);
        try {
            publicKey = keyFactory.generatePublic(encodedPublicKey);
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return publicKey;
    }

    public PrivateKeyEntry getLlave(String locationJSK, String nameJSK, String passwordJSK, String signatureIdJSK) throws KeyStoreException, IOException, NoSuchAlgorithmException,
            CertificateException, UnrecoverableEntryException {
        KeyStore ks = KeyStore.getInstance(KEY_INSTANCE);
        ks.load(new FileInputStream(locationJSK + nameJSK), passwordJSK.toCharArray());
        keyEntry = (KeyStore.PrivateKeyEntry) ks.getEntry(signatureIdJSK, new KeyStore.PasswordProtection(passwordJSK.toCharArray()));
        cert = (X509Certificate) keyEntry.getCertificate();
        return keyEntry;
    }


}
