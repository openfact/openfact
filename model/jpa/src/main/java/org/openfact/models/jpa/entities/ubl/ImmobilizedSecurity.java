package org.openfact.models.jpa.entities.ubl;


/**
 * A class to describe an immobilized security to be used as a guarantee.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:15:32 a. m.
 */
public class ImmobilizedSecurity {

	/**
	 * The value of the security on the day it was immobilized.
	 */
	private BigDecimal FaceValueAmount;
	/**
	 * An identifier for the certificate of this immobilized security.
	 */
	private String ImmobilizationCertificateID;
	/**
	 * The date on which this immobilized security was issued.
	 */
	private LocalDate IssueDate;
	/**
	 * The current market value of the immobilized security.
	 */
	private BigDecimal MarketValueAmount;
	/**
	 * An identifier for the security being immobilized.
	 */
	private String SecurityID;
	/**
	 * The number of shares immobilized.
	 */
	private BigDecimal SharesNumberQuantity;
	private Party Issuer Party;

	public Immobilized Security(){

	}

	public void finalize() throws Throwable {

	}
	public BigDecimal getFaceValueAmount(){
		return FaceValueAmount;
	}

	public String getImmobilizationCertificateID(){
		return ImmobilizationCertificateID;
	}

	public LocalDate getIssueDate(){
		return IssueDate;
	}

	public Party getIssuer Party(){
		return Issuer Party;
	}

	public BigDecimal getMarketValueAmount(){
		return MarketValueAmount;
	}

	public String getSecurityID(){
		return SecurityID;
	}

	public BigDecimal getSharesNumberQuantity(){
		return SharesNumberQuantity;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFaceValueAmount(BigDecimal newVal){
		FaceValueAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setImmobilizationCertificateID(String newVal){
		ImmobilizationCertificateID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setIssueDate(LocalDate newVal){
		IssueDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setIssuer Party(Party newVal){
		Issuer Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMarketValueAmount(BigDecimal newVal){
		MarketValueAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSecurityID(String newVal){
		SecurityID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSharesNumberQuantity(BigDecimal newVal){
		SharesNumberQuantity = newVal;
	}
}//end Immobilized Security