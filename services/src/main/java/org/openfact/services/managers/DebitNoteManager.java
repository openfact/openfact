/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
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
import org.openfact.models.enums.RequiredActionDocument;
import org.openfact.models.utils.TypeToModel;
import org.openfact.ubl.DebitNoteIDGeneratorProvider;
import org.openfact.ubl.DebitNoteReaderWriterProvider;
import org.openfact.ubl.SignerProvider;
import org.w3c.dom.Document;

import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.IDType;
import oasis.names.specification.ubl.schema.xsd.debitnote_21.DebitNoteType;

public class DebitNoteManager {

    protected static final Logger logger = Logger.getLogger(DebitNoteManager.class);

    protected OpenfactSession session;
    protected DebitNoteProvider model;

    public DebitNoteManager(OpenfactSession session) {
        this.session = session;
        this.model = session.debitNotes();
    }

    public DebitNoteModel getDebitNoteByID(OrganizationModel organization, String ID) {
        return model.getDebitNoteByID(organization, ID);
    }

    public DebitNoteModel addDebitNote(OrganizationModel organization, DebitNoteType type,
            Map<String, String> attributes) {
        IDType documentId = type.getID();
        if (documentId == null) {
            String generatedId = session.getProvider(DebitNoteIDGeneratorProvider.class)
                    .generateID(organization, type);
            documentId = new IDType(generatedId);
            type.setID(documentId);
        }

        DebitNoteModel debitNote = model.addDebitNote(organization, documentId.getValue());
        for (Map.Entry<String, String> entry : attributes.entrySet()) {
            debitNote.setAttribute(entry.getKey(), entry.getValue());
        }

        TypeToModel.importDebitNote(session, organization, debitNote, type);
        RequiredActionDocument.getDefaults().stream().forEach(c -> debitNote.addRequiredAction(c));

        try {
            // Generate Document
            DebitNoteReaderWriterProvider debitNoteReaderProvider = session
                    .getProvider(DebitNoteReaderWriterProvider.class);
            Document baseDocument = debitNoteReaderProvider.writeAsDocument(organization, type, attributes);

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

    public void sendToCustomerParty(OrganizationModel organization, DebitNoteModel debitNote) {
        // TODO Auto-generated method stub

    }

    public void sendToTrirdParty(OrganizationModel organization, DebitNoteModel debitNote) {
        // TODO Auto-generated method stub

    }

}
