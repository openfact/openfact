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

import java.math.BigDecimal;
import java.util.List;

public interface GoodsItemModel {

    String getID();

    void setID(String value);

    String getSequenceNumberID();

    void setSequenceNumberID(String value);

    List<String> getDescription();

    void setDescription(List<String> description);

    boolean getHazardousRiskIndicator();

    void setHazardousRiskIndicator(boolean value);

    BigDecimal getDeclaredCustomsValueAmount();

    void setDeclaredCustomsValueAmount(BigDecimal value);

    BigDecimal getDeclaredForCarriageValueAmount();

    void setDeclaredForCarriageValueAmount(BigDecimal value);

    BigDecimal getDeclaredStatisticsValueAmount();

    void setDeclaredStatisticsValueAmount(BigDecimal value);

    BigDecimal getFreeOnBoardValueAmount();

    void setFreeOnBoardValueAmount(BigDecimal value);

    BigDecimal getInsuranceValueAmount();

    void setInsuranceValueAmount(BigDecimal value);

    BigDecimal getValueAmount();

    void setValueAmount(BigDecimal value);

    MeasureModel getGrossWeightMeasure();

    void setGrossWeightMeasure(MeasureModel value);

    MeasureModel getNetWeightMeasure();

    void setNetWeightMeasure(MeasureModel value);

    MeasureModel getNetNetWeightMeasure();

    void setNetNetWeightMeasure(MeasureModel value);

    MeasureModel getChargeableWeightMeasure();

    void setChargeableWeightMeasure(MeasureModel value);

    MeasureModel getGrossVolumeMeasure();

    void setGrossVolumeMeasure(MeasureModel value);

    MeasureModel getNetVolumeMeasure();

    void setNetVolumeMeasure(MeasureModel value);

    QuantityModel getQuantity();

    void setQuantity(QuantityModel value);

    String getPreferenceCriterionCode();

    void setPreferenceCriterionCode(String value);

    String getRequiredCustomsID();

    void setRequiredCustomsID(String value);

    String getCustomsStatusCode();

    void setCustomsStatusCode(String value);

    QuantityModel getCustomsTariffQuantity();

    void setCustomsTariffQuantity(QuantityModel value);

    boolean getCustomsImportClassifiedIndicator();

    void setCustomsImportClassifiedIndicator(boolean value);

    List<ItemModel> getItem();

    void setItem(List<ItemModel> item);

    List<GoodsItemContainerModel> getGoodsItemContainer();

    void setGoodsItemContainer(List<GoodsItemContainerModel> goodsItemContainer);

    List<AllowanceChargeModel> getFreightAllowanceCharge();

    void setFreightAllowanceCharge(List<AllowanceChargeModel> freightAllowanceCharge);

    List<InvoiceLineModel> getInvoiceLine();

    void setInvoiceLine(List<InvoiceLineModel> invoiceLine);

    List<TemperatureModel> getTemperature();

    void setTemperature(List<TemperatureModel> temperature);

    List<GoodsItemModel> getContainedGoodsItem();

    void setContainedGoodsItem(List<GoodsItemModel> containedGoodsItem);

    AddressModel getOriginAddress();

    void setOriginAddress(AddressModel value);

    String getId();


}
