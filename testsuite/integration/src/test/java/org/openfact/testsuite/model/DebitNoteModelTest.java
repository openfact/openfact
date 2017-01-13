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
public class DebitNoteModelTest extends AbstractModelTest {

	@Test
	public void persistDebitNote() {
		OrganizationModel organization = organizationManager.createOrganization("original");
		OpenfactSession session = organizationManager.getSession();
		DebitNoteModel debitNote = session.debitNotes().addDebitNote(organization, "debitNote");
		debitNote.setDocumentCurrencyCode("PEN");
		debitNote.setIssueDateTime(LocalDateTime.now());
		assertNotNull(debitNote.getCreatedTimestamp());

		// test that timestamp is current with 10s tollerance
		Assert.assertTrue((System.currentTimeMillis() - Date.from(debitNote.getCreatedTimestamp().atZone(ZoneId.systemDefault()).toInstant()).getTime()) < 10000);

		debitNote.addRequiredAction(RequiredAction.SEND_TO_CUSTOMER);
		debitNote.addRequiredAction(RequiredAction.SEND_TO_TRIRD_PARTY);

		OrganizationModel searchOrganization = organizationManager.getOrganization(organization.getId());
		DebitNoteModel persisted = session.debitNotes().getDebitNoteByDocumentId(searchOrganization, "debitNote");

		assertEquals(debitNote, persisted);

		searchOrganization = organizationManager.getOrganization(organization.getId());
		DebitNoteModel persisted2 =  session.debitNotes().getDebitNoteById(searchOrganization, debitNote.getId());
		assertEquals(debitNote, persisted2);
	}

	@Test
	public void testDebitNoteRequiredActions() throws Exception {
		OrganizationModel organization = organizationManager.createOrganization("original");
		DebitNoteModel debitNote = session.debitNotes().addDebitNote(organization, "debitNote");

		Assert.assertTrue(debitNote.getRequiredActions().isEmpty());

		debitNote.addRequiredAction(RequiredAction.SEND_TO_CUSTOMER);
		String id = organization.getId();
		commit();
		organization = organizationManager.getOrganization(id);
		debitNote = session.debitNotes().getDebitNoteByDocumentId(organization, "debitNote");

		Assert.assertEquals(1, debitNote.getRequiredActions().size());
		Assert.assertTrue(debitNote.getRequiredActions().contains(RequiredAction.SEND_TO_CUSTOMER.name()));

		debitNote.addRequiredAction(RequiredAction.SEND_TO_CUSTOMER);
		debitNote = session.debitNotes().getDebitNoteByDocumentId(organization, "debitNote");

		Assert.assertEquals(1, debitNote.getRequiredActions().size());
		Assert.assertTrue(debitNote.getRequiredActions().contains(RequiredAction.SEND_TO_CUSTOMER.name()));

		debitNote.addRequiredAction(RequiredAction.SEND_TO_TRIRD_PARTY.name());
		debitNote = session.debitNotes().getDebitNoteByDocumentId(organization, "debitNote");

		Assert.assertEquals(2, debitNote.getRequiredActions().size());
		Assert.assertTrue(debitNote.getRequiredActions().contains(RequiredAction.SEND_TO_CUSTOMER.name()));
		Assert.assertTrue(debitNote.getRequiredActions().contains(RequiredAction.SEND_TO_TRIRD_PARTY.name()));

		debitNote.removeRequiredAction(RequiredAction.SEND_TO_CUSTOMER.name());
		debitNote = session.debitNotes().getDebitNoteByDocumentId(organization, "debitNote");

		Assert.assertEquals(1, debitNote.getRequiredActions().size());
		Assert.assertTrue(debitNote.getRequiredActions().contains(RequiredAction.SEND_TO_TRIRD_PARTY.name()));

		debitNote.removeRequiredAction(RequiredAction.SEND_TO_TRIRD_PARTY.name());
		debitNote = session.debitNotes().getDebitNoteByDocumentId(organization, "debitNote");

		Assert.assertTrue(debitNote.getRequiredActions().isEmpty());
	}

