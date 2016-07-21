package org.openfact.authentication;

import org.openfact.common.ClientConnection;
import org.openfact.provider.Provider;

public interface ClientAuthenticatorProvider extends Provider {

    String getCurrentUser(ClientConnection client);

    String getFullName(ClientConnection client);

    String getEmail(ClientConnection client);

}
