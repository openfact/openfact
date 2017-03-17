package org.openfact.ubl.ubl21.invoice;

import org.openfact.models.OrganizationModel;
import org.openfact.models.utils.OpenfactModelUtils;
import org.openfact.ubl.ubl21.qualifiers.UBLDocumentType;
import org.openfact.provider.ProviderType;

import javax.ejb.Stateless;

@Stateless
@ProviderType("default")
@UBLDocumentType("INVOICE")
public class DefaultUBLInvoiceIDGenerator implements UBLInvoiceIDGenerator {

    @Override
    public String generateID(OrganizationModel organization, Object invoiceType) {
        return OpenfactModelUtils.generateId();
    }

}
