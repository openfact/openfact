package org.openfact.core.idm;

import javax.validation.constraints.NotNull;

public class OrganizationSearchQueryRepresentation {

    @NotNull
    private String userId;

    private ExtendedOrganizationRepresentation.UserRoleType userRole;
    private Integer offset;
    private Integer limit;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public ExtendedOrganizationRepresentation.UserRoleType getUserRole() {
        return userRole;
    }

    public void setUserRole(ExtendedOrganizationRepresentation.UserRoleType userRole) {
        this.userRole = userRole;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

}
