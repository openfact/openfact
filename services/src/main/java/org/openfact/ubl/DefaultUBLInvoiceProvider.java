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
import org.openfact.services.managers.InvoiceManager;
import org.w3c.dom.Document;

import com.helger.ubl21.UBL21Reader;
import com.helger.ubl21.UBL21Writer;

import oasis.names.specification.ubl.schema.xsd.invoice_21.InvoiceType;

public class DefaultUBLInvoiceProvider implements UBLInvoiceProvider {

    protected OpenfactSession session;

    public DefaultUBLInvoiceProvider(OpenfactSession session) {
        this.session = session;
    }

    @Override
    public void close() {
    }

    @Override
    public UBLIDGenerator<InvoiceType> idGenerator() {
        return new UBLIDGenerator<InvoiceType>() {
            @Override
            public void close() {
            }

            @Override
            public String generateID(OrganizationModel organization, InvoiceType t) {
                return OpenfactModelUtils.generateId();
            }
        };
    }

    @Override
    public UBLReader<InvoiceType> reader() {
        return new UBLReader<InvoiceType>() {
            @Override
            public void close() {
            }

            @Override
            public InvoiceType read(Document document) {
                return UBL21Reader.invoice().read(document);
            }

            @Override
            public InvoiceType read(byte[] bytes) {
                return UBL21Reader.invoice().read(bytes);
            }
        };
    }

    @Override
    public UBLWriter<InvoiceType> writer() {
        return new UBLWriter<InvoiceType>() {
            @Override
            public void close() {
            }

            @Override
            public Document write(OrganizationModel organization, InvoiceType t) {
                return UBL21Writer.invoice().getAsDocument(t);
            }

        };
    }

    @Override
    public UBLSender<InvoiceModel> sender() {
        return new UBLSender<InvoiceModel>() {

            @Override
            public void close() {
            }

            @Override
            public SendEventModel sendToCustomer(OrganizationModel organization, InvoiceModel invoice) throws ModelInsuficientData, SendException {
                SendEventModel sendEvent = invoice.addSendEvent(DestinyType.CUSTOMER);
                sendToCustomer(organization, invoice, sendEvent);
                return sendEvent;
            }

            @Override
            public void sendToCustomer(OrganizationModel organization, InvoiceModel invoice, SendEventModel sendEvent) throws ModelInsuficientData, SendException {
                InvoiceManager manager = new InvoiceManager(session);
                manager.sendToThirdPartyByEmail(organization, invoice, sendEvent, invoice.getCustomerElectronicMail());
            }

            @Override
            public SendEventModel sendToThirdParty(OrganizationModel organization, InvoiceModel invoice) throws ModelInsuficientData, SendException {
                SendEventModel sendEvent = invoice.addSendEvent(DestinyType.THIRD_PARTY);
                sendToThirdParty(organization, invoice, sendEvent);
                return sendEvent;
            }

            @Override
            public void sendToThirdParty(OrganizationModel organization, InvoiceModel invoiceModel, SendEventModel sendEvent) throws ModelInsuficientData, SendException {
                sendEvent.setResult(SendResultType.ERROR);
                sendEvent.setDescription("Could not send the invoice because there is no a valid Third Party. This feature should be implemented by your own code");
            }

        };
    }

}
