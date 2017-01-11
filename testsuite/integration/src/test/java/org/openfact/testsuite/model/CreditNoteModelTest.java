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
import org.openfact.file.FileModel;
import org.openfact.file.FileProvider;
import org.openfact.models.*;
import org.openfact.models.CreditNoteModel;
import org.openfact.models.enums.DestinyType;
import org.openfact.models.enums.DocumentType;
import org.openfact.models.enums.RequiredAction;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

import static org.junit.Assert.assertNotNull;

/**
 * @author <a href="mailto:carlosthe19916@sistcoop.com">Carlos Feria</a>
 */
public class CreditNoteModelTest extends AbstractModelTest {

	@Test
	public void persistCreditNote() {
		OrganizationModel organization = organizationManager.createOrganization("original");
		OpenfactSession session = organizationManager.getSession();
		CreditNoteModel creditNote = session.creditNotes().addCreditNote(organization, "creditNote");
		creditNote.setDocumentCurrencyCode("PEN");
		creditNote.setIssueDateTime(LocalDateTime.now());
		assertNotNull(creditNote.getCreatedTimestamp());

		// test that timestamp is current with 10s tollerance
		Assert.assertTrue((System.currentTimeMillis() - Date.from(creditNote.getCreatedTimestamp().atZone(ZoneId.systemDefault()).toInstant()).getTime()) < 10000);

		creditNote.addRequiredAction(RequiredAction.SEND_TO_CUSTOMER);
		creditNote.addRequiredAction(RequiredAction.SEND_TO_TRIRD_PARTY);

		OrganizationModel searchOrganization = organizationManager.getOrganization(organization.getId());
		CreditNoteModel persisted = session.creditNotes().getCreditNoteByDocumentId(searchOrganization, "creditNote");

		assertEquals(creditNote, persisted);

		searchOrganization = organizationManager.getOrganization(organization.getId());
		CreditNoteModel persisted2 =  session.creditNotes().getCreditNoteById(searchOrganization, creditNote.getId());
		assertEquals(creditNote, persisted2);
	}

	@Test
	public void testCreditNoteRequiredActions() throws Exception {
		OrganizationModel organization = organizationManager.createOrganization("original");
		CreditNoteModel creditNote = session.creditNotes().addCreditNote(organization, "creditNote");

		Assert.assertTrue(creditNote.getRequiredActions().isEmpty());

		creditNote.addRequiredAction(RequiredAction.SEND_TO_CUSTOMER);
		String id = organization.getId();
		commit();
		organization = organizationManager.getOrganization(id);
		creditNote = session.creditNotes().getCreditNoteByDocumentId(organization, "creditNote");

		Assert.assertEquals(1, creditNote.getRequiredActions().size());
		Assert.assertTrue(creditNote.getRequiredActions().contains(RequiredAction.SEND_TO_CUSTOMER.name()));

		creditNote.addRequiredAction(RequiredAction.SEND_TO_CUSTOMER);
		creditNote = session.creditNotes().getCreditNoteByDocumentId(organization, "creditNote");

		Assert.assertEquals(1, creditNote.getRequiredActions().size());
		Assert.assertTrue(creditNote.getRequiredActions().contains(RequiredAction.SEND_TO_CUSTOMER.name()));

		creditNote.addRequiredAction(RequiredAction.SEND_TO_TRIRD_PARTY.name());
		creditNote = session.creditNotes().getCreditNoteByDocumentId(organization, "creditNote");

		Assert.assertEquals(2, creditNote.getRequiredActions().size());
		Assert.assertTrue(creditNote.getRequiredActions().contains(RequiredAction.SEND_TO_CUSTOMER.name()));
		Assert.assertTrue(creditNote.getRequiredActions().contains(RequiredAction.SEND_TO_TRIRD_PARTY.name()));

		creditNote.removeRequiredAction(RequiredAction.SEND_TO_CUSTOMER.name());
		creditNote = session.creditNotes().getCreditNoteByDocumentId(organization, "creditNote");

		Assert.assertEquals(1, creditNote.getRequiredActions().size());
		Assert.assertTrue(creditNote.getRequiredActions().contains(RequiredAction.SEND_TO_TRIRD_PARTY.name()));

		creditNote.removeRequiredAction(RequiredAction.SEND_TO_TRIRD_PARTY.name());
		creditNote = session.creditNotes().getCreditNoteByDocumentId(organization, "creditNote");

		Assert.assertTrue(creditNote.getRequiredActions().isEmpty());
	}

