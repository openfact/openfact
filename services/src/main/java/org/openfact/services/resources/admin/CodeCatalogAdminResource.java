package org.openfact.services.resources.admin;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.jboss.resteasy.annotations.cache.NoCache;
import org.openfact.common.ClientConnection;
import org.openfact.models.ModelDuplicateException;
import org.openfact.models.OpenfactSession;
import org.openfact.models.catalog.CodeCatalogModel;
import org.openfact.models.utils.ModelToRepresentation;
import org.openfact.models.utils.RepresentationToModel;
import org.openfact.representations.idm.catalog.CodeCatalogRepresentation;
import org.openfact.services.ErrorResponse;
import org.openfact.services.ServicesLogger;
import org.openfact.services.managers.CodeCatalogManager;

public class CodeCatalogAdminResource {

    protected static final ServicesLogger logger = ServicesLogger.LOGGER;

    protected OrganizationAuth auth;
    protected CodeCatalogModel codeCatalog;

    @Context
    protected OpenfactSession session;

    @Context
    protected UriInfo uriInfo;

    @Context
    protected ClientConnection connection;

    @Context
    protected HttpHeaders headers;

    public CodeCatalogAdminResource(OrganizationAuth auth, CodeCatalogModel codeCatalog) {
        this.auth = auth;
        this.codeCatalog = codeCatalog;

        auth.init(OrganizationAuth.Resource.CODE_CATALOG);
        auth.requireAny();
    }

    /**
     * Get the document with the specified documentId.
     *
     * @return The document with the specified documentId
     * @summary Get the document with the specified documentId
     */
    @GET
    @NoCache
    @Produces(MediaType.APPLICATION_JSON)
    public CodeCatalogRepresentation getCodeCatalog() {
        if (auth.hasView()) {
            return ModelToRepresentation.toRepresentation(codeCatalog, false);
        } else {
            auth.requireAny();
            return ModelToRepresentation.toRepresentation(codeCatalog, true);
        }
    }

    /**
     * Update document information.
     *
     * @param rep
     *            The representation of the document to be changed
     * @return Generic Response object
     * @summary Update document information
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateCodeCatalog(final CodeCatalogRepresentation rep) {
        auth.requireManage();

        logger.debug("updating codeCatalog: " + codeCatalog.getDescription());

        try {
            RepresentationToModel.updateCodeCatalog(rep, codeCatalog);

            return Response.noContent().build();
        } catch (ModelDuplicateException e) {
            return ErrorResponse.exists("Code Catalog with same data exists");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return ErrorResponse.error("Failed to update code catalog",
                    Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Deletes document with given documentId.
     *
     * @throws AuthorizationException
     *             The user is not authorized to delete this invoice.
     */
    @DELETE
    public void deleteCodeCatalog() {
        auth.requireManage();

        if (!new CodeCatalogManager(session).removeCodeCatalog(codeCatalog)) {
            throw new NotFoundException("Code Catalog doesn't exist");
        }
    }

}
