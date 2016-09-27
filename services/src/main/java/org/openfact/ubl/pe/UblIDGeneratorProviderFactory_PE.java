package org.openfact.ubl.pe;

import org.openfact.Config.Scope;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;
import org.openfact.ubl.UblIDGeneratorProvider;
import org.openfact.ubl.UblIDGeneratorProviderFactory;

public class UblIDGeneratorProviderFactory_PE implements UblIDGeneratorProviderFactory {

    @Override
    public UblIDGeneratorProvider create(OpenfactSession session) {
        return new UblIDGeneratorProvider_PE(session);
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
        return "ublIDGenerator_pe";
    }

}
