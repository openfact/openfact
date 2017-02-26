package org.openfact.ubl;

import org.openfact.models.ModelInsuficientData;
import org.openfact.models.OrganizationModel;
import org.openfact.models.SendEventModel;
import org.openfact.models.SendEventException;

public interface UBLSender<T> {

    SendEventModel sendToCustomer(OrganizationModel organization, T t) throws ModelInsuficientData, SendEventException;

    void sendToCustomer(OrganizationModel organization, T t, SendEventModel sendEvent) throws ModelInsuficientData, SendEventException;

    SendEventModel sendToThirdParty(OrganizationModel organization, T t) throws ModelInsuficientData, SendEventException;

    void sendToThirdParty(OrganizationModel organization, T t, SendEventModel sendEvent) throws ModelInsuficientData, SendEventException;

}