	@Test
	public void testCreditNoteMultipleAttributes() throws Exception {
		OrganizationModel organization = organizationManager.createOrganization("original");
		CreditNoteModel creditNote = session.creditNotes().addCreditNote(organization, "creditNote");
		CreditNoteModel creditNoteNoAttrs = session.creditNotes().addCreditNote(organization, "creditNote-noattrs");

		creditNote.setSingleAttribute("key1", "value1");
		List<String> attrVals = new ArrayList<>(Arrays.asList( "val21", "val22" ));
		creditNote.setAttribute("key2", attrVals);

		commit();

		// Test read attributes
		organization = organizationManager.getOrganizationByName("original");
		creditNote = session.creditNotes().getCreditNoteByDocumentId(organization, "creditNote");

		attrVals = creditNote.getAttribute("key1");
		Assert.assertEquals(1, attrVals.size());
		Assert.assertEquals("value1", attrVals.get(0));
		Assert.assertEquals("value1", creditNote.getFirstAttribute("key1"));

		attrVals = creditNote.getAttribute("key2");
		Assert.assertEquals(2, attrVals.size());
		Assert.assertTrue(attrVals.contains("val21"));
		Assert.assertTrue(attrVals.contains("val22"));

		attrVals = creditNote.getAttribute("key3");
		Assert.assertTrue(attrVals.isEmpty());
		Assert.assertNull(creditNote.getFirstAttribute("key3"));

		Map<String, List<String>> allAttrVals = creditNote.getAttributes();
		Assert.assertEquals(2, allAttrVals.size());
		Assert.assertEquals(allAttrVals.get("key1"), creditNote.getAttribute("key1"));
		Assert.assertEquals(allAttrVals.get("key2"), creditNote.getAttribute("key2"));

		// Test remove and rewrite attribute
		creditNote.removeAttribute("key1");
		creditNote.setSingleAttribute("key2", "val23");

		commit();

		organization = organizationManager.getOrganizationByName("original");
		creditNote = session.creditNotes().getCreditNoteByDocumentId(organization, "creditNote");
		Assert.assertNull(creditNote.getFirstAttribute("key1"));
		attrVals = creditNote.getAttribute("key2");
		Assert.assertEquals(1, attrVals.size());
		Assert.assertEquals("val23", attrVals.get(0));
	}

	@Test
	public void testUpdateCreditNoteAttribute() throws Exception {
		OrganizationModel organization = organizationManager.createOrganization("original");
		CreditNoteModel creditNote = session.creditNotes().addCreditNote(organization, "creditNote");

		creditNote.setSingleAttribute("key1", "value1");

		commit();

		organization = organizationManager.getOrganizationByName("original");
		creditNote = session.creditNotes().getCreditNoteByDocumentId(organization, "creditNote");

		// Update attribute
		List<String> attrVals = new ArrayList<>(Arrays.asList( "val2" ));
		creditNote.setAttribute("key1", attrVals);
		Map<String, List<String>> allAttrVals = creditNote.getAttributes();

		// Ensure same transaction is able to see updated value
		Assert.assertEquals(1, allAttrVals.size());
		Assert.assertEquals(allAttrVals.get("key1"), Arrays.asList("val2"));

		commit();
	}

	@Test
	public void testUpdateCreditNoteSingleAttribute() {
		Map<String, List<String>> expected = ImmutableMap.of(
				"key1", Arrays.asList("value3"),
				"key2", Arrays.asList("value2"));

		OrganizationModel organization = organizationManager.createOrganization("original");
		CreditNoteModel creditNote = session.creditNotes().addCreditNote(organization, "creditNote");

		creditNote.setSingleAttribute("key1", "value1");
		creditNote.setSingleAttribute("key2", "value2");

		// Overwrite the first attribute
		creditNote.setSingleAttribute("key1", "value3");

		Assert.assertEquals(expected, creditNote.getAttributes());

		commit();

		organization = session.organizations().getOrganizationByName("original");
		Assert.assertEquals(expected, session.creditNotes().getCreditNoteByDocumentId(organization, "creditNote").getAttributes());
	}

	@Test
	public void testSearchByString() {
		OrganizationModel organization = organizationManager.createOrganization("original");
		CreditNoteModel creditNote1 = session.creditNotes().addCreditNote(organization, "creditNote1");

		commit();
		organization = session.organizations().getOrganizationByName("original");
		List<CreditNoteModel> creditNotes = session.creditNotes().searchForCreditNote(organization, "creditNote", 0, 7);
		Assert.assertTrue(creditNotes.contains(creditNote1));
	}

