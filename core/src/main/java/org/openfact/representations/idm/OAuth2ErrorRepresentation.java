package org.openfact.representations.idm;

public class OAuth2ErrorRepresentation {

    private String error;
    private String errorDescription;

    public OAuth2ErrorRepresentation() {
    }

    public OAuth2ErrorRepresentation(String error, String errorDescription) {
        this.error = error;
        this.errorDescription = errorDescription;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }
}