package org.openfact.services.resources.admin;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Providers;

import org.jboss.logging.Logger;
import org.jboss.resteasy.spi.HttpRequest;
import org.jboss.resteasy.spi.HttpResponse;
import org.openfact.common.ClientConnection;
import org.openfact.common.Version;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.services.resources.OpenfactApplication;
import org.openfact.theme.BrowserSecurityHeaderSetup;
import org.openfact.theme.FreeMarkerException;
import org.openfact.theme.FreeMarkerUtil;
import org.openfact.utils.MediaType;

public class AdminConsoleImpl implements AdminConsole {

    private static final Logger logger = Logger.getLogger(AdminConsoleImpl.class);

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

    public AdminConsoleImpl(OrganizationModel organization) {
        this.organization = organization;
    }

    @Override
    public Response getMainPage() throws URISyntaxException, IOException {
        try {
            if (!uriInfo.getRequestUri().getPath().endsWith("/")) {
                return Response.status(302).location(uriInfo.getRequestUriBuilder().path("/").build()).build();
            } else {
                //Theme theme = AdminRootImpl.getTheme(session, organization);

                Map<String, Object> map = new HashMap<>();

                URI baseUri = uriInfo.getBaseUri();

                String authUrl = baseUri.toString();
                authUrl = authUrl.substring(0, authUrl.length() - 1);

                map.put("authUrl", authUrl);
                //map.put("resourceUrl", Urls.themeRoot(baseUri) + "/admin/" + theme.getName());
                map.put("resourceVersion", Version.RESOURCES_VERSION);
                //map.put("properties", theme.getProperties());

                FreeMarkerUtil freeMarkerUtil = new FreeMarkerUtil();
                String result = freeMarkerUtil.processTemplate(map, "index.ftl", null/*theme*/);
                Response.ResponseBuilder builder = Response.status(Response.Status.OK).type(MediaType.TEXT_HTML_UTF_8).language(Locale.ENGLISH).entity(result);
                BrowserSecurityHeaderSetup.headers(builder, organization);
                return builder.build();
            } 
        } catch (FreeMarkerException e) {
            logger.error(e);
        }
        
        return Response.ok().entity("Esta es la pagina de admin/console donde se redirige a angularjs").build();        
    }

    @Override
    public Response getIndexHtmlRedirect() {
        return Response.status(302).location(uriInfo.getRequestUriBuilder().path("../").build()).build();
    }

}
