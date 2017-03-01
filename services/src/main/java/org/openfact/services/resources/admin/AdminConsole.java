/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
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
import org.openfact.models.OrganizationModel;
import org.openfact.theme.BrowserSecurityHeaderSetup;
import org.openfact.theme.FreeMarkerException;
import org.openfact.theme.FreeMarkerUtil;
import org.openfact.theme.Theme;
import org.openfact.utils.MediaType;

public class AdminConsole {

    private static final Logger logger = Logger.getLogger(AdminConsole.class);

    @Context
    protected UriInfo uriInfo;

    @Context
    protected HttpRequest request;

    @Context
    protected HttpResponse response;

    @Context
    protected Providers providers;

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
//    @GET
//    @NoCache
//    public Response getMainPage() throws URISyntaxException, IOException, FreeMarkerException {
//        if (!uriInfo.getRequestUri().getPath().endsWith("/")) {
//            return Response.status(302).location(uriInfo.getRequestUriBuilder().path("/").build()).build();
//        } else {
//            Theme theme = AdminRoot.getTheme(session, organization);
//
//            Map<String, Object> map = new HashMap<>();
//
//            URI baseUri = uriInfo.getBaseUri();
//
//            String openfactUrl = baseUri.toString();
//            openfactUrl = openfactUrl.substring(0, openfactUrl.length() - 1);
//
//            map.put("adminConsoleUrl", Config.getAdminConsoleUrl());
//
//            FreeMarkerUtil freeMarkerUtil = new FreeMarkerUtil();
//            String result = freeMarkerUtil.processTemplate(map, "index.ftl", theme);
//            Response.ResponseBuilder builder = Response.status(Response.Status.OK).type(MediaType.TEXT_HTML_UTF_8).language(Locale.ENGLISH).entity(result);
//            BrowserSecurityHeaderSetup.headers(builder, organization);
//            return builder.build();
//        }
//    }

    @GET
    @Path("{indexhtml: index.html}")
    public Response getIndexHtmlRedirect() {
        return Response.status(302).location(uriInfo.getRequestUriBuilder().path("../").build()).build();
    }

}
