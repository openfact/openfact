package org.openfact;

import org.openfact.representations.idm.ServerInfoRepresentation;
import org.openfact.representations.idm.UserRepresentation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("serverinfo")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface ServerInfoResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    ServerInfoRepresentation getInfo() ;

}
