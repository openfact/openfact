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
package org.openfact.services.resources;

import org.jboss.logging.Logger;
import org.openfact.common.Version;
import org.openfact.common.util.MimeTypeUtil;
import org.openfact.services.util.CacheControlUtil;
import org.openfact.theme.Theme;
import org.openfact.theme.ThemeProvider;
import org.openfact.theme.ThemeProviderType;
import org.openfact.theme.ThemeProviderType.ProviderType;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.io.InputStream;

/**
 * Theme resource
 */
@Stateless
@Path("/resources")
public class ThemeResource {

    protected static final Logger logger = Logger.getLogger(ThemeResource.class);

    @Inject
    @ThemeProviderType(type = ProviderType.EXTENDING)
    private ThemeProvider themeProvider;

    /**
     * Get theme content
     *
     * @param themType
     * @param themeName
     * @param path
     * @return
     */
    @GET
    @Path("/{version}/{themeType}/{themeName}/{path:.*}")
    public Response getResource(
            @PathParam("version") String version, 
            @PathParam("themeType") String themType,
            @PathParam("themeName") String themeName, 
            @PathParam("path") String path) {
        
        if (!version.equals(Version.RESOURCES_VERSION)) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        try {
            Theme theme = themeProvider.getTheme(themeName, Theme.Type.valueOf(themType.toUpperCase()));
            InputStream resource = theme.getResourceAsStream(path);
            if (resource != null) {
                return Response.ok(resource).type(MimeTypeUtil.getContentType(path))
                        .cacheControl(CacheControlUtil.getDefaultCacheControl()).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
        } catch (Exception e) {
            logger.error("Failed to get Theme Request", e);
            return Response.serverError().build();
        }
    }

}
