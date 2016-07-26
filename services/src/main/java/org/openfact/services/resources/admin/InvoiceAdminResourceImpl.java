package org.openfact.services.resources.admin;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.jboss.logging.Logger;
import org.openfact.common.ClientConnection;
import org.openfact.models.InvoiceModel;
import org.openfact.models.ModelDuplicateException;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.utils.ModelToRepresentation;
import org.openfact.models.utils.RepresentationToModel;
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


    public InvoiceAdminResourceImpl(OrganizationAuth auth, OrganizationModel organization,
                                    InvoiceModel invoice) {
        this.auth=auth;
        this.organization=organization;
        this.invoice=invoice;

        auth.init(OrganizationAuth.Resource.REALM);
        auth.requireAny();
    }

    @Override
    public InvoiceRepresentation getInvoice() {
        if (auth.hasView()){
//            return ModelToRepresentation.toRepresentacion(invoice, false);
        }
        return null;
    }

    @Override
    public Response updateInvoice(InvoiceRepresentation rep) {
        auth.requireManage();
        logger.debug("updating invoice"+ invoice.getId());
        try {
            RepresentationToModel.updateInvoice(rep, invoice);
            return Response.noContent().build();
        }catch (ModelDuplicateException e){
            return ErrorResponse.exists("Invoice with same name exists");
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return ErrorResponse.error("", Response.Status.INTERNAL_SERVER_ERROR);
        }

    }

    @Override
    public void deleteInvoice() {
        auth.requireManage();
        if (!new InvoiceManager(session).removeInvoice(invoice)){
            throw new NotFoundException("Invoice doesn't exist");
        }

    }

}
