package org.openfact.provider;

import javax.enterprise.util.AnnotationLiteral;

public class ProviderTypeLiteral extends AnnotationLiteral<ProviderType> implements ProviderType {

    private final String value;

    public ProviderTypeLiteral(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

}
