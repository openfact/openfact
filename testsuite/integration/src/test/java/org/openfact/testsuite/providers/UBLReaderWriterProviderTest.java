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
package org.openfact.testsuite.providers;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.openfact.models.OrganizationModel;

public class UBLReaderWriterProviderTest /*extends AbstractProviderTest*/ {

    protected OrganizationModel organization;

    /*@Before
    @Override
    public void before() throws Exception {
        super.before();
        OrganizationManager manager = organizationManager;
        OrganizationRepresentation rep = AbstractProviderTest.loadJson("model/testorganization2.json");
        rep.setId("TestUblProvider");
        organization = manager.importOrganization(rep);
    }

    @Test
    public void getInvoiceDocument() throws Exception {
        List<InvoiceModel> documents = session.documents().getDocuments(organization);
        InvoiceModel documentEntity = documents.getObject(0);

        Set<InvoiceReaderWriterProvider> providers = session.getAllProviders(InvoiceReaderWriterProvider.class);
        for (InvoiceReaderWriterProvider provider : providers) {
            byte[] bytes = documentEntity.getXmlDocument();
            InvoiceType invoiceType = provider.read(bytes);

            assertThat(invoiceType, is(notNullValue()));

            Document xml = provider.writeAsDocument(organization, invoiceType, documentEntity.getAttributes());

            assertThat(xml, is(notNullValue()));
        }
    }

    @Test
    public void getCreditNoteDocument() throws Exception {
        List<CreditNoteModel> creditNotes = session.creditNotes().getCreditNotes(organization);
        CreditNoteModel creditNote = creditNotes.getObject(0);

        Set<CreditNoteReaderWriterProvider> providers = session.getAllProviders(CreditNoteReaderWriterProvider.class);
        for (CreditNoteReaderWriterProvider provider : providers) {
            byte[] bytes = creditNote.getXmlDocument();
            CreditNoteType creditNoteType = provider.read(bytes);

            assertThat(creditNoteType, is(notNullValue()));

            Document xml = provider.writeAsDocument(organization, creditNoteType, creditNote.getAttributes());

            assertThat(xml, is(notNullValue()));
        }
    }

    @Test
    public void getDebitNoteDocument() throws Exception {
        List<DebitNoteModel> debitNotes = session.debitNotes().getDebitNotes(organization);
        DebitNoteModel debitNote = debitNotes.getObject(0);

        Set<DebitNoteReaderWriterProvider> providers = session.getAllProviders(DebitNoteReaderWriterProvider.class);
        for (DebitNoteReaderWriterProvider provider : providers) {
            byte[] bytes = debitNote.getXmlDocument();
            DebitNoteType debitNoteType = provider.read(bytes);

            assertThat(debitNoteType, is(notNullValue()));

            Document xml = provider.writeAsDocument(organization, debitNoteType, debitNote.getAttributes());

            assertThat(xml, is(notNullValue()));
        }
    }*/

}
