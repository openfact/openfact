package org.openfact.services.resources.admin;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import org.openfact.services.resources.admin.info.ServerInfoAdminResource;

/**
 * @author carlosthe19916@sistcoop.com
 */
@Path("/admin")
public interface AdminRoot {

    @GET
    Response masterOrganizationAdminConsoleRedirect();

    @GET
    @Path("index.{html:html}")
    Response masterOrganizationAdminConsoleRedirectHtml();

    @Path("{organization}/console")
    AdminConsole getAdminConsole(final @PathParam("organization") String name);

    @Path("organizations")
    OrganizationsAdminResource getOrganizationsAdmin(@Context final HttpHeaders headers);

    @Path("codes-catalog")
    CodesCatalogAdminResource getCodesCatalogResource(@Context final HttpHeaders headers);

    @Path("commons")
    CommonsAdminResource getCommonsResource(@Context final HttpHeaders headers);

    @Path("serverinfo")
    ServerInfoAdminResource getServerInfo(@Context final HttpHeaders headers);

}
