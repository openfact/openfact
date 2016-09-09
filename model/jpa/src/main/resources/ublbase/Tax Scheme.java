

/**
 * A class to describe a taxation scheme (e.g., VAT, State tax, County tax).
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:04 a. m.
 */
public class Tax Scheme {

	/**
	 * A code signifying the currency in which the tax is collected and reported.
	 */
	private Currency_ Code. Type CurrencyCode;
	/**
	 * An identifier for this taxation scheme.
	 */
	private Identifier. Type ID;
	/**
	 * The name of this taxation scheme.
	 */
	private Name. Type Name;
	/**
	 * A code signifying the type of tax.
	 */
	private Code. Type TaxTypeCode;
	private Address Jurisdiction Region Address;

	public Tax Scheme(){

	}

	public void finalize() throws Throwable {

	}
	public Currency_ Code. Type getCurrencyCode(){
		return CurrencyCode;
	}

	public Identifier. Type getID(){
		return ID;
	}

	public Address getJurisdiction Region Address(){
		return Jurisdiction Region Address;
	}

	public Name. Type getName(){
		return Name;
	}

	public Code. Type getTaxTypeCode(){
		return TaxTypeCode;
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
	public void setID(Identifier. Type newVal){
		ID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setJurisdiction Region Address(Address newVal){
		Jurisdiction Region Address = newVal;
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
	public void setTaxTypeCode(Code. Type newVal){
		TaxTypeCode = newVal;
	}
}//end Tax Scheme