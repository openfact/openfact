package org.openfact.ubl.pe;

import org.openfact.Config.Scope;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;
import org.openfact.ubl.UblExtensionContentGeneratorProvider;
import org.openfact.ubl.UblExtensionContentGeneratorProviderFactory;

public class UblExtensionContentGeneratorProviderFactory_PE implements UblExtensionContentGeneratorProviderFactory {

    @Override
    public UblExtensionContentGeneratorProvider create(OpenfactSession session) {
        return new UblExtensionContentGeneratorProvider_PE(session);
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
