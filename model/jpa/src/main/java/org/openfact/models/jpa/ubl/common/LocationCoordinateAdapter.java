package org.openfact.models.jpa.ubl.common;

public class LocationCoordinateAdapter
        implements LocationCoordinateModel, JpaModel<LocationCoordinateEntity> {

    protected static final Logger logger = Logger.getLogger(LocationCoordinateAdapter.class);
    protected LocationCoordinateEntity locationCoordinate;
    protected EntityManager em;
    protected OpenfactSession session;

    public LocationCoordinateAdapter(OpenfactSession session, EntityManager em,
            LocationCoordinateEntity locationCoordinate) {
        this.session = session;
        this.em = em;
        this.locationCoordinate = locationCoordinate;
    }

    String getCoordinateSystemCode() {
        return this.locationCoordinate.getCoordinateSystemCode();
    }

    void setCoordinateSystemCode(String value) {
        this.locationCoordinate.setCoordinateSystemCode(value);
    }

    MeasureAdapter getLatitudeDegreesMeasure() {
        return this.locationCoordinate.getLatitudeDegreesMeasure();
    }

    void setLatitudeDegreesMeasure(MeasureAdapter value) {
        this.locationCoordinate.setLatitudeDegreesMeasure(value);
    }

    MeasureAdapter getLatitudeMinutesMeasure() {
        return this.locationCoordinate.getLatitudeMinutesMeasure();
    }

    void setLatitudeMinutesMeasure(MeasureAdapter value) {
        this.locationCoordinate.setLatitudeMinutesMeasure(value);
    }

    String getLatitudeDirectionCode() {
        return this.locationCoordinate.getLatitudeDirectionCode();
    }

    void setLatitudeDirectionCode(String value) {
        this.locationCoordinate.setLatitudeDirectionCode(value);
    }

    MeasureAdapter getLongitudeDegreesMeasure() {
        return this.locationCoordinate.getLongitudeDegreesMeasure();
    }

    void setLongitudeDegreesMeasure(MeasureAdapter value) {
        this.locationCoordinate.setLongitudeDegreesMeasure(value);
    }

    MeasureAdapter getLongitudeMinutesMeasure() {
        return this.locationCoordinate.getLongitudeMinutesMeasure();
    }

    void setLongitudeMinutesMeasure(MeasureAdapter value) {
        this.locationCoordinate.setLongitudeMinutesMeasure(value);
    }

    String getLongitudeDirectionCode() {
        return this.locationCoordinate.getLongitudeDirectionCode();
    }

    void setLongitudeDirectionCode(String value) {
        this.locationCoordinate.setLongitudeDirectionCode(value);
    }

    String getId() {
        return this.locationCoordinate.getId();
    }

    void setId(String value) {
        this.locationCoordinate.setId(value);
    }

}
