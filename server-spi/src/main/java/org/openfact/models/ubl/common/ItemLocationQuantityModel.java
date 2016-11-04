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
package org.openfact.models.ubl.common;

import java.util.List;

public interface ItemLocationQuantityModel {

    MeasureModel getLeadTimeMeasure();

    void setLeadTimeMeasure(MeasureModel value);

    QuantityModel getMinimumQuantity();

    void setMinimumQuantity(QuantityModel value);

    QuantityModel getMaximumQuantity();

    void setMaximumQuantity(QuantityModel value);

    boolean getHazardousRiskIndicator();

    void setHazardousRiskIndicator(boolean value);

    List<String> getTradingRestrictions();

    void setTradingRestrictions(List<String> tradingRestrictions);

    List<AddressModel> getApplicableTerritoryAddress();

    void setApplicableTerritoryAddress(List<AddressModel> applicableTerritoryAddress);

    PriceModel getPrice();

    void setPrice(PriceModel value);

    List<DeliveryUnitModel> getDeliveryUnit();

    void setDeliveryUnit(List<DeliveryUnitModel> deliveryUnit);

    List<TaxCategoryModel> getApplicableTaxCategory();

    void setApplicableTaxCategory(List<TaxCategoryModel> applicableTaxCategory);

    String getId();


}
