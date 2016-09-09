package adapter;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe a tendering framework agreement.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:15:22 a. m.
 */
public class FrameworkAgreementAdapter{

	/**
	 * The number of economic operators expected to participate in this framework
	 * agreement.
	 */
	private QuantityType expectedOperatorQuantity;
	/**
	 * Text describing the frequency with which subsequent contracts will be awarded.
	 */
	private TextType frequency;
	/**
	 * Text describing the justification for this framework agreement.
	 */
	private TextType justification;
	/**
	 * The maximum number of economic operators allowed to participate in this
	 * framework agreement.
	 */
	private QuantityType maximumOperatorQuantity;
	private PeriodAdapter durationPeriod;
	private TenderRequirementAdapter subsequentProcessTenderRequirement;

}
