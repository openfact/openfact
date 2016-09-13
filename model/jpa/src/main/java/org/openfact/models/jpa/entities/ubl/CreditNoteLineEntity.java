package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
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

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.openfact.models.ubl.type.CodeType;
import org.openfact.models.ubl.type.IdentifierType;
import org.openfact.models.ubl.type.QuantityType;
import org.openfact.models.ubl.type.TextType;

/**
 * A class to define a line in a CreditNoteEntity or SelfBilledCreditNote.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:14 a. m.
 */
@Entity
@Table(name = "CREDIT_NOTE_LINE")
public class CreditNoteLineEntity {

	@Id
	@Column(name = "ID_OP", length = 36)
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Access(AccessType.PROPERTY)
	private String id;
	/**
	 * The buyer's accounting cost centre for this credit note line, expressed
	 * as text.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "ACCOUNTINGCOST_VALUE")),
			@AttributeOverride(name = "languageID", column = @Column(name = "ACCOUNTINGCOST_LANGUAGEID")) })
	private TextType accountingCost;
	/**
	 * The buyer's accounting cost centre for this credit note line, expressed
	 * as a code.
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
	 * The quantity of items credited in this credit note line.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "CREDITEDQUANTITY_VALUE")),
			@AttributeOverride(name = "unitCode", column = @Column(name = "CREDITEDQUANTITY_UNITCODE")) })
	private QuantityType creditedQuantity;
	/**
	 * An indicator that this credit note line is free of charge (true) or not
	 * (false). The default is false.
	 */
	@Type(type = "org.hibernate.type.NumericBooleanType")
	@Column(name = "FREE_OF_CHARGE_INDICATOR")
	private boolean freeOfChargeIndicator;
	/**
	 * An identifier for this credit note line.
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
	 * The total amount for this credit note line, including allowance charges
	 * but exclusive of taxes.
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
	 * The date of this credit note line, used to indicate the point at which
	 * tax becomes applicable.
	 */
	@Type(type = "org.hibernate.type.LocalDateType")
	@Column(name = "TAX_POINT_DATE")
	private LocalDate taxPointDate;
	/**
	 * A universally unique identifier for this credit note line.
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

	private List<AllowanceChargeEntity> allowanceCharges = new ArrayList<>();
	private List<BillingReferenceEntity> billingReferences = new ArrayList<>();
	private CreditNoteLineEntity subCreditNoteLine;
	private List<DeliveryEntity> deliveries = new ArrayList<>();
	private List<DeliveryTermsEntity> deliveriesTerms = new ArrayList<>();
	private List<DocumentReferenceEntity> documentReferences = new ArrayList<>();

	@OneToMany(mappedBy = "creditNoteLine", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
	private List<CreditNoteLineItemMappingEntity> items = new ArrayList<>();

	private LineReferenceEntity receiptLineReference;
	private LineReferenceEntity despatchLineReference;
	private List<OrderLineReferenceEntity> orderLineReferences = new ArrayList<>();
	private PartyEntity originatorParty;
	private List<PaymentTermsEntity> paymentTermses = new ArrayList<>();
	private PeriodEntity invoicePeriod;
	private List<PriceEntity> prices = new ArrayList<>();
	private PriceExtensionEntity itemPriceExtension;
	private List<PricingReferenceEntity> pricingReferences = new ArrayList<>();
	private ResponseEntity discrepancyResponse;
	private List<TaxTotalEntity> taxTotals = new ArrayList<>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey, name = "CREDIT_NOTE_ID")
	private CreditNoteEntity creditNote;

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
	 * @return the accountingCost
	 */
	public TextType getAccountingCost() {
		return accountingCost;
	}

	/**
	 * @param accountingCost the accountingCost to set
	 */
	public void setAccountingCost(TextType accountingCost) {
		this.accountingCost = accountingCost;
	}

	/**
	 * @return the accountingCostCode
	 */
	public CodeType getAccountingCostCode() {
		return accountingCostCode;
	}

	/**
	 * @param accountingCostCode the accountingCostCode to set
	 */
	public void setAccountingCostCode(CodeType accountingCostCode) {
		this.accountingCostCode = accountingCostCode;
	}

	/**
	 * @return the creditedQuantity
	 */
	public QuantityType getCreditedQuantity() {
		return creditedQuantity;
	}

