package org.openfact.services.resources.admin.ubl;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.cache.NoCache;
import org.openfact.representations.idm.ubl.InvoiceLineRepresentation;
import org.openfact.representations.idm.ubl.InvoiceRepresentation;

/**
 * @author carlosthe19916@sistcoop.com
 */
public interface InvoiceAdminResource {

    /**
     * Get the invoice with the specified invoiceId.
     *
     * @return The invoice with the specified invoiceId
     * @summary Get the invoice with the specified invoiceId
     */
    @GET
    @NoCache
    @Produces(MediaType.APPLICATION_JSON)
    InvoiceRepresentation getInvoice();

    @GET
    @Path("invoiceLines")
    @Produces(MediaType.APPLICATION_JSON)
    List<InvoiceLineRepresentation> getInvoiceLines();  

}
