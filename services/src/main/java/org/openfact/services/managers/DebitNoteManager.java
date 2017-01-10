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
import org.openfact.models.utils.TypeToModel;
import org.openfact.models.SendException;
import org.openfact.ubl.SignerProvider;
import org.openfact.ubl.UBLDebitNoteProvider;
import org.w3c.dom.Document;

import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.IDType;
import oasis.names.specification.ubl.schema.xsd.debitnote_21.DebitNoteType;

public class DebitNoteManager {

    protected static final Logger logger = Logger.getLogger(DebitNoteManager.class);

    protected OpenfactSession session;
    protected DebitNoteProvider model;
    protected UBLDebitNoteProvider ublProvider;

    public DebitNoteManager(OpenfactSession session) {
        this.session = session;
        this.model = session.debitNotes();
        this.ublProvider = session.getProvider(UBLDebitNoteProvider.class);
    }

    public DebitNoteModel getDebitNoteByDocumentId(OrganizationModel organization, String ID) {
        return model.getDebitNoteByDocumentId(organization, ID);
    }

    public DebitNoteModel addDebitNote(OrganizationModel organization, DebitNoteType debitNoteType, Map<String, List<String>> attributes) {
        // Model persist
        IDType documentId = debitNoteType.getID();
        if (documentId == null) {
            String newDocumentId = ublProvider.idGenerator().generateID(organization, debitNoteType);
            documentId = new IDType(newDocumentId);
            debitNoteType.setID(documentId);
        }
        DebitNoteModel debitNoteModel = model.addDebitNote(organization, documentId.getValue());

        // Attributes
        for (Map.Entry<String, List<String>> entry : attributes.entrySet()) {
            debitNoteModel.setAttribute(entry.getKey(), entry.getValue());
        }

        // Type to Model
        TypeToModel.importDebitNote(session, organization, debitNoteModel, debitNoteType);

        // Required actions
        Arrays.stream(RequiredAction.values()).forEach(c -> debitNoteModel.addRequiredAction(c));

        try {
            // Generate Document
            Document baseDocument = ublProvider.writer().write(organization, debitNoteType, attributes);
            Document signedDocument = session.getProvider(SignerProvider.class).sign(baseDocument, organization);
            byte[] signedDocumentBytes = DocumentUtils.getBytesFromDocument(signedDocument);

            // File
            FileModel xmlFile = session.getProvider(FileProvider.class).createFile(organization, debitNoteModel.getDocumentId() + ".xml", signedDocumentBytes);
            debitNoteModel.attachXmlFile(xmlFile);
        } catch (TransformerException e) {
            logger.error("Error parsing XML to byte", e);
            throw new ModelException(e);
        }

        fireDebitNotePostCreate(debitNoteModel);
        return debitNoteModel;
    }

    private void fireDebitNotePostCreate(DebitNoteModel debitNote) {
        session.getOpenfactSessionFactory().publish(new DebitNoteModel.DebitNotePostCreateEvent() {
            @Override
            public DebitNoteModel getCreatedDebitNote() {
                return debitNote;
            }

            @Override
            public OpenfactSession getOpenfactSession() {
                return session;
            }
        });
    }

    public boolean removeDebitNote(OrganizationModel organization, DebitNoteModel debitNote) {
        if (model.removeDebitNote(organization, debitNote)) {
            return true;
        }
        return false;
    }

    public SendEventModel sendToCustomerParty(OrganizationModel organization, DebitNoteModel debitNote) throws SendException {
        return ublProvider.sender().sendToCustomer(organization, debitNote);
    }

    public SendEventModel sendToTrirdParty(OrganizationModel organization, DebitNoteModel debitNote) throws SendException {
        return ublProvider.sender().sendToThridParty(organization, debitNote);
    }

}