	@Test
	public void testDebitNoteMultipleAttributes() throws Exception {
		OrganizationModel organization = organizationManager.createOrganization("original");
		DebitNoteModel debitNote = session.debitNotes().addDebitNote(organization, "debitNote");
		DebitNoteModel debitNoteNoAttrs = session.debitNotes().addDebitNote(organization, "debitNote-noattrs");

		debitNote.setSingleAttribute("key1", "value1");
		List<String> attrVals = new ArrayList<>(Arrays.asList( "val21", "val22" ));
		debitNote.setAttribute("key2", attrVals);

		commit();

		// Test read attributes
		organization = organizationManager.getOrganizationByName("original");
		debitNote = session.debitNotes().getDebitNoteByDocumentId(organization, "debitNote");

		attrVals = debitNote.getAttribute("key1");
		Assert.assertEquals(1, attrVals.size());
		Assert.assertEquals("value1", attrVals.get(0));
		Assert.assertEquals("value1", debitNote.getFirstAttribute("key1"));

		attrVals = debitNote.getAttribute("key2");
		Assert.assertEquals(2, attrVals.size());
		Assert.assertTrue(attrVals.contains("val21"));
		Assert.assertTrue(attrVals.contains("val22"));

		attrVals = debitNote.getAttribute("key3");
		Assert.assertTrue(attrVals.isEmpty());
		Assert.assertNull(debitNote.getFirstAttribute("key3"));

		Map<String, List<String>> allAttrVals = debitNote.getAttributes();
		Assert.assertEquals(2, allAttrVals.size());
		Assert.assertEquals(allAttrVals.get("key1"), debitNote.getAttribute("key1"));
		Assert.assertEquals(allAttrVals.get("key2"), debitNote.getAttribute("key2"));

		// Test remove and rewrite attribute
		debitNote.removeAttribute("key1");
		debitNote.setSingleAttribute("key2", "val23");

		commit();

		organization = organizationManager.getOrganizationByName("original");
		debitNote = session.debitNotes().getDebitNoteByDocumentId(organization, "debitNote");
		Assert.assertNull(debitNote.getFirstAttribute("key1"));
		attrVals = debitNote.getAttribute("key2");
		Assert.assertEquals(1, attrVals.size());
		Assert.assertEquals("val23", attrVals.get(0));
	}

	@Test
	public void testUpdateDebitNoteAttribute() throws Exception {
		OrganizationModel organization = organizationManager.createOrganization("original");
		DebitNoteModel debitNote = session.debitNotes().addDebitNote(organization, "debitNote");

		debitNote.setSingleAttribute("key1", "value1");

		commit();

		organization = organizationManager.getOrganizationByName("original");
		debitNote = session.debitNotes().getDebitNoteByDocumentId(organization, "debitNote");

		// Update attribute
		List<String> attrVals = new ArrayList<>(Arrays.asList( "val2" ));
		debitNote.setAttribute("key1", attrVals);
		Map<String, List<String>> allAttrVals = debitNote.getAttributes();

		// Ensure same transaction is able to see updated value
		Assert.assertEquals(1, allAttrVals.size());
		Assert.assertEquals(allAttrVals.get("key1"), Arrays.asList("val2"));

		commit();
	}

	@Test
	public void testUpdateDebitNoteSingleAttribute() {
		Map<String, List<String>> expected = ImmutableMap.of(
				"key1", Arrays.asList("value3"),
				"key2", Arrays.asList("value2"));

		OrganizationModel organization = organizationManager.createOrganization("original");
		DebitNoteModel debitNote = session.debitNotes().addDebitNote(organization, "debitNote");

		debitNote.setSingleAttribute("key1", "value1");
		debitNote.setSingleAttribute("key2", "value2");

		// Overwrite the first attribute
		debitNote.setSingleAttribute("key1", "value3");

		Assert.assertEquals(expected, debitNote.getAttributes());

		commit();

		organization = session.organizations().getOrganizationByName("original");
		Assert.assertEquals(expected, session.debitNotes().getDebitNoteByDocumentId(organization, "debitNote").getAttributes());
	}

	@Test
	public void testSearchByString() {
		OrganizationModel organization = organizationManager.createOrganization("original");
		DebitNoteModel debitNote1 = session.debitNotes().addDebitNote(organization, "debitNote1");

		commit();
		organization = session.organizations().getOrganizationByName("original");
		List<DebitNoteModel> debitNotes = session.debitNotes().searchForDebitNote(organization, "debitNote", 0, 7);
		Assert.assertTrue(debitNotes.contains(debitNote1));
	}