	@Test
	public void testSearchByCreditNoteAttribute() throws Exception {
		OrganizationModel realm = organizationManager.createOrganization("original");
		CreditNoteModel creditNote1 = session.creditNotes().addCreditNote(realm, "creditNote1");
		CreditNoteModel creditNote2 = session.creditNotes().addCreditNote(realm, "creditNote2");
		CreditNoteModel creditNote3 = session.creditNotes().addCreditNote(realm, "creditNote3");

		creditNote1.setSingleAttribute("key1", "value1");
		creditNote1.setSingleAttribute("key2", "value21");

		creditNote2.setSingleAttribute("key1", "value1");
		creditNote2.setSingleAttribute("key2", "value22");

		creditNote3.setSingleAttribute("key2", "value21");

		commit();
		realm = session.organizations().getOrganizationByName("original");

		List<CreditNoteModel> creditNotes = session.creditNotes().searchForCreditNoteByAttribute("key1", "value1", realm);
		Assert.assertEquals(2, creditNotes.size());
		Assert.assertTrue(creditNotes.contains(creditNote1));
		Assert.assertTrue(creditNotes.contains(creditNote2));

		creditNotes = session.creditNotes().searchForCreditNoteByAttribute("key2", "value21", realm);
		Assert.assertEquals(2, creditNotes.size());
		Assert.assertTrue(creditNotes.contains(creditNote1));
		Assert.assertTrue(creditNotes.contains(creditNote3));

		creditNotes = session.creditNotes().searchForCreditNoteByAttribute("key2", "value22", realm);
		Assert.assertEquals(1, creditNotes.size());
		Assert.assertTrue(creditNotes.contains(creditNote2));

		creditNotes = session.creditNotes().searchForCreditNoteByAttribute("key3", "value3", realm);
		Assert.assertEquals(0, creditNotes.size());
	}

	@Test
	public void testCreditNoteSendEvent() {
		OrganizationModel organization = organizationManager.createOrganization("original");
		CreditNoteModel creditNote = session.creditNotes().addCreditNote(organization, "creditNote");

		Assert.assertTrue(creditNote.getSendEvents().isEmpty());

		SendEventModel sendEvent1 = creditNote.addSendEvent(DestinyType.CUSTOMER);
		String id = organization.getId();
		commit();
		organization = organizationManager.getOrganization(id);
		creditNote = session.creditNotes().getCreditNoteByDocumentId(organization, "creditNote");

		Assert.assertEquals(1, creditNote.getSendEvents().size());
		Assert.assertTrue(creditNote.getSendEvents().contains(sendEvent1));
		Assert.assertTrue(sendEvent1.getDestityType().equals(DestinyType.CUSTOMER));

		SendEventModel sendEvent2 = creditNote.addSendEvent(DestinyType.THIRD_PARTY);
		creditNote = session.creditNotes().getCreditNoteByDocumentId(organization, "creditNote");
		Assert.assertTrue(sendEvent2.getDestityType().equals(DestinyType.THIRD_PARTY));

		Assert.assertEquals(2, creditNote.getSendEvents().size());
		Assert.assertTrue(creditNote.getSendEvents().contains(sendEvent2));

		creditNote.removeSendEvent(sendEvent1);
		creditNote = session.creditNotes().getCreditNoteByDocumentId(organization, "creditNote");

		Assert.assertEquals(1, creditNote.getSendEvents().size());
		Assert.assertTrue(creditNote.getSendEvents().contains(sendEvent2));

		creditNote.removeSendEvent(sendEvent2);
		creditNote = session.creditNotes().getCreditNoteByDocumentId(organization, "creditNote");

		Assert.assertTrue(creditNote.getSendEvents().isEmpty());
	}

