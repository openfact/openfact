package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

/**
 * A class for describing the terms and conditions applying to the delivery of
 * goods.
 * 
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
	private String id;
	/**
	 * A description of responsibility for risk of loss in execution of the
	 * delivery, expressed as text.
	 */
	private String lossRisk;
	/**
	 * A code that identifies one of various responsibilities for loss risk in
	 * the execution of the delivery.
	 */
	private String lossRiskResponsibilityCode;
	/**
	 * A description of any terms or conditions relating to the delivery items.
	 */
	private String specialTerms;
	private List<AllowanceCharge> allowanceCharges=new ArrayList<>();
	private Location deliveryLocation;

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public List<AllowanceCharge> getAllowanceCharges() {
		return allowanceCharges;
	}

	public void setAllowanceCharges(List<AllowanceCharge> allowanceCharges) {
		this.allowanceCharges = allowanceCharges;
	}

	public Location getDeliveryLocation() {
		return deliveryLocation;
	}

	public void setDeliveryLocation(Location deliveryLocation) {
		this.deliveryLocation = deliveryLocation;
	}
}// end DeliveryTerms