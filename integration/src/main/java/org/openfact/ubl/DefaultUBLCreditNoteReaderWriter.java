package org.openfact.ubl;

import com.helger.ubl21.UBL21Reader;
import com.helger.ubl21.UBL21Writer;
import oasis.names.specification.ubl.schema.xsd.creditnote_21.CreditNoteType;
import org.openfact.models.OrganizationModel;
import org.openfact.ubl.io.UBLCreditNoteReaderWriterProvider;
import org.openfact.ubl.qualifiers.UBLDocumentType;
import org.openfact.ubl.qualifiers.UBLProviderType;
import org.w3c.dom.Document;

@UBLProviderType("default")
@UBLDocumentType("CREDIT_NOTE")
public class DefaultUBLCreditNoteReaderWriter implements UBLCreditNoteReaderWriterProvider {

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
        return new UBLWriter<CreditNoteType>() {
            @Override
            public Document write(OrganizationModel organization, CreditNoteType t) {
                return UBL21Writer.creditNote().getAsDocument(t);
            }
        };
    }

}
