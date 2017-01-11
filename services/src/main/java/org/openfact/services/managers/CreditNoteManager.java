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
package org.openfact.services.managers;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.xml.transform.TransformerException;

import org.jboss.logging.Logger;
import org.openfact.common.converts.DocumentUtils;
import org.openfact.file.FileModel;
import org.openfact.file.FileProvider;
import org.openfact.models.*;
import org.openfact.models.SendEventModel;
import org.openfact.models.enums.RequiredAction;
import org.openfact.models.utils.OpenfactModelUtils;
import org.openfact.models.utils.TypeToModel;
import org.openfact.models.SendException;
import org.openfact.ubl.SignerProvider;
import org.openfact.ubl.UBLCreditNoteProvider;
import org.w3c.dom.Document;

import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.IDType;
import oasis.names.specification.ubl.schema.xsd.creditnote_21.CreditNoteType;

public class CreditNoteManager {

    protected static final Logger logger = Logger.getLogger(CreditNoteManager.class);

    protected OpenfactSession session;
    protected CreditNoteProvider model;
    protected UBLCreditNoteProvider ublProvider;

    public CreditNoteManager(OpenfactSession session) {
        this.session = session;
        this.model = session.creditNotes();
        this.ublProvider = session.getProvider(UBLCreditNoteProvider.class);
    }

    public CreditNoteModel getCreditNoteByDocumentId(OrganizationModel organization, String ID) {
        return model.getCreditNoteByDocumentId(organization, ID);
    }

    public CreditNoteModel addCreditNote(OrganizationModel organization, CreditNoteType creditNoteType, Map<String, List<String>> attributes) {
        // Model persist
        IDType documentId = creditNoteType.getID();
        if (documentId == null) {
            String generatedId = ublProvider.idGenerator().generateID(organization, creditNoteType);
            documentId = new IDType(generatedId);
            creditNoteType.setID(documentId);
        }
        CreditNoteModel creditNoteModel = model.addCreditNote(organization, documentId.getValue());

        // Attributes
        for (Map.Entry<String, List<String>> entry : attributes.entrySet()) {
            creditNoteModel.setAttribute(entry.getKey(), entry.getValue());
        }

        // Type to Model
        TypeToModel.importCreditNote(session, organization, creditNoteModel, creditNoteType);

        // Required actions
        Arrays.stream(RequiredAction.values()).forEach(c -> creditNoteModel.addRequiredAction(c));

        try {
            // Generate Document
            Document baseDocument = ublProvider.writer().write(organization, creditNoteType, attributes);
            Document signedDocument = session.getProvider(SignerProvider.class).sign(baseDocument, organization);
            byte[] signedDocumentBytes = DocumentUtils.getBytesFromDocument(signedDocument);

            // File
            FileModel xmlFile = session.getProvider(FileProvider.class).createFile(organization, OpenfactModelUtils.generateId() + ".xml", signedDocumentBytes);
            creditNoteModel.attachXmlFile(xmlFile);
        } catch (TransformerException e) {
            logger.error("Error parsing XML to byte", e);
            throw new ModelException(e);
        }

        fireCreditNotePostCreate(creditNoteModel);
        return creditNoteModel;
    }

    private void fireCreditNotePostCreate(CreditNoteModel creditNote) {
        session.getOpenfactSessionFactory().publish(new CreditNoteModel.CreditNotePostCreateEvent() {
            @Override
            public CreditNoteModel getCreatedCreditNote() {
                return creditNote;
            }

            @Override
            public OpenfactSession getOpenfactSession() {
                return session;
            }
        });
    }

    public boolean removeCreditNote(OrganizationModel organization, CreditNoteModel creditNote) {
        if (model.removeCreditNote(organization, creditNote)) {
            return true;
        }
        return false;
    }

    public boolean removeDebitNote(OrganizationModel organization, CreditNoteModel creditNote) {
        if (model.removeCreditNote(organization, creditNote)) {
            return true;
        }
        return false;
    }

    public SendEventModel sendToCustomerParty(OrganizationModel organization, CreditNoteModel creditNote) throws SendException {
        return sendToCustomerParty(organization, creditNote, null);
    }

    public SendEventModel sendToCustomerParty(OrganizationModel organization, CreditNoteModel creditNote, SendEventModel sendEvent) throws SendException {
        if(sendEvent == null) {
            return ublProvider.sender().sendToCustomer(organization, creditNote);
        } else {
            return ublProvider.sender().sendToCustomer(organization, creditNote, sendEvent);
        }
    }

    public SendEventModel sendToTrirdParty(OrganizationModel organization, CreditNoteModel creditNote) throws SendException {
        return sendToTrirdParty(organization, creditNote, null);
    }

    public SendEventModel sendToTrirdParty(OrganizationModel organization, CreditNoteModel creditNote, SendEventModel sendEvent) throws SendException {
        if(sendEvent == null) {
            return ublProvider.sender().sendToThirdParty(organization, creditNote);
        } else {
            return ublProvider.sender().sendToThirdParty(organization, creditNote, sendEvent);
        }
    }

}
