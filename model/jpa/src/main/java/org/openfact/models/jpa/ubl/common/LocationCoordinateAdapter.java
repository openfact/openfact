package org.openfact.models.jpa.ubl.common;

import javax.persistence.EntityManager;

import org.openfact.models.OpenfactSession;
import org.jboss.logging.Logger;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.LocationCoordinateEntity;
import org.openfact.models.ubl.common.LocationCoordinateModel;
import org.openfact.models.ubl.common.MeasureModel;

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

    @Override
    public String getCoordinateSystemCode() {
        return this.locationCoordinate.getCoordinateSystemCode();
    }

    @Override
    public void setCoordinateSystemCode(String value) {
        this.locationCoordinate.setCoordinateSystemCode(value);
    }

    @Override
    public MeasureModel getLatitudeDegreesMeasure() {
        return this.locationCoordinate.getLatitudeDegreesMeasure();
    }

    @Override
    public void setLatitudeDegreesMeasure(MeasureAdapter value) {
        this.locationCoordinate.setLatitudeDegreesMeasure(value);
    }

    @Override
    public MeasureModel getLatitudeMinutesMeasure() {
        return this.locationCoordinate.getLatitudeMinutesMeasure();
    }

    @Override
    public void setLatitudeMinutesMeasure(MeasureAdapter value) {
        this.locationCoordinate.setLatitudeMinutesMeasure(value);
    }

    @Override
    public String getLatitudeDirectionCode() {
        return this.locationCoordinate.getLatitudeDirectionCode();
    }

    @Override
    public void setLatitudeDirectionCode(String value) {
        this.locationCoordinate.setLatitudeDirectionCode(value);
    }

    @Override
    public MeasureModel getLongitudeDegreesMeasure() {
        return this.locationCoordinate.getLongitudeDegreesMeasure();
    }

    @Override
    public void setLongitudeDegreesMeasure(MeasureAdapter value) {
        this.locationCoordinate.setLongitudeDegreesMeasure(value);
    }

    @Override
    public MeasureModel getLongitudeMinutesMeasure() {
        return this.locationCoordinate.getLongitudeMinutesMeasure();
    }

    @Override
    public void setLongitudeMinutesMeasure(MeasureAdapter value) {
        this.locationCoordinate.setLongitudeMinutesMeasure(value);
    }

    @Override
    public String getLongitudeDirectionCode() {
        return this.locationCoordinate.getLongitudeDirectionCode();
    }

    @Override
    public void setLongitudeDirectionCode(String value) {
        this.locationCoordinate.setLongitudeDirectionCode(value);
    }

    @Override
    public String getId() {
        return this.locationCoordinate.getId();
    }

    @Override
    public void setId(String value) {
        this.locationCoordinate.setId(value);
    }

    @Override
    public LocationCoordinateEntity getEntity() {
        // TODO Auto-generated method stub
        return null;
    }

    public static LocationCoordinateEntity toEntity(LocationCoordinateModel value) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setLatitudeDegreesMeasure(MeasureModel value) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setLatitudeMinutesMeasure(MeasureModel value) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setLongitudeDegreesMeasure(MeasureModel value) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setLongitudeMinutesMeasure(MeasureModel value) {
        // TODO Auto-generated method stub

    }

}
