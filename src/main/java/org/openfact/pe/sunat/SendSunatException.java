package org.openfact.pe.sunat;

public class SendSunatException extends Exception {

    private final String message;

    public SendSunatException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