	@Test
	public void testSearchByDebitNoteAttribute() throws Exception {
		OrganizationModel realm = organizationManager.createOrganization("original");
		DebitNoteModel debitNote1 = session.debitNotes().addDebitNote(realm, "debitNote1");
		DebitNoteModel debitNote2 = session.debitNotes().addDebitNote(realm, "debitNote2");
		DebitNoteModel debitNote3 = session.debitNotes().addDebitNote(realm, "debitNote3");

		debitNote1.setSingleAttribute("key1", "value1");
		debitNote1.setSingleAttribute("key2", "value21");

		debitNote2.setSingleAttribute("key1", "value1");
		debitNote2.setSingleAttribute("key2", "value22");

		debitNote3.setSingleAttribute("key2", "value21");

		commit();
		realm = session.organizations().getOrganizationByName("original");

		List<DebitNoteModel> debitNotes = session.debitNotes().searchForDebitNoteByAttribute("key1", "value1", realm);
		Assert.assertEquals(2, debitNotes.size());
		Assert.assertTrue(debitNotes.contains(debitNote1));
		Assert.assertTrue(debitNotes.contains(debitNote2));

		debitNotes = session.debitNotes().searchForDebitNoteByAttribute("key2", "value21", realm);
		Assert.assertEquals(2, debitNotes.size());
		Assert.assertTrue(debitNotes.contains(debitNote1));
		Assert.assertTrue(debitNotes.contains(debitNote3));

		debitNotes = session.debitNotes().searchForDebitNoteByAttribute("key2", "value22", realm);
		Assert.assertEquals(1, debitNotes.size());
		Assert.assertTrue(debitNotes.contains(debitNote2));

		debitNotes = session.debitNotes().searchForDebitNoteByAttribute("key3", "value3", realm);
		Assert.assertEquals(0, debitNotes.size());
	}

	@Test
	public void testDebitNoteSendEvent() {
		OrganizationModel organization = organizationManager.createOrganization("original");
		DebitNoteModel debitNote = session.debitNotes().addDebitNote(organization, "debitNote");

		Assert.assertTrue(debitNote.getSendEvents().isEmpty());

		SendEventModel sendEvent1 = debitNote.addSendEvent(DestinyType.CUSTOMER);
		String id = organization.getId();
		commit();
		organization = organizationManager.getOrganization(id);
		debitNote = session.debitNotes().getDebitNoteByDocumentId(organization, "debitNote");

		Assert.assertEquals(1, debitNote.getSendEvents().size());
		Assert.assertTrue(debitNote.getSendEvents().contains(sendEvent1));
		Assert.assertTrue(sendEvent1.getDestityType().equals(DestinyType.CUSTOMER));

		SendEventModel sendEvent2 = debitNote.addSendEvent(DestinyType.THIRD_PARTY);
		debitNote = session.debitNotes().getDebitNoteByDocumentId(organization, "debitNote");
		Assert.assertTrue(sendEvent2.getDestityType().equals(DestinyType.THIRD_PARTY));

		Assert.assertEquals(2, debitNote.getSendEvents().size());
		Assert.assertTrue(debitNote.getSendEvents().contains(sendEvent2));

		debitNote.removeSendEvent(sendEvent1);
		debitNote = session.debitNotes().getDebitNoteByDocumentId(organization, "debitNote");

		Assert.assertEquals(1, debitNote.getSendEvents().size());
		Assert.assertTrue(debitNote.getSendEvents().contains(sendEvent2));

		debitNote.removeSendEvent(sendEvent2);
		debitNote = session.debitNotes().getDebitNoteByDocumentId(organization, "debitNote");

		Assert.assertTrue(debitNote.getSendEvents().isEmpty());
	}

