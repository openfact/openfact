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

public interface TransportHandlingUnitModel {

    String getID();

    void setID(String value);

    String getTransportHandlingUnitTypeCode();

    void setTransportHandlingUnitTypeCode(String value);

    String getHandlingCode();

    void setHandlingCode(String value);

    String getHandlingInstructions();

    void setHandlingInstructions(String value);

    boolean getHazardousRiskIndicator();

    void setHazardousRiskIndicator(boolean value);

    QuantityModel getTotalGoodsItemQuantity();

    void setTotalGoodsItemQuantity(QuantityModel value);

    QuantityModel getTotalPackageQuantity();

    void setTotalPackageQuantity(QuantityModel value);

    List<String> getDamageRemarks();

    void setDamageRemarks(List<String> damageRemarks);

    List<String> getShippingMarks();

    void setShippingMarks(List<String> shippingMarks);

    List<DespatchLineModel> getHandlingUnitDespatchLine();

    void setHandlingUnitDespatchLine(List<DespatchLineModel> handlingUnitDespatchLine);

    List<PackageModel> getActualPackage();

    void setActualPackage(List<PackageModel> actualPackage);

    List<ReceiptLineModel> getReceivedHandlingUnitReceiptLine();

    void setReceivedHandlingUnitReceiptLine(List<ReceiptLineModel> receivedHandlingUnitReceiptLine);

    List<TransportEquipmentModel> getTransportEquipment();

    void setTransportEquipment(List<TransportEquipmentModel> transportEquipment);

    List<HazardousGoodsTransitModel> getHazardousGoodsTransit();

    void setHazardousGoodsTransit(List<HazardousGoodsTransitModel> hazardousGoodsTransit);

    List<DimensionModel> getMeasurementDimension();

    void setMeasurementDimension(List<DimensionModel> measurementDimension);

    TemperatureModel getMinimumTemperature();

    void setMinimumTemperature(TemperatureModel value);

    TemperatureModel getMaximumTemperature();

    void setMaximumTemperature(TemperatureModel value);

    String getId();


}
