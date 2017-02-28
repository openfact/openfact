package org.openfact.models;

public class ModelReadOnlyException extends ModelException {

	private static final long serialVersionUID = 1L;

	public ModelReadOnlyException() {
    }

    public ModelReadOnlyException(String message) {
        super(message);
    }

    public ModelReadOnlyException(String message, Throwable cause) {
        super(message, cause);
    }

    public ModelReadOnlyException(Throwable cause) {
        super(cause);
    }
}
