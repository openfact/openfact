package org.openfact.ubl.ubl21.creditnote;

import com.helger.ubl21.UBL21Reader;
import com.helger.ubl21.UBL21Writer;
import oasis.names.specification.ubl.schema.xsd.creditnote_21.CreditNoteType;
import org.openfact.ubl.ubl21.qualifiers.UBLDocumentType;
import org.openfact.provider.ProviderType;
import org.w3c.dom.Document;

import javax.ejb.Stateless;

@ProviderType("default")
@UBLDocumentType("CREDIT_NOTE")
@Stateless
public class DefaultUBLCreditNoteReaderWriter implements UBLCreditNoteReaderWriter {

    @Override
    public UBLReader<CreditNoteType> reader() {
        return new UBLReader<CreditNoteType>() {
            @Override
            public CreditNoteType read(Document document) {
                return UBL21Reader.creditNote().read(document);
            }

            @Override
            public CreditNoteType read(byte[] bytes) {
                return UBL21Reader.creditNote().read(bytes);
            }
        };
    }

    @Override
    public UBLWriter<CreditNoteType> writer() {
        return (organization, t) -> UBL21Writer.creditNote().getAsDocument(t);
    }

}
