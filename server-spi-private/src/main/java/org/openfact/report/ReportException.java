package org.openfact.report;

public class ReportException extends Exception {

	private static final long serialVersionUID = 1L;
	

	public ReportException(Throwable cause) {
        super(cause);
    }

    public ReportException(String message, Throwable cause) {
        super(message, cause);
    }

}