	/**
	 * @param creditedQuantity the creditedQuantity to set
	 */
	public void setCreditedQuantity(QuantityType creditedQuantity) {
		this.creditedQuantity = creditedQuantity;
	}

	/**
	 * @return the freeOfChargeIndicator
	 */
	public boolean isFreeOfChargeIndicator() {
		return freeOfChargeIndicator;
	}

	/**
	 * @param freeOfChargeIndicator the freeOfChargeIndicator to set
	 */
	public void setFreeOfChargeIndicator(boolean freeOfChargeIndicator) {
		this.freeOfChargeIndicator = freeOfChargeIndicator;
	}

	/**
	 * @return the iD
	 */
	public IdentifierType getID() {
		return ID;
	}

	/**
	 * @param iD the iD to set
	 */
	public void setID(IdentifierType iD) {
		ID = iD;
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
	 * @return the note
	 */
	public TextType getNote() {
		return note;
	}

	/**
	 * @param note the note to set
	 */
	public void setNote(TextType note) {
		this.note = note;
	}

	/**
	 * @return the paymentPurposeCode
	 */
	public CodeType getPaymentPurposeCode() {
		return paymentPurposeCode;
	}

	/**
	 * @param paymentPurposeCode the paymentPurposeCode to set
	 */
	public void setPaymentPurposeCode(CodeType paymentPurposeCode) {
		this.paymentPurposeCode = paymentPurposeCode;
	}

	/**
	 * @return the taxPointDate
	 */
	public LocalDate getTaxPointDate() {
		return taxPointDate;
	}

	/**
	 * @param taxPointDate the taxPointDate to set
	 */
	public void setTaxPointDate(LocalDate taxPointDate) {
		this.taxPointDate = taxPointDate;
	}

	/**
	 * @return the uUID
	 */
	public IdentifierType getUUID() {
		return UUID;
	}

	/**
	 * @param uUID the uUID to set
	 */
	public void setUUID(IdentifierType uUID) {
		UUID = uUID;
	}

	/**
	 * @return the allowanceCharges
	 */
	public List<AllowanceChargeEntity> getAllowanceCharges() {
		return allowanceCharges;
	}

	/**
	 * @param allowanceCharges the allowanceCharges to set
	 */
	public void setAllowanceCharges(List<AllowanceChargeEntity> allowanceCharges) {
		this.allowanceCharges = allowanceCharges;
	}

	/**
	 * @return the billingReferences
	 */
	public List<BillingReferenceEntity> getBillingReferences() {
		return billingReferences;
	}

	/**
	 * @param billingReferences the billingReferences to set
	 */
	public void setBillingReferences(List<BillingReferenceEntity> billingReferences) {
		this.billingReferences = billingReferences;
	}

	/**
	 * @return the subCreditNoteLine
	 */
	public CreditNoteLineEntity getSubCreditNoteLine() {
		return subCreditNoteLine;
	}

	/**
	 * @param subCreditNoteLine the subCreditNoteLine to set
	 */
	public void setSubCreditNoteLine(CreditNoteLineEntity subCreditNoteLine) {
		this.subCreditNoteLine = subCreditNoteLine;
	}

	/**
	 * @return the deliveries
	 */
	public List<DeliveryEntity> getDeliveries() {
		return deliveries;
	}

	/**
	 * @param deliveries the deliveries to set
	 */
	public void setDeliveries(List<DeliveryEntity> deliveries) {
		this.deliveries = deliveries;
	}

	/**
	 * @return the deliveriesTerms
	 */
	public List<DeliveryTermsEntity> getDeliveriesTerms() {
		return deliveriesTerms;
	}

	/**
	 * @param deliveriesTerms the deliveriesTerms to set
	 */
	public void setDeliveriesTerms(List<DeliveryTermsEntity> deliveriesTerms) {
		this.deliveriesTerms = deliveriesTerms;
	}

	/**
	 * @return the documentReferences
	 */
	public List<DocumentReferenceEntity> getDocumentReferences() {
		return documentReferences;
	}

	/**
	 * @param documentReferences the documentReferences to set
	 */
	public void setDocumentReferences(List<DocumentReferenceEntity> documentReferences) {
		this.documentReferences = documentReferences;
	}

	/**
	 * @return the items
	 */
	public List<CreditNoteLineItemMappingEntity> getItems() {
		return items;
	}

	/**
	 * @param items the items to set
	 */
	public void setItems(List<CreditNoteLineItemMappingEntity> items) {
		this.items = items;
	}

	/**
	 * @return the receiptLineReference
	 */
	public LineReferenceEntity getReceiptLineReference() {
		return receiptLineReference;
	}

	/**
	 * @param receiptLineReference the receiptLineReference to set
	 */
	public void setReceiptLineReference(LineReferenceEntity receiptLineReference) {
		this.receiptLineReference = receiptLineReference;
	}

	/**
	 * @return the despatchLineReference
	 */
	public LineReferenceEntity getDespatchLineReference() {
		return despatchLineReference;
	}

	/**
	 * @param despatchLineReference the despatchLineReference to set
	 */
	public void setDespatchLineReference(LineReferenceEntity despatchLineReference) {
		this.despatchLineReference = despatchLineReference;
	}

	/**
	 * @return the orderLineReferences
	 */
	public List<OrderLineReferenceEntity> getOrderLineReferences() {
		return orderLineReferences;
	}

	/**
	 * @param orderLineReferences the orderLineReferences to set
	 */
	public void setOrderLineReferences(List<OrderLineReferenceEntity> orderLineReferences) {
		this.orderLineReferences = orderLineReferences;
	}

	/**
	 * @return the originatorParty
	 */
	public PartyEntity getOriginatorParty() {
		return originatorParty;
	}

	/**
	 * @param originatorParty the originatorParty to set
	 */
	public void setOriginatorParty(PartyEntity originatorParty) {
		this.originatorParty = originatorParty;
	}

	/**
	 * @return the paymentTermses
	 */
	public List<PaymentTermsEntity> getPaymentTermses() {
		return paymentTermses;
	}

	/**
	 * @param paymentTermses the paymentTermses to set
	 */
	public void setPaymentTermses(List<PaymentTermsEntity> paymentTermses) {
		this.paymentTermses = paymentTermses;
	}

	/**
	 * @return the invoicePeriod
	 */
	public PeriodEntity getInvoicePeriod() {
		return invoicePeriod;
	}

	/**
	 * @param invoicePeriod the invoicePeriod to set
	 */
	public void setInvoicePeriod(PeriodEntity invoicePeriod) {
		this.invoicePeriod = invoicePeriod;
	}

	/**
	 * @return the prices
	 */
	public List<PriceEntity> getPrices() {
		return prices;
	}

	/**
	 * @param prices the prices to set
	 */
	public void setPrices(List<PriceEntity> prices) {
		this.prices = prices;
	}

	/**
	 * @return the itemPriceExtension
	 */
	public PriceExtensionEntity getItemPriceExtension() {
		return itemPriceExtension;
	}

	/**
	 * @param itemPriceExtension the itemPriceExtension to set
	 */
	public void setItemPriceExtension(PriceExtensionEntity itemPriceExtension) {
		this.itemPriceExtension = itemPriceExtension;
	}

	/**
	 * @return the pricingReferences
	 */
	public List<PricingReferenceEntity> getPricingReferences() {
		return pricingReferences;
	}

	/**
	 * @param pricingReferences the pricingReferences to set
	 */
	public void setPricingReferences(List<PricingReferenceEntity> pricingReferences) {
		this.pricingReferences = pricingReferences;
	}

	/**
	 * @return the discrepancyResponse
	 */
	public ResponseEntity getDiscrepancyResponse() {
		return discrepancyResponse;
	}

	/**
	 * @param discrepancyResponse the discrepancyResponse to set
	 */
	public void setDiscrepancyResponse(ResponseEntity discrepancyResponse) {
		this.discrepancyResponse = discrepancyResponse;
	}

	/**
	 * @return the taxTotals
	 */
	public List<TaxTotalEntity> getTaxTotals() {
		return taxTotals;
	}

	/**
	 * @param taxTotals the taxTotals to set
	 */
	public void setTaxTotals(List<TaxTotalEntity> taxTotals) {
		this.taxTotals = taxTotals;
	}

	/**
	 * @return the creditNote
	 */
	public CreditNoteEntity getCreditNote() {
		return creditNote;
	}

	/**
	 * @param creditNote the creditNote to set
	 */
	public void setCreditNote(CreditNoteEntity creditNote) {
		this.creditNote = creditNote;
	}
	
	

}
