

/**
 * A class to describe a taxation scheme applying to a party.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:31 a. m.
 */
public class PartyTaxScheme {

	/**
	 * An identifier for the party assigned for tax purposes by the taxation authority.
	 */
	private Identifier. Type CompanyID;
	/**
	 * A reason for the party's exemption from tax, expressed as text.
	 */
	private Text. Type ExemptionReason;
	/**
	 * A reason for the party's exemption from tax, expressed as a code.
	 */
	private Code. Type ExemptionReasonCode;
	/**
	 * The name of the party as registered with the relevant fiscal authority.
	 */
	private Name. Type RegistrationName;
	/**
	 * A code signifying the tax level applicable to the party within this taxation
	 * scheme.
	 */
	private Code. Type TaxLevelCode;
	private Address Registration Address;
	private Tax Scheme m_Tax Scheme;

	public Party Tax Scheme(){

	}

	public void finalize() throws Throwable {

	}
	public Identifier. Type getCompanyID(){
		return CompanyID;
	}

	public Text. Type getExemptionReason(){
		return ExemptionReason;
	}

	public Code. Type getExemptionReasonCode(){
		return ExemptionReasonCode;
	}

	public Address getRegistration Address(){
		return Registration Address;
	}

	public Name. Type getRegistrationName(){
		return RegistrationName;
	}

	public Tax Scheme getTax Scheme(){
		return m_Tax Scheme;
	}

	public Code. Type getTaxLevelCode(){
		return TaxLevelCode;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCompanyID(Identifier. Type newVal){
		CompanyID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setExemptionReason(Text. Type newVal){
		ExemptionReason = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setExemptionReasonCode(Code. Type newVal){
		ExemptionReasonCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRegistration Address(Address newVal){
		Registration Address = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRegistrationName(Name. Type newVal){
		RegistrationName = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTax Scheme(Tax Scheme newVal){
		m_Tax Scheme = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTaxLevelCode(Code. Type newVal){
		TaxLevelCode = newVal;
	}
}//end Party Tax Scheme