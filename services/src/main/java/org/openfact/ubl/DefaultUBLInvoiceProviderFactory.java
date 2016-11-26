package org.openfact.ubl;

import org.openfact.Config.Scope;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;

public class DefaultUBLInvoiceProviderFactory implements UBLInvoiceProviderFactory {

    @Override
    public UBLInvoiceProvider create(OpenfactSession session) {
        return new DefaultUBLInvoiceProvider(session);
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
        return "default";
    }

}
