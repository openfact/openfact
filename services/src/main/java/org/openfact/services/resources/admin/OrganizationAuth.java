package org.openfact.services.resources.admin;


import org.openfact.models.AdminRoles;
import org.openfact.services.ForbiddenException;

public class OrganizationAuth {

    private Resource resource;

    public enum Resource {
        CLIENT,CERTIFIED, INVOICE, REALM, EVENTS, IDENTITY_PROVIDER, IMPERSONATION, AUTHORIZATION
    }

    private AdminAuth auth;

    public OrganizationAuth(AdminAuth auth) {
        this.auth = auth;
    }

    public OrganizationAuth init(Resource resource) {
        this.resource = resource;
        return this;
    }

    public AdminAuth getAuth() {
        return auth;
    }

    public void requireAny() {
        if (!auth.hasOneRole(AdminRoles.ALL_ORGANIZATION_ROLES)) {
            throw new ForbiddenException();
        }
    }

    public boolean hasView() {
        return auth.hasOneRole(getViewRole(resource), getManageRole(resource));
    }

    public boolean hasManage() {
        return auth.hasOneRole(getManageRole(resource));
    }

    public void requireView() {
        if (!hasView()) {
            throw new ForbiddenException();
        }
    }

    public void requireManage() {
        if (!hasManage()) {
            throw new ForbiddenException();
        }
    }

    private String getViewRole(Resource resource) {
        switch (resource) {
        /*case CLIENT:
            return AdminRoles.VIEW_CLIENTS;*/
        case INVOICE:
            return AdminRoles.VIEW_DOCUMENTS;
        case REALM:
            return AdminRoles.VIEW_ORGANIZATION;
        case CERTIFIED:
            return AdminRoles.VIEW_CERTIFIED;
        /*case EVENTS:
            return AdminRoles.VIEW_EVENTS;
        case IDENTITY_PROVIDER:
            return AdminRoles.VIEW_IDENTITY_PROVIDERS;*/
        /*case AUTHORIZATION:
            return AdminRoles.VIEW_AUTHORIZATION;*/
        default:
            throw new IllegalStateException();
        }
    }

    private String getManageRole(Resource resource) {
        switch (resource) {
        /*case CLIENT:
            return AdminRoles.MANAGE_CLIENTS;*/
        case INVOICE:
            return AdminRoles.MANAGE_DOCUMENT;
        case REALM:
            return AdminRoles.MANAGE_ORGANIZATION;
        case CERTIFIED:
            return AdminRoles.CREATE_CERTIFIED;
        /*case EVENTS:
            return AdminRoles.MANAGE_EVENTS;
        case IDENTITY_PROVIDER:
            return AdminRoles.MANAGE_IDENTITY_PROVIDERS;*/
        /*case IMPERSONATION:
            return ImpersonationConstants.IMPERSONATION_ROLE;
        case AUTHORIZATION:
            return AdminRoles.MANAGE_AUTHORIZATION;*/
        default:
            throw new IllegalStateException();
        }
    }

}
