package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;

/**
 * A class to describe a delivery unit.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:25 a. m.
 */
public class DeliveryUnit {

	/**
	 * The quantity of ordered Items that constitutes a batch for delivery purposes.
	 */
	private BigDecimal BatchQuantity;
	/**
	 * The quantity of units in the Delivery Unit expressed in the units used by the
	 * consumer.
	 */
	private BigDecimal ConsumerUnitQuantity;
	/**
	 * An indication that the transported goods are subject to an international
	 * regulation concerning the carriage of dangerous goods (true) or not (false).
	 */
	private boolean HazardousRiskIndicator;

	public Delivery Unit(){

	}

	public void finalize() throws Throwable {

	}
	public BigDecimal getBatchQuantity(){
		return BatchQuantity;
	}

	public BigDecimal getConsumerUnitQuantity(){
		return ConsumerUnitQuantity;
	}

	public boolean getHazardousRiskIndicator(){
		return HazardousRiskIndicator;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setBatchQuantity(BigDecimal newVal){
		BatchQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setConsumerUnitQuantity(BigDecimal newVal){
		ConsumerUnitQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setHazardousRiskIndicator(boolean newVal){
		HazardousRiskIndicator = newVal;
	}
}//end Delivery Unit