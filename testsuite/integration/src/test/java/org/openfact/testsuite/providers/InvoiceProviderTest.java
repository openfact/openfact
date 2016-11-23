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
import org.openfact.models.InvoiceModel;
import org.openfact.models.InvoiceProvider;
import org.openfact.models.ModelDuplicateException;
import org.openfact.models.OrganizationModel;
import org.openfact.models.OrganizationProvider;

public class InvoiceProviderTest extends AbstractProviderTest {

    protected OrganizationModel organization;

    public void createOrganization() {
        OrganizationProvider provider = session.organizations();
        organization = provider.createOrganization("SISTCOOP");
        commit();
    }

    @Test
    public void createWithSeriesAndNumber() throws Exception {
        createOrganization();        
        
        InvoiceModel invoice = session.invoices().addInvoice(organization, "F002-0003");
        commit();

        assertThat(invoice, is(notNullValue()));
        assertThat(invoice.getId(), is(notNullValue()));
        assertThat(invoice.getDocumentId(), is("F002-0003"));
    }    

    @Test
    public void SeriesAndNumberCollision() {
        OrganizationModel sistcoop1 = session.organizations().createOrganization("SISTCOOP1");
        OrganizationModel sistcoop2 = session.organizations().createOrganization("SISTCOOP2");
        commit();

        session.invoices().addInvoice(sistcoop1, "F01-001");
        session.invoices().addInvoice(sistcoop2, "F01-001");
        commit();

        // Try to create invoice with duplicate series and number
        try {
            sistcoop1 = session.organizations().getOrganizationByName("SISTCOOP1");
            session.invoices().addInvoice(sistcoop1,"F01-001");
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
        InvoiceModel invoice1 = session.invoices().addInvoice(organization, "F01-001");
        commit();

        InvoiceModel invoice2 = session.invoices().getInvoiceById(organization, invoice1.getId());
        assertThat(invoice2, is(notNullValue()));
        assertThat(invoice2.getId(), is(notNullValue()));
        assertThat(invoice2.getId(), is(equalTo(invoice1.getId())));
        assertThat(invoice2.getDocumentId(), is(equalTo(invoice1.getDocumentId())));
    }

    @Test
    public void findBySeriesAndNumber() throws Exception {
        createOrganization();
        InvoiceProvider provider = session.invoices();
        InvoiceModel invoice1 = provider.addInvoice(organization, "F001-0001");
        commit();

        InvoiceModel invoice2 = session.invoices().getInvoiceByID(organization, "F001-0001");
        assertThat(invoice2, is(notNullValue()));
        assertThat(invoice2.getId(), is(notNullValue()));
        assertThat(invoice2.getId(), is(equalTo(invoice1.getId())));
        assertThat(invoice2.getDocumentId(), is(equalTo(invoice1.getDocumentId())));
    }

    @Test
    public void remove() throws Exception {
        createOrganization();

        InvoiceProvider provider = session.invoices();
        provider.addInvoice(organization, "F001-0001");
        commit();

        InvoiceModel invoice = session.invoices().getInvoiceByID(organization, "F001-0001");
        assertThat(session.invoices().removeInvoice(organization, invoice), is(true));
        assertThat(session.invoices().removeInvoice(organization, invoice), is(false));
        assertThat(session.invoices().getInvoiceByID(organization, "F001-0001"), is(nullValue()));
    }

    /**
     * Get invoices
     */
    @Test
    public void getInvoicesByOrganization() throws Exception {
        OrganizationModel sistcoop1 = session.organizations().createOrganization("SISTCOOP1");
        OrganizationModel sistcoop2 = session.organizations().createOrganization("SISTCOOP2");
        commit();

        session.invoices().addInvoice(sistcoop1, "F01-001");
        session.invoices().addInvoice(sistcoop1, "F01-002");
        session.invoices().addInvoice(sistcoop1, "F01-003");
        session.invoices().addInvoice(sistcoop2, "F01-004");
        session.invoices().addInvoice(sistcoop2, "F01-005");
        session.invoices().addInvoice(sistcoop2, "F01-006");
        commit();

        List<InvoiceModel> invoices1 = session.invoices().getInvoices(sistcoop1);
        List<InvoiceModel> invoices2 = session.invoices().getInvoices(sistcoop2);

        List<InvoiceModel> invoices3 = session.invoices().getInvoices(sistcoop1, 0, 1);

        assertThat(invoices1.size(), is(3));
        assertThat(invoices2.size(), is(3));
        assertThat(invoices3.size(), is(1));
    }

}
