package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

/**
 * A class to describe a meter and its readings.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:16:06 a. m.
 */
public class Meter {

	/**
	 * The factor by which readings of this meter must be multiplied to
	 * calculate consumption, expressed as text.
	 */
	private String meterConstant;
	/**
	 * A code signifying the formula to be used in applying the meter constant.
	 */
	private String meterConstantCode;
	/**
	 * The name of this meter, which serves as an identifier to distinguish a
	 * main meter from a submeter.
	 */
	private String meterName;
	/**
	 * The meter number, expressed as text.
	 */
	private String meterNumber;
	/**
	 * The quantity delivered; the total quantity consumed as calculated from
	 * the meter readings.
	 */
	private BigDecimal totalDeliveredQuantity;
	private List<MeterProperty> meterProperteis=new ArrayList<>();
	private List<MeterReading> meterReadings=new ArrayList<>();

	public Meter() {

	}

	public void finalize() throws Throwable {

	}

	public String getMeterConstant() {
		return meterConstant;
	}

	public void setMeterConstant(String meterConstant) {
		this.meterConstant = meterConstant;
	}

	public String getMeterConstantCode() {
		return meterConstantCode;
	}

	public void setMeterConstantCode(String meterConstantCode) {
		this.meterConstantCode = meterConstantCode;
	}

	public String getMeterName() {
		return meterName;
	}

	public void setMeterName(String meterName) {
		this.meterName = meterName;
	}

	public String getMeterNumber() {
		return meterNumber;
	}

	public void setMeterNumber(String meterNumber) {
		this.meterNumber = meterNumber;
	}

	public BigDecimal getTotalDeliveredQuantity() {
		return totalDeliveredQuantity;
	}

	public void setTotalDeliveredQuantity(BigDecimal totalDeliveredQuantity) {
		this.totalDeliveredQuantity = totalDeliveredQuantity;
	}

	public List<MeterProperty> getMeterProperteis() {
		return meterProperteis;
	}

	public void setMeterProperteis(List<MeterProperty> meterProperteis) {
		this.meterProperteis = meterProperteis;
	}

	public List<MeterReading> getMeterReadings() {
		return meterReadings;
	}

	public void setMeterReadings(List<MeterReading> meterReadings) {
		this.meterReadings = meterReadings;
	}
}// end Meter