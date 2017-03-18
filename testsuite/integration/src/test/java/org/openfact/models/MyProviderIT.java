package org.openfact.models;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openfact.TicketDTO;
import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.arquillian.CreateSwarm;
import org.wildfly.swarm.datasources.DatasourcesFraction;
import org.wildfly.swarm.jaxrs.JAXRSFraction;
import org.wildfly.swarm.naming.NamingFraction;
import org.wildfly.swarm.security.SecurityFraction;
import org.wildfly.swarm.undertow.WARArchive;

import java.io.File;

@RunWith(Arquillian.class)
public class MyProviderIT {

//    @CreateSwarm(startEagerly = true)
//    public static Swarm newContainer() throws Exception {
//        Swarm swarm = new Swarm();
//
//        // Configure the Datasources subsystem with a driver and a datasource
//        swarm.fraction(new DatasourcesFraction()
//                .jdbcDriver("h2", (d) -> {
//                    d.driverClassName("org.h2.Driver");
//                    d.xaDatasourceClass("org.h2.jdbcx.JdbcDataSource");
//                    d.driverModuleName("com.h2database.h2");
//                })
//                .dataSource("ExampleDS", (ds) -> {
//                    ds.driverName("h2");
//                    ds.connectionUrl("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE");
//                    ds.userName("sa");
//                    ds.password("sa");
//                })
//        );
//
//        return swarm;
//    }

    @Deployment
    public static WARArchive createDeployment() throws Exception {
        WARArchive appDeployment = ShrinkWrap.create(WARArchive.class);

        appDeployment.addClass(TicketDTO.class)
//                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAllDependencies();
        return appDeployment;
    }

    @Test
    public void should_start_service() {
        Assert.assertNotNull("");
    }

}