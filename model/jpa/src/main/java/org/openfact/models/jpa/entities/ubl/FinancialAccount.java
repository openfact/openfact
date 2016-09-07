package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to describe a financial account.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:11 a. m.
 */
public class FinancialAccount {

	/**
	 * A code signifying the format of this financial account.
	 */
	private String accountFormatCode;
	/**
	 * A code signifying the type of this financial account.
	 */
	private String accountTypeCode;
	/**
	 * An alias for the name of this financial account, to be used in place of
	 * the actual account name for security reasons.
	 */
	private String aliasName;
	/**
	 * A code signifying the currency in which this financial account is held.
	 */
	private String currencyCode;
	/**
	 * The identifier for this financial account; the bank account number.
	 */
	private String ID;
	/**
	 * The name of this financial account.
	 */
	private String name;
	/**
	 * Free-form text applying to the Payment for the owner of this account.
	 */
	private String paymentNote;
	private Branch financialInstitutionBranch;
	private List<Country> countries = new ArrayList<>();

	public String getAccountFormatCode() {
		return accountFormatCode;
	}

	public void setAccountFormatCode(String accountFormatCode) {
		this.accountFormatCode = accountFormatCode;
	}

	public String getAccountTypeCode() {
		return accountTypeCode;
	}

	public void setAccountTypeCode(String accountTypeCode) {
		this.accountTypeCode = accountTypeCode;
	}

	public String getAliasName() {
		return aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPaymentNote() {
		return paymentNote;
	}

	public void setPaymentNote(String paymentNote) {
		this.paymentNote = paymentNote;
	}

	public Branch getFinancialInstitutionBranch() {
		return financialInstitutionBranch;
	}

	public void setFinancialInstitutionBranch(Branch financialInstitutionBranch) {
		this.financialInstitutionBranch = financialInstitutionBranch;
	}

	public List<Country> getCountries() {
		return countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}
}// end FinancialAccount