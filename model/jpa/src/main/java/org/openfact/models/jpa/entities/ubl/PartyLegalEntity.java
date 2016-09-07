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
	private String CompanyID;
	/**
	 * The company legal status, expressed as a text.
	 */
	private String CompanyLegalForm;
	/**
	 * A code signifying the party's legal status.
	 */
	private String CompanyLegalFormCode;
	/**
	 * A code signifying the party's liquidation status.
	 */
	private String CompanyLiquidationStatusCode;
	/**
	 * The number of shares in the capital stock of a corporation.
	 */
	private BigDecimal CorporateStockAmount;
	/**
	 * An indicator that all shares of corporate stock have been paid by shareholders
	 * (true) or not (false).
	 */
	private boolean FullyPaidSharesIndicator;
	/**
	 * The registration date of the CompanyID.
	 */
	private LocalDate RegistrationDate;
	/**
	 * The date upon which a registration expires (e.g., registration for an
	 * import/export license).
	 */
	private LocalDate RegistrationExpirationDate;
	/**
	 * The name of the party as registered with the relevant legal authority.
	 */
	private String RegistrationName;
	/**
	 * An indicator that the company is owned and controlled by one person (true) or
	 * not (false).
	 */
	private boolean SoleProprietorshipIndicator;
	private Address Registration Address;
	private Corporate Registration Scheme m_Corporate Registration Scheme;
	private Party Head Office Party;
	private Shareholder Party m_Shareholder Party;

	public Party Legal Entity(){

	}

	public void finalize() throws Throwable {

	}
	public String getCompanyID(){
		return CompanyID;
	}

	public String getCompanyLegalForm(){
		return CompanyLegalForm;
	}

	public String getCompanyLegalFormCode(){
		return CompanyLegalFormCode;
	}

	public String getCompanyLiquidationStatusCode(){
		return CompanyLiquidationStatusCode;
	}

	public Corporate Registration Scheme getCorporate Registration Scheme(){
		return m_Corporate Registration Scheme;
	}

	public BigDecimal getCorporateStockAmount(){
		return CorporateStockAmount;
	}

	public boolean getFullyPaidSharesIndicator(){
		return FullyPaidSharesIndicator;
	}

	public Party getHead Office Party(){
		return Head Office Party;
	}

	public Address getRegistration Address(){
		return Registration Address;
	}

	public LocalDate getRegistrationDate(){
		return RegistrationDate;
	}

	public LocalDate getRegistrationExpirationDate(){
		return RegistrationExpirationDate;
	}

	public String getRegistrationName(){
		return RegistrationName;
	}

	public Shareholder Party getShareholder Party(){
		return m_Shareholder Party;
	}

	public boolean getSoleProprietorshipIndicator(){
		return SoleProprietorshipIndicator;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCompanyID(String newVal){
		CompanyID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCompanyLegalForm(String newVal){
		CompanyLegalForm = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCompanyLegalFormCode(String newVal){
		CompanyLegalFormCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCompanyLiquidationStatusCode(String newVal){
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
	public void setCorporateStockAmount(BigDecimal newVal){
		CorporateStockAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFullyPaidSharesIndicator(boolean newVal){
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
	public void setRegistrationDate(LocalDate newVal){
		RegistrationDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRegistrationExpirationDate(LocalDate newVal){
		RegistrationExpirationDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRegistrationName(String newVal){
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
	public void setSoleProprietorshipIndicator(boolean newVal){
		SoleProprietorshipIndicator = newVal;
	}
}//end Party Legal Entity