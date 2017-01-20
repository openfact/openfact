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

import java.util.*;

import org.apache.commons.validator.routines.EmailValidator;
import org.openfact.email.EmailException;
import org.openfact.email.EmailTemplateProvider;
import org.openfact.file.FileModel;
import org.openfact.file.FileMymeTypeModel;
import org.openfact.file.FileProvider;
import org.openfact.models.*;
import org.openfact.models.enums.DestinyType;
import org.openfact.models.enums.RequiredAction;
import org.openfact.models.enums.SendResultType;
import org.openfact.models.utils.OpenfactModelUtils;
import org.openfact.report.ExportFormat;
import org.openfact.report.ReportException;
import org.openfact.services.managers.CreditNoteManager;
import org.openfact.services.managers.DebitNoteManager;
import org.w3c.dom.Document;

import com.helger.ubl21.UBL21Reader;
import com.helger.ubl21.UBL21Writer;

import oasis.names.specification.ubl.schema.xsd.creditnote_21.CreditNoteType;

public class DefaultUBLCreditNoteProvider implements UBLCreditNoteProvider {

    protected OpenfactSession session;

    public DefaultUBLCreditNoteProvider(OpenfactSession session) {
        this.session = session;
    }

    @Override
    public void close() {
    }

    @Override
    public UBLIDGenerator<CreditNoteType> idGenerator() {
        return new UBLIDGenerator<CreditNoteType>() {

            @Override
            public void close() {
            }

            @Override
            public String generateID(OrganizationModel organization, CreditNoteType t) {
                return OpenfactModelUtils.generateId();
            }

        };
    }

    @Override
    public UBLReader<CreditNoteType> reader() {
        return new UBLReader<CreditNoteType>() {

            @Override
            public void close() {
            }

            @Override
            public CreditNoteType read(Document document) {
                return UBL21Reader.creditNote().read(document);
            }

            @Override
            public CreditNoteType read(byte[] bytes) {
                return UBL21Reader.creditNote().read(bytes);
            }

        };
    }

    @Override
    public UBLWriter<CreditNoteType> writer() {
        return new UBLWriter<CreditNoteType>() {

            @Override
            public void close() {
            }

            @Override
            public Document write(OrganizationModel organization, CreditNoteType t) {
                return UBL21Writer.creditNote().getAsDocument(t);
            }

        };
    }

    @Override
    public UBLSender<CreditNoteModel> sender() {
        return new UBLSender<CreditNoteModel>() {

            @Override
            public void close() {
            }

            @Override
            public SendEventModel sendToCustomer(OrganizationModel organization, CreditNoteModel creditNote) throws ModelInsuficientData, SendException {
                SendEventModel sendEvent = creditNote.addSendEvent(DestinyType.CUSTOMER);
                sendToCustomer(organization, creditNote, sendEvent);
                return sendEvent;
            }

            @Override
            public void sendToCustomer(OrganizationModel organization, CreditNoteModel creditNote, SendEventModel sendEvent) throws ModelInsuficientData, SendException {
                CreditNoteManager manager = new CreditNoteManager(session);
                manager.sendToThirdPartyByEmail(organization, creditNote, sendEvent, creditNote.getCustomerElectronicMail());
            }

            @Override
            public SendEventModel sendToThirdParty(OrganizationModel organization, CreditNoteModel creditNote) throws SendException {
                SendEventModel sendEvent = creditNote.addSendEvent(DestinyType.THIRD_PARTY);
                sendToThirdParty(organization, creditNote, sendEvent);
                return sendEvent;
            }

            @Override
            public void sendToThirdParty(OrganizationModel organization, CreditNoteModel creditNoteModel, SendEventModel sendEvent) throws SendException {
                sendEvent.setResult(SendResultType.ERROR);
                sendEvent.setDescription("Could not send the credit note because there is no a valid Third Party. This feature should be implemented by your own code");
            }

        };
    }

}
