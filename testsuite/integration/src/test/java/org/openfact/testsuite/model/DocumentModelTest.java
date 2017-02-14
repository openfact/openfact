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

import java.time.ZoneId;
import java.util.*;

import static org.junit.Assert.assertNotNull;

/**
 * @author <a href="mailto:carlosthe19916@sistcoop.com">Carlos Feria</a>
 */
public class DocumentModelTest extends AbstractModelTest {

    @Test
    public void persistDocument() {
        OrganizationModel organization = organizationManager.createOrganization("original");
        OpenfactSession session = organizationManager.getSession();
        DocumentModel document = session.documents().addDocument(DocumentType.INVOICE, "document", organization);
        document.setCustomerElectronicMail("carlosthe19916@sistcoop.com");
        assertNotNull(document.getCustomerElectronicMail());

        // test that timestamp is current with 10s tollerance
        Assert.assertTrue((System.currentTimeMillis() - Date.from(document.getCreatedTimestamp().atZone(ZoneId.systemDefault()).toInstant()).getTime()) < 10000);

        document.addRequiredAction(RequiredAction.SEND_TO_CUSTOMER);
        document.addRequiredAction(RequiredAction.SEND_TO_THIRD_PARTY);

        OrganizationModel searchOrganization = organizationManager.getOrganization(organization.getId());
        DocumentModel persisted = session.documents().getDocumentByTypeAndDocumentId(DocumentType.INVOICE, "document", searchOrganization);

        assertEquals(document, persisted);

        searchOrganization = organizationManager.getOrganization(organization.getId());
        DocumentModel persisted2 = session.documents().getDocumentById(document.getId(), searchOrganization);
        assertEquals(document, persisted2);
    }

    @Test
    public void testDocumentRequiredActions() throws Exception {
        OrganizationModel organization = organizationManager.createOrganization("original");
        DocumentModel document = session.documents().addDocument(DocumentType.INVOICE, "document", organization);

        Assert.assertTrue(document.getRequiredActions().isEmpty());

        document.addRequiredAction(RequiredAction.SEND_TO_CUSTOMER);
        String id = organization.getId();
        commit();
        organization = organizationManager.getOrganization(id);
        document = session.documents().getDocumentByTypeAndDocumentId(DocumentType.INVOICE, "document", organization);

        Assert.assertEquals(1, document.getRequiredActions().size());
        Assert.assertTrue(document.getRequiredActions().contains(RequiredAction.SEND_TO_CUSTOMER.name()));

        document.addRequiredAction(RequiredAction.SEND_TO_CUSTOMER);
        document = session.documents().getDocumentByTypeAndDocumentId(DocumentType.INVOICE, "document", organization);

        Assert.assertEquals(1, document.getRequiredActions().size());
        Assert.assertTrue(document.getRequiredActions().contains(RequiredAction.SEND_TO_CUSTOMER.name()));

        document.addRequiredAction(RequiredAction.SEND_TO_THIRD_PARTY.name());
        document = session.documents().getDocumentByTypeAndDocumentId(DocumentType.INVOICE, "document", organization);

        Assert.assertEquals(2, document.getRequiredActions().size());
        Assert.assertTrue(document.getRequiredActions().contains(RequiredAction.SEND_TO_CUSTOMER.name()));
        Assert.assertTrue(document.getRequiredActions().contains(RequiredAction.SEND_TO_THIRD_PARTY.name()));

        document.removeRequiredAction(RequiredAction.SEND_TO_CUSTOMER.name());
        document = session.documents().getDocumentByTypeAndDocumentId(DocumentType.INVOICE, "document", organization);

        Assert.assertEquals(1, document.getRequiredActions().size());
        Assert.assertTrue(document.getRequiredActions().contains(RequiredAction.SEND_TO_THIRD_PARTY.name()));

        document.removeRequiredAction(RequiredAction.SEND_TO_THIRD_PARTY.name());
        document = session.documents().getDocumentByTypeAndDocumentId(DocumentType.INVOICE, "document", organization);

        Assert.assertTrue(document.getRequiredActions().isEmpty());
    }

