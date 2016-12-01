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
import org.jboss.resteasy.annotations.cache.NoCache;
import org.jboss.resteasy.spi.HttpRequest;
import org.jboss.resteasy.spi.HttpResponse;
import org.openfact.common.util.PemUtils;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.representations.idm.PublishedOrganizationRepresentation;
import org.openfact.services.resources.admin.AdminRoot;

import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * @author carlosthe19916@sistcoop.com
 */
public class PublicOrganizationResource {

    protected static final Logger logger = Logger.getLogger(PublicOrganizationResource.class);

    @Context
    protected UriInfo uriInfo;

    @Context
    protected HttpRequest request;

    @Context
    protected HttpResponse response;

    @Context
    protected OpenfactSession session;

    protected OrganizationModel organization;

    public PublicOrganizationResource(OrganizationModel organization) {
        this.organization = organization;
    }

    public static PublishedOrganizationRepresentation organizationRep(OpenfactSession session,
                                                                      OrganizationModel organization, UriInfo uriInfo) {
        PublishedOrganizationRepresentation rep = new PublishedOrganizationRepresentation();
        rep.setOrganization(organization.getName());
        rep.setAdminApiUrl(uriInfo.getBaseUriBuilder().path(AdminRoot.class).build().toString());
        rep.setPublicKeyPem(PemUtils.encodeKey(session.keys().getActiveKey(organization).getPublicKey()));
        return rep;
    }

    @Path("/")
    @OPTIONS
    public Response accountPreflight() {
        return Cors.add(request, Response.ok()).auth().preflight().build();
    }

    @GET
    @NoCache
    @Produces(MediaType.APPLICATION_JSON)
    public PublishedOrganizationRepresentation getOrganization() {
        Cors.add(request).allowedOrigins(Cors.ACCESS_CONTROL_ALLOW_ORIGIN_WILDCARD).auth().build(response);
        return organizationRep(session, organization, uriInfo);
    }

}
