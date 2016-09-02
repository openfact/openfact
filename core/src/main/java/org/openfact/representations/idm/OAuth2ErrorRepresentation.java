package org.openfact.representations.idm;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.openfact.OAuth2Constants;

public class OAuth2ErrorRepresentation {
	private String error;
    private String errorDescription;

    public OAuth2ErrorRepresentation() {
    }

    public OAuth2ErrorRepresentation(String error, String errorDescription) {
        this.error = error;
        this.errorDescription = errorDescription;
    }

    @JsonProperty(OAuth2Constants.ERROR)
    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @JsonProperty(OAuth2Constants.ERROR_DESCRIPTION)
    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }
}
