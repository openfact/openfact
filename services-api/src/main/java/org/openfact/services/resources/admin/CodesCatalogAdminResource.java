package org.openfact.services.resources.admin;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.cache.NoCache;
import org.openfact.representations.idm.catalog.CodeCatalogRepresentation;

/**
 * @author carlosthe19916@sistcoop.com
 */
@Consumes(MediaType.APPLICATION_JSON)
public interface CodesCatalogAdminResource {

    /**
     * @param documentId
     *            The documentId of the document
     */
    @Path("{codeCatalogId}")
    CodeCatalogAdminResource getDocumentAdmin(@PathParam("codeCatalogId") final String codeCatalogId);

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    Response createCodeCatalog(@Valid final CodeCatalogRepresentation rep);

    @GET
    @NoCache
    @Produces(MediaType.APPLICATION_JSON)
    List<CodeCatalogRepresentation> getCodesCatalog(@QueryParam("locale") final String locale,
            @QueryParam("type") final String type, @QueryParam("code") final String code,
            @QueryParam("description") final String description);

}
