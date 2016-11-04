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

public interface ShipmentStageModel {

    String getID();

    void setID(String value);

    String getTransportModeCode();

    void setTransportModeCode(String value);

    String getTransportMeansTypeCode();

    void setTransportMeansTypeCode(String value);

    String getTransitDirectionCode();

    void setTransitDirectionCode(String value);

    boolean getPreCarriageIndicator();

    void setPreCarriageIndicator(boolean value);

    boolean getOnCarriageIndicator();

    void setOnCarriageIndicator(boolean value);

    PeriodModel getTransitPeriod();

    void setTransitPeriod(PeriodModel value);

    List<PartyModel> getCarrierParty();

    void setCarrierParty(List<PartyModel> carrierParty);

    TransportMeansModel getTransportMeans();

    void setTransportMeans(TransportMeansModel value);

    LocationCommAggModel getLoadingPortLocation();

    void setLoadingPortLocation(LocationCommAggModel value);

    LocationCommAggModel getUnloadingPortLocation();

    void setUnloadingPortLocation(LocationCommAggModel value);

    LocationCommAggModel getTransshipPortLocation();

    void setTransshipPortLocation(LocationCommAggModel value);

    String getId();


}
