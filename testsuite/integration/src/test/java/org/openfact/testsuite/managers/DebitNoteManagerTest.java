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
package org.openfact.testsuite.managers;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.openfact.models.DebitNoteModel;
import org.openfact.models.OrganizationModel;
import org.openfact.models.OrganizationProvider;
import org.openfact.services.managers.DebitNoteManager;
import org.openfact.testsuite.providers.AbstractProviderTest;

import com.helger.ubl21.UBL21Reader;

import oasis.names.specification.ubl.schema.xsd.debitnote_21.DebitNoteType;

public class DebitNoteManagerTest /*extends AbstractProviderTest*/ {

    protected OrganizationModel organization;

    /*public void createOrganization() {
        OrganizationProvider provider = session.organizations();
        organization = provider.createOrganization("SISTCOOP");
    }

    @Test
    public void createDebitNote() throws Exception {
        createOrganization();

        // Read file
        InputStream is = getClass().getResourceAsStream("/xml/debit-note.xml");
        DebitNoteType debitNoteType = UBL21Reader.debitNote().read(is);

        // Attributes
        Map<String, String> attributes = new HashMap<>();
        attributes.put("location", "peru");
        attributes.put("language", "spanish");

        DebitNoteManager manager = new DebitNoteManager(session);
        DebitNoteModel debitNote = manager.addDebitNote(organization, debitNoteType, attributes);
        commit();

        assertThat(debitNote, is(notNullValue()));
        assertThat(debitNote.getId(), is(notNullValue()));
        assertThat(debitNote.getDocumentId(), is(notNullValue()));
        assertThat(UBL21Reader.debitNote().read(debitNote.getXmlDocument()), is(notNullValue()));
    }*/

}
