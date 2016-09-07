

/**
 * A class to describe an immobilized security to be used as a guarantee.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:15:32 a. m.
 */
public class Immobilized Security {

	/**
	 * The value of the security on the day it was immobilized.
	 */
	private Amount. Type FaceValueAmount;
	/**
	 * An identifier for the certificate of this immobilized security.
	 */
	private Identifier. Type ImmobilizationCertificateID;
	/**
	 * The date on which this immobilized security was issued.
	 */
	private Date. Type IssueDate;
	/**
	 * The current market value of the immobilized security.
	 */
	private Amount. Type MarketValueAmount;
	/**
	 * An identifier for the security being immobilized.
	 */
	private Identifier. Type SecurityID;
	/**
	 * The number of shares immobilized.
	 */
	private Quantity. Type SharesNumberQuantity;
	private Party Issuer Party;

	public Immobilized Security(){

	}

	public void finalize() throws Throwable {

	}
	public Amount. Type getFaceValueAmount(){
		return FaceValueAmount;
	}

	public Identifier. Type getImmobilizationCertificateID(){
		return ImmobilizationCertificateID;
	}

	public Date. Type getIssueDate(){
		return IssueDate;
	}

	public Party getIssuer Party(){
		return Issuer Party;
	}

	public Amount. Type getMarketValueAmount(){
		return MarketValueAmount;
	}

	public Identifier. Type getSecurityID(){
		return SecurityID;
	}

	public Quantity. Type getSharesNumberQuantity(){
		return SharesNumberQuantity;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFaceValueAmount(Amount. Type newVal){
		FaceValueAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setImmobilizationCertificateID(Identifier. Type newVal){
		ImmobilizationCertificateID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setIssueDate(Date. Type newVal){
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
	public void setMarketValueAmount(Amount. Type newVal){
		MarketValueAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSecurityID(Identifier. Type newVal){
		SecurityID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSharesNumberQuantity(Quantity. Type newVal){
		SharesNumberQuantity = newVal;
	}
}//end Immobilized Security