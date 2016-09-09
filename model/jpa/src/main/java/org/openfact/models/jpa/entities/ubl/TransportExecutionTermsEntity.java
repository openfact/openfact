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
    private TextType ChangeConditions;
    /**
     * Text describing special terms specified by the transport service
     * provider.
     */
    private TextType TransportServiceProviderSpecialTerms;
    /**
     * Text describing special terms specified by the transport user.
     */
    private TextType TransportUserSpecialTerms;
    private List<DeliveryTermsEntity> DeliveryTermses = new ArrayList<>();
    private List<EnvironmentalEmissionEntity> EnvironmentalEmissions = new ArrayList<>();
    private List<NotificationRequirementEntity> NotificationRequirements = new ArrayList<>();
    private List<PaymentTermsEntity> BonusPaymentTerms = new ArrayList<>();
    private List<PaymentTermsEntity> CommissionPaymentTerms = new ArrayList<>();
    private List<PaymentTermsEntity> PenaltyPaymentTerms = new ArrayList<>();
    private List<PaymentTermsEntity> ServiceChargePaymentTerms = new ArrayList<>();
    private List<PaymentTermsEntity> PaymentTermses = new ArrayList<>();

}
