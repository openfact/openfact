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
import org.openfact.models.DebitNoteModel;
import org.openfact.models.DebitNoteProvider;
import org.openfact.models.ModelDuplicateException;
import org.openfact.models.OrganizationModel;
import org.openfact.models.OrganizationProvider;

public class DebitNoteProviderTest extends AbstractProviderTest {

    protected OrganizationModel organization;

    public void createOrganization() {
        OrganizationProvider provider = session.organizations();
        organization = provider.createOrganization("SISTCOOP");
        commit();
    }

    @Test
    public void createWithSeriesAndNumber() throws Exception {
        createOrganization();

        DebitNoteModel debitNote = session.debitNotes().addDebitNote(organization, "D002-0003");
        commit();

        assertThat(debitNote, is(notNullValue()));
        assertThat(debitNote.getId(), is(notNullValue()));
        assertThat(debitNote.getDocumentId(), is("D002-0003"));
    }

    @Test
    public void SeriesAndNumberCollision() {
        OrganizationModel sistcoop1 = session.organizations().createOrganization("SISTCOOP1");
        OrganizationModel sistcoop2 = session.organizations().createOrganization("SISTCOOP2");
        commit();

        session.debitNotes().addDebitNote(sistcoop1, "D01-001");
        session.debitNotes().addDebitNote(sistcoop2, "D01-001");
        commit();

        // Try to create debitNote with duplicate series and number
        try {
            sistcoop1 = session.organizations().getOrganizationByName("SISTCOOP1");
            session.debitNotes().addDebitNote(sistcoop1, "D01-001");
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
        DebitNoteModel debitNote1 = session.debitNotes().addDebitNote(organization, "D01-001");
        commit();

        DebitNoteModel debitNote2 = session.debitNotes().getDebitNoteById(organization, debitNote1.getId());
        assertThat(debitNote2, is(notNullValue()));
        assertThat(debitNote2.getId(), is(notNullValue()));
        assertThat(debitNote2.getId(), is(equalTo(debitNote1.getId())));
        assertThat(debitNote2.getDocumentId(), is(equalTo(debitNote1.getDocumentId())));
    }

    @Test
    public void findBySeriesAndNumber() throws Exception {
        createOrganization();
        DebitNoteProvider provider = session.debitNotes();
        DebitNoteModel debitNote1 = provider.addDebitNote(organization, "D001-0001");
        commit();

        DebitNoteModel debitNote2 = session.debitNotes().getDebitNoteByID(organization, "D001-0001");
        assertThat(debitNote2, is(notNullValue()));
        assertThat(debitNote2.getId(), is(notNullValue()));
        assertThat(debitNote2.getId(), is(equalTo(debitNote1.getId())));
        assertThat(debitNote2.getDocumentId(), is(equalTo(debitNote1.getDocumentId())));
    }

    @Test
    public void remove() throws Exception {
        createOrganization();

        DebitNoteProvider provider = session.debitNotes();
        provider.addDebitNote(organization, "D001-0001");
        commit();

        DebitNoteModel debitNote = session.debitNotes().getDebitNoteByID(organization, "D001-0001");
        assertThat(session.debitNotes().removeDebitNote(organization, debitNote), is(true));
        assertThat(session.debitNotes().removeDebitNote(organization, debitNote), is(false));
        assertThat(session.debitNotes().getDebitNoteByID(organization, "D001-0001"), is(nullValue()));
    }  

    /**
     * Get debitNotes
     */
    @Test
    public void getDebitNotesByOrganization() throws Exception {
        OrganizationModel sistcoop1 = session.organizations().createOrganization("SISTCOOP1");
        OrganizationModel sistcoop2 = session.organizations().createOrganization("SISTCOOP2");
        commit();

        session.debitNotes().addDebitNote(sistcoop1, "D01-001");
        session.debitNotes().addDebitNote(sistcoop1, "D01-002");
        session.debitNotes().addDebitNote(sistcoop1, "D01-003");
        session.debitNotes().addDebitNote(sistcoop2, "D01-004");
        session.debitNotes().addDebitNote(sistcoop2, "D01-005");
        session.debitNotes().addDebitNote(sistcoop2, "D01-006");
        commit();

        List<DebitNoteModel> debitNotes1 = session.debitNotes().getDebitNotes(sistcoop1);
        List<DebitNoteModel> debitNotes2 = session.debitNotes().getDebitNotes(sistcoop2);

        List<DebitNoteModel> debitNotes3 = session.debitNotes().getDebitNotes(sistcoop1, 0, 1);

        assertThat(debitNotes1.size(), is(3));
        assertThat(debitNotes2.size(), is(3));
        assertThat(debitNotes3.size(), is(1));
    }      

}
