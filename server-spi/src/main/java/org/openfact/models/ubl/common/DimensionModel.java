package org.openfact.models.ubl.common;

import java.util.List;

public interface DimensionModel {

    String getAttributeID();

    void setAttributeID(String value);

    MeasureModel getMeasure();

    void setMeasure(MeasureModel value);

    List<String> getDescription();

    void setDescription(List<String> description);

    MeasureModel getMinimumMeasure();

    void setMinimumMeasure(MeasureModel value);

    MeasureModel getMaximumMeasure();

    void setMaximumMeasure(MeasureModel value);

    String getId();

    void setId(String value);

}
