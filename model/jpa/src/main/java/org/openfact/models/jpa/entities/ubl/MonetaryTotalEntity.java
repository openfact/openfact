package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * A class to define a monetary total.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:12 a. m.
 */
@Entity
@Table(name = "MONETARY_TOTAL")
public class MonetaryTotalEntity {

	@Id
	@Column(name = "ID_OP", length = 36)
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Access(AccessType.PROPERTY)
	private String id;
	/**
	 * The total monetary amount of all allowances.
	 */
	@Column(name = "ALLOWANCE_TOTAL_AMOUNT")
	private BigDecimal allowanceTotalAmount;
	/**
	 * The total monetary amount of all charges.
	 */
	@Column(name = "CHARGE_TOTAL_AMOUNT")
	private BigDecimal chargeTotalAmount;
	/**
	 * The monetary amount of an extended transaction line, net of tax and
	 * settlement discounts, but inclusive of any applicable rounding amount.
	 */
	@Column(name = "LINE_EXTENSION_AMOUNT")
	private BigDecimal lineExtensionAmount;
	/**
	 * The amount of the monetary total to be paid, expressed in an alternative
	 * currency.
	 */
	@Column(name = "PAYABLE_ALTERNATIVE_AMOUNT")
	private BigDecimal payableAlternativeAmount;
	/**
	 * The amount of the monetary total to be paid.
	 */
	@Column(name = "PAYABLE_AMOUNT")
	private BigDecimal payableAmount;
	/**
	 * The rounding amount (positive or negative) added to produce the line
	 * extension amount.
	 */
	@Column(name = "PAYABLE_ROUNDING_AMOUNT")
	private BigDecimal payableRoundingAmount;
	/**
	 * The total prepaid monetary amount.
	 */
	@Column(name = "PREPAID_AMOUNT")
	private BigDecimal prepaidAmount;
	/**
	 * The monetary amount of an extended transaction line, exclusive of taxes.
	 */
	@Column(name = "TAX_EXCLUSIVE_AMOUNT")
	private BigDecimal taxExclusiveAmount;
	/**
	 * The monetary amount including taxes; the sum of payable amount and
	 * prepaid amount.
	 */
	@Column(name = "TAX_INCLUSIVE_AMOUNT")
	private BigDecimal taxInclusiveAmount;
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the allowanceTotalAmount
	 */
	public BigDecimal getAllowanceTotalAmount() {
		return allowanceTotalAmount;
	}
	/**
	 * @param allowanceTotalAmount the allowanceTotalAmount to set
	 */
	public void setAllowanceTotalAmount(BigDecimal allowanceTotalAmount) {
		this.allowanceTotalAmount = allowanceTotalAmount;
	}
	/**
	 * @return the chargeTotalAmount
	 */
	public BigDecimal getChargeTotalAmount() {
		return chargeTotalAmount;
	}
	/**
	 * @param chargeTotalAmount the chargeTotalAmount to set
	 */
	public void setChargeTotalAmount(BigDecimal chargeTotalAmount) {
		this.chargeTotalAmount = chargeTotalAmount;
	}
	/**
	 * @return the lineExtensionAmount
	 */
	public BigDecimal getLineExtensionAmount() {
		return lineExtensionAmount;
	}
	/**
	 * @param lineExtensionAmount the lineExtensionAmount to set
	 */
	public void setLineExtensionAmount(BigDecimal lineExtensionAmount) {
		this.lineExtensionAmount = lineExtensionAmount;
	}
	/**
	 * @return the payableAlternativeAmount
	 */
	public BigDecimal getPayableAlternativeAmount() {
		return payableAlternativeAmount;
	}
	/**
	 * @param payableAlternativeAmount the payableAlternativeAmount to set
	 */
	public void setPayableAlternativeAmount(BigDecimal payableAlternativeAmount) {
		this.payableAlternativeAmount = payableAlternativeAmount;
	}
	/**
	 * @return the payableAmount
	 */
	public BigDecimal getPayableAmount() {
		return payableAmount;
	}
	/**
	 * @param payableAmount the payableAmount to set
	 */
	public void setPayableAmount(BigDecimal payableAmount) {
		this.payableAmount = payableAmount;
	}
	/**
	 * @return the payableRoundingAmount
	 */
	public BigDecimal getPayableRoundingAmount() {
		return payableRoundingAmount;
	}
	/**
	 * @param payableRoundingAmount the payableRoundingAmount to set
	 */
	public void setPayableRoundingAmount(BigDecimal payableRoundingAmount) {
		this.payableRoundingAmount = payableRoundingAmount;
	}
	/**
	 * @return the prepaidAmount
	 */
	public BigDecimal getPrepaidAmount() {
		return prepaidAmount;
	}
	/**
	 * @param prepaidAmount the prepaidAmount to set
	 */
	public void setPrepaidAmount(BigDecimal prepaidAmount) {
		this.prepaidAmount = prepaidAmount;
	}
	/**
	 * @return the taxExclusiveAmount
	 */
	public BigDecimal getTaxExclusiveAmount() {
		return taxExclusiveAmount;
	}
	/**
	 * @param taxExclusiveAmount the taxExclusiveAmount to set
	 */
	public void setTaxExclusiveAmount(BigDecimal taxExclusiveAmount) {
		this.taxExclusiveAmount = taxExclusiveAmount;
	}
	/**
	 * @return the taxInclusiveAmount
	 */
	public BigDecimal getTaxInclusiveAmount() {
		return taxInclusiveAmount;
	}
	/**
	 * @param taxInclusiveAmount the taxInclusiveAmount to set
	 */
	public void setTaxInclusiveAmount(BigDecimal taxInclusiveAmount) {
		this.taxInclusiveAmount = taxInclusiveAmount;
	}

}
