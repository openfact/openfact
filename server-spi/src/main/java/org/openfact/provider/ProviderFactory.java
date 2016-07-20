package org.openfact.provider;

import org.openfact.Config;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;

public interface ProviderFactory<T extends Provider> {

    public T create(OpenfactSession session);

    /**
     * Only called once when the factory is first created. This config is pulled
     * from keycloak_server.json
     *
     * @param config
     */
    public void init(Config.Scope config);

    /**
     * Called after all provider factories have been initialized
     */
    public void postInit(OpenfactSessionFactory factory);

    /**
     * This is called when the server shuts down.
     */
    public void close();

    public String getId();

}