	@Test
	public void testCreditNoteSendEventDestinyMultipleAttributes() throws Exception {
		OrganizationModel organization = organizationManager.createOrganization("original");
		CreditNoteModel creditNote = session.creditNotes().addCreditNote(organization, "creditNote");
		SendEventModel sendEvent = creditNote.addSendEvent(DestinyType.CUSTOMER);
		SendEventModel sendEventNoAttrs = creditNote.addSendEvent(DestinyType.THIRD_PARTY);

		String sendEventId = sendEvent.getId();

		sendEvent.setSingleDestinyAttribute("key1", "value1");
		List<String> attrVals = new ArrayList<>(Arrays.asList("val21", "val22"));
		sendEvent.setDestinyAttribute("key2", attrVals);

		commit();

		// Test read attributes
		organization = organizationManager.getOrganizationByName("original");
		creditNote = session.creditNotes().getCreditNoteByDocumentId(organization, "creditNote");
		sendEvent = creditNote.getSendEventById(sendEventId);

		attrVals = sendEvent.getDestinyAttribute("key1");
		Assert.assertEquals(1, attrVals.size());
		Assert.assertEquals("value1", attrVals.get(0));
		Assert.assertEquals("value1", sendEvent.getFirstDestinyAttribute("key1"));

		attrVals = sendEvent.getDestinyAttribute("key2");
		Assert.assertEquals(2, attrVals.size());
		Assert.assertTrue(attrVals.contains("val21"));
		Assert.assertTrue(attrVals.contains("val22"));

		attrVals = sendEvent.getDestinyAttribute("key3");
		Assert.assertTrue(attrVals.isEmpty());
		Assert.assertNull(sendEvent.getFirstDestinyAttribute("key3"));

		Map<String, List<String>> allAttrVals = sendEvent.getDestinyAttributes();
		Assert.assertEquals(2, allAttrVals.size());
		Assert.assertEquals(allAttrVals.get("key1"), sendEvent.getDestinyAttribute("key1"));
		Assert.assertEquals(allAttrVals.get("key2"), sendEvent.getDestinyAttribute("key2"));

		// Test remove and rewrite attribute
		sendEvent.removeDestinyAttribute("key1");
		sendEvent.setSingleDestinyAttribute("key2", "val23");

		commit();

		organization = organizationManager.getOrganizationByName("original");
		creditNote = session.creditNotes().getCreditNoteByDocumentId(organization, "creditNote");
		sendEvent = creditNote.getSendEventById(sendEventId);
		Assert.assertNull(sendEvent.getFirstDestinyAttribute("key1"));
		attrVals = sendEvent.getDestinyAttribute("key2");
		Assert.assertEquals(1, attrVals.size());
		Assert.assertEquals("val23", attrVals.get(0));
	}

	@Test
	public void testUpdateSendEventDestinyAttribute() throws Exception {
		OrganizationModel organization = organizationManager.createOrganization("original");
		CreditNoteModel creditNote = session.creditNotes().addCreditNote(organization, "creditNote");
		SendEventModel sendEvent = creditNote.addSendEvent(DestinyType.CUSTOMER);
		String sendEventId = sendEvent.getId();

		sendEvent.setSingleDestinyAttribute("key1", "value1");

		commit();

		organization = organizationManager.getOrganizationByName("original");
		creditNote = session.creditNotes().getCreditNoteByDocumentId(organization, "creditNote");
		sendEvent = creditNote.getSendEventById(sendEventId);

		// Update attribute
		List<String> attrVals = new ArrayList<>(Arrays.asList("val2"));
		sendEvent.setDestinyAttribute("key1", attrVals);
		Map<String, List<String>> allAttrVals = sendEvent.getDestinyAttributes();

		// Ensure same transaction is able to see updated value
		Assert.assertEquals(1, allAttrVals.size());
		Assert.assertEquals(allAttrVals.get("key1"), Arrays.asList("val2"));

		commit();
	}

	@Test
	public void testUpdateSendEventDestinySingleAttribute() {
		Map<String, List<String>> expected = ImmutableMap.of(
				"key1", Arrays.asList("value3"),
				"key2", Arrays.asList("value2"));

		OrganizationModel organization = organizationManager.createOrganization("original");
		CreditNoteModel creditNote = session.creditNotes().addCreditNote(organization, "creditNote");
		SendEventModel sendEvent = creditNote.addSendEvent(DestinyType.CUSTOMER);
		String sendEventId = sendEvent.getId();

		sendEvent.setSingleDestinyAttribute("key1", "value1");
		sendEvent.setSingleDestinyAttribute("key2", "value2");

		// Overwrite the first attribute
		sendEvent.setSingleDestinyAttribute("key1", "value3");

		Assert.assertEquals(expected, sendEvent.getDestinyAttributes());

		commit();

		organization = session.organizations().getOrganizationByName("original");
		creditNote = session.creditNotes().getCreditNoteByDocumentId(organization, "creditNote");
		sendEvent = creditNote.getSendEventById(sendEventId);
		Assert.assertEquals(expected, sendEvent.getDestinyAttributes());
	}

