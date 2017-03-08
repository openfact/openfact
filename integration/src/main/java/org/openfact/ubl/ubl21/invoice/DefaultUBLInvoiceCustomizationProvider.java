package org.openfact.ubl.ubl21.invoice;

import oasis.names.specification.ubl.schema.xsd.invoice_21.InvoiceType;
import org.openfact.models.DocumentModel;
import org.openfact.models.OrganizationModel;
import org.openfact.models.utils.TypeToModel;
import org.openfact.ubl.ubl21.qualifiers.UBLDocumentType;
import org.openfact.ubl.ubl21.qualifiers.UBLProviderType;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
@UBLProviderType("default")
@UBLDocumentType("INVOICE")
public class DefaultUBLInvoiceCustomizationProvider implements UBLInvoiceCustomizationProvider {

    @Inject
    private TypeToModel typeToModel;

    @Override
    public void config(OrganizationModel organization, DocumentModel document, InvoiceType invoiceType) {
        typeToModel.importInvoice(organization, document, invoiceType);
    }

}
