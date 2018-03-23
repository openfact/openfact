package org.openfact.representations.idm;

public class CompanyRepresentation {

    private String id;
    private String name;
    private String description;
    private UserRepresentation owner;

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

    public UserRepresentation getOwner() {
        return owner;
    }

    public void setOwner(UserRepresentation owner) {
        this.owner = owner;
    }
}
