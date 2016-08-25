package org.openfact.email;

public class EmailException extends Exception {

    public EmailException(Throwable cause) {
        super(cause);
    }

    public EmailException(String message, Throwable cause) {
        super(message, cause);
    }

}
