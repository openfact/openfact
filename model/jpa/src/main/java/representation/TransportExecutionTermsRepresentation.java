package representation;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe terms applying to a transport execution plan.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:44 a. m.
 */
public class TransportExecutionTermsRepresentation{

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
	private List<DeliveryTermsRepresentation> DeliveryTermses = new ArrayList<>();
	private List<EnvironmentalEmissionRepresentation> EnvironmentalEmissions = new ArrayList<>();
	private List<NotificationRequirementRepresentation> NotificationRequirements = new ArrayList<>();
	private List<PaymentTermsRepresentation> BonusPaymentTerms = new ArrayList<>();
	private List<PaymentTermsRepresentation> CommissionPaymentTerms = new ArrayList<>();
	private List<PaymentTermsRepresentation> PenaltyPaymentTerms = new ArrayList<>();
	private List<PaymentTermsRepresentation> ServiceChargePaymentTerms = new ArrayList<>();
	private List<PaymentTermsRepresentation> PaymentTermses = new ArrayList<>();

}
