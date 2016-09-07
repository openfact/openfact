package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;

/**
 * A class to describe a means of payment.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:39 a. m.
 */
public class PaymentMeans {

	/**
	 * An identifier for this means of payment.
	 */
	private String ID;
	/**
	 * An identifier for the payment instruction.
	 */
	private String InstructionID;
	/**
	 * Free-form text conveying information that is not contained explicitly in
	 * other structures.
	 */
	private String InstructionNote;
	/**
	 * A code signifying the payment channel for this means of payment.
	 */
	private String PaymentChannelCode;
	/**
	 * The date on which payment is due for this means of payment.
	 */
	private LocalDate PaymentDueDate;
	/**
	 * An identifier for a payment made using this means of payment.
	 */
	private String PaymentID;
	/**
	 * A code signifying the type of this means of payment.
	 */
	private String PaymentMeansCode;
	private CardAccount m_CardAccount;
	private CreditAccount m_CreditAccount;
	private FinancialAccount PayeeFinancialAccount;
	private FinancialAccount PayerFinancialAccount;
	private PaymentMandate m_PaymentMandate;
	private TradeFinancing m_TradeFinancing;

	public PaymentMeans() {

	}

	public void finalize() throws Throwable {

	}

	/**
	 * @return the iD
	 */
	public String getID() {
		return ID;
	}

	/**
	 * @param iD
	 *            the iD to set
	 */
	public void setID(String iD) {
		ID = iD;
	}

	/**
	 * @return the instructionID
	 */
	public String getInstructionID() {
		return InstructionID;
	}

	/**
	 * @param instructionID
	 *            the instructionID to set
	 */
	public void setInstructionID(String instructionID) {
		InstructionID = instructionID;
	}

	/**
	 * @return the instructionNote
	 */
	public String getInstructionNote() {
		return InstructionNote;
	}

	/**
	 * @param instructionNote
	 *            the instructionNote to set
	 */
	public void setInstructionNote(String instructionNote) {
		InstructionNote = instructionNote;
	}

	/**
	 * @return the paymentChannelCode
	 */
	public String getPaymentChannelCode() {
		return PaymentChannelCode;
	}

	/**
	 * @param paymentChannelCode
	 *            the paymentChannelCode to set
	 */
	public void setPaymentChannelCode(String paymentChannelCode) {
		PaymentChannelCode = paymentChannelCode;
	}

	/**
	 * @return the paymentDueDate
	 */
	public LocalDate getPaymentDueDate() {
		return PaymentDueDate;
	}

	/**
	 * @param paymentDueDate
	 *            the paymentDueDate to set
	 */
	public void setPaymentDueDate(LocalDate paymentDueDate) {
		PaymentDueDate = paymentDueDate;
	}

	/**
	 * @return the paymentID
	 */
	public String getPaymentID() {
		return PaymentID;
	}

	/**
	 * @param paymentID
	 *            the paymentID to set
	 */
	public void setPaymentID(String paymentID) {
		PaymentID = paymentID;
	}

	/**
	 * @return the paymentMeansCode
	 */
	public String getPaymentMeansCode() {
		return PaymentMeansCode;
	}

	/**
	 * @param paymentMeansCode
	 *            the paymentMeansCode to set
	 */
	public void setPaymentMeansCode(String paymentMeansCode) {
		PaymentMeansCode = paymentMeansCode;
	}

	/**
	 * @return the m_CardAccount
	 */
	public CardAccount getM_CardAccount() {
		return m_CardAccount;
	}

	/**
	 * @param m_CardAccount
	 *            the m_CardAccount to set
	 */
	public void setM_CardAccount(CardAccount m_CardAccount) {
		this.m_CardAccount = m_CardAccount;
	}

	/**
	 * @return the m_CreditAccount
	 */
	public CreditAccount getM_CreditAccount() {
		return m_CreditAccount;
	}

	/**
	 * @param m_CreditAccount
	 *            the m_CreditAccount to set
	 */
	public void setM_CreditAccount(CreditAccount m_CreditAccount) {
		this.m_CreditAccount = m_CreditAccount;
	}

	/**
	 * @return the payeeFinancialAccount
	 */
	public FinancialAccount getPayeeFinancialAccount() {
		return PayeeFinancialAccount;
	}

	/**
	 * @param payeeFinancialAccount
	 *            the payeeFinancialAccount to set
	 */
	public void setPayeeFinancialAccount(FinancialAccount payeeFinancialAccount) {
		PayeeFinancialAccount = payeeFinancialAccount;
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
	 * @return the m_PaymentMandate
	 */
	public PaymentMandate getM_PaymentMandate() {
		return m_PaymentMandate;
	}

	/**
	 * @param m_PaymentMandate
	 *            the m_PaymentMandate to set
	 */
	public void setM_PaymentMandate(PaymentMandate m_PaymentMandate) {
		this.m_PaymentMandate = m_PaymentMandate;
	}

	/**
	 * @return the m_TradeFinancing
	 */
	public TradeFinancing getM_TradeFinancing() {
		return m_TradeFinancing;
	}

	/**
	 * @param m_TradeFinancing
	 *            the m_TradeFinancing to set
	 */
	public void setM_TradeFinancing(TradeFinancing m_TradeFinancing) {
		this.m_TradeFinancing = m_TradeFinancing;
	}

}// end PaymentMeans