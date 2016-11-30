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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.openfact.email.EmailException;
import org.openfact.email.EmailTemplateProvider;
import org.openfact.models.CustomerPartyModel;
import org.openfact.models.FileModel;
import org.openfact.models.CreditNoteModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.PartyLegalEntityModel;
import org.openfact.models.UserSenderModel;
import org.openfact.models.enums.SendResultType;
import org.openfact.models.utils.OpenfactModelUtils;
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
                CustomerPartyModel customerParty = creditNote.getAccountingCustomerParty();                
                if(customerParty == null || customerParty.getParty() == null || customerParty.getParty().getContact() == null || customerParty.getParty().getContact().getElectronicMail() == null) {
                    return null;
                }
                
                // User where the email will be send
                UserSenderModel user = new UserSenderModel() {                                                         
                    @Override
                    public String getFullName() {
                        List<PartyLegalEntityModel> partyLegalEntities = customerParty.getParty().getPartyLegalEntity();
                        return partyLegalEntities.stream().map(f -> f.getRegistrationName()).reduce((t,u) -> t + "," +u).get();
                    }                                                           
                    @Override
                    public String getEmail() {
                        return customerParty.getParty().getContact().getElectronicMail();
                    }
                }; 
                
                // Attatchments
                FileModel file = new FileModel();
                file.setFileName(creditNote.getDocumentId() + ".xml");
                file.setFile(creditNote.getXmlDocument());
                file.setMimeType("application/xml");
                
                try {
                    session.getProvider(EmailTemplateProvider.class)
                            .setOrganization(organization)
                            .setUser(user).setAttachments(new ArrayList<>(Arrays.asList(file)))
                            .sendCreditNote(creditNote);
                    
                    // Write event to the database
                    SendEventModel sendEvent = session.getProvider(SendEventProvider.class)
                            .addSendEvent(organization, SendResultType.SUCCESS, creditNote);
                    sendEvent.setDescription("CreditNote Sended by Email");
                    
                    return sendEvent;
                } catch (EmailException e) {
                    throw new SendException(e);
                }
            }

            @Override
            public SendEventModel sendToThridParty(OrganizationModel organization, CreditNoteModel t) throws SendException {
                return null;
            }
            
        };
    }

}
