/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package org.openfact.services.resources.admin;

import org.jboss.logging.Logger;
import org.openfact.common.ClientConnection;
import org.openfact.component.ComponentModel;
import org.openfact.component.ComponentValidationException;
import org.openfact.events.admin.OperationType;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.utils.ModelToRepresentation;
import org.openfact.models.utils.RepresentationToModel;
import org.openfact.representations.idm.ComponentRepresentation;
import org.openfact.services.ErrorResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ComponentResource {

    protected static final Logger logger = Logger.getLogger(ComponentResource.class);

    protected OrganizationModel organization;
    @Context
    protected ClientConnection clientConnection;
    @Context
    protected UriInfo uriInfo;
    @Context
    protected OpenfactSession session;
    @Context
    protected HttpHeaders headers;
    private OrganizationAuth auth;
    private AdminEventBuilder adminEvent;

    public ComponentResource(OrganizationModel organization, OrganizationAuth auth,
                             AdminEventBuilder adminEvent) {
        this.auth = auth;
        this.organization = organization;
        this.adminEvent = adminEvent;

        auth.init(OrganizationAuth.Resource.ORGANIZATION);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ComponentRepresentation> getComponents(@QueryParam("parent") String parent,
                                                       @QueryParam("type") String type) {
        auth.requireManage();
        List<ComponentModel> components = Collections.EMPTY_LIST;
        if (parent == null) {
            components = organization.getComponents();

        } else if (type == null) {
            components = organization.getComponents(parent);
        } else {
            components = organization.getComponents(parent, type);
        }
        List<ComponentRepresentation> reps = new LinkedList<>();
        for (ComponentModel component : components) {
            ComponentRepresentation rep = ModelToRepresentation.toRepresentation(session, component, false);
            reps.add(rep);
        }
        return reps;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(ComponentRepresentation rep) {
        auth.requireManage();
        try {
            ComponentModel model = RepresentationToModel.toModel(session, rep);
            if (model.getParentId() == null)
                model.setParentId(organization.getId());
            adminEvent.operation(OperationType.CREATE).resourcePath(uriInfo, model.getId())
                    .representation(rep).success();

            model = organization.addComponentModel(model);
            return Response.created(uriInfo.getAbsolutePathBuilder().path(model.getId()).build()).build();
        } catch (ComponentValidationException e) {
            return ErrorResponse.error(e.getMessage(), Response.Status.BAD_REQUEST);
        }
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ComponentRepresentation getComponent(@PathParam("id") String id) {
        auth.requireManage();
        ComponentModel model = organization.getComponent(id);
        if (model == null) {
            throw new NotFoundException("Could not find component");
        }
        return ModelToRepresentation.toRepresentation(session, model, false);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateComponent(@PathParam("id") String id, ComponentRepresentation rep) {
        auth.requireManage();
        ComponentModel model = organization.getComponent(id);
        if (model == null) {
            throw new NotFoundException("Could not find component");
        }
        RepresentationToModel.updateComponent(session, rep, model, false);
        adminEvent.operation(OperationType.UPDATE).resourcePath(uriInfo, model.getId()).representation(rep)
                .success();
        organization.updateComponent(model);
    }

    @DELETE
    @Path("{id}")
    public void removeComponent(@PathParam("id") String id) {
        auth.requireManage();
        ComponentModel model = organization.getComponent(id);
        if (model == null) {
            throw new NotFoundException("Could not find component");
        }
        adminEvent.operation(OperationType.DELETE).resourcePath(uriInfo, model.getId()).success();
        organization.removeComponent(model);

    }

}
