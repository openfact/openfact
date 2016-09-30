package org.openfact.ubl.send;

public class UblSenderException extends Exception {

    public UblSenderException(Throwable cause) {
        super(cause);
    }

    public UblSenderException(String message, Throwable cause) {
        super(message, cause);
    }
}
