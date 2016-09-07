package org.openfact.models.jpa.entities.ubl;

/**
 * A class to define a measurable dimension (length, mass, weight, volume, or
 * area) of an item.
 * 
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:14:30 a. m.
 */
public class Dimension {

    /**
     * An identifier for the attribute to which the measure applies.
     */
    private String AttributeID;
    /**
     * Text describing the measurement attribute.
     */
    private String Description;
    /**
     * The maximum value in a range of measurement of this dimension.
     */
    private Measure.Type MaximumMeasure;
    /**
     * The measurement value.
     */
    private Measure.Type Measure;
    /**
     * The minimum value in a range of measurement of this dimension.
     */
    private Measure.Type MinimumMeasure;

    public Dimension() {

    }

    public void finalize() throws Throwable {

    }

    public String getAttributeID() {
        return AttributeID;
    }

    public String getDescription() {
        return Description;
    }

    public Measure.Type getMaximumMeasure() {
        return MaximumMeasure;
    }

    public Measure.Type getMeasure() {
        return Measure;
    }

    public Measure.Type getMinimumMeasure() {
        return MinimumMeasure;
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
    public void setMaximumMeasure(Measure.Type newVal) {
        MaximumMeasure = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setMeasure(Measure.Type newVal) {
        Measure = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setMinimumMeasure(Measure.Type newVal) {
        MinimumMeasure = newVal;
    }
}// end Dimension