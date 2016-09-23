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
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.models.ubl.provider.InvoiceProvider;

public class InvoiceProviderTest extends AbstractProviderTest {

    protected OrganizationModel organization;

    public void createOrganization() {
        OrganizationProvider provider = session.organizations();
        organization = provider.createOrganization("SISTCOOP");
        organization.setMaxInvoiceNumber(3);
        commit();
    }

    @Test
    public void createWithoutSeriesAndNumber() throws Exception {
        createOrganization();

        InvoiceProvider provider = session.invoices();
        InvoiceModel invoice = provider.addInvoice(organization);
        commit();

        assertThat(invoice, is(notNullValue()));
        assertThat(invoice.getId(), is(notNullValue()));
        assertThat(invoice.getID(), is("F001-0001"));
    }

    @Test
    public void createWithSeriesAndNumber() throws Exception {
        createOrganization();

        InvoiceProvider provider = session.invoices();
        InvoiceModel invoice = provider.addInvoice(organization, "F002-0003");
        commit();

        assertThat(invoice, is(notNullValue()));
        assertThat(invoice.getId(), is(notNullValue()));
        assertThat(invoice.getID(), is("F002-0003"));
    }

    @Test
    public void createWithTwoMethods() throws Exception {
        createOrganization();

        InvoiceProvider provider = session.invoices();
        InvoiceModel invoice23 = provider.addInvoice(organization, "F002-0003");
        InvoiceModel invoice31 = provider.addInvoice(organization);
        InvoiceModel invoice32 = provider.addInvoice(organization);
        InvoiceModel invoice33 = provider.addInvoice(organization);
        InvoiceModel invoice41 = provider.addInvoice(organization);
        InvoiceModel invoice52 = provider.addInvoice(organization, "F005-0002");
        InvoiceModel invoice53 = provider.addInvoice(organization);
        commit();

        assertThat(invoice23.getID(), is("F002-0003"));
        assertThat(invoice31.getID(), is("F003-0001"));
        assertThat(invoice32.getID(), is("F003-0002"));
        assertThat(invoice33.getID(), is("F003-0003"));
        assertThat(invoice41.getID(), is("F004-0001"));
        assertThat(invoice52.getID(), is("F005-0002"));
        assertThat(invoice53.getID(), is("F005-0003"));
    }

    @Test
    public void SeriesAndNumberCollision() {
        OrganizationModel sistcoop1 = session.organizations().createOrganization("SISTCOOP1");
        OrganizationModel sistcoop2 = session.organizations().createOrganization("SISTCOOP2");
        commit();

        session.invoices().addInvoice(sistcoop1, "F001-0001");
        session.invoices().addInvoice(sistcoop2, "F001-0001");
        commit();

        // Try to create invoice with duplicate series and number
        try {
            sistcoop1 = session.organizations().getOrganizationByName("SISTCOOP1");
            session.invoices().addInvoice(sistcoop1, "F001-0001");
            commit();
            Assert.fail("Expected exception");
        } catch (ModelDuplicateException e) {
        }
        commit(true);

        // Ty to rename invoice to duplicate series and number
        sistcoop1 = session.organizations().getOrganizationByName("SISTCOOP1");
        session.invoices().addInvoice(sistcoop1, "F001-0002");
        commit();
        try {
            sistcoop1 = session.organizations().getOrganizationByName("SISTCOOP1");
            session.invoices().getInvoiceByID(sistcoop1, "F001-002").setID("F001-0001");
            commit();
            Assert.fail("Expected exception");
        } catch (ModelDuplicateException e) {
        }

        resetSession();
    }

    @Test
    public void findById() throws Exception {
        createOrganization();
        InvoiceProvider provider = session.invoices();
        InvoiceModel invoice1 = provider.addInvoice(organization);
        commit();

        InvoiceModel invoice2 = session.invoices().getInvoiceById(organization, invoice1.getId());
        assertThat(invoice2, is(notNullValue()));
        assertThat(invoice2.getId(), is(notNullValue()));
        assertThat(invoice2.getId(), is(equalTo(invoice1.getId())));
        assertThat(invoice2.getID(), is(equalTo(invoice1.getID())));
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
        assertThat(invoice2.getID(), is(equalTo(invoice1.getID())));
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

        InvoiceProvider provider = session.invoices();
        provider.addInvoice(sistcoop1);
        provider.addInvoice(sistcoop1);
        provider.addInvoice(sistcoop1);
        provider.addInvoice(sistcoop2);
        provider.addInvoice(sistcoop2);
        provider.addInvoice(sistcoop2);
        commit();

        List<InvoiceModel> invoices1 = session.invoices().getInvoices(sistcoop1);
        List<InvoiceModel> invoices2 = session.invoices().getInvoices(sistcoop2);

        List<InvoiceModel> invoices3 = session.invoices().getInvoices(sistcoop1, 0, 1);

        assertThat(invoices1.size(), is(3));
        assertThat(invoices2.size(), is(3));
        assertThat(invoices3.size(), is(1));
    }      

}
