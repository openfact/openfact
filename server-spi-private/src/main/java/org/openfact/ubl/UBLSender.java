package org.openfact.ubl;

import org.openfact.models.ModelInsuficientData;
import org.openfact.models.OrganizationModel;
import org.openfact.models.SendEventModel;
import org.openfact.models.SendException;
import org.openfact.provider.Provider;

public interface UBLSender<T> extends Provider {

    SendEventModel sendToCustomer(OrganizationModel organization, T t) throws ModelInsuficientData, SendException;

    void sendToCustomer(OrganizationModel organization, T t, SendEventModel sendEvent) throws ModelInsuficientData, SendException;

    SendEventModel sendToThirdParty(OrganizationModel organization, T t) throws ModelInsuficientData, SendException;

    void sendToThirdParty(OrganizationModel organization, T t, SendEventModel sendEvent) throws ModelInsuficientData, SendException;

}
