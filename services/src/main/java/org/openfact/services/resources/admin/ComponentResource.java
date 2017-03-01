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

import java.text.MessageFormat;
import java.util.*;

import javax.ws.rs.*;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.jboss.logging.Logger;
import org.jboss.resteasy.annotations.cache.NoCache;
import org.jboss.resteasy.spi.*;
import org.openfact.events.admin.OperationType;
import org.openfact.models.OrganizationModel;
import org.openfact.models.utils.ModelToRepresentation;
import org.openfact.models.utils.RepresentationToModel;
import org.openfact.representations.idm.ComponentTypeRepresentation;
import org.openfact.representations.idm.ConfigPropertyRepresentation;
import org.openfact.services.ErrorResponse;

public class ComponentResource {

    protected static final Logger logger = Logger.getLogger(ComponentResource.class);

    protected OrganizationModel organization;

    @Context
    protected UriInfo uriInfo;

    @Context
    protected HttpHeaders headers;

    private OrganizationAuth auth;
    private AdminEventBuilder adminEvent;

    public ComponentResource(OrganizationModel organization, OrganizationAuth auth, AdminEventBuilder adminEvent) {
        this.auth = auth;
        this.organization = organization;
        this.adminEvent = adminEvent;

        auth.init(OrganizationAuth.Resource.ORGANIZATION);
    }

//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<ComponentRepresentation> getComponents(@QueryParam("parent") String parent, @QueryParam("type") String type) {
//        auth.requireView();
//        List<ComponentModel> components = Collections.EMPTY_LIST;
//        if (parent == null && type == null) {
//            components = organization.getComponents();
//
//        } else if (type == null) {
//            components = organization.getComponents(parent);
//        } else if (parent == null) {
//            components = organization.getComponents(organization.getId(), type);
//        } else {
//            components = organization.getComponents(parent, type);
//        }
//        List<ComponentRepresentation> reps = new LinkedList<>();
//        for (ComponentModel component : components) {
//            ComponentRepresentation rep = ModelToRepresentation.toRepresentation(session, component, false);
//            reps.add(rep);
//        }
//        return reps;
//    }
//
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response create(ComponentRepresentation rep) {
//        auth.requireManage();
//        try {
//            ComponentModel model = RepresentationToModel.toModel(session, rep);
//            if (model.getParentId() == null) model.setParentId(organization.getId());
//
//            model = organization.addComponentModel(model);
//
//            adminEvent.operation(OperationType.CREATE).resourcePath(uriInfo, model.getId()).representation(StripSecretsUtils.strip(session, rep)).success();
//            return Response.created(uriInfo.getAbsolutePathBuilder().path(model.getId()).build()).build();
//        } catch (ComponentValidationException e) {
//            return localizedErrorResponse(e);
//        } catch (IllegalArgumentException e) {
//            throw new BadRequestException(e);
//        }
//    }
//
//    @GET
//    @Path("{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    @NoCache
//    public ComponentRepresentation getComponent(@PathParam("id") String id) {
//        auth.requireView();
//        ComponentModel model = organization.getComponent(id);
//        if (model == null) {
//            throw new org.jboss.resteasy.spi.NotFoundException("Could not find component");
//        }
//        ComponentRepresentation rep = ModelToRepresentation.toRepresentation(session, model, false);
//        return rep;
//    }
//
//    @PUT
//    @Path("{id}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response updateComponent(@PathParam("id") String id, ComponentRepresentation rep) {
//        auth.requireManage();
//        try {
//            ComponentModel model = organization.getComponent(id);
//            if (model == null) {
//                throw new NotFoundException("Could not find component");
//            }
//            RepresentationToModel.updateComponent(session, rep, model, false);
//            adminEvent.operation(OperationType.UPDATE).resourcePath(uriInfo, model.getId()).representation(StripSecretsUtils.strip(session, rep)).success();
//            organization.updateComponent(model);
//            return Response.noContent().build();
//        } catch (ComponentValidationException e) {
//            return localizedErrorResponse(e);
//        } catch (IllegalArgumentException e) {
//            throw new BadRequestException();
//        }
//    }
//
//    @DELETE
//    @Path("{id}")
//    public void removeComponent(@PathParam("id") String id) {
//        auth.requireManage();
//        ComponentModel model = organization.getComponent(id);
//        if (model == null) {
//            throw new org.jboss.resteasy.spi.NotFoundException("Could not find component");
//        }
//        adminEvent.operation(OperationType.DELETE).resourcePath(uriInfo, model.getId()).success();
//        organization.removeComponent(model);
//
//    }
//
//    private Response localizedErrorResponse(ComponentValidationException cve) {
//        Properties messages = AdminRoot.getMessages(session, organization, "en"/*auth.getAuth().getToken().getLocale()*/, "admin-messages", "messages");
//
//        Object[] localizedParameters = cve.getParameters()==null ? null : Arrays.asList(cve.getParameters()).stream().map((Object parameter) -> {
//
//            if (parameter instanceof String) {
//                String paramStr = (String) parameter;
//                return messages.getProperty(paramStr, paramStr);
//            } else {
//                return parameter;
//            }
//
//        }).toArray();
//
//        String message = MessageFormat.format(messages.getProperty(cve.getMessage(), cve.getMessage()), localizedParameters);
//        return ErrorResponse.error(message, Response.Status.BAD_REQUEST);
//    }
//
//    /**
//     * List of subcomponent types that are available to configure for a particular parent component.
//     *
//     * @param parentId
//     * @param subtype
//     * @return
//     */
//    @GET
//    @Path("{id}/sub-component-types")
//    @Produces(MediaType.APPLICATION_JSON)
//    @NoCache
//    public List<ComponentTypeRepresentation> getSubcomponentConfig(@PathParam("id") String parentId, @QueryParam("type") String subtype) {
//        auth.requireView();
//        ComponentModel parent = organization.getComponent(parentId);
//        if (parent == null) {
//            throw new org.jboss.resteasy.spi.NotFoundException("Could not find parent component");
//        }
//        if (subtype == null) {
//            throw new BadRequestException("must specify a subtype");
//        }
//        Class<? extends Provider> providerClass = null;
//        try {
//            providerClass = (Class<? extends Provider>)Class.forName(subtype);
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//        List<ComponentTypeRepresentation> subcomponents = new LinkedList<>();
//        for (ProviderFactory factory : session.getOpenfactSessionFactory().getProviderFactories(providerClass)) {
//            ComponentTypeRepresentation rep = new ComponentTypeRepresentation();
//            rep.setId(factory.getId());
//            if (!(factory instanceof ComponentFactory)) {
//                continue;
//            }
//            ComponentFactory componentFactory = (ComponentFactory)factory;
//
//            rep.setHelpText(componentFactory.getHelpText());
//            List<ProviderConfigProperty> props = null;
//            Map<String, Object> metadata = null;
//            if (factory instanceof SubComponentFactory) {
//                props = ((SubComponentFactory)factory).getConfigProperties(organization, parent);
//                metadata = ((SubComponentFactory)factory).getTypeMetadata(organization, parent);
//
//            } else {
//                props = componentFactory.getConfigProperties();
//                metadata = componentFactory.getTypeMetadata();
//            }
//
//            List<ConfigPropertyRepresentation> propReps =  ModelToRepresentation.toRepresentation(props);
//            rep.setProperties(propReps);
//            rep.setMetadata(metadata);
//            subcomponents.add(rep);
//        }
//        return subcomponents;
//    }

}
