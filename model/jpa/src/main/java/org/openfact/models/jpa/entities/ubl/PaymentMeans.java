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
	private String id;
	/**
	 * An identifier for the payment instruction.
	 */
	private String instructionID;
	/**
	 * Free-form text conveying information that is not contained explicitly in
	 * other structures.
	 */
	private String instructionNote;
	/**
	 * A code signifying the payment channel for this means of payment.
	 */
	private String paymentChannelCode;
	/**
	 * The date on which payment is due for this means of payment.
	 */
	private LocalDate paymentDueDate;
	/**
	 * An identifier for a payment made using this means of payment.
	 */
	private String paymentID;
	/**
	 * A code signifying the type of this means of payment.
	 */
	private String paymentMeansCode;
	private List<CardAccount> cardAccounts=new ArrayList<>();
	private List<CreditAccount> creditAccounts=new ArrayList<>();
	private FinancialAccount payeeFinancialAccount;
	private FinancialAccount payerFinancialAccount;
	private List<PaymentMandate> paymentMandates=new ArrayList<>();
	private List<TradeFinancing> tradeFinancing=new ArrayList<>();

	public PaymentMeans() {

	}

	public void finalize() throws Throwable {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getInstructionID() {
		return instructionID;
	}

	public void setInstructionID(String instructionID) {
		this.instructionID = instructionID;
	}

	public String getInstructionNote() {
		return instructionNote;
	}

	public void setInstructionNote(String instructionNote) {
		this.instructionNote = instructionNote;
	}

	public String getPaymentChannelCode() {
		return paymentChannelCode;
	}

	public void setPaymentChannelCode(String paymentChannelCode) {
		this.paymentChannelCode = paymentChannelCode;
	}

	public LocalDate getPaymentDueDate() {
		return paymentDueDate;
	}

	public void setPaymentDueDate(LocalDate paymentDueDate) {
		this.paymentDueDate = paymentDueDate;
	}

	public String getPaymentID() {
		return paymentID;
	}

	public void setPaymentID(String paymentID) {
		this.paymentID = paymentID;
	}

	public String getPaymentMeansCode() {
		return paymentMeansCode;
	}

	public void setPaymentMeansCode(String paymentMeansCode) {
		this.paymentMeansCode = paymentMeansCode;
	}

	public List<CardAccount> getCardAccounts() {
		return cardAccounts;
	}

	public void setCardAccounts(List<CardAccount> cardAccounts) {
		this.cardAccounts = cardAccounts;
	}

	public List<CreditAccount> getCreditAccounts() {
		return creditAccounts;
	}

	public void setCreditAccounts(List<CreditAccount> creditAccounts) {
		this.creditAccounts = creditAccounts;
	}

	public FinancialAccount getPayeeFinancialAccount() {
		return payeeFinancialAccount;
	}

	public void setPayeeFinancialAccount(FinancialAccount payeeFinancialAccount) {
		this.payeeFinancialAccount = payeeFinancialAccount;
	}

	public FinancialAccount getPayerFinancialAccount() {
		return payerFinancialAccount;
	}

	public void setPayerFinancialAccount(FinancialAccount payerFinancialAccount) {
		this.payerFinancialAccount = payerFinancialAccount;
	}

	public List<PaymentMandate> getPaymentMandates() {
		return paymentMandates;
	}

	public void setPaymentMandates(List<PaymentMandate> paymentMandates) {
		this.paymentMandates = paymentMandates;
	}

	public List<TradeFinancing> getTradeFinancing() {
		return tradeFinancing;
	}

	public void setTradeFinancing(List<TradeFinancing> tradeFinancing) {
		this.tradeFinancing = tradeFinancing;
	}
}// end PaymentMeans