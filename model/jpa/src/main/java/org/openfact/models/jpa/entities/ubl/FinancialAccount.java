package org.openfact.models.jpa.entities.ubl;


/**
 * A class to describe a financial account.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:11 a. m.
 */
public class FinancialAccount {

	/**
	 * A code signifying the format of this financial account.
	 */
	private String AccountFormatCode;
	/**
	 * A code signifying the type of this financial account.
	 */
	private String AccountTypeCode;
	/**
	 * An alias for the name of this financial account, to be used in place of the
	 * actual account name for security reasons.
	 */
	private String AliasName;
	/**
	 * A code signifying the currency in which this financial account is held.
	 */
	private Currency_ String CurrencyCode;
	/**
	 * The identifier for this financial account; the bank account number.
	 */
	private String ID;
	/**
	 * The name of this financial account.
	 */
	private String Name;
	/**
	 * Free-form text applying to the Payment for the owner of this account.
	 */
	private String PaymentNote;
	private Branch Financial Institution Branch;
	private Country m_Country;

	public Financial Account(){

	}

	public void finalize() throws Throwable {

	}
	public String getAccountFormatCode(){
		return AccountFormatCode;
	}

	public String getAccountTypeCode(){
		return AccountTypeCode;
	}

	public String getAliasName(){
		return AliasName;
	}

	public Country getCountry(){
		return m_Country;
	}

	public Currency_ String getCurrencyCode(){
		return CurrencyCode;
	}

	public Branch getFinancial Institution Branch(){
		return Financial Institution Branch;
	}

	public String getID(){
		return ID;
	}

	public String getName(){
		return Name;
	}

	public String getPaymentNote(){
		return PaymentNote;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAccountFormatCode(String newVal){
		AccountFormatCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAccountTypeCode(String newVal){
		AccountTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAliasName(String newVal){
		AliasName = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCountry(Country newVal){
		m_Country = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCurrencyCode(Currency_ String newVal){
		CurrencyCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFinancial Institution Branch(Branch newVal){
		Financial Institution Branch = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setID(String newVal){
		ID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setName(String newVal){
		Name = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPaymentNote(String newVal){
		PaymentNote = newVal;
	}
}//end Financial Account