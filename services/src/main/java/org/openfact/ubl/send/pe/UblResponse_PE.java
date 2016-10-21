package org.openfact.ubl.send.pe;

import java.util.List;

public class UblResponse_PE {
	private int errorCode;
	private boolean isError = false;
	private String message;
	private List<String> warnings;

	public UblResponse_PE(int errorCode, String message, List<String> warnings) {
		this.errorCode = errorCode;
		this.message = message;
		this.warnings = warnings;
		if (errorCode != 0 && (errorCode < 100 || errorCode > 399) && errorCode <= 4000) {
			this.isError = true;
		}
	}

	public int getErrorCode() {
		return errorCode;
	}

	public boolean isError() {
		return isError;
	}

	public String getMessage() {
		return message;
	}

	public List<String> getWarnings() {
		return warnings;
	}

}
