package org.openfact.ubl.ubl21.debitnote;

import oasis.names.specification.ubl.schema.xsd.debitnote_21.DebitNoteType;
import oasis.names.specification.ubl.schema.xsd.invoice_21.InvoiceType;
import org.openfact.models.types.DocumentRequiredAction;
import org.openfact.ubl.UBLCustomizationProvider;

public interface UBLDebitNoteCustomizationProvider extends UBLCustomizationProvider<DebitNoteType> {

    default DocumentRequiredAction[] getRequiredActions() {
        return new DocumentRequiredAction[]{DocumentRequiredAction.SEND_TO_CUSTOMER, DocumentRequiredAction.SEND_TO_THIRD_PARTY};
    }

}
