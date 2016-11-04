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

import java.time.LocalDate;
import java.time.LocalTime;

public interface DeliveryModel {

    String getID();

    void setID(String value);

    QuantityModel getQuantity();

    void setQuantity(QuantityModel value);

    QuantityModel getMinimumQuantity();

    void setMinimumQuantity(QuantityModel value);

    QuantityModel getMaximumQuantity();

    void setMaximumQuantity(QuantityModel value);

    LocalDate getActualDeliveryDate();

    void setActualDeliveryDate(LocalDate value);

    LocalTime getActualDeliveryTime();

    void setActualDeliveryTime(LocalTime value);

    LocalDate getLatestDeliveryDate();

    void setLatestDeliveryDate(LocalDate value);

    LocalTime getLatestDeliveryTime();

    void setLatestDeliveryTime(LocalTime value);

    String getTrackingID();

    void setTrackingID(String value);

    AddressModel getDeliveryAddress();

    void setDeliveryAddress(AddressModel value);

    LocationCommAggModel getDeliveryLocation();

    void setDeliveryLocation(LocationCommAggModel value);

    PeriodModel getRequestedDeliveryPeriod();

    void setRequestedDeliveryPeriod(PeriodModel value);

    PeriodModel getPromisedDeliveryPeriod();

    void setPromisedDeliveryPeriod(PeriodModel value);

    PeriodModel getEstimatedDeliveryPeriod();

    void setEstimatedDeliveryPeriod(PeriodModel value);

    PartyModel getDeliveryParty();

    void setDeliveryParty(PartyModel value);

    DespatchModel getDespatch();

    void setDespatch(DespatchModel value);

    String getId();


}
