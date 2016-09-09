package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe an environmental emission.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:50 a. m.
 */
public class EnvironmentalEmission{

	/**
	 * Text describing this environmental emission.
	 */
	private TextType Description;
	/**
	 * A code specifying the type of environmental emission.
	 */
	private CodeType EnvironmentalEmissionTypeCode;
	/**
	 * A value measurement for the environmental emission.
	 */
	private MeasureType ValueMeasure;
	private List<EmissionCalculationMethod> EmissionCalculationMethods = new ArrayList<>();

}
