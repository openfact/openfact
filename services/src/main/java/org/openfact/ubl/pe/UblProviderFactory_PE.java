package org.openfact.ubl.pe;

import org.openfact.Config.Scope;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;
import org.openfact.ubl.UblProvider;
import org.openfact.ubl.UblProviderFactory;

public class UblProviderFactory_PE implements UblProviderFactory {

    @Override
    public UblProvider create(OpenfactSession session) {
        return new UblProvider_PE(session);
    }

    @Override
    public void init(Scope config) {
    }

    @Override
    public void postInit(OpenfactSessionFactory factory) {
    }

    @Override
    public void close() {

    }

    @Override
    public String getId() {
        return "ubl_pe";
    }

}
