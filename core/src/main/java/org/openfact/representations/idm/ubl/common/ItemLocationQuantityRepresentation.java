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

public class ItemLocationQuantityRepresentation {
    private MeasureRepresentation leadTimeMeasure;
    private QuantityRepresentation minimumQuantity;
    private QuantityRepresentation maximumQuantity;
    private Boolean hazardousRiskIndicator;
    private List<String> tradingRestrictions;
    private List<AddressRepresentation> applicableTerritoryAddress;
    private PriceRepresentation price;
    private List<DeliveryUnitRepresentation> deliveryUnit;
    private List<TaxCategoryRepresentation> applicableTaxCategory;
    private String id;

    public List<DeliveryUnitRepresentation> getDeliveryUnit() {
        return this.deliveryUnit;
    }

    public void setDeliveryUnit(List<DeliveryUnitRepresentation> deliveryUnit) {
        this.deliveryUnit = deliveryUnit;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PriceRepresentation getPrice() {
        return this.price;
    }

    public void setPrice(PriceRepresentation price) {
        this.price = price;
    }

    public MeasureRepresentation getLeadTimeMeasure() {
        return this.leadTimeMeasure;
    }

    public void setLeadTimeMeasure(MeasureRepresentation leadTimeMeasure) {
        this.leadTimeMeasure = leadTimeMeasure;
    }

    public QuantityRepresentation getMaximumQuantity() {
        return this.maximumQuantity;
    }

    public void setMaximumQuantity(QuantityRepresentation maximumQuantity) {
        this.maximumQuantity = maximumQuantity;
    }

    public List<String> getTradingRestrictions() {
        return this.tradingRestrictions;
    }

    public void setTradingRestrictions(List<String> tradingRestrictions) {
        this.tradingRestrictions = tradingRestrictions;
    }

    public List<TaxCategoryRepresentation> getApplicableTaxCategory() {
        return this.applicableTaxCategory;
    }

    public void setApplicableTaxCategory(List<TaxCategoryRepresentation> applicableTaxCategory) {
        this.applicableTaxCategory = applicableTaxCategory;
    }

    public QuantityRepresentation getMinimumQuantity() {
        return this.minimumQuantity;
    }

    public void setMinimumQuantity(QuantityRepresentation minimumQuantity) {
        this.minimumQuantity = minimumQuantity;
    }

    public List<AddressRepresentation> getApplicableTerritoryAddress() {
        return this.applicableTerritoryAddress;
    }

    public void setApplicableTerritoryAddress(List<AddressRepresentation> applicableTerritoryAddress) {
        this.applicableTerritoryAddress = applicableTerritoryAddress;
    }

    public Boolean getHazardousRiskIndicator() {
        return this.hazardousRiskIndicator;
    }

    public void setHazardousRiskIndicator(Boolean hazardousRiskIndicator) {
        this.hazardousRiskIndicator = hazardousRiskIndicator;
    }
}