package org.openfact.models.utils;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.openfact.common.util.MultivaluedHashMap;
import org.openfact.keys.KeyProvider;
import org.openfact.models.ComponentProvider;
import org.openfact.models.ModelException;
import org.openfact.models.OrganizationModel;
import org.openfact.component.ComponentModel;

@Stateless
public class DefaultKeyProviders {

    @Inject
    private ComponentProvider componentProvider;
    
    public void createProviders(OrganizationModel organization) throws ModelException {
        ComponentModel generated = new ComponentModel();
        generated.setName("rsa-generated");
        generated.setParentId(organization.getId());
        generated.setProviderId("rsa-generated");
        generated.setProviderType(KeyProvider.class.getName());

        MultivaluedHashMap<String, String> config = new MultivaluedHashMap<>();
        config.putSingle("priority", "100");
        generated.setConfig(config);
        
        componentProvider.addComponentModel(organization, generated);
    }

    public void createProviders(OrganizationModel organization, String privateKeyPem, String certificatePem) throws ModelException {
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
        
        componentProvider.addComponentModel(organization, rsa);
    }

}