	@Test
	public void testCreditNoteSendEventResponseMultipleAttributes() throws Exception {
		OrganizationModel organization = organizationManager.createOrganization("original");
		CreditNoteModel creditNote = session.creditNotes().addCreditNote(organization, "creditNote");
		SendEventModel sendEvent = creditNote.addSendEvent(DestinyType.CUSTOMER);
		SendEventModel sendEventNoAttrs = creditNote.addSendEvent(DestinyType.THIRD_PARTY);

		String sendEventId = sendEvent.getId();

		sendEvent.setSingleResponseAttribute("key1", "value1");
		List<String> attrVals = new ArrayList<>(Arrays.asList("val21", "val22"));
		sendEvent.setResponseAttribute("key2", attrVals);

		commit();

		// Test read attributes
		organization = organizationManager.getOrganizationByName("original");
		creditNote = session.creditNotes().getCreditNoteByDocumentId(organization, "creditNote");
		sendEvent = creditNote.getSendEventById(sendEventId);

		attrVals = sendEvent.getResponseAttribute("key1");
		Assert.assertEquals(1, attrVals.size());
		Assert.assertEquals("value1", attrVals.get(0));
		Assert.assertEquals("value1", sendEvent.getFirstResponseAttribute("key1"));

		attrVals = sendEvent.getResponseAttribute("key2");
		Assert.assertEquals(2, attrVals.size());
		Assert.assertTrue(attrVals.contains("val21"));
		Assert.assertTrue(attrVals.contains("val22"));

		attrVals = sendEvent.getResponseAttribute("key3");
		Assert.assertTrue(attrVals.isEmpty());
		Assert.assertNull(sendEvent.getFirstResponseAttribute("key3"));

		Map<String, List<String>> allAttrVals = sendEvent.getResponseAttributes();
		Assert.assertEquals(2, allAttrVals.size());
		Assert.assertEquals(allAttrVals.get("key1"), sendEvent.getResponseAttribute("key1"));
		Assert.assertEquals(allAttrVals.get("key2"), sendEvent.getResponseAttribute("key2"));

		// Test remove and rewrite attribute
		sendEvent.removeResponseAttribute("key1");
		sendEvent.setSingleResponseAttribute("key2", "val23");

		commit();

		organization = organizationManager.getOrganizationByName("original");
		creditNote = session.creditNotes().getCreditNoteByDocumentId(organization, "creditNote");
		sendEvent = creditNote.getSendEventById(sendEventId);
		Assert.assertNull(sendEvent.getFirstResponseAttribute("key1"));
		attrVals = sendEvent.getResponseAttribute("key2");
		Assert.assertEquals(1, attrVals.size());
		Assert.assertEquals("val23", attrVals.get(0));
	}

	@Test
	public void testUpdateSendEventResponseAttribute() throws Exception {
		OrganizationModel organization = organizationManager.createOrganization("original");
		CreditNoteModel creditNote = session.creditNotes().addCreditNote(organization, "creditNote");
		SendEventModel sendEvent = creditNote.addSendEvent(DestinyType.CUSTOMER);
		String sendEventId = sendEvent.getId();

		sendEvent.setSingleResponseAttribute("key1", "value1");

		commit();

		organization = organizationManager.getOrganizationByName("original");
		creditNote = session.creditNotes().getCreditNoteByDocumentId(organization, "creditNote");
		sendEvent = creditNote.getSendEventById(sendEventId);

		// Update attribute
		List<String> attrVals = new ArrayList<>(Arrays.asList("val2"));
		sendEvent.setResponseAttribute("key1", attrVals);
		Map<String, List<String>> allAttrVals = sendEvent.getResponseAttributes();

		// Ensure same transaction is able to see updated value
		Assert.assertEquals(1, allAttrVals.size());
		Assert.assertEquals(allAttrVals.get("key1"), Arrays.asList("val2"));

		commit();
	}

	@Test
	public void testUpdateSendEventResponseSingleAttribute() {
		Map<String, List<String>> expected = ImmutableMap.of(
				"key1", Arrays.asList("value3"),
				"key2", Arrays.asList("value2"));

		OrganizationModel organization = organizationManager.createOrganization("original");
		CreditNoteModel creditNote = session.creditNotes().addCreditNote(organization, "creditNote");
		SendEventModel sendEvent = creditNote.addSendEvent(DestinyType.CUSTOMER);
		String sendEventId = sendEvent.getId();

		sendEvent.setSingleResponseAttribute("key1", "value1");
		sendEvent.setSingleResponseAttribute("key2", "value2");

		// Overwrite the first attribute
		sendEvent.setSingleResponseAttribute("key1", "value3");

		Assert.assertEquals(expected, sendEvent.getResponseAttributes());

		commit();

		organization = session.organizations().getOrganizationByName("original");
		creditNote = session.creditNotes().getCreditNoteByDocumentId(organization, "creditNote");
		sendEvent = creditNote.getSendEventById(sendEventId);
		Assert.assertEquals(expected, sendEvent.getResponseAttributes());
	}

