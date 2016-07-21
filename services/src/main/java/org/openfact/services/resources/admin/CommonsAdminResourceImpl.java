package org.openfact.services.resources.admin;

import javax.ws.rs.core.Context;

import org.openfact.models.OpenfactSession;

public class CommonsAdminResourceImpl implements CommonsAdminResource {

    @Context
    private OpenfactSession session;

    public CommonsAdminResourceImpl() {
        // TODO Auto-generated constructor stub
    }

}
