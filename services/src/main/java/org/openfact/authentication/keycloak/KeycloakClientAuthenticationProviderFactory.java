package org.openfact.authentication.keycloak;

import org.openfact.Config.Scope;
import org.openfact.authentication.AuthenticationProvider;
import org.openfact.authentication.AuthenticationProviderFactory;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;

public class KeycloakClientAuthenticationProviderFactory implements AuthenticationProviderFactory {

    @Override
    public AuthenticationProvider create(OpenfactSession session) {
        return new KeycloakClientAuthenticationProvider(session);
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
