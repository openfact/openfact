package org.openfact.models.jpa.entities.ubl;
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
	private QuantityType actualTemperatureReductionQuantity; 
	/**
	 * Your consumpt for district heating energy.
	 */
	private QuantityType consumptionEnergyQuantity; 
	/**
	 * Your consumpt for district heating water.
	 */
	private QuantityType consumptionWaterQuantity; 
	/**
	 * Your correction for heating correction.
	 */
	private AmountType correctionAmount; 
	/**
	 * StatementRepresentation for the correction type.
	 */
	private TextType correctionType; 
	/**
	 * StatementRepresentation at the code for the correction type.
	 */
	private CodeType correctionTypeCode; 
	/**
	 * Correction per MWH per degree C.
	 */
	private AmountType correctionUnitAmount; 
	/**
	 * description related to the corrections.
	 */
	private TextType description; 
	/**
	 * Deviation from standard heating correction.
	 */
	private QuantityType differenceTemperatureReductionQuantity; 
	/**
	 * Correction of the gas pressure.
	 */
	private QuantityType gasPressureQuantity; 
	/**
	 * StatementRepresentation for meter number.
	 */
	private TextType meterNumber; 
	/**
	 * StatementRepresentation for the standard for heating correction temperature.
	 */
	private QuantityType normalTemperatureReductionQuantity; 

}