	@Test
	public void testDebitNoteSendEventDestinyMultipleAttributes() throws Exception {
		OrganizationModel organization = organizationManager.createOrganization("original");
		DebitNoteModel debitNote = session.debitNotes().addDebitNote(organization, "debitNote");
		SendEventModel sendEvent = debitNote.addSendEvent(DestinyType.CUSTOMER);
		SendEventModel sendEventNoAttrs = debitNote.addSendEvent(DestinyType.THIRD_PARTY);

		String sendEventId = sendEvent.getId();

		sendEvent.setSingleDestinyAttribute("key1", "value1");
		List<String> attrVals = new ArrayList<>(Arrays.asList("val21", "val22"));
		sendEvent.setDestinyAttribute("key2", attrVals);

		commit();

		// Test read attributes
		organization = organizationManager.getOrganizationByName("original");
		debitNote = session.debitNotes().getDebitNoteByDocumentId(organization, "debitNote");
		sendEvent = debitNote.getSendEventById(sendEventId);

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
		debitNote = session.debitNotes().getDebitNoteByDocumentId(organization, "debitNote");
		sendEvent = debitNote.getSendEventById(sendEventId);
		Assert.assertNull(sendEvent.getFirstDestinyAttribute("key1"));
		attrVals = sendEvent.getDestinyAttribute("key2");
		Assert.assertEquals(1, attrVals.size());
		Assert.assertEquals("val23", attrVals.get(0));
	}

	@Test
	public void testUpdateSendEventDestinyAttribute() throws Exception {
		OrganizationModel organization = organizationManager.createOrganization("original");
		DebitNoteModel debitNote = session.debitNotes().addDebitNote(organization, "debitNote");
		SendEventModel sendEvent = debitNote.addSendEvent(DestinyType.CUSTOMER);
		String sendEventId = sendEvent.getId();

		sendEvent.setSingleDestinyAttribute("key1", "value1");

		commit();

		organization = organizationManager.getOrganizationByName("original");
		debitNote = session.debitNotes().getDebitNoteByDocumentId(organization, "debitNote");
		sendEvent = debitNote.getSendEventById(sendEventId);

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
		DebitNoteModel debitNote = session.debitNotes().addDebitNote(organization, "debitNote");
		SendEventModel sendEvent = debitNote.addSendEvent(DestinyType.CUSTOMER);
		String sendEventId = sendEvent.getId();

		sendEvent.setSingleDestinyAttribute("key1", "value1");
		sendEvent.setSingleDestinyAttribute("key2", "value2");

		// Overwrite the first attribute
		sendEvent.setSingleDestinyAttribute("key1", "value3");

		Assert.assertEquals(expected, sendEvent.getDestinyAttributes());

		commit();

		organization = session.organizations().getOrganizationByName("original");
		debitNote = session.debitNotes().getDebitNoteByDocumentId(organization, "debitNote");
		sendEvent = debitNote.getSendEventById(sendEventId);
		Assert.assertEquals(expected, sendEvent.getDestinyAttributes());
	}

	@Test
	public void testDebitNoteSendEventResponseMultipleAttributes() throws Exception {
		OrganizationModel organization = organizationManager.createOrganization("original");
		DebitNoteModel debitNote = session.debitNotes().addDebitNote(organization, "debitNote");
		SendEventModel sendEvent = debitNote.addSendEvent(DestinyType.CUSTOMER);
		SendEventModel sendEventNoAttrs = debitNote.addSendEvent(DestinyType.THIRD_PARTY);

		String sendEventId = sendEvent.getId();

		sendEvent.setSingleResponseAttribute("key1", "value1");
		List<String> attrVals = new ArrayList<>(Arrays.asList("val21", "val22"));
		sendEvent.setResponseAttribute("key2", attrVals);

		commit();

		// Test read attributes
		organization = organizationManager.getOrganizationByName("original");
		debitNote = session.debitNotes().getDebitNoteByDocumentId(organization, "debitNote");
		sendEvent = debitNote.getSendEventById(sendEventId);

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
		debitNote = session.debitNotes().getDebitNoteByDocumentId(organization, "debitNote");
		sendEvent = debitNote.getSendEventById(sendEventId);
		Assert.assertNull(sendEvent.getFirstResponseAttribute("key1"));
		attrVals = sendEvent.getResponseAttribute("key2");
		Assert.assertEquals(1, attrVals.size());
		Assert.assertEquals("val23", attrVals.get(0));
	}

