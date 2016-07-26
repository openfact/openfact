package org.openfact.services.resources.admin;

import javax.ws.rs.core.Response;

import org.openfact.models.InvoiceModel;
import org.openfact.models.OrganizationModel;
import org.openfact.representations.idm.InvoiceRepresentation;

public class InvoiceAdminResourceImpl implements InvoiceAdminResource {

    public InvoiceAdminResourceImpl(OrganizationAuth auth, OrganizationModel organization,
            InvoiceModel invoice) {
        // TODO Auto-generated constructor stub
    }

    @Override
    public InvoiceRepresentation getInvoice() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Response updateInvoice(InvoiceRepresentation rep) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteInvoice() {
        // TODO Auto-generated method stub

    }

}
