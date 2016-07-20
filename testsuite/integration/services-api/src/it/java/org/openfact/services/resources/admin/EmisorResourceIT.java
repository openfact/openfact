package org.openfact.services.resources.admin;

import java.util.List;

import javax.inject.Inject;

import org.hamcrest.CoreMatchers;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openfact.models.EmisorModel;
import org.openfact.models.EmisorProvider;
import org.openfact.representations.idm.EmisorRepresentation;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(Arquillian.class)
public class EmisorResourceIT {

    @Inject
    private EmisorProvider emisores;

    @Deployment
    public static Archive createDeployment() {
        JavaArchive archive = ShrinkWrap.create(JavaArchive.class);

        archive.addPackages(true, "org.openfact");

        archive.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
        archive.addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml");
        archive.addAsResource("META-INF/openfact-server.json", "META-INF/openfact-server.json");

        return archive;
    }

    @Before
    public void before() {
        removeAllEmisores();
    }

    @After
    public void after() {
        removeAllEmisores();
    }

    public void removeAllEmisores() {
        List<EmisorModel> models = emisores.getAll();
        for (EmisorModel model : models) {
            emisores.remove(model);
        }
    }

    @Test
    public void create() {
        EmisorModel model = emisores.create("PE", "10467793549", "Sistcoop S.A.C.");

        Assert.assertThat(model, CoreMatchers.notNullValue());
        Assert.assertThat(model.getId(), CoreMatchers.notNullValue());
        Assert.assertThat(model.getPais(), CoreMatchers.equalTo("PE"));
        Assert.assertThat(model.getRuc(), CoreMatchers.equalTo("10467793549"));
        Assert.assertThat(model.getRazonSocial(), CoreMatchers.equalTo("Sistcoop S.A.C."));
        Assert.assertThat(model.getEstado(), CoreMatchers.is(true));
    }
    
    /*@Test
    @RunAsClient
    public void getAll() {
        EmisorRepresentation rep = new EmisorRepresentation();
        rep.setPais("PE");
        rep.setRuc("10467793459");
        rep.setRazonSocial("Sistcoop S.A.C.");

        given().contentType("application/json").body(rep).when().post("/admin/emisores").then()
                .statusCode(201);
    }*/

}
