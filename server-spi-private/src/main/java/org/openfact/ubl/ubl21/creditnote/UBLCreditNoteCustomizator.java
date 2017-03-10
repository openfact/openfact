package org.openfact.ubl.ubl21.creditnote;

import org.openfact.models.types.DocumentRequiredAction;

public interface UBLCreditNoteCustomizator extends UBLCreditNoteCustomizatorFactory {

    default DocumentRequiredAction[] getRequiredActions() {
        return new DocumentRequiredAction[]{DocumentRequiredAction.SEND_TO_CUSTOMER, DocumentRequiredAction.SEND_TO_THIRD_PARTY};
    }

}
