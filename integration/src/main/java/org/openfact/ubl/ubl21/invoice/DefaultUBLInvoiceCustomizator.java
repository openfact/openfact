package org.openfact.ubl.ubl21.invoice;

import oasis.names.specification.ubl.schema.xsd.invoice_21.InvoiceType;
import org.openfact.models.DocumentModel;
import org.openfact.models.OrganizationModel;
import org.openfact.models.types.DocumentRequiredAction;
import org.openfact.models.utils.TypeToModel;
import org.openfact.ubl.ubl21.qualifiers.UBLDocumentType;
import org.openfact.provider.ProviderType;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
@ProviderType("default")
@UBLDocumentType("INVOICE")
public class DefaultUBLInvoiceCustomizator implements UBLInvoiceCustomizator {

    @Inject
    private TypeToModel typeToModel;

    @Override
    public void config(OrganizationModel organization, DocumentModel document, Object o) {
        InvoiceType invoiceType;
        if (o instanceof InvoiceType) {
            invoiceType = (InvoiceType) o;
        } else {
            throw new IllegalStateException("Object class " + o.getClass().getName() + " should be a children of " + InvoiceType.class.getName());
        }

        typeToModel.importInvoice(organization, document, invoiceType);
    }

    @Override
    public DocumentRequiredAction[] getRequiredActions() {
        return new DocumentRequiredAction[]{DocumentRequiredAction.SEND_TO_CUSTOMER, DocumentRequiredAction.SEND_TO_THIRD_PARTY};
    }

    @Override
    public String[] getExtraRequiredActions() {
        return new String[0];
    }
}
