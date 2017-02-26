package org.openfact.models;

public class JobException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private Object[] parameters;

    public JobException() {
    }

    public JobException(String message) {
        super(message);
    }

    public JobException(String message, Object... parameters) {
        super(message);
        this.parameters = parameters;
    }

    public JobException(String message, Throwable cause) {
        super(message, cause);
    }

    public JobException(Throwable cause) {
        super(cause);
    }

    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }

}
