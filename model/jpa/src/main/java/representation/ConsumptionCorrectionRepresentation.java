package representation;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * The StatementRepresentation of correction, for examples heating correction.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:48 a. m.
 */
public class ConsumptionCorrectionRepresentation{

	/**
	 * StatementRepresentation for the actuel heating correction temperature.
	 */
	private QuantityType ActualTemperatureReductionQuantity;
	/**
	 * Your consumpt for district heating energy.
	 */
	private QuantityType ConsumptionEnergyQuantity;
	/**
	 * Your consumpt for district heating water.
	 */
	private QuantityType ConsumptionWaterQuantity;
	/**
	 * Your correction for heating correction.
	 */
	private AmountType CorrectionAmount;
	/**
	 * StatementRepresentation for the correction type.
	 */
	private TextType CorrectionType;
	/**
	 * StatementRepresentation at the code for the correction type.
	 */
	private CodeType CorrectionTypeCode;
	/**
	 * Correction per MWH per degree C.
	 */
	private AmountType CorrectionUnitAmount;
	/**
	 * Description related to the corrections.
	 */
	private TextType Description;
	/**
	 * Deviation from standard heating correction.
	 */
	private QuantityType DifferenceTemperatureReductionQuantity;
	/**
	 * Correction of the gas pressure.
	 */
	private QuantityType GasPressureQuantity;
	/**
	 * StatementRepresentation for meter number.
	 */
	private TextType MeterNumber;
	/**
	 * StatementRepresentation for the standard for heating correction temperature.
	 */
	private QuantityType NormalTemperatureReductionQuantity;

}
