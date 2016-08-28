package org.openfact.testsuite.util.cli;

import java.util.List;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactModelUtils;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;
import org.openfact.models.OpenfactSessionTask;

public abstract class AbstractCommand {

    protected final Logger log = Logger.getLogger(this.getClass().getName());

    protected List<String> args;
    protected OpenfactSessionFactory sessionFactory;

    public void injectProperties(List<String> args, TestsuiteCLI cli, OpenfactSessionFactory sessionFactory) {
        this.args = args;
        this.sessionFactory = sessionFactory;
    }

    public void runCommand() {
        try {
            OpenfactModelUtils.runJobInTransaction(sessionFactory, new OpenfactSessionTask() {

                @Override
                public void run(OpenfactSession session) {
                    doRunCommand(session);
                }

            });
        } catch (HandledException handled) {
            // Fine to ignore. Was handled already
        } catch (RuntimeException e) {
            log.error("Error occured during command. ", e);
        }
    }

    public abstract String getName();
    protected abstract void doRunCommand(OpenfactSession session);

    protected String getArg(int index) {
        try {
            return args.get(index);
        } catch (IndexOutOfBoundsException ex) {
            log.errorf("Usage: %s", printUsage());
            throw new HandledException();
        }
    }

    protected Integer getIntArg(int index) {
        String str = getArg(index);
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException nex) {
            log.errorf("Usage: %s", printUsage());
            throw new HandledException();
        }
    }

    public String printUsage() {
        return getName();
    }

    public static class HandledException extends RuntimeException {
    }

}
