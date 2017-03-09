package org.openfact.ubl.ubl21.invoice;

import oasis.names.specification.ubl.schema.xsd.invoice_21.InvoiceType;
import org.openfact.models.types.DocumentRequiredAction;
import org.openfact.ubl.UBLCustomizationProvider;

public interface UBLInvoiceCustomizationProvider extends UBLCustomizationProvider<InvoiceType> {

    default DocumentRequiredAction[] getRequiredActions() {
        return new DocumentRequiredAction[]{DocumentRequiredAction.SEND_TO_CUSTOMER, DocumentRequiredAction.SEND_TO_CUSTOMER};
    }

}
