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
import org.openfact.models.InvoiceModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.PartyLegalEntityModel;
import org.openfact.models.UserSenderModel;
import org.openfact.models.enums.RequiredAction;
import org.openfact.models.enums.SendResultType;
import org.openfact.models.utils.OpenfactModelUtils;
import org.openfact.report.ReportException;
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

            @Override
            public Document write(OrganizationModel organization, InvoiceType t,
                    Map<String, String> attributes) {
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
			public SendEventModel sendToCustomer(OrganizationModel organization, InvoiceModel invoice) throws SendException {
				CustomerPartyModel customerParty = invoice.getAccountingCustomerParty();

                SendEventModel sendEvent =  session.getProvider(SendEventProvider.class).addSendEvent(organization, SendResultType.ERROR, invoice);
                sendEvent.setType("EMAIL");

                if (customerParty == null || customerParty.getParty() == null || customerParty.getParty().getContact() == null || customerParty.getParty().getContact().getElectronicMail() == null) {
                    sendEvent.setDescription("Could not find a valid email for the customer.");
                    return sendEvent;
				}

				// User where the email will be send
				UserSenderModel user = new UserSenderModel() {
					@Override
					public String getFullName() {
						List<PartyLegalEntityModel> partyLegalEntities = customerParty.getParty().getPartyLegalEntity();
						return partyLegalEntities.stream().map(f -> f.getRegistrationName()).reduce((t, u) -> t + "," + u).get();
					}

					@Override
					public String getEmail() {
						return customerParty.getParty().getContact().getElectronicMail();
					}
				};

                try {
                    // Attatchments
                    FileModel xmlFile = new FileModel();
                    xmlFile.setFileName(invoice.getDocumentId() + ".xml");
                    xmlFile.setFile(invoice.getXmlDocument());
                    xmlFile.setMimeType("application/xml");

                    FileModel pdfFile = new FileModel();

                    xmlFile.setFileName(invoice.getDocumentId() + ".pdf");
                    xmlFile.setFile(session.getProvider(UBLReportProvider.class).invoice().getReportAsPdf(invoice));
                    xmlFile.setMimeType("application/pdf");

                    List<FileModel> fileAttatchments = new ArrayList<>(Arrays.asList(xmlFile, pdfFile));

                    session.getProvider(EmailTemplateProvider.class)
                            .setOrganization(organization).setUser(user)
                            .setAttachments(fileAttatchments)
                            .sendInvoice(invoice);

                    // Write event to the database
                    sendEvent.setDescription("Ivoice successfully sended");
                    sendEvent.setFileAttatchments(fileAttatchments);

                    Map<String, String> destiny = new HashMap<>();
                    destiny.put("email", user.getEmail());
                    sendEvent.setDestiny(destiny);

                    // Remove required action
                    invoice.removeRequiredAction(RequiredAction.SEND_TO_CUSTOMER);

                    return sendEvent;
                } catch (ReportException e) {
                    sendEvent.setDescription(e.getMessage());
                    throw new SendException("Could not generate pdf report", e);
                } catch (EmailException e) {
                    sendEvent.setDescription(e.getMessage());
                    throw new SendException("Could not send email", e);
                }
			}

            @Override
            public SendEventModel sendToThridParty(OrganizationModel organization, InvoiceModel invoice) throws SendException {
                SendEventModel sendEvent =  session.getProvider(SendEventProvider.class).addSendEvent(organization, SendResultType.ERROR, invoice);
                sendEvent.setDescription("Could not send the invoice because there is no a valid Third Party. This feature should be implemented by your own code");
                return sendEvent;
            }
            
        };
    }

}
