package org.openfact.ubl.ubl21.debitnote;

import com.helger.ubl21.UBL21Reader;
import com.helger.ubl21.UBL21Writer;
import oasis.names.specification.ubl.schema.xsd.debitnote_21.DebitNoteType;
import org.openfact.ubl.ubl21.qualifiers.UBLDocumentType;
import org.openfact.provider.ProviderType;
import org.w3c.dom.Document;

import javax.ejb.Stateless;

@Stateless
@ProviderType("default")
@UBLDocumentType("DEBIT_NOTE")
public class DefaultUBLDebitNoteReaderWriter implements UBLDebitNoteReaderWriter {

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
        return (organization, t) -> UBL21Writer.debitNote().getAsDocument(t);
    }

}
