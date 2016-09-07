package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * A class to define a line in an Invoice.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:37 a. m.
 */
public class InvoiceLine {

	/**
	 * The buyer's accounting cost centre for this invoice line, expressed as
	 * text.
	 */
	private String accountingCost;
	/**
	 * The buyer's accounting cost centre for this invoice line, expressed as a
	 * code.
	 */
	private String accountingCostCode;
	/**
	 * An indicator that this invoice line is free of charge (true) or not
	 * (false). The default is false.
	 */
	private boolean freeOfChargeIndicator;
	/**
	 * An identifier for this invoice line.
	 */
	private String ID;
	/**
	 * The quantity (of items) on this invoice line.
	 */
	private BigDecimal invoicedQuantity;
	/**
	 * The total amount for this invoice line, including allowance charges but
	 * net of taxes.
	 */
	private BigDecimal lineExtensionAmount;
	/**
	 * Free-form text conveying information that is not contained explicitly in
	 * other structures.
	 */
	private String note;
	/**
	 * A code signifying the business purpose for this payment.
	 */
	private String paymentPurposeCode;
	/**
	 * The date of this invoice line, used to indicate the point at which tax
	 * becomes applicable.
	 */
	private LocalDate taxPointDate;
	/**
	 * A universally unique identifier for this invoice line.
	 */
	private String UUID;
	private AllowanceCharge m_AllowanceCharge;
	private BillingReference m_BillingReference;
	private Delivery m_Delivery;
	private DeliveryTerms m_DeliveryTerms;
	private List<DocumentReference> documentReferences = new ArrayList<>();
	private List<Item> items = new ArrayList<>();
	private LineReference despatchLineReference;
	private LineReference receiptLineReference;
	private OrderLineReference m_OrderLineReference;
	private Party originatorParty;
	private PaymentTerms m_PaymentTerms;
	private Period invoicePeriod;
	private InvoiceLine subInvoiceLine;
	private Price m_Price;
	private PriceExtension ItemPriceExtension;
	private PricingReference m_PricingReference;
	private TaxTotal withholdingTaxTotal;
	private TaxTotal m_TaxTotal;

	public String getAccountingCost() {
		return accountingCost;
	}

	public void setAccountingCost(String accountingCost) {
		this.accountingCost = accountingCost;
	}

	public String getAccountingCostCode() {
		return accountingCostCode;
	}

	public void setAccountingCostCode(String accountingCostCode) {
		this.accountingCostCode = accountingCostCode;
	}

	public boolean isFreeOfChargeIndicator() {
		return freeOfChargeIndicator;
	}

	public void setFreeOfChargeIndicator(boolean freeOfChargeIndicator) {
		this.freeOfChargeIndicator = freeOfChargeIndicator;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public BigDecimal getInvoicedQuantity() {
		return invoicedQuantity;
	}

	public void setInvoicedQuantity(BigDecimal invoicedQuantity) {
		this.invoicedQuantity = invoicedQuantity;
	}

	public BigDecimal getLineExtensionAmount() {
		return lineExtensionAmount;
	}

	public void setLineExtensionAmount(BigDecimal lineExtensionAmount) {
		this.lineExtensionAmount = lineExtensionAmount;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getPaymentPurposeCode() {
		return paymentPurposeCode;
	}

	public void setPaymentPurposeCode(String paymentPurposeCode) {
		this.paymentPurposeCode = paymentPurposeCode;
	}

	public LocalDate getTaxPointDate() {
		return taxPointDate;
	}

	public void setTaxPointDate(LocalDate taxPointDate) {
		this.taxPointDate = taxPointDate;
	}

	public String getUUID() {
		return UUID;
	}

	public void setUUID(String UUID) {
		this.UUID = UUID;
	}

	public AllowanceCharge getM_AllowanceCharge() {
		return m_AllowanceCharge;
	}

	public void setM_AllowanceCharge(AllowanceCharge m_AllowanceCharge) {
		this.m_AllowanceCharge = m_AllowanceCharge;
	}

	public BillingReference getM_BillingReference() {
		return m_BillingReference;
	}

	public void setM_BillingReference(BillingReference m_BillingReference) {
		this.m_BillingReference = m_BillingReference;
	}

	public Delivery getM_Delivery() {
		return m_Delivery;
	}

	public void setM_Delivery(Delivery m_Delivery) {
		this.m_Delivery = m_Delivery;
	}

	public DeliveryTerms getM_DeliveryTerms() {
		return m_DeliveryTerms;
	}

	public void setM_DeliveryTerms(DeliveryTerms m_DeliveryTerms) {
		this.m_DeliveryTerms = m_DeliveryTerms;
	}

	public DocumentReference getM_DocumentReference() {
		return m_DocumentReference;
	}

	public void setM_DocumentReference(DocumentReference m_DocumentReference) {
		this.m_DocumentReference = m_DocumentReference;
	}

	public Item getM_Item() {
		return m_Item;
	}

	public void setM_Item(Item m_Item) {
		this.m_Item = m_Item;
	}

	public LineReference getDespatchLineReference() {
		return despatchLineReference;
	}

	public void setDespatchLineReference(LineReference despatchLineReference) {
		this.despatchLineReference = despatchLineReference;
	}

	public LineReference getReceiptLineReference() {
		return receiptLineReference;
	}

	public void setReceiptLineReference(LineReference receiptLineReference) {
		this.receiptLineReference = receiptLineReference;
	}

	public OrderLineReference getM_OrderLineReference() {
		return m_OrderLineReference;
	}

	public void setM_OrderLineReference(OrderLineReference m_OrderLineReference) {
		this.m_OrderLineReference = m_OrderLineReference;
	}

	public Party getOriginatorParty() {
		return originatorParty;
	}

	public void setOriginatorParty(Party originatorParty) {
		this.originatorParty = originatorParty;
	}

	public PaymentTerms getM_PaymentTerms() {
		return m_PaymentTerms;
	}

	public void setM_PaymentTerms(PaymentTerms m_PaymentTerms) {
		this.m_PaymentTerms = m_PaymentTerms;
	}

	public Period getInvoicePeriod() {
		return invoicePeriod;
	}

	public void setInvoicePeriod(Period invoicePeriod) {
		this.invoicePeriod = invoicePeriod;
	}

	public InvoiceLine getSubInvoiceLine() {
		return subInvoiceLine;
	}

	public void setSubInvoiceLine(InvoiceLine subInvoiceLine) {
		this.subInvoiceLine = subInvoiceLine;
	}

	public Price getM_Price() {
		return m_Price;
	}

	public void setM_Price(Price m_Price) {
		this.m_Price = m_Price;
	}

	public PriceExtension getItemPriceExtension() {
		return ItemPriceExtension;
	}

	public void setItemPriceExtension(PriceExtension itemPriceExtension) {
		ItemPriceExtension = itemPriceExtension;
	}

	public PricingReference getM_PricingReference() {
		return m_PricingReference;
	}

	public void setM_PricingReference(PricingReference m_PricingReference) {
		this.m_PricingReference = m_PricingReference;
	}

	public TaxTotal getWithholdingTaxTotal() {
		return withholdingTaxTotal;
	}

	public void setWithholdingTaxTotal(TaxTotal withholdingTaxTotal) {
		this.withholdingTaxTotal = withholdingTaxTotal;
	}

	public TaxTotal getM_TaxTotal() {
		return m_TaxTotal;
	}

	public void setM_TaxTotal(TaxTotal m_TaxTotal) {
		this.m_TaxTotal = m_TaxTotal;
	}
}// end Invoice Line