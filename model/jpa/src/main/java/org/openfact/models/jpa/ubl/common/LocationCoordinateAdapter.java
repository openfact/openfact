/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package org.openfact.models.jpa.ubl.common;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
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
        return new MeasureAdapter(session, em, locationCoordinate.getLatitudeDegreesMeasure());
    }

    @Override
    public void setLatitudeDegreesMeasure(MeasureModel value) {
        this.locationCoordinate.setLatitudeDegreesMeasure(MeasureAdapter.toEntity(value, em));
    }

    @Override
    public MeasureModel getLatitudeMinutesMeasure() {
        return new MeasureAdapter(session, em, locationCoordinate.getLatitudeMinutesMeasure());
    }

    @Override
    public void setLatitudeMinutesMeasure(MeasureModel value) {
        this.locationCoordinate.setLatitudeMinutesMeasure(MeasureAdapter.toEntity(value, em));
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
        return new MeasureAdapter(session, em, locationCoordinate.getLongitudeDegreesMeasure());
    }

    @Override
    public void setLongitudeDegreesMeasure(MeasureModel value) {
        this.locationCoordinate.setLongitudeDegreesMeasure(MeasureAdapter.toEntity(value, em));
    }

    @Override
    public MeasureModel getLongitudeMinutesMeasure() {
        return new MeasureAdapter(session, em, locationCoordinate.getLongitudeMinutesMeasure());
    }

    @Override
    public void setLongitudeMinutesMeasure(MeasureModel value) {
        this.locationCoordinate.setLongitudeMinutesMeasure(MeasureAdapter.toEntity(value, em));
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
    public LocationCoordinateEntity getEntity() {

        return locationCoordinate;
    }

    public static LocationCoordinateEntity toEntity(LocationCoordinateModel model, EntityManager em) {
        if (model instanceof LocationCoordinateAdapter) {
            return ((LocationCoordinateAdapter) model).getEntity();
        }
        return em.getReference(LocationCoordinateEntity.class, model.getId());
    }

}
