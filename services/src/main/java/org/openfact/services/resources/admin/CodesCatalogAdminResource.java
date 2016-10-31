package org.openfact.services.resources.admin;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.jboss.logging.Logger;
import org.jboss.resteasy.annotations.cache.NoCache;
import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.openfact.common.ClientConnection;
import org.openfact.models.ModelDuplicateException;
import org.openfact.models.OpenfactSession;
import org.openfact.models.catalog.CodeCatalogModel;
import org.openfact.models.utils.ModelToRepresentation;
import org.openfact.representations.idm.catalog.CodeCatalogRepresentation;
import org.openfact.services.ErrorResponse;
import org.openfact.services.managers.CodeCatalogManager;
import org.openfact.services.managers.OrganizationManager;
import org.openfact.services.resources.OpenfactApplication;

/**
 * @author carlosthe19916@sistcoop.com
 */
@Consumes(MediaType.APPLICATION_JSON)
public class CodesCatalogAdminResource {

    private static final Logger logger = Logger.getLogger(CodesCatalogAdminResource.class);

    protected AdminAuth auth;

    @Context
    protected OpenfactSession session;

    @Context
    protected OpenfactApplication openfact;

    @Context
    protected ClientConnection clientConnection;

    public CodesCatalogAdminResource(AdminAuth auth) {
        this.auth = auth;
    }

    /**
     * @param documentId
     *            The documentId of the document
     */
    @Path("{codeCatalogId}")
    public CodeCatalogAdminResource getDocumentAdmin(@PathParam("codeCatalogId") final String codeCatalogId) {
        CodeCatalogManager catalogManager = new CodeCatalogManager(session);
        CodeCatalogModel codeCatalog = catalogManager.getCodeCatalogById(codeCatalogId);
        if (codeCatalog == null)
            throw new NotFoundException("Code Catalog not found.");

        OrganizationAuth organizationAuth = new OrganizationAuth(auth);

        CodeCatalogAdminResource adminResource = new CodeCatalogAdminResource(organizationAuth, codeCatalog);
        ResteasyProviderFactory.getInstance().injectProperties(adminResource);
        // resourceContext.initResource(adminResource);
        return adminResource;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCodeCatalog(@Context final UriInfo uriInfo,
            @Valid final CodeCatalogRepresentation rep) {
        CodeCatalogManager codeCatalogManager = new CodeCatalogManager(session);

        logger.debugv("importCodeCatalog: {0}", rep.getDescription());

        try {
            CodeCatalogModel codeCatalog = codeCatalogManager.importCodeCatalog(rep);

            URI location = AdminRoot.organizationsUrl(uriInfo).path(codeCatalog.getId()).build();
            logger.debugv("imported organization success, sending back: {0}", location.toString());

            return Response.created(location).build();
        } catch (ModelDuplicateException e) {
            return ErrorResponse.exists("Organization with same name exists");
        }
    }

    @GET
    @NoCache
    @Produces(MediaType.APPLICATION_JSON)
    public List<CodeCatalogRepresentation> getCodesCatalog(@QueryParam("filterText") final String filterText,
            @QueryParam("locale") final String locale, @QueryParam("type") final String type,
            @QueryParam("code") final String code, @QueryParam("description") final String description,
            @QueryParam("first") Integer firstResult, @QueryParam("max") Integer maxResults) {
        OrganizationManager organizationManager = new OrganizationManager(session);
        List<CodeCatalogRepresentation> reps = new ArrayList<>();

        firstResult = firstResult != null ? firstResult : -1;
        maxResults = maxResults != null ? maxResults : -1;

        List<CodeCatalogModel> codesCatalog;
        if (filterText != null) {
            codesCatalog = session.codesCatalog().searchForCodeCatalog(filterText.trim(), firstResult,
                    maxResults);
        } else if (locale != null || type != null || code != null || description != null) {
            Map<String, String> attributes = new HashMap<String, String>();
            if (locale != null) {
                attributes.put(CodeCatalogModel.LOCALE, locale);
            }
            if (type != null) {
                attributes.put(CodeCatalogModel.TYPE, type);
            }
            if (code != null) {
                attributes.put(CodeCatalogModel.CODE, code);
            }
            if (description != null) {
                attributes.put(CodeCatalogModel.DESCRIPTION, description);
            }
            codesCatalog = session.codesCatalog().searchForCodeCatalog(attributes, firstResult, maxResults);
        } else {
            codesCatalog = session.codesCatalog().getCodeCatalogs(firstResult, maxResults);
        }

        if (auth.getOrganization().equals(organizationManager.getOpenfactAdminstrationOrganization())) {
            reps = codesCatalog.stream().map(f -> ModelToRepresentation.toRepresentation(f, true))
                    .collect(Collectors.toList());
        } else {
            reps = codesCatalog.stream().map(f -> ModelToRepresentation.toRepresentation(f, false))
                    .collect(Collectors.toList());
        }

        logger.debug(("getCodeCatalogs()"));
        return reps;
    }

}
