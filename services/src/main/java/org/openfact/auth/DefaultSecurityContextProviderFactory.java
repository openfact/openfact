package org.openfact.auth;

import javax.servlet.http.HttpServletRequest;

import org.openfact.Config.Scope;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;

public class DefaultSecurityContextProviderFactory implements SecurityContextProviderFactory {

    protected HttpServletRequest request;

    @Override
    public SecurityContextProvider create(OpenfactSession session) {
       return null;
    }

    @Override
    public void init(Scope config) {
        // TODO Auto-generated method stub

    }

    @Override
    public void postInit(OpenfactSessionFactory factory) {
        // TODO Auto-generated method stub

    }

    @Override
    public void close() {
        // TODO Auto-generated method stub

    }

    @Override
    public String getId() {
        return "default";
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

}
