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
package org.openfact.services.resources.admin.storage;

import org.jboss.logging.Logger;
import org.jboss.resteasy.annotations.cache.NoCache;
import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.openfact.common.ClientConnection;
import org.openfact.events.EventType;
import org.openfact.events.admin.OperationType;
import org.openfact.events.admin.ResourceType;
import org.openfact.models.InvoiceModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.StorageFileModel;
import org.openfact.models.utils.ModelToRepresentation;
import org.openfact.provider.*;
import org.openfact.representations.idm.ComponentTypeRepresentation;
import org.openfact.representations.idm.InvoiceRepresentation;
import org.openfact.representations.idm.OrganizationRepresentation;
import org.openfact.representations.info.*;
import org.openfact.services.ServicesLogger;
import org.openfact.services.managers.OrganizationManager;
import org.openfact.services.resources.OpenfactApplication;
import org.openfact.services.resources.admin.*;
import org.openfact.theme.Theme;
import org.openfact.theme.ThemeProvider;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class StorageFilesAdminResource {

    private static final ServicesLogger logger = ServicesLogger.LOGGER;

    @Context
    protected UriInfo uriInfo;

    @Context
    protected OpenfactSession session;

    @Context
    protected ClientConnection clientConnection;

    @Context
    protected HttpHeaders headers;

    protected OrganizationModel organization;
    private OrganizationAuth auth;
    private AdminEventBuilder adminEvent;

    public StorageFilesAdminResource(OrganizationModel organization, OrganizationAuth auth,
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
        auth.requireView();

        StorageFileModel file = session.storageFiles().getFileById(organization, idFile);
        if (file == null) {
            throw new NotFoundException("File not found");
        }

        Response.ResponseBuilder response = Response.ok(file.getFile());
        response.type(file.getMimeType());
        response.header("content-disposition", "attachment; filename=\"" + file.getFileName() + "\"");

        return response.build();
    }

}
