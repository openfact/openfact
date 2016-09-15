package org.openfact.models.ubl.common;

public interface LocationCoordinateType {

    CoordinateSystemCodeType getCoordinateSystemCode();

    void setCoordinateSystemCode(CoordinateSystemCodeType value);

    LatitudeDegreesMeasureType getLatitudeDegreesMeasure();

    void setLatitudeDegreesMeasure(LatitudeDegreesMeasureType value);

    LatitudeMinutesMeasureType getLatitudeMinutesMeasure();

    void setLatitudeMinutesMeasure(LatitudeMinutesMeasureType value);

    LatitudeDirectionCodeTypeCommBas getLatitudeDirectionCode();

    void setLatitudeDirectionCode(LatitudeDirectionCodeTypeCommBas value);

    LongitudeDegreesMeasureType getLongitudeDegreesMeasure();

    void setLongitudeDegreesMeasure(LongitudeDegreesMeasureType value);

    LongitudeMinutesMeasureType getLongitudeMinutesMeasure();

    void setLongitudeMinutesMeasure(LongitudeMinutesMeasureType value);

    LongitudeDirectionCodeTypeCommBas getLongitudeDirectionCode();

    void setLongitudeDirectionCode(LongitudeDirectionCodeTypeCommBas value);

    String getId();

    void setId(String value);

}
