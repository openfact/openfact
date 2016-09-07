package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to define how an environmental emission is calculated.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:43 a. m.
 */
public class EmissionCalculationMethod {

	/**
	 * A code signifying the method used to calculate the emission.
	 */
	private String CalculationMethodCode;
	/**
	 * A code signifying whether a piece of transport equipment is full,
	 * partially full, or empty. This indication is used as a parameter when
	 * calculating the environmental emission.
	 */
	private String fullnessIndicationCode;
	private Location measurementToLocation;
	private Location measurementFromLocation;

	public String getCalculationMethodCode() {
		return CalculationMethodCode;
	}

	public void setCalculationMethodCode(String calculationMethodCode) {
		CalculationMethodCode = calculationMethodCode;
	}

	public String getFullnessIndicationCode() {
		return fullnessIndicationCode;
	}

	public void setFullnessIndicationCode(String fullnessIndicationCode) {
		fullnessIndicationCode = fullnessIndicationCode;
	}

	public Location getMeasurementToLocation() {
		return measurementToLocation;
	}

	public void setMeasurementToLocation(Location measurementToLocation) {
		this.measurementToLocation = measurementToLocation;
	}

	public Location getMeasurementFromLocation() {
		return measurementFromLocation;
	}

	public void setMeasurementFromLocation(Location measurementFromLocation) {
		this.measurementFromLocation = measurementFromLocation;
	}
}// end Emission Calculation Method