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
import java.util.stream.Collectors;

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
import org.openfact.models.ubl.CreditNoteModel;
import org.openfact.models.ubl.provider.CreditNoteProvider;
import org.openfact.models.utils.RepresentationToModel;
import org.openfact.representations.idm.ubl.CreditNoteRepresentation;
import org.openfact.ubl.UblDocumentProvider;
import org.openfact.ubl.UblDocumentSignerProvider;
import org.openfact.ubl.UblExtensionContentGeneratorProvider;
import org.openfact.ubl.UblIDGeneratorProvider;
import org.w3c.dom.Document;

public class CreditNoteManager {

	protected static final Logger logger = Logger.getLogger(CreditNoteManager.class);

	protected OpenfactSession session;
	protected CreditNoteProvider model;

	public CreditNoteManager(OpenfactSession session) {
		this.session = session;
		this.model = session.creditNotes();
	}

	public CreditNoteModel getCreditNoteByID(OrganizationModel organization, String ID) {
		return model.getCreditNoteByID(organization, ID);
	}

	public CreditNoteModel addCreditNote(OrganizationModel organization, CreditNoteRepresentation rep) {
		String ID = rep.getIdUbl();
		if (ID == null) {
			List<String> referencesID = rep.getDiscrepancyResponse().stream().map(f -> f.getReferenceID())
					.collect(Collectors.toList());

			UblIDGeneratorProvider provider = session.getProvider(UblIDGeneratorProvider.class);
			ID = provider.generateCreditNoteID(organization, referencesID.toArray(new String[referencesID.size()]));
		}
		CreditNoteModel creditNote = model.addCreditNote(organization, ID);

		RepresentationToModel.importCreditNote(session, organization, creditNote, rep);

		// Generate extensions
		UblExtensionContentGeneratorProvider extensionContentProvider = session
				.getProvider(UblExtensionContentGeneratorProvider.class);
		if (extensionContentProvider != null) {
			extensionContentProvider.generateUBLExtensions(organization, creditNote);
		}

		// Generate Document from credit note
		UblDocumentProvider documentProvider = session.getProvider(UblDocumentProvider.class);
		Document baseDocument = documentProvider.getDocument(organization, creditNote);

		// Sign Document
		Document signedDocument = null;
		UblDocumentSignerProvider signerProvider = session.getProvider(UblDocumentSignerProvider.class);
		if (signerProvider != null) {
			signedDocument = signerProvider.sign(baseDocument, UblDocumentType.CREDIT_NOTE, organization);
		}

		try {
			byte[] bytes = DocumentUtils.getBytesFromDocument(signedDocument != null ? signedDocument : baseDocument);
			creditNote.setXmlDocument(ArrayUtils.toObject(bytes));
			if (rep.isSendImmediately()) {

				UserSenderModel user = new UserSenderModel() {
					@Override
					public String getLastName() {
						return creditNote.getAccountingCustomerParty().getParty().getPartyName().get(0);
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
						return creditNote.getAccountingCustomerParty().getAccountingContact().getElectronicMail();
					}

					@Override
					public Map<String, Object> getAttributes() {
						return null;
					}
				};
				session.getProvider(EmailTemplateProvider.class).setUser(user).sendCreditNote(creditNote);
				creditNote.removeRequeridAction(RequeridActionDocument.SEND_EMAIL_CUSTOMER);
			}
		} catch (TransformerException e) {
			logger.error("Error parsing to byte XML", e);
			throw new ModelException(e);
		} catch (EmailException e) {
			logger.error("Error sending email of credit note", e);
			throw new ModelException(e);
		}

		return creditNote;
	}

	public boolean removeCreditNote(OrganizationModel organization, CreditNoteModel creditNote) {
		if (model.removeCreditNote(organization, creditNote)) {
			return true;
		}
		return false;
	}

}
