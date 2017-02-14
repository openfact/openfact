/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates
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
 */

package org.openfact.admin.client.resource;

import org.openfact.representations.idm.DocumentRepresentation;
import org.openfact.representations.idm.SendEventRepresentation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface DocumentResource {

    @GET
    public DocumentRepresentation toRepresentation();

    @PUT
    public void update(DocumentRepresentation documentRepresentation);

    @DELETE
    public void remove();

    @GET
    @Path("representation/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response jsonRepresentation();

    @GET
    @Path("representation/xml")
    @Produces("application/xml")
    public Response downloadXml();

    @Path("report")
    @GET
    public Response report(@QueryParam("theme") String theme,
                           @QueryParam("format") String format);

    @POST
    @Path("send-to-customer")
    public void sendToCustomer();

    @POST
    @Path("send-to-third-party")
    public void sendToThirdParty();

    @POST
    @Path("send-to-third-party-by-email")
    public void sendToCustomEmail();

    @GET
    @Path("send-events")
    public List<SendEventRepresentation> sendedEvents();

}
