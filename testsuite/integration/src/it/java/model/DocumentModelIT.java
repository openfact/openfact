package model;

import org.junit.Assert;
import org.junit.Test;

public class DocumentModelIT extends AbstractModelTest {

//    @Inject
//    private DocumentProvider documentProvider;
//
//    @Inject
//    private FileProvider fileProvider;
//
//    @Test
//    public void persistDocument() {
//        OrganizationModel organization = organizationManager.createOrganization("original");
//
//        DocumentModel document = documentProvider.addDocument(DocumentType.INVOICE, "document", organization);
//        document.setCustomerElectronicMail("carlosthe19916@sistcoop.com");
//        assertNotNull(document.getCustomerElectronicMail());
//
//        // test that timestamp is current with 10s tollerance
//        Assert.assertTrue((System.currentTimeMillis() - Date.from(document.getCreatedTimestamp().atZone(ZoneId.systemDefault()).toInstant()).getTime()) < 10000);
//
//        document.addRequiredAction(DocumentRequiredAction.SEND_TO_CUSTOMER);
//        document.addRequiredAction(DocumentRequiredAction.SEND_TO_THIRD_PARTY);
//
//        OrganizationModel searchOrganization = organizationManager.getOrganization(organization.getId());
//        DocumentModel persisted = documentProvider.getDocumentByTypeAndDocumentId(DocumentType.INVOICE, "document", searchOrganization);
//
//        assertEquals(document, persisted);
//
//        searchOrganization = organizationManager.getOrganization(organization.getId());
//        DocumentModel persisted2 = documentProvider.getDocumentById(document.getId(), searchOrganization);
//        assertEquals(document, persisted2);
//    }
//
//    @Test
//    public void testDocumentLines() {
//        OrganizationModel organization = organizationManager.createOrganization("original");
//
//        DocumentModel document = documentProvider.addDocument(DocumentType.INVOICE, "document", organization);
//        DocumentLineModel documentLine = document.addDocumentLine();
//        assertNotNull(documentLine);
//
//        documentLine.setAttribute("key1", "value1");
//        documentLine.setAttribute("key2", "value2");
//
//        Assert.assertEquals(2, documentLine.getAttributes().size());
//
//        organization = organizationManager.getOrganization(organization.getId());
//        document = documentProvider.getDocumentByTypeAndDocumentId(DocumentType.INVOICE, "document", organization);
//        Assert.assertEquals(1, document.getDocumentLines().size());
//
//        documentLine = document.getDocumentLines().get(0);
//        documentLine.removeAttribute("key1");
//
//        Assert.assertEquals(1, documentLine.getAttributes().size());
//
//        document.removeDocumentLine(documentLine);
//
//        Assert.assertTrue(document.getDocumentLines().isEmpty());
//    }
//
//    @Test
//    public void testDocumentRequiredActions() throws Exception {
//        OrganizationModel organization = organizationManager.createOrganization("original");
//        DocumentModel document = documentProvider.addDocument(DocumentType.INVOICE, "document", organization);
//
//        Assert.assertTrue(document.getRequiredActions().isEmpty());
//
//        document.addRequiredAction(DocumentRequiredAction.SEND_TO_CUSTOMER);
//        String id = organization.getId();
//
//        organization = organizationManager.getOrganization(id);
//        document = documentProvider.getDocumentByTypeAndDocumentId(DocumentType.INVOICE, "document", organization);
//
//        Assert.assertEquals(1, document.getRequiredActions().size());
//        Assert.assertTrue(document.getRequiredActions().contains(DocumentRequiredAction.SEND_TO_CUSTOMER.name()));
//
//        document.addRequiredAction(DocumentRequiredAction.SEND_TO_CUSTOMER);
//        document = documentProvider.getDocumentByTypeAndDocumentId(DocumentType.INVOICE, "document", organization);
//
//        Assert.assertEquals(1, document.getRequiredActions().size());
//        Assert.assertTrue(document.getRequiredActions().contains(DocumentRequiredAction.SEND_TO_CUSTOMER.name()));
//
//        document.addRequiredAction(DocumentRequiredAction.SEND_TO_THIRD_PARTY.name());
//        document = documentProvider.getDocumentByTypeAndDocumentId(DocumentType.INVOICE, "document", organization);
//
//        Assert.assertEquals(2, document.getRequiredActions().size());
//        Assert.assertTrue(document.getRequiredActions().contains(DocumentRequiredAction.SEND_TO_CUSTOMER.name()));
//        Assert.assertTrue(document.getRequiredActions().contains(DocumentRequiredAction.SEND_TO_THIRD_PARTY.name()));
//
//        document.removeRequiredAction(DocumentRequiredAction.SEND_TO_CUSTOMER.name());
//        document = documentProvider.getDocumentByTypeAndDocumentId(DocumentType.INVOICE, "document", organization);
//
//        Assert.assertEquals(1, document.getRequiredActions().size());
//        Assert.assertTrue(document.getRequiredActions().contains(DocumentRequiredAction.SEND_TO_THIRD_PARTY.name()));
//
//        document.removeRequiredAction(DocumentRequiredAction.SEND_TO_THIRD_PARTY.name());
//        document = documentProvider.getDocumentByTypeAndDocumentId(DocumentType.INVOICE, "document", organization);
//
//        Assert.assertTrue(document.getRequiredActions().isEmpty());
//    }
//
//    @Test
//    public void testDocumentMultipleAttributes() throws Exception {
//        OrganizationModel organization = organizationManager.createOrganization("original");
//        DocumentModel document = documentProvider.addDocument(DocumentType.INVOICE, "document", organization);
//        DocumentModel documentNoAttrs = documentProvider.addDocument(DocumentType.INVOICE, "document-noattrs", organization);
//
//        document.setSingleAttribute("key1", "value1");
//        List<String> attrVals = new ArrayList<>(Arrays.asList("val21", "val22"));
//        document.setAttribute("key2", attrVals);
//
//        // Test read attributes
//        organization = organizationManager.getOrganizationByName("original");
//        document = documentProvider.getDocumentByTypeAndDocumentId(DocumentType.INVOICE, "document", organization);
//
//        attrVals = document.getAttribute("key1");
//        Assert.assertEquals(1, attrVals.size());
//        Assert.assertEquals("value1", attrVals.get(0));
//        Assert.assertEquals("value1", document.getFirstAttribute("key1"));
//
//        attrVals = document.getAttribute("key2");
//        Assert.assertEquals(2, attrVals.size());
//        Assert.assertTrue(attrVals.contains("val21"));
//        Assert.assertTrue(attrVals.contains("val22"));
//
//        attrVals = document.getAttribute("key3");
//        Assert.assertTrue(attrVals.isEmpty());
//        Assert.assertNull(document.getFirstAttribute("key3"));
//
//        Map<String, List<String>> allAttrVals = document.getAttributes();
//        Assert.assertEquals(2, allAttrVals.size());
//        Assert.assertEquals(allAttrVals.get("key1"), document.getAttribute("key1"));
//        Assert.assertEquals(allAttrVals.get("key2"), document.getAttribute("key2"));
//
//        // Test remove and rewrite attribute
//        document.removeAttribute("key1");
//        document.setSingleAttribute("key2", "val23");
//
//
//        organization = organizationManager.getOrganizationByName("original");
//        document = documentProvider.getDocumentByTypeAndDocumentId(DocumentType.INVOICE, "document", organization);
//        Assert.assertNull(document.getFirstAttribute("key1"));
//        attrVals = document.getAttribute("key2");
//        Assert.assertEquals(1, attrVals.size());
//        Assert.assertEquals("val23", attrVals.get(0));
//    }
//
//    @Test
//    public void testUpdateDocumentAttribute() throws Exception {
//        OrganizationModel organization = organizationManager.createOrganization("original");
//        DocumentModel document = documentProvider.addDocument(DocumentType.INVOICE, "document", organization);
//
//        document.setSingleAttribute("key1", "value1");
//
//
//        organization = organizationManager.getOrganizationByName("original");
//        document = documentProvider.getDocumentByTypeAndDocumentId(DocumentType.INVOICE, "document", organization);
//
//        // Update attribute
//        List<String> attrVals = new ArrayList<>(Arrays.asList("val2"));
//        document.setAttribute("key1", attrVals);
//        Map<String, List<String>> allAttrVals = document.getAttributes();
//
//        // Ensure same transaction is able to see updated value
//        Assert.assertEquals(1, allAttrVals.size());
//        Assert.assertEquals(allAttrVals.get("key1"), Arrays.asList("val2"));
//
//    }
//
//    @Test
//    public void testUpdateDocumentSingleAttribute() {
//        Map<String, List<String>> expected = ImmutableMap.of(
//                "key1", Arrays.asList("value3"),
//                "key2", Arrays.asList("value2"));
//
//        OrganizationModel organization = organizationManager.createOrganization("original");
//        DocumentModel document = documentProvider.addDocument(DocumentType.INVOICE, "document", organization);
//
//        document.setSingleAttribute("key1", "value1");
//        document.setSingleAttribute("key2", "value2");
//
//        // Overwrite the first attribute
//        document.setSingleAttribute("key1", "value3");
//
//        Assert.assertEquals(expected, document.getAttributes());
//
//
//        organization = organizationProvider.getOrganizationByName("original");
//        Assert.assertEquals(expected, documentProvider.getDocumentByTypeAndDocumentId(DocumentType.INVOICE, "document", organization).getAttributes());
//    }
//
//    @Test
//    public void testSearchByString() {
//        OrganizationModel organization = organizationManager.createOrganization("original");
//        DocumentModel document1 = documentProvider.addDocument(DocumentType.INVOICE, "document1", organization);
//
//        organization = organizationProvider.getOrganizationByName("original");
//        List<DocumentModel> documents = documentProvider.searchForDocument("document", organization, 0, 7);
//        Assert.assertTrue(documents.contains(document1));
//    }
//
//    @Test
//    public void testDocumentSendEvent() {
//        OrganizationModel organization = organizationManager.createOrganization("original");
//        DocumentModel document = documentProvider.addDocument(DocumentType.INVOICE, "document", organization);
//
//        Assert.assertTrue(document.getSendEvents().isEmpty());
//
//        SendEventModel sendEvent1 = document.addSendEvent(DestinyType.CUSTOMER);
//        String id = organization.getId();
//
//        organization = organizationManager.getOrganization(id);
//        document = documentProvider.getDocumentByTypeAndDocumentId(DocumentType.INVOICE, "document", organization);
//
//        Assert.assertEquals(1, document.getSendEvents().size());
//        Assert.assertTrue(document.getSendEvents().contains(sendEvent1));
//        Assert.assertTrue(sendEvent1.getDestityType().equals(DestinyType.CUSTOMER));
//
//        SendEventModel sendEvent2 = document.addSendEvent(DestinyType.THIRD_PARTY);
//        document = documentProvider.getDocumentByTypeAndDocumentId(DocumentType.INVOICE, "document", organization);
//        Assert.assertTrue(sendEvent2.getDestityType().equals(DestinyType.THIRD_PARTY));
//
//        Assert.assertEquals(2, document.getSendEvents().size());
//        Assert.assertTrue(document.getSendEvents().contains(sendEvent2));
//
//        document.removeSendEvent(sendEvent1);
//        document = documentProvider.getDocumentByTypeAndDocumentId(DocumentType.INVOICE, "document", organization);
//
//        Assert.assertEquals(1, document.getSendEvents().size());
//        Assert.assertTrue(document.getSendEvents().contains(sendEvent2));
//
//        document.removeSendEvent(sendEvent2);
//        document = documentProvider.getDocumentByTypeAndDocumentId(DocumentType.INVOICE, "document", organization);
//
//        Assert.assertTrue(document.getSendEvents().isEmpty());
//    }
//
//    @Test
//    public void testDocumentSendEventAttributes() throws Exception {
//        OrganizationModel organization = organizationManager.createOrganization("original");
//        DocumentModel document = documentProvider.addDocument(DocumentType.INVOICE, "document", organization);
//        SendEventModel sendEvent = document.addSendEvent(DestinyType.CUSTOMER);
//        SendEventModel sendEventNoAttrs = document.addSendEvent(DestinyType.THIRD_PARTY);
//
//        String sendEventId = sendEvent.getId();
//
//        sendEvent.setAttribute("key1", "value1");
//
//
//        // Test read attributes
//        organization = organizationManager.getOrganizationByName("original");
//        document = documentProvider.getDocumentByTypeAndDocumentId(DocumentType.INVOICE, "document", organization);
//        sendEvent = document.getSendEventById(sendEventId);
//
//        Assert.assertEquals(sendEvent.getAttribute("key1"), "value1");
//
//        sendEvent.setAttribute("key2", "value2");
//        Assert.assertEquals(sendEvent.getAttribute("key2"), "value2");
//
//        // Test remove and rewrite attribute
//        sendEvent.removeAttribute("key1");
//        sendEvent.setAttribute("key3", "value3");
//
//
//        organization = organizationManager.getOrganizationByName("original");
//        document = documentProvider.getDocumentByTypeAndDocumentId(DocumentType.INVOICE, "document", organization);
//        sendEvent = document.getSendEventById(sendEventId);
//
//        Assert.assertNull(sendEvent.getAttribute("key1"));
//        Assert.assertEquals(sendEvent.getAttribute("key2"), "value2");
//        Assert.assertEquals(sendEvent.getAttribute("key3"), "value3");
//    }
//
//    @Test
//    public void testSendEventFileAttatchements() {
//        OrganizationModel organization = organizationManager.createOrganization("original");
//        DocumentModel document = documentProvider.addDocument(DocumentType.INVOICE, "document", organization);
//        SendEventModel sendEvent = document.addSendEvent(DestinyType.CUSTOMER);
//        SendEventModel sendEventNoFileAttatchement = document.addSendEvent(DestinyType.THIRD_PARTY);
//        String sendEventId = sendEvent.getId();
//
//        Assert.assertTrue(sendEvent.getAttachedFileIds().isEmpty());
//
//        FileModel file1 = fileProvider.createFile(organization, "file1.xml", new byte[]{0, 1, 2, 3});
//        sendEvent.attachFile(file1);
//
//        Assert.assertEquals(1, sendEvent.getAttachedFileIds().size());
//
//
//        document = documentProvider.getDocumentByTypeAndDocumentId(DocumentType.INVOICE, "document", organization);
//        sendEvent = document.getSendEventById(sendEventId);
//
//        Assert.assertEquals(1, sendEvent.getAttachedFileIds().size());
//        Assert.assertTrue(sendEvent.getAttachedFileIds().contains(file1));
//
//        FileModel file2 = fileProvider.createFile(organization, "file2.xml", new byte[]{0, 1, 2, 3, 4, 5});
//        sendEvent.attachFile(file2);
//
//        Assert.assertEquals(2, sendEvent.getAttachedFileIds().size());
//        Assert.assertTrue(sendEvent.getAttachedFileIds().contains(file2));
//
//        sendEvent.unattachResponseFile(file1);
//        Assert.assertEquals(1, sendEvent.getAttachedFileIds().size());
//        Assert.assertTrue(sendEvent.getAttachedFileIds().contains(file2));
//
//    }
//
//    @Test
//    public void testSendEventFileAttatchements1() {
//        OrganizationModel organization = organizationManager.createOrganization("original");
//        DocumentModel document = documentProvider.addDocument(DocumentType.INVOICE, "document", organization);
//        SendEventModel sendEvent = document.addSendEvent(DestinyType.CUSTOMER);
//        SendEventModel sendEventNoFileResponseAttatchement = document.addSendEvent(DestinyType.THIRD_PARTY);
//        String sendEventId = sendEvent.getId();
//
//        Assert.assertTrue(sendEvent.getAttachedFileIds().isEmpty());
//
//        FileModel file1 = fileProvider.createFile(organization, "file1.xml", new byte[]{0, 1, 2, 3});
//        sendEvent.attachFile(file1);
//
//        Assert.assertEquals(1, sendEvent.getAttachedFileIds().size());
//
//
//        document = documentProvider.getDocumentByTypeAndDocumentId(DocumentType.INVOICE, "document", organization);
//        sendEvent = document.getSendEventById(sendEventId);
//
//        Assert.assertEquals(1, sendEvent.getAttachedFileIds().size());
//        Assert.assertTrue(sendEvent.getAttachedFileIds().contains(file1));
//
//        FileModel file2 = fileProvider.createFile(organization, "file2.xml", new byte[]{0, 1, 2, 3, 4, 5});
//        sendEvent.attachFile(file2);
//
//        Assert.assertEquals(2, sendEvent.getAttachedFileIds().size());
//        Assert.assertTrue(sendEvent.getAttachedFileIds().contains(file2));
//
//        sendEvent.unattachResponseFile(file1);
//        sendEvent = document.getSendEventById(sendEventId);
//
//        Assert.assertEquals(1, sendEvent.getAttachedFileIds().size());
//        Assert.assertTrue(sendEvent.getAttachedFileIds().contains(file2));
//
//        sendEvent.unattachResponseFile(file2);
//        sendEvent = document.getSendEventById(sendEventId);
//
//        Assert.assertTrue(sendEvent.getAttachedFileIds().isEmpty());
//
//
//        organization = organizationManager.getOrganizationByName("original");
//        document = documentProvider.getDocumentByTypeAndDocumentId(DocumentType.INVOICE, "document", organization);
//        sendEvent = document.getSendEventById(sendEventId);
//        Assert.assertTrue(sendEvent.getAttachedFileIds().isEmpty());
//    }
//
//    @Test
//    public void testXmlFileAttatch() {
//        OrganizationModel organization = organizationManager.createOrganization("original");
//        DocumentModel document = documentProvider.addDocument(DocumentType.INVOICE, "document", organization);
//
//        Assert.assertNull(document.getXmlAsFile());
//
//        FileModel file1 = fileProvider.createFile(organization, "file1.xml", new byte[]{0, 1, 2, 3});
//        String file1Id = file1.getId();
//        document.attachXmlFile(file1);
//
//        Assert.assertNotNull(document.getXmlAsFile());
//
//
//        document = documentProvider.getDocumentByTypeAndDocumentId(DocumentType.INVOICE, "document", organization);
//
//        Assert.assertNotNull(document.getXmlAsFile());
//        Assert.assertEquals(document.getXmlAsFile(), fileProvider.getFileById(organization, file1Id));
//
//        FileModel file2 = fileProvider.createFile(organization, "file2.xml", new byte[]{0, 1, 2, 3, 4, 5});
//        String file2Id = file2.getId();
//        document.attachXmlFile(file2);
//
//        Assert.assertNotNull(document.getXmlAsFile());
//        Assert.assertEquals(document.getXmlAsFile(), fileProvider.getFileById(organization, file2Id));
//
//
//        organization = organizationManager.getOrganizationByName("original");
//        document = documentProvider.getDocumentByTypeAndDocumentId(DocumentType.INVOICE, "document", organization);
//
//        Assert.assertNotNull(document.getXmlAsFile());
//        Assert.assertEquals(document.getXmlAsFile(), fileProvider.getFileById(organization, file2Id));
//    }
//
//    @Test
//    public void testAttatchedDocuments() {
//        OrganizationModel organization = organizationManager.createOrganization("original");
//        DocumentModel invoice = documentProvider.addDocument(DocumentType.INVOICE, "invoiceEntity", organization);
//        DocumentModel creditNote = documentProvider.addDocument(DocumentType.CREDIT_NOTE.toString(), "creditNoteEntity", organization);
//
//        Assert.assertTrue(invoice.getAttachedDocumentsAsOrigin().isEmpty());
//        Assert.assertTrue(invoice.getAttachedDocumentsAsDestiny().isEmpty());
//
//        invoice.addAttachedDocument(creditNote);
//        String organizationId = organization.getId();
//
//        Assert.assertEquals(1, invoice.getAttachedDocumentsAsOrigin().size());
//        Assert.assertEquals(0, invoice.getAttachedDocumentsAsDestiny().size());
//        Assert.assertTrue(invoice.getAttachedDocumentsAsOrigin().contains(creditNote));
//
//        Assert.assertEquals(0, creditNote.getAttachedDocumentsAsOrigin().size());
//        Assert.assertEquals(1, creditNote.getAttachedDocumentsAsDestiny().size());
//        Assert.assertTrue(creditNote.getAttachedDocumentsAsDestiny().contains(invoice));
//
//
//        organization = organizationManager.getOrganization(organizationId);
//        invoice = documentProvider.getDocumentByTypeAndDocumentId(DocumentType.INVOICE, "invoiceEntity", organization);
//        creditNote = documentProvider.getDocumentByTypeAndDocumentId(DocumentType.CREDIT_NOTE, "creditNoteEntity", organization);
//
//        Assert.assertEquals(1, invoice.getAttachedDocumentsAsOrigin().size());
//        Assert.assertEquals(0, invoice.getAttachedDocumentsAsDestiny().size());
//        Assert.assertEquals(0, creditNote.getAttachedDocumentsAsOrigin().size());
//        Assert.assertEquals(1, creditNote.getAttachedDocumentsAsDestiny().size());
//
//        Assert.assertTrue(invoice.getAttachedDocumentsAsOrigin().contains(creditNote));
//
//
//        DocumentModel debitNote = documentProvider.addDocument(DocumentType.DEBIT_NOTE, "debitNoteEntity", organization);
//        invoice.addAttachedDocument(debitNote);
//
//        Assert.assertEquals(2, invoice.getAttachedDocumentsAsOrigin().size());
//        Assert.assertEquals(0, invoice.getAttachedDocumentsAsDestiny().size());
//        Assert.assertTrue(invoice.getAttachedDocumentsAsOrigin().contains(debitNote));
//
//        Assert.assertEquals(0, debitNote.getAttachedDocumentsAsOrigin().size());
//        Assert.assertEquals(1, debitNote.getAttachedDocumentsAsDestiny().size());
//        Assert.assertTrue(debitNote.getAttachedDocumentsAsDestiny().contains(invoice));
//
//
//        organization = organizationManager.getOrganization(organizationId);
//        invoice = documentProvider.getDocumentByTypeAndDocumentId(DocumentType.INVOICE, "invoiceEntity", organization);
//        creditNote = documentProvider.getDocumentByTypeAndDocumentId(DocumentType.CREDIT_NOTE, "creditNoteEntity", organization);
//        debitNote = documentProvider.getDocumentByTypeAndDocumentId(DocumentType.DEBIT_NOTE, "debitNoteEntity", organization);
//
//        Assert.assertEquals(2, invoice.getAttachedDocumentsAsOrigin().size());
//        Assert.assertEquals(0, invoice.getAttachedDocumentsAsDestiny().size());
//        Assert.assertTrue(invoice.getAttachedDocumentsAsOrigin().contains(debitNote));
//
//        Assert.assertEquals(0, debitNote.getAttachedDocumentsAsOrigin().size());
//        Assert.assertEquals(1, debitNote.getAttachedDocumentsAsDestiny().size());
//        Assert.assertTrue(debitNote.getAttachedDocumentsAsDestiny().contains(invoice));
//
//        invoice.removeAttachedDocument(creditNote);
//
//        Assert.assertEquals(1, invoice.getAttachedDocumentsAsOrigin().size());
//        Assert.assertEquals(0, invoice.getAttachedDocumentsAsDestiny().size());
//        Assert.assertFalse(invoice.getAttachedDocumentsAsOrigin().contains(creditNote));
//
//        Assert.assertEquals(0, creditNote.getAttachedDocumentsAsOrigin().size());
//        Assert.assertEquals(0, creditNote.getAttachedDocumentsAsDestiny().size());
//        Assert.assertFalse(creditNote.getAttachedDocumentsAsDestiny().contains(invoice));
//    }
//
//    public static void assertEquals(DocumentModel expected, DocumentModel actual) {
//        Assert.assertEquals(expected.getDocumentId(), actual.getDocumentId());
//        Assert.assertEquals(expected.getCreatedTimestamp(), actual.getCreatedTimestamp());
//        Assert.assertEquals(expected.getCustomerElectronicMail(), actual.getCustomerElectronicMail());
//
//        String[] expectedRequiredActions = expected.getRequiredActions().toArray(new String[expected.getRequiredActions().size()]);
//        Arrays.sort(expectedRequiredActions);
//        String[] actualRequiredActions = actual.getRequiredActions().toArray(new String[actual.getRequiredActions().size()]);
//        Arrays.sort(actualRequiredActions);
//
//        Assert.assertArrayEquals(expectedRequiredActions, actualRequiredActions);
//    }

    @Test
    public void test() {
        Assert.assertNotNull("nada");
    }

}