	@Test
	public void testSendEventFileAttatchements() {
		OrganizationModel organization = organizationManager.createOrganization("original");
		CreditNoteModel creditNote = session.creditNotes().addCreditNote(organization, "creditNote");
		SendEventModel sendEvent = creditNote.addSendEvent(DestinyType.CUSTOMER);
		SendEventModel sendEventNoFileAttatchement = creditNote.addSendEvent(DestinyType.THIRD_PARTY);
		String sendEventId = sendEvent.getId();

		Assert.assertTrue(sendEvent.getFileAttatchments().isEmpty());

		FileModel file1 = session.getProvider(FileProvider.class).createFile(organization, "file1.xml", new byte[]{0,1,2,3});
		sendEvent.attachFile(file1);

		Assert.assertEquals(1, sendEvent.getFileAttatchments().size());
		commit();

		creditNote = session.creditNotes().getCreditNoteByDocumentId(organization, "creditNote");
		sendEvent = creditNote.getSendEventById(sendEventId);

		Assert.assertEquals(1, sendEvent.getFileAttatchments().size());
		Assert.assertTrue(sendEvent.getFileAttatchments().contains(file1));

		FileModel file2 = session.getProvider(FileProvider.class).createFile(organization, "file2.xml", new byte[]{0,1,2,3,4,5});
		sendEvent.attachFile(file2);

		Assert.assertEquals(2, sendEvent.getFileAttatchments().size());
		Assert.assertTrue(sendEvent.getFileAttatchments().contains(file2));

		sendEvent.unattachFile(file1);
		sendEvent = creditNote.getSendEventById(sendEventId);

		Assert.assertEquals(1, sendEvent.getFileAttatchments().size());
		Assert.assertTrue(sendEvent.getFileAttatchments().contains(file2));

		sendEvent.unattachFile(file2);
		sendEvent = creditNote.getSendEventById(sendEventId);

		Assert.assertTrue(sendEvent.getFileAttatchments().isEmpty());

		commit();

		organization = organizationManager.getOrganizationByName("original");
		creditNote = session.creditNotes().getCreditNoteByDocumentId(organization, "creditNote");
		sendEvent = creditNote.getSendEventById(sendEventId);
		Assert.assertTrue(sendEvent.getFileAttatchments().isEmpty());
	}

	@Test
	public void testSendEventResponseFileAttatchements1() {
		OrganizationModel organization = organizationManager.createOrganization("original");
		CreditNoteModel creditNote = session.creditNotes().addCreditNote(organization, "creditNote");
		SendEventModel sendEvent = creditNote.addSendEvent(DestinyType.CUSTOMER);
		SendEventModel sendEventNoFileResponseAttatchement = creditNote.addSendEvent(DestinyType.THIRD_PARTY);
		String sendEventId = sendEvent.getId();

		Assert.assertTrue(sendEvent.getResponseFileAttatchments().isEmpty());

		FileModel file1 = session.getProvider(FileProvider.class).createFile(organization, "file1.xml", new byte[]{0,1,2,3});
		sendEvent.attachResponseFile(file1);

		Assert.assertEquals(1, sendEvent.getResponseFileAttatchments().size());
		commit();

		creditNote = session.creditNotes().getCreditNoteByDocumentId(organization, "creditNote");
		sendEvent = creditNote.getSendEventById(sendEventId);

		Assert.assertEquals(1, sendEvent.getResponseFileAttatchments().size());
		Assert.assertTrue(sendEvent.getResponseFileAttatchments().contains(file1));

		FileModel file2 = session.getProvider(FileProvider.class).createFile(organization, "file2.xml", new byte[]{0,1,2,3,4,5});
		sendEvent.attachResponseFile(file2);

		Assert.assertEquals(2, sendEvent.getResponseFileAttatchments().size());
		Assert.assertTrue(sendEvent.getResponseFileAttatchments().contains(file2));

		sendEvent.unattachResponseFile(file1);
		sendEvent = creditNote.getSendEventById(sendEventId);

		Assert.assertEquals(1, sendEvent.getResponseFileAttatchments().size());
		Assert.assertTrue(sendEvent.getResponseFileAttatchments().contains(file2));

		sendEvent.unattachResponseFile(file2);
		sendEvent = creditNote.getSendEventById(sendEventId);

		Assert.assertTrue(sendEvent.getResponseFileAttatchments().isEmpty());

		commit();

		organization = organizationManager.getOrganizationByName("original");
		creditNote = session.creditNotes().getCreditNoteByDocumentId(organization, "creditNote");
		sendEvent = creditNote.getSendEventById(sendEventId);
		Assert.assertTrue(sendEvent.getResponseFileAttatchments().isEmpty());
	}

