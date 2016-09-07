package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to describe terms applying to a transport execution plan.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:44 a. m.
 */
public class TransportExecutionTerms {

	/**
	 * Text describing conditions applying to a change of these transport
	 * execution terms.
	 */
	private String changeConditions;
	/**
	 * Text describing special terms specified by the transport service
	 * provider.
	 */
	private String transportServiceProviderSpecialTerms;
	/**
	 * Text describing special terms specified by the transport user.
	 */
	private String transportUserSpecialTerms;
	private DeliveryTerms m_DeliveryTerms;
	private EnvironmentalEmission m_EnvironmentalEmission;
	private NotificationRequirement m_NotificationRequirement;
	private PaymentTerms bonusPaymentTerms;
	private PaymentTerms commissionPaymentTerms;
	private PaymentTerms penaltyPaymentTerms;
	private PaymentTerms serviceChargePaymentTerms;
	private PaymentTerms m_PaymentTerms;

	/**
	 * @return the changeConditions
	 */
	public String getChangeConditions() {
		return changeConditions;
	}

	/**
	 * @param changeConditions
	 *            the changeConditions to set
	 */
	public void setChangeConditions(String changeConditions) {
		this.changeConditions = changeConditions;
	}

	/**
	 * @return the transportServiceProviderSpecialTerms
	 */
	public String getTransportServiceProviderSpecialTerms() {
		return transportServiceProviderSpecialTerms;
	}

	/**
	 * @param transportServiceProviderSpecialTerms
	 *            the transportServiceProviderSpecialTerms to set
	 */
	public void setTransportServiceProviderSpecialTerms(String transportServiceProviderSpecialTerms) {
		this.transportServiceProviderSpecialTerms = transportServiceProviderSpecialTerms;
	}

	/**
	 * @return the transportUserSpecialTerms
	 */
	public String getTransportUserSpecialTerms() {
		return transportUserSpecialTerms;
	}

	/**
	 * @param transportUserSpecialTerms
	 *            the transportUserSpecialTerms to set
	 */
	public void setTransportUserSpecialTerms(String transportUserSpecialTerms) {
		this.transportUserSpecialTerms = transportUserSpecialTerms;
	}

	/**
	 * @return the m_DeliveryTerms
	 */
	public DeliveryTerms getM_DeliveryTerms() {
		return m_DeliveryTerms;
	}

	/**
	 * @param m_DeliveryTerms
	 *            the m_DeliveryTerms to set
	 */
	public void setM_DeliveryTerms(DeliveryTerms m_DeliveryTerms) {
		this.m_DeliveryTerms = m_DeliveryTerms;
	}

	/**
	 * @return the m_EnvironmentalEmission
	 */
	public EnvironmentalEmission getM_EnvironmentalEmission() {
		return m_EnvironmentalEmission;
	}

	/**
	 * @param m_EnvironmentalEmission
	 *            the m_EnvironmentalEmission to set
	 */
	public void setM_EnvironmentalEmission(EnvironmentalEmission m_EnvironmentalEmission) {
		this.m_EnvironmentalEmission = m_EnvironmentalEmission;
	}

	/**
	 * @return the m_NotificationRequirement
	 */
	public NotificationRequirement getM_NotificationRequirement() {
		return m_NotificationRequirement;
	}

	/**
	 * @param m_NotificationRequirement
	 *            the m_NotificationRequirement to set
	 */
	public void setM_NotificationRequirement(NotificationRequirement m_NotificationRequirement) {
		this.m_NotificationRequirement = m_NotificationRequirement;
	}

	/**
	 * @return the bonusPaymentTerms
	 */
	public PaymentTerms getBonusPaymentTerms() {
		return bonusPaymentTerms;
	}

	/**
	 * @param bonusPaymentTerms
	 *            the bonusPaymentTerms to set
	 */
	public void setBonusPaymentTerms(PaymentTerms bonusPaymentTerms) {
		this.bonusPaymentTerms = bonusPaymentTerms;
	}

	/**
	 * @return the commissionPaymentTerms
	 */
	public PaymentTerms getCommissionPaymentTerms() {
		return commissionPaymentTerms;
	}

	/**
	 * @param commissionPaymentTerms
	 *            the commissionPaymentTerms to set
	 */
	public void setCommissionPaymentTerms(PaymentTerms commissionPaymentTerms) {
		this.commissionPaymentTerms = commissionPaymentTerms;
	}

	/**
	 * @return the penaltyPaymentTerms
	 */
	public PaymentTerms getPenaltyPaymentTerms() {
		return penaltyPaymentTerms;
	}

	/**
	 * @param penaltyPaymentTerms
	 *            the penaltyPaymentTerms to set
	 */
	public void setPenaltyPaymentTerms(PaymentTerms penaltyPaymentTerms) {
		this.penaltyPaymentTerms = penaltyPaymentTerms;
	}

	/**
	 * @return the serviceChargePaymentTerms
	 */
	public PaymentTerms getServiceChargePaymentTerms() {
		return serviceChargePaymentTerms;
	}

	/**
	 * @param serviceChargePaymentTerms
	 *            the serviceChargePaymentTerms to set
	 */
	public void setServiceChargePaymentTerms(PaymentTerms serviceChargePaymentTerms) {
		this.serviceChargePaymentTerms = serviceChargePaymentTerms;
	}

	/**
	 * @return the m_PaymentTerms
	 */
	public PaymentTerms getM_PaymentTerms() {
		return m_PaymentTerms;
	}

	/**
	 * @param m_PaymentTerms
	 *            the m_PaymentTerms to set
	 */
	public void setM_PaymentTerms(PaymentTerms m_PaymentTerms) {
		this.m_PaymentTerms = m_PaymentTerms;
	}

}// end TransportExecutionTerms