    @Test
    public void testDocumentMultipleAttributes() throws Exception {
        OrganizationModel organization = organizationManager.createOrganization("original");
        DocumentModel document = session.documents().addDocument(DocumentType.INVOICE, "document", organization);
        DocumentModel documentNoAttrs = session.documents().addDocument(DocumentType.INVOICE, "document-noattrs", organization);

        document.setSingleAttribute("key1", "value1");
        List<String> attrVals = new ArrayList<>(Arrays.asList("val21", "val22"));
        document.setAttribute("key2", attrVals);

        commit();

        // Test read attributes
        organization = organizationManager.getOrganizationByName("original");
        document = session.documents().getDocumentByTypeAndDocumentId(DocumentType.INVOICE, "document", organization);

        attrVals = document.getAttribute("key1");
        Assert.assertEquals(1, attrVals.size());
        Assert.assertEquals("value1", attrVals.get(0));
        Assert.assertEquals("value1", document.getFirstAttribute("key1"));

        attrVals = document.getAttribute("key2");
        Assert.assertEquals(2, attrVals.size());
        Assert.assertTrue(attrVals.contains("val21"));
        Assert.assertTrue(attrVals.contains("val22"));

        attrVals = document.getAttribute("key3");
        Assert.assertTrue(attrVals.isEmpty());
        Assert.assertNull(document.getFirstAttribute("key3"));

        Map<String, List<String>> allAttrVals = document.getAttributes();
        Assert.assertEquals(2, allAttrVals.size());
        Assert.assertEquals(allAttrVals.get("key1"), document.getAttribute("key1"));
        Assert.assertEquals(allAttrVals.get("key2"), document.getAttribute("key2"));

        // Test remove and rewrite attribute
        document.removeAttribute("key1");
        document.setSingleAttribute("key2", "val23");

        commit();

        organization = organizationManager.getOrganizationByName("original");
        document = session.documents().getDocumentByTypeAndDocumentId(DocumentType.INVOICE, "document", organization);
        Assert.assertNull(document.getFirstAttribute("key1"));
        attrVals = document.getAttribute("key2");
        Assert.assertEquals(1, attrVals.size());
        Assert.assertEquals("val23", attrVals.get(0));
    }

    @Test
    public void testUpdateDocumentAttribute() throws Exception {
        OrganizationModel organization = organizationManager.createOrganization("original");
        DocumentModel document = session.documents().addDocument(DocumentType.INVOICE, "document", organization);

        document.setSingleAttribute("key1", "value1");

        commit();

        organization = organizationManager.getOrganizationByName("original");
        document = session.documents().getDocumentByTypeAndDocumentId(DocumentType.INVOICE, "document", organization);

        // Update attribute
        List<String> attrVals = new ArrayList<>(Arrays.asList("val2"));
        document.setAttribute("key1", attrVals);
        Map<String, List<String>> allAttrVals = document.getAttributes();

        // Ensure same transaction is able to see updated value
        Assert.assertEquals(1, allAttrVals.size());
        Assert.assertEquals(allAttrVals.get("key1"), Arrays.asList("val2"));

        commit();
    }

    @Test
    public void testUpdateDocumentSingleAttribute() {
        Map<String, List<String>> expected = ImmutableMap.of(
                "key1", Arrays.asList("value3"),
                "key2", Arrays.asList("value2"));

        OrganizationModel organization = organizationManager.createOrganization("original");
        DocumentModel document = session.documents().addDocument(DocumentType.INVOICE, "document", organization);

        document.setSingleAttribute("key1", "value1");
        document.setSingleAttribute("key2", "value2");

        // Overwrite the first attribute
        document.setSingleAttribute("key1", "value3");

        Assert.assertEquals(expected, document.getAttributes());

        commit();

        organization = session.organizations().getOrganizationByName("original");
        Assert.assertEquals(expected, session.documents().getDocumentByTypeAndDocumentId(DocumentType.INVOICE, "document", organization).getAttributes());
    }

