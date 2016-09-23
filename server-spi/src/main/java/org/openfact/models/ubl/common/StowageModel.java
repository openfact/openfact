package org.openfact.models.ubl.common;

import java.util.List;

public interface StowageModel {

    String getLocationID();

    void setLocationID(String value);

    List<String> getLocation();

    void setLocation(List<String> location);

    List<DimensionModel> getMeasurementDimension();

    void setMeasurementDimension(List<DimensionModel> measurementDimension);

    String getId();

    void setId(String value);

}
