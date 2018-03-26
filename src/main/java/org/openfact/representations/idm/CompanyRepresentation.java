package org.openfact.representations.idm;

import javax.validation.constraints.NotNull;

public class CompanyRepresentation {

    private String id;
    private String name;
    private String description;

    @NotNull
    private CompanyOwnerRepresentation owner;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CompanyOwnerRepresentation getOwner() {
        return owner;
    }

    public void setOwner(CompanyOwnerRepresentation owner) {
        this.owner = owner;
    }

    public static class CompanyOwnerRepresentation {

        @NotNull
        private String id;
        private String identityId;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getIdentityId() {
            return identityId;
        }

        public void setIdentityId(String identityId) {
            this.identityId = identityId;
        }
    }
}