    @Test
    public void testSearchByString() {
        OrganizationModel organization = organizationManager.createOrganization("original");
        DocumentModel document1 = session.documents().addDocument(DocumentType.INVOICE, "document1", organization);

        commit();
        organization = session.organizations().getOrganizationByName("original");
        List<DocumentModel> documents = session.documents().searchForDocument("document", organization, 0, 7);
        Assert.assertTrue(documents.contains(document1));
    }

    @Test
    public void testSearchByDocumentAttribute() throws Exception {
        OrganizationModel organization = organizationManager.createOrganization("original");
        DocumentModel document1 = session.documents().addDocument(DocumentType.INVOICE, "document1", organization);
        DocumentModel document2 = session.documents().addDocument(DocumentType.INVOICE, "document2", organization);
        DocumentModel document3 = session.documents().addDocument(DocumentType.INVOICE, "document3", organization);

        document1.setSingleAttribute("key1", "value1");
        document1.setSingleAttribute("key2", "value21");

        document2.setSingleAttribute("key1", "value1");
        document2.setSingleAttribute("key2", "value22");

        document3.setSingleAttribute("key2", "value21");

        commit();
        organization = session.organizations().getOrganizationByName("original");

        List<DocumentModel> documents = session.documents().searchForDocumentByAttribute("key1", "value1", organization);
        Assert.assertEquals(2, documents.size());
        Assert.assertTrue(documents.contains(document1));
        Assert.assertTrue(documents.contains(document2));

        documents = session.documents().searchForDocumentByAttribute("key2", "value21", organization);
        Assert.assertEquals(2, documents.size());
        Assert.assertTrue(documents.contains(document1));
        Assert.assertTrue(documents.contains(document3));

        documents = session.documents().searchForDocumentByAttribute("key2", "value22", organization);
        Assert.assertEquals(1, documents.size());
        Assert.assertTrue(documents.contains(document2));

        documents = session.documents().searchForDocumentByAttribute("key3", "value3", organization);
        Assert.assertEquals(0, documents.size());
    }

    @Test
    public void testDocumentSendEvent() {
        OrganizationModel organization = organizationManager.createOrganization("original");
        DocumentModel document = session.documents().addDocument(DocumentType.INVOICE, "document", organization);

        Assert.assertTrue(document.getSendEvents().isEmpty());

        SendEventModel sendEvent1 = document.addSendEvent(DestinyType.CUSTOMER);
        String id = organization.getId();
        commit();
        organization = organizationManager.getOrganization(id);
        document = session.documents().getDocumentByTypeAndDocumentId(DocumentType.INVOICE, "document", organization);

        Assert.assertEquals(1, document.getSendEvents().size());
        Assert.assertTrue(document.getSendEvents().contains(sendEvent1));
        Assert.assertTrue(sendEvent1.getDestityType().equals(DestinyType.CUSTOMER));

        SendEventModel sendEvent2 = document.addSendEvent(DestinyType.THIRD_PARTY);
        document = session.documents().getDocumentByTypeAndDocumentId(DocumentType.INVOICE, "document", organization);
        Assert.assertTrue(sendEvent2.getDestityType().equals(DestinyType.THIRD_PARTY));

        Assert.assertEquals(2, document.getSendEvents().size());
        Assert.assertTrue(document.getSendEvents().contains(sendEvent2));

        document.removeSendEvent(sendEvent1);
        document = session.documents().getDocumentByTypeAndDocumentId(DocumentType.INVOICE, "document", organization);

        Assert.assertEquals(1, document.getSendEvents().size());
        Assert.assertTrue(document.getSendEvents().contains(sendEvent2));

        document.removeSendEvent(sendEvent2);
        document = session.documents().getDocumentByTypeAndDocumentId(DocumentType.INVOICE, "document", organization);

        Assert.assertTrue(document.getSendEvents().isEmpty());
    }

