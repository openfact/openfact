package org.openfact.ubl.ubl21.invoice;

import oasis.names.specification.ubl.schema.xsd.invoice_21.InvoiceType;
import org.openfact.ubl.UBLIDGenerator;

public interface UBLInvoiceIDGeneratorFactory<T extends InvoiceType> extends UBLIDGenerator<T> {
}
