package org.openfact.models.ubl.common;

import java.util.List;

public interface StowageModel {

    LocationIDModel getLocationID();

    void setLocationID(LocationIDModel value);

    List<LocationModel> getLocation();

    void setLocation(List<LocationModel> location);

    List<DimensionModel> getMeasurementDimension();

    void setMeasurementDimension(List<DimensionModel> measurementDimension);

    String getId();

    void setId(String value);

}