    @Test
    public void testDocumentSendEventAttributes() throws Exception {
        OrganizationModel organization = organizationManager.createOrganization("original");
        DocumentModel document = session.documents().addDocument(DocumentType.INVOICE, "document", organization);
        SendEventModel sendEvent = document.addSendEvent(DestinyType.CUSTOMER);
        SendEventModel sendEventNoAttrs = document.addSendEvent(DestinyType.THIRD_PARTY);

        String sendEventId = sendEvent.getId();

        sendEvent.setAttribute("key1", "value1");
        commit();

        // Test read attributes
        organization = organizationManager.getOrganizationByName("original");
        document = session.documents().getDocumentByTypeAndDocumentId(DocumentType.INVOICE, "document", organization);
        sendEvent = document.getSendEventById(sendEventId);

        Assert.assertEquals(sendEvent.getAttribute("key1"), "value1");

        sendEvent.setAttribute("key2", "value2");
        Assert.assertEquals(sendEvent.getAttribute("key2"), "value2");

        // Test remove and rewrite attribute
        sendEvent.removeAttribute("key1");
        sendEvent.setAttribute("key3", "value3");

        commit();

        organization = organizationManager.getOrganizationByName("original");
        document = session.documents().getDocumentByTypeAndDocumentId(DocumentType.INVOICE, "document", organization);
        sendEvent = document.getSendEventById(sendEventId);

        Assert.assertNull(sendEvent.getAttribute("key1"));
        Assert.assertEquals(sendEvent.getAttribute("key2"), "value2");
        Assert.assertEquals(sendEvent.getAttribute("key3"), "value3");
    }

    @Test
    public void testSendEventFileAttatchements() {
        OrganizationModel organization = organizationManager.createOrganization("original");
        DocumentModel document = session.documents().addDocument(DocumentType.INVOICE, "document", organization);
        SendEventModel sendEvent = document.addSendEvent(DestinyType.CUSTOMER);
        SendEventModel sendEventNoFileAttatchement = document.addSendEvent(DestinyType.THIRD_PARTY);
        String sendEventId = sendEvent.getId();

        Assert.assertTrue(sendEvent.getAttachedFiles().isEmpty());

        FileModel file1 = session.getProvider(FileProvider.class).createFile(organization, "file1.xml", new byte[]{0, 1, 2, 3});
        sendEvent.attachFile(file1);

        Assert.assertEquals(1, sendEvent.getAttachedFiles().size());
        commit();

        document = session.documents().getDocumentByTypeAndDocumentId(DocumentType.INVOICE, "document", organization);
        sendEvent = document.getSendEventById(sendEventId);

        Assert.assertEquals(1, sendEvent.getAttachedFiles().size());
        Assert.assertTrue(sendEvent.getAttachedFiles().contains(file1));

        FileModel file2 = session.getProvider(FileProvider.class).createFile(organization, "file2.xml", new byte[]{0, 1, 2, 3, 4, 5});
        sendEvent.attachFile(file2);

        Assert.assertEquals(2, sendEvent.getAttachedFiles().size());
        Assert.assertTrue(sendEvent.getAttachedFiles().contains(file2));

        sendEvent.unattachResponseFile(file1);
        Assert.assertEquals(1, sendEvent.getAttachedFiles().size());
        Assert.assertTrue(sendEvent.getAttachedFiles().contains(file2));

        commit();
    }

