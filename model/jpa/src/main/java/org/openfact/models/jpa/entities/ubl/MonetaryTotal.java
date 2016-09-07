package org.openfact.models.jpa.entities.ubl;


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
	private Amount. Type AllowanceTotalAmount;
	/**
	 * The total monetary amount of all charges.
	 */
	private Amount. Type ChargeTotalAmount;
	/**
	 * The monetary amount of an extended transaction line, net of tax and settlement
	 * discounts, but inclusive of any applicable rounding amount.
	 */
	private Amount. Type LineExtensionAmount;
	/**
	 * The amount of the monetary total to be paid, expressed in an alternative
	 * currency.
	 */
	private Amount. Type PayableAlternativeAmount;
	/**
	 * The amount of the monetary total to be paid.
	 */
	private Amount. Type PayableAmount;
	/**
	 * The rounding amount (positive or negative) added to produce the line extension
	 * amount.
	 */
	private Amount. Type PayableRoundingAmount;
	/**
	 * The total prepaid monetary amount.
	 */
	private Amount. Type PrepaidAmount;
	/**
	 * The monetary amount of an extended transaction line, exclusive of taxes.
	 */
	private Amount. Type TaxExclusiveAmount;
	/**
	 * The monetary amount including taxes; the sum of payable amount and prepaid
	 * amount.
	 */
	private Amount. Type TaxInclusiveAmount;

	public Monetary Total(){

	}

	public void finalize() throws Throwable {

	}
	public Amount. Type getAllowanceTotalAmount(){
		return AllowanceTotalAmount;
	}

	public Amount. Type getChargeTotalAmount(){
		return ChargeTotalAmount;
	}

	public Amount. Type getLineExtensionAmount(){
		return LineExtensionAmount;
	}

	public Amount. Type getPayableAlternativeAmount(){
		return PayableAlternativeAmount;
	}

	public Amount. Type getPayableAmount(){
		return PayableAmount;
	}

	public Amount. Type getPayableRoundingAmount(){
		return PayableRoundingAmount;
	}

	public Amount. Type getPrepaidAmount(){
		return PrepaidAmount;
	}

	public Amount. Type getTaxExclusiveAmount(){
		return TaxExclusiveAmount;
	}

	public Amount. Type getTaxInclusiveAmount(){
		return TaxInclusiveAmount;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAllowanceTotalAmount(Amount. Type newVal){
		AllowanceTotalAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setChargeTotalAmount(Amount. Type newVal){
		ChargeTotalAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLineExtensionAmount(Amount. Type newVal){
		LineExtensionAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPayableAlternativeAmount(Amount. Type newVal){
		PayableAlternativeAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPayableAmount(Amount. Type newVal){
		PayableAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPayableRoundingAmount(Amount. Type newVal){
		PayableRoundingAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPrepaidAmount(Amount. Type newVal){
		PrepaidAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTaxExclusiveAmount(Amount. Type newVal){
		TaxExclusiveAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTaxInclusiveAmount(Amount. Type newVal){
		TaxInclusiveAmount = newVal;
	}
}//end Monetary Total