package org.openfact.models.xml.ubl;

import org.openfact.Config.Scope;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;
import org.openfact.models.xml.XmlInvoiceProvider;
import org.openfact.models.xml.XmlInvoiceProviderFactory;

public class UblXmlInvoiceProviderFactory implements XmlInvoiceProviderFactory {

    @Override
    public XmlInvoiceProvider create(OpenfactSession session) {
        return new UblXmlInvoiceProvider();
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
