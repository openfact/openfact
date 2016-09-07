package org.openfact.models.jpa.entities.ubl;

/**
 * A class to identify a credit account for sales on account.
 * 
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:14:12 a. m.
 */
public class CreditAccount {

	/**
	 * An identifier for this credit account.
	 */
	private String AccountID;

	public CreditAccount() {

	}

	public void finalize() throws Throwable {

	}

	public String getAccountID() {
		return AccountID;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAccountID(String newVal) {
		AccountID = newVal;
	}
}// end Credit Account