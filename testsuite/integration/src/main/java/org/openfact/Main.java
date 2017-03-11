package org.openfact;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.datasources.DatasourceArchive;
import org.wildfly.swarm.datasources.DatasourcesFraction;
import org.wildfly.swarm.spi.api.JARArchive;
import org.wildfly.swarm.undertow.WARArchive;

public class Main {

    public static void main(String[] args) throws Exception {
        Swarm swarm = new Swarm();
        swarm.start();

        // Create a JDBC driver deployment using maven groupId:artifactId
        // The version is resolved from your pom.xml's <dependency>
        swarm.deploy(Swarm.artifact("com.h2database:h2", "h2"));

        // Create a DS deployment
        JARArchive dsArchive = ShrinkWrap.create(JARArchive.class);
        dsArchive.as(DatasourceArchive.class).dataSource("ExampleDS", (ds) -> {
            ds.connectionUrl("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE");
            ds.driverName("h2");
            ds.userName("sa");
            ds.password("sa");
        });

        swarm.deploy(dsArchive);

        WARArchive appDeployment = ShrinkWrap.create(WARArchive.class).addAllDependencies();
        swarm.deploy(appDeployment);
    }
}