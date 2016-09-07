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
    private List<DeliveryTerms> deliveryTerms = new ArrayList<>();
    private List<EnvironmentalEmission> environmentalEmissions = new ArrayList<>();
    private List<NotificationRequirement> notificationRequirements = new ArrayList<>();
    private PaymentTerms bonusPaymentTerms;
    private PaymentTerms commissionPaymentTerms;
    private PaymentTerms penaltyPaymentTerms;
    private PaymentTerms serviceChargePaymentTerms;
    private List<PaymentTerms> paymentTerms = new ArrayList<>();

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
     * @return the deliveryTerms
     */
    public List<DeliveryTerms> getDeliveryTerms() {
        return deliveryTerms;
    }

    /**
     * @param deliveryTerms
     *            the deliveryTerms to set
     */
    public void setDeliveryTerms(List<DeliveryTerms> deliveryTerms) {
        this.deliveryTerms = deliveryTerms;
    }

    /**
     * @return the environmentalEmissions
     */
    public List<EnvironmentalEmission> getEnvironmentalEmissions() {
        return environmentalEmissions;
    }

    /**
     * @param environmentalEmissions
     *            the environmentalEmissions to set
     */
    public void setEnvironmentalEmissions(List<EnvironmentalEmission> environmentalEmissions) {
        this.environmentalEmissions = environmentalEmissions;
    }

    /**
     * @return the notificationRequirements
     */
    public List<NotificationRequirement> getNotificationRequirements() {
        return notificationRequirements;
    }

    /**
     * @param notificationRequirements
     *            the notificationRequirements to set
     */
    public void setNotificationRequirements(List<NotificationRequirement> notificationRequirements) {
        this.notificationRequirements = notificationRequirements;
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
     * @return the paymentTerms
     */
    public List<PaymentTerms> getPaymentTerms() {
        return paymentTerms;
    }

    /**
     * @param paymentTerms
     *            the paymentTerms to set
     */
    public void setPaymentTerms(List<PaymentTerms> paymentTerms) {
        this.paymentTerms = paymentTerms;
    }

}// end TransportExecutionTerms