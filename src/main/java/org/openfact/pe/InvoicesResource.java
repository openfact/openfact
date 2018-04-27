package org.openfact.pe;

import org.openfact.pe.representations.idm.InvoiceRepresentation;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/organizations/{organizationId}/pe/documentos/invoices")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface InvoicesResource {

    @GET
    @Path("/")
    List<InvoiceRepresentation> getInvoices(
            @PathParam("organizationId") String organizationId,
            @QueryParam("filterText") String filterText,
            @QueryParam("offset") @DefaultValue("0") int offset,
            @QueryParam("limit") @DefaultValue("10") int limit
    );

    @POST
    @Path("/")
    InvoiceRepresentation crearInvoice(
            @PathParam("organizationId") String organizationId,
            @QueryParam("async") @DefaultValue("true") Boolean async,
            @Valid InvoiceRepresentation rep
    );


    @GET
    @Path("/{documentId}")
    InvoiceRepresentation getInvoice(
            @PathParam("organizationId") String organizationId,
            @PathParam("documentId") String documentId
    );

    @PUT
    @Path("/{documentId}")
    InvoiceRepresentation actualizarInvoice(
            @PathParam("organizationId") String organizationId,
            @PathParam("documentId") String idDocumento,
            @QueryParam("async") @DefaultValue("true") Boolean async,
            @Valid InvoiceRepresentation rep
    );

    @DELETE
    @Path("/{documentId}")
    void eliminarInvoice(
            @PathParam("organizationId") String organizationId,
            @PathParam("documentId") String idDocumento
    );

}
