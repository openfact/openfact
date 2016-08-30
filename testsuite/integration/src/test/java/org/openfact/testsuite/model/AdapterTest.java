package org.openfact.testsuite.model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openfact.models.InvoiceModel;
import org.openfact.models.ModelDuplicateException;
import org.openfact.models.OrganizationModel;
import org.openfact.models.enums.DocumentType;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdapterTest extends AbstractModelTest {
    
    private OrganizationModel organizationModel;

    @Test
    public void test1CreateOrganization() throws Exception {
        organizationModel = organizationManager.createOrganization("SISTCOOP");      
        organizationModel.setName("SISTCOOP");
        organizationModel.setDescription("SISTCOOP IS A SOFTWARE COMPANY");
        organizationModel.setEnabled(true);        
        organizationModel.setAttempNumber(5);
        organizationModel.setLapseTime(50);
        organizationModel.setOnErrorAttempNumber(2);
        organizationModel.setOnErrorLapseTime(500);
        organizationModel.setDelayTime(0);
        organizationModel.setSubmitTime(LocalTime.now());
        organizationModel.setSubmitDays(new HashSet<DayOfWeek>(Arrays.asList(DayOfWeek.MONDAY, DayOfWeek.THURSDAY)));

        organizationModel.addSimpleDocument(DocumentType.INVOICE_TYPE, "Document X", "00");
        organizationModel.addCheckableDocument(DocumentType.INVOICE_TYPE, "Document Y", "01", true);
        organizationModel.addValuableDocument(DocumentType.INVOICE_TYPE, "Document Z", "02", BigDecimal.ONE);
        organizationModel.addComposedDocument(DocumentType.INVOICE_TYPE, "Document A", "03").addChildren(organizationModel.addSimpleDocument(DocumentType.INVOICE_TYPE, "Document AB", "04"));

        organizationModel.setAssignedIdentificationId("012345678910");
        organizationModel.setSupplierName("SISTCOOP SAC");
        organizationModel.setRegistrationName("SISTCOOP SOFTWARE");
        organizationModel.setAdditionalAccountId(organizationModel.addSimpleDocument(DocumentType.ADDITIONAL_IDENTIFICATION_ID, "RUC", "05"));       
        organizationModel.setStreetName("Jr. Arequipa 123");
        organizationModel.setCitySubdivisionName("Ayacucho");
        organizationModel.setCityName("Huamanga");
        organizationModel.setCountrySubentity("Region");
        organizationModel.setDistrict("Jesus Nazareno");
        organizationModel.setCountryIdentificationCode("PE");        
        
        KeyPair keyPair = generateKeypair();
        organizationModel.setPrivateKey(keyPair.getPrivate());
        organizationModel.setPublicKey(keyPair.getPublic());

        organizationModel.addCurrency("PEN");
        organizationModel.addCurrency("USD");
        
        session.getTransactionManager().commit();
        resetSession();

        organizationModel = organizationManager.getOrganization(organizationModel.getId());
        assertNotNull(organizationModel);                
        Assert.assertEquals(organizationModel.getName(), "SISTCOOP");
        Assert.assertEquals(organizationModel.getDescription(), "SISTCOOP IS A SOFTWARE COMPANY");        
        Assert.assertEquals(organizationModel.isEnabled(), true);        
        Assert.assertEquals(organizationModel.getAttempNumber(), 5);
        Assert.assertEquals(organizationModel.getLapseTime(), 50);
        Assert.assertEquals(organizationModel.getOnErrorAttempNumber(), 2);
        Assert.assertEquals(organizationModel.getOnErrorLapseTime(), 500);
        Assert.assertEquals(organizationModel.getDelayTime(), 0);

        Assert.assertEquals(organizationModel.getDocuments().size(), 6);

        Assert.assertEquals(organizationModel.getAssignedIdentificationId(), "012345678910");
        Assert.assertEquals(organizationModel.getSupplierName(), "SISTCOOP SAC");
        Assert.assertEquals(organizationModel.getRegistrationName(), "SISTCOOP SOFTWARE");
        Assert.assertEquals(organizationModel.getStreetName(), "Jr. Arequipa 123");
        Assert.assertEquals(organizationModel.getCitySubdivisionName(), "Ayacucho");
        Assert.assertEquals(organizationModel.getCityName(), "Huamanga");
        Assert.assertEquals(organizationModel.getCountrySubentity(), "Region");
        Assert.assertEquals(organizationModel.getDistrict(), "Jesus Nazareno");
        Assert.assertEquals(organizationModel.getCountryIdentificationCode(), "PE");
        Assert.assertArrayEquals(organizationModel.getPrivateKey().getEncoded(), keyPair.getPrivate().getEncoded());
        Assert.assertArrayEquals(organizationModel.getPublicKey().getEncoded(), keyPair.getPublic().getEncoded());
        Assert.assertTrue(organizationModel.getCurrencies().size() >= 2);
    }

    @Test
    public void testOrganizationListing() throws Exception {
    	test1CreateOrganization();

        commit();
        List<OrganizationModel> organizations = model.getOrganizations();
        Assert.assertEquals(organizations.size(), 2);
    }

    @Test
    public void testRemoveOrganization() throws Exception {
        test1CreateOrganization();

        InvoiceModel invoice = organizationManager.getSession().invoices().addInvoice(organizationModel, 1, 1);
        invoice.addInvoiceLine();
        
        commit();
        organizationModel = model.getOrganization("SISTCOOP");

        Assert.assertTrue(organizationManager.removeOrganization(organizationModel));
        Assert.assertFalse(organizationManager.removeOrganization(organizationModel));
        assertNull(organizationManager.getOrganization(organizationModel.getId()));
    }
    
    @Test
    public void testDeleteInvoice() throws Exception {
        test1CreateOrganization();

        InvoiceModel invoice = organizationManager.getSession().invoices().addInvoice(organizationModel, 1, 1);
        invoice.setSingleAttribute("attr1", "val1");
        invoice.addRequiredAction(InvoiceModel.RequiredAction.UPDATE_PASSWORD);

        commit();

        organizationModel = model.getOrganization("SISTCOOP");
        Assert.assertTrue(organizationManager.getSession().invoices().removeInvoice(organizationModel, invoice));
        assertNull(organizationManager.getSession().invoices().getInvoiceBySeriesAndNumber(1, 1, organizationModel));
    }   

    
    /*@Test
    public void testInvoiceSearch() throws Exception {
        test1CreateOrganization();
        {
            InvoiceModel invoice = organizationManager.getSession().invoices().addInvoice(organizationModel, 1, 1);
            InvoiceModel invoice2 = organizationManager.getSession().invoices().addInvoice(organizationModel, 1, 2);
            InvoiceModel invoice3 = organizationManager.getSession().invoices().addInvoice(organizationModel, 1, 3);
        }

        RealmManager adapter = organizationManager;

        {
            List<InvoiceModel> userModels = adapter.searchUsers("total junk query", organizationModel);
            Assert.assertEquals(userModels.size(), 0);
        }

        {
            List<InvoiceModel> userModels = adapter.searchUsers("Bill Burke", organizationModel);
            Assert.assertEquals(userModels.size(), 1);
            InvoiceModel bburke = userModels.get(0);
            Assert.assertEquals(bburke.getFirstName(), "Bill");
            Assert.assertEquals(bburke.getLastName(), "Burke");
            Assert.assertEquals(bburke.getEmail(), "bburke@redhat.com");
        }

        {
            List<InvoiceModel> userModels = adapter.searchUsers("bill burk", organizationModel);
            Assert.assertEquals(userModels.size(), 1);
            InvoiceModel bburke = userModels.get(0);
            Assert.assertEquals(bburke.getFirstName(), "Bill");
            Assert.assertEquals(bburke.getLastName(), "Burke");
            Assert.assertEquals(bburke.getEmail(), "bburke@redhat.com");
        }

        {
            ArrayList<String> users = new ArrayList<String>();
            for (InvoiceModel u : adapter.searchUsers("ole alver", organizationModel)) {
                users.add(u.getUsername());
            }
            String[] usernames = users.toArray(new String[users.size()]);
            Arrays.sort(usernames);
            Assert.assertArrayEquals(new String[]{"doublefirst", "doublelast"}, usernames);
        }

        {
            List<InvoiceModel> userModels = adapter.searchUsers("bburke@redhat.com", organizationModel);
            Assert.assertEquals(userModels.size(), 1);
            InvoiceModel bburke = userModels.get(0);
            Assert.assertEquals(bburke.getFirstName(), "Bill");
            Assert.assertEquals(bburke.getLastName(), "Burke");
            Assert.assertEquals(bburke.getEmail(), "bburke@redhat.com");
        }

        {
            List<InvoiceModel> userModels = adapter.searchUsers("rke@redhat.com", organizationModel);
            Assert.assertEquals(userModels.size(), 1);
            InvoiceModel bburke = userModels.get(0);
            Assert.assertEquals(bburke.getFirstName(), "Bill");
            Assert.assertEquals(bburke.getLastName(), "Burke");
            Assert.assertEquals(bburke.getEmail(), "bburke@redhat.com");
        }

        {
            List<InvoiceModel> userModels = adapter.searchUsers("bburke", organizationModel);
            Assert.assertEquals(userModels.size(), 1);
            InvoiceModel bburke = userModels.get(0);
            Assert.assertEquals(bburke.getFirstName(), "Bill");
            Assert.assertEquals(bburke.getLastName(), "Burke");
            Assert.assertEquals(bburke.getEmail(), "bburke@redhat.com");
        }

        {
            List<InvoiceModel> userModels = adapter.searchUsers("BurK", organizationModel);
            Assert.assertEquals(userModels.size(), 1);
            InvoiceModel bburke = userModels.get(0);
            Assert.assertEquals(bburke.getFirstName(), "Bill");
            Assert.assertEquals(bburke.getLastName(), "Burke");
            Assert.assertEquals(bburke.getEmail(), "bburke@redhat.com");
        }

        {
            List<InvoiceModel> userModels = adapter.searchUsers("Burke", organizationModel);
            Assert.assertEquals(userModels.size(), 1);
            InvoiceModel bburke = userModels.get(0);
            Assert.assertEquals(bburke.getFirstName(), "Bill");
            Assert.assertEquals(bburke.getLastName(), "Burke");
            Assert.assertEquals(bburke.getEmail(), "bburke@redhat.com");
        }

        {
            InvoiceModel user = organizationManager.getSession().invoices().addUser(organizationModel, "mburke");
            user.setLastName("Burke");
            user.setFirstName("Monica");
            user.setEmail("mburke@redhat.com");
        }

        {
            InvoiceModel user = organizationManager.getSession().invoices().addUser(organizationModel, "thor");
            user.setLastName("Thorgersen");
            user.setFirstName("Stian");
            user.setEmail("thor@redhat.com");
        }

        {
            List<InvoiceModel> userModels = adapter.searchUsers("Monica Burke", organizationModel);
            Assert.assertEquals(userModels.size(), 1);
            InvoiceModel bburke = userModels.get(0);
            Assert.assertEquals(bburke.getFirstName(), "Monica");
            Assert.assertEquals(bburke.getLastName(), "Burke");
            Assert.assertEquals(bburke.getEmail(), "mburke@redhat.com");
        }


        {
            List<InvoiceModel> userModels = adapter.searchUsers("mburke@redhat.com", organizationModel);
            Assert.assertEquals(userModels.size(), 1);
            InvoiceModel bburke = userModels.get(0);
            Assert.assertEquals(bburke.getFirstName(), "Monica");
            Assert.assertEquals(bburke.getLastName(), "Burke");
            Assert.assertEquals(bburke.getEmail(), "mburke@redhat.com");
        }

        {
            List<InvoiceModel> userModels = adapter.searchUsers("mburke", organizationModel);
            Assert.assertEquals(userModels.size(), 1);
            InvoiceModel bburke = userModels.get(0);
            Assert.assertEquals(bburke.getFirstName(), "Monica");
            Assert.assertEquals(bburke.getLastName(), "Burke");
            Assert.assertEquals(bburke.getEmail(), "mburke@redhat.com");
        }

        {
            List<InvoiceModel> userModels = adapter.searchUsers("Burke", organizationModel);
            Assert.assertEquals(userModels.size(), 2);
            InvoiceModel first = userModels.get(0);
            InvoiceModel second = userModels.get(1);
            if (!first.getEmail().equals("bburke@redhat.com") && !second.getEmail().equals("bburke@redhat.com")) {
                Assert.fail();
            }
            if (!first.getEmail().equals("mburke@redhat.com") && !second.getEmail().equals("mburke@redhat.com")) {
                Assert.fail();
            }
        }

        OrganizationModel otherRealm = adapter.createOrganization("other");
        organizationManager.getSession().invoices().addUser(otherRealm, "bburke");

        Assert.assertEquals(1, organizationManager.getSession().invoices().getUsers(otherRealm, false).size());
        Assert.assertEquals(1, organizationManager.getSession().invoices().searchForUser("bu", otherRealm).size());
    }*/ 

    @Test
    public void testOrganizationNameCollisions() throws Exception {
        test1CreateOrganization();

        commit();

        // Try to create organization with duplicate name
        try {
            test1CreateOrganization();
            commit();
            Assert.fail("Expected exception");
        } catch (ModelDuplicateException e) {
        }
        commit(true);

        // Try to rename organization to duplicate name
        organizationManager.createOrganization("SISTCOOP2");
        commit();
        try {
            organizationManager.getOrganizationByName("SISTCOOP2").setName("SISTCOOP");
            commit();
            Assert.fail("Expected exception");
        } catch (ModelDuplicateException e) {
        }

        resetSession();
    }

    @Test
    public void testSeriesNumberCollisions() throws Exception {
        OrganizationModel sistcoop1 = organizationManager.createOrganization("SISTCOOP1");
        sistcoop1.setAdditionalAccountId(sistcoop1.addSimpleDocument(DocumentType.ADDITIONAL_IDENTIFICATION_ID, "RUC", "01"));        
        OrganizationModel sistcoop2 = organizationManager.createOrganization("SISTCOOP2");
        sistcoop2.setAdditionalAccountId(sistcoop2.addSimpleDocument(DocumentType.ADDITIONAL_IDENTIFICATION_ID, "RUC", "01"));
        commit();
        
        organizationManager.getSession().invoices().addInvoice(sistcoop1, 1, 1);              
        organizationManager.getSession().invoices().addInvoice(sistcoop2, 1, 1);
        commit();

        // Try to create invoice with duplicate series and number
        try {
            sistcoop1 = organizationManager.getOrganizationByName("SISTCOOP1");
            organizationManager.getSession().invoices().addInvoice(sistcoop1, 1, 1);
            commit();
            Assert.fail("Expected exception");
        } catch (ModelDuplicateException e) {
        }
        commit(true);

        // Ty to rename invoice to duplicate series and number
        sistcoop1 = organizationManager.getOrganizationByName("SISTCOOP1");
        organizationManager.getSession().invoices().addInvoice(sistcoop1, 1, 2);
        commit();
        try {
            sistcoop1 = organizationManager.getOrganizationByName("SISTCOOP1");
            organizationManager.getSession().invoices().getInvoiceBySeriesAndNumber(1, 2, sistcoop1).setNumber(1);
            commit();
            Assert.fail("Expected exception");
        } catch (ModelDuplicateException e) {
        }

        resetSession();
    }   

    private KeyPair generateKeypair() throws NoSuchAlgorithmException {
        return KeyPairGenerator.getInstance("RSA").generateKeyPair();
    }

}
