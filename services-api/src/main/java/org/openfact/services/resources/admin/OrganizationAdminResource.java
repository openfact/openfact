package org.openfact.services.resources.admin;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.cache.NoCache;
import org.openfact.representations.idm.OrganizationRepresentation;

/**
 * @author carlosthe19916@sistcoop.com
 */
public interface OrganizationAdminResource {

    /**
     * Get the organization with the specified organization name.
     *
     * @return The organization with the specified name
     * @summary Get the organization with the specified name
     */
    @GET
    @NoCache
    @Produces(MediaType.APPLICATION_JSON)
    OrganizationRepresentation getOrganization();

    /**
     * Update organization information.
     *
     * @param rep
     *            The representation of the organization to be changed
     * @return Generic Response object
     * @summary Update organization information
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    Response updateOrganization(final OrganizationRepresentation rep);

    /**
     * Deletes organization with given name.
     *
     * @throws AuthorizationException
     *             The user is not authorized to delete this organization.
     */
    @DELETE
    void deleteOrganization();

    /**
     * Get the invoices sub resource for the current organization
     */
    @Path("invoices")
    InvoicesAdminResource invoices();

    /**
     * Get the invoices sub resource for the current organization
     */
    @Path("credit-notes")
    CreditNotesAdminResource creditNotes();

    /**
     * Get the invoices sub resource for the current organization
     */
    @Path("debit-notes")
    DebitNotesAdminResource debitNotes();

}
