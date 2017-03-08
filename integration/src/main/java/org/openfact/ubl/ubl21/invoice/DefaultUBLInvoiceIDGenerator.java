package org.openfact.ubl.ubl21.invoice;

import oasis.names.specification.ubl.schema.xsd.invoice_21.InvoiceType;
import org.openfact.models.OrganizationModel;
import org.openfact.models.utils.OpenfactModelUtils;
import org.openfact.ubl.ubl21.qualifiers.UBLDocumentType;
import org.openfact.ubl.ubl21.qualifiers.UBLProviderType;

import javax.ejb.Stateless;

@Stateless
@UBLProviderType("default")
@UBLDocumentType("INVOICE")
public class DefaultUBLInvoiceIDGenerator implements UBLInvoiceIDGenerator {

    @Override
    public String generateID(OrganizationModel organization, InvoiceType invoiceType) {
        return OpenfactModelUtils.generateId();
    }

}
