package org.openfact.actions;

import org.jboss.resteasy.spi.HttpRequest;
import org.openfact.common.ClientConnection;
import org.openfact.events.EventBuilder;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.UserModel;
import org.openfact.models.InvoiceModel;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

/**
 * Interface that encapsulates current information about the current required action
 *
 */
public interface RequiredActionContext {
    public static enum Status {
        CHALLENGE,
        SUCCESS,
        IGNORE,
        FAILURE
    }

    /**
     * Get the action URL for the required action.
     *
     * @param code client sessino access code
     * @return
     */
    URI getActionUrl(String code);

    /**
     * Get the action URL for the required action.  This auto-generates the access code.
     *
     * @return
     */
    URI getActionUrl();

    /**
     * Create a Freemarker form builder that presets the user, action URI, and a generated access code
     *
     * @return
     */
    //LoginFormsProvider form();


    /**
     * If challenge has been sent this returns the JAX-RS Response
     *
     * @return
     */
    Response getChallenge();


    /**
     * Current event builder being used
     *
     * @return
     */
    EventBuilder getEvent();

    /**
     * Current user
     *
     * @return
     */
    UserModel getUser();
    OrganizationModel getOrganization();
    InvoiceModel getInvoice();
    //ClientSessionModel getClientSession();
    //UserSessionModel getUserSession();
    ClientConnection getConnection();
    UriInfo getUriInfo();
    OpenfactSession getSession();
    HttpRequest getHttpRequest();

    /**
     * Generates access code and updates clientsession timestamp
     * Access codes must be included in form action callbacks as a query parameter.
     *
     * @return
     */
    String generateCode();

    Status getStatus();

    /**
     * Send a challenge Response back to user
     *
     * @param response
     */
    void challenge(Response response);

    /**
     * Abort the authentication with an error
     *
     */
    void failure();

    /**
     * Mark this required action as successful.  The required action will be removed from the UserModel
     *
     */
    void success();

    /**
     * Ignore this required action and go onto the next, or complete the flow.
     *
     */
    void ignore();

}
