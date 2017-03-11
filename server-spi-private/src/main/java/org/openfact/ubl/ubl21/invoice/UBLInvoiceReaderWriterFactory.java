package org.openfact.ubl.ubl21.invoice;

import oasis.names.specification.ubl.schema.xsd.invoice_21.InvoiceType;
import org.openfact.ubl.UBLReaderWriter;

public interface UBLInvoiceReaderWriterFactory<T extends InvoiceType> extends UBLReaderWriter<T> {
}
