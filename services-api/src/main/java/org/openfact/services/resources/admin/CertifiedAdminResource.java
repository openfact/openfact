package org.openfact.services.resources.admin;

import org.jboss.resteasy.annotations.cache.NoCache;
import org.openfact.representations.idm.CertifiedRepresentation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Alex Pariona-"alexpariona@openfact.com" on 09/08/2016.
 */
public interface CertifiedAdminResource {
    /**
     * Get the certified with the specified certifiedId.
     *
     * @return The certified with the specified certifiedId
     * @summary Get the certified with the specified certifiedId
     */
    @GET
    @Path("/certified")
    @NoCache
    @Produces(MediaType.APPLICATION_JSON)
    CertifiedRepresentation getCertified();


    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    Response updateCertified(final CertifiedRepresentation rep);
}
