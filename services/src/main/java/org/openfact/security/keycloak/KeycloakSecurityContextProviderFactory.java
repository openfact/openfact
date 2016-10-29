package org.openfact.security.keycloak;

import org.openfact.Config.Scope;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;
import org.openfact.security.SecurityContextProvider;
import org.openfact.security.SecurityContextProviderFactory;

public class KeycloakSecurityContextProviderFactory implements SecurityContextProviderFactory {

    @Override
    public SecurityContextProvider create(OpenfactSession session) {
        return new KeycloakSecurityContextProvider(session);
    }

    @Override
    public void init(Scope config) {
    }

    @Override
    public void postInit(OpenfactSessionFactory factory) {
    }

    @Override
    public void close() {
    }

    @Override
    public String getId() {
        return "keycloak";
    }

}
