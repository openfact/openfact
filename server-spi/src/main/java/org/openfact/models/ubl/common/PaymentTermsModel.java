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

public interface PaymentTermsModel {

    String getID();

    void setID(String value);

    String getPaymentMeansID();

    void setPaymentMeansID(String value);

    String getPrepaidPaymentReferenceID();

    void setPrepaidPaymentReferenceID(String value);

    List<String> getNote();

    void setNote(List<String> note);

    String getReferenceEventCode();

    void setReferenceEventCode(String value);

    BigDecimal getSettlementDiscountPercent();

    void setSettlementDiscountPercent(BigDecimal value);

    BigDecimal getPenaltySurchargePercent();

    void setPenaltySurchargePercent(BigDecimal value);

    BigDecimal getAmount();

    void setAmount(BigDecimal value);

    PeriodModel getSettlementPeriod();

    void setSettlementPeriod(PeriodModel value);

    PeriodModel getPenaltyPeriod();

    void setPenaltyPeriod(PeriodModel value);

    String getId();


}
