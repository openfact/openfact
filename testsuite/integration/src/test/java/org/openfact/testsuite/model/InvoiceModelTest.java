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
        InvoiceModel persisted2 = session.invoices().getInvoiceById(searchOrganization, invoice.getId());
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
        List<String> attrVals = new ArrayList<>(Arrays.asList("val21", "val22"));
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
        List<String> attrVals = new ArrayList<>(Arrays.asList("val2"));
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

        List<InvoiceModel> invoices = session.invoices().searchForInvoiceByAttribute("key1", "value1", realm);
        Assert.assertEquals(2, invoices.size());
        Assert.assertTrue(invoices.contains(invoice1));
        Assert.assertTrue(invoices.contains(invoice2));

        invoices = session.invoices().searchForInvoiceByAttribute("key2", "value21", realm);
        Assert.assertEquals(2, invoices.size());
        Assert.assertTrue(invoices.contains(invoice1));
        Assert.assertTrue(invoices.contains(invoice3));

        invoices = session.invoices().searchForInvoiceByAttribute("key2", "value22", realm);
        Assert.assertEquals(1, invoices.size());
        Assert.assertTrue(invoices.contains(invoice2));

        invoices = session.invoices().searchForInvoiceByAttribute("key3", "value3", realm);
        Assert.assertEquals(0, invoices.size());
    }

    @Test
    public void testInvoiceSendEvent() {
        OrganizationModel organization = organizationManager.createOrganization("original");
        InvoiceModel invoice = session.invoices().addInvoice(organization, "invoice");

        Assert.assertTrue(invoice.getSendEvents().isEmpty());

        SendEventModel sendEvent1 = invoice.addSendEvent(DestinyType.CUSTOMER);
        String id = organization.getId();
        commit();
        organization = organizationManager.getOrganization(id);
        invoice = session.invoices().getInvoiceByDocumentId(organization, "invoice");

        Assert.assertEquals(1, invoice.getSendEvents().size());
        Assert.assertTrue(invoice.getSendEvents().contains(sendEvent1));
        Assert.assertTrue(sendEvent1.getDestityType().equals(DestinyType.CUSTOMER));

        SendEventModel sendEvent2 = invoice.addSendEvent(DestinyType.THIRD_PARTY);
        invoice = session.invoices().getInvoiceByDocumentId(organization, "invoice");
        Assert.assertTrue(sendEvent2.getDestityType().equals(DestinyType.THIRD_PARTY));

        Assert.assertEquals(2, invoice.getSendEvents().size());
        Assert.assertTrue(invoice.getSendEvents().contains(sendEvent2));

        invoice.removeSendEvent(sendEvent1);
        invoice = session.invoices().getInvoiceByDocumentId(organization, "invoice");

        Assert.assertEquals(1, invoice.getSendEvents().size());
        Assert.assertTrue(invoice.getSendEvents().contains(sendEvent2));

        invoice.removeSendEvent(sendEvent2);
        invoice = session.invoices().getInvoiceByDocumentId(organization, "invoice");

        Assert.assertTrue(invoice.getSendEvents().isEmpty());
    }

    @Test
    public void testInvoiceSendEventDestinyMultipleAttributes() throws Exception {
        OrganizationModel organization = organizationManager.createOrganization("original");
        InvoiceModel invoice = session.invoices().addInvoice(organization, "invoice");
        SendEventModel sendEvent = invoice.addSendEvent(DestinyType.CUSTOMER);
        SendEventModel sendEventNoAttrs = invoice.addSendEvent(DestinyType.THIRD_PARTY);

        String sendEventId = sendEvent.getId();

        sendEvent.setSingleDestinyAttribute("key1", "value1");
        List<String> attrVals = new ArrayList<>(Arrays.asList("val21", "val22"));
        sendEvent.setDestinyAttribute("key2", attrVals);

        commit();

        // Test read attributes
        organization = organizationManager.getOrganizationByName("original");
        invoice = session.invoices().getInvoiceByDocumentId(organization, "invoice");
        sendEvent = invoice.getSendEventById(sendEventId);

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
        invoice = session.invoices().getInvoiceByDocumentId(organization, "invoice");
        sendEvent = invoice.getSendEventById(sendEventId);
        Assert.assertNull(sendEvent.getFirstDestinyAttribute("key1"));
        attrVals = sendEvent.getDestinyAttribute("key2");
        Assert.assertEquals(1, attrVals.size());
        Assert.assertEquals("val23", attrVals.get(0));
    }

    @Test
    public void testUpdateSendEventDestinyAttribute() throws Exception {
        OrganizationModel organization = organizationManager.createOrganization("original");
        InvoiceModel invoice = session.invoices().addInvoice(organization, "invoice");
        SendEventModel sendEvent = invoice.addSendEvent(DestinyType.CUSTOMER);
        String sendEventId = sendEvent.getId();

        sendEvent.setSingleDestinyAttribute("key1", "value1");

        commit();

        organization = organizationManager.getOrganizationByName("original");
        invoice = session.invoices().getInvoiceByDocumentId(organization, "invoice");
        sendEvent = invoice.getSendEventById(sendEventId);

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
        InvoiceModel invoice = session.invoices().addInvoice(organization, "invoice");
        SendEventModel sendEvent = invoice.addSendEvent(DestinyType.CUSTOMER);
        String sendEventId = sendEvent.getId();

        sendEvent.setSingleDestinyAttribute("key1", "value1");
        sendEvent.setSingleDestinyAttribute("key2", "value2");

        // Overwrite the first attribute
        sendEvent.setSingleDestinyAttribute("key1", "value3");

        Assert.assertEquals(expected, sendEvent.getDestinyAttributes());

        commit();

        organization = session.organizations().getOrganizationByName("original");
        invoice = session.invoices().getInvoiceByDocumentId(organization, "invoice");
        sendEvent = invoice.getSendEventById(sendEventId);
        Assert.assertEquals(expected, sendEvent.getDestinyAttributes());
    }

    @Test
    public void testInvoiceSendEventResponseMultipleAttributes() throws Exception {
        OrganizationModel organization = organizationManager.createOrganization("original");
        InvoiceModel invoice = session.invoices().addInvoice(organization, "invoice");
        SendEventModel sendEvent = invoice.addSendEvent(DestinyType.CUSTOMER);
        SendEventModel sendEventNoAttrs = invoice.addSendEvent(DestinyType.THIRD_PARTY);

        String sendEventId = sendEvent.getId();

        sendEvent.setSingleResponseAttribute("key1", "value1");
        List<String> attrVals = new ArrayList<>(Arrays.asList("val21", "val22"));
        sendEvent.setResponseAttribute("key2", attrVals);

        commit();

        // Test read attributes
        organization = organizationManager.getOrganizationByName("original");
        invoice = session.invoices().getInvoiceByDocumentId(organization, "invoice");
        sendEvent = invoice.getSendEventById(sendEventId);

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
        invoice = session.invoices().getInvoiceByDocumentId(organization, "invoice");
        sendEvent = invoice.getSendEventById(sendEventId);
        Assert.assertNull(sendEvent.getFirstResponseAttribute("key1"));
        attrVals = sendEvent.getResponseAttribute("key2");
        Assert.assertEquals(1, attrVals.size());
        Assert.assertEquals("val23", attrVals.get(0));
    }

    @Test
    public void testUpdateSendEventResponseAttribute() throws Exception {
        OrganizationModel organization = organizationManager.createOrganization("original");
        InvoiceModel invoice = session.invoices().addInvoice(organization, "invoice");
        SendEventModel sendEvent = invoice.addSendEvent(DestinyType.CUSTOMER);
        String sendEventId = sendEvent.getId();

        sendEvent.setSingleResponseAttribute("key1", "value1");

        commit();

        organization = organizationManager.getOrganizationByName("original");
        invoice = session.invoices().getInvoiceByDocumentId(organization, "invoice");
        sendEvent = invoice.getSendEventById(sendEventId);

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
        InvoiceModel invoice = session.invoices().addInvoice(organization, "invoice");
        SendEventModel sendEvent = invoice.addSendEvent(DestinyType.CUSTOMER);
        String sendEventId = sendEvent.getId();

        sendEvent.setSingleResponseAttribute("key1", "value1");
        sendEvent.setSingleResponseAttribute("key2", "value2");

        // Overwrite the first attribute
        sendEvent.setSingleResponseAttribute("key1", "value3");

        Assert.assertEquals(expected, sendEvent.getResponseAttributes());

        commit();

        organization = session.organizations().getOrganizationByName("original");
        invoice = session.invoices().getInvoiceByDocumentId(organization, "invoice");
        sendEvent = invoice.getSendEventById(sendEventId);
        Assert.assertEquals(expected, sendEvent.getResponseAttributes());
    }

    @Test
    public void testSendEventFileAttatchements() {
        OrganizationModel organization = organizationManager.createOrganization("original");
        InvoiceModel invoice = session.invoices().addInvoice(organization, "invoice");
        SendEventModel sendEvent = invoice.addSendEvent(DestinyType.CUSTOMER);
        SendEventModel sendEventNoFileAttatchement = invoice.addSendEvent(DestinyType.THIRD_PARTY);
        String sendEventId = sendEvent.getId();

        Assert.assertTrue(sendEvent.getFileAttatchments().isEmpty());

        FileModel file1 = session.getProvider(FileProvider.class).createFile(organization, "file1.xml", new byte[]{0,1,2,3});
        sendEvent.attachFile(file1);

        Assert.assertEquals(1, sendEvent.getFileAttatchments().size());
        commit();

        invoice = session.invoices().getInvoiceByDocumentId(organization, "invoice");
        sendEvent = invoice.getSendEventById(sendEventId);

        Assert.assertEquals(1, sendEvent.getFileAttatchments().size());
        Assert.assertTrue(sendEvent.getFileAttatchments().contains(file1));

        FileModel file2 = session.getProvider(FileProvider.class).createFile(organization, "file2.xml", new byte[]{0,1,2,3,4,5});
        sendEvent.attachFile(file2);

        Assert.assertEquals(2, sendEvent.getFileAttatchments().size());
        Assert.assertTrue(sendEvent.getFileAttatchments().contains(file2));

        sendEvent.unattachFile(file1);
        sendEvent = invoice.getSendEventById(sendEventId);

        Assert.assertEquals(1, sendEvent.getFileAttatchments().size());
        Assert.assertTrue(sendEvent.getFileAttatchments().contains(file2));

        sendEvent.unattachFile(file2);
        sendEvent = invoice.getSendEventById(sendEventId);

        Assert.assertTrue(sendEvent.getFileAttatchments().isEmpty());

        commit();

        organization = organizationManager.getOrganizationByName("original");
        invoice = session.invoices().getInvoiceByDocumentId(organization, "invoice");
        sendEvent = invoice.getSendEventById(sendEventId);
        Assert.assertTrue(sendEvent.getFileAttatchments().isEmpty());
    }

    @Test
    public void testSendEventResponseFileAttatchements1() {
        OrganizationModel organization = organizationManager.createOrganization("original");
        InvoiceModel invoice = session.invoices().addInvoice(organization, "invoice");
        SendEventModel sendEvent = invoice.addSendEvent(DestinyType.CUSTOMER);
        SendEventModel sendEventNoFileResponseAttatchement = invoice.addSendEvent(DestinyType.THIRD_PARTY);
        String sendEventId = sendEvent.getId();

        Assert.assertTrue(sendEvent.getResponseFileAttatchments().isEmpty());

        FileModel file1 = session.getProvider(FileProvider.class).createFile(organization, "file1.xml", new byte[]{0,1,2,3});
        sendEvent.attachResponseFile(file1);

        Assert.assertEquals(1, sendEvent.getResponseFileAttatchments().size());
        commit();

        invoice = session.invoices().getInvoiceByDocumentId(organization, "invoice");
        sendEvent = invoice.getSendEventById(sendEventId);

        Assert.assertEquals(1, sendEvent.getResponseFileAttatchments().size());
        Assert.assertTrue(sendEvent.getResponseFileAttatchments().contains(file1));

        FileModel file2 = session.getProvider(FileProvider.class).createFile(organization, "file2.xml", new byte[]{0,1,2,3,4,5});
        sendEvent.attachResponseFile(file2);

        Assert.assertEquals(2, sendEvent.getResponseFileAttatchments().size());
        Assert.assertTrue(sendEvent.getResponseFileAttatchments().contains(file2));

        sendEvent.unattachResponseFile(file1);
        sendEvent = invoice.getSendEventById(sendEventId);

        Assert.assertEquals(1, sendEvent.getResponseFileAttatchments().size());
        Assert.assertTrue(sendEvent.getResponseFileAttatchments().contains(file2));

        sendEvent.unattachResponseFile(file2);
        sendEvent = invoice.getSendEventById(sendEventId);

        Assert.assertTrue(sendEvent.getResponseFileAttatchments().isEmpty());

        commit();

        organization = organizationManager.getOrganizationByName("original");
        invoice = session.invoices().getInvoiceByDocumentId(organization, "invoice");
        sendEvent = invoice.getSendEventById(sendEventId);
        Assert.assertTrue(sendEvent.getResponseFileAttatchments().isEmpty());
    }

    @Test
    public void testXmlFileAttatch() {
        OrganizationModel organization = organizationManager.createOrganization("original");
        InvoiceModel invoice = session.invoices().addInvoice(organization, "invoice");

        Assert.assertNull(invoice.getXmlAsFile());

        FileModel file1 = session.getProvider(FileProvider.class).createFile(organization, "file1.xml", new byte[]{0,1,2,3});
        String file1Id = file1.getId();
        invoice.attachXmlFile(file1);

        Assert.assertNotNull(invoice.getXmlAsFile());
        commit();

        invoice = session.invoices().getInvoiceByDocumentId(organization, "invoice");

        Assert.assertNotNull(invoice.getXmlAsFile());
        Assert.assertEquals(invoice.getXmlAsFile(), session.getProvider(FileProvider.class).getFileById(organization, file1Id));

        FileModel file2 = session.getProvider(FileProvider.class).createFile(organization, "file2.xml", new byte[]{0,1,2,3,4,5});
        String file2Id = file2.getId();
        invoice.attachXmlFile(file2);

        Assert.assertNotNull(invoice.getXmlAsFile());
        Assert.assertEquals(invoice.getXmlAsFile(), session.getProvider(FileProvider.class).getFileById(organization, file2Id));

        commit();

        organization = organizationManager.getOrganizationByName("original");
        invoice = session.invoices().getInvoiceByDocumentId(organization, "invoice");

        Assert.assertNotNull(invoice.getXmlAsFile());
        Assert.assertEquals(invoice.getXmlAsFile(), session.getProvider(FileProvider.class).getFileById(organization, file2Id));
    }

    @Test
    public void testAttatchedDocuments() {
        OrganizationModel organization = organizationManager.createOrganization("original");
        InvoiceModel invoice = session.invoices().addInvoice(organization, "invoice");

        Assert.assertTrue(invoice.getSendEvents().isEmpty());

        AttatchedDocumentModel attatchedDocument1 = invoice.addAttatchedDocument(DocumentType.CREDIT_NOTE, "credit-note");
        String id = organization.getId();
        commit();
        organization = organizationManager.getOrganization(id);
        invoice = session.invoices().getInvoiceByDocumentId(organization, "invoice");

        Assert.assertEquals(1, invoice.getAttatchedDocuments().size());
        Assert.assertTrue(invoice.getAttatchedDocuments().contains(attatchedDocument1));
        Assert.assertEquals(attatchedDocument1.getDocumentType(), DocumentType.CREDIT_NOTE);
        Assert.assertEquals(attatchedDocument1.getDocumentId(), "credit-note");

        AttatchedDocumentModel attatchedDocument2 = invoice.addAttatchedDocument(DocumentType.DEBIT_NOTE, "debit-note");
        invoice = session.invoices().getInvoiceByDocumentId(organization, "invoice");
        Assert.assertEquals(attatchedDocument2.getDocumentType(), DocumentType.DEBIT_NOTE);
        Assert.assertEquals(attatchedDocument2.getDocumentId(), "debit-note");

        Assert.assertEquals(2, invoice.getAttatchedDocuments().size());
        Assert.assertTrue(invoice.getAttatchedDocuments().contains(attatchedDocument2));

        invoice.removeAttatchedDocument(attatchedDocument1);
        invoice = session.invoices().getInvoiceByDocumentId(organization, "invoice");

        Assert.assertEquals(1, invoice.getAttatchedDocuments().size());
        Assert.assertTrue(invoice.getAttatchedDocuments().contains(attatchedDocument2));

        invoice.removeAttatchedDocument(attatchedDocument2);
        invoice = session.invoices().getInvoiceByDocumentId(organization, "invoice");

        Assert.assertTrue(invoice.getAttatchedDocuments().isEmpty());
    }

    @Test
    public void testAttatchedDocumentsMultipleAttributes() throws Exception {
        OrganizationModel organization = organizationManager.createOrganization("original");
        InvoiceModel invoice = session.invoices().addInvoice(organization, "invoice");
        AttatchedDocumentModel attachmentDocument = invoice.addAttatchedDocument(DocumentType.CREDIT_NOTE, "credit-note");
        AttatchedDocumentModel attachmentDocumentNoAttrs = invoice.addAttatchedDocument(DocumentType.CREDIT_NOTE, "credit-note");

        String attachmentDocumentId = attachmentDocument.getId();

        attachmentDocument.setSingleAttribute("key1", "value1");
        List<String> attrVals = new ArrayList<>(Arrays.asList("val21", "val22"));
        attachmentDocument.setAttribute("key2", attrVals);

        commit();

        // Test read attributes
        organization = organizationManager.getOrganizationByName("original");
        invoice = session.invoices().getInvoiceByDocumentId(organization, "invoice");
        attachmentDocument = invoice.getAttatchedDocumentById(attachmentDocumentId);

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
        invoice = session.invoices().getInvoiceByDocumentId(organization, "invoice");
        attachmentDocument = invoice.getAttatchedDocumentById(attachmentDocumentId);
        Assert.assertNull(attachmentDocument.getFirstAttribute("key1"));
        attrVals = attachmentDocument.getAttribute("key2");
        Assert.assertEquals(1, attrVals.size());
        Assert.assertEquals("val23", attrVals.get(0));
    }

    @Test
    public void testUpdateAttatchedDocumentsAttribute() throws Exception {
        OrganizationModel organization = organizationManager.createOrganization("original");
        InvoiceModel invoice = session.invoices().addInvoice(organization, "invoice");
        AttatchedDocumentModel attatchedDocument = invoice.addAttatchedDocument(DocumentType.CREDIT_NOTE, "credit-note");
        String attatchedDocumentId = attatchedDocument.getId();

        attatchedDocument.setSingleAttribute("key1", "value1");

        commit();

        organization = organizationManager.getOrganizationByName("original");
        invoice = session.invoices().getInvoiceByDocumentId(organization, "invoice");
        attatchedDocument = invoice.getAttatchedDocumentById(attatchedDocumentId);

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
        InvoiceModel invoice = session.invoices().addInvoice(organization, "invoice");
        AttatchedDocumentModel attatchedDocument = invoice.addAttatchedDocument(DocumentType.CREDIT_NOTE, "credit-note");
        String attatchedDocumentId = attatchedDocument.getId();

        attatchedDocument.setSingleAttribute("key1", "value1");
        attatchedDocument.setSingleAttribute("key2", "value2");

        // Overwrite the first attribute
        attatchedDocument.setSingleAttribute("key1", "value3");

        Assert.assertEquals(expected, attatchedDocument.getAttributes());

        commit();

        organization = session.organizations().getOrganizationByName("original");
        invoice = session.invoices().getInvoiceByDocumentId(organization, "invoice");
        attatchedDocument = invoice.getAttatchedDocumentById(attatchedDocumentId);
        Assert.assertEquals(expected, attatchedDocument.getAttributes());
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
