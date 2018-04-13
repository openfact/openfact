package org.openfact.pe;

import org.openfact.pe.idm.OrganizacionInformacionAdicionalRepresentation;
import org.openfact.pe.idm.OrganizacionInformacionSUNATRepresentation;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/organizations/{organizationId}/peru")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface OrganizacionesResource {

    @GET
    @Path("/informacion-adicional")
    OrganizacionInformacionAdicionalRepresentation getOrganization(
            @PathParam("organizationId") String organizationId
    );

    @PUT
    @Path("/informacion-adicional")
    OrganizacionInformacionAdicionalRepresentation updateOrganizationInformacionAdicional(
            @PathParam("organizationId") String organizationId,
            @Valid OrganizacionInformacionAdicionalRepresentation rep
    );

    @GET
    @Path("/informacion-sunat")
    OrganizacionInformacionSUNATRepresentation getOrganizationInformacionSUNAT(
            @PathParam("organizationId") String organizationId
    );

    @PUT
    @Path("/informacion-sunat")
    OrganizacionInformacionSUNATRepresentation updateOrganizationInformacionSUNAT(
            @PathParam("organizationId") String organizationId,
            @Valid OrganizacionInformacionSUNATRepresentation rep
    );

}
