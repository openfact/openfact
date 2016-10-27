package org.openfact.services.resources.admin;

import org.openfact.models.AdminRoles;
import org.openfact.services.ForbiddenException;

public class OrganizationAuth {

    public enum Resource {
        ORGANIZATION, INVOICE, CREDIT_NOTE, DEBIT_NOTE, EVENTS, CODE_CATALOG
    }

    private Resource resource;
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
        if (!auth.hasOneOfAppRole(AdminRoles.ALL_ORGANIZATION_ROLES)) {
            throw new ForbiddenException();
        }
    }

    public boolean hasView() {
        return auth.hasOneOfAppRole(getViewRole(resource), getManageRole(resource));
    }

    public boolean hasManage() {
        return auth.hasOneOfAppRole(getManageRole(resource));
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
        case ORGANIZATION:
            return AdminRoles.VIEW_ORGANIZATION;
        case INVOICE:
            return AdminRoles.VIEW_INVOICES;
        case CREDIT_NOTE:
            return AdminRoles.VIEW_CREDIT_NOTES;
        case DEBIT_NOTE:
            return AdminRoles.VIEW_DEBIT_NOTES;
        case EVENTS:
            return AdminRoles.VIEW_EVENTS;
        default:
            throw new IllegalStateException();
        }
    }

    private String getManageRole(Resource resource) {
        switch (resource) {
        case ORGANIZATION:
            return AdminRoles.MANAGE_ORGANIZATION;
        case INVOICE:
            return AdminRoles.MANAGE_INVOICES;
        case CREDIT_NOTE:
            return AdminRoles.MANAGE_CREDIT_NOTES;
        case DEBIT_NOTE:
            return AdminRoles.MANAGE_DEBIT_NOTES;
        case EVENTS:
            return AdminRoles.MANAGE_EVENTS;
        default:
            throw new IllegalStateException();
        }
    }

}
