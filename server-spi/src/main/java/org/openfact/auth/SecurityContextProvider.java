package org.openfact.auth;

import org.openfact.provider.Provider;

public interface SecurityContextProvider extends Provider {

    public String getCurrentUser();

    public String getFullName();

    public String getEmail();

}
