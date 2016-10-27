package org.openfact.representations.idm;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PublishedOrganizationRepresentation {

    protected String organization;

    @JsonProperty("public_key")
    protected String publicKeyPem;

    @JsonProperty("admin-api")
    protected String adminApiUrl;

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getPublicKeyPem() {
        return publicKeyPem;
    }

    public void setPublicKeyPem(String publicKeyPem) {
        this.publicKeyPem = publicKeyPem;
    }

    public String getAdminApiUrl() {
        return adminApiUrl;
    }

    public void setAdminApiUrl(String adminApiUrl) {
        this.adminApiUrl = adminApiUrl;
    }

}
