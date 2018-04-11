package org.openfact.core;

import org.keycloak.representations.idm.KeysMetadataRepresentation;
import org.openfact.core.idm.ComponentRepresentation;
import org.openfact.core.idm.OrganizationRepresentation;
import org.openfact.core.idm.OrganizationSearchQueryRepresentation;
import org.openfact.core.idm.OrganizationSearchResultRepresentation;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("organizations")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface OrganizationsResource {

    @POST
    @Path("/")
    OrganizationRepresentation createOrganization(@Valid OrganizationRepresentation organizationRepresentation);

    @GET
    @Path("/")
    List<OrganizationRepresentation> getOrganizations(
            @QueryParam("organizationId") String organizationId,
            @QueryParam("userId") String userId,
            @QueryParam("role") @DefaultValue("owner") String role);

    @POST
    @Path("/search")
    OrganizationSearchResultRepresentation searchOrganizations(@Valid OrganizationSearchQueryRepresentation organizationQuery);


    @GET
    @Path("/{organizationId}")
    OrganizationRepresentation getOrganization(
            @PathParam("organizationId") String organizationId
    );

    @PUT
    @Path("/{organizationId}")
    OrganizationRepresentation updateOrganization(
            @PathParam("organizationId") String organizationId,
            OrganizationRepresentation rep
    );

    @DELETE
    @Path("/{organizationId}")
    void deleteOrganization(
            @PathParam("organizationId") String organizationId
    );

    @GET
    @Path("/{organizationId}/keys")
    @Produces(MediaType.APPLICATION_JSON)
    KeysMetadataRepresentation getKeyMetadata(
            @PathParam("organizationId") final String organizationId
    );

    @GET
    @Path("/{organizationId}/components")
    @Produces(MediaType.APPLICATION_JSON)
    List<ComponentRepresentation> getComponents(
            @PathParam("organizationId") final String organizationId,
            @QueryParam("parent") String parent,
            @QueryParam("type") String type
    );

    @POST
    @Path("/{organizationId}/components")
    @Consumes(MediaType.APPLICATION_JSON)
    Response createComponent(
            @PathParam("organizationId") final String organizationId, ComponentRepresentation rep
    );

    @GET
    @Path("/{organizationId}/components/{componentId}")
    @Produces(MediaType.APPLICATION_JSON)
    ComponentRepresentation getComponent(
            @PathParam("organizationId") final String organizationId,
            @PathParam("componentId") String componentId
    );

    @PUT
    @Path("/{organizationId}/components/{componentId}")
    @Consumes(MediaType.APPLICATION_JSON)
    Response updateComponent(
            @PathParam("organizationId") final String organizationId,
            @PathParam("componentId") String componentId, ComponentRepresentation rep
    );

    @DELETE
    @Path("/{organizationId}/components/{componentId}")
    void removeComponent(
            @PathParam("organizationId") final String organizationId,
            @PathParam("componentId") String componentId
    );

}
