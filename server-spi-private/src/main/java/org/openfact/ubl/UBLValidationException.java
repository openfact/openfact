package org.openfact.ubl;

public class UBLValidationException extends RuntimeException {

    private Object[] parameters;

    public UBLValidationException() {
    }

    public UBLValidationException(String message, Object... parameters) {
        super(message);
        this.parameters = parameters;
    }

    public UBLValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public UBLValidationException(Throwable cause) {
        super(cause);
    }

    public UBLValidationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }
}
