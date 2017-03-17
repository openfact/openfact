package org.openfact.services.managers;

import org.jboss.logging.Logger;
import org.openfact.ServerStartupTask;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;

@Startup
@Singleton
public class ServerStartup {

    protected static final Logger logger = Logger.getLogger(ServerStartup.class);

    @Context
    private ServletContext context;

    @Inject
    private ApplianceBootstrap applianceBootstrap;

    @Inject
    private ServerStartupTask serverStartupTask;

    private long serverStartupTimestamp;

    @PostConstruct
    private void init() {
        serverStartupTimestamp = System.currentTimeMillis();

        applianceBootstrap.bootstrap();
        serverStartupTask.execute();
    }

    public long getServerStartupTimestamp() {
        return serverStartupTimestamp;
    }

}
