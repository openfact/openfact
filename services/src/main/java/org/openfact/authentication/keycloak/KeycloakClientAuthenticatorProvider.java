package org.openfact.authentication.keycloak;

import org.openfact.authentication.ClientAuthenticatorProvider;
import org.openfact.common.ClientConnection;

public class KeycloakClientAuthenticatorProvider implements ClientAuthenticatorProvider {

    @Override
    public void close() {
        // TODO Auto-generated method stub

    }

    @Override
    public String getCurrentUser(ClientConnection client) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getFullName(ClientConnection client) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getEmail(ClientConnection client) {
        // TODO Auto-generated method stub
        return null;
    }

}
