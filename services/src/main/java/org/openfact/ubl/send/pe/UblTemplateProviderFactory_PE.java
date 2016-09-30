package org.openfact.ubl.send.pe;

import org.openfact.Config.Scope;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;
import org.openfact.ubl.send.UblTemplateProvider;
import org.openfact.ubl.send.UblTemplateProviderFactory;

public class UblTemplateProviderFactory_PE implements UblTemplateProviderFactory {

    @Override
    public UblTemplateProvider create(OpenfactSession session) {
        return new UblTemplateProvider_PE(session);
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
        return "ublTemplate_pe";
    }

}
