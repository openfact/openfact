package org.openfact.models.ubl.common;

import java.util.List;

public interface TemperatureModel {

    String getAttributeID();

    void setAttributeID(String value);

    MeasureModelCommBas getMeasure();

    void setMeasure(MeasureModelCommBas value);

    List<String> getDescription();

    void setDescription(List<String> description);

    String getId();

    void setId(String value);

}
