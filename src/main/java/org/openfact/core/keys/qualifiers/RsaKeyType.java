package org.openfact.core.keys.qualifiers;

import org.openfact.core.keys.GeneratedRsaKeyProviderFactory;
import org.openfact.core.keys.ImportedRsaKeyProviderFactory;
import org.openfact.core.keys.JavaKeystoreKeyProviderFactory;

import java.util.Optional;
import java.util.stream.Stream;

public enum RsaKeyType {

    /**
     * rsa-generated
     */
    GENERATED(GeneratedRsaKeyProviderFactory.ID),

    /**
     * java-keystore
     */
    JAVA_KEYSTORE(JavaKeystoreKeyProviderFactory.ID),

    /**
     * rsa
     */
    IMPORTED(ImportedRsaKeyProviderFactory.ID);

    private final String providerId;

    RsaKeyType(String providerId) {
        this.providerId = providerId;
    }

    public String getProviderId() {
        return providerId;
    }

    public static Optional<RsaKeyType> findByProviderId(String providerId) {
        return Stream.of(RsaKeyType.values())
                .filter(p -> p.getProviderId().equals(providerId))
                .findFirst();
    }
}
