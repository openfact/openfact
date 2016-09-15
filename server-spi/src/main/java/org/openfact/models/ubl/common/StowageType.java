package org.openfact.models.ubl.common;

import java.util.List;

public interface StowageType {

    LocationIDType getLocationID();

    void setLocationID(LocationIDType value);

    List<LocationType> getLocation();

    void setLocation(List<LocationType> location);

    List<DimensionType> getMeasurementDimension();

    void setMeasurementDimension(List<DimensionType> measurementDimension);

    String getId();

    void setId(String value);

}
