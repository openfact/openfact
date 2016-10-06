package org.openfact.models.ubl.common;

public interface LocationCoordinateModel {

    String getCoordinateSystemCode();

    void setCoordinateSystemCode(String value);

    MeasureModel getLatitudeDegreesMeasure();

    void setLatitudeDegreesMeasure(MeasureModel value);

    MeasureModel getLatitudeMinutesMeasure();

    void setLatitudeMinutesMeasure(MeasureModel value);

    String getLatitudeDirectionCode();

    void setLatitudeDirectionCode(String value);

    MeasureModel getLongitudeDegreesMeasure();

    void setLongitudeDegreesMeasure(MeasureModel value);

    MeasureModel getLongitudeMinutesMeasure();

    void setLongitudeMinutesMeasure(MeasureModel value);

    String getLongitudeDirectionCode();

    void setLongitudeDirectionCode(String value);

    String getId();

    

}
