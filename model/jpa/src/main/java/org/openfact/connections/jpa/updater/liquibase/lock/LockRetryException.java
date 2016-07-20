package org.openfact.connections.jpa.updater.liquibase.lock;

public class LockRetryException extends RuntimeException {

    public LockRetryException(String message) {
        super(message);
    }

    public LockRetryException(Throwable cause) {
        super(cause);
    }

    public LockRetryException(String message, Throwable cause) {
        super(message, cause);
    }

}
