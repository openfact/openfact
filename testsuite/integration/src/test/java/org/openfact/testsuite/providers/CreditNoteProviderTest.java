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

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openfact.models.CreditNoteModel;
import org.openfact.models.CreditNoteProvider;
import org.openfact.models.ModelDuplicateException;
import org.openfact.models.OrganizationModel;
import org.openfact.models.OrganizationProvider;

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
        assertThat(creditNote.getDocumentId(), is("C002-0003"));
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
        assertThat(creditNote2.getDocumentId(), is(equalTo(creditNote1.getDocumentId())));
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
        assertThat(creditNote2.getDocumentId(), is(equalTo(creditNote1.getDocumentId())));
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
