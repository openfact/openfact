package org.openfact.testsuite.model;

import org.openfact.component.ComponentFactory;
import org.openfact.components.utils.ComponentUtil;

import javax.ejb.Stateless;

@Stateless
public class MockComponentProvider implements ComponentUtil{

    @Override
    public ComponentFactory getComponentFactory(String providerType, String providerId) {
        return null;
    }

}
