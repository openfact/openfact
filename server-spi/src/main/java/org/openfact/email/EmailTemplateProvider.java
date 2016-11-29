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

package org.openfact.email;

import java.util.List;
import java.util.Map;

import org.openfact.events.Event;
import org.openfact.models.CreditNoteModel;
import org.openfact.models.DebitNoteModel;
import org.openfact.models.FileModel;
import org.openfact.models.InvoiceModel;
import org.openfact.models.OrganizationModel;
import org.openfact.models.UserSenderModel;
import org.openfact.provider.Provider;

/**
 * @author <a href="mailto:carlosthe19916@sistcoop.com">Carlos Feria</a>
 */
public interface EmailTemplateProvider extends Provider {

	String IDENTITY_PROVIDER_BROKER_CONTEXT = "identityProviderBrokerCtx";

	public EmailTemplateProvider setOrganization(OrganizationModel organization);

	public EmailTemplateProvider setUser(UserSenderModel user);

	public EmailTemplateProvider setAttribute(String name, Object value);
	
	public EmailTemplateProvider setAttachments(List<FileModel> files);

	public void sendEvent(Event event) throws EmailException;
	
	void send(String subjectKey, String template, Map<String, Object> attributes) throws EmailException;

	public void sendInvoice(InvoiceModel invoice) throws EmailException ;

	public void sendCreditNote(CreditNoteModel creditNote) throws EmailException ;

	public void sendDebitNote(DebitNoteModel debitNote) throws EmailException ;

}
