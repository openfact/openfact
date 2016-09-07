package org.openfact.models.jpa.entities.ubl;

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
    private String MeterConstant;
    /**
     * A code signifying the formula to be used in applying the meter constant.
     */
    private String MeterConstantCode;
    /**
     * The name of this meter, which serves as an identifier to distinguish a
     * main meter from a submeter.
     */
    private String MeterName;
    /**
     * The meter number, expressed as text.
     */
    private String MeterNumber;
    /**
     * The quantity delivered; the total quantity consumed as calculated from
     * the meter readings.
     */
    private Quantity.Type TotalDeliveredQuantity;
    private Meter Property
    m_Meter Property;
    private Meter Reading
    m_Meter Reading;

    public Meter() {

    }

    public void finalize() throws Throwable {

    }

    public Meter Property

    getMeter Property(){
		return m_Meter Property;
	}

    public Meter Reading

    getMeter Reading(){
		return m_Meter Reading;
	}

    public String getMeterConstant() {
        return MeterConstant;
    }

    public String getMeterConstantCode() {
        return MeterConstantCode;
    }

    public String getMeterName() {
        return MeterName;
    }

    public String getMeterNumber() {
        return MeterNumber;
    }

    public Quantity.Type getTotalDeliveredQuantity() {
        return TotalDeliveredQuantity;
    }

    /**
	 * 
	 * @param newVal
	 */
	public void setMeter

    Property(Meter Property newVal){
		m_Meter Property = newVal;
	}

    /**
	 * 
	 * @param newVal
	 */
	public void setMeter

    Reading(Meter Reading newVal){
		m_Meter Reading = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setMeterConstant(String newVal) {
        MeterConstant = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setMeterConstantCode(String newVal) {
        MeterConstantCode = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setMeterName(String newVal) {
        MeterName = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setMeterNumber(String newVal) {
        MeterNumber = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setTotalDeliveredQuantity(Quantity.Type newVal) {
        TotalDeliveredQuantity = newVal;
    }
}// end Meter