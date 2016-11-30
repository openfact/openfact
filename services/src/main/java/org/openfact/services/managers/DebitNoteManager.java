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

import java.util.Map;

import javax.xml.transform.TransformerException;

import org.jboss.logging.Logger;
import org.openfact.common.converts.DocumentUtils;
import org.openfact.models.DebitNoteModel;
import org.openfact.models.DebitNoteProvider;
import org.openfact.models.ModelException;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.ubl.SendEventModel;
import org.openfact.models.enums.RequiredAction;
import org.openfact.models.utils.TypeToModel;
import org.openfact.ubl.SendException;
import org.openfact.ubl.SignerProvider;
import org.openfact.ubl.UBLDebitNoteProvider;
import org.w3c.dom.Document;

import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.IDType;
import oasis.names.specification.ubl.schema.xsd.debitnote_21.DebitNoteType;

public class DebitNoteManager {

    protected static final Logger logger = Logger.getLogger(DebitNoteManager.class);

    protected OpenfactSession session;
    protected DebitNoteProvider model;
    protected UBLDebitNoteProvider ubl;

    public DebitNoteManager(OpenfactSession session) {
        this.session = session;
        this.model = session.debitNotes();
        this.ubl = session.getProvider(UBLDebitNoteProvider.class);
    }

    public DebitNoteModel getDebitNoteByID(OrganizationModel organization, String ID) {
        return model.getDebitNoteByID(organization, ID);
    }

    public DebitNoteModel addDebitNote(OrganizationModel organization, DebitNoteType type,
            Map<String, String> attributes) {
        IDType documentId = type.getID();
        if (documentId == null) {
            String generatedId = ubl.idGenerator().generateID(organization, type);
            documentId = new IDType(generatedId);
            type.setID(documentId);
        }

        DebitNoteModel debitNote = model.addDebitNote(organization, documentId.getValue());
        for (Map.Entry<String, String> entry : attributes.entrySet()) {
            debitNote.setAttribute(entry.getKey(), entry.getValue());
        }

        TypeToModel.importDebitNote(session, organization, debitNote, type);
        RequiredAction.getDefaults().stream().forEach(c -> debitNote.addRequiredAction(c));

        try {
            // Generate Document
            Document baseDocument = ubl.writer().write(organization, type, attributes);

            // Sign Document
            SignerProvider signerProvider = session.getProvider(SignerProvider.class);
            Document signedDocument = signerProvider.sign(baseDocument, organization);

            byte[] bytes = DocumentUtils.getBytesFromDocument(signedDocument);
            debitNote.setXmlDocument(bytes);
        } catch (TransformerException e) {
            logger.error("Error parsing to byte XML", e);
            throw new ModelException(e);
        }

        return debitNote;
    }

    public boolean removeDebitNote(OrganizationModel organization, DebitNoteModel debitNote) {
        if (model.removeDebitNote(organization, debitNote)) {
            return true;
        }
        return false;
    }

    public SendEventModel sendToCustomerParty(OrganizationModel organization, DebitNoteModel debitNote)
            throws SendException {
        return ubl.sender().sendToCustomer(organization, debitNote);
    }

    public SendEventModel sendToTrirdParty(OrganizationModel organization, DebitNoteModel debitNote)
            throws SendException {
        return ubl.sender().sendToThridParty(organization, debitNote);
    }

}
