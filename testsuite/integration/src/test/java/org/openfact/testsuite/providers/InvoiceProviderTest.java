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
        assertThat(invoice.getSeries(), is(1));
        assertThat(invoice.getNumber(), is(1));
    }

    @Test
    public void createWithSeriesAndNumber() throws Exception {
        createOrganization();

        InvoiceProvider provider = session.invoices();
        InvoiceModel invoice = provider.addInvoice(organization, 2, 3);
        commit();

        assertThat(invoice, is(notNullValue()));
        assertThat(invoice.getId(), is(notNullValue()));
        assertThat(invoice.getSeries(), is(2));
        assertThat(invoice.getNumber(), is(3));
    }

    @Test
    public void createWithTwoMethods() throws Exception {
        createOrganization();

        InvoiceProvider provider = session.invoices();
        InvoiceModel invoice23 = provider.addInvoice(organization, 2, 3);
        InvoiceModel invoice31 = provider.addInvoice(organization);
        InvoiceModel invoice32 = provider.addInvoice(organization);
        InvoiceModel invoice33 = provider.addInvoice(organization);
        InvoiceModel invoice41 = provider.addInvoice(organization);
        InvoiceModel invoice52 = provider.addInvoice(organization, 5, 2);
        InvoiceModel invoice53 = provider.addInvoice(organization);
        commit();

        assertThat(invoice23.getSeries(), is(2));
        assertThat(invoice23.getNumber(), is(3));

        assertThat(invoice31.getSeries(), is(3));
        assertThat(invoice31.getNumber(), is(1));

        assertThat(invoice32.getSeries(), is(3));
        assertThat(invoice32.getNumber(), is(2));

        assertThat(invoice33.getSeries(), is(3));
        assertThat(invoice33.getNumber(), is(3));

        assertThat(invoice41.getSeries(), is(4));
        assertThat(invoice41.getNumber(), is(1));

        assertThat(invoice52.getSeries(), is(5));
        assertThat(invoice52.getNumber(), is(2));

        assertThat(invoice53.getSeries(), is(5));
        assertThat(invoice53.getNumber(), is(3));
    }

    @Test
    public void SeriesAndNumberCollision() {
        OrganizationModel sistcoop1 = session.organizations().createOrganization("SISTCOOP1");
        OrganizationModel sistcoop2 = session.organizations().createOrganization("SISTCOOP2");
        commit();

        session.invoices().addInvoice(sistcoop1, 1, 1);
        session.invoices().addInvoice(sistcoop2, 1, 1);
        commit();

        // Try to create invoice with duplicate series and number
        try {
            sistcoop1 = session.organizations().getOrganizationByName("SISTCOOP1");
            session.invoices().addInvoice(sistcoop1, 1, 1);
            commit();
            Assert.fail("Expected exception");
        } catch (ModelDuplicateException e) {
        }
        commit(true);

        // Ty to rename invoice to duplicate series and number
        sistcoop1 = session.organizations().getOrganizationByName("SISTCOOP1");
        session.invoices().addInvoice(sistcoop1, 1, 2);
        commit();
        try {
            sistcoop1 = session.organizations().getOrganizationByName("SISTCOOP1");
            session.invoices().getInvoiceBySeriesAndNumber(1, 2, sistcoop1).setNumber(1);
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

        InvoiceModel invoice2 = session.invoices().getInvoiceById(invoice1.getId(), organization);
        assertThat(invoice2, is(notNullValue()));
        assertThat(invoice2.getId(), is(notNullValue()));
        assertThat(invoice2.getId(), is(equalTo(invoice1.getId())));
        assertThat(invoice2.getSeries(), is(equalTo(invoice1.getSeries())));
        assertThat(invoice2.getNumber(), is(equalTo(invoice1.getNumber())));
    }

    @Test
    public void findBySeriesAndNumber() throws Exception {
        createOrganization();
        InvoiceProvider provider = session.invoices();
        InvoiceModel invoice1 = provider.addInvoice(organization, 1, 1);
        commit();

        InvoiceModel invoice2 = session.invoices().getInvoiceBySeriesAndNumber(1, 1, organization);
        assertThat(invoice2, is(notNullValue()));
        assertThat(invoice2.getId(), is(notNullValue()));
        assertThat(invoice2.getId(), is(equalTo(invoice1.getId())));
        assertThat(invoice2.getSeries(), is(equalTo(invoice1.getSeries())));
        assertThat(invoice2.getNumber(), is(equalTo(invoice1.getNumber())));
    }

    @Test
    public void remove() throws Exception {
        createOrganization();

        InvoiceProvider provider = session.invoices();
        provider.addInvoice(organization, 1, 1);
        commit();

        InvoiceModel invoice = session.invoices().getInvoiceBySeriesAndNumber(1, 1, organization);
        assertThat(session.invoices().removeInvoice(organization, invoice), is(true));
        assertThat(session.invoices().removeInvoice(organization, invoice), is(false));
        assertThat(session.invoices().getInvoiceBySeriesAndNumber(1, 1, organization), is(nullValue()));
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
    
    /**
     * Required actions
     */
    @Test
    public void getByRequiredActions() throws Exception {
        OrganizationModel sistcoop1 = session.organizations().createOrganization("SISTCOOP1");
        OrganizationModel sistcoop2 = session.organizations().createOrganization("SISTCOOP2");
        commit();

        InvoiceProvider provider = session.invoices();
        InvoiceModel invoice1 = provider.addInvoice(sistcoop1);
        InvoiceModel invoice2 = provider.addInvoice(sistcoop1);
        InvoiceModel invoice3 = provider.addInvoice(sistcoop2);
        InvoiceModel invoice4 = provider.addInvoice(sistcoop2);

        invoice1.addRequiredAction("Action1");
        invoice2.addRequiredAction("Action1");
        invoice1.addRequiredAction(InvoiceModel.RequiredAction.SEND_EMAIL_INMEDIATELLY);
        invoice2.addRequiredAction(InvoiceModel.RequiredAction.SEND_EMAIL_INMEDIATELLY);

        invoice3.addRequiredAction("Action1");
        invoice4.addRequiredAction("Action1");
        invoice3.addRequiredAction(InvoiceModel.RequiredAction.SEND_EMAIL_INMEDIATELLY);
        invoice4.addRequiredAction(InvoiceModel.RequiredAction.SEND_EMAIL_INMEDIATELLY);

        commit();

        List<InvoiceModel> invoices1 = session.invoices().searchForInvoiceByRequiredAction("Action1");
        List<InvoiceModel> invoices2 = session.invoices().searchForInvoiceByRequiredAction(InvoiceModel.RequiredAction.SEND_EMAIL_INMEDIATELLY);

        List<InvoiceModel> invoices3 = session.invoices().searchForInvoiceByRequiredAction("Action1", sistcoop1);
        List<InvoiceModel> invoices4 = session.invoices().searchForInvoiceByRequiredAction(InvoiceModel.RequiredAction.SEND_EMAIL_INMEDIATELLY, sistcoop2);

        assertThat(invoices1.size(), is(4));
        assertThat(invoices2.size(), is(4));
        assertThat(invoices3.size(), is(2));
        assertThat(invoices4.size(), is(2));
    }

}
