package org.openfact.core.files;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.wildfly.swarm.jaxrs.JAXRSArchive;

import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import java.io.File;
import java.net.URL;

@RunWith(Arquillian.class)
public class FileProviderTest {

    @Inject
    @Any
    private Instance<FileProvider> fileProviders;

    @Deployment
    public static Archive createDeployment() throws Exception {
        URL url = Thread.currentThread().getContextClassLoader().getResource("project-test-defaults-path.yml");
        Assert.assertNotNull(url);
        File projectDefaults = new File(url.toURI());
        JAXRSArchive deployment = ShrinkWrap.create(JAXRSArchive.class, "openfact.war");
        deployment.addPackages(true, FileProvider.class.getPackage());
        deployment.setContextRoot("rest");
        deployment.addAsResource(projectDefaults, "/project-defaults.yml");
        deployment.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
        deployment.addAsResource("persistence-test.xml", "META-INF/persistence.xml");
        deployment.addAllDependencies();
        return deployment;
    }

    @Test
    public void createFile() throws FileException {
        int providersCount = 0;
        for (FileProvider fileProvider : fileProviders) {
            providersCount++;

            FileModel file = fileProvider.addFile("openfact-file-test.xml", new byte[]{0, 1, 2, 3});
            Assert.assertNotNull(file);
            Assert.assertNotNull(file.getBytes());
            Assert.assertNotNull(file.getFileName());
        }
        Assert.assertEquals(providersCount, 3);
    }
}