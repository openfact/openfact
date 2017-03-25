package org.openfact.ubl.ubl21.debitnote;

import org.openfact.models.types.DocumentRequiredAction;

public interface UBLDebitNoteCustomizator extends UBLDebitNoteCustomizatorFactory {

    default DocumentRequiredAction[] getRequiredActions() {
        return new DocumentRequiredAction[]{DocumentRequiredAction.SEND_TO_CUSTOMER, DocumentRequiredAction.SEND_TO_THIRD_PARTY};
    }

    default String[] getExtraRequiredActions() {
        return new String[0];
    }

}
