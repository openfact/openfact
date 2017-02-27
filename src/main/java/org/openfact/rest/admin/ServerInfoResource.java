package org.openfact.rest.admin;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

@Path("/server-info")
public class ServerInfoResource {

	@GET
	@Produces("text/plain")
	public Response doGet() {
		return Response.ok("method doGet invoked").build();
	}
}