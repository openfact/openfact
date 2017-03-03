package org.openfact.models.utils;

import org.openfact.keys.qualifiers.QComponentProvider;

import javax.enterprise.util.AnnotationLiteral;

public class ComponentProviderLiteral extends AnnotationLiteral<QComponentProvider> implements QComponentProvider {

    private final Class<?> providerType;

    public ComponentProviderLiteral(Class<?> providerType) {
        this.providerType = providerType;
    }

    @Override
    public Class<?> providerType() {
        return providerType;
    }
}
