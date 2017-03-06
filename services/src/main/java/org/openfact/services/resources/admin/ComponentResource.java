package org.openfact.services.resources.admin;


import org.jboss.logging.Logger;
import org.jboss.resteasy.annotations.cache.NoCache;
import org.openfact.common.OpenfactClientConnection;
import org.openfact.events.admin.OperationType;
import org.openfact.models.ComponentProvider;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.component.ComponentModel;
import org.openfact.models.component.ComponentValidationException;
import org.openfact.models.utils.ComponentUtil;
import org.openfact.models.utils.ModelToRepresentation;
import org.openfact.models.utils.RepresentationToModel;
import org.openfact.models.utils.StripSecretsUtils;
import org.openfact.representations.idm.ComponentRepresentation;
import org.openfact.representations.idm.ComponentTypeRepresentation;
import org.openfact.services.ErrorResponse;
import org.openfact.services.managers.OrganizationManager;
import org.openfact.services.resource.security.OrganizationAuth;
import org.openfact.services.resource.security.SecurityContextProvider;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Stateless
@Path("/admin/organizations/{organization}/components")
public class ComponentResource {

    protected static final Logger logger = Logger.getLogger(ComponentResource.class);

    @Context
    protected UriInfo uriInfo;

    @Context
    protected HttpHeaders headers;

    @Context
    protected OpenfactSession session;

    @Context
    protected OpenfactClientConnection clientConnection;

    @Inject
    private AdminEventBuilder adminEvent;

    @Inject
    private SecurityContextProvider securityContext;

    @Inject
    private OrganizationManager organizationManager;

    @Inject
    private ComponentProvider componentProvider;

