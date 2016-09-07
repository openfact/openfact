package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * A class to define a line in a Credit Note or Self Billed Credit Note.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:14 a. m.
 */
public class CreditNoteLine {

	/**
	 * The buyer's accounting cost centre for this credit note line, expressed
	 * as text.
	 */
	private String accountingCost;
	/**
	 * The buyer's accounting cost centre for this credit note line, expressed
	 * as a code.
	 */
	private String accountingCostCode;
	/**
	 * The quantity of items credited in this credit note line.
	 */
	private BigDecimal creditedQuantity;
	/**
	 * An indicator that this credit note line is free of charge (true) or not
	 * (false). The default is false.
	 */
	private boolean freeOfChargeIndicator;
	/**
	 * An identifier for this credit note line.
	 */
	private String ID;
	/**
	 * The total amount for this credit note line, including allowance charges
	 * but exclusive of taxes.
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
	 * The date of this credit note line, used to indicate the point at which
	 * tax becomes applicable.
	 */
	private LocalDate taxPointDate;
	/**
	 * A universally unique identifier for this credit note line.
	 */
	private String UUID;
	private List<AllowanceCharge> allowanceCharges= new ArrayList<>();
	private BillingReference billingReference;
	private CreditNoteLine subCreditNoteLine;
	private List<Delivery> deliveries= new ArrayList<>();
	private List<DeliveryTerms> deliveryTerms= new ArrayList<>();
	private List<DocumentReference> documentReferences= new ArrayList<>();
	private List<Item> items= new ArrayList<>();
	private LineReference receiptLineReference;
	private LineReference despatchLineReference;
	private List<OrderLineReference> orderLineReferences= new ArrayList<>();
	private Party originatorParty;
	private List<PaymentTerms> paymentTerms= new ArrayList<>();
	private Period invoicePeriod;
	private List<Price> prices= new ArrayList<>();
	private PriceExtension itemPriceExtension;
	private List<PricingReference> pricingReferences= new ArrayList<>();
	private Response discrepancyResponse;
	private List<TaxTotal> taxTotals= new ArrayList<>();

	public CreditNoteLine() {

	}

	public void finalize() throws Throwable {

	}

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

	public BigDecimal getCreditedQuantity() {
		return creditedQuantity;
	}

	public void setCreditedQuantity(BigDecimal creditedQuantity) {
		this.creditedQuantity = creditedQuantity;
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

	public List<AllowanceCharge> getAllowanceCharges() {
		return allowanceCharges;
	}

	public void setAllowanceCharges(List<AllowanceCharge> allowanceCharges) {
		this.allowanceCharges = allowanceCharges;
	}

	public BillingReference getBillingReference() {
		return billingReference;
	}

	public void setBillingReference(BillingReference billingReference) {
		this.billingReference = billingReference;
	}

	public CreditNoteLine getSubCreditNoteLine() {
		return subCreditNoteLine;
	}

	public void setSubCreditNoteLine(CreditNoteLine subCreditNoteLine) {
		this.subCreditNoteLine = subCreditNoteLine;
	}

	public List<Delivery> getDeliveries() {
		return deliveries;
	}

	public void setDeliveries(List<Delivery> deliveries) {
		this.deliveries = deliveries;
	}

	public List<DeliveryTerms> getDeliveryTerms() {
		return deliveryTerms;
	}

	public void setDeliveryTerms(List<DeliveryTerms> deliveryTerms) {
		this.deliveryTerms = deliveryTerms;
	}

	public List<DocumentReference> getDocumentReferences() {
		return documentReferences;
	}

	public void setDocumentReferences(List<DocumentReference> documentReferences) {
		this.documentReferences = documentReferences;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public LineReference getReceiptLineReference() {
		return receiptLineReference;
	}

	public void setReceiptLineReference(LineReference receiptLineReference) {
		this.receiptLineReference = receiptLineReference;
	}

	public LineReference getDespatchLineReference() {
		return despatchLineReference;
	}

	public void setDespatchLineReference(LineReference despatchLineReference) {
		this.despatchLineReference = despatchLineReference;
	}

	public List<OrderLineReference> getOrderLineReferences() {
		return orderLineReferences;
	}

	public void setOrderLineReferences(List<OrderLineReference> orderLineReferences) {
		this.orderLineReferences = orderLineReferences;
	}

	public Party getOriginatorParty() {
		return originatorParty;
	}

	public void setOriginatorParty(Party originatorParty) {
		this.originatorParty = originatorParty;
	}

	public List<PaymentTerms> getPaymentTerms() {
		return paymentTerms;
	}

	public void setPaymentTerms(List<PaymentTerms> paymentTerms) {
		this.paymentTerms = paymentTerms;
	}

	public Period getInvoicePeriod() {
		return invoicePeriod;
	}

	public void setInvoicePeriod(Period invoicePeriod) {
		this.invoicePeriod = invoicePeriod;
	}

	public List<Price> getPrices() {
		return prices;
	}

	public void setPrices(List<Price> prices) {
		this.prices = prices;
	}

	public PriceExtension getItemPriceExtension() {
		return itemPriceExtension;
	}

	public void setItemPriceExtension(PriceExtension itemPriceExtension) {
		this.itemPriceExtension = itemPriceExtension;
	}

	public List<PricingReference> getPricingReferences() {
		return pricingReferences;
	}

	public void setPricingReferences(List<PricingReference> pricingReferences) {
		this.pricingReferences = pricingReferences;
	}

	public Response getDiscrepancyResponse() {
		return discrepancyResponse;
	}

	public void setDiscrepancyResponse(Response discrepancyResponse) {
		this.discrepancyResponse = discrepancyResponse;
	}

	public List<TaxTotal> getTaxTotals() {
		return taxTotals;
	}

	public void setTaxTotals(List<TaxTotal> taxTotals) {
		this.taxTotals = taxTotals;
	}
}// end Credit Note Line