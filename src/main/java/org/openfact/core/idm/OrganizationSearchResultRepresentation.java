package org.openfact.core.idm;

import java.util.List;

public class OrganizationSearchResultRepresentation {

    private OrganizationRepresentation master;
    private List<OrganizationRepresentation> owned;
    private List<OrganizationRepresentation> collaborated;

    public OrganizationRepresentation getMaster() {
        return master;
    }

    public void setMaster(OrganizationRepresentation master) {
        this.master = master;
    }

    public List<OrganizationRepresentation> getOwned() {
        return owned;
    }

    public void setOwned(List<OrganizationRepresentation> owned) {
        this.owned = owned;
    }

    public List<OrganizationRepresentation> getCollaborated() {
        return collaborated;
    }

    public void setCollaborated(List<OrganizationRepresentation> collaborated) {
        this.collaborated = collaborated;
    }
}
