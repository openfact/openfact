package org.openfact.core.keys.component.utils;

import org.openfact.core.keys.qualifiers.RsaKeyProviderType;
import org.openfact.core.keys.qualifiers.RsaKeyType;

import javax.enterprise.util.AnnotationLiteral;

public class RsaKeyProviderLiteral extends AnnotationLiteral<RsaKeyProviderType> implements RsaKeyProviderType {

    private final RsaKeyType type;

    public RsaKeyProviderLiteral(RsaKeyType type) {
        this.type = type;
    }

    @Override
    public RsaKeyType type() {
        return type;
    }

}
