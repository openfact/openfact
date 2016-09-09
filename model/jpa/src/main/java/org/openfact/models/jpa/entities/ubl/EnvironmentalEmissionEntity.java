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
public class EnvironmentalEmissionEntity{

	/**
	 * Text describing this environmental emission.
	 */
	private TextType description; 
	/**
	 * A code specifying the type of environmental emission.
	 */
	private CodeType environmentalEmissionTypeCode; 
	/**
	 * A value measurement for the environmental emission.
	 */
	private MeasureType valueMeasure; 
	private List<EmissionCalculationMethodEntity> emissionCalculationMethods = new ArrayList<>(); 

}
