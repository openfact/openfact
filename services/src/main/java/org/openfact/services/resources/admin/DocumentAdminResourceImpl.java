package org.openfact.services.resources.admin;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.jboss.logging.Logger;
import org.openfact.common.ClientConnection;
import org.openfact.models.DocumentModel;
import org.openfact.models.ModelDuplicateException;
import org.openfact.models.ModelException;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.utils.ModelToRepresentation;
import org.openfact.models.utils.RepresentationToModel;
import org.openfact.representations.idm.DocumentRepresentation;
import org.openfact.services.ErrorResponse;

public class DocumentAdminResourceImpl implements DocumentAdminResource {
    
    protected static final Logger logger = Logger.getLogger(DocumentAdminResourceImpl.class);
    
    protected OrganizationModel organization;
    protected OrganizationAuth auth;
    protected DocumentModel document;
    
    @Context
    protected OpenfactSession session;
    
    @Context
    protected UriInfo uriInfo;
    
    @Context
    protected ClientConnection connection;

    public DocumentAdminResourceImpl(OrganizationAuth auth, OrganizationModel organization, DocumentModel document) {
        this.auth = auth;
        this.organization = organization;
        this.document = document;

        auth.init(OrganizationAuth.Resource.INVOICE);
        auth.requireAny();
    }

    @Override
    public DocumentRepresentation getDocument() {
        auth.requireView();

        if (document == null) {
            throw new NotFoundException("Could not find document");
        }

        return ModelToRepresentation.toRepresentation(document);
    }

    @Override
    public Response updateDocument(DocumentRepresentation rep) {
        auth.requireManage();

        if (document == null) {
            throw new NotFoundException("Could not find document");
        }

        try {
            RepresentationToModel.updateDocument(rep, document);           
            return Response.noContent().build();
        } catch (ModelDuplicateException e) {
            return ErrorResponse.exists("Document " + rep.getName() + " already exists");
        }
    }

    @Override
    public Response deleteDocument() {
        auth.requireManage();

        if (document == null) {
            throw new NotFoundException("Could not find document");
        }

        try {
            organization.removeDocument(document);           
            return Response.noContent().build();
        } catch (ModelException me) {
            return ErrorResponse.error(me.getMessage(), Response.Status.BAD_REQUEST);
        }
    }

}
