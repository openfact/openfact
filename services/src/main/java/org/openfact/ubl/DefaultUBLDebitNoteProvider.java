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

import org.openfact.email.EmailException;
import org.openfact.email.EmailTemplateProvider;
import org.openfact.models.CustomerPartyModel;
import org.openfact.models.FileModel;
import org.openfact.models.DebitNoteModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.PartyLegalEntityModel;
import org.openfact.models.SimpleFileModel;
import org.openfact.models.UserSenderModel;
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

            @Override
            public Document write(OrganizationModel organization, DebitNoteType t,
                    Map<String, String> attributes) {
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
            public SendEventModel sendToCustomer(OrganizationModel organization, DebitNoteModel debitNote) throws SendException {
                if (debitNote.getCustomerElectronicMail() == null) {
                    SendEventModel sendEvent =  session.getProvider(SendEventProvider.class).addSendEvent(organization, SendResultType.ERROR, debitNote);
                    sendEvent.setType("EMAIL");
                    sendEvent.setDescription("Could not find a valid email for the customer.");
                    return sendEvent;
                }

                if (organization.getSmtpConfig().size() == 0) {
                    SendEventModel sendEvent =  session.getProvider(SendEventProvider.class).addSendEvent(organization, SendResultType.ERROR, debitNote);
                    sendEvent.setType("EMAIL");
                    sendEvent.setDescription("Could not find a valid smtp configuration on organization.");
                    return sendEvent;
                }

                // User where the email will be send
                UserSenderModel user = new UserSenderModel() {
                    @Override
                    public String getFullName() {
                        return debitNote.getCustomerRegistrationName();
                    }

                    @Override
                    public String getEmail() {
                        return debitNote.getCustomerElectronicMail();
                    }
                };

                try {
                    // Attatchments
                    FileModel xmlFile = new SimpleFileModel();
                    xmlFile.setFileName(debitNote.getDocumentId() + ".xml");
                    xmlFile.setFile(debitNote.getXmlFile().getFile());
                    xmlFile.setMimeType("application/xml");

                    FileModel pdfFile = new SimpleFileModel();

                    pdfFile.setFileName(debitNote.getDocumentId() + ".pdf");
                    pdfFile.setFile(session.getProvider(UBLReportProvider.class).invoice().setOrganization(organization).getReport(debitNote, ExportFormat.PDF));
                    pdfFile.setMimeType("application/pdf");

                    session.getProvider(EmailTemplateProvider.class)
                            .setOrganization(organization).setUser(user)
                            .setAttachments(Arrays.asList(xmlFile, pdfFile))
                            .sendDebitNote(debitNote);

                    // Write event to the database
                    SendEventModel sendEvent =  session.getProvider(SendEventProvider.class).addSendEvent(organization, SendResultType.SUCCESS, debitNote);
                    sendEvent.setType("EMAIL");

                    sendEvent.setDescription("Debit note successfully sended");
                    sendEvent.addFileAttatchments(xmlFile);
                    sendEvent.addFileAttatchments(pdfFile);
                    sendEvent.setResult(true);

                    Map<String, String> destiny = new HashMap<>();
                    destiny.put("email", user.getEmail());
                    sendEvent.setDestiny(destiny);

                    // Remove required action
                    debitNote.removeRequiredAction(RequiredAction.SEND_TO_CUSTOMER);

                    return sendEvent;
                } catch (ReportException e) {
                    SendEventModel sendEvent =  session.getProvider(SendEventProvider.class).addSendEvent(organization, SendResultType.ERROR, debitNote);
                    sendEvent.setType("EMAIL");
                    sendEvent.setDescription(e.getMessage());
                    throw new SendException("Could not generate pdf report", e);
                } catch (EmailException e) {
                    SendEventModel sendEvent =  session.getProvider(SendEventProvider.class).addSendEvent(organization, SendResultType.ERROR, debitNote);
                    sendEvent.setType("EMAIL");
                    sendEvent.setDescription(e.getMessage());
                    throw new SendException("Could not send email", e);
                }
            }

            @Override
            public SendEventModel sendToThridParty(OrganizationModel organization, DebitNoteModel debitNote) throws SendException {
                SendEventModel sendEvent =  session.getProvider(SendEventProvider.class).addSendEvent(organization, SendResultType.ERROR, debitNote);
                sendEvent.setDescription("Could not send the debit note because there is no a valid Third Party. This feature should be implemented by your own code");
                return sendEvent;
            }
            
        };
    }

}
