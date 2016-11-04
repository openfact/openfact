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

import java.util.List;
import java.util.stream.Collectors;

import javax.xml.transform.TransformerException;

import org.apache.commons.lang.ArrayUtils;
import org.jboss.logging.Logger;
import org.openfact.common.converts.DocumentUtils;
import org.openfact.models.ModelException;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.enums.UblDocumentType;
import org.openfact.models.ubl.DebitNoteModel;
import org.openfact.models.ubl.provider.DebitNoteProvider;
import org.openfact.models.utils.RepresentationToModel;
import org.openfact.representations.idm.ubl.DebitNoteRepresentation;
import org.openfact.ubl.UblDocumentProvider;
import org.openfact.ubl.UblDocumentSignerProvider;
import org.openfact.ubl.UblExtensionContentGeneratorProvider;
import org.openfact.ubl.UblIDGeneratorProvider;
import org.w3c.dom.Document;

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

    public DebitNoteModel addDebitNote(OrganizationModel organization, DebitNoteRepresentation rep) {
        String ID = rep.getIdUbl();
        if (ID == null) {
            List<String> referencesID = rep.getDiscrepancyResponse().stream().map(f -> f.getReferenceID()).collect(Collectors.toList());
            
            UblIDGeneratorProvider provider = session.getProvider(UblIDGeneratorProvider.class);            
            ID = provider.generateDebitNoteID(organization, referencesID.toArray(new String[referencesID.size()]));
        }
        DebitNoteModel debitNote = model.addDebitNote(organization, ID);

        RepresentationToModel.importDebitNote(session, organization, debitNote, rep);
        
        // Generate extensions
        UblExtensionContentGeneratorProvider extensionContentProvider = session.getProvider(UblExtensionContentGeneratorProvider.class);
        if(extensionContentProvider != null) {
            extensionContentProvider.generateUBLExtensions(organization, debitNote);
        }
        
        // Generate Document from debit note
        UblDocumentProvider documentProvider = session.getProvider(UblDocumentProvider.class);
        Document baseDocument = documentProvider.getDocument(organization, debitNote);
        
        // Sign Document
        Document signedDocument = null;
        UblDocumentSignerProvider signerProvider = session.getProvider(UblDocumentSignerProvider.class);
        if(signerProvider != null) {
            signedDocument = signerProvider.sign(baseDocument, UblDocumentType.DEBIT_NOTE, organization);
        }
        
        try {
            byte[] bytes = DocumentUtils.getBytesFromDocument(signedDocument != null ? signedDocument: baseDocument);
            debitNote.setXmlDocument(ArrayUtils.toObject(bytes));
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

}
