package org.openfact.components.utils;

import org.openfact.component.ComponentFactory;
import org.openfact.keys.qualifiers.RsaKeyType;

import javax.ejb.Stateless;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import java.lang.annotation.Annotation;
import java.util.Optional;

@Stateless
public class DefaultComponentUtil implements ComponentUtil {

    @Inject
    @Any
    private Instance<ComponentFactory> componentFactories;

    @Override
    public ComponentFactory getComponentFactory(String providerType, String providerId) {
        try {
            Class<?> aClass = Class.forName(providerType);

            Optional<RsaKeyType> optional = RsaKeyType.findByProviderId(providerId);
            if (!optional.isPresent()) {
                return null;
            }

            Annotation componentProviderLiteral = new ComponentProviderLiteral(aClass);
            Annotation rsaKeyProviderLiteral = new RsaKeyProviderLiteral(optional.get());

            return componentFactories.select(ComponentFactory.class, componentProviderLiteral, rsaKeyProviderLiteral).get();
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Invalid factory", e);
        }
    }

}
