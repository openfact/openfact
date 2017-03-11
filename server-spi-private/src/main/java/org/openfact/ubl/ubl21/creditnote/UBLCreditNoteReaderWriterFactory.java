package org.openfact.ubl.ubl21.creditnote;

import oasis.names.specification.ubl.schema.xsd.creditnote_21.CreditNoteType;
import org.openfact.ubl.UBLReaderWriterProvider;

public interface UBLCreditNoteReaderWriterFactory<T extends CreditNoteType> extends UBLReaderWriterProvider<T> {
}
