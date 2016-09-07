package org.openfact.models.jpa.entities.ubl;


/**
 * A class to describe a party as a legal entity.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:28 a. m.
 */
public class PartyLegalEntity {

	/**
	 * An identifier for the party as registered within a company registration scheme.
	 */
	private Identifier. Type CompanyID;
	/**
	 * The company legal status, expressed as a text.
	 */
	private Text. Type CompanyLegalForm;
	/**
	 * A code signifying the party's legal status.
	 */
	private Code. Type CompanyLegalFormCode;
	/**
	 * A code signifying the party's liquidation status.
	 */
	private Code. Type CompanyLiquidationStatusCode;
	/**
	 * The number of shares in the capital stock of a corporation.
	 */
	private Amount. Type CorporateStockAmount;
	/**
	 * An indicator that all shares of corporate stock have been paid by shareholders
	 * (true) or not (false).
	 */
	private Indicator. Type FullyPaidSharesIndicator;
	/**
	 * The registration date of the CompanyID.
	 */
	private Date. Type RegistrationDate;
	/**
	 * The date upon which a registration expires (e.g., registration for an
	 * import/export license).
	 */
	private Date. Type RegistrationExpirationDate;
	/**
	 * The name of the party as registered with the relevant legal authority.
	 */
	private Name. Type RegistrationName;
	/**
	 * An indicator that the company is owned and controlled by one person (true) or
	 * not (false).
	 */
	private Indicator. Type SoleProprietorshipIndicator;
	private Address Registration Address;
	private Corporate Registration Scheme m_Corporate Registration Scheme;
	private Party Head Office Party;
	private Shareholder Party m_Shareholder Party;

	public Party Legal Entity(){

	}

	public void finalize() throws Throwable {

	}
	public Identifier. Type getCompanyID(){
		return CompanyID;
	}

	public Text. Type getCompanyLegalForm(){
		return CompanyLegalForm;
	}

	public Code. Type getCompanyLegalFormCode(){
		return CompanyLegalFormCode;
	}

	public Code. Type getCompanyLiquidationStatusCode(){
		return CompanyLiquidationStatusCode;
	}

	public Corporate Registration Scheme getCorporate Registration Scheme(){
		return m_Corporate Registration Scheme;
	}

	public Amount. Type getCorporateStockAmount(){
		return CorporateStockAmount;
	}

	public Indicator. Type getFullyPaidSharesIndicator(){
		return FullyPaidSharesIndicator;
	}

	public Party getHead Office Party(){
		return Head Office Party;
	}

	public Address getRegistration Address(){
		return Registration Address;
	}

	public Date. Type getRegistrationDate(){
		return RegistrationDate;
	}

	public Date. Type getRegistrationExpirationDate(){
		return RegistrationExpirationDate;
	}

	public Name. Type getRegistrationName(){
		return RegistrationName;
	}

	public Shareholder Party getShareholder Party(){
		return m_Shareholder Party;
	}

	public Indicator. Type getSoleProprietorshipIndicator(){
		return SoleProprietorshipIndicator;
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
	public void setCompanyLegalForm(Text. Type newVal){
		CompanyLegalForm = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCompanyLegalFormCode(Code. Type newVal){
		CompanyLegalFormCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCompanyLiquidationStatusCode(Code. Type newVal){
		CompanyLiquidationStatusCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCorporate Registration Scheme(Corporate Registration Scheme newVal){
		m_Corporate Registration Scheme = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCorporateStockAmount(Amount. Type newVal){
		CorporateStockAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFullyPaidSharesIndicator(Indicator. Type newVal){
		FullyPaidSharesIndicator = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setHead Office Party(Party newVal){
		Head Office Party = newVal;
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
	public void setRegistrationDate(Date. Type newVal){
		RegistrationDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRegistrationExpirationDate(Date. Type newVal){
		RegistrationExpirationDate = newVal;
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
	public void setShareholder Party(Shareholder Party newVal){
		m_Shareholder Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSoleProprietorshipIndicator(Indicator. Type newVal){
		SoleProprietorshipIndicator = newVal;
	}
}//end Party Legal Entity