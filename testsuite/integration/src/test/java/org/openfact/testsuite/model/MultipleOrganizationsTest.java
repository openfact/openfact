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

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openfact.file.FileModel;
import org.openfact.file.FileProvider;
import org.openfact.models.DocumentModel;
import org.openfact.models.OrganizationModel;
import org.openfact.models.enums.DocumentType;

/**
 * @author <a href="mailto:mposolda@sistcoop.com">Marek Posolda</a>
 */
public class MultipleOrganizationsTest extends AbstractModelTest {

    private OrganizationModel organization1;
    private OrganizationModel organization2;

    @Before
    @Override
    public void before() throws Exception {
        super.before();
        organization1 = organizationManager.createOrganization("id1", "organization1");
        organization2 = organizationManager.createOrganization("id2", "organization2");

        createObjects(organization1);
        createObjects(organization2);
    }

    @Test
    public void testDocuments() {
        DocumentModel r1invoice1 = session.documents().getDocumentByTypeAndUblId(DocumentType.INVOICE.toString(), "F01-001", organization1);
        DocumentModel r2invoice1 = session.documents().getDocumentByTypeAndUblId(DocumentType.INVOICE.toString(), "F01-001", organization2);
        Assert.assertEquals(r1invoice1.getDocumentId(), r2invoice1.getDocumentId());
        Assert.assertNotEquals(r1invoice1.getId(), r2invoice1.getId());

        // Test searching
        Assert.assertEquals(2, session.documents().searchForDocument("F01", organization1).size());

        commit();
        organization1 = model.getOrganization("id1");
        organization2 = model.getOrganization("id2");

        session.documents().removeDocument(r1invoice1.getId(), organization1);
        DocumentModel invoice2 = session.documents().getDocumentByTypeAndUblId(DocumentType.INVOICE.toString(), "F01-002", organization1);
        session.documents().removeDocument(invoice2.getId(), organization1);
        Assert.assertEquals(0, session.documents().searchForDocument("F01", organization1).size());
        Assert.assertEquals(2, session.documents().searchForDocument("F01", organization2).size());
    }

    @Test
    public void testFiles() {
        FileModel r1file1 = session.files().getFileByFileName(organization1, "file1");
        FileModel r2file1 = session.files().getFileByFileName(organization2, "file1");

        Assert.assertEquals(r1file1.getFileName(), r2file1.getFileName());
        Assert.assertNotEquals(r1file1.getId(), r2file1.getId());

        // Test searching
        //Assert.assertEquals(2, session.files().searchForFile(organization1, "D01").size());

        commit();
        organization1 = model.getOrganization("id1");
        organization2 = model.getOrganization("id2");

        session.files().removeFile(organization1, r1file1);
        Assert.assertNull(session.files().getFileById(organization1, r1file1.getId()));

        FileModel file2 = session.files().getFileByFileName(organization1, "file2");
        session.files().removeFile(organization1, file2);
        Assert.assertNull(session.files().getFileByFileName(organization1, "file1"));
        Assert.assertNotNull(session.files().getFileByFileName(organization2, "file1"));
        Assert.assertNotNull(session.files().getFileByFileName(organization2, "file2"));
    }

    private void createObjects(OrganizationModel organization) {
        organizationManager.getSession().documents().addDocument(DocumentType.INVOICE.toString(), "F01-001", organization);
        organizationManager.getSession().documents().addDocument(DocumentType.INVOICE.toString(), "F01-002", organization);

        organizationManager.getSession().files().createFile(organization, "file1", new byte[]{1, 2, 3});
        organizationManager.getSession().files().createFile(organization, "file2", new byte[]{1, 2, 3});
    }

}
