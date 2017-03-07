/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package org.openfact.ubl;

import org.openfact.models.*;
import org.openfact.services.managers.DocumentManager;

public class DefaultUBLSenderProvider implements UBLSender<DocumentModel> {

    @Override
    public SendEventModel sendToCustomer(OrganizationModel organization, DocumentModel document) throws ModelInsuficientData, SendEventException {
        return null;
//        SendEventModel sendEvent = document.addSendEvent(DestinyType.CUSTOMER);
//        sendToCustomer(organization, document, sendEvent);
//        return sendEvent;
    }

    @Override
    public void sendToCustomer(OrganizationModel organization, DocumentModel document, SendEventModel sendEvent) throws ModelInsuficientData, SendEventException {
//        DocumentManager manager = new DocumentManager(session);
//        manager.sendToThirdPartyByEmail(organization, document, sendEvent, document.getCustomerElectronicMail());
//        document.removeRequiredAction(RequiredAction.SEND_TO_CUSTOMER);
    }

    @Override
    public SendEventModel sendToThirdParty(OrganizationModel organization, DocumentModel invoice) throws ModelInsuficientData, SendEventException {
//        SendEventModel sendEvent = io.addSendEvent(DestinyType.THIRD_PARTY);
//        sendToThirdParty(organization, io, sendEvent);
//        return sendEvent;
        return null;
    }

    @Override
    public void sendToThirdParty(OrganizationModel organization, DocumentModel invoiceModel, SendEventModel sendEvent) throws ModelInsuficientData, SendEventException {
//        sendEvent.setResult(SendEventStatus.ERROR);
//        sendEvent.setDescription("Could not send the document because there is no a valid Third Party. This feature should be implemented by your own code");
    }

}
