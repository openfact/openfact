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
    private Identifier.Type AttributeID;
    /**
     * Text describing the attribute that applies to the condition.
     */
    private Text.Type Description;
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

    public Identifier.Type getAttributeID() {
        return AttributeID;
    }

    public Text.Type getDescription() {
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
    public void setAttributeID(Identifier.Type newVal) {
        AttributeID = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setDescription(Text.Type newVal) {
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