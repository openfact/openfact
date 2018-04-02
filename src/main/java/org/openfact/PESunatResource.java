package org.openfact;

import org.openfact.representations.idm.PESunatGenericTypeRepresentation;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/pe/sunat")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface PESunatResource {

    @GET
    @Path("/tipos-invoice")
    List<PESunatGenericTypeRepresentation> getTiposInvoice();

    @GET
    @Path("/tipos-documento-identidad")
    List<PESunatGenericTypeRepresentation> getTiposDocumentoIdentidad();

    @GET
    @Path("/tipos-afectacion-igv")
    List<PESunatGenericTypeRepresentation> getTipoAfectacionIgv();

    @GET
    @Path("/igv")
    PESunatGenericTypeRepresentation getIgv();

}
