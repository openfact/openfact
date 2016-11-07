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

import org.apache.commons.lang.ArrayUtils;
import org.jboss.logging.Logger;
import org.openfact.common.converts.DocumentUtils;
import org.openfact.email.EmailException;
import org.openfact.email.EmailTemplateProvider;
import org.openfact.models.ModelException;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.UserSenderModel;
import org.openfact.models.enums.RequeridActionDocument;
import org.openfact.models.enums.UblDocumentType;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.models.ubl.provider.InvoiceProvider;
import org.openfact.models.utils.RepresentationToModel;
import org.openfact.representations.idm.ubl.InvoiceRepresentation;
import org.openfact.ubl.UblDocumentProvider;
import org.openfact.ubl.UblDocumentSignerProvider;
import org.openfact.ubl.UblExtensionContentGeneratorProvider;
import org.openfact.ubl.UblIDGeneratorProvider;
import org.w3c.dom.Document;

public class InvoiceManager {

	protected static final Logger logger = Logger.getLogger(DebitNoteManager.class);

	protected OpenfactSession session;
	protected InvoiceProvider model;

	public InvoiceManager(OpenfactSession session) {
		this.session = session;
		this.model = session.invoices();
	}

	public InvoiceModel getInvoiceByID(OrganizationModel organization, String ID) {
		return model.getInvoiceByID(organization, ID);
	}

	public InvoiceModel addInvoice(OrganizationModel organization, InvoiceRepresentation rep) {
		String ID = rep.getIdUbl();
		if (ID == null) {
			UblIDGeneratorProvider provider = session.getProvider(UblIDGeneratorProvider.class);
			ID = provider.generateInvoiceID(organization, rep.getInvoiceTypeCode());
		}
		InvoiceModel invoice = model.addInvoice(organization, ID);

		RepresentationToModel.importInvoice(session, organization, invoice, rep);

		// Generate extensions
		UblExtensionContentGeneratorProvider extensionContentProvider = session
				.getProvider(UblExtensionContentGeneratorProvider.class);
		if (extensionContentProvider != null) {
			extensionContentProvider.generateUBLExtensions(organization, invoice);
		}

		// Generate Document from Invoice
		UblDocumentProvider documentProvider = session.getProvider(UblDocumentProvider.class);
		Document baseDocument = documentProvider.getDocument(organization, invoice);

		// Sign Document
		Document signedDocument = null;
		UblDocumentSignerProvider signerProvider = session.getProvider(UblDocumentSignerProvider.class);
		if (signerProvider != null) {
			signedDocument = signerProvider.sign(baseDocument, UblDocumentType.INVOICE, organization);
		}

		try {
			byte[] bytes = DocumentUtils.getBytesFromDocument(signedDocument != null ? signedDocument : baseDocument);
			invoice.setXmlDocument(ArrayUtils.toObject(bytes));
			if (rep.isSendImmediately()) {

				UserSenderModel user = new UserSenderModel() {
					@Override
					public String getLastName() {
						return invoice.getAccountingCustomerParty().getParty().getPartyName().get(0);
					}

					@Override
					public String getFullName() {
						return null;
					}

					@Override
					public String getFirstName() {
						return null;
					}

					@Override
					public String getEmail() {
						return invoice.getAccountingCustomerParty().getAccountingContact().getElectronicMail();
					}

					@Override
					public Map<String, Object> getAttributes() {
						return null;
					}
				};
				session.getProvider(EmailTemplateProvider.class).setUser(user).sendInvoice(invoice);
				invoice.removeRequeridAction(RequeridActionDocument.SEND_EMAIL_CUSTOMER);
			}
		} catch (TransformerException e) {
			logger.error("Error parsing to byte XML", e);
			throw new ModelException(e);
		} catch (EmailException e) {
			logger.error("Error sending email of invoice", e);
			throw new ModelException(e);
		}

		return invoice;
	}

	public boolean removeInvoice(OrganizationModel organization, InvoiceModel invoice) {
		if (model.removeInvoice(organization, invoice)) {
			return true;
		}
		return false;
	}

}
