package org.openfact.services.resources.admin;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.cache.NoCache;

public interface AdminConsole {

	@GET
	@NoCache
	Response getMainPage() throws URISyntaxException, IOException;

	@GET
	@Path("{indexhtml: index.html}")
	Response getIndexHtmlRedirect();

}
