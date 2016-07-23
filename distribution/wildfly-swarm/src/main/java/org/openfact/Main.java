package org.openfact;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.ClassLoaderAsset;
import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.undertow.WARArchive;

public class Main {

    public static void main(String[] args) throws Exception {
        Swarm container = new Swarm(args);

        WARArchive deployment = ShrinkWrap.create(WARArchive.class);

        deployment.addAsManifestResource(new ClassLoaderAsset("META-INF/openfact-server.json", Main.class.getClassLoader()), "openfact-server.json");
        deployment.addAsWebInfResource(new ClassLoaderAsset("META-INF/web.xml", Main.class.getClassLoader()), "web.xml");

        deployment.addAllDependencies();

        container.start();
        container.deploy(deployment);
    }
}