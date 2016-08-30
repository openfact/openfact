package org.openfact.testsuite.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.openfact.models.InvoiceModel;
import org.openfact.models.InvoiceModel.RequiredAction;
import org.openfact.models.enums.DocumentType;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;

public class InvoiceModelTest extends AbstractModelTest {

    /*@Test
    public void persistInvoice() {
        OrganizationModel organization = organizationManager.createOrganization("original");
        organization.setAdditionalAccountId(organization.addSimpleDocument(DocumentType.ADDITIONAL_IDENTIFICATION_ID, "RUC", "05"));
        commit();
        
        OpenfactSession session = organizationManager.getSession();
        InvoiceModel invoice = session.invoices().addInvoice(organization, 1, 1);        
        invoice.setType("RUC", "06");
        invoice.setCurrencyCode("PEN");
        //assertNotNull(invoice.getCreatedTimestamp());
        // test that timestamp is current with 10s tollerance
        //Assert.assertTrue((System.currentTimeMillis() - invoice.getCreatedTimestamp()) < 10000);

        invoice.addRequiredAction(RequiredAction.CONFIGURE_TOTP);
        invoice.addRequiredAction(RequiredAction.UPDATE_PASSWORD);

        OrganizationModel searchOrganization = organizationManager.getOrganization(organization.getId());
        InvoiceModel persisted = session.invoices().getInvoiceBySeriesAndNumber(1, 1, searchOrganization);

        assertEquals(invoice, persisted);

        searchOrganization = organizationManager.getOrganization(organization.getId());
        InvoiceModel persisted2 =  session.invoices().getInvoiceById(invoice.getId(), searchOrganization);
        assertEquals(invoice, persisted2);

        Map<String, String> attributes = new HashMap<String, String>();
        attributes.put(InvoiceModel.CURRENCY_CODE, "PEN");
        List<InvoiceModel> search = session.invoices().searchForInvoiceByAttributes(attributes, organization);
        Assert.assertEquals(search.size(), 1);
        Assert.assertEquals(search.get(0).getSeries(), 1);
        Assert.assertEquals(search.get(0).getNumber(), 1);

        attributes.clear();
        attributes.put(InvoiceModel.TYPE, "RUC");
        search = session.invoices().searchForInvoiceByAttributes(attributes, organization);
        Assert.assertEquals(search.size(), 1);
        Assert.assertEquals(search.get(0).getSeries(), 1);
        Assert.assertEquals(search.get(0).getNumber(), 1);

        attributes.clear();
        attributes.put(InvoiceModel.CURRENCY_CODE, "PEN");
        attributes.put(InvoiceModel.TYPE, "RUC");
        search = session.invoices().searchForInvoiceByAttributes(attributes, organization);
        Assert.assertEquals(search.size(), 1);
        Assert.assertEquals(search.get(0).getSeries(), 1);
        Assert.assertEquals(search.get(0).getNumber(), 1);
    }*/

    @Test
    public void testInvoiceRequiredActions() throws Exception {
        OrganizationModel organization = organizationManager.createOrganization("original");
        organization.setAdditionalAccountId(organization.addSimpleDocument(DocumentType.ADDITIONAL_IDENTIFICATION_ID, "RUC", "05"));
        commit();
        
        InvoiceModel invoice = session.invoices().addInvoice(organization, 1, 1);

        Assert.assertTrue(invoice.getRequiredActions().isEmpty());

        invoice.addRequiredAction(RequiredAction.CONFIGURE_TOTP);
        String id = organization.getId();
        commit();
        organization = organizationManager.getOrganization(id);
        invoice = session.invoices().getInvoiceBySeriesAndNumber(1, 1, organization);

        Assert.assertEquals(1, invoice.getRequiredActions().size());
        Assert.assertTrue(invoice.getRequiredActions().contains(RequiredAction.CONFIGURE_TOTP.name()));

        invoice.addRequiredAction(RequiredAction.CONFIGURE_TOTP);
        invoice = session.invoices().getInvoiceBySeriesAndNumber(1, 1, organization);

        Assert.assertEquals(1, invoice.getRequiredActions().size());
        Assert.assertTrue(invoice.getRequiredActions().contains(RequiredAction.CONFIGURE_TOTP.name()));

        invoice.addRequiredAction(RequiredAction.VERIFY_EMAIL.name());
        invoice = session.invoices().getInvoiceBySeriesAndNumber(1, 1, organization);

        Assert.assertEquals(2, invoice.getRequiredActions().size());
        Assert.assertTrue(invoice.getRequiredActions().contains(RequiredAction.CONFIGURE_TOTP.name()));
        Assert.assertTrue(invoice.getRequiredActions().contains(RequiredAction.VERIFY_EMAIL.name()));

        invoice.removeRequiredAction(RequiredAction.CONFIGURE_TOTP.name());
        invoice = session.invoices().getInvoiceBySeriesAndNumber(1, 1, organization);

        Assert.assertEquals(1, invoice.getRequiredActions().size());
        Assert.assertTrue(invoice.getRequiredActions().contains(RequiredAction.VERIFY_EMAIL.name()));

        invoice.removeRequiredAction(RequiredAction.VERIFY_EMAIL.name());
        invoice = session.invoices().getInvoiceBySeriesAndNumber(1, 1, organization);

        Assert.assertTrue(invoice.getRequiredActions().isEmpty());
    }

