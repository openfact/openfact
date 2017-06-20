package org.openfact.model;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openfact.models.*;
import org.openfact.models.DocumentModel.DocumentType;

import javax.inject.Inject;

@RunWith(Arquillian.class)
@UsingDataSet("empty.xml")
public class DocumentModelTest {

    public static final String ORGANIZATION_NAME = "SISTCOOP S.A.C.";
    public static final String DOCUMENT_ID = "F001-0001";

    public OrganizationModel ORGANIZATION;
    public DocumentModel DOCUMENT;

    @Inject
    public OrganizationProvider organizationProvider;

    @Inject
    public DocumentProvider documentProvider;

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
        ORGANIZATION = organizationProvider.createOrganization(ORGANIZATION_NAME);
        DOCUMENT = documentProvider.addDocument(ORGANIZATION, DocumentType.INVOICE, DOCUMENT_ID);
    }

    @Ignore
    @Test
    public void disable_document_success() {
    }

}
