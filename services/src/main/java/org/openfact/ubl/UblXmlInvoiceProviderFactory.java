package org.openfact.ubl;

import org.openfact.Config.Scope;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;
import org.openfact.ubl.UblTemplateProvider;
import org.openfact.ubl.UblTemplateProviderFactory;

public class UblXmlInvoiceProviderFactory implements UblTemplateProviderFactory {

    @Override
    public UblTemplateProvider create(OpenfactSession session) {
        return new UblXmlInvoiceProvider(session);
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
        return "ubl";
    }

}