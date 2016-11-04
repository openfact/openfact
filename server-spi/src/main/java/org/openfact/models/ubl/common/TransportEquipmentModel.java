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

public interface TransportEquipmentModel {

    String getID();

    void setID(String value);

    String getTransportEquipmentTypeCode();

    void setTransportEquipmentTypeCode(String value);

    String getProviderTypeCode();

    void setProviderTypeCode(String value);

    String getOwnerTypeCode();

    void setOwnerTypeCode(String value);

    String getSizeTypeCode();

    void setSizeTypeCode(String value);

    String getDispositionCode();

    void setDispositionCode(String value);

    String getFullnessIndicationCode();

    void setFullnessIndicationCode(String value);

    boolean getRefrigerationOnIndicator();

    void setRefrigerationOnIndicator(boolean value);

    String getInformation();

    void setInformation(String value);

    boolean getReturnabilityIndicator();

    void setReturnabilityIndicator(boolean value);

    boolean getLegalStatusIndicator();

    void setLegalStatusIndicator(boolean value);

    List<DimensionModel> getMeasurementDimension();

    void setMeasurementDimension(List<DimensionModel> measurementDimension);

    List<TransportEquipmentSealModel> getTransportEquipmentSeal();

    void setTransportEquipmentSeal(List<TransportEquipmentSealModel> transportEquipmentSeal);

    TemperatureModel getMinimumTemperature();

    void setMinimumTemperature(TemperatureModel value);

    TemperatureModel getMaximumTemperature();

    void setMaximumTemperature(TemperatureModel value);

    PartyModel getProviderParty();

    void setProviderParty(PartyModel value);

    PartyModel getLoadingProofParty();

    void setLoadingProofParty(PartyModel value);

    LocationCommAggModel getLoadingLocation();

    void setLoadingLocation(LocationCommAggModel value);

    String getId();


}
