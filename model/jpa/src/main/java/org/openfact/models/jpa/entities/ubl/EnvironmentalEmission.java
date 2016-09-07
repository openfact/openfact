package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

/**
 * A class to describe an environmental emission.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:50 a. m.
 */
public class EnvironmentalEmission {

	/**
	 * Text describing this environmental emission.
	 */
	private String description;
	/**
	 * A code specifying the type of environmental emission.
	 */
	private String environmentalEmissionTypeCode;
	/**
	 * A value measurement for the environmental emission.
	 */
	private BigDecimal valueMeasure;
	private List<EmissionCalculationMethod> emissionCalculationMethod=new ArrayList<>();

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEnvironmentalEmissionTypeCode() {
		return environmentalEmissionTypeCode;
	}

	public void setEnvironmentalEmissionTypeCode(String environmentalEmissionTypeCode) {
		this.environmentalEmissionTypeCode = environmentalEmissionTypeCode;
	}

	public BigDecimal getValueMeasure() {
		return valueMeasure;
	}

	public void setValueMeasure(BigDecimal valueMeasure) {
		this.valueMeasure = valueMeasure;
	}

	public List<EmissionCalculationMethod> getEmissionCalculationMethod() {
		return emissionCalculationMethod;
	}

	public void setEmissionCalculationMethod(List<EmissionCalculationMethod> emissionCalculationMethod) {
		this.emissionCalculationMethod = emissionCalculationMethod;
	}
}// end EnvironmentalEmission