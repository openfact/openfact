package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.util.ArrayList;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.openfact.models.jpa.entities.ublType.*;

/**
 * A class to define a line in an Invoice.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:37 a. m.
 */
@Entity
@Table(name = "INVOICE_LINE")
public class InvoiceLineEntity {

	@Id
	@Column(name = "ID_OP", length = 36)
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Access(AccessType.PROPERTY)
	private String id;
	/**
	 * The buyer's accounting cost centre for this invoice line, expressed as
	 * text.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "ACCOUNTINGCOST_VALUE")),
			@AttributeOverride(name = "languageID", column = @Column(name = "ACCOUNTINGCOST_LANGUAGEID")) })
	private TextType accountingCost;
	/**
	 * The buyer's accounting cost centre for this invoice line, expressed as a
	 * code.
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
	 * An indicator that this invoice line is free of charge (true) or not
	 * (false). The default is false.
	 */
	@Type(type = "org.hibernate.type.NumericBooleanType")
	@Column(name = "FREE_OF_CHARGE_INDICATOR")
	private boolean freeOfChargeIndicator;
	/**
	 * An identifier for this invoice line.
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
	 * The quantity (of items) on this invoice line.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "INVOICEQUANTITY_VALUE")),
			@AttributeOverride(name = "unitCode", column = @Column(name = "INVOICEQUANTITY_UNITCODE")) })
	private QuantityType invoicedQuantity;
	/**
	 * The total amount for this invoice line, including allowance charges but
	 * net of taxes.
	 */
	@Column(name = "LINE_EXTENSION_AMOUNT")
	private BigDecimal lineExtensionAmount;
	/**
	 * Free-form text conveying information that is not contained explicitly in
	 * other structures.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "NOTE_VALUE")),
			@AttributeOverride(name = "languageID", column = @Column(name = "NOTE_LANGUAGEID")) })
	private TextType note;
	/**
	 * A code signifying the business purpose for this payment.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "PAYMENTPURPOSECODE_VALUE")),
			@AttributeOverride(name = "listID", column = @Column(name = "PAYMENTPURPOSECODE_LISTID")),
			@AttributeOverride(name = "listAgencyID", column = @Column(name = "PAYMENTPURPOSECODE_LISTAGENCYID")),
			@AttributeOverride(name = "listAgencyName", column = @Column(name = "PAYMENTPURPOSECODE_LISTAGENCYNAME")),
			@AttributeOverride(name = "listName", column = @Column(name = "PAYMENTPURPOSECODE_LISTNAME")),
			@AttributeOverride(name = "listVersionID", column = @Column(name = "PAYMENTPURPOSECODE_LISTVERSIONID")),
			@AttributeOverride(name = "name", column = @Column(name = "PAYMENTPURPOSECODE_NAME")),
			@AttributeOverride(name = "languageID", column = @Column(name = "PAYMENTPURPOSECODE_LANGUAGEID")),
			@AttributeOverride(name = "listURI", column = @Column(name = "PAYMENTPURPOSECODE_LISTURI")),
			@AttributeOverride(name = "listSchemeURI", column = @Column(name = "PAYMENTPURPOSECODE_LISTSCHEMEURI")) })
	private CodeType paymentPurposeCode;
	/**
	 * The date of this invoice line, used to indicate the point at which tax
	 * becomes applicable.
	 */
	@Type(type = "org.hibernate.type.LocalDateType")
	@Column(name = "TAX_POINT_DATE")
	private LocalDate taxPointDate;
	/**
	 * A universally unique identifier for this invoice line.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "UUID_VALUE")),
			@AttributeOverride(name = "schemeID", column = @Column(name = "UUID_SCHEMEID")),
			@AttributeOverride(name = "schemeName", column = @Column(name = "UUID_SCHEMENAME")),
			@AttributeOverride(name = "schemeAgencyID", column = @Column(name = "UUID_SCHEMEAGENCYID")),
			@AttributeOverride(name = "schemeAgencyName", column = @Column(name = "UUID_SCHEMEAGENCYNAME")),
			@AttributeOverride(name = "schemeVersionID", column = @Column(name = "UUID_SCHEMEVERSIONID")),
			@AttributeOverride(name = "schemeDataURI", column = @Column(name = "UUID_SCHEMEDATAURI")),
			@AttributeOverride(name = "schemeURI", column = @Column(name = "UUID_SCHEMEURI")) })
	private IdentifierType UUID;

	@OneToMany(mappedBy = "invoiceLine", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
	private List<AllowanceChargeEntity> allowanceCharges = new ArrayList<>();

	@Transient
	private List<BillingReferenceEntity> billingReferences = new ArrayList<>();
	@Transient
	private List<DeliveryEntity> deliveries = new ArrayList<>();
	@Transient
	private List<DeliveryTermsEntity> deliveriesTerms = new ArrayList<>();
	@Transient
	private List<DocumentReferenceEntity> documentReferences = new ArrayList<>();
	@Transient
	private List<ItemEntity> items = new ArrayList<>();
	@Transient
	private LineReferenceEntity despatchLineReference;
	@Transient
	private LineReferenceEntity receiptLineReference;
	@Transient
	private List<OrderLineReferenceEntity> orderLineReferences = new ArrayList<>();
	@Transient
	private PartyEntity originatorParty;
	@Transient
	private List<PaymentTermsEntity> paymentTermses = new ArrayList<>();
	@Transient
	private PeriodEntity invoicePeriod;
	@Transient
	private InvoiceLineEntity subInvoiceLine;
	@Transient
	private List<PriceEntity> prices = new ArrayList<>();
	@Transient
	private PriceExtensionEntity itemPriceExtension;
	@Transient
	private List<PricingReferenceEntity> pricingReferences = new ArrayList<>();
	@Transient
	private List<TaxTotalEntity> withholdingTaxTotal = new ArrayList<>();
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

	public boolean isFreeOfChargeIndicator() {
		return freeOfChargeIndicator;
	}

	public void setFreeOfChargeIndicator(boolean freeOfChargeIndicator) {
		this.freeOfChargeIndicator = freeOfChargeIndicator;
	}

	public IdentifierType getID() {
		return ID;
	}

	public void setID(IdentifierType iD) {
		ID = iD;
	}

	public QuantityType getInvoicedQuantity() {
		return invoicedQuantity;
	}

	public void setInvoicedQuantity(QuantityType invoicedQuantity) {
		this.invoicedQuantity = invoicedQuantity;
	}

	public BigDecimal getLineExtensionAmount() {
		return lineExtensionAmount;
	}

	public void setLineExtensionAmount(BigDecimal lineExtensionAmount) {
		this.lineExtensionAmount = lineExtensionAmount;
	}

	public TextType getNote() {
		return note;
	}

	public void setNote(TextType note) {
		this.note = note;
	}

	public CodeType getPaymentPurposeCode() {
		return paymentPurposeCode;
	}

	public void setPaymentPurposeCode(CodeType paymentPurposeCode) {
		this.paymentPurposeCode = paymentPurposeCode;
	}

	public LocalDate getTaxPointDate() {
		return taxPointDate;
	}

	public void setTaxPointDate(LocalDate taxPointDate) {
		this.taxPointDate = taxPointDate;
	}

	public IdentifierType getUUID() {
		return UUID;
	}

	public void setUUID(IdentifierType uUID) {
		UUID = uUID;
	}

	public List<AllowanceChargeEntity> getAllowanceCharges() {
		return allowanceCharges;
	}

	public void setAllowanceCharges(List<AllowanceChargeEntity> allowanceCharges) {
		this.allowanceCharges = allowanceCharges;
	}

	public List<BillingReferenceEntity> getBillingReferences() {
		return billingReferences;
	}

	public void setBillingReferences(List<BillingReferenceEntity> billingReferences) {
		this.billingReferences = billingReferences;
	}

	public List<DeliveryEntity> getDeliveries() {
		return deliveries;
	}

	public void setDeliveries(List<DeliveryEntity> deliveries) {
		this.deliveries = deliveries;
	}

	public List<DeliveryTermsEntity> getDeliveriesTerms() {
		return deliveriesTerms;
	}

	public void setDeliveriesTerms(List<DeliveryTermsEntity> deliveriesTerms) {
		this.deliveriesTerms = deliveriesTerms;
	}

	public List<DocumentReferenceEntity> getDocumentReferences() {
		return documentReferences;
	}

	public void setDocumentReferences(List<DocumentReferenceEntity> documentReferences) {
		this.documentReferences = documentReferences;
	}

	public List<ItemEntity> getItems() {
		return items;
	}

	public void setItems(List<ItemEntity> items) {
		this.items = items;
	}

	public LineReferenceEntity getDespatchLineReference() {
		return despatchLineReference;
	}

	public void setDespatchLineReference(LineReferenceEntity despatchLineReference) {
		this.despatchLineReference = despatchLineReference;
	}

	public LineReferenceEntity getReceiptLineReference() {
		return receiptLineReference;
	}

	public void setReceiptLineReference(LineReferenceEntity receiptLineReference) {
		this.receiptLineReference = receiptLineReference;
	}

	public List<OrderLineReferenceEntity> getOrderLineReferences() {
		return orderLineReferences;
	}

	public void setOrderLineReferences(List<OrderLineReferenceEntity> orderLineReferences) {
		this.orderLineReferences = orderLineReferences;
	}

	public PartyEntity getOriginatorParty() {
		return originatorParty;
	}

	public void setOriginatorParty(PartyEntity originatorParty) {
		this.originatorParty = originatorParty;
	}

	public List<PaymentTermsEntity> getPaymentTermses() {
		return paymentTermses;
	}

	public void setPaymentTermses(List<PaymentTermsEntity> paymentTermses) {
		this.paymentTermses = paymentTermses;
	}

	public PeriodEntity getInvoicePeriod() {
		return invoicePeriod;
	}

	public void setInvoicePeriod(PeriodEntity invoicePeriod) {
		this.invoicePeriod = invoicePeriod;
	}

	public InvoiceLineEntity getSubInvoiceLine() {
		return subInvoiceLine;
	}

	public void setSubInvoiceLine(InvoiceLineEntity subInvoiceLine) {
		this.subInvoiceLine = subInvoiceLine;
	}

	public List<PriceEntity> getPrices() {
		return prices;
	}

	public void setPrices(List<PriceEntity> prices) {
		this.prices = prices;
	}

	public PriceExtensionEntity getItemPriceExtension() {
		return itemPriceExtension;
	}

	public void setItemPriceExtension(PriceExtensionEntity itemPriceExtension) {
		this.itemPriceExtension = itemPriceExtension;
	}

	public List<PricingReferenceEntity> getPricingReferences() {
		return pricingReferences;
	}

	public void setPricingReferences(List<PricingReferenceEntity> pricingReferences) {
		this.pricingReferences = pricingReferences;
	}

	public List<TaxTotalEntity> getWithholdingTaxTotal() {
		return withholdingTaxTotal;
	}

	public void setWithholdingTaxTotal(List<TaxTotalEntity> withholdingTaxTotal) {
		this.withholdingTaxTotal = withholdingTaxTotal;
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
		InvoiceLineEntity other = (InvoiceLineEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
