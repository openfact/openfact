package org.openfact.model;

import org.hamcrest.core.Is;
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
import org.openfact.models.DocumentModel.RequiredAction;

import javax.inject.Inject;
import java.util.List;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsNull.notNullValue;

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

    /**
     * Lines
     */

    @Test
    public void test_add_line_success() {
        DocumentLineModel line1 = DOCUMENT.addLine();
        DocumentLineModel line2 = DOCUMENT.addLine();

        assertThat("Result should never be null", line1, is(notNullValue()));
        assertThat("Result should never be null", line2, is(notNullValue()));
        assertThat("Id has not been assigned", line1.getId(), is(notNullValue()));
        assertThat("Id has not been assigned", line2.getId(), is(notNullValue()));
    }

    @Test
    public void test_get_lines_success() {
        DOCUMENT.addLine();
        DOCUMENT.addLine();

        List<DocumentLineModel> lines = DOCUMENT.getLines();
        assertThat("Result should never be null", lines, is(notNullValue()));
        assertThat("Incorrect size", lines.size(), is(equalTo(2)));
    }

    @Test
    public void test_remove_line_success() {
        DocumentLineModel line1 = DOCUMENT.addLine();
        DocumentLineModel line2 = DOCUMENT.addLine();

        DOCUMENT.removeLine(line1);

        List<DocumentLineModel> lines = DOCUMENT.getLines();

        assertThat("Incorrect size", lines.size(), is(equalTo(1)));
        assertThat("Incorrect line has been selected", lines.get(0), is(equalTo(line2)));
    }

    @Test
    public void test_attribute_success() {
        DocumentLineModel line = DOCUMENT.addLine();

        line.setAttribute("string", "value");
        line.setAttribute("boolean", true);
        line.setAttribute("integer", 1);
        line.setAttribute("long", 1L);

        assertThat("Values are not the same", line.getAttribute("string"), Is.is(equalTo("value")));

        assertThat("Values are not the same", line.getAttribute("boolean"), Is.is(equalTo("true")));
        assertThat("Values are not the same", line.getAttribute("boolean", false), Is.is(equalTo(true)));
        assertThat("Values are not the same", line.getAttribute("boolean1", true), Is.is(equalTo(true)));

        assertThat("Values are not the same", line.getAttribute("integer"), Is.is(equalTo("1")));
        assertThat("Values are not the same", line.getAttribute("integer", 0), Is.is(equalTo(1)));
        assertThat("Values are not the same", line.getAttribute("integer1", 0), Is.is(equalTo(0)));

        assertThat("Values are not the same", line.getAttribute("long"), Is.is(equalTo("1")));
        assertThat("Values are not the same", line.getAttribute("long", 0L), Is.is(equalTo(1L)));
        assertThat("Values are not the same", line.getAttribute("long1", 0L), Is.is(equalTo(0L)));

        // remove attribute
        line.removeAttribute("string");
        assertThat("Values are not the same", line.getAttribute("string"), Is.is(nullValue()));
    }

    @Test
    public void test_remove_organization_cascade_success() {
        DocumentLineModel line = DOCUMENT.addLine();
        line.setAttribute("string", "value");

        boolean result = organizationProvider.removeOrganization(ORGANIZATION);
        assertThat("Result should be true", result, equalTo(true));
    }

    /*
     * Required actions
     */
    @Test
    public void test_required_action_success() {
        Set<String> requiredActions = DOCUMENT.getRequiredActions();
        assertThat("Value should never been null",requiredActions, is(notNullValue()));
        assertThat("Initial value should be empty",requiredActions.size(), equalTo(0));

        // Add required actions
        DOCUMENT.addRequiredAction(RequiredAction.SEND_TO_CUSTOMER);
        DOCUMENT.addRequiredAction(RequiredAction.SEND_TO_THIRD_PARTY);

        requiredActions = DOCUMENT.getRequiredActions();
        assertThat("Invalid number of required actions",requiredActions.size(), equalTo(2));

        // Remove required actions
        DOCUMENT.removeRequiredAction(RequiredAction.SEND_TO_CUSTOMER);

        requiredActions = DOCUMENT.getRequiredActions();
        assertThat("Invalid number of required actions",requiredActions.size(), equalTo(1));
    }

}
