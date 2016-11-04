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

public class SecondaryHazardRepresentation {
    private String idUbl;
    private String placardNotation;
    private String placardEndorsement;
    private String emergencyProceduresCode;
    private String extension;
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

    public String getPlacardEndorsement() {
        return this.placardEndorsement;
    }

    public void setPlacardEndorsement(String placardEndorsement) {
        this.placardEndorsement = placardEndorsement;
    }

    public String getPlacardNotation() {
        return this.placardNotation;
    }

    public void setPlacardNotation(String placardNotation) {
        this.placardNotation = placardNotation;
    }

    public String getEmergencyProceduresCode() {
        return this.emergencyProceduresCode;
    }

    public void setEmergencyProceduresCode(String emergencyProceduresCode) {
        this.emergencyProceduresCode = emergencyProceduresCode;
    }

    public String getExtension() {
        return this.extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
}