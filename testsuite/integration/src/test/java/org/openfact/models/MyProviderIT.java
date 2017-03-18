package org.openfact.models;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.wildfly.swarm.undertow.WARArchive;

import javax.inject.Inject;

@RunWith(Arquillian.class)
public class MyProviderIT {

    @Inject
    OrganizationProvider organizationProvider;

    @Deployment
    public static WARArchive createDeployment() throws Exception {
        WARArchive appDeployment = ShrinkWrap.create(WARArchive.class);

        appDeployment.addPackage("org.openfact")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAllDependencies();
        return appDeployment;
    }

    @Test
    public void should_start_service() {
        OrganizationModel organization = organizationProvider.createOrganization("openfact");
        Assert.assertNotNull(organization);
    }

}