package org.openfact.services.resources.admin;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.jboss.logging.Logger;
import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.openfact.common.ClientConnection;
import org.openfact.models.DocumentModel;
import org.openfact.models.ModelDuplicateException;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.enums.DocumentType;
import org.openfact.models.utils.ModelToRepresentation;
import org.openfact.models.utils.RepresentationToModel;
import org.openfact.representations.idm.DocumentRepresentation;
import org.openfact.services.ErrorResponse;

public class DocumentsAdminResourceImpl implements DocumentsAdminResource {

	private static final Logger logger = Logger.getLogger(DocumentsAdminResourceImpl.class);

	protected OrganizationAuth auth;

	protected OrganizationModel organization;

	@Context
	protected UriInfo uriInfo;

	@Context
	protected OpenfactSession session;

	@Context
	protected ClientConnection clientConnection;

	public DocumentsAdminResourceImpl(OrganizationModel organization, OrganizationAuth auth) {
		this.organization = organization;
		this.auth = auth;
		auth.init(OrganizationAuth.Resource.INVOICE);
	}

	public static final CacheControl noCache = new CacheControl();

	static {
		noCache.setNoCache(true);
	}

    @Override
    public DocumentAdminResource getDocumentAdmin(String documentId) {
        DocumentModel document = organization.getDocumentById(documentId);
        DocumentAdminResource clientResource = new DocumentAdminResourceImpl(auth, organization, document);
        ResteasyProviderFactory.getInstance().injectProperties(clientResource);
        return clientResource;
    }
    
    @Override
    public Response createDocument(DocumentRepresentation rep) {
        auth.requireManage();

        try {
            DocumentModel clientModel = RepresentationToModel.createDocument(session, organization, rep);
            
            logger.debug("Document created: " + clientModel.getId());
            
            return Response.created(uriInfo.getAbsolutePathBuilder().path(clientModel.getId()).build()).entity(ModelToRepresentation.toRepresentation(clientModel)).build();
        } catch (ModelDuplicateException e) {
            return ErrorResponse.exists("Document " + rep.getName() + " already exists");
        }
    }

    @Override
    public Set<DocumentRepresentation> getDocuments(String type) {
        auth.requireView();

        Set<DocumentRepresentation> rep = new HashSet<>();
        Set<DocumentModel> documents;
        if(type == null || type.isEmpty()) {
            documents = organization.getDocuments();
        } else {
            documents = organization.getDocuments(DocumentType.valueOf(type));
        }

        boolean view = auth.hasView();
        for (DocumentModel taxType : documents) {
            if (view) {
                rep.add(ModelToRepresentation.toRepresentation(taxType));
            } else {
                DocumentRepresentation client = new DocumentRepresentation();
                client.setName(taxType.getName());
                rep.add(client);
            }
        }
        return rep;
    }

}
