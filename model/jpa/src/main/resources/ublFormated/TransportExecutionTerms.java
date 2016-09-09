package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe terms applying to a transport execution plan.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:44 a. m.
 */
public class TransportExecutionTerms{

	/**
	 * Text describing conditions applying to a change of these transport execution
	 * terms.
	 */
	private TextType ChangeConditions;
	/**
	 * Text describing special terms specified by the transport service provider.
	 */
	private TextType TransportServiceProviderSpecialTerms;
	/**
	 * Text describing special terms specified by the transport user.
	 */
	private TextType TransportUserSpecialTerms;
	private List<DeliveryTerms> DeliveryTermses = new ArrayList<>();
	private List<EnvironmentalEmission> EnvironmentalEmissions = new ArrayList<>();
	private List<NotificationRequirement> NotificationRequirements = new ArrayList<>();
	private List<PaymentTerms> BonusPaymentTerms = new ArrayList<>();
	private List<PaymentTerms> CommissionPaymentTerms = new ArrayList<>();
	private List<PaymentTerms> PenaltyPaymentTerms = new ArrayList<>();
	private List<PaymentTerms> ServiceChargePaymentTerms = new ArrayList<>();
	private List<PaymentTerms> PaymentTermses = new ArrayList<>();

}
