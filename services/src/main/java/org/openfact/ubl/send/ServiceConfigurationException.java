package org.openfact.ubl.send;

public class ServiceConfigurationException extends Exception {
	private static final long serialVersionUID = 1L;

	public ServiceConfigurationException() {
	}

	public ServiceConfigurationException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceConfigurationException(String message) {
		super(message);
	}

	public ServiceConfigurationException(Throwable cause) {
		super(cause);
	}
}