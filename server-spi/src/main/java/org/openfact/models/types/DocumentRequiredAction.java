package org.openfact.models.types;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum DocumentRequiredAction {

    SEND_TO_CUSTOMER(false),
    SEND_TO_THIRD_PARTY(true);

    private boolean isDefault;

    DocumentRequiredAction(boolean isDefault) {
        this.isDefault = isDefault;
    }

    public static List<DocumentRequiredAction> getDefaults() {
        return Arrays.asList(DocumentRequiredAction.values()).stream()
                .filter(p -> p.isDefault)
                .collect(Collectors.toList());
    }

}
