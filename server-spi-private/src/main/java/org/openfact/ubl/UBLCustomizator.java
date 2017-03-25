package org.openfact.ubl;

import org.openfact.models.DocumentModel;
import org.openfact.models.OrganizationModel;
import org.openfact.models.types.DocumentRequiredAction;

public interface UBLCustomizator<T> {

    void config(OrganizationModel organization, DocumentModel document, T t);

    DocumentRequiredAction[] getRequiredActions();

    String[] getExtraRequiredActions();

}
