package org.openfact.testsuite.model;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;
import org.openfact.models.*;
import org.openfact.models.DocumentModel.DocumentType;
import org.openfact.models.DocumentModel.RequiredAction;
import org.openfact.models.search.PagingModel;
import org.openfact.models.search.SearchResultsModel;

import javax.inject.Inject;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class DocumentQueryTest extends AbstractModelTest {

    public static final String ORGANIZATION_NAME1 = "SISTCOOP S.A.C.";
    public static final String ORGANIZATION_NAME2 = "SOFTGREEN S.A.C.";

    @Inject
    public OrganizationProvider organizationProvider;

    @Inject
    public DocumentProvider documentProvider;

    public OrganizationModel ORGANIZATION1;
    public OrganizationModel ORGANIZATION2;

    @Deployment
    public static Archive deploy() {
        Archive[] libs = TestUtil.getLibraries();
        WebArchive archive = buildArchive()
                .addClasses(TestUtil.getOrganizationClasses())
                .addClasses(TestUtil.getDocumentClasses())
                .addClasses(TestUtil.getDocumentQueryClasses());
        return archive.addAsLibraries(libs);
    }

    @Before
    public void before() {
        ORGANIZATION1 = organizationProvider.createOrganization(ORGANIZATION_NAME1);
        ORGANIZATION2 = organizationProvider.createOrganization(ORGANIZATION_NAME2);

        // documents for organization1
        documentProvider.addDocument(ORGANIZATION1, DocumentType.INVOICE, "F001-0001").setCurrencyCode("USD");
        documentProvider.addDocument(ORGANIZATION1, DocumentType.INVOICE, "F001-0002").setCurrencyCode("USD");
        documentProvider.addDocument(ORGANIZATION1, DocumentType.INVOICE, "F001-0003").setCurrencyCode("PEN");

        documentProvider.addDocument(ORGANIZATION1, DocumentType.CREDIT_NOTE, "C001-0001").addRequiredAction(RequiredAction.SEND_TO_CUSTOMER);
        documentProvider.addDocument(ORGANIZATION1, DocumentType.CREDIT_NOTE, "C001-0002").addRequiredAction(RequiredAction.SEND_TO_CUSTOMER);
        documentProvider.addDocument(ORGANIZATION1, DocumentType.CREDIT_NOTE, "C001-0003").addRequiredAction(RequiredAction.SEND_TO_THIRD_PARTY);

        documentProvider.addDocument(ORGANIZATION1, DocumentType.DEBIT_NOTE, "C001-0001");
        documentProvider.addDocument(ORGANIZATION1, DocumentType.DEBIT_NOTE, "C001-0002");
        documentProvider.addDocument(ORGANIZATION1, DocumentType.DEBIT_NOTE, "C001-0003");

        DocumentModel document1 = documentProvider.addDocument(ORGANIZATION1, DocumentType.DEBIT_NOTE, "X001-0001");
        document1.disable();

        // documents for organization2
        documentProvider.addDocument(ORGANIZATION2, DocumentType.INVOICE, "F001-0001");
        documentProvider.addDocument(ORGANIZATION2, DocumentType.INVOICE, "F001-0002");
        documentProvider.addDocument(ORGANIZATION2, DocumentType.INVOICE, "F001-0003");

        documentProvider.addDocument(ORGANIZATION2, DocumentType.CREDIT_NOTE, "C001-0001");
        documentProvider.addDocument(ORGANIZATION2, DocumentType.CREDIT_NOTE, "C001-0002");
        documentProvider.addDocument(ORGANIZATION2, DocumentType.CREDIT_NOTE, "C001-0003");

        documentProvider.addDocument(ORGANIZATION2, DocumentType.DEBIT_NOTE, "C001-0001");
        documentProvider.addDocument(ORGANIZATION2, DocumentType.DEBIT_NOTE, "C001-0002");
        documentProvider.addDocument(ORGANIZATION2, DocumentType.DEBIT_NOTE, "C001-0003");
    }

    @Test
    public void getAllResult() {
        // Provider
        DocumentQueryProvider queryProvider = documentProvider.queryProvider(ORGANIZATION1);

        // All
        DocumentQueryModel query = DocumentQueryModel.builder().build();
        List<DocumentModel> documents = queryProvider.listQuery(query).getResult();

        assertThat(documents, is(notNullValue()));
        assertThat(documents.size(), equalTo(10));
    }

    @Test
    public void getFirstAndMaxResult() {
        // Provider
        DocumentQueryProvider queryProvider = documentProvider.queryProvider(ORGANIZATION1);

        // First and Max Results
        DocumentQueryModel query = DocumentQueryModel.builder().build();
        ListQueryParamsModel params = ListQueryParamsModel.builder().firstResult(2).maxResults(5).build();
        List<DocumentModel> documents = queryProvider.listQuery(query, params).getResult();
        assertThat(documents.size(), equalTo(5));
    }

    @Test
    public void getOrderByResult() {
        // Provider
        DocumentQueryProvider queryProvider = documentProvider.queryProvider(ORGANIZATION1);

        // Order by Asc
        DocumentQueryModel query = DocumentQueryModel.builder().build();
        ListQueryParamsModel params = ListQueryParamsModel.builder().orderByAsc(DocumentModel.DOCUMENT_ID).build();
        List<DocumentModel> documents = queryProvider.listQuery(query, params).getResult();

        DocumentModel first = documents.get(0);
        DocumentModel last = documents.get(documents.size() - 1);
        assertThat(first.getID(), equalTo("C001-0001"));
        assertThat(last.getID(), equalTo("X001-0001"));

        // Order by Desc
        query = DocumentQueryModel.builder().build();
        params = ListQueryParamsModel.builder().orderByDesc(DocumentModel.DOCUMENT_ID).build();
        documents = queryProvider.listQuery(query, params).getResult();

        first = documents.get(0);
        last = documents.get(documents.size() - 1);
        assertThat(first.getID(), equalTo("X001-0001"));
        assertThat(last.getID(), equalTo("C001-0001"));
    }

    @Test
    public void getFilterTextResult() {
        // Provider
        DocumentQueryProvider queryProvider = documentProvider.queryProvider(ORGANIZATION1);

        // Filter text
        DocumentQueryModel query = DocumentQueryModel.builder().filterText("F001").build();
        List<DocumentModel> documents = queryProvider.listQuery(query).getResult();
        assertThat(documents.size(), equalTo(3));
    }

    @Test
    public void getCurrencyCodeResult() {
        // Provider
        DocumentQueryProvider queryProvider = documentProvider.queryProvider(ORGANIZATION1);

        // Currency code
        DocumentQueryModel query = DocumentQueryModel.builder().currencyCode("USD").build();
        List<DocumentModel> documents = queryProvider.listQuery(query).getResult();
        assertThat(documents.size(), equalTo(2));

        query = DocumentQueryModel.builder().currencyCode("USD", "PEN").build();
        documents = queryProvider.listQuery(query).getResult();
        assertThat(documents.size(), equalTo(3));
    }

    @Test
    public void getEnabledResult() {
        // Provider
        DocumentQueryProvider queryProvider = documentProvider.queryProvider(ORGANIZATION1);

        // enabled
        DocumentQueryModel query = DocumentQueryModel.builder().enabled(true).build();
        List<DocumentModel> documents = queryProvider.listQuery(query).getResult();
        assertThat(documents.size(), equalTo(9));

        query = DocumentQueryModel.builder().enabled(false).build();
        documents = queryProvider.listQuery(query).getResult();
        assertThat(documents.size(), equalTo(1));
    }

    @Test
    public void getRequiredActionsResult() {
        // Provider
        DocumentQueryProvider queryProvider = documentProvider.queryProvider(ORGANIZATION1);

        // Required actions
        DocumentQueryModel query = DocumentQueryModel.builder().requiredAction(RequiredAction.SEND_TO_CUSTOMER).build();
        List<DocumentModel> documents = queryProvider.listQuery(query).getResult();
        assertThat(documents.size(), equalTo(2));

        query = DocumentQueryModel.builder().requiredAction(RequiredAction.SEND_TO_THIRD_PARTY).build();
        documents = queryProvider.listQuery(query).getResult();
        assertThat(documents.size(), equalTo(1));
    }

    @Test
    public void getTypeResult() {
        // Provider
        DocumentQueryProvider queryProvider = documentProvider.queryProvider(ORGANIZATION1);

        // Type
        DocumentQueryModel query = DocumentQueryModel.builder().type(DocumentType.INVOICE).build();
        List<DocumentModel> documents = queryProvider.listQuery(query).getResult();
        assertThat(documents.size(), equalTo(3));
    }

    /**
     * Search
     */

    @Test
    public void searchAllResult() {
        // Provider
        DocumentQueryProvider queryProvider = documentProvider.queryProvider(ORGANIZATION1);

        // All
        DocumentQueryModel query = DocumentQueryModel.builder().build();
        SearchResultsModel<DocumentModel> result = queryProvider.searchQuery(query).getResult();

        assertThat(result, is(notNullValue()));
        assertThat(result.getTotalSize(), equalTo(10));
        assertThat(result.getModels().size(), equalTo(10));
    }

    @Test
    public void searchPagingResult() {
        // Provider
        DocumentQueryProvider queryProvider = documentProvider.queryProvider(ORGANIZATION1);

        // Paging
        DocumentQueryModel query = DocumentQueryModel.builder().build();
        SearchQueryParamsModel params = SearchQueryParamsModel.builder().paging(new PagingModel(1, 5)).build();
        SearchResultsModel<DocumentModel> result = queryProvider.searchQuery(query, params).getResult();
        assertThat(result.getModels().size(), equalTo(5));
        assertThat(result.getTotalSize(), equalTo(10));
    }

    @Test
    public void searchOrderByResult() {
        // Provider
        DocumentQueryProvider queryProvider = documentProvider.queryProvider(ORGANIZATION1);

        // Order by Asc
        DocumentQueryModel query = DocumentQueryModel.builder().build();
        SearchQueryParamsModel params = SearchQueryParamsModel.builder().orderByAsc(DocumentModel.DOCUMENT_ID).build();
        SearchResultsModel<DocumentModel> result = queryProvider.searchQuery(query, params).getResult();

        DocumentModel first = result.getModels().get(0);
        DocumentModel last = result.getModels().get(result.getModels().size() - 1);
        assertThat(first.getID(), equalTo("C001-0001"));
        assertThat(last.getID(), equalTo("X001-0001"));

        // Order by Desc
        query = DocumentQueryModel.builder().build();
        params = SearchQueryParamsModel.builder().orderByDesc(DocumentModel.DOCUMENT_ID).build();
        result = queryProvider.searchQuery(query, params).getResult();

        first = result.getModels().get(0);
        last = result.getModels().get(result.getModels().size() - 1);
        assertThat(first.getID(), equalTo("X001-0001"));
        assertThat(last.getID(), equalTo("C001-0001"));
    }

    @Test
    public void searchFilterTextResult() {
        // Provider
        DocumentQueryProvider queryProvider = documentProvider.queryProvider(ORGANIZATION1);

        // Filter text
        DocumentQueryModel query = DocumentQueryModel.builder().filterText("F001").build();
        SearchResultsModel<DocumentModel> result = queryProvider.searchQuery(query).getResult();
        assertThat(result.getTotalSize(), equalTo(3));
        assertThat(result.getModels().size(), equalTo(3));
    }

    @Test
    public void searchCurrencyCodeResult() {
        // Provider
        DocumentQueryProvider queryProvider = documentProvider.queryProvider(ORGANIZATION1);

        // Currency code
        DocumentQueryModel query = DocumentQueryModel.builder().currencyCode("USD").build();
        SearchResultsModel<DocumentModel> result = queryProvider.searchQuery(query).getResult();
        assertThat(result.getTotalSize(), equalTo(2));
        assertThat(result.getModels().size(), equalTo(2));

        query = DocumentQueryModel.builder().currencyCode("USD", "PEN").build();
        result = queryProvider.searchQuery(query).getResult();
        assertThat(result.getTotalSize(), equalTo(3));
        assertThat(result.getModels().size(), equalTo(3));
    }

    @Test
    public void searchEnabledCodeResult() {
        // Provider
        DocumentQueryProvider queryProvider = documentProvider.queryProvider(ORGANIZATION1);

        // enabled
        DocumentQueryModel query = DocumentQueryModel.builder().enabled(true).build();
        SearchResultsModel<DocumentModel> result = queryProvider.searchQuery(query).getResult();
        assertThat(result.getTotalSize(), equalTo(9));
        assertThat(result.getModels().size(), equalTo(9));

        query = DocumentQueryModel.builder().enabled(false).build();
        result = queryProvider.searchQuery(query).getResult();
        assertThat(result.getTotalSize(), equalTo(1));
        assertThat(result.getModels().size(), equalTo(1));
    }

    @Test
    public void searchRequiredActionCodeResult() {
        // Provider
        DocumentQueryProvider queryProvider = documentProvider.queryProvider(ORGANIZATION1);

        // Required actions
        DocumentQueryModel query = DocumentQueryModel.builder().requiredAction(RequiredAction.SEND_TO_CUSTOMER).build();
        SearchResultsModel<DocumentModel> result = queryProvider.searchQuery(query).getResult();
        assertThat(result.getTotalSize(), equalTo(2));
        assertThat(result.getModels().size(), equalTo(2));

        query = DocumentQueryModel.builder().requiredAction(RequiredAction.SEND_TO_THIRD_PARTY).build();
        result = queryProvider.searchQuery(query).getResult();
        assertThat(result.getTotalSize(), equalTo(1));
        assertThat(result.getModels().size(), equalTo(1));
    }

    @Test
    public void searchTypeResult() {
        // Provider
        DocumentQueryProvider queryProvider = documentProvider.queryProvider(ORGANIZATION1);

        // Type
        DocumentQueryModel query = DocumentQueryModel.builder().type(DocumentType.INVOICE).build();
        SearchResultsModel<DocumentModel> result = queryProvider.searchQuery(query).getResult();
        assertThat(result.getTotalSize(), equalTo(3));
        assertThat(result.getModels().size(), equalTo(3));
    }

}
