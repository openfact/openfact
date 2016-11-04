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

public interface DespatchModel {

    String getID();

    void setID(String value);

    LocalDate getRequestedDespatchDate();

    void setRequestedDespatchDate(LocalDate value);

    LocalTime getRequestedDespatchTime();

    void setRequestedDespatchTime(LocalTime value);

    LocalDate getEstimatedDespatchDate();

    void setEstimatedDespatchDate(LocalDate value);

    LocalTime getEstimatedDespatchTime();

    void setEstimatedDespatchTime(LocalTime value);

    LocalDate getActualDespatchDate();

    void setActualDespatchDate(LocalDate value);

    LocalTime getActualDespatchTime();

    void setActualDespatchTime(LocalTime value);

    AddressModel getDespatchAddress();

    void setDespatchAddress(AddressModel value);

    PartyModel getDespatchParty();

    void setDespatchParty(PartyModel value);

    ContactModel getContact();

    void setContact(ContactModel value);

    String getId();


}
