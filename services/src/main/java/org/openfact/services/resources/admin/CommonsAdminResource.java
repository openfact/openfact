package org.openfact.services.resources.admin;

import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.openfact.models.OpenfactSession;

/**
 * @author carlosthe19916@sistcoop.com
 */
@Produces(MediaType.APPLICATION_JSON)
public class CommonsAdminResource {

    @Context
    private OpenfactSession session;

    public CommonsAdminResource(AdminAuth auth) {
        // TODO Auto-generated constructor stub
    }

}
