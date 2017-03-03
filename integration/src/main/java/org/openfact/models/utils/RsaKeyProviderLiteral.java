package org.openfact.models.utils;

import org.openfact.keys.qualifiers.QRsaKeyProvider;
import org.openfact.keys.qualifiers.RsaKeyType;

import javax.enterprise.util.AnnotationLiteral;

public class RsaKeyProviderLiteral extends AnnotationLiteral<QRsaKeyProvider> implements QRsaKeyProvider {

    private final RsaKeyType type;

    public RsaKeyProviderLiteral(RsaKeyType type) {
        this.type = type;
    }

    @Override
    public RsaKeyType type() {
        return type;
    }

}
