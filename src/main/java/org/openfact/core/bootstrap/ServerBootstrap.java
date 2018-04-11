package org.openfact.core.bootstrap;

import org.jboss.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Startup
@Singleton
public class ServerBootstrap {

    private static final Logger logger = Logger.getLogger(ServerBootstrap.class);

    @Inject
    private ApplianceBootstrap applianceBootstrap;

    private long serverStartupTimestamp;

    @PostConstruct
    private void init() {
        logger.info("Server Bootstrap...");
        serverStartupTimestamp = System.currentTimeMillis();
        applianceBootstrap.bootstrap();
    }

    public long getServerStartupTimestamp() {
        return serverStartupTimestamp;
    }

}
