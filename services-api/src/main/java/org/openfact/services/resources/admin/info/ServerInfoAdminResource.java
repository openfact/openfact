package org.openfact.services.resources.admin.info;

import javax.ws.rs.GET;

import org.openfact.representations.info.ServerInfoRepresentation;

public interface ServerInfoAdminResource {

	@GET
	ServerInfoRepresentation getInfo();

}
