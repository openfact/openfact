package org.openfact.models.ubl.common;

import java.util.List;

public interface TemperatureModel {

    AttributeIDModel getAttributeID();

    void setAttributeID(AttributeIDModel value);

    MeasureModelCommBas getMeasure();

    void setMeasure(MeasureModelCommBas value);

    List<DescriptionModel> getDescription();

    void setDescription(List<DescriptionModel> description);

    String getId();

    void setId(String value);

}
