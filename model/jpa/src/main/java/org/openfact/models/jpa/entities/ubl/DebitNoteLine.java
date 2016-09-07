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
	private String accountingCost;
	/**
	 * The buyer's accounting cost centre for this debit note line, expressed as
	 * a code.
	 */
	private String accountingCostCode;
	/**
	 * The quantity of Items debited in this debit note line.
	 */
	private BigDecimal debitedQuantity;
	/**
	 * An identifier for this debit note line.
	 */
	private String id;
	/**
	 * The total amount for this debit note line, including allowance charges
	 * but net of taxes.
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
	 * The date of this debit note line, used to indicate the point at which tax
	 * becomes applicable.
	 */
	private LocalDate taxPointDate;
	/**
	 * A universally unique identifier for this debit note line.
	 */
	private String UUID;
	private List<AllowanceCharge> allowanceCharges=new ArrayList<>();
	private List<BillingReference> billingReferences=new ArrayList<>();
	private DebitNoteLine subDebitNoteLine;
	private List<Delivery> deliveries=new ArrayList<>();
	private List<DocumentReference> documentReferences=new ArrayList<>();
	private List<Item> items=new ArrayList<>();

	public DebitNoteLine() {
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

	public BigDecimal getDebitedQuantity() {
		return debitedQuantity;
	}

	public void setDebitedQuantity(BigDecimal debitedQuantity) {
		this.debitedQuantity = debitedQuantity;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public List<BillingReference> getBillingReferences() {
		return billingReferences;
	}

	public void setBillingReferences(List<BillingReference> billingReferences) {
		this.billingReferences = billingReferences;
	}

	public DebitNoteLine getSubDebitNoteLine() {
		return subDebitNoteLine;
	}

	public void setSubDebitNoteLine(DebitNoteLine subDebitNoteLine) {
		this.subDebitNoteLine = subDebitNoteLine;
	}

    public List<Delivery> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(List<Delivery> deliveries) {
        this.deliveries = deliveries;
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
}// end Debit Note Line