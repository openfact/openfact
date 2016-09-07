package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;

import org.openfact.models.jpa.entities.ubl2.Monetary;

/**
 * A class to define a monetary total.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:12 a. m.
 */
public class MonetaryTotal {

	/**
	 * The total monetary amount of all allowances.
	 */
	private BigDecimal AllowanceTotalAmount;
	/**
	 * The total monetary amount of all charges.
	 */
	private BigDecimal ChargeTotalAmount;
	/**
	 * The monetary amount of an extended transaction line, net of tax and settlement
	 * discounts, but inclusive of any applicable rounding amount.
	 */
	private BigDecimal LineExtensionAmount;
	/**
	 * The amount of the monetary total to be paid, expressed in an alternative
	 * currency.
	 */
	private BigDecimal PayableAlternativeAmount;
	/**
	 * The amount of the monetary total to be paid.
	 */
	private BigDecimal PayableAmount;
	/**
	 * The rounding amount (positive or negative) added to produce the line extension
	 * amount.
	 */
	private BigDecimal PayableRoundingAmount;
	/**
	 * The total prepaid monetary amount.
	 */
	private BigDecimal PrepaidAmount;
	/**
	 * The monetary amount of an extended transaction line, exclusive of taxes.
	 */
	private BigDecimal TaxExclusiveAmount;
	/**
	 * The monetary amount including taxes; the sum of payable amount and prepaid
	 * amount.
	 */
	private BigDecimal TaxInclusiveAmount;

	public Monetary Total(){

	}

	public void finalize() throws Throwable {

	}
	public BigDecimal getAllowanceTotalAmount(){
		return AllowanceTotalAmount;
	}

	public BigDecimal getChargeTotalAmount(){
		return ChargeTotalAmount;
	}

	public BigDecimal getLineExtensionAmount(){
		return LineExtensionAmount;
	}

	public BigDecimal getPayableAlternativeAmount(){
		return PayableAlternativeAmount;
	}

	public BigDecimal getPayableAmount(){
		return PayableAmount;
	}

	public BigDecimal getPayableRoundingAmount(){
		return PayableRoundingAmount;
	}

	public BigDecimal getPrepaidAmount(){
		return PrepaidAmount;
	}

	public BigDecimal getTaxExclusiveAmount(){
		return TaxExclusiveAmount;
	}

	public BigDecimal getTaxInclusiveAmount(){
		return TaxInclusiveAmount;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAllowanceTotalAmount(BigDecimal newVal){
		AllowanceTotalAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setChargeTotalAmount(BigDecimal newVal){
		ChargeTotalAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLineExtensionAmount(BigDecimal newVal){
		LineExtensionAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPayableAlternativeAmount(BigDecimal newVal){
		PayableAlternativeAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPayableAmount(BigDecimal newVal){
		PayableAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPayableRoundingAmount(BigDecimal newVal){
		PayableRoundingAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPrepaidAmount(BigDecimal newVal){
		PrepaidAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTaxExclusiveAmount(BigDecimal newVal){
		TaxExclusiveAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTaxInclusiveAmount(BigDecimal newVal){
		TaxInclusiveAmount = newVal;
	}
}//end Monetary Total