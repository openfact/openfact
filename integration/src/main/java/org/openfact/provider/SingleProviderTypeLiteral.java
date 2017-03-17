package org.openfact.provider;

import javax.enterprise.util.AnnotationLiteral;

public class SingleProviderTypeLiteral extends AnnotationLiteral<SingleProviderType> implements SingleProviderType {

    private final String provider;
    private final String value;

    public SingleProviderTypeLiteral(String provider, String value) {
        this.provider = provider;
        this.value = value;
    }

    @Override
    public String provider() {
        return provider;
    }

    @Override
    public String value() {
        return value;
    }

}