	@Test
	public void testXmlFileAttatch() {
		OrganizationModel organization = organizationManager.createOrganization("original");
		CreditNoteModel creditNote = session.creditNotes().addCreditNote(organization, "creditNote");

		Assert.assertNull(creditNote.getXmlFile());

		FileModel file1 = session.getProvider(FileProvider.class).createFile(organization, "file1.xml", new byte[]{0,1,2,3});
		String file1Id = file1.getId();
		creditNote.attachXmlFile(file1);

		Assert.assertNotNull(creditNote.getXmlFile());
		commit();

		creditNote = session.creditNotes().getCreditNoteByDocumentId(organization, "creditNote");

		Assert.assertNotNull(creditNote.getXmlFile());
		Assert.assertEquals(creditNote.getXmlFile(), session.getProvider(FileProvider.class).getFileById(organization, file1Id));

		FileModel file2 = session.getProvider(FileProvider.class).createFile(organization, "file2.xml", new byte[]{0,1,2,3,4,5});
		String file2Id = file2.getId();
		creditNote.attachXmlFile(file2);

		Assert.assertNotNull(creditNote.getXmlFile());
		Assert.assertEquals(creditNote.getXmlFile(), session.getProvider(FileProvider.class).getFileById(organization, file2Id));

		commit();

		organization = organizationManager.getOrganizationByName("original");
		creditNote = session.creditNotes().getCreditNoteByDocumentId(organization, "creditNote");

		Assert.assertNotNull(creditNote.getXmlFile());
		Assert.assertEquals(creditNote.getXmlFile(), session.getProvider(FileProvider.class).getFileById(organization, file2Id));
	}

	@Test
	public void testAttatchedDocuments() {
		OrganizationModel organization = organizationManager.createOrganization("original");
		CreditNoteModel creditNote = session.creditNotes().addCreditNote(organization, "creditNote");

		Assert.assertTrue(creditNote.getSendEvents().isEmpty());

		AttatchedDocumentModel attatchedDocument1 = creditNote.addAttatchedDocument(DocumentType.CREDIT_NOTE, "credit-note");
		String id = organization.getId();
		commit();
		organization = organizationManager.getOrganization(id);
		creditNote = session.creditNotes().getCreditNoteByDocumentId(organization, "creditNote");

		Assert.assertEquals(1, creditNote.getAttatchedDocuments().size());
		Assert.assertTrue(creditNote.getAttatchedDocuments().contains(attatchedDocument1));
		Assert.assertEquals(attatchedDocument1.getDocumentType(), DocumentType.CREDIT_NOTE);
		Assert.assertEquals(attatchedDocument1.getDocumentId(), "credit-note");

		AttatchedDocumentModel attatchedDocument2 = creditNote.addAttatchedDocument(DocumentType.DEBIT_NOTE, "debit-note");
		creditNote = session.creditNotes().getCreditNoteByDocumentId(organization, "creditNote");
		Assert.assertEquals(attatchedDocument2.getDocumentType(), DocumentType.DEBIT_NOTE);
		Assert.assertEquals(attatchedDocument2.getDocumentId(), "debit-note");

		Assert.assertEquals(2, creditNote.getAttatchedDocuments().size());
		Assert.assertTrue(creditNote.getAttatchedDocuments().contains(attatchedDocument2));

		creditNote.removeAttatchedDocument(attatchedDocument1);
		creditNote = session.creditNotes().getCreditNoteByDocumentId(organization, "creditNote");

		Assert.assertEquals(1, creditNote.getAttatchedDocuments().size());
		Assert.assertTrue(creditNote.getAttatchedDocuments().contains(attatchedDocument2));

		creditNote.removeAttatchedDocument(attatchedDocument2);
		creditNote = session.creditNotes().getCreditNoteByDocumentId(organization, "creditNote");

		Assert.assertTrue(creditNote.getAttatchedDocuments().isEmpty());
	}

