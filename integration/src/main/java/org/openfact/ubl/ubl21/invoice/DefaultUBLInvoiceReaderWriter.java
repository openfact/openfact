package org.openfact.ubl.ubl21.invoice;

import com.helger.ubl21.UBL21Reader;
import com.helger.ubl21.UBL21Writer;
import oasis.names.specification.ubl.schema.xsd.invoice_21.InvoiceType;
import org.openfact.ubl.ubl21.qualifiers.UBLDocumentType;
import org.openfact.provider.ProviderType;
import org.w3c.dom.Document;

import javax.ejb.Stateless;

@Stateless
@ProviderType("default")
@UBLDocumentType("INVOICE")
public class DefaultUBLInvoiceReaderWriter implements UBLInvoiceReaderWriter {

    @Override
    public UBLReader<InvoiceType> reader() {
        return new UBLReader<InvoiceType>() {
            @Override
            public InvoiceType read(Document document) {
                return UBL21Reader.invoice().read(document);
            }

            @Override
            public InvoiceType read(byte[] bytes) {
                return UBL21Reader.invoice().read(bytes);
            }
        };
    }

    @Override
    public UBLWriter<InvoiceType> writer() {
        return (organization, invoiceType) -> UBL21Writer.invoice().getAsDocument(invoiceType);
    }

}
