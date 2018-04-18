package org.openfact.pe.models;

public class ModelReadOnlyException extends RuntimeException {

    public ModelReadOnlyException() {
        super();
    }

    public ModelReadOnlyException(String message) {
        super(message);
    }

}