	@Test
	public void testUpdateSendEventResponseAttribute() throws Exception {
		OrganizationModel organization = organizationManager.createOrganization("original");
		DebitNoteModel debitNote = session.debitNotes().addDebitNote(organization, "debitNote");
		SendEventModel sendEvent = debitNote.addSendEvent(DestinyType.CUSTOMER);
		String sendEventId = sendEvent.getId();

		sendEvent.setSingleResponseAttribute("key1", "value1");

		commit();

		organization = organizationManager.getOrganizationByName("original");
		debitNote = session.debitNotes().getDebitNoteByDocumentId(organization, "debitNote");
		sendEvent = debitNote.getSendEventById(sendEventId);

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
		DebitNoteModel debitNote = session.debitNotes().addDebitNote(organization, "debitNote");
		SendEventModel sendEvent = debitNote.addSendEvent(DestinyType.CUSTOMER);
		String sendEventId = sendEvent.getId();

		sendEvent.setSingleResponseAttribute("key1", "value1");
		sendEvent.setSingleResponseAttribute("key2", "value2");

		// Overwrite the first attribute
		sendEvent.setSingleResponseAttribute("key1", "value3");

		Assert.assertEquals(expected, sendEvent.getResponseAttributes());

		commit();

		organization = session.organizations().getOrganizationByName("original");
		debitNote = session.debitNotes().getDebitNoteByDocumentId(organization, "debitNote");
		sendEvent = debitNote.getSendEventById(sendEventId);
		Assert.assertEquals(expected, sendEvent.getResponseAttributes());
	}

	@Test
	public void testSendEventFileAttatchements() {
		OrganizationModel organization = organizationManager.createOrganization("original");
		DebitNoteModel debitNote = session.debitNotes().addDebitNote(organization, "debitNote");
		SendEventModel sendEvent = debitNote.addSendEvent(DestinyType.CUSTOMER);
		SendEventModel sendEventNoFileAttatchement = debitNote.addSendEvent(DestinyType.THIRD_PARTY);
		String sendEventId = sendEvent.getId();

		Assert.assertTrue(sendEvent.getFileAttatchments().isEmpty());

		FileModel file1 = session.getProvider(FileProvider.class).createFile(organization, "file1.xml", new byte[]{0,1,2,3});
		sendEvent.attachFile(file1);

		Assert.assertEquals(1, sendEvent.getFileAttatchments().size());
		commit();

		debitNote = session.debitNotes().getDebitNoteByDocumentId(organization, "debitNote");
		sendEvent = debitNote.getSendEventById(sendEventId);

		Assert.assertEquals(1, sendEvent.getFileAttatchments().size());
		Assert.assertTrue(sendEvent.getFileAttatchments().contains(file1));

		FileModel file2 = session.getProvider(FileProvider.class).createFile(organization, "file2.xml", new byte[]{0,1,2,3,4,5});
		sendEvent.attachFile(file2);

		Assert.assertEquals(2, sendEvent.getFileAttatchments().size());
		Assert.assertTrue(sendEvent.getFileAttatchments().contains(file2));

		sendEvent.unattachFile(file1);
		sendEvent = debitNote.getSendEventById(sendEventId);

		Assert.assertEquals(1, sendEvent.getFileAttatchments().size());
		Assert.assertTrue(sendEvent.getFileAttatchments().contains(file2));

		sendEvent.unattachFile(file2);
		sendEvent = debitNote.getSendEventById(sendEventId);

		Assert.assertTrue(sendEvent.getFileAttatchments().isEmpty());

		commit();

		organization = organizationManager.getOrganizationByName("original");
		debitNote = session.debitNotes().getDebitNoteByDocumentId(organization, "debitNote");
		sendEvent = debitNote.getSendEventById(sendEventId);
		Assert.assertTrue(sendEvent.getFileAttatchments().isEmpty());
	}

