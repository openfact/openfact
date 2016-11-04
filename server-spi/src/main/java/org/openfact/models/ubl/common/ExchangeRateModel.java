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
import java.time.LocalDate;

public interface ExchangeRateModel {

    String getSourceCurrencyCode();

    void setSourceCurrencyCode(String value);

    BigDecimal getSourceCurrencyBaseRate();

    void setSourceCurrencyBaseRate(BigDecimal value);

    String getTargetCurrencyCode();

    void setTargetCurrencyCode(String value);

    BigDecimal getTargetCurrencyBaseRate();

    void setTargetCurrencyBaseRate(BigDecimal value);

    String getExchangeMarketID();

    void setExchangeMarketID(String value);

    BigDecimal getCalculationRate();

    void setCalculationRate(BigDecimal value);

    String getMathematicOperatorCode();

    void setMathematicOperatorCode(String value);

    LocalDate getDate();

    void setDate(LocalDate value);

    ContractModel getForeignExchangeContract();

    void setForeignExchangeContract(ContractModel value);

    String getId();


}
