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
import org.openfact.models.CreditNoteModel;
import org.openfact.models.OrganizationModel;
import org.openfact.models.OrganizationProvider;
import org.openfact.services.managers.CreditNoteManager;
import org.openfact.services.managers.OrganizationManager;
import org.openfact.testsuite.providers.AbstractProviderTest;

import com.helger.ubl21.UBL21Reader;

import oasis.names.specification.ubl.schema.xsd.creditnote_21.CreditNoteType;


public class CreditNoteManagerTest /*extends AbstractProviderTest*/ {

    protected OrganizationModel organization;

    /*public void createOrganization() {
        OrganizationManager a = new OrganizationManager(session);
        OrganizationProvider provider = session.organizations();
        organization = provider.createOrganization("SISTCOOP");
    }

    @Test
    public void createCreditNote() throws Exception {
        createOrganization();       

        // Read file
        InputStream is = getClass().getResourceAsStream("/xml/credit-note.xml");
        CreditNoteType creditNoteType = UBL21Reader.creditNote().read(is);
        
        // Attributes
        Map<String, String> attributes = new HashMap<>();
        attributes.put("location", "peru");
        attributes.put("language", "spanish");

        CreditNoteManager manager = new CreditNoteManager(session);
        CreditNoteModel creditNote = manager.addCreditNote(organization, creditNoteType, attributes);
        commit();

        assertThat(creditNote, is(notNullValue()));
        assertThat(creditNote.getId(), is(notNullValue()));
        assertThat(creditNote.getDocumentId(), is(notNullValue()));
        assertThat(UBL21Reader.creditNote().read(creditNote.getXmlDocument()), is(notNullValue()));
    }  */  

}
