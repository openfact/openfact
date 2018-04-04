package org.openfact.pe;

import org.openfact.pe.idm.SunatGenericTypePERepresentation;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/pe/sunat")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface SunatPEResource {

    @GET
    @Path("/tipos-invoice")
    List<SunatGenericTypePERepresentation> getTiposInvoice();

    @GET
    @Path("/tipos-documento-identidad")
    List<SunatGenericTypePERepresentation> getTiposDocumentoIdentidad();

    @GET
    @Path("/tipos-afectacion-igv")
    List<SunatGenericTypePERepresentation> getTipoAfectacionIgv();

    @GET
    @Path("/igv")
    SunatGenericTypePERepresentation getIgv();

}
