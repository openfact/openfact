package org.openfact.services.resources.admin;

import org.openfact.models.OrganizationModel;
import org.openfact.models.UserModel;

public class AdminAuth {

    private OrganizationModel organization;
    private UserModel user;

    public AdminAuth(OrganizationModel organization, UserModel user) {
        this.user = user;
        this.organization = organization;
    }

    public UserModel getUser() {
        return user;
    }

    public OrganizationModel getOrganization() {
        return organization;
    }

    public boolean hasOneRole(String... roles) {       
        return true;
    }

    public boolean hasAppRole(String role) {
        return true;
    }

    public boolean hasOrganizationRole(String role) {
        return true;
    }

}
