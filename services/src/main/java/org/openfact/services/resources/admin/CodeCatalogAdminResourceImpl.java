package org.openfact.services.resources.admin;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

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

public class CodeCatalogAdminResourceImpl implements CodeCatalogAdminResource {

    protected static final ServicesLogger logger = ServicesLogger.ROOT_LOGGER;

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

    public CodeCatalogAdminResourceImpl(OrganizationAuth auth, CodeCatalogModel codeCatalog) {
        this.auth = auth;
        this.codeCatalog = codeCatalog;

        auth.init(OrganizationAuth.Resource.CODE_CATALOG);
        auth.requireAny();
    }

    @Override
    public CodeCatalogRepresentation getCodeCatalog() {
        if (auth.hasView()) {
            return ModelToRepresentation.toRepresentation(codeCatalog, false);
        } else {
            auth.requireAny();
            return ModelToRepresentation.toRepresentation(codeCatalog, true);
        }
    }

    @Override
    public Response updateCodeCatalog(CodeCatalogRepresentation rep) {
        auth.requireManage();

        logger.debug("updating codeCatalog: " + codeCatalog.getDescription());

        try {
            RepresentationToModel.updateCodeCatalog(rep, codeCatalog);

            return Response.noContent().build();
        } catch (ModelDuplicateException e) {
            return ErrorResponse.exists("Code Catalog with same data exists");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return ErrorResponse.error("Failed to update code catalog", Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public void deleteCodeCatalog() {
        auth.requireManage();

        if (!new CodeCatalogManager(session).removeCodeCatalog(codeCatalog)) {
            throw new NotFoundException("Code Catalog doesn't exist");
        }
    }

}
