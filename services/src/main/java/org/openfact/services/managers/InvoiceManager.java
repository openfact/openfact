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
import java.util.Map;

import javax.xml.transform.TransformerException;

import org.jboss.logging.Logger;
import org.openfact.common.converts.DocumentUtils;
import org.openfact.models.InvoiceModel;
import org.openfact.models.InvoiceProvider;
import org.openfact.models.ModelException;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.ubl.SendEventModel;
import org.openfact.models.enums.RequiredAction;
import org.openfact.models.utils.TypeToModel;
import org.openfact.ubl.SendException;
import org.openfact.ubl.SignerProvider;
import org.openfact.ubl.UBLInvoiceProvider;
import org.w3c.dom.Document;

import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.IDType;
import oasis.names.specification.ubl.schema.xsd.invoice_21.InvoiceType;

public class InvoiceManager {

    protected static final Logger logger = Logger.getLogger(DebitNoteManager.class);

    protected OpenfactSession session;
    protected InvoiceProvider model;
    protected UBLInvoiceProvider ubl;

    public InvoiceManager(OpenfactSession session) {
        this.session = session;
        this.model = session.invoices();
        this.ubl = session.getProvider(UBLInvoiceProvider.class);
    }

    public InvoiceModel getInvoiceByID(OrganizationModel organization, String ID) {
        return model.getInvoiceByDocumentId(organization, ID);
    }

    public InvoiceModel addInvoice(OrganizationModel organization, InvoiceType type, Map<String, List<String>> attributes) {
        IDType documentId = type.getID();
        if (documentId == null) {
            String generatedId = ubl.idGenerator().generateID(organization, type);
            documentId = new IDType(generatedId);
            type.setID(documentId);
        }

        InvoiceModel invoice = model.addInvoice(organization, documentId.getValue());
        for (Map.Entry<String, List<String>> entry : attributes.entrySet()) {
            invoice.setAttribute(entry.getKey(), entry.getValue());
        }

        TypeToModel.importInvoice(session, organization, invoice, type);
        RequiredAction.getDefaults().stream().forEach(c -> invoice.addRequiredAction(c));

        try {
            // Generate Document
            Document baseDocument = ubl.writer().write(organization, type, attributes);

            // Sign Document
            SignerProvider signerProvider = session.getProvider(SignerProvider.class);
            Document signedDocument = signerProvider.sign(baseDocument, organization);

            byte[] bytes = DocumentUtils.getBytesFromDocument(signedDocument);
            invoice.setXmlDocument(bytes);
        } catch (TransformerException e) {
            logger.error("Error parsing to byte XML", e);
            throw new ModelException(e);
        }

        fireInvoicePostCreate(invoice);
        return invoice;
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
        return ubl.sender().sendToCustomer(organization, invoice);
    }

    public SendEventModel sendToTrirdParty(OrganizationModel organization, InvoiceModel invoice) throws SendException {
        return ubl.sender().sendToThridParty(organization, invoice);
    }

}