    @Test
    public void testSendEventFileAttatchements1() {
        OrganizationModel organization = organizationManager.createOrganization("original");
        DocumentModel document = session.documents().addDocument(DocumentType.INVOICE, "document", organization);
        SendEventModel sendEvent = document.addSendEvent(DestinyType.CUSTOMER);
        SendEventModel sendEventNoFileResponseAttatchement = document.addSendEvent(DestinyType.THIRD_PARTY);
        String sendEventId = sendEvent.getId();

        Assert.assertTrue(sendEvent.getAttachedFiles().isEmpty());

        FileModel file1 = session.getProvider(FileProvider.class).createFile(organization, "file1.xml", new byte[]{0, 1, 2, 3});
        sendEvent.attachFile(file1);

        Assert.assertEquals(1, sendEvent.getAttachedFiles().size());
        commit();

        document = session.documents().getDocumentByTypeAndDocumentId(DocumentType.INVOICE, "document", organization);
        sendEvent = document.getSendEventById(sendEventId);

        Assert.assertEquals(1, sendEvent.getAttachedFiles().size());
        Assert.assertTrue(sendEvent.getAttachedFiles().contains(file1));

        FileModel file2 = session.getProvider(FileProvider.class).createFile(organization, "file2.xml", new byte[]{0, 1, 2, 3, 4, 5});
        sendEvent.attachFile(file2);

        Assert.assertEquals(2, sendEvent.getAttachedFiles().size());
        Assert.assertTrue(sendEvent.getAttachedFiles().contains(file2));

        sendEvent.unattachResponseFile(file1);
        sendEvent = document.getSendEventById(sendEventId);

        Assert.assertEquals(1, sendEvent.getAttachedFiles().size());
        Assert.assertTrue(sendEvent.getAttachedFiles().contains(file2));

        sendEvent.unattachResponseFile(file2);
        sendEvent = document.getSendEventById(sendEventId);

        Assert.assertTrue(sendEvent.getAttachedFiles().isEmpty());

        commit();

        organization = organizationManager.getOrganizationByName("original");
        document = session.documents().getDocumentByTypeAndDocumentId(DocumentType.INVOICE, "document", organization);
        sendEvent = document.getSendEventById(sendEventId);
        Assert.assertTrue(sendEvent.getAttachedFiles().isEmpty());
    }

    @Test
    public void testXmlFileAttatch() {
        OrganizationModel organization = organizationManager.createOrganization("original");
        DocumentModel document = session.documents().addDocument(DocumentType.INVOICE, "document", organization);

        Assert.assertNull(document.getXmlAsFile());

        FileModel file1 = session.getProvider(FileProvider.class).createFile(organization, "file1.xml", new byte[]{0, 1, 2, 3});
        String file1Id = file1.getId();
        document.attachXmlFile(file1);

        Assert.assertNotNull(document.getXmlAsFile());
        commit();

        document = session.documents().getDocumentByTypeAndDocumentId(DocumentType.INVOICE, "document", organization);

        Assert.assertNotNull(document.getXmlAsFile());
        Assert.assertEquals(document.getXmlAsFile(), session.getProvider(FileProvider.class).getFileById(organization, file1Id));

        FileModel file2 = session.getProvider(FileProvider.class).createFile(organization, "file2.xml", new byte[]{0, 1, 2, 3, 4, 5});
        String file2Id = file2.getId();
        document.attachXmlFile(file2);

        Assert.assertNotNull(document.getXmlAsFile());
        Assert.assertEquals(document.getXmlAsFile(), session.getProvider(FileProvider.class).getFileById(organization, file2Id));

        commit();

        organization = organizationManager.getOrganizationByName("original");
        document = session.documents().getDocumentByTypeAndDocumentId(DocumentType.INVOICE, "document", organization);

        Assert.assertNotNull(document.getXmlAsFile());
        Assert.assertEquals(document.getXmlAsFile(), session.getProvider(FileProvider.class).getFileById(organization, file2Id));
    }

