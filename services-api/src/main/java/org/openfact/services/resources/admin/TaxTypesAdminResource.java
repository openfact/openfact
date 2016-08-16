package org.openfact.services.resources.admin;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.cache.NoCache;
import org.openfact.representations.idm.TaxTypeRepresentation;

/**
 * @author carlosthe19916@sistcoop.com
 */
@Consumes(MediaType.APPLICATION_JSON)
public interface TaxTypesAdminResource {

    /**
     * @param taxTypeId
     *            The invoiceId of the invoice
     */
    @Path("{taxTypeId}")
    TaxTypeAdminResource getTaxTypeAdmin(@PathParam("taxTypeId") final String taxTypeId);

    @GET
    @NoCache
    @Produces(MediaType.APPLICATION_JSON)
    List<TaxTypeRepresentation> getTaxTypes();

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    Response createTaxType(@Valid final TaxTypeRepresentation rep);

}