    /*@Test
    public void testInvoiceMultipleAttributes() throws Exception {
        OrganizationModel organization = organizationManager.createOrganization("original");
        organization.setAdditionalAccountId(organization.addSimpleDocument(DocumentType.ADDITIONAL_IDENTIFICATION_ID, "RUC", "05"));
        commit();
        
        InvoiceModel invoice = session.invoices().addInvoice(organization, 1, 1);
        InvoiceModel invoiceNoAttrs = session.invoices().addInvoice(organization, 1, 2);

        invoice.setSingleAttribute("key1", "value1");
        List<String> attrVals = new ArrayList<>(Arrays.asList( "val21", "val22" ));
        invoice.setAttribute("key2", attrVals);

        commit();

        // Test read attributes
        organization = organizationManager.getOrganizationByName("orginal");
        invoice = session.invoices().getInvoiceBySeriesAndNumber(1, 1, organization);

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
        invoice = session.invoices().getInvoiceBySeriesAndNumber(1, 1, organization);
        Assert.assertNull(invoice.getFirstAttribute("key1"));
        attrVals = invoice.getAttribute("key2");
        Assert.assertEquals(1, attrVals.size());
        Assert.assertEquals("val23", attrVals.get(0));
    }*/

    /*@Test
    public void testSearchByString() {
        OrganizationModel organization = organizationManager.createOrganization("original");
        organization.setAdditionalAccountId(organization.addSimpleDocument(DocumentType.ADDITIONAL_IDENTIFICATION_ID, "RUC", "05"));
        commit();
        
        InvoiceModel invoice1 = session.invoices().addInvoice(organization, 1, 1);

        commit();
        organization = session.organizations().getOrganizationByName("original");
        List<InvoiceModel> users = session.invoices().searchForInvoice("1", organization, 0, 7);
        Assert.assertTrue(users.contains(invoice1));
    }*/

    /*@Test
    public void testSearchByInvoiceAttribute() throws Exception {
        OrganizationModel organization = organizationManager.createOrganization("original");
        organization.setAdditionalAccountId(organization.addSimpleDocument(DocumentType.ADDITIONAL_IDENTIFICATION_ID, "RUC", "05"));
        commit();
        
        InvoiceModel invoice11 = session.invoices().addInvoice(organization, 1, 1);
        InvoiceModel invoice2 = session.invoices().addInvoice(organization, 1, 2);
        InvoiceModel invoice3 = session.invoices().addInvoice(organization, 1, 3);

        invoice11.setSingleAttribute("key1", "value1");
        invoice11.setSingleAttribute("key2", "value21");

        invoice2.setSingleAttribute("key1", "value1");
        invoice2.setSingleAttribute("key2", "value22");

        invoice3.setSingleAttribute("key2", "value21");

        commit();
        organization = session.organizations().getOrganizationByName("original");

        List<InvoiceModel> invoices = session.invoices().searchForInvoiceByAttribute("key1", "value1", organization);
        Assert.assertEquals(2, invoices.size());
        Assert.assertTrue(invoices.contains(invoice11));
        Assert.assertTrue(invoices.contains(invoice2));

        invoices = session.invoices().searchForInvoiceByAttribute("key2", "value21", organization);
        Assert.assertEquals(2, invoices.size());
        Assert.assertTrue(invoices.contains(invoice11));
        Assert.assertTrue(invoices.contains(invoice3));

        invoices = session.invoices().searchForInvoiceByAttribute("key2", "value22", organization);
        Assert.assertEquals(1, invoices.size());
        Assert.assertTrue(invoices.contains(invoice2));

        invoices = session.invoices().searchForInvoiceByAttribute("key3", "value3", organization);
        Assert.assertEquals(0, invoices.size());
    }*/
        
    public static void assertEquals(InvoiceModel expected, InvoiceModel actual) {
        Assert.assertEquals(expected.getSeries(), actual.getSeries());
        Assert.assertEquals(expected.getCreatedTimestamp(), actual.getCreatedTimestamp());
        
        String[] expectedRequiredActions = expected.getRequiredActions().toArray(new String[expected.getRequiredActions().size()]);
        Arrays.sort(expectedRequiredActions);
        String[] actualRequiredActions = actual.getRequiredActions().toArray(new String[actual.getRequiredActions().size()]);
        Arrays.sort(actualRequiredActions);

        Assert.assertArrayEquals(expectedRequiredActions, actualRequiredActions);
    }

}

