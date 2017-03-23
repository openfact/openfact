package org.openfact.models;

public class ModelInsuficientData extends Exception {

	private static final long serialVersionUID = 1L;

	public ModelInsuficientData(Throwable cause) {
        super(cause);
    }

    public ModelInsuficientData(String message) {
        super(message);
    }

    public ModelInsuficientData(String message, Throwable cause) {
        super(message, cause);
    }

}
