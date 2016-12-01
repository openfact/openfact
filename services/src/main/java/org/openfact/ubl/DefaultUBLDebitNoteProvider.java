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
import org.openfact.models.DebitNoteModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.PartyLegalEntityModel;
import org.openfact.models.UserSenderModel;
import org.openfact.models.enums.SendResultType;
import org.openfact.models.utils.OpenfactModelUtils;
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
                CustomerPartyModel customerParty = debitNote.getAccountingCustomerParty();                
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
                file.setFileName(debitNote.getDocumentId() + ".xml");
                file.setFile(debitNote.getXmlDocument());
                file.setMimeType("application/xml");
                
                try {
                    session.getProvider(EmailTemplateProvider.class)
                            .setOrganization(organization)
                            .setUser(user).setAttachments(new ArrayList<>(Arrays.asList(file)))
                            .sendDebitNote(debitNote);
                    
                    // Write event to the database
                    SendEventModel sendEvent = session.getProvider(SendEventProvider.class)
                            .addSendEvent(organization, SendResultType.SUCCESS, debitNote);
                    sendEvent.setDescription("DebitNote Sended by Email");
                    
                    return sendEvent;
                } catch (EmailException e) {
                    throw new SendException(e);
                }
            }

            @Override
            public SendEventModel sendToThridParty(OrganizationModel organization, DebitNoteModel t) throws SendException {
                return null;
            }
            
        };
    }

}