	@Test
	public void testAttatchedDocumentsMultipleAttributes() throws Exception {
		OrganizationModel organization = organizationManager.createOrganization("original");
		CreditNoteModel creditNote = session.creditNotes().addCreditNote(organization, "creditNote");
		AttatchedDocumentModel attachmentDocument = creditNote.addAttatchedDocument(DocumentType.CREDIT_NOTE, "credit-note");
		AttatchedDocumentModel attachmentDocumentNoAttrs = creditNote.addAttatchedDocument(DocumentType.CREDIT_NOTE, "credit-note");

		String attachmentDocumentId = attachmentDocument.getId();

		attachmentDocument.setSingleAttribute("key1", "value1");
		List<String> attrVals = new ArrayList<>(Arrays.asList("val21", "val22"));
		attachmentDocument.setAttribute("key2", attrVals);

		commit();

		// Test read attributes
		organization = organizationManager.getOrganizationByName("original");
		creditNote = session.creditNotes().getCreditNoteByDocumentId(organization, "creditNote");
		attachmentDocument = creditNote.getAttatchedDocumentById(attachmentDocumentId);

		attrVals = attachmentDocument.getAttribute("key1");
		Assert.assertEquals(1, attrVals.size());
		Assert.assertEquals("value1", attrVals.get(0));
		Assert.assertEquals("value1", attachmentDocument.getFirstAttribute("key1"));

		attrVals = attachmentDocument.getAttribute("key2");
		Assert.assertEquals(2, attrVals.size());
		Assert.assertTrue(attrVals.contains("val21"));
		Assert.assertTrue(attrVals.contains("val22"));

		attrVals = attachmentDocument.getAttribute("key3");
		Assert.assertTrue(attrVals.isEmpty());
		Assert.assertNull(attachmentDocument.getFirstAttribute("key3"));

		Map<String, List<String>> allAttrVals = attachmentDocument.getAttributes();
		Assert.assertEquals(2, allAttrVals.size());
		Assert.assertEquals(allAttrVals.get("key1"), attachmentDocument.getAttribute("key1"));
		Assert.assertEquals(allAttrVals.get("key2"), attachmentDocument.getAttribute("key2"));

		// Test remove and rewrite attribute
		attachmentDocument.removeAttribute("key1");
		attachmentDocument.setSingleAttribute("key2", "val23");

		commit();

		organization = organizationManager.getOrganizationByName("original");
		creditNote = session.creditNotes().getCreditNoteByDocumentId(organization, "creditNote");
		attachmentDocument = creditNote.getAttatchedDocumentById(attachmentDocumentId);
		Assert.assertNull(attachmentDocument.getFirstAttribute("key1"));
		attrVals = attachmentDocument.getAttribute("key2");
		Assert.assertEquals(1, attrVals.size());
		Assert.assertEquals("val23", attrVals.get(0));
	}

	@Test
	public void testUpdateAttatchedDocumentsAttribute() throws Exception {
		OrganizationModel organization = organizationManager.createOrganization("original");
		CreditNoteModel creditNote = session.creditNotes().addCreditNote(organization, "creditNote");
		AttatchedDocumentModel attatchedDocument = creditNote.addAttatchedDocument(DocumentType.CREDIT_NOTE, "credit-note");
		String attatchedDocumentId = attatchedDocument.getId();

		attatchedDocument.setSingleAttribute("key1", "value1");

		commit();

		organization = organizationManager.getOrganizationByName("original");
		creditNote = session.creditNotes().getCreditNoteByDocumentId(organization, "creditNote");
		attatchedDocument = creditNote.getAttatchedDocumentById(attatchedDocumentId);

		// Update attribute
		List<String> attrVals = new ArrayList<>(Arrays.asList("val2"));
		attatchedDocument.setAttribute("key1", attrVals);
		Map<String, List<String>> allAttrVals = attatchedDocument.getAttributes();

		// Ensure same transaction is able to see updated value
		Assert.assertEquals(1, allAttrVals.size());
		Assert.assertEquals(allAttrVals.get("key1"), Arrays.asList("val2"));

		commit();
	}

	@Test
	public void testUpdateAttatchedDocumentsSingleAttribute() {
		Map<String, List<String>> expected = ImmutableMap.of(
				"key1", Arrays.asList("value3"),
				"key2", Arrays.asList("value2"));

		OrganizationModel organization = organizationManager.createOrganization("original");
		CreditNoteModel creditNote = session.creditNotes().addCreditNote(organization, "creditNote");
		AttatchedDocumentModel attatchedDocument = creditNote.addAttatchedDocument(DocumentType.CREDIT_NOTE, "credit-note");
		String attatchedDocumentId = attatchedDocument.getId();

		attatchedDocument.setSingleAttribute("key1", "value1");
		attatchedDocument.setSingleAttribute("key2", "value2");

		// Overwrite the first attribute
		attatchedDocument.setSingleAttribute("key1", "value3");

		Assert.assertEquals(expected, attatchedDocument.getAttributes());

		commit();

		organization = session.organizations().getOrganizationByName("original");
		creditNote = session.creditNotes().getCreditNoteByDocumentId(organization, "creditNote");
		attatchedDocument = creditNote.getAttatchedDocumentById(attatchedDocumentId);
		Assert.assertEquals(expected, attatchedDocument.getAttributes());
	}
	
	public static void assertEquals(CreditNoteModel expected, CreditNoteModel actual) {
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
