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

import java.util.List;

public class DimensionRepresentation {
    private String attributeID;
    private MeasureRepresentation measure;
    private List<String> description;
    private MeasureRepresentation minimumMeasure;
    private MeasureRepresentation maximumMeasure;
    private String id;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getDescription() {
        return this.description;
    }

    public void setDescription(List<String> description) {
        this.description = description;
    }

    public MeasureRepresentation getMinimumMeasure() {
        return this.minimumMeasure;
    }

    public void setMinimumMeasure(MeasureRepresentation minimumMeasure) {
        this.minimumMeasure = minimumMeasure;
    }

    public MeasureRepresentation getMeasure() {
        return this.measure;
    }

    public void setMeasure(MeasureRepresentation measure) {
        this.measure = measure;
    }

    public String getAttributeID() {
        return this.attributeID;
    }

    public void setAttributeID(String attributeID) {
        this.attributeID = attributeID;
    }

    public MeasureRepresentation getMaximumMeasure() {
        return this.maximumMeasure;
    }

    public void setMaximumMeasure(MeasureRepresentation maximumMeasure) {
        this.maximumMeasure = maximumMeasure;
    }
}