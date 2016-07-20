package org.openfact.services.resources;

import java.net.URISyntaxException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.openfact.utils.MediaType;

@Path("/")
public interface WelcomeResource {

	@GET
	@Produces(MediaType.TEXT_HTML_UTF_8)
	public Response getWelcomePage() throws URISyntaxException;

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response createUser(final MultivaluedMap<String, String> formData);

	@GET
	@Path("/welcome-content/{path}")
	@Produces(MediaType.TEXT_HTML_UTF_8)
	public Response getResource(@PathParam("path") String path);

}
