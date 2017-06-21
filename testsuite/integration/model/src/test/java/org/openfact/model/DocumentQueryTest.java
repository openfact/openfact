package org.openfact.model;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openfact.models.DocumentModel.DocumentType;
import org.openfact.models.DocumentProvider;
import org.openfact.models.DocumentQuery;
import org.openfact.models.OrganizationModel;
import org.openfact.models.OrganizationProvider;

import javax.inject.Inject;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.openfact.models.DocumentQuery.CountQuery;

@RunWith(Arquillian.class)
@UsingDataSet("empty.xml")
public class DocumentQueryTest {

    public static final String ORGANIZATION_NAME1 = "SISTCOOP S.A.C.";
    public static final String ORGANIZATION_NAME2= "SOFTGREEN S.A.C.";

    private OrganizationModel ORGANIZATION1;
    private OrganizationModel ORGANIZATION2;

    @Inject
    private OrganizationProvider organizationProvider;

    @Inject
    private DocumentProvider documentProvider;

    @Deployment
    public static Archive deploy() {
        Archive[] libs = TestUtil.getLibraries();
        WebArchive archive = ShrinkWrap.create(WebArchive.class)
                .addAsResource("persistence.xml", "META-INF/persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
                .addClasses(TestUtil.getBasicClasses())
                .addClasses(TestUtil.getOrganizationClasses())
                .addPackage(TestUtil.getEntitiesPackage())
                .addClasses(TestUtil.getDocumentClasses());
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

        documentProvider.addDocument(ORGANIZATION1, DocumentType.CREDIT_NOTE, "C001-0001");
        documentProvider.addDocument(ORGANIZATION1, DocumentType.CREDIT_NOTE, "C001-0002");
        documentProvider.addDocument(ORGANIZATION1, DocumentType.CREDIT_NOTE, "C001-0003");

        documentProvider.addDocument(ORGANIZATION1, DocumentType.DEBIT_NOTE, "C001-0001");
        documentProvider.addDocument(ORGANIZATION1, DocumentType.DEBIT_NOTE, "C001-0002");
        documentProvider.addDocument(ORGANIZATION1, DocumentType.DEBIT_NOTE, "C001-0003");

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
    public void test_currency_success() {
        DocumentQuery query = documentProvider
                .createQuery(ORGANIZATION1)
                .currencyCode("USD");

//        EntityQuery entityQuery = query.entityQuery();
        CountQuery countQuery = query.countQuery();

        // Query results
//        ListEntityQuery listEntityQuery = entityQuery.resultList();
//        ScrollEntityQuery scrollEntityQuery = entityQuery.resultScroll();
//        SearchResultEntityQuery searchResultEntityQuery = entityQuery.searchResult();

        // Check total
        int totalCount = countQuery.getTotalCount();
        assertThat("Incorrect number of results", totalCount, equalTo(2));
    }

}
