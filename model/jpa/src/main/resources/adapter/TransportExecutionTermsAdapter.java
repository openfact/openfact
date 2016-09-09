package adapter;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe terms applying to a transport execution plan.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:44 a. m.
 */
public class TransportExecutionTermsAdapter{

	/**
	 * Text describing conditions applying to a change of these transport execution
	 * terms.
	 */
	private TextType changeConditions;
	/**
	 * Text describing special terms specified by the transport service provider.
	 */
	private TextType transportServiceProviderSpecialTerms;
	/**
	 * Text describing special terms specified by the transport user.
	 */
	private TextType transportUserSpecialTerms;
	private List<DeliveryTermsAdapter> deliveryTermses = new ArrayList<>();
	private List<EnvironmentalEmissionAdapter> environmentalEmissions = new ArrayList<>();
	private List<NotificationRequirementAdapter> notificationRequirements = new ArrayList<>();
	private List<PaymentTermsAdapter> bonusPaymentTerms = new ArrayList<>();
	private List<PaymentTermsAdapter> commissionPaymentTerms = new ArrayList<>();
	private List<PaymentTermsAdapter> penaltyPaymentTerms = new ArrayList<>();
	private List<PaymentTermsAdapter> serviceChargePaymentTerms = new ArrayList<>();
	private List<PaymentTermsAdapter> paymentTermses = new ArrayList<>();

}
