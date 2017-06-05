package org.sistcoop.admin.client.resource;

import org.openfact.representations.idm.DocumentRepresentation;
import org.openfact.representations.idm.SendEventRepresentation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface DocumentResource {

    @GET
    DocumentRepresentation toRepresentation();

    @PUT
    void update(DocumentRepresentation documentRepresentation);

    @DELETE
    void remove();

    @Path("report")
    @GET
    Response report();

    @GET
    @Path("representation/xml")
    @Produces("application/xml")
    Response getXml();

    @POST
    @Path("send-to-customer")
    void sendToCustomer();

    @POST
    @Path("send-to-third-party")
    void sendToThirdParty();

    @POST
    @Path("send-to-third-party-by-email")
    void sendToThirdPartyByEmail();

    @GET
    @Path("send-events")
    List<SendEventRepresentation> getSendEvents(@QueryParam("destinyType") String destinyType,
                                                @QueryParam("result") String result,
                                                @QueryParam("first") Integer firstResult,
                                                @QueryParam("max") Integer maxResults);

}
