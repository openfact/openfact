package org.openfact.ubl;

import org.openfact.models.*;
import org.openfact.models.types.DestinyType;

public interface UBLEmailSender {

    SendEventModel send(OrganizationModel organization, DocumentModel document, String email, DestinyType destiny) throws ModelInsuficientData, SendEventException;

}
