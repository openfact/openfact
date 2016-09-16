package org.openfact.representations.idm.ubl.common;

public class LocationCoordinateRepresentation {
    private String coordinateSystemCode;
    private MeasureRepresentation latitudeDegreesMeasure;
    private MeasureRepresentation latitudeMinutesMeasure;
    private String latitudeDirectionCode;
    private MeasureRepresentation longitudeDegreesMeasure;
    private MeasureRepresentation longitudeMinutesMeasure;
    private String longitudeDirectionCode;
    private String id;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLatitudeDirectionCode() {
        return this.latitudeDirectionCode;
    }

    public void setLatitudeDirectionCode(String latitudeDirectionCode) {
        this.latitudeDirectionCode = latitudeDirectionCode;
    }

    public String getLongitudeDirectionCode() {
        return this.longitudeDirectionCode;
    }

    public void setLongitudeDirectionCode(String longitudeDirectionCode) {
        this.longitudeDirectionCode = longitudeDirectionCode;
    }

    public MeasureRepresentation getLatitudeDegreesMeasure() {
        return this.latitudeDegreesMeasure;
    }

    public void setLatitudeDegreesMeasure(MeasureRepresentation latitudeDegreesMeasure) {
        this.latitudeDegreesMeasure = latitudeDegreesMeasure;
    }

    public MeasureRepresentation getLongitudeDegreesMeasure() {
        return this.longitudeDegreesMeasure;
    }

    public void setLongitudeDegreesMeasure(MeasureRepresentation longitudeDegreesMeasure) {
        this.longitudeDegreesMeasure = longitudeDegreesMeasure;
    }

    public String getCoordinateSystemCode() {
        return this.coordinateSystemCode;
    }

    public void setCoordinateSystemCode(String coordinateSystemCode) {
        this.coordinateSystemCode = coordinateSystemCode;
    }

    public MeasureRepresentation getLongitudeMinutesMeasure() {
        return this.longitudeMinutesMeasure;
    }

    public void setLongitudeMinutesMeasure(MeasureRepresentation longitudeMinutesMeasure) {
        this.longitudeMinutesMeasure = longitudeMinutesMeasure;
    }

    public MeasureRepresentation getLatitudeMinutesMeasure() {
        return this.latitudeMinutesMeasure;
    }

    public void setLatitudeMinutesMeasure(MeasureRepresentation latitudeMinutesMeasure) {
        this.latitudeMinutesMeasure = latitudeMinutesMeasure;
    }
}