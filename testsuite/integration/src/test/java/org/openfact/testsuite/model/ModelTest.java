package org.openfact.testsuite.model;

import org.junit.Assert;
import org.junit.Test;
import org.openfact.models.OpenfactModelUtils;
import org.openfact.models.OrganizationModel;
import org.openfact.models.utils.ModelToRepresentation;
import org.openfact.representations.idm.OrganizationRepresentation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class ModelTest extends AbstractModelTest {

    /*@Test
    public void importExportOrganization() {
        OrganizationModel organization = organizationManager.createOrganization("original");        
        organization.setAccessCodeLifespanUserAction(1002);
        OpenfactModelUtils.generateOrganizationKeys(organization);

        HashMap<String, String> smtp = new HashMap<String,String>();
        smtp.put("from", "auto@openfact");
        smtp.put("hostname", "localhost");
        organization.setSmtpConfig(smtp);

        organization.setEventsListeners(new HashSet<String>(Arrays.asList("jpa", "mongo", "foo")));        
        organization.setEventsEnabled(true);

        OrganizationModel persisted = organizationManager.getOrganization(organization.getId());
        assertEquals(organization, persisted);

        OrganizationModel copy = importExport(organization, "copy");
        assertEquals(organization, copy);
    }*/

    public static void assertEquals(OrganizationModel expected, OrganizationModel actual) {        
        
        //Assert.assertEquals(expected.getAccessCodeLifespanUserAction(), actual.getAccessCodeLifespanUserAction());
        //Assert.assertEquals(expected.getPublicKeyPem(), actual.getPublicKeyPem());
        //Assert.assertEquals(expected.getPrivateKeyPem(), actual.getPrivateKeyPem());        

        Assert.assertEquals(expected.getSmtpConfig(), actual.getSmtpConfig());
        
        Assert.assertEquals(expected.getEventsListeners(), actual.getEventsListeners());        
        Assert.assertEquals(expected.isEventsEnabled(), actual.isEventsEnabled());
    }

    private OrganizationModel importExport(OrganizationModel src, String copyName) {
        OrganizationRepresentation representation = ModelToRepresentation.toRepresentation(src, true);
        representation.setName(copyName);
        representation.setId(copyName);
        OrganizationModel copy = organizationManager.importOrganization(representation);
        return organizationManager.getOrganization(copy.getId());
    }

}
