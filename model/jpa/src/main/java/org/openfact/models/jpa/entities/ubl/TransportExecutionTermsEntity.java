package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.TextType;

/**
 * A class to describe terms applying to a transport execution plan.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:44 a. m.
 */
public class TransportExecutionTermsEntity {

    /**
     * Text describing conditions applying to a change of these transport
     * execution terms.
     */
    private TextType changeConditions;
    /**
     * Text describing special terms specified by the transport service
     * provider.
     */
    private TextType transportServiceProviderSpecialTerms;
    /**
     * Text describing special terms specified by the transport user.
     */
    private TextType transportUserSpecialTerms;
    private List<DeliveryTermsEntity> deliveryTermses = new ArrayList<>();
    private List<EnvironmentalEmissionEntity> environmentalEmissions = new ArrayList<>();
    private List<NotificationRequirementEntity> notificationRequirements = new ArrayList<>();
    private List<PaymentTermsEntity> bonusPaymentTerms = new ArrayList<>();
    private List<PaymentTermsEntity> commissionPaymentTerms = new ArrayList<>();
    private List<PaymentTermsEntity> penaltyPaymentTerms = new ArrayList<>();
    private List<PaymentTermsEntity> serviceChargePaymentTerms = new ArrayList<>();
    private List<PaymentTermsEntity> paymentTermses = new ArrayList<>();

}
