package org.openfact;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.ClassLoaderAsset;
import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.datasources.DatasourcesFraction;
import org.wildfly.swarm.undertow.WARArchive;

public class Main {

    public final static String WEB_XML = "web.xml";
    public final static String SERVER_CONFIG = "openfact-server.json";

    public static void main(String[] args) throws Exception {
        Swarm swarm = new Swarm();
        swarm.fraction(new DatasourcesFraction().dataSource("OpenfactDS", (ds) -> {
            ds.driverName("h2");
            ds.connectionUrl("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE");
            ds.userName("sa");
            ds.password("sa");
        }));

        ClassLoader cl = Main.class.getClassLoader();

        WARArchive deployment = ShrinkWrap.create(WARArchive.class);
        deployment.addAsWebInfResource(new ClassLoaderAsset(WEB_XML, cl), WEB_XML);
        deployment.addAsManifestResource(new ClassLoaderAsset(SERVER_CONFIG, cl), SERVER_CONFIG);
        deployment.addAllDependencies();

        swarm.start();
        swarm.deploy(deployment);
    }
}