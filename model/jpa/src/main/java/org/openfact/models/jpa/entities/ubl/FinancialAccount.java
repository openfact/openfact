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
	private Code. Type AccountFormatCode;
	/**
	 * A code signifying the type of this financial account.
	 */
	private Code. Type AccountTypeCode;
	/**
	 * An alias for the name of this financial account, to be used in place of the
	 * actual account name for security reasons.
	 */
	private Name. Type AliasName;
	/**
	 * A code signifying the currency in which this financial account is held.
	 */
	private Currency_ Code. Type CurrencyCode;
	/**
	 * The identifier for this financial account; the bank account number.
	 */
	private Identifier. Type ID;
	/**
	 * The name of this financial account.
	 */
	private Name. Type Name;
	/**
	 * Free-form text applying to the Payment for the owner of this account.
	 */
	private Text. Type PaymentNote;
	private Branch Financial Institution Branch;
	private Country m_Country;

	public Financial Account(){

	}

	public void finalize() throws Throwable {

	}
	public Code. Type getAccountFormatCode(){
		return AccountFormatCode;
	}

	public Code. Type getAccountTypeCode(){
		return AccountTypeCode;
	}

	public Name. Type getAliasName(){
		return AliasName;
	}

	public Country getCountry(){
		return m_Country;
	}

	public Currency_ Code. Type getCurrencyCode(){
		return CurrencyCode;
	}

	public Branch getFinancial Institution Branch(){
		return Financial Institution Branch;
	}

	public Identifier. Type getID(){
		return ID;
	}

	public Name. Type getName(){
		return Name;
	}

	public Text. Type getPaymentNote(){
		return PaymentNote;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAccountFormatCode(Code. Type newVal){
		AccountFormatCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAccountTypeCode(Code. Type newVal){
		AccountTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAliasName(Name. Type newVal){
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
	public void setCurrencyCode(Currency_ Code. Type newVal){
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
	public void setID(Identifier. Type newVal){
		ID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setName(Name. Type newVal){
		Name = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPaymentNote(Text. Type newVal){
		PaymentNote = newVal;
	}
}//end Financial Account