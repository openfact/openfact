package org.openfact.testsuite.model;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openfact.models.DocumentModel;
import org.openfact.models.InvoiceModel;
import org.openfact.models.ModelDuplicateException;
import org.openfact.models.OrganizationModel;
import org.openfact.models.SimpleDocumentModel;
import org.openfact.models.enums.DocumentType;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

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
        
        organizationModel.setAssignedIdentificationId("012345678910");
        organizationModel.setSupplierName("SISTCOOP SAC");
        organizationModel.setRegistrationName("SISTCOOP SOFTWARE");
        organizationModel.setAdditionalAccountId(organizationModel.addSimpleDocument(DocumentType.ADDITIONAL_IDENTIFICATION_ID, "RUC", "01"));       
        organizationModel.setStreetName("Jr. Arequipa 123");
        organizationModel.setCitySubdivisionName("Ayacucho");
        organizationModel.setCityName("Huamanga");
        organizationModel.setCountrySubentity("Region");
        organizationModel.setDistrict("Jesus Nazareno");
        organizationModel.setCountryIdentificationCode("PE");        
        
        KeyPair keyPair = generateKeypair();
        organizationModel.setPrivateKey(keyPair.getPrivate());
        organizationModel.setPublicKey(keyPair.getPublic());

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
        Assert.assertArrayEquals(organizationModel.getPrivateKey().getEncoded(), keyPair.getPrivate().getEncoded());
        Assert.assertArrayEquals(organizationModel.getPublicKey().getEncoded(), keyPair.getPublic().getEncoded());
        Assert.assertEquals(organizationModel.getAssignedIdentificationId(), "012345678910");
        Assert.assertEquals(organizationModel.getSupplierName(), "SISTCOOP SAC");
        Assert.assertEquals(organizationModel.getRegistrationName(), "SISTCOOP SOFTWARE");
        Assert.assertEquals(organizationModel.getStreetName(), "Jr. Arequipa 123");
        Assert.assertEquals(organizationModel.getCitySubdivisionName(), "Ayacucho");
        Assert.assertEquals(organizationModel.getCityName(), "Huamanga");
        Assert.assertEquals(organizationModel.getCountrySubentity(), "Region");
        Assert.assertEquals(organizationModel.getDistrict(), "Jesus Nazareno");
        Assert.assertEquals(organizationModel.getCountryIdentificationCode(), "PE");
    }

    @Test
    public void testOrganizationListing() throws Exception {
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

        KeyPair keyPair = generateKeypair();

        organizationModel.setPrivateKey(keyPair.getPrivate());
        organizationModel.setPublicKey(keyPair.getPublic());

        organizationModel = organizationManager.getOrganization(organizationModel.getId());
        Assert.assertEquals(organizationModel.getName(), "SISTCOOP");
        Assert.assertEquals(organizationModel.getDescription(), "SISTCOOP IS A SOFTWARE COMPANY");        
        Assert.assertEquals(organizationModel.isEnabled(), true);        
        Assert.assertEquals(organizationModel.getAttempNumber(), 5);
        Assert.assertEquals(organizationModel.getLapseTime(), 50);
        Assert.assertEquals(organizationModel.getOnErrorAttempNumber(), 2);
        Assert.assertEquals(organizationModel.getOnErrorLapseTime(), 500);
        Assert.assertEquals(organizationModel.getDelayTime(), 0);        
        Assert.assertArrayEquals(organizationModel.getPrivateKey().getEncoded(), keyPair.getPrivate().getEncoded());
        Assert.assertArrayEquals(organizationModel.getPublicKey().getEncoded(), keyPair.getPublic().getEncoded());

        organizationModel.getId();

        commit();
        List<OrganizationModel> organizations = model.getOrganizations();
        Assert.assertEquals(organizations.size(), 2);
    }

    @Test
    public void testRemoveOrganization() throws Exception {
        test1CreateOrganization();

        InvoiceModel invoice = organizationManager.getSession().invoices().addInvoice(organizationModel, 1, 1);
        
        commit();
        organizationModel = model.getOrganization("SISTCOOP");

        Assert.assertTrue(organizationManager.removeOrganization(organizationModel));
        Assert.assertFalse(organizationManager.removeOrganization(organizationModel));
        assertNull(organizationManager.getOrganization(organizationModel.getId()));
    }
    
    /*@Test
    public void testDeleteInvoice() throws Exception {
        test1CreateOrganization();

        InvoiceModel invoice = organizationManager.getSession().invoices().addInvoice(organizationModel, 1, 1);
        invoice.setSingleAttribute("attr1", "val1");
        invoice.addRequiredAction(InvoiceModel.RequiredAction.UPDATE_PASSWORD);

        commit();

        organizationModel = model.getOrganization("JUGGLER");
        Assert.assertTrue(organizationManager.getSession().invoices().removeInvoice(organizationModel, invoice));
        assertNull(organizationManager.getSession().invoices().getInvoiceBySeriesAndNumber(1, 1, organizationModel));
    }*/    

    
    /*@Test
    public void testUserSearch() throws Exception {
        test1CreateOrganization();
        {
            UserModel user = organizationManager.getSession().users().addUser(organizationModel, "bburke");
            user.setLastName("Burke");
            user.setFirstName("Bill");
            user.setEmail("bburke@redhat.com");

            UserModel user2 = organizationManager.getSession().users().addUser(organizationModel, "doublefirst");
            user2.setFirstName("Knut Ole");
            user2.setLastName("Alver");
            user2.setEmail("knut@redhat.com");

            UserModel user3 = organizationManager.getSession().users().addUser(organizationModel, "doublelast");
            user3.setFirstName("Ole");
            user3.setLastName("Alver Veland");
            user3.setEmail("knut2@redhat.com");
        }

        RealmManager adapter = organizationManager;

        {
            List<UserModel> userModels = adapter.searchUsers("total junk query", organizationModel);
            Assert.assertEquals(userModels.size(), 0);
        }

        {
            List<UserModel> userModels = adapter.searchUsers("Bill Burke", organizationModel);
            Assert.assertEquals(userModels.size(), 1);
            UserModel bburke = userModels.get(0);
            Assert.assertEquals(bburke.getFirstName(), "Bill");
            Assert.assertEquals(bburke.getLastName(), "Burke");
            Assert.assertEquals(bburke.getEmail(), "bburke@redhat.com");
        }

        {
            List<UserModel> userModels = adapter.searchUsers("bill burk", organizationModel);
            Assert.assertEquals(userModels.size(), 1);
            UserModel bburke = userModels.get(0);
            Assert.assertEquals(bburke.getFirstName(), "Bill");
            Assert.assertEquals(bburke.getLastName(), "Burke");
            Assert.assertEquals(bburke.getEmail(), "bburke@redhat.com");
        }

        {
            ArrayList<String> users = new ArrayList<String>();
            for (UserModel u : adapter.searchUsers("ole alver", organizationModel)) {
                users.add(u.getUsername());
            }
            String[] usernames = users.toArray(new String[users.size()]);
            Arrays.sort(usernames);
            Assert.assertArrayEquals(new String[]{"doublefirst", "doublelast"}, usernames);
        }

        {
            List<UserModel> userModels = adapter.searchUsers("bburke@redhat.com", organizationModel);
            Assert.assertEquals(userModels.size(), 1);
            UserModel bburke = userModels.get(0);
            Assert.assertEquals(bburke.getFirstName(), "Bill");
            Assert.assertEquals(bburke.getLastName(), "Burke");
            Assert.assertEquals(bburke.getEmail(), "bburke@redhat.com");
        }

        {
            List<UserModel> userModels = adapter.searchUsers("rke@redhat.com", organizationModel);
            Assert.assertEquals(userModels.size(), 1);
            UserModel bburke = userModels.get(0);
            Assert.assertEquals(bburke.getFirstName(), "Bill");
            Assert.assertEquals(bburke.getLastName(), "Burke");
            Assert.assertEquals(bburke.getEmail(), "bburke@redhat.com");
        }

        {
            List<UserModel> userModels = adapter.searchUsers("bburke", organizationModel);
            Assert.assertEquals(userModels.size(), 1);
            UserModel bburke = userModels.get(0);
            Assert.assertEquals(bburke.getFirstName(), "Bill");
            Assert.assertEquals(bburke.getLastName(), "Burke");
            Assert.assertEquals(bburke.getEmail(), "bburke@redhat.com");
        }

        {
            List<UserModel> userModels = adapter.searchUsers("BurK", organizationModel);
            Assert.assertEquals(userModels.size(), 1);
            UserModel bburke = userModels.get(0);
            Assert.assertEquals(bburke.getFirstName(), "Bill");
            Assert.assertEquals(bburke.getLastName(), "Burke");
            Assert.assertEquals(bburke.getEmail(), "bburke@redhat.com");
        }

        {
            List<UserModel> userModels = adapter.searchUsers("Burke", organizationModel);
            Assert.assertEquals(userModels.size(), 1);
            UserModel bburke = userModels.get(0);
            Assert.assertEquals(bburke.getFirstName(), "Bill");
            Assert.assertEquals(bburke.getLastName(), "Burke");
            Assert.assertEquals(bburke.getEmail(), "bburke@redhat.com");
        }

        {
            UserModel user = organizationManager.getSession().users().addUser(organizationModel, "mburke");
            user.setLastName("Burke");
            user.setFirstName("Monica");
            user.setEmail("mburke@redhat.com");
        }

        {
            UserModel user = organizationManager.getSession().users().addUser(organizationModel, "thor");
            user.setLastName("Thorgersen");
            user.setFirstName("Stian");
            user.setEmail("thor@redhat.com");
        }

        {
            List<UserModel> userModels = adapter.searchUsers("Monica Burke", organizationModel);
            Assert.assertEquals(userModels.size(), 1);
            UserModel bburke = userModels.get(0);
            Assert.assertEquals(bburke.getFirstName(), "Monica");
            Assert.assertEquals(bburke.getLastName(), "Burke");
            Assert.assertEquals(bburke.getEmail(), "mburke@redhat.com");
        }


        {
            List<UserModel> userModels = adapter.searchUsers("mburke@redhat.com", organizationModel);
            Assert.assertEquals(userModels.size(), 1);
            UserModel bburke = userModels.get(0);
            Assert.assertEquals(bburke.getFirstName(), "Monica");
            Assert.assertEquals(bburke.getLastName(), "Burke");
            Assert.assertEquals(bburke.getEmail(), "mburke@redhat.com");
        }

        {
            List<UserModel> userModels = adapter.searchUsers("mburke", organizationModel);
            Assert.assertEquals(userModels.size(), 1);
            UserModel bburke = userModels.get(0);
            Assert.assertEquals(bburke.getFirstName(), "Monica");
            Assert.assertEquals(bburke.getLastName(), "Burke");
            Assert.assertEquals(bburke.getEmail(), "mburke@redhat.com");
        }

        {
            List<UserModel> userModels = adapter.searchUsers("Burke", organizationModel);
            Assert.assertEquals(userModels.size(), 2);
            UserModel first = userModels.get(0);
            UserModel second = userModels.get(1);
            if (!first.getEmail().equals("bburke@redhat.com") && !second.getEmail().equals("bburke@redhat.com")) {
                Assert.fail();
            }
            if (!first.getEmail().equals("mburke@redhat.com") && !second.getEmail().equals("mburke@redhat.com")) {
                Assert.fail();
            }
        }

        OrganizationModel otherRealm = adapter.createOrganization("other");
        organizationManager.getSession().users().addUser(otherRealm, "bburke");

        Assert.assertEquals(1, organizationManager.getSession().users().getUsers(otherRealm, false).size());
        Assert.assertEquals(1, organizationManager.getSession().users().searchForUser("bu", otherRealm).size());
    }*/    

    /*@Test
    public void testOrganizationNameCollisions() throws Exception {
        test1CreateOrganization();

        commit();

        // Try to create realm with duplicate name
        try {
            test1CreateOrganization();
            commit();
            Assert.fail("Expected exception");
        } catch (ModelDuplicateException e) {
        }
        commit(true);

        // Try to rename realm to duplicate name
        organizationManager.createOrganization("JUGGLER2");
        commit();
        try {
            organizationManager.getOrganizationByName("JUGGLER2").setName("JUGGLER");
            commit();
            Assert.fail("Expected exception");
        } catch (ModelDuplicateException e) {
        }

        resetSession();
    }*/    

    /*@Test
    public void testSeriesNumberCollisions() throws Exception {
        OrganizationModel juggler1 = organizationManager.createOrganization("JUGGLER1");
        organizationManager.getSession().invoices().addInvoice(juggler1, 1, 1);
        OrganizationModel juggler2 = organizationManager.createOrganization("JUGGLER2");
        organizationManager.getSession().invoices().addInvoice(juggler2, 1, 1);
        commit();

        // Try to create user with duplicate login name
        try {
            juggler1 = organizationManager.getOrganizationByName("JUGGLER1");
            organizationManager.getSession().invoices().addInvoice(juggler1, 1, 1);
            commit();
            Assert.fail("Expected exception");
        } catch (ModelDuplicateException e) {
        }
        commit(true);

        // Ty to rename user to duplicate login name
        juggler1 = organizationManager.getOrganizationByName("JUGGLER1");
        organizationManager.getSession().invoices().addInvoice(juggler1, 1, 2);
        commit();
        try {
            juggler1 = organizationManager.getOrganizationByName("JUGGLER1");
            //organizationManager.getSession().invoices().getUserByUsername("user2", juggler1).setUsername("user1");
            commit();
            Assert.fail("Expected exception");
        } catch (ModelDuplicateException e) {
        }

        resetSession();
    }*/

    /*@Test
    public void testEmailCollisions() throws Exception {
        OrganizationModel juggler1 = organizationManager.createOrganization("JUGGLER1");
        organizationManager.getSession().users().addUser(juggler1, "user1").setEmail("email@example.com");
        OrganizationModel juggler2 = organizationManager.createOrganization("JUGGLER2");
        organizationManager.getSession().users().addUser(juggler2, "user1").setEmail("email@example.com");
        commit();

        // Try to create user with duplicate email
        juggler1 = organizationManager.getOrganizationByName("JUGGLER1");
        try {
            organizationManager.getSession().users().addUser(juggler1, "user2").setEmail("email@example.com");
            commit();
            Assert.fail("Expected exception");
        } catch (ModelDuplicateException e) {
        }

        resetSession();

        // Ty to rename user to duplicate email
        juggler1 = organizationManager.getOrganizationByName("JUGGLER1");
        organizationManager.getSession().users().addUser(juggler1, "user3").setEmail("email2@example.com");
        commit();
        try {
            juggler1 = organizationManager.getOrganizationByName("JUGGLER1");
            organizationManager.getSession().users().getUserByUsername("user3", juggler1).setEmail("email@example.com");
            commit();
            Assert.fail("Expected exception");
        } catch (ModelDuplicateException e) {
        }

        resetSession();
    }*/    

    private KeyPair generateKeypair() throws NoSuchAlgorithmException {
        return KeyPairGenerator.getInstance("RSA").generateKeyPair();
    }

}
