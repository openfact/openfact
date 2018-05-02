package org.openfact.core.keys.component.utils;

import org.openfact.core.keys.qualifiers.ComponentProviderType;

import javax.enterprise.util.AnnotationLiteral;

public class ComponentProviderLiteral extends AnnotationLiteral<ComponentProviderType> implements ComponentProviderType {

    private final Class<?> providerType;

    public ComponentProviderLiteral(Class<?> providerType) {
        this.providerType = providerType;
    }

    @Override
    public Class<?> providerType() {
        return providerType;
    }
}
