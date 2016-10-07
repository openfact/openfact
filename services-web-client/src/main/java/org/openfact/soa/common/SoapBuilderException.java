package org.openfact.soa.common;

public class SoapBuilderException extends SoapException {
	public SoapBuilderException(String message) {
		super(message);
	}

	public SoapBuilderException(String message, Throwable cause) {
		super(message, cause);
	}

	public SoapBuilderException(Throwable cause) {
		super(cause.getMessage(), cause);
	}
}
