package org.openfact.authentication;

import org.openfact.Config.Scope;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;

public class TestClientAuthenticatorProviderFactory implements ClientAuthenticatorProviderFactory {

    @Override
    public ClientAuthenticatorProvider create(OpenfactSession session) {
        return new TestClientAuthenticatorProvider(session);
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
        return "test";
    }

}
