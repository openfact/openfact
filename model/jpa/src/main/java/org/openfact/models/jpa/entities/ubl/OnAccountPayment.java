package org.openfact.models.jpa.entities.ubl;


/**
 * A scheduled prepayment (on-account payment) for a estimated utility consumption
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:16:14 a. m.
 */
public class OnAccountPayment {

	/**
	 * The estimated consumed quantity covered by the payment.
	 */
	private BigDecimal EstimatedConsumedQuantity;
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private String Note;
	private PaymentTerms m_PaymentTerms;

	public OnAccountPayment(){

	}

	public void finalize() throws Throwable {

	}
	public BigDecimal getEstimatedConsumedQuantity(){
		return EstimatedConsumedQuantity;
	}

	public String getNote(){
		return Note;
	}

	public PaymentTerms getPaymentTerms(){
		return m_PaymentTerms;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setEstimatedConsumedQuantity(BigDecimal newVal){
		EstimatedConsumedQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNote(String newVal){
		Note = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPaymentTerms(PaymentTerms newVal){
		m_PaymentTerms = newVal;
	}
}//end OnAccountPayment