package org.openfact.models.ubl.common;

import java.util.List;

public interface TemperatureType {

    AttributeIDType getAttributeID();

    void setAttributeID(AttributeIDType value);

    MeasureTypeCommBas getMeasure();

    void setMeasure(MeasureTypeCommBas value);

    List<DescriptionType> getDescription();

    void setDescription(List<DescriptionType> description);

    String getId();

    void setId(String value);

}
