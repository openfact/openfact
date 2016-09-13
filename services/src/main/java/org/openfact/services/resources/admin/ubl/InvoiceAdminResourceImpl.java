package org.openfact.services.resources.admin.ubl;

import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import org.jboss.logging.Logger;
import org.openfact.common.ClientConnection;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.models.utils.ModelToRepresentation;
import org.openfact.representations.idm.ubl.InvoiceLineRepresentation;
import org.openfact.representations.idm.ubl.InvoiceRepresentation;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.services.resources.admin.OrganizationAuth;

public class InvoiceAdminResourceImpl implements InvoiceAdminResource {

    protected static final Logger logger = Logger.getLogger(InvoiceAdminResourceImpl.class);

    protected OrganizationModel organization;
    protected OrganizationAuth auth;
    protected InvoiceModel invoice;

    @Context
    protected OpenfactSession session;

    @Context
    protected UriInfo uriInfo;

    @Context
    protected ClientConnection connection;

    public InvoiceAdminResourceImpl(OrganizationAuth auth, OrganizationModel organization, InvoiceModel invoice) {
        this.auth = auth;
        this.organization = organization;
        this.invoice = invoice;

        auth.init(OrganizationAuth.Resource.INVOICE);
        auth.requireAny();
    }

    @Override
    public InvoiceRepresentation getInvoice() {
        auth.requireView();

        if (invoice == null) {
            throw new NotFoundException("Invoice not found");
        }
        return ModelToRepresentation.toRepresentation(invoice);
    }

    @Override
    public List<InvoiceLineRepresentation> getInvoiceLines() {
        auth.requireView();
        return invoice.getInvoiceLines().stream().map(f -> ModelToRepresentation.toRepresentation(f)).collect(Collectors.toList());
    }

}