    @Inject
    private ComponentUtil componentUtil;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ComponentRepresentation> getComponents(@PathParam("organization") String organizationName,
                                                       @QueryParam("parent") String parent,
                                                       @QueryParam("type") String type) {
        OrganizationModel organization = AdminUtil.initOrganization(organizationName, organizationManager);
        OrganizationAuth auth = AdminUtil.initAuth(session, securityContext, organizationManager, organization);

        auth.requireView();

        List<ComponentModel> components = Collections.EMPTY_LIST;
        if (parent == null && type == null) {
            components = componentProvider.getComponents(organization);
        } else if (type == null) {
            components = componentProvider.getComponents(organization, parent);
        } else if (parent == null) {
            components = componentProvider.getComponents(organization, organization.getId(), type);
        } else {
            components = componentProvider.getComponents(organization, parent, type);
        }
        List<ComponentRepresentation> reps = new LinkedList<>();
        for (ComponentModel component : components) {
            ComponentRepresentation rep = ModelToRepresentation.toRepresentation(component, false, componentUtil);
            reps.add(rep);
        }
        return reps;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(@PathParam("organization") String organizationName, ComponentRepresentation rep) {
        OrganizationModel organization = AdminUtil.initOrganization(organizationName, organizationManager);
        OrganizationAuth auth = AdminUtil.initAuth(session, securityContext, organizationManager, organization);

        auth.requireManage();
        try {
            ComponentModel model = RepresentationToModel.toModel(rep);
            if (model.getParentId() == null) model.setParentId(organization.getId());

            model = componentProvider.addComponentModel(organization, model);

            AdminUtil.initAdminEvent(adminEvent, organization, securityContext.getClientUser(session), clientConnection)
                    .operation(OperationType.CREATE)
                    .resourcePath(uriInfo, model.getId())
                    .representation(StripSecretsUtils.strip(componentUtil, rep))
                    .success();
            return Response.created(uriInfo.getAbsolutePathBuilder().path(model.getId()).build()).build();
        } catch (ComponentValidationException e) {
            return ErrorResponse.error("Component validation exception", Response.Status.BAD_REQUEST);
        } catch (IllegalArgumentException e) {
            throw new BadRequestException(e);
        }
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @NoCache
    public ComponentRepresentation getComponent(@PathParam("organization") String organizationName,
                                                @PathParam("id") String id) {
        OrganizationModel organization = AdminUtil.initOrganization(organizationName, organizationManager);
        OrganizationAuth auth = AdminUtil.initAuth(session, securityContext, organizationManager, organization);

        auth.requireView();
        ComponentModel model = componentProvider.getComponent(organization, id);
        if (model == null) {
            throw new NotFoundException("Could not find component");
        }
        ComponentRepresentation rep = ModelToRepresentation.toRepresentation(model, false, componentUtil);
        return rep;
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateComponent(@PathParam("organization") String organizationName,
                                    @PathParam("id") String id, ComponentRepresentation rep) {
        OrganizationModel organization = AdminUtil.initOrganization(organizationName, organizationManager);
        OrganizationAuth auth = AdminUtil.initAuth(session, securityContext, organizationManager, organization);

        auth.requireManage();
        try {
            ComponentModel model = componentProvider.getComponent(organization, id);
            if (model == null) {
                throw new NotFoundException("Could not find component");
            }
            RepresentationToModel.updateComponent(rep, model, false, componentUtil);
            AdminUtil.initAdminEvent(adminEvent, organization, securityContext.getClientUser(session), clientConnection)
                    .operation(OperationType.UPDATE)
                    .resourcePath(uriInfo, model.getId())
                    .representation(StripSecretsUtils.strip(componentUtil, rep))
                    .success();
            componentProvider.updateComponent(organization, model);
            return Response.noContent().build();
        } catch (ComponentValidationException e) {
            return ErrorResponse.error("Component validation exception", Response.Status.BAD_REQUEST);
        } catch (IllegalArgumentException e) {
            throw new BadRequestException();
        }
    }

    @DELETE
    @Path("{id}")
    public void removeComponent(@PathParam("organization") String organizationName,
                                @PathParam("id") String id) {
        OrganizationModel organization = AdminUtil.initOrganization(organizationName, organizationManager);
        OrganizationAuth auth = AdminUtil.initAuth(session, securityContext, organizationManager, organization);

        auth.requireManage();
        ComponentModel model = componentProvider.getComponent(organization, id);
        if (model == null) {
            throw new NotFoundException("Could not find component");
        }
        AdminUtil.initAdminEvent(adminEvent, organization, securityContext.getClientUser(session), clientConnection)
                .operation(OperationType.DELETE)
                .resourcePath(uriInfo, model.getId())
                .success();
        componentProvider.removeComponent(organization, model);
    }

    /**
     * List of subcomponent types that are available to configure for a particular parent component.
     *
     * @param parentId
     * @param subtype
     * @return
     */
    @GET
    @Path("{id}/sub-component-types")
    @Produces(MediaType.APPLICATION_JSON)
    @NoCache
    public List<ComponentTypeRepresentation> getSubcomponentConfig(@PathParam("organization") String organizationName,
                                                                   @PathParam("id") String parentId,
                                                                   @QueryParam("type") String subtype) {
        /*OrganizationModel organization = AdminUtil.initOrganization(organizationName, organizationManager);
        OrganizationAuth auth = AdminUtil.initAuth(session, securityContext, organizationManager, organization);

        auth.requireView();
        ComponentModel parent = componentProvider.getComponent(organization, parentId);
        if (parent == null) {
            throw new NotFoundException("Could not find parent component");
        }
        if (subtype == null) {
            throw new BadRequestException("must specify a subtype");
        }
        Class<?> providerClass = null;
        try {
            providerClass = Class.forName(subtype);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        List<ComponentTypeRepresentation> subcomponents = new LinkedList<>();
        for (ProviderFactory factory : session.getOpenfactSessionFactory().getProviderFactories(providerClass)) {
            ComponentTypeRepresentation rep = new ComponentTypeRepresentation();
            rep.setId(factory.getId());
            if (!(factory instanceof ComponentFactory)) {
                continue;
            }
            ComponentFactory componentFactory = (ComponentFactory) factory;

            rep.setHelpText(componentFactory.getHelpText());
            List<ProviderConfigProperty> props = null;
            Map<String, Object> metadata = null;
            if (factory instanceof SubComponentFactory) {
                props = ((SubComponentFactory) factory).getConfigProperties(organization, parent);
                metadata = ((SubComponentFactory) factory).getTypeMetadata(organization, parent);

            } else {
                props = componentFactory.getConfigProperties();
                metadata = componentFactory.getTypeMetadata();
            }

            List<ConfigPropertyRepresentation> propReps = ModelToRepresentation.toRepresentation(props);
            rep.setProperties(propReps);
            rep.setMetadata(metadata);
            subcomponents.add(rep);
        }
        return subcomponents;*/
        return null;
    }


}
