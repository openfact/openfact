package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * A class to define a line in a Debit Note.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:19 a. m.
 */
public class DebitNoteLine {

	/**
	 * The buyer's accounting cost centre for this debit note line, expressed as
	 * text.
	 */
	private String AccountingCost;
	/**
	 * The buyer's accounting cost centre for this debit note line, expressed as
	 * a code.
	 */
	private String AccountingCostCode;
	/**
	 * The quantity of Items debited in this debit note line.
	 */
	private BigDecimal DebitedQuantity;
	/**
	 * An identifier for this debit note line.
	 */
	private String ID;
	/**
	 * The total amount for this debit note line, including allowance charges
	 * but net of taxes.
	 */
	private BigDecimal LineExtensionAmount;
	/**
	 * Free-form text conveying information that is not contained explicitly in
	 * other structures.
	 */
	private String Note;
	/**
	 * A code signifying the business purpose for this payment.
	 */
	private String PaymentPurposeCode;
	/**
	 * The date of this debit note line, used to indicate the point at which tax
	 * becomes applicable.
	 */
	private LocalDate TaxPointDate;
	/**
	 * A universally unique identifier for this debit note line.
	 */
	private String UUID;
	private List<AllowanceCharge> allowanceCharges = new ArrayList<>();
	private List<BillingReference> billingReferences = new ArrayList<>();
	private DebitNoteLine subDebitNoteLine;
	private List<Delivery> deliveries = new ArrayList<>();
	private List<DocumentReference> documentReferences = new ArrayList<>();
	private List<Item> items = new ArrayList<>();

	public String getAccountingCost() {
		return AccountingCost;
	}

	public void setAccountingCost(String accountingCost) {
		AccountingCost = accountingCost;
	}

	public String getAccountingCostCode() {
		return AccountingCostCode;
	}

	public void setAccountingCostCode(String accountingCostCode) {
		AccountingCostCode = accountingCostCode;
	}

	public BigDecimal getDebitedQuantity() {
		return DebitedQuantity;
	}

	public void setDebitedQuantity(BigDecimal debitedQuantity) {
		DebitedQuantity = debitedQuantity;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public BigDecimal getLineExtensionAmount() {
		return LineExtensionAmount;
	}

	public void setLineExtensionAmount(BigDecimal lineExtensionAmount) {
		LineExtensionAmount = lineExtensionAmount;
	}

	public String getNote() {
		return Note;
	}

	public void setNote(String note) {
		Note = note;
	}

	public String getPaymentPurposeCode() {
		return PaymentPurposeCode;
	}

	public void setPaymentPurposeCode(String paymentPurposeCode) {
		PaymentPurposeCode = paymentPurposeCode;
	}

	public LocalDate getTaxPointDate() {
		return TaxPointDate;
	}

	public void setTaxPointDate(LocalDate taxPointDate) {
		TaxPointDate = taxPointDate;
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

	public DebitNoteLine getSubDebitNoteLine() {
		return subDebitNoteLine;
	}

	public void setSubDebitNoteLine(DebitNoteLine subDebitNoteLine) {
		this.subDebitNoteLine = subDebitNoteLine;
	}

	public Delivery getM_Delivery() {
		return m_Delivery;
	}

	public void setM_Delivery(Delivery m_Delivery) {
		this.m_Delivery = m_Delivery;
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

	public Price getM_Price() {
		return m_Price;
	}

	public void setM_Price(Price m_Price) {
		this.m_Price = m_Price;
	}

	public PricingReference getM_PricingReference() {
		return m_PricingReference;
	}

	public void setM_PricingReference(PricingReference m_PricingReference) {
		this.m_PricingReference = m_PricingReference;
	}

	public Response getDiscrepancyResponse() {
		return DiscrepancyResponse;
	}

	public void setDiscrepancyResponse(Response discrepancyResponse) {
		DiscrepancyResponse = discrepancyResponse;
	}

	public TaxTotal getM_TaxTotal() {
		return m_TaxTotal;
	}

	public void setM_TaxTotal(TaxTotal m_TaxTotal) {
		this.m_TaxTotal = m_TaxTotal;
	}

	private LineReference despatchLineReference;
	private LineReference receiptLineReference;
	private List<Price> prices = new ArrayList<>();
	private List<PricingReference> pricingReferences = new ArrayList<>();
	private Response DiscrepancyResponse;
	private List<TaxTotal> taxTotals = new ArrayList<>();

	public DebitNoteLine() {
	}

}// end Debit Note Line