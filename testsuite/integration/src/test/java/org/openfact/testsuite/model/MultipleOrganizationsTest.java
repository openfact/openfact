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
import org.openfact.models.CreditNoteModel;
import org.openfact.models.DebitNoteModel;
import org.openfact.models.InvoiceModel;
import org.openfact.models.OrganizationModel;

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
    public void testInvoices() {
        InvoiceModel r1invoice1 = session.invoices().getInvoiceByDocumentId(organization1, "F01-001");
        InvoiceModel r2invoice1 = session.invoices().getInvoiceByDocumentId(organization2, "F01-001");
        Assert.assertEquals(r1invoice1.getDocumentId(), r2invoice1.getDocumentId());
        Assert.assertNotEquals(r1invoice1.getId(), r2invoice1.getId());

        // Test searching
        Assert.assertEquals(2, session.invoices().searchForInvoice(organization1, "F01").size());

        commit();
        organization1 = model.getOrganization("id1");
        organization2 = model.getOrganization("id2");

        session.invoices().removeInvoice(organization1, r1invoice1);
        InvoiceModel invoice2 = session.invoices().getInvoiceByDocumentId(organization1, "F01-002");
        session.invoices().removeInvoice(organization1, invoice2);
        Assert.assertEquals(0, session.invoices().searchForInvoice(organization1, "F01").size());
        Assert.assertEquals(2, session.invoices().searchForInvoice(organization2, "F01").size());
    }

    @Test
    public void testCreditNotes() {
        CreditNoteModel r1creditNote1 = session.creditNotes().getCreditNoteByDocumentId(organization1, "C01-001");
        CreditNoteModel r2creditNote1 = session.creditNotes().getCreditNoteByDocumentId(organization2, "C01-001");
        Assert.assertEquals(r1creditNote1.getDocumentId(), r2creditNote1.getDocumentId());
        Assert.assertNotEquals(r1creditNote1.getId(), r2creditNote1.getId());

        // Test searching
        Assert.assertEquals(2, session.creditNotes().searchForCreditNote(organization1, "C01").size());

        commit();
        organization1 = model.getOrganization("id1");
        organization2 = model.getOrganization("id2");

        session.creditNotes().removeCreditNote(organization1, r1creditNote1);
        CreditNoteModel creditNote2 = session.creditNotes().getCreditNoteByDocumentId(organization1, "C01-002");
        session.creditNotes().removeCreditNote(organization1, creditNote2);
        Assert.assertEquals(0, session.creditNotes().searchForCreditNote(organization1, "C01").size());
        Assert.assertEquals(2, session.creditNotes().searchForCreditNote(organization2, "C01").size());
    }

    @Test
    public void testDebitNotes() {
        DebitNoteModel r1debitNote1 = session.debitNotes().getDebitNoteByDocumentId(organization1, "D01-001");
        DebitNoteModel r2debitNote1 = session.debitNotes().getDebitNoteByDocumentId(organization2, "D01-001");
        Assert.assertEquals(r1debitNote1.getDocumentId(), r2debitNote1.getDocumentId());
        Assert.assertNotEquals(r1debitNote1.getId(), r2debitNote1.getId());

        // Test searching
        Assert.assertEquals(2, session.debitNotes().searchForDebitNote(organization1, "D01").size());

        commit();
        organization1 = model.getOrganization("id1");
        organization2 = model.getOrganization("id2");

        session.debitNotes().removeDebitNote(organization1, r1debitNote1);
        DebitNoteModel creditNote2 = session.debitNotes().getDebitNoteByDocumentId(organization1, "D01-002");
        session.debitNotes().removeDebitNote(organization1, creditNote2);
        Assert.assertEquals(0, session.debitNotes().searchForDebitNote(organization1, "D01").size());
        Assert.assertEquals(2, session.debitNotes().searchForDebitNote(organization2, "D01").size());
    }

    @Test
    public void testFiles() {
        FileModel r1file1 = session.getProvider(FileProvider.class).getFileByFileName(organization1, "file1");
        FileModel r2file1 = session.getProvider(FileProvider.class).getFileByFileName(organization2, "file1");

        Assert.assertEquals(r1file1.getFileName(), r2file1.getFileName());
        Assert.assertNotEquals(r1file1.getId(), r2file1.getId());

        // Test searching
        //Assert.assertEquals(2, session.getProvider(FileProvider.class).searchForFile(organization1, "D01").size());

        commit();
        organization1 = model.getOrganization("id1");
        organization2 = model.getOrganization("id2");

        session.getProvider(FileProvider.class).removeFile(organization1, r1file1);
        FileModel file2 = session.getProvider(FileProvider.class).getFileByFileName(organization1, "file2");
        session.getProvider(FileProvider.class).removeFile(organization1, file2);
        Assert.assertNull(session.getProvider(FileProvider.class).getFileByFileName(organization1, "file1"));
        Assert.assertNotNull(session.getProvider(FileProvider.class).getFileByFileName(organization2, "file1"));
        Assert.assertNotNull(session.getProvider(FileProvider.class).getFileByFileName(organization2, "file2"));
    }

    private void createObjects(OrganizationModel organization) {
        organizationManager.getSession().invoices().addInvoice(organization, "F01-001");
        organizationManager.getSession().invoices().addInvoice(organization, "F01-002");

        organizationManager.getSession().creditNotes().addCreditNote(organization, "C01-001");
        organizationManager.getSession().creditNotes().addCreditNote(organization, "C01-002");

        organizationManager.getSession().debitNotes().addDebitNote(organization, "D01-001");
        organizationManager.getSession().debitNotes().addDebitNote(organization, "D01-002");

        organizationManager.getSession().getProvider(FileProvider.class).createFile(organization, "file1", new byte[]{1,2,3});
        organizationManager.getSession().getProvider(FileProvider.class).createFile(organization, "file2", new byte[]{1,2,3});
    }

}
