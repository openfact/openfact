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
import org.openfact.models.*;

import javax.inject.Inject;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(Arquillian.class)
@UsingDataSet("empty.xml")
public class DocumentQueryTest {

    public static final String ORGANIZATION_NAME1 = "SISTCOOP S.A.C.";
    public static final String ORGANIZATION_NAME2 = "SOFTGREEN S.A.C.";

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
    public void test_count_success() {
        // Provider
        DocumentQueryProvider queryProvider = documentProvider.queryProvider(ORGANIZATION1);

        // All
        DocumentQuery query = DocumentQuery.builder().build();
        Integer result = queryProvider.countQuery(query).getResult();
        assertThat("Incorrect result", result, equalTo(9));

        // Currency code
        query = DocumentQuery.builder().currencyCode("USD").build();
        result = queryProvider.countQuery(query).getResult();
        assertThat("Incorrect result", result, equalTo(2));

        query = DocumentQuery.builder().currencyCode("USD", "PEN").build();
        result = queryProvider.countQuery(query).getResult();
        assertThat("Incorrect result", result, equalTo(3));

        // enabled
//        query = DocumentQuery.builder().enabled(true).build();
//        result = queryProvider.countQuery(query).getResult();
//        assertThat("Incorrect result", result, equalTo(3));
    }

}
