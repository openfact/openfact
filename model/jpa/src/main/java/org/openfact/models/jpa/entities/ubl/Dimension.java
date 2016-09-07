package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;

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
    private BigDecimal MaximumMeasure;
    /**
     * The measurement value.
     */
    private BigDecimal Measure;
    /**
     * The minimum value in a range of measurement of this dimension.
     */
    private BigDecimal MinimumMeasure;

    /**
     * @return the attributeID
     */
    public String getAttributeID() {
        return AttributeID;
    }

    /**
     * @param attributeID
     *            the attributeID to set
     */
    public void setAttributeID(String attributeID) {
        AttributeID = attributeID;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return Description;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
        Description = description;
    }

    /**
     * @return the maximumMeasure
     */
    public BigDecimal getMaximumMeasure() {
        return MaximumMeasure;
    }

    /**
     * @param maximumMeasure
     *            the maximumMeasure to set
     */
    public void setMaximumMeasure(BigDecimal maximumMeasure) {
        MaximumMeasure = maximumMeasure;
    }

    /**
     * @return the measure
     */
    public BigDecimal getMeasure() {
        return Measure;
    }

    /**
     * @param measure
     *            the measure to set
     */
    public void setMeasure(BigDecimal measure) {
        Measure = measure;
    }

    /**
     * @return the minimumMeasure
     */
    public BigDecimal getMinimumMeasure() {
        return MinimumMeasure;
    }

    /**
     * @param minimumMeasure
     *            the minimumMeasure to set
     */
    public void setMinimumMeasure(BigDecimal minimumMeasure) {
        MinimumMeasure = minimumMeasure;
    }
}