package org.openfact;

import org.keycloak.representations.idm.KeysMetadataRepresentation;
import org.openfact.representations.idm.CompanyRepresentation;
import org.openfact.representations.idm.ComponentRepresentation;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("companies")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface CompaniesResource {

    @POST
    @Path("/")
    CompanyRepresentation createCompany(@Valid CompanyRepresentation companyRepresentation);

    @GET
    @Path("/")
    List<CompanyRepresentation> getCompanies(
            @QueryParam("companyId") String companyId,
            @QueryParam("userId") String userId,
            @QueryParam("role") @DefaultValue("owner") String role);

    @GET
    @Path("/{companyId}")
    CompanyRepresentation getCompany(
            @PathParam("companyId") String companyId
    );

    @PUT
    @Path("/{companyId}")
    CompanyRepresentation updateCompany(
            @PathParam("companyId") String companyId,
            @Valid CompanyRepresentation rep
    );

    @DELETE
    @Path("/{companyId}")
    void deleteCompany(
            @PathParam("companyId") String companyId
    );

    @GET
    @Path("/{companyId}/keys")
    @Produces(MediaType.APPLICATION_JSON)
    KeysMetadataRepresentation getKeyMetadata(
            @PathParam("companyId") final String companyId
    );

    @GET
    @Path("/{companyId}/components")
    @Produces(MediaType.APPLICATION_JSON)
    List<ComponentRepresentation> getComponents(
            @PathParam("companyId") final String companyId,
            @QueryParam("parent") String parent,
            @QueryParam("type") String type
    );

    @POST
    @Path("/{companyId}/components")
    @Consumes(MediaType.APPLICATION_JSON)
    Response createComponent(
            @PathParam("companyId") final String companyId, ComponentRepresentation rep
    );

    @GET
    @Path("/{companyId}/components/{componentId}")
    @Produces(MediaType.APPLICATION_JSON)
    ComponentRepresentation getComponent(
            @PathParam("companyId") final String companyId,
            @PathParam("componentId") String componentId
    );

    @PUT
    @Path("/{companyId}/components/{componentId}")
    @Consumes(MediaType.APPLICATION_JSON)
    Response updateComponent(
            @PathParam("companyId") final String companyId,
            @PathParam("componentId") String componentId, ComponentRepresentation rep
    );

    @DELETE
    @Path("/{companyId}/components/{componentId}")
    void removeComponent(
            @PathParam("companyId") final String companyId,
            @PathParam("componentId") String componentId
    );

}
