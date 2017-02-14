package org.openfact.provider;

import org.openfact.Config;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;

/**
 * At boot time, openfact discovers all factories.  For each discovered factory, the init() method is called.  After
 * all factories have been initialized, the postInit() method is called.  close() is called when the server shuts down.
 * <p>
 * Only one instance of a factory exists per server.
 */
public interface ProviderFactory<T extends Provider> {

    T create(OpenfactSession session);

    /**
     * Only called once when the factory is first created.  This config is pulled from openfact_server.json
     *
     * @param config
     */
    void init(Config.Scope config);

    /**
     * Called after all provider factories have been initialized
     */
    void postInit(OpenfactSessionFactory factory);

    /**
     * This is called when the server shuts down.
     */
    void close();

    String getId();

}
