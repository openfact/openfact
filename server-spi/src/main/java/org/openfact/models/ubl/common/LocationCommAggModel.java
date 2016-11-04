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

public interface LocationCommAggModel {

    String getID();

    void setID(String value);

    String getDescription();

    void setDescription(String value);

    String getConditions();

    void setConditions(String value);

    String getCountrySubentity();

    void setCountrySubentity(String value);

    String getCountrySubentityCode();

    void setCountrySubentityCode(String value);

    List<PeriodModel> getValidityPeriod();

    void setValidityPeriod(List<PeriodModel> validityPeriod);

    AddressModel getAddress();

    void setAddress(AddressModel value);

    String getId();


}
