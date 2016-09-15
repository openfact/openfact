package org.openfact.models.ubl.common;

import java.util.List;

public interface DimensionModel {

    String getAttributeID();

    void setAttributeID(String value);

    MeasureModelCommBas getMeasure();

    void setMeasure(MeasureModelCommBas value);

    List<String> getDescription();

    void setDescription(List<String> description);

    MinimumMeasureModel getMinimumMeasure();

    void setMinimumMeasure(MinimumMeasureModel value);

    MaximumMeasureModel getMaximumMeasure();

    void setMaximumMeasure(MaximumMeasureModel value);

    String getId();

    void setId(String value);

}
