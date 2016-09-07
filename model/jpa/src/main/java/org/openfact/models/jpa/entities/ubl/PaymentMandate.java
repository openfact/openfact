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
	private String MandateTypeCode;
	/**
	 * The maximum amount to be paid within a single instruction.
	 */
	private BigDecimal MaximumPaidAmount;
	/**
	 * The number of maximum payment instructions allowed within the validity
	 * period.
	 */
	private BigDecimal MaximumPaymentInstructionsNumeric;
	/**
	 * An identifier for a signature applied by a signatory party.
	 */
	private String SignatureID;
	private List<Clause> clauses = new ArrayList<>();
	private FinancialAccount PayerFinancialAccount;
	private Party PayerParty;
	private Period ValidityPeriod;
	private Period PaymentReversalPeriod;

	public PaymentMandate() {

	}

	public void finalize() throws Throwable {

	}

	public Clause getClause() {
		return m_Clause;
	}

	public String getID() {
		return ID;
	}

	public String getMandateTypeCode() {
		return MandateTypeCode;
	}

	public BigDecimal getMaximumPaidAmount() {
		return MaximumPaidAmount;
	}

	public BigDecimal getMaximumPaymentInstructionsNumeric() {
		return MaximumPaymentInstructionsNumeric;
	}

	public String getSignatureID() {
		return SignatureID;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setClause(Clause newVal) {
		m_Clause = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setID(String newVal) {
		ID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMandateTypeCode(String newVal) {
		MandateTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMaximumPaidAmount(BigDecimal newVal) {
		MaximumPaidAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMaximumPaymentInstructionsNumeric(BigDecimal newVal) {
		MaximumPaymentInstructionsNumeric = newVal;
	}

	/**
	 * @return the m_Clause
	 */
	public Clause getM_Clause() {
		return m_Clause;
	}

	/**
	 * @param m_Clause
	 *            the m_Clause to set
	 */
	public void setM_Clause(Clause m_Clause) {
		this.m_Clause = m_Clause;
	}

	/**
	 * @return the payerFinancialAccount
	 */
	public FinancialAccount getPayerFinancialAccount() {
		return PayerFinancialAccount;
	}

	/**
	 * @param payerFinancialAccount
	 *            the payerFinancialAccount to set
	 */
	public void setPayerFinancialAccount(FinancialAccount payerFinancialAccount) {
		PayerFinancialAccount = payerFinancialAccount;
	}

	/**
	 * @return the payerParty
	 */
	public Party getPayerParty() {
		return PayerParty;
	}

	/**
	 * @param payerParty
	 *            the payerParty to set
	 */
	public void setPayerParty(Party payerParty) {
		PayerParty = payerParty;
	}

	/**
	 * @return the validityPeriod
	 */
	public Period getValidityPeriod() {
		return ValidityPeriod;
	}

	/**
	 * @param validityPeriod
	 *            the validityPeriod to set
	 */
	public void setValidityPeriod(Period validityPeriod) {
		ValidityPeriod = validityPeriod;
	}

	/**
	 * @return the paymentReversalPeriod
	 */
	public Period getPaymentReversalPeriod() {
		return PaymentReversalPeriod;
	}

	/**
	 * @param paymentReversalPeriod
	 *            the paymentReversalPeriod to set
	 */
	public void setPaymentReversalPeriod(Period paymentReversalPeriod) {
		PaymentReversalPeriod = paymentReversalPeriod;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSignatureID(String newVal) {
		SignatureID = newVal;
	}

}// end Payment Mandate