    @Test
    public void testAttatchedDocuments() {
        OrganizationModel organization = organizationManager.createOrganization("original");
        DocumentModel invoice = session.documents().addDocument(DocumentType.INVOICE, "invoiceEntity", organization);
        DocumentModel creditNote = session.documents().addDocument(DocumentType.CREDIT_NOTE.toString(), "creditNoteEntity", organization);

        Assert.assertTrue(invoice.getAttachedDocumentsAsOrigin().isEmpty());
        Assert.assertTrue(invoice.getAttachedDocumentsAsDestiny().isEmpty());

        invoice.addAttachedDocument(creditNote);
        String organizationId = organization.getId();

        Assert.assertEquals(1, invoice.getAttachedDocumentsAsOrigin().size());
        Assert.assertEquals(0, invoice.getAttachedDocumentsAsDestiny().size());
        Assert.assertTrue(invoice.getAttachedDocumentsAsOrigin().contains(creditNote));

        Assert.assertEquals(0, creditNote.getAttachedDocumentsAsOrigin().size());
        Assert.assertEquals(1, creditNote.getAttachedDocumentsAsDestiny().size());
        Assert.assertTrue(creditNote.getAttachedDocumentsAsDestiny().contains(invoice));

        commit();

        organization = organizationManager.getOrganization(organizationId);
        invoice = session.documents().getDocumentByTypeAndDocumentId(DocumentType.INVOICE, "invoiceEntity", organization);
        creditNote = session.documents().getDocumentByTypeAndDocumentId(DocumentType.CREDIT_NOTE, "creditNoteEntity", organization);

        Assert.assertEquals(1, invoice.getAttachedDocumentsAsOrigin().size());
        Assert.assertEquals(0, invoice.getAttachedDocumentsAsDestiny().size());
        Assert.assertEquals(0, creditNote.getAttachedDocumentsAsOrigin().size());
        Assert.assertEquals(1, creditNote.getAttachedDocumentsAsDestiny().size());

        Assert.assertTrue(invoice.getAttachedDocumentsAsOrigin().contains(creditNote));


        DocumentModel debitNote = session.documents().addDocument(DocumentType.DEBIT_NOTE, "debitNoteEntity", organization);
        invoice.addAttachedDocument(debitNote);

        Assert.assertEquals(2, invoice.getAttachedDocumentsAsOrigin().size());
        Assert.assertEquals(0, invoice.getAttachedDocumentsAsDestiny().size());
        Assert.assertTrue(invoice.getAttachedDocumentsAsOrigin().contains(debitNote));

        Assert.assertEquals(0, debitNote.getAttachedDocumentsAsOrigin().size());
        Assert.assertEquals(1, debitNote.getAttachedDocumentsAsDestiny().size());
        Assert.assertTrue(debitNote.getAttachedDocumentsAsDestiny().contains(invoice));

        commit();

        organization = organizationManager.getOrganization(organizationId);
        invoice = session.documents().getDocumentByTypeAndDocumentId(DocumentType.INVOICE, "invoiceEntity", organization);
        creditNote = session.documents().getDocumentByTypeAndDocumentId(DocumentType.CREDIT_NOTE, "creditNoteEntity", organization);
        debitNote = session.documents().getDocumentByTypeAndDocumentId(DocumentType.DEBIT_NOTE, "debitNoteEntity", organization);

        Assert.assertEquals(2, invoice.getAttachedDocumentsAsOrigin().size());
        Assert.assertEquals(0, invoice.getAttachedDocumentsAsDestiny().size());
        Assert.assertTrue(invoice.getAttachedDocumentsAsOrigin().contains(debitNote));

        Assert.assertEquals(0, debitNote.getAttachedDocumentsAsOrigin().size());
        Assert.assertEquals(1, debitNote.getAttachedDocumentsAsDestiny().size());
        Assert.assertTrue(debitNote.getAttachedDocumentsAsDestiny().contains(invoice));

        invoice.removeAttachedDocument(creditNote);

        Assert.assertEquals(1, invoice.getAttachedDocumentsAsOrigin().size());
        Assert.assertEquals(0, invoice.getAttachedDocumentsAsDestiny().size());
        Assert.assertFalse(invoice.getAttachedDocumentsAsOrigin().contains(creditNote));

        Assert.assertEquals(0, creditNote.getAttachedDocumentsAsOrigin().size());
        Assert.assertEquals(0, creditNote.getAttachedDocumentsAsDestiny().size());
        Assert.assertFalse(creditNote.getAttachedDocumentsAsDestiny().contains(invoice));
    }

    public static void assertEquals(DocumentModel expected, DocumentModel actual) {
        Assert.assertEquals(expected.getDocumentId(), actual.getDocumentId());
        Assert.assertEquals(expected.getCreatedTimestamp(), actual.getCreatedTimestamp());
        Assert.assertEquals(expected.getCustomerElectronicMail(), actual.getCustomerElectronicMail());

        String[] expectedRequiredActions = expected.getRequiredActions().toArray(new String[expected.getRequiredActions().size()]);
        Arrays.sort(expectedRequiredActions);
        String[] actualRequiredActions = actual.getRequiredActions().toArray(new String[actual.getRequiredActions().size()]);
        Arrays.sort(actualRequiredActions);

        Assert.assertArrayEquals(expectedRequiredActions, actualRequiredActions);
    }

}
