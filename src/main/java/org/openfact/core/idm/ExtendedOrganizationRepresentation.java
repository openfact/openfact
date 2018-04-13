package org.openfact.core.idm;

public class ExtendedOrganizationRepresentation extends OrganizationRepresentation {

    public ExtendedOrganizationRepresentation() {
        super();
    }

    public ExtendedOrganizationRepresentation(OrganizationRepresentation rep) {
        super(rep);
    }

    public enum UserRoleType {
        admin, owner, collaborator
    }

    private UserRoleType userRole;

    public UserRoleType getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRoleType userRole) {
        this.userRole = userRole;
    }

}
