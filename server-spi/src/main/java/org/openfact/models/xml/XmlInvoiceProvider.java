package org.openfact.models.xml;

import org.openfact.models.InvoiceModel;
import org.openfact.provider.Provider;

public interface XmlInvoiceProvider extends Provider {

    XmlInvoiceModel toXml(InvoiceModel invoice);

}