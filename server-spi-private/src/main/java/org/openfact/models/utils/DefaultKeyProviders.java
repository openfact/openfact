package org.openfact.models.utils;

import org.openfact.common.util.MultivaluedHashMap;
import org.openfact.keys.KeyProvider;
import org.openfact.models.OrganizationModel;
import org.openfact.models.component.ComponentModel;

public class DefaultKeyProviders {

    public static void createProviders(OrganizationModel organization) {
        ComponentModel generated = new ComponentModel();
        generated.setName("rsa-generated");
        generated.setParentId(organization.getId());
        generated.setProviderId("rsa-generated");
        generated.setProviderType(KeyProvider.class.getName());

        MultivaluedHashMap<String, String> config = new MultivaluedHashMap<>();
        config.putSingle("priority", "100");
        generated.setConfig(config);

        organization.addComponentModel(generated);
    }

    public static void createProviders(OrganizationModel organization, String privateKeyPem, String certificatePem) {
        ComponentModel rsa = new ComponentModel();
        rsa.setName("rsa");
        rsa.setParentId(organization.getId());
        rsa.setProviderId("rsa");
        rsa.setProviderType(KeyProvider.class.getName());

        MultivaluedHashMap<String, String> config = new MultivaluedHashMap<>();
        config.putSingle("priority", "100");
        config.putSingle("privateKey", privateKeyPem);
        if (certificatePem != null) {
            config.putSingle("certificate", certificatePem);
        }
        rsa.setConfig(config);

        organization.addComponentModel(rsa);
    }

}
