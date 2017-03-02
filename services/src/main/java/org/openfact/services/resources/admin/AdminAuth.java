package org.openfact.services.resources.admin;

import org.openfact.models.OrganizationModel;

public class AdminAuth {

    private final OrganizationModel organization;
    private final UserModel user;

    public AdminAuth(OrganizationModel organization, UserModel user) {
        this.organization = organization;
        this.user = user;
    }

    public OrganizationModel getOrganization() {
        return organization;
    }

    public UserModel getUser() {
        return user;
    }

    public boolean hasOrganizationRole(String role) {
        return user.hasRole(role);
    }

    public boolean hasOneOfOrganizationRole(String... roles) {
        for (String r : roles) {
            if (hasOrganizationRole(r)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasAppRole(String role) {
        return user.hasRole(role);
    }

    public boolean hasOneOfAppRole(String... roles) {
        for (String r : roles) {
            if (hasAppRole(r)) {
                return true;
            }
        }
        return false;
    }

}
