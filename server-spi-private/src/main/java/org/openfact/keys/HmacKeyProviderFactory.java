package org.openfact.keys;

import org.openfact.jose.jws.AlgorithmType;

import java.util.Collections;
import java.util.Map;

public interface HmacKeyProviderFactory extends KeyProviderFactory {

    @Override
    default Map<String, Object> getTypeMetadata() {
        return Collections.singletonMap("algorithmType", AlgorithmType.HMAC);
    }

}
