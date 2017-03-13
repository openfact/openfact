package org.openfact.services.managers.task;

import org.jboss.logging.Logger;
import org.openfact.ServerStartupTask;

import javax.ejb.Stateless;

@Stateless
public class DefaultServerStartupTask implements ServerStartupTask {

    protected static final Logger logger = Logger.getLogger(DefaultServerStartupTask.class);

    @Override
    public void execute() {
        logger.info("Production default task executed");
    }

}
