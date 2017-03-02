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

import org.jboss.resteasy.annotations.cache.NoCache;
import org.openfact.models.OrganizationModel;
import org.openfact.services.resources.admin.*;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

public class FilesAdminResource {

    @Context
    protected UriInfo uriInfo;

    @Context
    protected HttpHeaders headers;

    protected OrganizationModel organization;
    private OrganizationAuth auth;
    private AdminEventBuilder adminEvent;

    public FilesAdminResource(OrganizationModel organization, OrganizationAuth auth,
                              AdminEventBuilder adminEvent) {
        this.auth = auth;
        this.organization = organization;
        this.adminEvent = adminEvent;

        auth.init(OrganizationAuth.Resource.FILES);
    }

    @GET
    @Path("{idFile}")
    @NoCache
    public Response getFile(@PathParam("idFile") String idFile) {
        /*auth.requireView();

        FileModel file = session.getProvider(FileProvider.class).getFileById(organization, idFile);
        if (file == null) {
            throw new NotFoundException("File not found");
        }

        Response.ResponseBuilder response = Response.ok(file.getFile());
        response.type(InternetMediaType.getMymeTypeFromExtension(file.getExtension()));
        response.header("content-disposition", "attachment; filename=\"" + file.getFileName() + "\"");

        return response.build();*/
        return null;
    }

}
