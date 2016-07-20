package org.openfact.auth;

import javax.servlet.http.HttpServletRequest;

public class DefaultSecurityContextProvider implements SecurityContextProvider {

    protected HttpServletRequest request;

    @Override
    public void close() {
        // TODO Auto-generated method stub
    }

    @Override
    public String getCurrentUser() {
        return request.getRemoteUser();
    }

    @Override
    public String getFullName() {
        return null;
    }

    @Override
    public String getEmail() {
        return null;
    }

}
