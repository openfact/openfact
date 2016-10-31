package org.openfact.testsuite.providers;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openfact.models.ModelDuplicateException;
import org.openfact.models.OrganizationModel;
import org.openfact.models.OrganizationProvider;
import org.openfact.models.ubl.CreditNoteModel;
import org.openfact.models.ubl.provider.CreditNoteProvider;

public class CreditNoteProviderTest extends AbstractProviderTest {

    protected OrganizationModel organization;

    public void createOrganization() {
        OrganizationProvider provider = session.organizations();
        organization = provider.createOrganization("SISTCOOP");
        commit();
    }

    @Test
    public void createWithSeriesAndNumber() throws Exception {
        createOrganization();

        CreditNoteModel creditNote = session.creditNotes().addCreditNote(organization, "C002-0003");
        commit();

        assertThat(creditNote, is(notNullValue()));
        assertThat(creditNote.getId(), is(notNullValue()));
        assertThat(creditNote.getID(), is("C002-0003"));
    }

    @Test
    public void SeriesAndNumberCollision() {
        OrganizationModel sistcoop1 = session.organizations().createOrganization("SISTCOOP1");
        OrganizationModel sistcoop2 = session.organizations().createOrganization("SISTCOOP2");
        commit();

        session.creditNotes().addCreditNote(sistcoop1, "C01-001");
        session.creditNotes().addCreditNote(sistcoop2, "C01-001");
        commit();

        // Try to create creditNote with duplicate series and number
        try {
            sistcoop1 = session.organizations().getOrganizationByName("SISTCOOP1");
            session.creditNotes().addCreditNote(sistcoop1, "C01-001");
            commit();
            Assert.fail("Expected exception");
        } catch (ModelDuplicateException e) {
        }
        commit(true);

        // Ty to rename creditNote to duplicate series and number
        sistcoop1 = session.organizations().getOrganizationByName("SISTCOOP1");
        session.creditNotes().addCreditNote(sistcoop1, "C01-002");
        commit();
        try {
            sistcoop1 = session.organizations().getOrganizationByName("SISTCOOP1");
            session.creditNotes().getCreditNoteByID(sistcoop1, "C01-002").setID("C01-001");
            commit();
            Assert.fail("Expected exception");
        } catch (ModelDuplicateException e) {
        }

        resetSession();
    }

    @Test
    public void findById() throws Exception {
        createOrganization();
        CreditNoteModel creditNote1 = session.creditNotes().addCreditNote(organization, "C01-001");
        commit();

        CreditNoteModel creditNote2 = session.creditNotes().getCreditNoteById(organization, creditNote1.getId());
        assertThat(creditNote2, is(notNullValue()));
        assertThat(creditNote2.getId(), is(notNullValue()));
        assertThat(creditNote2.getId(), is(equalTo(creditNote1.getId())));
        assertThat(creditNote2.getID(), is(equalTo(creditNote1.getID())));
    }

    @Test
    public void findBySeriesAndNumber() throws Exception {
        createOrganization();
        CreditNoteProvider provider = session.creditNotes();
        CreditNoteModel creditNote1 = provider.addCreditNote(organization, "C001-0001");
        commit();

        CreditNoteModel creditNote2 = session.creditNotes().getCreditNoteByID(organization, "C001-0001");
        assertThat(creditNote2, is(notNullValue()));
        assertThat(creditNote2.getId(), is(notNullValue()));
        assertThat(creditNote2.getId(), is(equalTo(creditNote1.getId())));
        assertThat(creditNote2.getID(), is(equalTo(creditNote1.getID())));
    }

    @Test
    public void remove() throws Exception {
        createOrganization();

        CreditNoteProvider provider = session.creditNotes();
        provider.addCreditNote(organization, "C001-0001");
        commit();

        CreditNoteModel creditNote = session.creditNotes().getCreditNoteByID(organization, "C001-0001");
        assertThat(session.creditNotes().removeCreditNote(organization, creditNote), is(true));
        assertThat(session.creditNotes().removeCreditNote(organization, creditNote), is(false));
        assertThat(session.creditNotes().getCreditNoteByID(organization, "C001-0001"), is(nullValue()));
    }  

    /**
     * Get creditNotes
     */
    @Test
    public void getCreditNotesByOrganization() throws Exception {
        OrganizationModel sistcoop1 = session.organizations().createOrganization("SISTCOOP1");
        OrganizationModel sistcoop2 = session.organizations().createOrganization("SISTCOOP2");
        commit();

        session.creditNotes().addCreditNote(sistcoop1, "C01-001");
        session.creditNotes().addCreditNote(sistcoop1, "C01-002");
        session.creditNotes().addCreditNote(sistcoop1, "C01-003");
        session.creditNotes().addCreditNote(sistcoop2, "C01-004");
        session.creditNotes().addCreditNote(sistcoop2, "C01-005");
        session.creditNotes().addCreditNote(sistcoop2, "C01-006");
        commit();

        List<CreditNoteModel> creditNotes1 = session.creditNotes().getCreditNotes(sistcoop1);
        List<CreditNoteModel> creditNotes2 = session.creditNotes().getCreditNotes(sistcoop2);

        List<CreditNoteModel> creditNotes3 = session.creditNotes().getCreditNotes(sistcoop1, 0, 1);

        assertThat(creditNotes1.size(), is(3));
        assertThat(creditNotes2.size(), is(3));
        assertThat(creditNotes3.size(), is(1));
    }      

}
