package org.openfact.models;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.wildfly.swarm.undertow.WARArchive;

import javax.inject.Inject;
import java.io.File;

@RunWith(Arquillian.class)
public class MyProviderIT {

    @Inject
    private MyProvider provider;

    @Deployment
    public static WARArchive createDeployment() {
        WARArchive warArchive = ShrinkWrap.create(WARArchive.class);

        File[] files = Maven.resolver()
                .loadPomFromFile("pom.xml")
                .importRuntimeDependencies()
                .resolve()
                .withoutTransitivity()
                .asFile();

        warArchive.addAsLibraries(files);
        //.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");

        return warArchive;
    }

    @Test
    public void should_start_service() {
        Assert.assertNotNull(provider);
        Assert.assertEquals(provider.hello(), "hello");
    }
}