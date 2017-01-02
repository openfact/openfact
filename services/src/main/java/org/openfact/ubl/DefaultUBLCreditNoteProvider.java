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
import org.openfact.models.*;
import org.openfact.models.enums.RequiredAction;
import org.openfact.models.enums.SendResultType;
import org.openfact.models.utils.OpenfactModelUtils;
import org.openfact.report.ExportFormat;
import org.openfact.report.ReportException;
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

            @Override
            public Document write(OrganizationModel organization, CreditNoteType t,
                    Map<String, String> attributes) {
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
            public SendEventModel sendToCustomer(OrganizationModel organization, CreditNoteModel creditNote) throws SendException {
                if (creditNote.getCustomerElectronicMail() == null) {
                    SendEventModel sendEvent =  session.getProvider(SendEventProvider.class).addSendEvent(organization, SendResultType.ERROR, creditNote);
                    sendEvent.setType("EMAIL");
                    sendEvent.setDescription("Could not find a valid email for the customer.");
                    return sendEvent;
                }

                if (organization.getSmtpConfig().size() == 0) {
                    SendEventModel sendEvent =  session.getProvider(SendEventProvider.class).addSendEvent(organization, SendResultType.ERROR, creditNote);
                    sendEvent.setType("EMAIL");
                    sendEvent.setDescription("Could not find a valid smtp configuration on organization.");
                    return sendEvent;
                }

                // User where the email will be send
                UserSenderModel user = new UserSenderModel() {
                    @Override
                    public String getFullName() {
                        return creditNote.getCustomerRegistrationName();
                    }

                    @Override
                    public String getEmail() {
                        return creditNote.getCustomerElectronicMail();
                    }
                };

                try {
                    // Attatchments
                    FileModel xmlFile = new SimpleFileModel();
                    xmlFile.setFileName(creditNote.getDocumentId() + ".xml");
                    xmlFile.setFile(creditNote.getXmlFile().getFile());
                    xmlFile.setMimeType("application/xml");

                    FileModel pdfFile = new SimpleFileModel();

                    pdfFile.setFileName(creditNote.getDocumentId() + ".pdf");
                    pdfFile.setFile(session.getProvider(UBLReportProvider.class).invoice().setOrganization(organization).getReport(creditNote, ExportFormat.PDF));
                    pdfFile.setMimeType("application/pdf");

                    session.getProvider(EmailTemplateProvider.class)
                            .setOrganization(organization).setUser(user)
                            .setAttachments(Arrays.asList(xmlFile, pdfFile))
                            .sendCreditNote(creditNote);

                    // Write event to the database
                    SendEventModel sendEvent =  session.getProvider(SendEventProvider.class).addSendEvent(organization, SendResultType.SUCCESS, creditNote);
                    sendEvent.setType("EMAIL");

                    sendEvent.setDescription("Credit note successfully sended");
                    sendEvent.addFileAttatchments(xmlFile);
                    sendEvent.addFileAttatchments(pdfFile);
                    sendEvent.setResult(true);

                    Map<String, String> destiny = new HashMap<>();
                    destiny.put("email", user.getEmail());
                    sendEvent.setDestiny(destiny);

                    // Remove required action
                    creditNote.removeRequiredAction(RequiredAction.SEND_TO_CUSTOMER);

                    return sendEvent;
                } catch (ReportException e) {
                    SendEventModel sendEvent =  session.getProvider(SendEventProvider.class).addSendEvent(organization, SendResultType.ERROR, creditNote);
                    sendEvent.setType("EMAIL");
                    sendEvent.setDescription(e.getMessage());
                    throw new SendException("Could not generate pdf report", e);
                } catch (EmailException e) {
                    SendEventModel sendEvent =  session.getProvider(SendEventProvider.class).addSendEvent(organization, SendResultType.ERROR, creditNote);
                    sendEvent.setType("EMAIL");
                    sendEvent.setDescription(e.getMessage());
                    throw new SendException("Could not send email", e);
                }
            }

            @Override
            public SendEventModel sendToThridParty(OrganizationModel organization, CreditNoteModel creditNote) throws SendException {
                SendEventModel sendEvent =  session.getProvider(SendEventProvider.class).addSendEvent(organization, SendResultType.ERROR, creditNote);
                sendEvent.setDescription("Could not send the credit note because there is no a valid Third Party. This feature should be implemented by your own code");
                return sendEvent;
            }
            
        };
    }

}
