package org.openfact.authentication;

import java.util.Map;

import org.openfact.Config.Scope;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;

public class DefaultClientAuthenticatorProviderFactory implements ClientAuthenticatorProviderFactory {

    @Override
    public ClientAuthenticatorProvider create(OpenfactSession session) {
        // TODO Auto-generated method stub
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
    public Map<String, Object> getAdapterConfiguration() {
        // TODO Auto-generated method stub
        return null;
    }

}
