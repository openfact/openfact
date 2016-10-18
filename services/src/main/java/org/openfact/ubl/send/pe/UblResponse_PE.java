package org.openfact.ubl.send.pe;

import java.util.List;

public class UblResponse_PE {
	private int code;
	private boolean isError = false;
	private String msj;
	private List<String> warnings;

	public UblResponse_PE(int code, String msj, List<String> warnings) {
		this.code = code;
		this.msj = msj;
		this.warnings = warnings;
		if (code != 0 && (this.code < 100 || this.code > 399) && this.code <= 4000) {
			this.isError = true;
		}
	}

	public int getCode() {
		return code;
	}

	public boolean isError() {
		return isError;
	}

	public String getMsj() {
		return msj;
	}

	public List<String> getWarnings() {
		return warnings;
	}
}