	@Test
	public void testSendEventResponseFileAttatchements1() {
		OrganizationModel organization = organizationManager.createOrganization("original");
		DebitNoteModel debitNote = session.debitNotes().addDebitNote(organization, "debitNote");
		SendEventModel sendEvent = debitNote.addSendEvent(DestinyType.CUSTOMER);
		SendEventModel sendEventNoFileResponseAttatchement = debitNote.addSendEvent(DestinyType.THIRD_PARTY);
		String sendEventId = sendEvent.getId();

		Assert.assertTrue(sendEvent.getResponseFileAttatchments().isEmpty());

		FileModel file1 = session.getProvider(FileProvider.class).createFile(organization, "file1.xml", new byte[]{0,1,2,3});
		sendEvent.attachResponseFile(file1);

		Assert.assertEquals(1, sendEvent.getResponseFileAttatchments().size());
		commit();

		debitNote = session.debitNotes().getDebitNoteByDocumentId(organization, "debitNote");
		sendEvent = debitNote.getSendEventById(sendEventId);

		Assert.assertEquals(1, sendEvent.getResponseFileAttatchments().size());
		Assert.assertTrue(sendEvent.getResponseFileAttatchments().contains(file1));

		FileModel file2 = session.getProvider(FileProvider.class).createFile(organization, "file2.xml", new byte[]{0,1,2,3,4,5});
		sendEvent.attachResponseFile(file2);

		Assert.assertEquals(2, sendEvent.getResponseFileAttatchments().size());
		Assert.assertTrue(sendEvent.getResponseFileAttatchments().contains(file2));

		sendEvent.unattachResponseFile(file1);
		sendEvent = debitNote.getSendEventById(sendEventId);

		Assert.assertEquals(1, sendEvent.getResponseFileAttatchments().size());
		Assert.assertTrue(sendEvent.getResponseFileAttatchments().contains(file2));

		sendEvent.unattachResponseFile(file2);
		sendEvent = debitNote.getSendEventById(sendEventId);

		Assert.assertTrue(sendEvent.getResponseFileAttatchments().isEmpty());

		commit();

		organization = organizationManager.getOrganizationByName("original");
		debitNote = session.debitNotes().getDebitNoteByDocumentId(organization, "debitNote");
		sendEvent = debitNote.getSendEventById(sendEventId);
		Assert.assertTrue(sendEvent.getResponseFileAttatchments().isEmpty());
	}

	@Test
	public void testXmlFileAttatch() {
		OrganizationModel organization = organizationManager.createOrganization("original");
		DebitNoteModel debitNote = session.debitNotes().addDebitNote(organization, "debitNote");

		Assert.assertNull(debitNote.getXmlAsFile());

		FileModel file1 = session.getProvider(FileProvider.class).createFile(organization, "file1.xml", new byte[]{0,1,2,3});
		String file1Id = file1.getId();
		debitNote.attachXmlFile(file1);

		Assert.assertNotNull(debitNote.getXmlAsFile());
		commit();

		debitNote = session.debitNotes().getDebitNoteByDocumentId(organization, "debitNote");

		Assert.assertNotNull(debitNote.getXmlAsFile());
		Assert.assertEquals(debitNote.getXmlAsFile(), session.getProvider(FileProvider.class).getFileById(organization, file1Id));

		FileModel file2 = session.getProvider(FileProvider.class).createFile(organization, "file2.xml", new byte[]{0,1,2,3,4,5});
		String file2Id = file2.getId();
		debitNote.attachXmlFile(file2);

		Assert.assertNotNull(debitNote.getXmlAsFile());
		Assert.assertEquals(debitNote.getXmlAsFile(), session.getProvider(FileProvider.class).getFileById(organization, file2Id));

		commit();

		organization = organizationManager.getOrganizationByName("original");
		debitNote = session.debitNotes().getDebitNoteByDocumentId(organization, "debitNote");

		Assert.assertNotNull(debitNote.getXmlAsFile());
		Assert.assertEquals(debitNote.getXmlAsFile(), session.getProvider(FileProvider.class).getFileById(organization, file2Id));
	}

	@Test
	public void testAttatchedDocuments() {
		OrganizationModel organization = organizationManager.createOrganization("original");
		DebitNoteModel debitNote = session.debitNotes().addDebitNote(organization, "debitNote");

		Assert.assertTrue(debitNote.getSendEvents().isEmpty());

		AttatchedDocumentModel attatchedDocument1 = debitNote.addAttatchedDocument(DocumentType.CREDIT_NOTE, "credit-note");
		String id = organization.getId();
		commit();
		organization = organizationManager.getOrganization(id);
		debitNote = session.debitNotes().getDebitNoteByDocumentId(organization, "debitNote");

		Assert.assertEquals(1, debitNote.getAttatchedDocuments().size());
		Assert.assertTrue(debitNote.getAttatchedDocuments().contains(attatchedDocument1));
		Assert.assertEquals(attatchedDocument1.getDocumentType(), DocumentType.CREDIT_NOTE);
		Assert.assertEquals(attatchedDocument1.getDocumentId(), "credit-note");

		AttatchedDocumentModel attatchedDocument2 = debitNote.addAttatchedDocument(DocumentType.DEBIT_NOTE, "debit-note");
		debitNote = session.debitNotes().getDebitNoteByDocumentId(organization, "debitNote");
		Assert.assertEquals(attatchedDocument2.getDocumentType(), DocumentType.DEBIT_NOTE);
		Assert.assertEquals(attatchedDocument2.getDocumentId(), "debit-note");

		Assert.assertEquals(2, debitNote.getAttatchedDocuments().size());
		Assert.assertTrue(debitNote.getAttatchedDocuments().contains(attatchedDocument2));

		debitNote.removeAttatchedDocument(attatchedDocument1);
		debitNote = session.debitNotes().getDebitNoteByDocumentId(organization, "debitNote");

		Assert.assertEquals(1, debitNote.getAttatchedDocuments().size());
		Assert.assertTrue(debitNote.getAttatchedDocuments().contains(attatchedDocument2));

		debitNote.removeAttatchedDocument(attatchedDocument2);
		debitNote = session.debitNotes().getDebitNoteByDocumentId(organization, "debitNote");

		Assert.assertTrue(debitNote.getAttatchedDocuments().isEmpty());
	}

