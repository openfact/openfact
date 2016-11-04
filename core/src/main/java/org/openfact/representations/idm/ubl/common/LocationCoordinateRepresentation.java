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