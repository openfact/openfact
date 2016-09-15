package org.openfact.models.ubl.common;

public interface LocationCoordinateModel {

    CoordinateSystemCodeModel getCoordinateSystemCode();

    void setCoordinateSystemCode(CoordinateSystemCodeModel value);

    LatitudeDegreesMeasureModel getLatitudeDegreesMeasure();

    void setLatitudeDegreesMeasure(LatitudeDegreesMeasureModel value);

    LatitudeMinutesMeasureModel getLatitudeMinutesMeasure();

    void setLatitudeMinutesMeasure(LatitudeMinutesMeasureModel value);

    LatitudeDirectionCodeModelCommBas getLatitudeDirectionCode();

    void setLatitudeDirectionCode(LatitudeDirectionCodeModelCommBas value);

    LongitudeDegreesMeasureModel getLongitudeDegreesMeasure();

    void setLongitudeDegreesMeasure(LongitudeDegreesMeasureModel value);

    LongitudeMinutesMeasureModel getLongitudeMinutesMeasure();

    void setLongitudeMinutesMeasure(LongitudeMinutesMeasureModel value);

    LongitudeDirectionCodeModelCommBas getLongitudeDirectionCode();

    void setLongitudeDirectionCode(LongitudeDirectionCodeModelCommBas value);

    String getId();

    void setId(String value);

}
