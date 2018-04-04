package org.openfact.core;

import org.openfact.core.idm.ServerInfoRepresentation;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("serverinfo")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface ServerInfoResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    ServerInfoRepresentation getInfo() ;

}
