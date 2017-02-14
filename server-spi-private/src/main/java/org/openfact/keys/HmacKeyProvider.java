package org.openfact.keys;

import org.openfact.jose.jws.AlgorithmType;

import javax.crypto.SecretKey;

public interface HmacKeyProvider extends KeyProvider<HmacKeyMetadata> {

    default AlgorithmType getType() {
        return AlgorithmType.HMAC;
    }

    /**
     * Return the active secret key, or <code>null</code> if no active key is available.
     *
     * @return
     */
    SecretKey getSecretKey();

    /**
     * Return the secret key for the specified kid, or <code>null</code> if the kid is unknown.
     *
     * @param kid
     * @return
     */
    SecretKey getSecretKey(String kid);

}
