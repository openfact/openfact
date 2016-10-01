/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates
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
 */

package org.openfact.testsuite.model;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openfact.Config;
import org.openfact.models.ModelDuplicateException;
import org.openfact.models.OrganizationModel;
import org.openfact.models.UserModel;
import org.openfact.models.ubl.CreditNoteModel;
import org.openfact.models.ubl.DebitNoteModel;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.services.managers.OrganizationManager;

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

/**
 * @author <a href="mailto:bill@burkecentral.com">Bill Burke</a>
 * @version $Revision: 1 $
 */
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
        organizationModel.setAdditionalAccountId("RUC");
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

        InvoiceModel invoice = organizationManager.getSession().invoices().addInvoice(organizationModel, "F01-01");
        invoice.addInvoiceLine();

        CreditNoteModel creditNote = organizationManager.getSession().creditNotes().addCreditNote(organizationModel, "C01-01");
        creditNote.addCreditNoteLine();
        
        DebitNoteModel debitNote = organizationManager.getSession().debitNotes().addDebitNote(organizationModel, "D01-01");
        debitNote.addDebitNoteLine();
        
        commit();
        organizationModel = model.getOrganization("SISTCOOP");

        Assert.assertTrue(organizationManager.removeOrganization(organizationModel));
        Assert.assertFalse(organizationManager.removeOrganization(organizationModel));
        assertNull(organizationManager.getOrganization(organizationModel.getId()));
    }

    @Test
    public void testDeleteInvoice() throws Exception {
        test1CreateOrganization();

        InvoiceModel invoice = organizationManager.getSession().invoices().addInvoice(organizationModel, "F01-001");
        commit();

        organizationModel = model.getOrganization("SISTCOOP");
        Assert.assertTrue(organizationManager.getSession().invoices().removeInvoice(organizationModel, invoice));
        assertNull(organizationManager.getSession().invoices().getInvoiceByID(organizationModel, "F01-001"));
    }
    
    @Test
    public void testDeleteCreditNote() throws Exception {
        test1CreateOrganization();

        CreditNoteModel creditNote = organizationManager.getSession().creditNotes().addCreditNote(organizationModel, "C01-001");
        commit();

        organizationModel = model.getOrganization("SISTCOOP");
        Assert.assertTrue(organizationManager.getSession().creditNotes().removeCreditNote(organizationModel, creditNote));
        assertNull(organizationManager.getSession().creditNotes().getCreditNoteByID(organizationModel, "C01-001"));
    }
    
    @Test
    public void testDeleteDebitNote() throws Exception {
        test1CreateOrganization();

        DebitNoteModel debitNote = organizationManager.getSession().debitNotes().addDebitNote(organizationModel, "D01-001");
        commit();

        organizationModel = model.getOrganization("SISTCOOP");
        Assert.assertTrue(organizationManager.getSession().debitNotes().removeDebitNote(organizationModel, debitNote));
        assertNull(organizationManager.getSession().debitNotes().getDebitNoteByID(organizationModel, "D01-001"));
    }

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
        OrganizationModel sistcoop2 = organizationManager.createOrganization("SISTCOOP2");        
        commit();

        organizationManager.getSession().invoices().addInvoice(sistcoop1, "F01-001");
        organizationManager.getSession().invoices().addInvoice(sistcoop2, "F01-001");
        
        organizationManager.getSession().creditNotes().addCreditNote(sistcoop1, "C01-001");
        organizationManager.getSession().creditNotes().addCreditNote(sistcoop2, "C01-001");
        
        organizationManager.getSession().debitNotes().addDebitNote(sistcoop1, "D01-001");
        organizationManager.getSession().debitNotes().addDebitNote(sistcoop2, "D01-001");
        commit();

        
        // Try to create invoice with duplicate series and number
        try {
            sistcoop1 = organizationManager.getOrganizationByName("SISTCOOP1");
            organizationManager.getSession().invoices().addInvoice(sistcoop1, "F01-001");
            commit();
            Assert.fail("Expected exception");
        } catch (ModelDuplicateException e) {
        }
        commit(true);
        
        // Try to create creditNote with duplicate series and number
        try {
            sistcoop1 = organizationManager.getOrganizationByName("SISTCOOP1");
            organizationManager.getSession().creditNotes().addCreditNote(sistcoop1, "C01-001");
            commit();
            Assert.fail("Expected exception");
        } catch (ModelDuplicateException e) {
        }
        commit(true);
        
        // Try to create debitNote with duplicate series and number
        try {
            sistcoop1 = organizationManager.getOrganizationByName("SISTCOOP1");
            organizationManager.getSession().debitNotes().addDebitNote(sistcoop1, "D01-001");
            commit();
            Assert.fail("Expected exception");
        } catch (ModelDuplicateException e) {
        }
        commit(true);

        
        // Ty to rename invoice to duplicate series and number
        sistcoop1 = organizationManager.getOrganizationByName("SISTCOOP1");
        organizationManager.getSession().invoices().addInvoice(sistcoop1, "F01-002");
        commit();
        try {
            sistcoop1 = organizationManager.getOrganizationByName("SISTCOOP1");
            organizationManager.getSession().invoices().getInvoiceByID(sistcoop1, "F01-002").setID("F01-001");
            commit();
            Assert.fail("Expected exception");
        } catch (ModelDuplicateException e) {
        }
        resetSession();
        
        // Ty to rename creditNote to duplicate series and number
        sistcoop1 = organizationManager.getOrganizationByName("SISTCOOP1");
        organizationManager.getSession().creditNotes().addCreditNote(sistcoop1, "C01-002");
        commit();
        try {
            sistcoop1 = organizationManager.getOrganizationByName("SISTCOOP1");
            organizationManager.getSession().creditNotes().getCreditNoteByID(sistcoop1, "C01-002").setID("C01-001");
            commit();
            Assert.fail("Expected exception");
        } catch (ModelDuplicateException e) {
        }
        resetSession();
        
        // Ty to rename debitNote to duplicate series and number
        sistcoop1 = organizationManager.getOrganizationByName("SISTCOOP1");
        organizationManager.getSession().debitNotes().addDebitNote(sistcoop1, "D01-002");
        commit();
        try {
            sistcoop1 = organizationManager.getOrganizationByName("SISTCOOP1");
            organizationManager.getSession().debitNotes().getDebitNoteByID(sistcoop1, "D01-002").setID("D01-001");
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
