package org.openfact.models.ubl.common;

import java.util.List;

public interface StowageModel {

    String getLocationID();

    void setLocationID(String value);

    List<LocationCommAggModel> getLocation();

    void setLocation(List<LocationCommAggModel> location);

    List<DimensionModel> getMeasurementDimension();

    void setMeasurementDimension(List<DimensionModel> measurementDimension);

    String getId();

    

}
