package org.openfact.models.ubl.common;

import java.util.List;

public interface DimensionType {

    AttributeIDType getAttributeID();

    void setAttributeID(AttributeIDType value);

    MeasureTypeCommBas getMeasure();

    void setMeasure(MeasureTypeCommBas value);

    List<DescriptionType> getDescription();

    void setDescription(List<DescriptionType> description);

    MinimumMeasureType getMinimumMeasure();

    void setMinimumMeasure(MinimumMeasureType value);

    MaximumMeasureType getMaximumMeasure();

    void setMaximumMeasure(MaximumMeasureType value);

    String getId();

    void setId(String value);

}