	@Test
	public void testAttatchedDocumentsMultipleAttributes() throws Exception {
		OrganizationModel organization = organizationManager.createOrganization("original");
		DebitNoteModel debitNote = session.debitNotes().addDebitNote(organization, "debitNote");
		AttatchedDocumentModel attachmentDocument = debitNote.addAttatchedDocument(DocumentType.CREDIT_NOTE, "credit-note");
		AttatchedDocumentModel attachmentDocumentNoAttrs = debitNote.addAttatchedDocument(DocumentType.CREDIT_NOTE, "credit-note");

		String attachmentDocumentId = attachmentDocument.getId();

		attachmentDocument.setSingleAttribute("key1", "value1");
		List<String> attrVals = new ArrayList<>(Arrays.asList("val21", "val22"));
		attachmentDocument.setAttribute("key2", attrVals);

		commit();

		// Test read attributes
		organization = organizationManager.getOrganizationByName("original");
		debitNote = session.debitNotes().getDebitNoteByDocumentId(organization, "debitNote");
		attachmentDocument = debitNote.getAttatchedDocumentById(attachmentDocumentId);

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
		debitNote = session.debitNotes().getDebitNoteByDocumentId(organization, "debitNote");
		attachmentDocument = debitNote.getAttatchedDocumentById(attachmentDocumentId);
		Assert.assertNull(attachmentDocument.getFirstAttribute("key1"));
		attrVals = attachmentDocument.getAttribute("key2");
		Assert.assertEquals(1, attrVals.size());
		Assert.assertEquals("val23", attrVals.get(0));
	}

	@Test
	public void testUpdateAttatchedDocumentsAttribute() throws Exception {
		OrganizationModel organization = organizationManager.createOrganization("original");
		DebitNoteModel debitNote = session.debitNotes().addDebitNote(organization, "debitNote");
		AttatchedDocumentModel attatchedDocument = debitNote.addAttatchedDocument(DocumentType.CREDIT_NOTE, "credit-note");
		String attatchedDocumentId = attatchedDocument.getId();

		attatchedDocument.setSingleAttribute("key1", "value1");

		commit();

		organization = organizationManager.getOrganizationByName("original");
		debitNote = session.debitNotes().getDebitNoteByDocumentId(organization, "debitNote");
		attatchedDocument = debitNote.getAttatchedDocumentById(attatchedDocumentId);

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
		DebitNoteModel debitNote = session.debitNotes().addDebitNote(organization, "debitNote");
		AttatchedDocumentModel attatchedDocument = debitNote.addAttatchedDocument(DocumentType.CREDIT_NOTE, "credit-note");
		String attatchedDocumentId = attatchedDocument.getId();

		attatchedDocument.setSingleAttribute("key1", "value1");
		attatchedDocument.setSingleAttribute("key2", "value2");

		// Overwrite the first attribute
		attatchedDocument.setSingleAttribute("key1", "value3");

		Assert.assertEquals(expected, attatchedDocument.getAttributes());

		commit();

		organization = session.organizations().getOrganizationByName("original");
		debitNote = session.debitNotes().getDebitNoteByDocumentId(organization, "debitNote");
		attatchedDocument = debitNote.getAttatchedDocumentById(attatchedDocumentId);
		Assert.assertEquals(expected, attatchedDocument.getAttributes());
	}
	
	public static void assertEquals(DebitNoteModel expected, DebitNoteModel actual) {
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
