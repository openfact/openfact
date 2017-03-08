package org.openfact;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.openfact.models.MyProvider;
import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.datasources.DatasourcesFraction;
import org.wildfly.swarm.jaxrs.JAXRSArchive;
import org.wildfly.swarm.undertow.WARArchive;

public class Main {

    public static void main(String... args) throws Exception {
        // Instantiate the container
        Swarm swarm = new Swarm().fraction(new DatasourcesFraction()
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
                }));

        // Create one or more deployments
        //WARArchive deployment = ShrinkWrap.create(WARArchive.class);


        // Add resource to deployment
        //deployment.addClass(MyProvider.class);

        swarm.start();
        swarm.deploy(/*deployment*/);
    }
}
