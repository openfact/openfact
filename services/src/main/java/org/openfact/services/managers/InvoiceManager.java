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
import org.openfact.models.InvoiceModel;
import org.openfact.models.InvoiceProvider;
import org.openfact.models.ModelException;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.SendEventModel;
import org.openfact.models.enums.RequiredAction;
import org.openfact.models.utils.TypeToModel;
import org.openfact.models.SendException;
import org.openfact.ubl.SignerProvider;
import org.openfact.ubl.UBLInvoiceProvider;
import org.w3c.dom.Document;

import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.IDType;
import oasis.names.specification.ubl.schema.xsd.invoice_21.InvoiceType;

public class InvoiceManager {

    protected static final Logger logger = Logger.getLogger(DebitNoteManager.class);

    protected OpenfactSession session;
    protected InvoiceProvider model;
    protected UBLInvoiceProvider ublProvider;

    public InvoiceManager(OpenfactSession session) {
        this.session = session;
        this.model = session.invoices();
        this.ublProvider = session.getProvider(UBLInvoiceProvider.class);
    }

    public InvoiceModel getInvoiceByDocumentId(OrganizationModel organization, String documentId) {
        return model.getInvoiceByDocumentId(organization, documentId);
    }

    public InvoiceModel addInvoice(OrganizationModel organization, InvoiceType invoiceType, Map<String, List<String>> attributes) {
        // Model persist
        IDType documentId = invoiceType.getID();
        if (documentId == null) {
            String newDocumentId = ublProvider.idGenerator().generateID(organization, invoiceType);
            documentId = new IDType(newDocumentId);
            invoiceType.setID(documentId);
        }
        InvoiceModel invoiceModel = model.addInvoice(organization, documentId.getValue());

        // Attributes
        for (Map.Entry<String, List<String>> entry : attributes.entrySet()) {
            invoiceModel.setAttribute(entry.getKey(), entry.getValue());
        }

        // Type to Model
        TypeToModel.importInvoice(session, organization, invoiceModel, invoiceType);

        // Required actions
        Arrays.stream(RequiredAction.values()).forEach(c -> invoiceModel.addRequiredAction(c));

        try {
            // Generate Document
            Document baseDocument = ublProvider.writer().write(organization, invoiceType, attributes);
            Document signedDocument = session.getProvider(SignerProvider.class).sign(baseDocument, organization);
            byte[] signedDocumentBytes = DocumentUtils.getBytesFromDocument(signedDocument);

            // File
            FileModel xmlFile = session.getProvider(FileProvider.class).createFile(organization, invoiceModel.getDocumentId() + ".xml", signedDocumentBytes);
            invoiceModel.attachXmlFile(xmlFile);
        } catch (TransformerException e) {
            logger.error("Error parsing XML to byte", e);
            throw new ModelException(e);
        }

        fireInvoicePostCreate(invoiceModel);
        return invoiceModel;
    }

    private void fireInvoicePostCreate(InvoiceModel invoice) {
        session.getOpenfactSessionFactory().publish(new InvoiceModel.InvoicePostCreateEvent() {
            @Override
            public InvoiceModel getCreatedInvoice() {
                return invoice;
            }

            @Override
            public OpenfactSession getOpenfactSession() {
                return session;
            }
        });
    }

    public boolean removeInvoice(OrganizationModel organization, InvoiceModel invoice) {
        if (model.removeInvoice(organization, invoice)) {
            return true;
        }
        return false;
    }

    public SendEventModel sendToCustomerParty(OrganizationModel organization, InvoiceModel invoice) throws SendException {
        return sendToCustomerParty(organization, invoice, null);
    }

    public SendEventModel sendToCustomerParty(OrganizationModel organization, InvoiceModel invoice, SendEventModel sendEvent) throws SendException {
        if(sendEvent == null) {
            return ublProvider.sender().sendToCustomer(organization, invoice);
        } else {
            return ublProvider.sender().sendToCustomer(organization, invoice, sendEvent);
        }
    }

    public SendEventModel sendToTrirdParty(OrganizationModel organization, InvoiceModel invoice) throws SendException {
        return sendToTrirdParty(organization, invoice, null);
    }

    public SendEventModel sendToTrirdParty(OrganizationModel organization, InvoiceModel invoice, SendEventModel sendEvent) throws SendException {
        if(sendEvent == null) {
            return ublProvider.sender().sendToThridParty(organization, invoice);
        } else {
            return ublProvider.sender().sendToThridParty(organization, invoice, sendEvent);
        }
    }

}
