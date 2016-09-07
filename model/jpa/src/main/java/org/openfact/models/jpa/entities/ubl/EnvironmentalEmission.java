package org.openfact.models.jpa.entities.ubl;


import java.math.BigDecimal;

/**
 * A class to describe an environmental emission.
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
	private EmissionCalculationMethod m_EmissionCalculationMethod;

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

	public EmissionCalculationMethod getM_EmissionCalculationMethod() {
		return m_EmissionCalculationMethod;
	}

	public void setM_EmissionCalculationMethod(EmissionCalculationMethod m_EmissionCalculationMethod) {
		this.m_EmissionCalculationMethod = m_EmissionCalculationMethod;
	}
}//end EnvironmentalEmission