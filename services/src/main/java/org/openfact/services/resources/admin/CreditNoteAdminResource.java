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

import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.jboss.resteasy.annotations.cache.NoCache;
import org.openfact.common.ClientConnection;
import org.openfact.events.admin.OperationType;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.ubl.CreditNoteModel;
import org.openfact.models.utils.ModelToRepresentation;
import org.openfact.representations.idm.ubl.CreditNoteRepresentation;
import org.openfact.representations.idm.ubl.common.CreditNoteLineRepresentation;
import org.openfact.services.ErrorResponse;
import org.openfact.services.ServicesLogger;
import org.openfact.services.managers.CreditNoteManager;

public class CreditNoteAdminResource {

    private static final ServicesLogger logger = ServicesLogger.LOGGER;

    protected OrganizationModel organization;
    protected CreditNoteModel creditNote;
    private OrganizationAuth auth;
    private AdminEventBuilder adminEvent;

    @Context
    protected UriInfo uriInfo;

    @Context
    protected OpenfactSession session;

    @Context
    protected ClientConnection clientConnection;

    @Context
    protected HttpHeaders headers;

    public CreditNoteAdminResource(OrganizationModel organization, OrganizationAuth auth,
            AdminEventBuilder adminEvent, CreditNoteModel creditNote) {
        this.auth = auth;
        this.organization = organization;
        this.adminEvent = adminEvent;
        this.creditNote = creditNote;

        auth.init(OrganizationAuth.Resource.CREDIT_NOTE);
    }

    /**
     * Get the creditNote with the specified creditNoteId.
     *
     * @return The creditNote with the specified creditNoteId
     * @summary Get the creditNote with the specified creditNoteId
     */
    @GET
    @NoCache
    @Produces(MediaType.APPLICATION_JSON)
    public CreditNoteRepresentation getCreditNote() {
        auth.requireView();

        if (creditNote == null) {
            throw new NotFoundException("Credit Note not found");
        }

        CreditNoteRepresentation rep = ModelToRepresentation.toRepresentation(creditNote);
        return rep;
    }

    @GET
    @Path("lines")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CreditNoteLineRepresentation> getLines() {
        auth.requireView();

        return creditNote.getCreditNoteLine().stream().map(f -> ModelToRepresentation.toRepresentation(f))
                .collect(Collectors.toList());
    }

    /**
     * Deletes creditNote with given creditNoteId.
     *
     * @throws AuthorizationException
     *             The user is not authorized to delete this creditNote.
     */
    @DELETE
    public Response deleteCreditNote() {
        auth.requireManage();

        if (creditNote == null) {
            throw new NotFoundException("Credit Note not found");
        }

        boolean removed = new CreditNoteManager(session).removeCreditNote(organization, creditNote);
        if (removed) {
            adminEvent.operation(OperationType.DELETE).resourcePath(uriInfo).success();
            return Response.noContent().build();
        } else {
            return ErrorResponse.error("Credit Note couldn't be deleted", Response.Status.BAD_REQUEST);
        }
    }

}
