package org.openfact.testsuite.model;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openfact.models.InvoiceModel;
import org.openfact.models.ModelDuplicateException;
import org.openfact.models.OrganizationModel;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
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
        organizationModel = organizationManager.createOrganization("JUGGLER");        
        organizationModel.setAccessCodeLifespanUserAction(600);
        organizationModel.setEnabled(true);
        organizationModel.setName("JUGGLER");

        KeyPair keyPair = generateKeypair();

        /*organizationModel.setPrivateKey(keyPair.getPrivate());
        organizationModel.setPublicKey(keyPair.getPublic());
        organizationModel.setAccessTokenLifespan(1000);
        organizationModel.addDefaultRole("foo");*/

        session.getTransaction().commit();
        resetSession();

        organizationModel = organizationManager.getOrganization(organizationModel.getId());
        assertNotNull(organizationModel);
        Assert.assertEquals(600, organizationModel.getAccessCodeLifespanUserAction());
        Assert.assertEquals(organizationModel.isEnabled(), true);
        Assert.assertEquals(organizationModel.getName(), "JUGGLER");
        //Assert.assertArrayEquals(organizationModel.getPrivateKey().getEncoded(), keyPair.getPrivate().getEncoded());
        //Assert.assertArrayEquals(organizationModel.getPublicKey().getEncoded(), keyPair.getPublic().getEncoded());        
    }

    @Test
    public void testOrganizationListing() throws Exception {
        organizationModel = organizationManager.createOrganization("JUGGLER");
        organizationModel.setAccessCodeLifespanUserAction(600);
        organizationModel.setEnabled(true);
        organizationModel.setName("JUGGLER");
        KeyPair keyPair = generateKeypair();
        /*organizationModel.setPrivateKey(keyPair.getPrivate());
        organizationModel.setPublicKey(keyPair.getPublic());
        organizationModel.setAccessTokenLifespan(1000);
        organizationModel.addDefaultRole("foo");*/

        organizationModel = organizationManager.getOrganization(organizationModel.getId());
        assertNotNull(organizationModel);
        Assert.assertEquals(600, organizationModel.getAccessCodeLifespanUserAction());
        Assert.assertEquals(organizationModel.isEnabled(), true);
        Assert.assertEquals(organizationModel.getName(), "JUGGLER");
        /*Assert.assertArrayEquals(organizationModel.getPrivateKey().getEncoded(), keyPair.getPrivate().getEncoded());
        Assert.assertArrayEquals(organizationModel.getPublicKey().getEncoded(), keyPair.getPublic().getEncoded());
        Assert.assertEquals(3, organizationModel.getDefaultRoles().size());
        Assert.assertTrue(organizationModel.getDefaultRoles().contains("foo"));*/

        organizationModel.getId();

        commit();
        List<OrganizationModel> realms = model.getOrganizations();
        Assert.assertEquals(realms.size(), 2);
    }


    /*@Test
    public void test2RequiredCredential() throws Exception {
        test1CreateOrganization();
        organizationModel.addRequiredCredential(CredentialRepresentation.PASSWORD);
        List<RequiredCredentialModel> storedCreds = organizationModel.getRequiredCredentials();
        Assert.assertEquals(1, storedCreds.size());

        Set<String> creds = new HashSet<String>();
        creds.add(CredentialRepresentation.PASSWORD);
        creds.add(CredentialRepresentation.TOTP);
        organizationModel.updateRequiredCredentials(creds);
        storedCreds = organizationModel.getRequiredCredentials();
        Assert.assertEquals(2, storedCreds.size());
        boolean totp = false;
        boolean password = false;
        for (RequiredCredentialModel cred : storedCreds) {
            Assert.assertTrue(cred.isInput());
            if (cred.getType().equals(CredentialRepresentation.PASSWORD)) {
                password = true;
                Assert.assertTrue(cred.isSecret());
            } else if (cred.getType().equals(CredentialRepresentation.TOTP)) {
                totp = true;
                Assert.assertFalse(cred.isSecret());
            }
        }
        Assert.assertTrue(totp);
        Assert.assertTrue(password);
    }*/

    /*@Test
    public void testCredentialValidation() throws Exception {
        test1CreateOrganization();
        UserProvider userProvider = organizationManager.getSession().users();
        UserModel user = userProvider.addUser(organizationModel, "bburke");
        UserCredentialModel cred = new UserCredentialModel();
        cred.setType(CredentialRepresentation.PASSWORD);
        cred.setValue("geheim");
        user.updateCredential(cred);
        Assert.assertTrue(userProvider.validCredentials(session, organizationModel, user, UserCredentialModel.password("geheim")));
        List<UserCredentialValueModel> creds = user.getCredentialsDirectly();
        Assert.assertEquals(creds.get(0).getHashIterations(), 20000);
        organizationModel.setPasswordPolicy(PasswordPolicy.parse(organizationManager.getSession(), "hashIterations(200)"));
        Assert.assertTrue(userProvider.validCredentials(session, organizationModel, user, UserCredentialModel.password("geheim")));
        creds = user.getCredentialsDirectly();
        Assert.assertEquals(creds.get(0).getHashIterations(), 200);
        organizationModel.setPasswordPolicy(PasswordPolicy.parse(organizationManager.getSession(), "hashIterations(1)"));
    }*/

    @Test
    public void testDeleteInvoice() throws Exception {
        test1CreateOrganization();

        InvoiceModel invoice = organizationManager.getSession().invoices().addInvoice(organizationModel, 1, 1);
        invoice.setSingleAttribute("attr1", "val1");
        invoice.addRequiredAction(InvoiceModel.RequiredAction.UPDATE_PASSWORD);

        commit();

        organizationModel = model.getOrganization("JUGGLER");
        Assert.assertTrue(organizationManager.getSession().invoices().removeInvoice(organizationModel, invoice));
        assertNull(organizationManager.getSession().invoices().getInvoiceBySeriesAndNumber(1, 1, organizationModel));
    }

    @Test
    public void testRemoveOrganization() throws Exception {
        test1CreateOrganization();

        InvoiceModel user = organizationManager.getSession().invoices().addInvoice(organizationModel, 1, 1);
        
        commit();
        organizationModel = model.getOrganization("JUGGLER");

        Assert.assertTrue(organizationManager.removeOrganization(organizationModel));
        Assert.assertFalse(organizationManager.removeOrganization(organizationModel));
        assertNull(organizationManager.getOrganization(organizationModel.getId()));
    }

    
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

    @Test
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
    }    

    @Test
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
    }

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
