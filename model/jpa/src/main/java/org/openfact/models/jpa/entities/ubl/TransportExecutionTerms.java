package org.openfact.models.jpa.entities.ubl;


/**
 * A class to describe terms applying to a transport execution plan.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:44 a. m.
 */
public class TransportExecutionTerms {

	/**
	 * Text describing conditions applying to a change of these transport execution
	 * terms.
	 */
	private String ChangeConditions;
	/**
	 * Text describing special terms specified by the transport service provider.
	 */
	private String TransportServiceProviderSpecialTerms;
	/**
	 * Text describing special terms specified by the transport user.
	 */
	private String TransportUserSpecialTerms;
	private DeliveryTerms m_DeliveryTerms;
	private EnvironmentalEmission m_EnvironmentalEmission;
	private NotificationRequirement m_NotificationRequirement;
	private PaymentTerms Bonus PaymentTerms;
	private PaymentTerms Commission PaymentTerms;
	private PaymentTerms Penalty PaymentTerms;
	private PaymentTerms Service Charge PaymentTerms;
	private PaymentTerms m_PaymentTerms;

	public Transport Execution Terms(){

	}

	public void finalize() throws Throwable {

	}
	public PaymentTerms getBonus PaymentTerms(){
		return Bonus PaymentTerms;
	}

	public String getChangeConditions(){
		return ChangeConditions;
	}

	public PaymentTerms getCommission PaymentTerms(){
		return Commission PaymentTerms;
	}

	public DeliveryTerms getDeliveryTerms(){
		return m_DeliveryTerms;
	}

	public EnvironmentalEmission getEnvironmentalEmission(){
		return m_EnvironmentalEmission;
	}

	public NotificationRequirement getNotificationRequirement(){
		return m_NotificationRequirement;
	}

	public PaymentTerms getPaymentTerms(){
		return m_PaymentTerms;
	}

	public PaymentTerms getPenalty PaymentTerms(){
		return Penalty PaymentTerms;
	}

	public PaymentTerms getService Charge PaymentTerms(){
		return Service Charge PaymentTerms;
	}

	public String getTransportServiceProviderSpecialTerms(){
		return TransportServiceProviderSpecialTerms;
	}

	public String getTransportUserSpecialTerms(){
		return TransportUserSpecialTerms;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setBonus PaymentTerms(PaymentTerms newVal){
		Bonus PaymentTerms = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setChangeConditions(String newVal){
		ChangeConditions = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCommission PaymentTerms(PaymentTerms newVal){
		Commission PaymentTerms = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDeliveryTerms(DeliveryTerms newVal){
		m_DeliveryTerms = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setEnvironmentalEmission(EnvironmentalEmission newVal){
		m_EnvironmentalEmission = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNotificationRequirement(NotificationRequirement newVal){
		m_NotificationRequirement = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPaymentTerms(PaymentTerms newVal){
		m_PaymentTerms = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPenalty PaymentTerms(PaymentTerms newVal){
		Penalty PaymentTerms = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setService Charge PaymentTerms(PaymentTerms newVal){
		Service Charge PaymentTerms = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTransportServiceProviderSpecialTerms(String newVal){
		TransportServiceProviderSpecialTerms = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTransportUserSpecialTerms(String newVal){
		TransportUserSpecialTerms = newVal;
	}
}//end Transport Execution Terms