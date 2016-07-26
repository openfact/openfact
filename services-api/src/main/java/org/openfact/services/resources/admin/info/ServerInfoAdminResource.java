package org.openfact.services.resources.admin.info;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.openfact.representations.info.ServerInfoRepresentation;

/**
 * @author carlosthe19916@sistcoop.com
 */
public interface ServerInfoAdminResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	ServerInfoRepresentation getInfo();

}
