package org.openfact.services.managers;

import java.io.Serializable;

public class OrganizationTimer implements Serializable {

    private String organizationId;

    public OrganizationTimer(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrganizationTimer that = (OrganizationTimer) o;

        return organizationId.equals(that.organizationId);
    }

    @Override
    public int hashCode() {
        return organizationId.hashCode();
    }
}
