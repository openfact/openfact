package org.openfact.jose.jws.crypto;

import org.openfact.jose.jws.JWSInput;

public interface SignatureProvider {
    boolean verify(JWSInput input, String key);
}
