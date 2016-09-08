package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

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
	private String accountID;

	public CreditAccount() {

	}

	public void finalize() throws Throwable {

	}

	public String getAccountID() {
		return accountID;
	}

	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}
}// end CreditAccount