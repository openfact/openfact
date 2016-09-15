package org.openfact.models.ubl.common;

public interface LocationCoordinateModel {

    String getCoordinateSystemCode();

    void setCoordinateSystemCode(String value);

    LatitudeDegreesMeasureModel getLatitudeDegreesMeasure();

    void setLatitudeDegreesMeasure(LatitudeDegreesMeasureModel value);

    LatitudeMinutesMeasureModel getLatitudeMinutesMeasure();

    void setLatitudeMinutesMeasure(LatitudeMinutesMeasureModel value);

    String getLatitudeDirectionCode();

    void setLatitudeDirectionCode(String value);

    LongitudeDegreesMeasureModel getLongitudeDegreesMeasure();

    void setLongitudeDegreesMeasure(LongitudeDegreesMeasureModel value);

    LongitudeMinutesMeasureModel getLongitudeMinutesMeasure();

    void setLongitudeMinutesMeasure(LongitudeMinutesMeasureModel value);

    String getLongitudeDirectionCode();

    void setLongitudeDirectionCode(String value);

    String getId();

    void setId(String value);

}
