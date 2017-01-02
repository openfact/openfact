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

package org.openfact.testsuite.model;

import org.junit.Assert;
import org.junit.Test;
import org.openfact.models.InvoiceModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.enums.RequiredAction;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;

import static org.junit.Assert.assertNotNull;

/**
 * @author <a href="mailto:carlosthe19916@sistcoop.com">Carlos Feria</a>
 */
public class InvoiceModelTest extends AbstractModelTest {

	@Test
	public void persistInvoice() {
		OrganizationModel organization = organizationManager.createOrganization("original");
		OpenfactSession session = organizationManager.getSession();
		InvoiceModel invoice = session.invoices().addInvoice(organization, "invoice");
		invoice.setDocumentCurrencyCode("PEN");
		invoice.setIssueDateTime(LocalDateTime.now());
		assertNotNull(invoice.getCreatedTimestamp());
		// test that timestamp is current with 10s tollerance
		Assert.assertTrue((System.currentTimeMillis() - Date.from(invoice.getCreatedTimestamp().atZone(ZoneId.systemDefault()).toInstant()).getTime()) < 10000);

		invoice.addRequiredAction(RequiredAction.SEND_TO_CUSTOMER);
		invoice.addRequiredAction(RequiredAction.SEND_TO_TRIRD_PARTY);

		OrganizationModel searchOrganization = organizationManager.getOrganization(organization.getId());
		InvoiceModel persisted = session.invoices().getInvoiceByDocumentId(searchOrganization, "invoice");

		assertEquals(invoice, persisted);

		searchOrganization = organizationManager.getOrganization(organization.getId());
		InvoiceModel persisted2 =  session.invoices().getInvoiceById(searchOrganization, invoice.getId());
		assertEquals(invoice, persisted2);
	}

	/*@Test
	public void testSearchByString() {
		OrganizationModel organization = organizationManager.createOrganization("original");
		InvoiceModel invoice1 = session.invoices().addInvoice(organization, "invoice1");

		commit();
		organization = session.organizations().getOrganizationByName("original");
		List<InvoiceModel> invoices = session.invoices().searchForInvoice(organization, "invoice", 0, 7);
		Assert.assertTrue(invoices.contains(invoice1));
	}*/

	public static void assertEquals(InvoiceModel expected, InvoiceModel actual) {
		Assert.assertEquals(expected.getDocumentId(), actual.getDocumentId());
		Assert.assertEquals(expected.getCreatedTimestamp(), actual.getCreatedTimestamp());
		Assert.assertEquals(expected.getDocumentCurrencyCode(), actual.getDocumentCurrencyCode());
		Assert.assertEquals(expected.getIssueDateTime(), actual.getIssueDateTime());

		String[] expectedRequiredActions = expected.getRequiredActions().toArray(new String[expected.getRequiredActions().size()]);
		Arrays.sort(expectedRequiredActions);
		String[] actualRequiredActions = actual.getRequiredActions().toArray(new String[actual.getRequiredActions().size()]);
		Arrays.sort(actualRequiredActions);

		Assert.assertArrayEquals(expectedRequiredActions, actualRequiredActions);
	}

}
