package org.openfact.models.jpa.entities.ubl;

/**
 * A class to define a measurable condition of an object.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:42 a. m.
 */
public class Condition {

    /**
     * An identifier for the attribute that applies to the condition.
     */
    private String AttributeID;
    /**
     * Text describing the attribute that applies to the condition.
     */
    private String Description;
    /**
     * The maximum value in a range of measurement for this condition.
     */
    private Measure.Type MaximumMeasure;
    /**
     * The measurement value.
     */
    private Measure.Type Measure;
    /**
     * The minimum value in a range of measurement for this condition.
     */
    private Measure.Type MinimumMeasure;

    public Condition() {

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
}// end Condition