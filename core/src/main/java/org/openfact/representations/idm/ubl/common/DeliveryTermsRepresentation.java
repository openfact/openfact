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

public class DeliveryTermsRepresentation {
    private String idUbl;
    private String specialTerms;
    private String lossRiskResponsibilityCode;
    private String lossRisk;
    private LocationRepresentationCommAgg deliveryLocation;
    private AllowanceChargeRepresentation allowanceCharge;
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

    public String getLossRiskResponsibilityCode() {
        return this.lossRiskResponsibilityCode;
    }

    public void setLossRiskResponsibilityCode(String lossRiskResponsibilityCode) {
        this.lossRiskResponsibilityCode = lossRiskResponsibilityCode;
    }

    public String getSpecialTerms() {
        return this.specialTerms;
    }

    public void setSpecialTerms(String specialTerms) {
        this.specialTerms = specialTerms;
    }

    public String getLossRisk() {
        return this.lossRisk;
    }

    public void setLossRisk(String lossRisk) {
        this.lossRisk = lossRisk;
    }

    public AllowanceChargeRepresentation getAllowanceCharge() {
        return this.allowanceCharge;
    }

    public void setAllowanceCharge(AllowanceChargeRepresentation allowanceCharge) {
        this.allowanceCharge = allowanceCharge;
    }

    public LocationRepresentationCommAgg getDeliveryLocation() {
        return this.deliveryLocation;
    }

    public void setDeliveryLocation(LocationRepresentationCommAgg deliveryLocation) {
        this.deliveryLocation = deliveryLocation;
    }
}