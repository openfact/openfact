package org.openfact.models.jpa.entities.ubl;


/**
 * A class for describing the terms and conditions applying to the delivery of
 * goods.
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:14:23 a. m.
 */
public class DeliveryTerms {

	/**
	 * The monetary amount covered by these delivery terms.
	 */
	private BigDecimal Amount;
	/**
	 * An identifier for this description of delivery terms.
	 */
	private String ID;
	/**
	 * A description of responsibility for risk of loss in execution of the delivery,
	 * expressed as text.
	 */
	private String LossRisk;
	/**
	 * A code that identifies one of various responsibilities for loss risk in the
	 * execution of the delivery.
	 */
	private String LossRiskResponsibilityCode;
	/**
	 * A description of any terms or conditions relating to the delivery items.
	 */
	private String SpecialTerms;
	private Allowance Charge m_Allowance Charge;
	private Location Delivery Location;

	public Delivery Terms(){

	}

	public void finalize() throws Throwable {

	}
	public Allowance Charge getAllowance Charge(){
		return m_Allowance Charge;
	}

	public BigDecimal getAmount(){
		return Amount;
	}

	public Location getDelivery Location(){
		return Delivery Location;
	}

	public String getID(){
		return ID;
	}

	public String getLossRisk(){
		return LossRisk;
	}

	public String getLossRiskResponsibilityCode(){
		return LossRiskResponsibilityCode;
	}

	public String getSpecialTerms(){
		return SpecialTerms;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAllowance Charge(Allowance Charge newVal){
		m_Allowance Charge = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAmount(BigDecimal newVal){
		Amount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDelivery Location(Location newVal){
		Delivery Location = newVal;
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
	public void setLossRisk(String newVal){
		LossRisk = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLossRiskResponsibilityCode(String newVal){
		LossRiskResponsibilityCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSpecialTerms(String newVal){
		SpecialTerms = newVal;
	}
}//end Delivery Terms