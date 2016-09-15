package org.openfact.models.ubl.common;

import java.util.List;

public interface DimensionModel {

    AttributeIDModel getAttributeID();

    void setAttributeID(AttributeIDModel value);

    MeasureModelCommBas getMeasure();

    void setMeasure(MeasureModelCommBas value);

    List<DescriptionModel> getDescription();

    void setDescription(List<DescriptionModel> description);

    MinimumMeasureModel getMinimumMeasure();

    void setMinimumMeasure(MinimumMeasureModel value);

    MaximumMeasureModel getMaximumMeasure();

    void setMaximumMeasure(MaximumMeasureModel value);

    String getId();

    void setId(String value);

}
