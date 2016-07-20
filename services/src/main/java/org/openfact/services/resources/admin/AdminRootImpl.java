package org.openfact.services.resources.admin;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.jboss.logging.Logger;
import org.jboss.resteasy.spi.HttpRequest;
import org.jboss.resteasy.spi.HttpResponse;
import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.openfact.models.OrganizationModel;
import org.openfact.models.RepeidSession;
import org.openfact.services.managers.OrganizationManager;
import org.openfact.services.resources.admin.AdminConsole;
import org.openfact.services.resources.admin.AdminRoot;
import org.openfact.services.resources.admin.CommonsAdminResource;
import org.openfact.services.resources.admin.OrganizationsAdminResource;
import org.openfact.services.resources.admin.info.ServerInfoAdminResource;

public class AdminRootImpl implements AdminRoot {

	private static final Logger logger = Logger.getLogger(AdminRootImpl.class);


    @Context
    protected UriInfo uriInfo;

    @Context
    protected HttpRequest request;

    @Context
    protected HttpResponse response;

    // protected AppAuthManager authManager;
    // protected TokenManager tokenManager;

    @Context
    protected RepeidSession session;

    public AdminRootImpl() {
        // this.tokenManager = new TokenManager();
        // this.authManager = new AppAuthManager();
    }

    @Override
    public Response masterOrganizationAdminConsoleRedirect() {
        OrganizationModel master = new OrganizationManager(session).getRepeidAdminstrationRealm();
        return Response.status(302).location(uriInfo.getBaseUriBuilder().path(AdminRoot.class)
                .path(AdminRoot.class, "getAdminConsole").path("/").build(master.getName())).build();
    }

    @Override
    public Response masterOrganizationAdminConsoleRedirectHtml() {
        return masterOrganizationAdminConsoleRedirect();
    }

    protected OrganizationModel locateOrganization(String name, OrganizationManager organizationManager) {
        OrganizationModel organization = organizationManager.getOrganizationByName(name);
        if (organization == null) {
            throw new NotFoundException("Organization not found. Did you type in a bad URL?");
        }
        return organization;
    }

    @Override
    public AdminConsole getAdminConsole(String name) {
        OrganizationManager organizationManager = new OrganizationManager(session);
        OrganizationModel organization = locateOrganization(name, organizationManager);
        AdminConsole service = new AdminConsoleImpl(organization);
        ResteasyProviderFactory.getInstance().injectProperties(service);
        return service;
    }

    @Override
    public OrganizationsAdminResource getOrganizationsAdmin(HttpHeaders headers) {
        OrganizationsAdminResource adminResource = new OrganizationsAdminResourceImpl();
        ResteasyProviderFactory.getInstance().injectProperties(adminResource);
        return adminResource;
    }

    @Override
    public CommonsAdminResource getCommonsResource(HttpHeaders headers) {
        CommonsAdminResource commonsResource = new CommonsAdminResourceImpl();
        ResteasyProviderFactory.getInstance().injectProperties(commonsResource);
        return commonsResource;
    }

    @Override
    public ServerInfoAdminResource getServerInfo(HttpHeaders headers) {
        ServerInfoAdminResource adminResource = new ServerInfoAdminResourceImpl();
        ResteasyProviderFactory.getInstance().injectProperties(adminResource);
        return adminResource;
    }
    
    public static UriBuilder adminBaseUrl(UriInfo uriInfo) {
        return adminBaseUrl(uriInfo.getBaseUriBuilder());
    }

    public static UriBuilder adminBaseUrl(UriBuilder base) {
        return base.path(AdminRoot.class);
    }
    
    public static UriBuilder organizationUrl(UriInfo uriInfo) {
        return organizationUrl(uriInfo.getBaseUriBuilder());
    }

    public static UriBuilder organizationUrl(UriBuilder base) {
        return adminBaseUrl(base).path(AdminRoot.class, "getOrganizationsAdmin");
    }

}
