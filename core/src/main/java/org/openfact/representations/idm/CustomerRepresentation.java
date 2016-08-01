package org.openfact.representations.idm;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CustomerRepresentation {

    private String id;

    // Ruc number
    @NotNull
    @Size(min = 1, max = 20)
    protected String assignedIdentificationId;

    // Document type
    @NotNull
    @Size(min = 1, max = 10)
    protected String additionalAccountId;

    // Nombre comercial
    @Size(min = 1, max = 200)
    protected String registrationName;

    @Size(min = 1, max = 160)
    protected String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAssignedIdentificationId() {
        return assignedIdentificationId;
    }

    public void setAssignedIdentificationId(String assignedIdentificationId) {
        this.assignedIdentificationId = assignedIdentificationId;
    }

    public String getAdditionalAccountId() {
        return additionalAccountId;
    }

    public void setAdditionalAccountId(String additionalAccountId) {
        this.additionalAccountId = additionalAccountId;
    }

    public String getRegistrationName() {
        return registrationName;
    }

    public void setRegistrationName(String registrationName) {
        this.registrationName = registrationName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
