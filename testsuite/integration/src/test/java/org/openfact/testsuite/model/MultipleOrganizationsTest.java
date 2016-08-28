package org.openfact.testsuite.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openfact.models.InvoiceModel;
import org.openfact.models.OrganizationModel;

public class MultipleOrganizationsTest extends AbstractModelTest {

	private OrganizationModel organization1;
    private OrganizationModel organization2;

    @Before
    @Override
    public void before() throws Exception {
        super.before();
        organization1 = organizationManager.createOrganization("id1", "realm1");
        organization2 = organizationManager.createOrganization("id2", "realm2");

        createObjects(organization1);
        createObjects(organization2);
    }

    @Test
    public void testInvoices() {
        InvoiceModel o1invoice1 = session.invoices().getInvoiceBySeriesAndNumber(1, 1, organization1);
        InvoiceModel o2invoice1 = session.invoices().getInvoiceBySeriesAndNumber(1, 1, organization2);
        Assert.assertEquals(o1invoice1.getInvoiceId().getSeries(), o2invoice1.getInvoiceId().getSeries());
        Assert.assertEquals(o1invoice1.getInvoiceId().getNumber(), o2invoice1.getInvoiceId().getNumber());
        Assert.assertNotEquals(o1invoice1.getId(), o2invoice1.getId());

        // Test searching
        Assert.assertEquals(2, session.invoices().searchForInvoice("1", organization1).size());

        commit();
        organization1 = model.getOrganization("id1");
        organization2 = model.getOrganization("id2");

        session.invoices().removeInvoice(organization1, o1invoice1);
        InvoiceModel invoice2 = session.invoices().getInvoiceBySeriesAndNumber(1, 1, organization1);
        session.invoices().removeInvoice(organization1, invoice2);
        Assert.assertEquals(0, session.invoices().searchForInvoice("1", organization1).size());
        Assert.assertEquals(2, session.invoices().searchForInvoice("1", organization2).size());
    }

    @Test
    public void testGetById() {
        Assert.assertEquals(organization1, model.getOrganization("id1"));
        Assert.assertEquals(organization1, model.getOrganizationByName("realm1"));
        Assert.assertEquals(organization2, model.getOrganization("id2"));
        Assert.assertEquals(organization2, model.getOrganizationByName("realm2"));        
    }

    private void createObjects(OrganizationModel organization) {        
        organizationManager.getSession().invoices().addInvoice(organization, 1, 1);
        organizationManager.getSession().invoices().addInvoice(organization, 1, 2);
    }
}
