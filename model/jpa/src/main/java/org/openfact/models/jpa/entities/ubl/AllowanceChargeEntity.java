package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.util.ArrayList;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.openfact.models.jpa.entities.ublType.*;

/**
 * A class to describe information about a charge or discount as applied to a
 * price component.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:12:43 a. m.
 */
@Entity
@Table(name = "ALLOWANCE_CHARGE")
public class AllowanceChargeEntity {

	@Id
	@Column(name = "ID_OP", length = 36)
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Access(AccessType.PROPERTY)
	private String id;
	/**
	 * The accounting cost centre used by the buyer to account for this
	 * allowance or charge, expressed as text.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "ACCOUNTINGCOST_VALUE")),
			@AttributeOverride(name = "languageID", column = @Column(name = "ACCOUNTINGCOST_LANGUAGEID")) })
	private TextType accountingCost;
	/**
	 * The accounting cost centre used by the buyer to account for this
	 * allowance or charge, expressed as a code.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "ACCOUNTINGCOSTCODE_VALUE")),
			@AttributeOverride(name = "listID", column = @Column(name = "ACCOUNTINGCOSTCODE_LISTID")),
			@AttributeOverride(name = "listAgencyID", column = @Column(name = "ACCOUNTINGCOSTCODE_LISTAGENCYID")),
			@AttributeOverride(name = "listAgencyName", column = @Column(name = "ACCOUNTINGCOSTCODE_LISTAGENCYNAME")),
			@AttributeOverride(name = "listName", column = @Column(name = "ACCOUNTINGCOSTCODE_LISTNAME")),
			@AttributeOverride(name = "listVersionID", column = @Column(name = "ACCOUNTINGCOSTCODE_LISTVERSIONID")),
			@AttributeOverride(name = "name", column = @Column(name = "ACCOUNTINGCOSTCODE_NAME")),
			@AttributeOverride(name = "languageID", column = @Column(name = "ACCOUNTINGCOSTCODE_LANGUAGEID")),
			@AttributeOverride(name = "listURI", column = @Column(name = "ACCOUNTINGCOSTCODE_LISTURI")),
			@AttributeOverride(name = "listSchemeURI", column = @Column(name = "ACCOUNTINGCOSTCODE_LISTSCHEMEURI")) })
	private CodeType accountingCostCode;
	/**
	 * The reason for this allowance or charge.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "ALLOWANCECHARGEREASON_VALUE")),
			@AttributeOverride(name = "languageID", column = @Column(name = "ALLOWANCECHARGEREASON_LANGUAGEID")) })
	private TextType allowanceChargeReason;
	/**
	 * A mutually agreed code signifying the reason for this allowance or
	 * charge.
	 */
	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "value", column = @Column(name = "ALLOWANCECHARGEREASONCODE_VALUE")),
			@AttributeOverride(name = "listID", column = @Column(name = "ALLOWANCECHARGEREASONCODE_LISTID")),
			@AttributeOverride(name = "listAgencyID", column = @Column(name = "ALLOWANCECHARGEREASONCODE_LISTAGENCYID")),
			@AttributeOverride(name = "listAgencyName", column = @Column(name = "ALLOWANCECHARGEREASONCODE_LISTAGENCYNAME")),
			@AttributeOverride(name = "listName", column = @Column(name = "ALLOWANCECHARGEREASONCODE_LISTNAME")),
			@AttributeOverride(name = "listVersionID", column = @Column(name = "ALLOWANCECHARGEREASONCODE_LISTVERSIONID")),
			@AttributeOverride(name = "name", column = @Column(name = "ALLOWANCECHARGEREASONCODE_NAME")),
			@AttributeOverride(name = "languageID", column = @Column(name = "ALLOWANCECHARGEREASONCODE_LANGUAGEID")),
			@AttributeOverride(name = "listURI", column = @Column(name = "ALLOWANCECHARGEREASONCODE_LISTURI")),
			@AttributeOverride(name = "listSchemeURI", column = @Column(name = "ALLOWANCECHARGEREASONCODE_LISTSCHEMEURI")) })
	private AllowanceChargeReasonCodeType allowanceChargeReasonCode;
	/**
	 * The monetary amount of this allowance or charge to be applied.
	 */
	@Column(name = "AMOUNT")
	private BigDecimal amount;
	/**
	 * The monetary amount to which the multiplier factor is applied in
	 * calculating the amount of this allowance or charge.
	 */
	@Column(name = "BASE_AMOUNT")
	private BigDecimal baseAmount;
	/**
	 * An indicator that this AllowanceChargeEntity describes a charge (true) or
	 * a discount (false).
	 */
	@Type(type = "org.hibernate.type.NumericBooleanType")
	@Column(name = "CHARGE_INDICATOR")
	private boolean chargeIndicator;
	/**
	 * An identifier for this allowance or charge.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "ID_VALUE")),
			@AttributeOverride(name = "schemeID", column = @Column(name = "ID_SCHEMEID")),
			@AttributeOverride(name = "schemeName", column = @Column(name = "ID_SCHEMENAME")),
			@AttributeOverride(name = "schemeAgencyID", column = @Column(name = "ID_SCHEMEAGENCYID")),
			@AttributeOverride(name = "schemeAgencyName", column = @Column(name = "ID_SCHEMEAGENCYNAME")),
			@AttributeOverride(name = "schemeVersionID", column = @Column(name = "ID_SCHEMEVERSIONID")),
			@AttributeOverride(name = "schemeDataURI", column = @Column(name = "ID_SCHEMEDATAURI")),
			@AttributeOverride(name = "schemeURI", column = @Column(name = "ID_SCHEMEURI")) })
	private IdentifierType ID;
	/**
	 * A number by which the base amount is multiplied to calculate the actual
	 * amount of this allowance or charge.
	 */
	@Column(name = "MULTIPLIER_FACTOR_NUMERIC")
	private BigDecimal multiplierFactorNumeric;
	/**
	 * The allowance or charge per item; the total allowance or charge is
	 * calculated by multiplying the per unit amount by the quantity of items,
	 * either at the level of the individual transaction line or for the total
	 * number of items in the document, depending o
	 */
	@Column(name = "PER_UNIT_AMOUNT")
	private BigDecimal perUnitAmount;
	/**
	 * An indicator that this allowance or charge is prepaid (true) or not
	 * (false).
	 */
	@Type(type = "org.hibernate.type.NumericBooleanType")
	@Column(name = "PREPAID_INDICATOR")
	private boolean prepaidIndicator;
	/**
	 * A number indicating the order of this allowance or charge in the sequence
	 * of calculations applied when there are multiple allowances or charges.
	 */
	@Column(name = "SEQUENCE_NUMERIC")
	private BigDecimal sequenceNumeric;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey, name = "INVOICE_LINE_ID")
	private InvoiceLineEntity invoiceLine;
	
	@OneToMany(mappedBy = "allowanceCharge", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
	private List<PaymentMeansEntity> paymentMeanses = new ArrayList<>();
	
	@Transient
	private List<TaxCategoryEntity> taxCategories = new ArrayList<>();
	@Transient
	private List<TaxTotalEntity> taxTotals = new ArrayList<>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public TextType getAccountingCost() {
		return accountingCost;
	}

	public void setAccountingCost(TextType accountingCost) {
		this.accountingCost = accountingCost;
	}

	public CodeType getAccountingCostCode() {
		return accountingCostCode;
	}

	public void setAccountingCostCode(CodeType accountingCostCode) {
		this.accountingCostCode = accountingCostCode;
	}

	public TextType getAllowanceChargeReason() {
		return allowanceChargeReason;
	}

	public void setAllowanceChargeReason(TextType allowanceChargeReason) {
		this.allowanceChargeReason = allowanceChargeReason;
	}

	public AllowanceChargeReasonCodeType getAllowanceChargeReasonCode() {
		return allowanceChargeReasonCode;
	}

	public void setAllowanceChargeReasonCode(AllowanceChargeReasonCodeType allowanceChargeReasonCode) {
		this.allowanceChargeReasonCode = allowanceChargeReasonCode;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getBaseAmount() {
		return baseAmount;
	}

	public void setBaseAmount(BigDecimal baseAmount) {
		this.baseAmount = baseAmount;
	}

	public boolean isChargeIndicator() {
		return chargeIndicator;
	}

	public void setChargeIndicator(boolean chargeIndicator) {
		this.chargeIndicator = chargeIndicator;
	}

	public IdentifierType getID() {
		return ID;
	}

	public void setID(IdentifierType ID) {
		this.ID = ID;
	}

	public BigDecimal getMultiplierFactorNumeric() {
		return multiplierFactorNumeric;
	}

	public void setMultiplierFactorNumeric(BigDecimal multiplierFactorNumeric) {
		this.multiplierFactorNumeric = multiplierFactorNumeric;
	}

	public BigDecimal getPerUnitAmount() {
		return perUnitAmount;
	}

	public void setPerUnitAmount(BigDecimal perUnitAmount) {
		this.perUnitAmount = perUnitAmount;
	}

	public boolean isPrepaidIndicator() {
		return prepaidIndicator;
	}

	public void setPrepaidIndicator(boolean prepaidIndicator) {
		this.prepaidIndicator = prepaidIndicator;
	}

	public BigDecimal getSequenceNumeric() {
		return sequenceNumeric;
	}

	public void setSequenceNumeric(BigDecimal sequenceNumeric) {
		this.sequenceNumeric = sequenceNumeric;
	}

	public InvoiceLineEntity getInvoiceLine() {
		return invoiceLine;
	}

	public void setInvoiceLine(InvoiceLineEntity invoiceLine) {
		this.invoiceLine = invoiceLine;
	}

	public List<PaymentMeansEntity> getPaymentMeanses() {
		return paymentMeanses;
	}

	public void setPaymentMeanses(List<PaymentMeansEntity> paymentMeanses) {
		this.paymentMeanses = paymentMeanses;
	}

	public List<TaxCategoryEntity> getTaxCategories() {
		return taxCategories;
	}

	public void setTaxCategories(List<TaxCategoryEntity> taxCategories) {
		this.taxCategories = taxCategories;
	}

	public List<TaxTotalEntity> getTaxTotals() {
		return taxTotals;
	}

	public void setTaxTotals(List<TaxTotalEntity> taxTotals) {
		this.taxTotals = taxTotals;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AllowanceChargeEntity other = (AllowanceChargeEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
