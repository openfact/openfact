package org.openfact.services.resources;

import java.net.URISyntaxException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.openfact.utils.MediaType;

/**
 * @author carlosthe19916@sistcoop.com
 */
@Path("/")
public interface WelcomeResource {

    /**
     * @throws URISyntaxException on internal error.
     */
    @GET
    @Produces(MediaType.TEXT_HTML_UTF_8)
    public Response getWelcomePage() throws URISyntaxException;

    @GET
    @Path("/welcome-content/{path}")
    @Produces(MediaType.TEXT_HTML_UTF_8)
    public Response getResource(@PathParam("path") String path);
    
}
