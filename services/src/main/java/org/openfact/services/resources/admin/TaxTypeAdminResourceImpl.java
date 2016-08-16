package org.openfact.services.resources.admin;

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
import org.openfact.models.TaxTypeModel;
import org.openfact.models.utils.ModelToRepresentation;
import org.openfact.models.utils.RepresentationToModel;
import org.openfact.representations.idm.InvoiceRepresentation;
import org.openfact.representations.idm.TaxTypeRepresentation;
import org.openfact.services.ErrorResponse;
import org.openfact.services.managers.InvoiceManager;

public class TaxTypeAdminResourceImpl implements TaxTypeAdminResource {
    
    protected static final Logger logger = Logger.getLogger(TaxTypeAdminResourceImpl.class);
    
    protected OrganizationModel organization;
    protected OrganizationAuth auth;
    protected TaxTypeModel taxType;
    
    @Context
    protected OpenfactSession session;
    
    @Context
    protected UriInfo uriInfo;
    
    @Context
    protected ClientConnection connection;

    public TaxTypeAdminResourceImpl(OrganizationAuth auth, OrganizationModel organization, TaxTypeModel taxType) {
        this.auth = auth;
        this.organization = organization;
        this.taxType = taxType;

        auth.init(OrganizationAuth.Resource.INVOICE);
        auth.requireAny();
    }

    @Override
    public TaxTypeRepresentation getTaxType() {
        auth.requireView();

        if (taxType == null) {
            throw new NotFoundException("Could not find tax type");
        }

        return ModelToRepresentation.toRepresentation(taxType);
    }

    @Override
    public Response updateTaxType(TaxTypeRepresentation rep) {
        auth.requireManage();

        if (taxType == null) {
            throw new NotFoundException("Could not find tax type");
        }

        try {
            RepresentationToModel.updateTaxType(rep, taxType);           
            return Response.noContent().build();
        } catch (ModelDuplicateException e) {
            return ErrorResponse.exists("Tax type " + rep.getName() + " already exists");
        }
    }

    @Override
    public Response deleteTaxType() {
        auth.requireManage();

        if (taxType == null) {
            throw new NotFoundException("Could not find tax type");
        }

        try {
            organization.removeTaxType(taxType);           
            return Response.noContent().build();
        } catch (ModelException me) {
            return ErrorResponse.error(me.getMessage(), Response.Status.BAD_REQUEST);
        }
    }

    

}
