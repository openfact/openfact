package org.openfact.ubl.send.pe;

import org.openfact.Config.Scope;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;
import org.openfact.ubl.send.UblTaskRunnerProvider;
import org.openfact.ubl.send.UblTaskRunnerProviderFactory;

public class UblTaskRunnerProviderFactory_PE implements UblTaskRunnerProviderFactory {

    @Override
    public UblTaskRunnerProvider create(OpenfactSession session) {
        return new UblTaskRunnerProvider_PE(session);
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
        return "pe";
    }

}
