package org.openfact.services.resources.admin;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Providers;

import org.jboss.logging.Logger;
import org.jboss.resteasy.annotations.cache.NoCache;
import org.jboss.resteasy.spi.HttpRequest;
import org.jboss.resteasy.spi.HttpResponse;
import org.openfact.Config;
import org.openfact.common.ClientConnection;
import org.openfact.common.Version;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.services.resources.OpenfactApplication;
import org.openfact.theme.BrowserSecurityHeaderSetup;
import org.openfact.theme.FreeMarkerException;
import org.openfact.theme.FreeMarkerUtil;
import org.openfact.utils.MediaType;

public class AdminConsole {

    private static final Logger logger = Logger.getLogger(AdminConsole.class);

    @Context
    protected UriInfo uriInfo;

    @Context
    protected ClientConnection clientConnection;

    @Context
    protected HttpRequest request;

    @Context
    protected HttpResponse response;

    @Context
    protected OpenfactSession session;

    @Context
    protected Providers providers;

    @Context
    protected OpenfactApplication openfact;

    protected OrganizationModel organization;

    public AdminConsole(OrganizationModel organization) {
        this.organization = organization;
    }

    /**
     * @throws URISyntaxException
     *             on internal error.
     * @throws IOException
     *             on internal error.
     */
    @GET
    @NoCache
    public Response getMainPage() throws URISyntaxException, IOException {
        try {
            if (!uriInfo.getRequestUri().getPath().endsWith("/")) {
                return Response.status(302).location(uriInfo.getRequestUriBuilder().path("/").build())
                        .build();
            } else {
                Map<String, Object> map = new HashMap<>();

                URI baseUri = uriInfo.getBaseUri();

                String authUrl = baseUri.toString();
                authUrl = authUrl.substring(0, authUrl.length() - 1);

                map.put("authUrl", authUrl);
                map.put("masterOrganization", Config.getAdminOrganization());
                map.put("resourceVersion", Version.RESOURCES_VERSION);

                FreeMarkerUtil freeMarkerUtil = new FreeMarkerUtil();
                String result = freeMarkerUtil.processTemplate(map, "index.ftl", null);
                Response.ResponseBuilder builder = Response.status(Response.Status.OK)
                        .type(MediaType.TEXT_HTML_UTF_8).language(Locale.ENGLISH).entity(result);
                BrowserSecurityHeaderSetup.headers(builder, organization);
                return builder.build();
            }
        } catch (FreeMarkerException e) {
            logger.error(e);
            throw new IOException(e);
        }
    }

    @GET
    @Path("{indexhtml: index.html}")
    public Response getIndexHtmlRedirect() {
        return Response.status(302).location(uriInfo.getRequestUriBuilder().path("../").build()).build();
    }

}
