package org.openfact.services.resources.admin;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

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

public class ComponentResource {

    protected static final Logger logger = Logger.getLogger(ComponentResource.class);

    protected OrganizationModel organization;

    private OrganizationAuth auth;

    private AdminEventBuilder adminEvent;

    @Context
    protected ClientConnection clientConnection;

    @Context
    protected UriInfo uriInfo;

    @Context
    protected OpenfactSession session;

    @Context
    protected HttpHeaders headers;

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
