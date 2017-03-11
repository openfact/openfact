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

        // Configure the Datasources subsystem with a driver
        // and a datasource
        swarm.fraction(new DatasourcesFraction()
                .jdbcDriver("h2", (d) -> {
                    d.driverClassName("org.h2.Driver");
                    d.xaDatasourceClass("org.h2.jdbcx.JdbcDataSource");
                    d.driverModuleName("com.h2database.h2");
                })
                .dataSource("ExampleDS", (ds) -> {
                    ds.driverName("h2");
                    ds.connectionUrl("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE");
                    ds.userName("sa");
                    ds.password("sa");
                })
        );

        swarm.start();

        WARArchive appDeployment = ShrinkWrap.create(WARArchive.class);
        appDeployment.addAllDependencies();

        // Deploy your app
        swarm.deploy(appDeployment);
    }
}