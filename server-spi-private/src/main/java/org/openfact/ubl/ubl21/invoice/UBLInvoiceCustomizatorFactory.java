package org.openfact.ubl.ubl21.invoice;

import oasis.names.specification.ubl.schema.xsd.invoice_21.InvoiceType;
import org.openfact.ubl.UBLCustomizationProvider;

public interface UBLInvoiceCustomizatorFactory<T extends InvoiceType> extends UBLCustomizationProvider<T> {
}
