package org.openfact.models.utils;

import org.openfact.models.ubl.InvoiceModel;
import oasis.names.specification.ubl.schema.xsd.invoice_21.InvoiceType;

public class ModelToType {

    public static InvoiceType toType(InvoiceModel model) {
        InvoiceType rep = new InvoiceType();
        return rep;
    }

}
