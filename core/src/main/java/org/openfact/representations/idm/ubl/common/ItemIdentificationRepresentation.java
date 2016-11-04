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

public class ItemIdentificationRepresentation {
    private String idUbl;
    private String extendedID;
    private List<PhysicalAttributeRepresentation> physicalAttribute;
    private List<DimensionRepresentation> measurementDimension;
    private PartyRepresentation issuerParty;
    private String id;

    public String getIdUbl() {
        return this.idUbl;
    }

    public void setIdUbl(String idUbl) {
        this.idUbl = idUbl;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<PhysicalAttributeRepresentation> getPhysicalAttribute() {
        return this.physicalAttribute;
    }

    public void setPhysicalAttribute(List<PhysicalAttributeRepresentation> physicalAttribute) {
        this.physicalAttribute = physicalAttribute;
    }

    public PartyRepresentation getIssuerParty() {
        return this.issuerParty;
    }

    public void setIssuerParty(PartyRepresentation issuerParty) {
        this.issuerParty = issuerParty;
    }

    public List<DimensionRepresentation> getMeasurementDimension() {
        return this.measurementDimension;
    }

    public void setMeasurementDimension(List<DimensionRepresentation> measurementDimension) {
        this.measurementDimension = measurementDimension;
    }

    public String getExtendedID() {
        return this.extendedID;
    }

    public void setExtendedID(String extendedID) {
        this.extendedID = extendedID;
    }
}