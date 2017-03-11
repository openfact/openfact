package org.openfact.ubl.ubl21.debitnote;

import oasis.names.specification.ubl.schema.xsd.debitnote_21.DebitNoteType;
import org.openfact.ubl.UBLReaderWriter;

public interface UBLDebitNoteReaderWriterFactory<T extends DebitNoteType> extends UBLReaderWriter<T> {
}
