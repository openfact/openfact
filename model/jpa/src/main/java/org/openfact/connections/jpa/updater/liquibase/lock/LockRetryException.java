package org.openfact.connections.jpa.updater.liquibase.lock;

/**
 * Indicates that retrieve lock wasn't successful, but it worth to retry it in different transaction (For example if we were trying to create LOCK table, but other transaction
 * created the table in the meantime etc)
 */
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
