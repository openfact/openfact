package org.openfact.models.jpa.entities.ubl;

/**
 * A class to describe a measurement of temperature.
 * 
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:18:13 a. m.
 */
public class Temperature {

    /**
     * An identifier for this temperature measurement.
     */
    private String AttributeID;
    /**
     * Text describing this temperature measurement.
     */
    private String Description;
    /**
     * The value of this temperature measurement.
     */
    private Measure.Type Measure;

    public Temperature() {

    }

    public void finalize() throws Throwable {

    }

    public String getAttributeID() {
        return AttributeID;
    }

    public String getDescription() {
        return Description;
    }

    public Measure.Type getMeasure() {
        return Measure;
    }

    /**
     * 
     * @param newVal
     */
    public void setAttributeID(String newVal) {
        AttributeID = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setDescription(String newVal) {
        Description = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setMeasure(Measure.Type newVal) {
        Measure = newVal;
    }
}// end Temperature