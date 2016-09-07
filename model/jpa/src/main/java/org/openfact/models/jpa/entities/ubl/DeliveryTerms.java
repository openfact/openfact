package org.openfact.models.jpa.entities.ubl;


import java.math.BigDecimal;

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
	private BigDecimal amount;
	/**
	 * An identifier for this description of delivery terms.
	 */
	private String ID;
	/**
	 * A description of responsibility for risk of loss in execution of the delivery,
	 * expressed as text.
	 */
	private String lossRisk;
	/**
	 * A code that identifies one of various responsibilities for loss risk in the
	 * execution of the delivery.
	 */
	private String lossRiskResponsibilityCode;
	/**
	 * A description of any terms or conditions relating to the delivery items.
	 */
	private String specialTerms;
	private AllowanceCharge m_AllowanceCharge;
	private Location deliveryLocation;

	public DeliveryTerms(){

	}

	public void finalize() throws Throwable {

	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getLossRisk() {
		return lossRisk;
	}

	public void setLossRisk(String lossRisk) {
		this.lossRisk = lossRisk;
	}

	public String getLossRiskResponsibilityCode() {
		return lossRiskResponsibilityCode;
	}

	public void setLossRiskResponsibilityCode(String lossRiskResponsibilityCode) {
		this.lossRiskResponsibilityCode = lossRiskResponsibilityCode;
	}

	public String getSpecialTerms() {
		return specialTerms;
	}

	public void setSpecialTerms(String specialTerms) {
		this.specialTerms = specialTerms;
	}

	public AllowanceCharge getM_AllowanceCharge() {
		return m_AllowanceCharge;
	}

	public void setM_AllowanceCharge(AllowanceCharge m_AllowanceCharge) {
		this.m_AllowanceCharge = m_AllowanceCharge;
	}

	public Location getDeliveryLocation() {
		return deliveryLocation;
	}

	public void setDeliveryLocation(Location deliveryLocation) {
		this.deliveryLocation = deliveryLocation;
	}
}//end DeliveryTerms