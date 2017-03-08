package org.openfact.ubl.ubl21.debitnote;

import com.helger.ubl21.UBL21Reader;
import com.helger.ubl21.UBL21Writer;
import oasis.names.specification.ubl.schema.xsd.debitnote_21.DebitNoteType;
import org.openfact.models.OrganizationModel;
import org.openfact.ubl.ubl21.qualifiers.UBLDocumentType;
import org.openfact.ubl.ubl21.qualifiers.UBLProviderType;
import org.w3c.dom.Document;

@UBLProviderType("default")
@UBLDocumentType("DEBIT_NOTE")
public class DefaultUBLDebitNoteReaderWriter implements UBLDebitNoteReaderWriterProvider {

    @Override
    public UBLReader<DebitNoteType> reader() {
        return new UBLReader<DebitNoteType>() {
            @Override
            public DebitNoteType read(Document document) {
                return UBL21Reader.debitNote().read(document);
            }

            @Override
            public DebitNoteType read(byte[] bytes) {
                return UBL21Reader.debitNote().read(bytes);
            }

        };
    }

    @Override
    public UBLWriter<DebitNoteType> writer() {
        return new UBLWriter<DebitNoteType>() {
            @Override
            public Document write(OrganizationModel organization, DebitNoteType t) {
                return UBL21Writer.debitNote().getAsDocument(t);
            }

        };
    }

}
