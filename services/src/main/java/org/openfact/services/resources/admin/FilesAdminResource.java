package org.openfact.services.resources.admin;

import org.jboss.logging.Logger;
import org.jboss.resteasy.annotations.cache.NoCache;
import org.openfact.common.OpenfactClientConnection;
import org.openfact.models.FileModel;
import org.openfact.models.FileProvider;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.types.InternetMediaType;
import org.openfact.services.managers.OrganizationManager;
import org.openfact.services.resource.security.OrganizationAuth;
import org.openfact.services.resource.security.SecurityContextProvider;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/admin/organizations/{organization}/files")
public class FilesAdminResource {

    protected static final Logger logger = Logger.getLogger(JobReportsAdminResource.class);

    @Context
    protected UriInfo uriInfo;

    @Context
    protected OpenfactSession session;

    @Context
    protected OpenfactClientConnection clientConnection;

    @Context
    protected HttpHeaders headers;

    @Inject
    private AdminEventBuilder adminEvent;

    @Inject
    private FileProvider fileProvider;

    @Inject
    private OrganizationManager organizationManager;

    @Inject
    private SecurityContextProvider securityContext;

    @GET
    @Path("{idFile}")
    @NoCache
    public Response getFile(
            @PathParam("organization") String organizationName,
            @PathParam("idFile") String idFile) {
        OrganizationModel organization = AdminUtil.initOrganization(organizationName, organizationManager);
        OrganizationAuth auth = AdminUtil.initAuth(session, securityContext, organizationManager, organization);

        auth.requireView();

        FileModel file = fileProvider.getFileById(organization, idFile);
        if (file == null) {
            throw new NotFoundException("File not found");
        }

        Response.ResponseBuilder response = Response.ok(file.getFile());
        response.type(InternetMediaType.getMymeTypeFromExtension(file.getExtension()));
        response.header("content-disposition", "attachment; filename=\"" + file.getFileName() + "\"");

        return response.build();
    }

}
