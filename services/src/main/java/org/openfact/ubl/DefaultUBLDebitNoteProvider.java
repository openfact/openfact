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
import org.w3c.dom.Document;

import com.helger.ubl21.UBL21Reader;
import com.helger.ubl21.UBL21Writer;

import oasis.names.specification.ubl.schema.xsd.debitnote_21.DebitNoteType;

public class DefaultUBLDebitNoteProvider implements UBLDebitNoteProvider {

    protected OpenfactSession session;

    public DefaultUBLDebitNoteProvider(OpenfactSession session) {
        this.session = session;
    }

    @Override
    public void close() {
    }

    @Override
    public UBLIDGenerator<DebitNoteType> idGenerator() {
        return new UBLIDGenerator<DebitNoteType>() {

            @Override
            public void close() {
            }

            @Override
            public String generateID(OrganizationModel organization, DebitNoteType t) {
                return OpenfactModelUtils.generateId();
            }

        };
    }

    @Override
    public UBLReader<DebitNoteType> reader() {
        return new UBLReader<DebitNoteType>() {

            @Override
            public void close() {
            }

            @Override
            public DebitNoteType read(Document document) {
                return UBL21Reader.debitNote().read(document);
            }

            @Override
            public DebitNoteType read(byte[] bytes) {
                return UBL21Reader.debitNote().read(bytes);
            }

        };
    }

    @Override
    public UBLWriter<DebitNoteType> writer() {
        return new UBLWriter<DebitNoteType>() {

            @Override
            public void close() {
            }

            @Override
            public Document write(OrganizationModel organization, DebitNoteType t) {
                return UBL21Writer.debitNote().getAsDocument(t);
            }

        };
    }

    @Override
    public UBLSender<DebitNoteModel> sender() {
        return new UBLSender<DebitNoteModel>() {

            @Override
            public void close() {
            }

            @Override
            public SendEventModel sendToCustomer(OrganizationModel organization, DebitNoteModel debitNote) throws ModelInsuficientData, SendException {
                SendEventModel sendEvent = debitNote.addSendEvent(DestinyType.CUSTOMER);
                sendToCustomer(organization, debitNote, sendEvent);
                return sendEvent;
            }

            @Override
            public void sendToCustomer(OrganizationModel organization, DebitNoteModel debitNote, SendEventModel sendEvent) throws ModelInsuficientData, SendException {
                if (debitNote.getCustomerElectronicMail() == null) {
                    throw new ModelInsuficientData("Could not find a valid email for the customer");
                }
                if (!EmailValidator.getInstance().isValid(debitNote.getCustomerElectronicMail())) {
                    throw new ModelInsuficientData("Invalid email");
                }
                if (organization.getSmtpConfig().size() == 0) {
                    throw new ModelInsuficientData("Could not find a valid smtp configuration on organization");
                }

                // User where the email will be send
                UserSenderModel user = new UserSenderModel(debitNote.getCustomerElectronicMail(), debitNote.getCustomerRegistrationName());

                try {
                    FileProvider fileProvider = session.getProvider(FileProvider.class);

                    // Attatchments
                    FileModel xmlFile = fileProvider.createFile(organization, debitNote.getDocumentId() + ".xml", debitNote.getXmlAsFile().getFile());
                    FileMymeTypeModel xmlFileMymeType = new FileMymeTypeModel(xmlFile, "application/xml");

                    byte[] pdfFileBytes = session.getProvider(UBLReportProvider.class).debitNote().setOrganization(organization).getReport(debitNote, ExportFormat.PDF);
                    FileModel pdfFile = fileProvider.createFile(organization, debitNote.getDocumentId() + ".pdf", pdfFileBytes);
                    FileMymeTypeModel pdfFileMymeType = new FileMymeTypeModel(pdfFile, "application/pdf");

                    session.getProvider(EmailTemplateProvider.class)
                            .setOrganization(organization).setUser(user)
                            .setAttachments(Arrays.asList(xmlFileMymeType, pdfFileMymeType))
                            .sendDebitNote(debitNote);

                    // Write event to the database
                    sendEvent.setType("EMAIL");
                    sendEvent.setDescription("Debit Note successfully sended");
                    sendEvent.attachFile(xmlFile);
                    sendEvent.attachFile(pdfFile);
                    sendEvent.setResult(SendResultType.SUCCESS);

                    sendEvent.setSingleDestinyAttribute("email", user.getEmail());

                    // Remove required action
                    debitNote.removeRequiredAction(RequiredAction.SEND_TO_CUSTOMER);
                } catch (ReportException e) {
                    throw new SendException("Could not generate pdf report to attach file", e);
                } catch (EmailException e) {
                    throw new SendException("Could not send email", e);
                } catch (Throwable e) {
                    throw new SendException("Internal Server Error", e);
                }
            }

            @Override
            public SendEventModel sendToThirdParty(OrganizationModel organization, DebitNoteModel debitNote) throws SendException {
                SendEventModel sendEvent = debitNote.addSendEvent(DestinyType.THIRD_PARTY);
                sendToThirdParty(organization, debitNote, sendEvent);
                return sendEvent;
            }

            @Override
            public void sendToThirdParty(OrganizationModel organization, DebitNoteModel debitNoteModel, SendEventModel sendEvent) throws SendException {
                sendEvent.setResult(SendResultType.ERROR);
                sendEvent.setDescription("Could not send the debit note because there is no a valid Third Party. This feature should be implemented by your own code");
            }

        };
    }

}
