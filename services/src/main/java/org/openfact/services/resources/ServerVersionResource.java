package org.openfact.services.resources;

import org.openfact.representations.VersionRepresentation;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Stateless
@Path("/version")
public class ServerVersionResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public VersionRepresentation getVersion() {
        return VersionRepresentation.SINGLETON;
    }

}
