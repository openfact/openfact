package org.openfact.services.resources;

import javax.annotation.PostConstruct;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.jboss.logging.Logger;

@Singleton
@Startup
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
public class OpenfactSession {

    protected static final Logger logger = Logger.getLogger(OpenfactSession.class);

    private long serverStartupTimestamp;

    @PostConstruct
    private void init() {
        this.serverStartupTimestamp = System.currentTimeMillis();
    }

    public long getServerStartupTimestamp() {
        return serverStartupTimestamp;
    }

}
