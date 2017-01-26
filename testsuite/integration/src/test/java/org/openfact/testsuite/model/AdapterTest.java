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

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openfact.models.DocumentModel;
import org.openfact.models.ModelDuplicateException;
import org.openfact.models.OrganizationModel;
import org.openfact.models.enums.DocumentType;

/**
 * @author <a href="mailto:carlosthe19916@sistcoop.com">Carlos Feria</a>
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

        session.getTransactionManager().commit();
        resetSession();

        organizationModel = organizationManager.getOrganization(organizationModel.getId());
        assertNotNull(organizationModel);
        Assert.assertEquals(organizationModel.getName(), "SISTCOOP");
        Assert.assertEquals(organizationModel.getDescription(), "SISTCOOP IS A SOFTWARE COMPANY");
        Assert.assertEquals(organizationModel.isEnabled(), true);

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
        test1CreateOrganization();

        commit();
        List<OrganizationModel> organizations = model.getOrganizations();
        Assert.assertEquals(organizations.size(), 2);
    }

    @Test
    public void testRemoveOrganization() throws Exception {
        test1CreateOrganization();

        DocumentModel document = organizationManager.getSession().documents().addDocument(DocumentType.INVOICE.toString(), "F01-01", organizationModel);

        commit();
        organizationModel = model.getOrganization("SISTCOOP");

        Assert.assertTrue(organizationManager.removeOrganization(organizationModel));
        Assert.assertFalse(organizationManager.removeOrganization(organizationModel));
        assertNull(organizationManager.getOrganization(organizationModel.getId()));
    }

    @Test
    public void testDeleteDocument() throws Exception {
        test1CreateOrganization();

        DocumentModel document = organizationManager.getSession().documents().addDocument(DocumentType.INVOICE.toString(), "F01-001", organizationModel);
        commit();

        organizationModel = model.getOrganization("SISTCOOP");
        Assert.assertTrue(organizationManager.getSession().documents().removeDocument(document.getId(), organizationModel));
        assertNull(organizationManager.getSession().documents().getDocumentByDocumentTypeAndId(DocumentType.INVOICE.toString(), "F01-001", organizationModel));
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

        organizationManager.getSession().documents().addDocument(DocumentType.INVOICE.toString(), "F01-001", sistcoop1);
        organizationManager.getSession().documents().addDocument(DocumentType.INVOICE.toString(), "F01-001", sistcoop2);
        commit();


        // Try to create documentEntity with duplicate series and number
        try {
            sistcoop1 = organizationManager.getOrganizationByName("SISTCOOP1");
            organizationManager.getSession().documents().addDocument(DocumentType.INVOICE.toString(), "F01-001", sistcoop1);
            commit();
            Assert.fail("Expected exception");
        } catch (ModelDuplicateException e) {
        }
        commit(true);

        resetSession();
    }

    private KeyPair generateKeypair() throws NoSuchAlgorithmException {
        return KeyPairGenerator.getInstance("RSA").generateKeyPair();
    }

}
