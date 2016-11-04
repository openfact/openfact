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

public interface HazardousItemModel {

    String getID();

    void setID(String value);

    String getPlacardNotation();

    void setPlacardNotation(String value);

    String getPlacardEndorsement();

    void setPlacardEndorsement(String value);

    String getAdditionalInformation();

    void setAdditionalInformation(String value);

    String getUNDGCode();

    void setUNDGCode(String value);

    String getEmergencyProceduresCode();

    void setEmergencyProceduresCode(String value);

    String getMedicalFirstAidGuideCode();

    void setMedicalFirstAidGuideCode(String value);

    String getTechnicalName();

    void setTechnicalName(String value);

    String getCategoryName();

    void setCategoryName(String value);

    String getHazardousCategoryCode();

    void setHazardousCategoryCode(String value);

    String getUpperOrangeHazardPlacardID();

    void setUpperOrangeHazardPlacardID(String value);

    String getLowerOrangeHazardPlacardID();

    void setLowerOrangeHazardPlacardID(String value);

    String getMarkingID();

    void setMarkingID(String value);

    String getHazardClassID();

    void setHazardClassID(String value);

    MeasureModel getNetWeightMeasure();

    void setNetWeightMeasure(MeasureModel value);

    MeasureModel getNetVolumeMeasure();

    void setNetVolumeMeasure(MeasureModel value);

    QuantityModel getQuantity();

    void setQuantity(QuantityModel value);

    PartyModel getContactParty();

    void setContactParty(PartyModel value);

    List<SecondaryHazardModel> getSecondaryHazard();

    void setSecondaryHazard(List<SecondaryHazardModel> secondaryHazard);

    List<HazardousGoodsTransitModel> getHazardousGoodsTransit();

    void setHazardousGoodsTransit(List<HazardousGoodsTransitModel> hazardousGoodsTransit);

    TemperatureModel getEmergencyTemperature();

    void setEmergencyTemperature(TemperatureModel value);

    TemperatureModel getFlashpointTemperature();

    void setFlashpointTemperature(TemperatureModel value);

    List<TemperatureModel> getAdditionalTemperature();

    void setAdditionalTemperature(List<TemperatureModel> additionalTemperature);

    String getId();


}
