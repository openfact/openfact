package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * A class to describe a set of payment terms.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:41 a. m.
 */
public class PaymentTerms {

	/**
	 * The monetary amount covered by these payment terms.
	 */
	private BigDecimal amount;
	/**
	 * An identifier for this set of payment terms.
	 */
	private String id;
	/**
	 * The due date for an installment payment for these payment terms.
	 */
	private LocalDate installmentDueDate;
	/**
	 * A reference to the payment terms used by the invoicing party. This may
	 * have been requested of the payer by the payee to accompany its
	 * remittance.
	 */
	private String invoicingPartyReference;
	/**
	 * Free-form text conveying information that is not contained explicitly in
	 * other structures.
	 */
	private String note;
	/**
	 * The due date for these payment terms.
	 */
	private LocalDate paymentDueDate;
	/**
	 * An identifier for a means of payment associated with these payment terms.
	 */
	private String paymentMeansID;
	/**
	 * The part of a payment, expressed as a percent, relevant for these payment
	 * terms.
	 */
	private BigDecimal paymentPercent;
	/**
	 * The Uniform Resource Identifier (URI) of a document providing additional
	 * details regarding these payment terms.
	 */
	private String paymentTermsDetailsURIID;
	/**
	 * The monetary amount of the penalty for payment after the settlement
	 * period.
	 */
	private BigDecimal penaltyAmount;
	/**
	 * The penalty for payment after the settlement period, expressed as a
	 * percentage of the payment.
	 */
	private BigDecimal penaltySurchargePercent;
	/**
	 * An identifier for a reference to a prepaid payment.
	 */
	private String prepaidPaymentReferenceID;
	/**
	 * A code signifying the event during which these terms are offered.
	 */
	private String referenceEventCode;
	/**
	 * The amount of a settlement discount offered for payment under these
	 * payment terms.
	 */
	private BigDecimal settlementDiscountAmount;
	/**
	 * The percentage for the settlement discount that is offered for payment
	 * under these payment terms.
	 */
	private BigDecimal settlementDiscountPercent;
	private List<ExchangeRate> exchangeRates = new ArrayList<>();
	private Period settlementPeriod;
	private Period penaltyPeriod;
	private Period validityPeriod;

	public PaymentTerms() {

	}

	public void finalize() throws Throwable {

	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDate getInstallmentDueDate() {
		return installmentDueDate;
	}

	public void setInstallmentDueDate(LocalDate installmentDueDate) {
		this.installmentDueDate = installmentDueDate;
	}

	public String getInvoicingPartyReference() {
		return invoicingPartyReference;
	}

	public void setInvoicingPartyReference(String invoicingPartyReference) {
		this.invoicingPartyReference = invoicingPartyReference;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public LocalDate getPaymentDueDate() {
		return paymentDueDate;
	}

	public void setPaymentDueDate(LocalDate paymentDueDate) {
		this.paymentDueDate = paymentDueDate;
	}

	public String getPaymentMeansID() {
		return paymentMeansID;
	}

	public void setPaymentMeansID(String paymentMeansID) {
		this.paymentMeansID = paymentMeansID;
	}

	public BigDecimal getPaymentPercent() {
		return paymentPercent;
	}

	public void setPaymentPercent(BigDecimal paymentPercent) {
		this.paymentPercent = paymentPercent;
	}

	public String getPaymentTermsDetailsURIID() {
		return paymentTermsDetailsURIID;
	}

	public void setPaymentTermsDetailsURIID(String paymentTermsDetailsURIID) {
		this.paymentTermsDetailsURIID = paymentTermsDetailsURIID;
	}

	public BigDecimal getPenaltyAmount() {
		return penaltyAmount;
	}

	public void setPenaltyAmount(BigDecimal penaltyAmount) {
		this.penaltyAmount = penaltyAmount;
	}

	public BigDecimal getPenaltySurchargePercent() {
		return penaltySurchargePercent;
	}

	public void setPenaltySurchargePercent(BigDecimal penaltySurchargePercent) {
		this.penaltySurchargePercent = penaltySurchargePercent;
	}

	public String getPrepaidPaymentReferenceID() {
		return prepaidPaymentReferenceID;
	}

	public void setPrepaidPaymentReferenceID(String prepaidPaymentReferenceID) {
		this.prepaidPaymentReferenceID = prepaidPaymentReferenceID;
	}

	public String getReferenceEventCode() {
		return referenceEventCode;
	}

	public void setReferenceEventCode(String referenceEventCode) {
		this.referenceEventCode = referenceEventCode;
	}

	public BigDecimal getSettlementDiscountAmount() {
		return settlementDiscountAmount;
	}

	public void setSettlementDiscountAmount(BigDecimal settlementDiscountAmount) {
		this.settlementDiscountAmount = settlementDiscountAmount;
	}

	public BigDecimal getSettlementDiscountPercent() {
		return settlementDiscountPercent;
	}

	public void setSettlementDiscountPercent(BigDecimal settlementDiscountPercent) {
		this.settlementDiscountPercent = settlementDiscountPercent;
	}

	public List<ExchangeRate> getExchangeRates() {
		return exchangeRates;
	}

	public void setExchangeRates(List<ExchangeRate> exchangeRates) {
		this.exchangeRates = exchangeRates;
	}

	public Period getSettlementPeriod() {
		return settlementPeriod;
	}

	public void setSettlementPeriod(Period settlementPeriod) {
		this.settlementPeriod = settlementPeriod;
	}

	public Period getPenaltyPeriod() {
		return penaltyPeriod;
	}

	public void setPenaltyPeriod(Period penaltyPeriod) {
		this.penaltyPeriod = penaltyPeriod;
	}

	public Period getValidityPeriod() {
		return validityPeriod;
	}

	public void setValidityPeriod(Period validityPeriod) {
		this.validityPeriod = validityPeriod;
	}
}// end PaymentTerms