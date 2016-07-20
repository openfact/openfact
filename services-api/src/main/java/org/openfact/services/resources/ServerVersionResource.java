package org.openfact.services.resources;

import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.cache.NoCache;
import org.openfact.representations.VersionRepresentation;

@Path("/version")
public interface ServerVersionResource {

    @OPTIONS
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVersionPreflight();

    @GET
    @NoCache
    @Produces(MediaType.APPLICATION_JSON)
    public VersionRepresentation getVersion();

}
