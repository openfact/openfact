package org.openfact.authentication.keycloak;

import org.openfact.Config.Scope;
import org.openfact.authentication.ClientAuthenticatorProvider;
import org.openfact.authentication.ClientAuthenticatorProviderFactory;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;

public class KeycloakClientAuthenticatorProviderFactory implements ClientAuthenticatorProviderFactory {

    @Override
    public ClientAuthenticatorProvider create(OpenfactSession session) {
        return new KeycloakClientAuthenticatorProvider(session);
    }

    @Override
    public void init(Scope config) {
        // TODO Auto-generated method stub
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
