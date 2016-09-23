package org.openfact.representations.idm.ubl.common;

import java.util.List;

public class DimensionRepresentation {
    private String attributeID;
    private MeasureRepresentation measure;
    private List<String> description;
    private MeasureRepresentation minimumMeasure;
    private MeasureRepresentation maximumMeasure;
    private String id;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getDescription() {
        return this.description;
    }

    public void setDescription(List<String> description) {
        this.description = description;
    }

    public MeasureRepresentation getMinimumMeasure() {
        return this.minimumMeasure;
    }

    public void setMinimumMeasure(MeasureRepresentation minimumMeasure) {
        this.minimumMeasure = minimumMeasure;
    }

    public MeasureRepresentation getMeasure() {
        return this.measure;
    }

    public void setMeasure(MeasureRepresentation measure) {
        this.measure = measure;
    }

    public String getAttributeID() {
        return this.attributeID;
    }

    public void setAttributeID(String attributeID) {
        this.attributeID = attributeID;
    }

    public MeasureRepresentation getMaximumMeasure() {
        return this.maximumMeasure;
    }

    public void setMaximumMeasure(MeasureRepresentation maximumMeasure) {
        this.maximumMeasure = maximumMeasure;
    }
}