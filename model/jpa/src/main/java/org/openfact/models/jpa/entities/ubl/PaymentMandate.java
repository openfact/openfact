package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

/**
 * A class to describe a payment mandate.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:16:37 a. m.
 */
public class PaymentMandate {

	/**
	 * An identifier for this payment mandate.
	 */
	private String ID;
	/**
	 * A code signifying the type of this payment mandate.
	 */
	private String mandateTypeCode;
	/**
	 * The maximum amount to be paid within a single instruction.
	 */
	private BigDecimal maximumPaidAmount;
	/**
	 * The number of maximum payment instructions allowed within the validity
	 * period.
	 */
	private BigDecimal maximumPaymentInstructionsNumeric;
	/**
	 * An identifier for a signature applied by a signatory party.
	 */
	private String signatureID;
	private List<Clause> clauses = new ArrayList<>();
	private FinancialAccount payerFinancialAccount;
	private Party payerParty;
	private Period validityPeriod;
	private Period paymentReversalPeriod;

	public PaymentMandate() {

	}

	public void finalize() throws Throwable {

	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getMandateTypeCode() {
		return mandateTypeCode;
	}

	public void setMandateTypeCode(String mandateTypeCode) {
		this.mandateTypeCode = mandateTypeCode;
	}

	public BigDecimal getMaximumPaidAmount() {
		return maximumPaidAmount;
	}

	public void setMaximumPaidAmount(BigDecimal maximumPaidAmount) {
		this.maximumPaidAmount = maximumPaidAmount;
	}

	public BigDecimal getMaximumPaymentInstructionsNumeric() {
		return maximumPaymentInstructionsNumeric;
	}

	public void setMaximumPaymentInstructionsNumeric(BigDecimal maximumPaymentInstructionsNumeric) {
		this.maximumPaymentInstructionsNumeric = maximumPaymentInstructionsNumeric;
	}

	public String getSignatureID() {
		return signatureID;
	}

	public void setSignatureID(String signatureID) {
		this.signatureID = signatureID;
	}

	public List<Clause> getClauses() {
		return clauses;
	}

	public void setClauses(List<Clause> clauses) {
		this.clauses = clauses;
	}

	public FinancialAccount getPayerFinancialAccount() {
		return payerFinancialAccount;
	}

	public void setPayerFinancialAccount(FinancialAccount payerFinancialAccount) {
		this.payerFinancialAccount = payerFinancialAccount;
	}

	public Party getPayerParty() {
		return payerParty;
	}

	public void setPayerParty(Party payerParty) {
		this.payerParty = payerParty;
	}

	public Period getValidityPeriod() {
		return validityPeriod;
	}

	public void setValidityPeriod(Period validityPeriod) {
		this.validityPeriod = validityPeriod;
	}

	public Period getPaymentReversalPeriod() {
		return paymentReversalPeriod;
	}

	public void setPaymentReversalPeriod(Period paymentReversalPeriod) {
		this.paymentReversalPeriod = paymentReversalPeriod;
	}
}// end Payment Mandate