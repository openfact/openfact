package org.openfact.testsuite.util.cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;
import org.openfact.testsuite.OpenfactServer;

public class TestsuiteCLI {
    
    private static final Logger log = Logger.getLogger(TestsuiteCLI.class);

    private static final Class<?>[] BUILTIN_COMMANDS = {
            /*ExitCommand.class,
            HelpCommand.class,
            /*AbstractOfflineCacheCommand.PutCommand.class,
            AbstractOfflineCacheCommand.GetCommand.class,
            AbstractOfflineCacheCommand.GetMultipleCommand.class,
            AbstractOfflineCacheCommand.GetLocalCommand.class,
            AbstractOfflineCacheCommand.RemoveCommand.class,
            AbstractOfflineCacheCommand.SizeCommand.class,
            AbstractOfflineCacheCommand.ListCommand.class,
            AbstractOfflineCacheCommand.ClearCommand.class,
            PersistSessionsCommand.class,
            LoadPersistentSessionsCommand.class,
            UserCommands.Create.class,
            UserCommands.Remove.class,
            UserCommands.Count.class,
            UserCommands.GetUser.class,
            SyncDummyFederationProviderCommand.class*/
    };

    private final OpenfactSessionFactory sessionFactory;
    private final Map<String, Class<? extends AbstractCommand>> commands = new LinkedHashMap<>();

    public TestsuiteCLI(OpenfactServer server) {
        this.sessionFactory = server.getSessionFactory();

        // register builtin commands
        for (Class<?> clazz : BUILTIN_COMMANDS) {
            Class<? extends AbstractCommand> commandClazz = (Class<? extends AbstractCommand>) clazz;
            try {
                AbstractCommand command = commandClazz.newInstance();
                commands.put(command.getName(), commandClazz);
            } catch (Exception ex) {
                log.error("Error registering command of class: " + commandClazz.getName(), ex);
            }
        }
    }

    public void registerCommand(String name, Class<? extends AbstractCommand> command) {
        commands.put(name, command);
    }

    // WARNING: Stdin blocking operation
    public void start() throws IOException {
        log.info("Starting testsuite CLI. Exit with 'exit' . Available commands with 'help' ");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        System.out.print("$ ");
        try {
            while ((line = reader.readLine()) != null) {
                String[] splits = line.split(" ");
                String commandName = splits[0];
                Class<? extends AbstractCommand> commandClass = commands.get(commandName);
                if (commandClass == null) {
                    log.errorf("Unknown command: %s", commandName);
                } else {
                    try {
                        AbstractCommand command = commandClass.newInstance();
                        List<String> args = new ArrayList<>(Arrays.asList(splits));
                        args.remove(0);
                        command.injectProperties(args, this, sessionFactory);
                        command.runCommand();

                        // Just special handling of ExitCommand
                        if (command instanceof ExitCommand) {
                            return;
                        }

                    } catch (InstantiationException ex) {
                        log.error(ex);
                    } catch (IllegalAccessException ex) {
                        log.error(ex);
                    }
                }

                System.out.print("$ ");
            }
        } finally {
            log.info("Exit testsuite CLI");
            reader.close();
        }
    }

    public static class ExitCommand extends AbstractCommand {

        @Override
        public String getName() {
            return "exit";
        }

        @Override
        public void runCommand() {
            // no need to implement. Exit handled in parent
        }

        @Override
        protected void doRunCommand(OpenfactSession session) {
            // no need to implement
        }

        @Override
        public String printUsage() {
            return getName();
        }
    }

    public static class HelpCommand extends AbstractCommand {

        private List<String> commandNames = new ArrayList<>();

        @Override
        public void injectProperties(List<String> args, TestsuiteCLI cli, OpenfactSessionFactory sessionFactory) {
            for (String commandName : cli.commands.keySet()) {
                commandNames.add(commandName);
            }
        }

        @Override
        public String getName() {
            return "help";
        }

        @Override
        public void runCommand() {
            log.info("Available commands: " + commandNames.toString());
        }

        @Override
        protected void doRunCommand(OpenfactSession session) {
            // no need to implement
        }
    }
    
}
