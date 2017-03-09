package org.openfact.ubl;

import org.openfact.models.*;

public interface UBLThirdPartySender {

    SendEventModel send(OrganizationModel organization, DocumentModel document) throws ModelInsuficientData, SendEventException;

}
