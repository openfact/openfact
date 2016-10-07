package org.openfact.soa.client;

import org.openfact.soa.common.SoapException;

/**
 * Top-level exception type thrown by SoapClient
 *
 */
public class SoapClientException extends SoapException {
	public SoapClientException(String message) {
		super(message);
	}

	public SoapClientException(String message, Throwable cause) {
		super(message, cause);
	}

	public SoapClientException(Throwable cause) {
		super(cause);
	}
}
