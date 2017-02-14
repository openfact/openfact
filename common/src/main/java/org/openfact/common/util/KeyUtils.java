package org.openfact.common.util;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.spec.RSAPublicKeySpec;

public class KeyUtils {

    private static final String DEFAULT_MESSAGE_DIGEST = "SHA-256";

    private KeyUtils() {
    }

    public static SecretKey loadSecretKey(String secret) {
        return new SecretKeySpec(secret.getBytes(), "HmacSHA256");
    }

    public static KeyPair generateRsaKeyPair(int keysize) {
        try {
            KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
            generator.initialize(keysize);
            KeyPair keyPair = generator.generateKeyPair();
            return keyPair;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static PublicKey extractPublicKey(PrivateKey key) {
        if (key == null) {
            return null;
        }

        try {
            RSAPrivateCrtKey rsaPrivateCrtKey = (RSAPrivateCrtKey) key;
            RSAPublicKeySpec publicKeySpec = new RSAPublicKeySpec(rsaPrivateCrtKey.getModulus(), rsaPrivateCrtKey.getPublicExponent());
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            return keyFactory.generatePublic(publicKeySpec);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String createKeyId(Key key) {
        try {
            return Base64Url.encode(MessageDigest.getInstance(DEFAULT_MESSAGE_DIGEST).digest(key.getEncoded()));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

}
