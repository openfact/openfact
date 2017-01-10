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

import com.google.common.collect.ImmutableMap;
import org.junit.Assert;
import org.junit.Test;
import org.openfact.models.InvoiceModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.enums.RequiredAction;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

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

	@Test
	public void testInvoiceRequiredActions() throws Exception {
		OrganizationModel organization = organizationManager.createOrganization("original");
		InvoiceModel invoice = session.invoices().addInvoice(organization, "invoice");

		Assert.assertTrue(invoice.getRequiredActions().isEmpty());

		invoice.addRequiredAction(RequiredAction.SEND_TO_CUSTOMER);
		String id = organization.getId();
		commit();
		organization = organizationManager.getOrganization(id);
		invoice = session.invoices().getInvoiceByDocumentId(organization, "invoice");

		Assert.assertEquals(1, invoice.getRequiredActions().size());
		Assert.assertTrue(invoice.getRequiredActions().contains(RequiredAction.SEND_TO_CUSTOMER.name()));

		invoice.addRequiredAction(RequiredAction.SEND_TO_CUSTOMER);
		invoice = session.invoices().getInvoiceByDocumentId(organization, "invoice");

		Assert.assertEquals(1, invoice.getRequiredActions().size());
		Assert.assertTrue(invoice.getRequiredActions().contains(RequiredAction.SEND_TO_CUSTOMER.name()));

		invoice.addRequiredAction(RequiredAction.SEND_TO_TRIRD_PARTY.name());
		invoice = session.invoices().getInvoiceByDocumentId(organization, "invoice");

		Assert.assertEquals(2, invoice.getRequiredActions().size());
		Assert.assertTrue(invoice.getRequiredActions().contains(RequiredAction.SEND_TO_CUSTOMER.name()));
		Assert.assertTrue(invoice.getRequiredActions().contains(RequiredAction.SEND_TO_TRIRD_PARTY.name()));

		invoice.removeRequiredAction(RequiredAction.SEND_TO_CUSTOMER.name());
		invoice = session.invoices().getInvoiceByDocumentId(organization, "invoice");

		Assert.assertEquals(1, invoice.getRequiredActions().size());
		Assert.assertTrue(invoice.getRequiredActions().contains(RequiredAction.SEND_TO_TRIRD_PARTY.name()));

		invoice.removeRequiredAction(RequiredAction.SEND_TO_TRIRD_PARTY.name());
		invoice = session.invoices().getInvoiceByDocumentId(organization, "invoice");

		Assert.assertTrue(invoice.getRequiredActions().isEmpty());
	}

	@Test
	public void testInvoiceMultipleAttributes() throws Exception {
		OrganizationModel organization = organizationManager.createOrganization("original");
		InvoiceModel invoice = session.invoices().addInvoice(organization, "invoice");
		InvoiceModel invoiceNoAttrs = session.invoices().addInvoice(organization, "invoice-noattrs");

		invoice.setSingleAttribute("key1", "value1");
		List<String> attrVals = new ArrayList<>(Arrays.asList( "val21", "val22" ));
		invoice.setAttribute("key2", attrVals);

		commit();

		// Test read attributes
		organization = organizationManager.getOrganizationByName("original");
		invoice = session.invoices().getInvoiceByDocumentId(organization, "invoice");

		attrVals = invoice.getAttribute("key1");
		Assert.assertEquals(1, attrVals.size());
		Assert.assertEquals("value1", attrVals.get(0));
		Assert.assertEquals("value1", invoice.getFirstAttribute("key1"));

		attrVals = invoice.getAttribute("key2");
		Assert.assertEquals(2, attrVals.size());
		Assert.assertTrue(attrVals.contains("val21"));
		Assert.assertTrue(attrVals.contains("val22"));

		attrVals = invoice.getAttribute("key3");
		Assert.assertTrue(attrVals.isEmpty());
		Assert.assertNull(invoice.getFirstAttribute("key3"));

		Map<String, List<String>> allAttrVals = invoice.getAttributes();
		Assert.assertEquals(2, allAttrVals.size());
		Assert.assertEquals(allAttrVals.get("key1"), invoice.getAttribute("key1"));
		Assert.assertEquals(allAttrVals.get("key2"), invoice.getAttribute("key2"));

		// Test remove and rewrite attribute
		invoice.removeAttribute("key1");
		invoice.setSingleAttribute("key2", "val23");

		commit();

		organization = organizationManager.getOrganizationByName("original");
		invoice = session.invoices().getInvoiceByDocumentId(organization, "invoice");
		Assert.assertNull(invoice.getFirstAttribute("key1"));
		attrVals = invoice.getAttribute("key2");
		Assert.assertEquals(1, attrVals.size());
		Assert.assertEquals("val23", attrVals.get(0));
	}

	@Test
	public void testUpdateInvoiceAttribute() throws Exception {
		OrganizationModel organization = organizationManager.createOrganization("original");
		InvoiceModel invoice = session.invoices().addInvoice(organization, "invoice");

		invoice.setSingleAttribute("key1", "value1");

		commit();

		organization = organizationManager.getOrganizationByName("original");
		invoice = session.invoices().getInvoiceByDocumentId(organization, "invoice");

		// Update attribute
		List<String> attrVals = new ArrayList<>(Arrays.asList( "val2" ));
		invoice.setAttribute("key1", attrVals);
		Map<String, List<String>> allAttrVals = invoice.getAttributes();

		// Ensure same transaction is able to see updated value
		Assert.assertEquals(1, allAttrVals.size());
		Assert.assertEquals(allAttrVals.get("key1"), Arrays.asList("val2"));

		commit();
	}

	@Test
	public void testUpdateInvoiceSingleAttribute() {
		Map<String, List<String>> expected = ImmutableMap.of(
				"key1", Arrays.asList("value3"),
				"key2", Arrays.asList("value2"));

		OrganizationModel organization = organizationManager.createOrganization("original");
		InvoiceModel invoice = session.invoices().addInvoice(organization, "invoice");

		invoice.setSingleAttribute("key1", "value1");
		invoice.setSingleAttribute("key2", "value2");

		// Overwrite the first attribute
		invoice.setSingleAttribute("key1", "value3");

		Assert.assertEquals(expected, invoice.getAttributes());

		commit();

		organization = session.organizations().getOrganizationByName("original");
		Assert.assertEquals(expected, session.invoices().getInvoiceByDocumentId(organization, "invoice").getAttributes());
	}

	@Test
	public void testSearchByString() {
		OrganizationModel organization = organizationManager.createOrganization("original");
		InvoiceModel invoice1 = session.invoices().addInvoice(organization, "invoice1");

		commit();
		organization = session.organizations().getOrganizationByName("original");
		List<InvoiceModel> invoices = session.invoices().searchForInvoice(organization, "invoice", 0, 7);
		Assert.assertTrue(invoices.contains(invoice1));
	}

	@Test
	public void testSearchByInvoiceAttribute() throws Exception {
		OrganizationModel realm = organizationManager.createOrganization("original");
		InvoiceModel invoice1 = session.invoices().addInvoice(realm, "invoice1");
		InvoiceModel invoice2 = session.invoices().addInvoice(realm, "invoice2");
		InvoiceModel invoice3 = session.invoices().addInvoice(realm, "invoice3");

		invoice1.setSingleAttribute("key1", "value1");
		invoice1.setSingleAttribute("key2", "value21");

		invoice2.setSingleAttribute("key1", "value1");
		invoice2.setSingleAttribute("key2", "value22");

		invoice3.setSingleAttribute("key2", "value21");

		commit();
		realm = session.organizations().getOrganizationByName("original");

		List<InvoiceModel> invoices = session.invoices().searchForInvoiceByInvoiceAttribute("key1", "value1", realm);
		Assert.assertEquals(2, invoices.size());
		Assert.assertTrue(invoices.contains(invoice1));
		Assert.assertTrue(invoices.contains(invoice2));

		invoices = session.invoices().searchForInvoiceByInvoiceAttribute("key2", "value21", realm);
		Assert.assertEquals(2, invoices.size());
		Assert.assertTrue(invoices.contains(invoice1));
		Assert.assertTrue(invoices.contains(invoice3));

		invoices = session.invoices().searchForInvoiceByInvoiceAttribute("key2", "value22", realm);
		Assert.assertEquals(1, invoices.size());
		Assert.assertTrue(invoices.contains(invoice2));

		invoices = session.invoices().searchForInvoiceByInvoiceAttribute("key3", "value3", realm);
		Assert.assertEquals(0, invoices.size());
	}

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
