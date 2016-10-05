package org.openfact.models.ubl.common;

import java.util.List;

public interface TemperatureModel {

    String getAttributeID();

    void setAttributeID(String value);

    MeasureModel getMeasure();

    void setMeasure(MeasureModel value);

    List<String> getDescription();

    void setDescription(List<String> description);

    String getId();

    

}
