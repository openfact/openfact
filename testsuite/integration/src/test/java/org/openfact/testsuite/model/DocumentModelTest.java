package org.openfact.testsuite.model;

import org.hamcrest.core.Is;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openfact.models.*;
import org.openfact.models.DocumentModel.DocumentType;
import org.openfact.models.DocumentModel.RequiredAction;

import javax.inject.Inject;
import java.util.List;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsNull.notNullValue;

public class DocumentModelTest extends AbstractModelTest {

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
        WebArchive archive = buildArchive()
                .addClasses(TestUtil.getOrganizationClasses())
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
    public void addLine() {
        DocumentLineModel line1 = DOCUMENT.addLine();
        DocumentLineModel line2 = DOCUMENT.addLine();

        assertThat(line1, is(notNullValue()));
        assertThat(line2, is(notNullValue()));
        assertThat(line1.getId(), is(notNullValue()));
        assertThat(line2.getId(), is(notNullValue()));
    }

    @Test
    public void getLines() {
        DOCUMENT.addLine();
        DOCUMENT.addLine();

        List<DocumentLineModel> lines = DOCUMENT.getLines();
        assertThat(lines, is(notNullValue()));
        assertThat(lines.size(), is(equalTo(2)));
    }

    @Test
    public void removeLine() {
        DocumentLineModel line1 = DOCUMENT.addLine();
        DocumentLineModel line2 = DOCUMENT.addLine();

        DOCUMENT.removeLine(line1);

        List<DocumentLineModel> lines = DOCUMENT.getLines();

        assertThat(lines.size(), is(equalTo(1)));
        assertThat(lines.get(0), is(equalTo(line2)));
    }

    @Test
    public void lineAttributes() {
        DocumentLineModel line = DOCUMENT.addLine();

        line.setAttribute("string", "value");
        line.setAttribute("boolean", true);
        line.setAttribute("integer", 1);
        line.setAttribute("long", 1L);

        assertThat(line.getAttribute("string"), Is.is(equalTo("value")));

        assertThat(line.getAttribute("boolean"), Is.is(equalTo("true")));
        assertThat(line.getAttribute("boolean", false), Is.is(equalTo(true)));
        assertThat(line.getAttribute("boolean1", true), Is.is(equalTo(true)));

        assertThat(line.getAttribute("integer"), Is.is(equalTo("1")));
        assertThat(line.getAttribute("integer", 0), Is.is(equalTo(1)));
        assertThat(line.getAttribute("integer1", 0), Is.is(equalTo(0)));

        assertThat(line.getAttribute("long"), Is.is(equalTo("1")));
        assertThat(line.getAttribute("long", 0L), Is.is(equalTo(1L)));
        assertThat(line.getAttribute("long1", 0L), Is.is(equalTo(0L)));

        // remove attribute
        line.removeAttribute("string");
        assertThat(line.getAttribute("string"), Is.is(nullValue()));
    }

    @Test
    public void removeOrganization() {
        DocumentLineModel line = DOCUMENT.addLine();
        line.setAttribute("string", "value");

        boolean result = organizationProvider.removeOrganization(ORGANIZATION);
        assertThat(result, equalTo(true));
    }

    /*
     * Required actions
     */
    @Test
    public void requiredActions() {
        Set<String> requiredActions = DOCUMENT.getRequiredActions();
        assertThat(requiredActions, is(notNullValue()));
        assertThat(requiredActions.size(), equalTo(0));

        // Add required actions
        DOCUMENT.addRequiredAction(RequiredAction.SEND_TO_CUSTOMER);
        DOCUMENT.addRequiredAction(RequiredAction.SEND_TO_THIRD_PARTY);

        requiredActions = DOCUMENT.getRequiredActions();
        assertThat(requiredActions.size(), equalTo(2));

        // Remove required actions
        DOCUMENT.removeRequiredAction(RequiredAction.SEND_TO_CUSTOMER);

        requiredActions = DOCUMENT.getRequiredActions();
        assertThat(requiredActions.size(), equalTo(1));
    }

}
