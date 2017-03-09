package org.openfact.ubl.ubl21.creditnote;

import oasis.names.specification.ubl.schema.xsd.creditnote_21.CreditNoteType;
import org.openfact.models.types.DocumentRequiredAction;
import org.openfact.ubl.UBLCustomizationProvider;

public interface UBLCreditNoteCustomizationProvider extends UBLCustomizationProvider<CreditNoteType> {

    default DocumentRequiredAction[] getRequiredActions() {
        return new DocumentRequiredAction[]{DocumentRequiredAction.SEND_TO_CUSTOMER, DocumentRequiredAction.SEND_TO_CUSTOMER};
    }

}
