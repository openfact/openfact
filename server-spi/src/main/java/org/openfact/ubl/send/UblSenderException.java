package org.openfact.ubl.send;

public class UblSenderException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UblSenderException(Throwable cause) {
		super(cause);
	}

	public UblSenderException(String message, Throwable cause) {
		super(message, cause);
	}
}
