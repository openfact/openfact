package org.openfact.services.resources.admin;

import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.jboss.logging.Logger;
import org.openfact.common.ClientConnection;
import org.openfact.models.InvoiceModel;
import org.openfact.models.ModelDuplicateException;
import org.openfact.models.ModelException;
import org.openfact.models.ModelReadOnlyException;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.utils.ModelToRepresentation;
import org.openfact.models.utils.RepresentationToModel;
import org.openfact.representations.idm.InvoiceLineRepresentation;
import org.openfact.representations.idm.InvoiceRepresentation;
import org.openfact.services.ErrorResponse;
import org.openfact.services.managers.InvoiceManager;

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
    public Response updateInvoice(InvoiceRepresentation rep) {
        auth.requireManage();

        if (invoice == null) {
            throw new NotFoundException("Invoice not found");
        }

        try {
            RepresentationToModel.updateInvoice(rep, invoice);
            return Response.noContent().build();
        } catch (ModelDuplicateException e) {
            return ErrorResponse.exists("Invoice exists with same serie and number");
        } catch (ModelReadOnlyException re) {
            return ErrorResponse.exists("Invoice is read only!");
        } catch (ModelException me) {
            return ErrorResponse.exists("Could not update invoice!");
        }
    } 

    @Override
    public List<InvoiceLineRepresentation> getLines() {
        auth.requireView();
        
        return invoice.getInvoiceLines().stream().map(f -> ModelToRepresentation.toRepresentation(f))
                .collect(Collectors.toList());
    }
    
    @Override
    public Response deleteInvoice() {
        auth.requireManage();

        if (invoice == null) {
            throw new NotFoundException("Invoice not found");
        }

        boolean removed = new InvoiceManager(session).removeInvoice(organization, invoice);
        if (removed) {
            return Response.noContent().build();
        } else {
            return ErrorResponse.error("Invoice couldn't be deleted", Response.Status.BAD_REQUEST);
        }
    }   
       
}
