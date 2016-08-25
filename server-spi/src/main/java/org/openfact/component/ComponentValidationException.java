package org.openfact.component;

public class ComponentValidationException extends RuntimeException {
    
    public ComponentValidationException() {
    
    }

    public ComponentValidationException(String message) {
        super(message);
    }

    public ComponentValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ComponentValidationException(Throwable cause) {
        super(cause);
    }

    public ComponentValidationException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
