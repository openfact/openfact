package org.openfact.ubl.ar;

import org.openfact.Config.Scope;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;
import org.openfact.ubl.UblProvider;
import org.openfact.ubl.UblProviderFactory;

public class UblProviderFactory_AR implements UblProviderFactory {

    @Override
    public UblProvider create(OpenfactSession session) {
        return new UblProvider_AR(session);
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
        return "ubl_ar";
    }

}
