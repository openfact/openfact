package org.openfact.core.models.files;

public class UnknownFileProviderTypeException extends RuntimeException {

    public UnknownFileProviderTypeException(String securityContextType) {
        super("Unknown security context type:" + securityContextType);
    }

}
