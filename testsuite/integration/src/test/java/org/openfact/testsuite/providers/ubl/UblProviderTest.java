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
package org.openfact.testsuite.providers.ubl;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.openfact.models.OrganizationModel;
import org.openfact.models.ubl.CreditNoteModel;
import org.openfact.models.ubl.DebitNoteModel;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.representations.idm.OrganizationRepresentation;
import org.openfact.services.managers.OrganizationManager;
import org.openfact.testsuite.providers.AbstractProviderTest;
import org.openfact.ubl.UblDocumentProvider;
import org.w3c.dom.Document;

public class UblProviderTest extends AbstractProviderTest {

	protected OrganizationModel organization;

	@Before
	@Override
	public void before() throws Exception {
		super.before();
		OrganizationManager manager = organizationManager;
		OrganizationRepresentation rep = AbstractProviderTest.loadJson("model/testorganization2.json");
		rep.setId("TestUblProvider");
		organization = manager.importOrganization(rep);
	}

	@Test
	public void getInvoiceDocument() throws Exception {
		List<InvoiceModel> invoices = session.invoices().getInvoices(organization);
		InvoiceModel invoice = invoices.get(0);

		Set<UblDocumentProvider> providers = session.getAllProviders(UblDocumentProvider.class);
		for (UblDocumentProvider provider : providers) {
			Document xml = provider.getDocument(organization, invoice);
			// InvoiceType invoiceType = UBL21Reader.invoice().read(xml);
			// IErrorList resourceErrorGroup =
			// UBL21Validator.invoice().validate(invoiceType);

			assertThat(xml, is(notNullValue()));
			// assertThat(resourceErrorGroup.getAllErrors().getSize(), is(0));
		}
	}

	@Test
	public void getCreditNoteDocument() throws Exception {
		List<CreditNoteModel> creditNotes = session.creditNotes().getCreditNotes(organization);
		CreditNoteModel creditNote = creditNotes.get(0);

		Set<UblDocumentProvider> providers = session.getAllProviders(UblDocumentProvider.class);
		for (UblDocumentProvider provider : providers) {
			Document xml = provider.getDocument(organization, creditNote);
			// CreditNoteType creditNoteType =
			// UBL21Reader.creditNote().read(xml);
			// IErrorList resourceErrorGroup =
			// UBL21Validator.creditNote().validate(creditNoteType);

			assertThat(xml, is(notNullValue()));
			// assertThat(resourceErrorGroup.getAllErrors().getSize(), is(0));
		}
	}

	@Test
	public void getDebitNoteDocument() throws Exception {
		List<DebitNoteModel> debitNotes = session.debitNotes().getDebitNotes(organization);
		DebitNoteModel debitNote = debitNotes.get(0);

		Set<UblDocumentProvider> providers = session.getAllProviders(UblDocumentProvider.class);
		for (UblDocumentProvider provider : providers) {
			Document xml = provider.getDocument(organization, debitNote);
			// DebitNoteType debitNoteType = UBL21Reader.debitNote().read(xml);
			// IErrorList resourceErrorGroup =
			// UBL21Validator.debitNote().validate(debitNoteType);

			assertThat(xml, is(notNullValue()));
			// assertThat(resourceErrorGroup.getAllErrors().getSize(), is(0));
		}
	}

}
