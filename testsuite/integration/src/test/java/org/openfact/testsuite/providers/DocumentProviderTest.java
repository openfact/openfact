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

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openfact.models.*;
import org.openfact.models.enums.DocumentType;
import org.openfact.models.enums.RequiredAction;

public class DocumentProviderTest extends AbstractProviderTest {

    protected OrganizationModel organization;

    public void createOrganization() {
        OrganizationProvider provider = session.organizations();
        organization = provider.createOrganization("SISTCOOP");
        commit();
    }

    @Test
    public void createWithSeriesAndNumber() throws Exception {
        createOrganization();

        DocumentModel document = session.documents().addDocument(DocumentType.INVOICE.toString(), "F002-0003", organization);
        commit();

        assertThat(document, is(notNullValue()));
        assertThat(document.getId(), is(notNullValue()));
        assertThat(document.getDocumentId(), is("F002-0003"));
    }

    @Test
    public void SeriesAndNumberCollision() {
        OrganizationModel sistcoop1 = session.organizations().createOrganization("SISTCOOP1");
        OrganizationModel sistcoop2 = session.organizations().createOrganization("SISTCOOP2");
        commit();

        session.documents().addDocument(DocumentType.INVOICE.toString(), "F01-001", sistcoop1);
        session.documents().addDocument(DocumentType.INVOICE.toString(), "F01-001", sistcoop2);
        commit();

        // Try to create ublDocument with duplicate series and number
        try {
            sistcoop1 = session.organizations().getOrganizationByName("SISTCOOP1");
            session.documents().addDocument(DocumentType.INVOICE.toString(), "F01-001", sistcoop1);
            commit();
            Assert.fail("Expected exception");
        } catch (ModelDuplicateException e) {
        }
        commit(true);

        resetSession();
    }

    @Test
    public void findById() throws Exception {
        createOrganization();
        DocumentModel document1 = session.documents().addDocument(DocumentType.INVOICE.toString(), "F01-001", organization);
        commit();

        DocumentModel document2 = session.documents().getDocumentById(document1.getId(), organization);
        assertThat(document2, is(notNullValue()));
        assertThat(document2.getId(), is(notNullValue()));
        assertThat(document2.getId(), is(equalTo(document1.getId())));
        assertThat(document2.getDocumentId(), is(equalTo(document1.getDocumentId())));
    }

    @Test
    public void findBySeriesAndNumber() throws Exception {
        createOrganization();
        DocumentProvider provider = session.documents();
        DocumentModel document1 = provider.addDocument(DocumentType.INVOICE.toString(), "F001-0001", organization);
        commit();

        DocumentModel document2 = session.documents().getDocumentByDocumentTypeAndId(DocumentType.INVOICE.toString(), "F001-0001", organization);
        assertThat(document2, is(notNullValue()));
        assertThat(document2.getId(), is(notNullValue()));
        assertThat(document2.getId(), is(equalTo(document1.getId())));
        assertThat(document2.getDocumentId(), is(equalTo(document1.getDocumentId())));
    }

    @Test
    public void remove() throws Exception {
        createOrganization();

        DocumentProvider provider = session.documents();
        provider.addDocument(DocumentType.INVOICE.toString(), "F001-0001", organization);
        commit();

        DocumentModel document = session.documents().getDocumentByDocumentTypeAndId(DocumentType.INVOICE.toString(), "F001-0001", organization);
        assertThat(session.documents().removeDocument(document.getId(), organization), is(true));
        assertThat(session.documents().removeDocument(document.getId(), organization), is(false));
        assertThat(session.documents().getDocumentByDocumentTypeAndId(DocumentType.INVOICE.toString(), "F001-0001", organization), is(nullValue()));
    }

    /**
     * Get documents
     */
    @Test
    public void getInvoicesByOrganization() throws Exception {
        OrganizationModel sistcoop1 = session.organizations().createOrganization("SISTCOOP1");
        OrganizationModel sistcoop2 = session.organizations().createOrganization("SISTCOOP2");
        commit();

        session.documents().addDocument(DocumentType.INVOICE.toString(), "F01-001", sistcoop1);
        session.documents().addDocument(DocumentType.INVOICE.toString(), "F01-002", sistcoop1);
        session.documents().addDocument(DocumentType.INVOICE.toString(), "F01-003", sistcoop1);

        session.documents().addDocument(DocumentType.INVOICE.toString(), "F01-004", sistcoop2);
        session.documents().addDocument(DocumentType.INVOICE.toString(), "F01-005", sistcoop2);
        session.documents().addDocument(DocumentType.INVOICE.toString(), "F01-006", sistcoop2);
        commit();

        List<DocumentModel> documents1 = session.documents().getDocuments(sistcoop1);
        List<DocumentModel> documents2 = session.documents().getDocuments(sistcoop2);

        List<DocumentModel> documents3 = session.documents().getDocuments(sistcoop1, 0, 1);

        assertThat(documents1.size(), is(3));
        assertThat(documents2.size(), is(3));
        assertThat(documents3.size(), is(1));
    }

