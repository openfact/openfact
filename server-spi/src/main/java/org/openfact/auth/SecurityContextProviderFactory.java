package org.openfact.auth;

import javax.servlet.http.HttpServletRequest;

import org.openfact.provider.ProviderFactory;

public interface SecurityContextProviderFactory extends ProviderFactory<SecurityContextProvider> {

    void setServletRequest(HttpServletRequest request);

}