    @Test
    public void searchQuery() {
        OrganizationModel sistcoop1 = session.organizations().createOrganization("SISTCOOP1");
        OrganizationModel sistcoop2 = session.organizations().createOrganization("SISTCOOP2");
        commit();

        session.documents().addDocument(DocumentType.INVOICE.toString(), "F01-001", sistcoop1).addRequiredAction(RequiredAction.SEND_TO_CUSTOMER);
        session.documents().addDocument(DocumentType.INVOICE.toString(), "F01-002", sistcoop1).addRequiredAction(RequiredAction.SEND_TO_TRIRD_PARTY);
        session.documents().addDocument(DocumentType.INVOICE.toString(), "F01-003", sistcoop1);
        session.documents().addDocument(DocumentType.CREDIT_NOTE.toString(), "C01-001", sistcoop1).addRequiredAction(RequiredAction.SEND_TO_CUSTOMER);
        session.documents().addDocument(DocumentType.CREDIT_NOTE.toString(), "C01-002", sistcoop1).addRequiredAction(RequiredAction.SEND_TO_TRIRD_PARTY);
        session.documents().addDocument(DocumentType.CREDIT_NOTE.toString(), "C01-003", sistcoop1);

        session.documents().addDocument(DocumentType.INVOICE.toString(), "F01-004", sistcoop2).addRequiredAction(RequiredAction.SEND_TO_CUSTOMER);
        session.documents().addDocument(DocumentType.INVOICE.toString(), "F01-005", sistcoop2).addRequiredAction(RequiredAction.SEND_TO_TRIRD_PARTY);
        session.documents().addDocument(DocumentType.INVOICE.toString(), "F01-006", sistcoop2);
        session.documents().addDocument(DocumentType.CREDIT_NOTE.toString(), "F01-004", sistcoop2).addRequiredAction(RequiredAction.SEND_TO_CUSTOMER);
        session.documents().addDocument(DocumentType.CREDIT_NOTE.toString(), "F01-005", sistcoop2).addRequiredAction(RequiredAction.SEND_TO_TRIRD_PARTY);
        session.documents().addDocument(DocumentType.CREDIT_NOTE.toString(), "F01-006", sistcoop2);
        commit();

        DocumentQuery query = session.documents().createQuery(sistcoop1);
        query.documentType(DocumentType.INVOICE.toString());
        assertThat(query.getResultList().size(), is(3));

        query = session.documents().createQuery(sistcoop1);
        query.documentType(DocumentType.CREDIT_NOTE.toString());
        assertThat(query.getResultList().size(), is(3));

        query = session.documents().createQuery(sistcoop1);
        query.documentType(DocumentType.INVOICE.toString(), DocumentType.CREDIT_NOTE.toString());
        assertThat(query.getResultList().size(), is(6));

        query = session.documents().createQuery(sistcoop1);
        query.filterText("2", DocumentModel.DOCUMENT_ID);
        assertThat(query.getResultList().size(), is(2));

        query = session.documents().createQuery(sistcoop1);
        query.requiredAction(RequiredAction.SEND_TO_CUSTOMER);
        assertThat(query.getResultList().size(), is(2));

        query = session.documents().createQuery(sistcoop1);
        query.documentType(DocumentType.INVOICE.toString());
        query.requiredAction(RequiredAction.SEND_TO_CUSTOMER);
        assertThat(query.getResultList().size(), is(1));

        query = session.documents().createQuery(sistcoop1);
        query.documentType(DocumentType.INVOICE.toString());
        query.filterText("F", DocumentModel.DOCUMENT_ID, DocumentModel.CUSTOMER_REGISTRATION_NAME, DocumentModel.CUSTOMER_ASSIGNED_ACCOUNT_ID);
        assertThat(query.getResultList().size(), is(3));

        query = session.documents().createQuery(sistcoop1);
        query.documentType(DocumentType.INVOICE.toString());
        query.fromDate(LocalDateTime.now().minusDays(1));
        assertThat(query.getResultList().size(), is(3));

        DocumentCountQuery countQuery = session.documents().createCountQuery(sistcoop1);
        countQuery.documentType(DocumentType.INVOICE.toString());
        countQuery.requiredAction(RequiredAction.SEND_TO_CUSTOMER);
        assertThat(countQuery.getTotalCount(), is(1));

    }

}
