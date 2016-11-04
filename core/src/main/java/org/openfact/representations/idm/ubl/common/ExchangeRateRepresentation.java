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
package org.openfact.representations.idm.ubl.common;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ExchangeRateRepresentation {
    private String sourceCurrencyCode;
    private BigDecimal sourceCurrencyBaseRate;
    private String targetCurrencyCode;
    private BigDecimal targetCurrencyBaseRate;
    private String exchangeMarketID;
    private BigDecimal calculationRate;
    private String mathematicOperatorCode;
    private LocalDate date;
    private ContractRepresentation foreignExchangeContract;
    private String id;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getCalculationRate() {
        return this.calculationRate;
    }

    public void setCalculationRate(BigDecimal calculationRate) {
        this.calculationRate = calculationRate;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public ContractRepresentation getForeignExchangeContract() {
        return this.foreignExchangeContract;
    }

    public void setForeignExchangeContract(ContractRepresentation foreignExchangeContract) {
        this.foreignExchangeContract = foreignExchangeContract;
    }

    public String getMathematicOperatorCode() {
        return this.mathematicOperatorCode;
    }

    public void setMathematicOperatorCode(String mathematicOperatorCode) {
        this.mathematicOperatorCode = mathematicOperatorCode;
    }

    public BigDecimal getSourceCurrencyBaseRate() {
        return this.sourceCurrencyBaseRate;
    }

    public void setSourceCurrencyBaseRate(BigDecimal sourceCurrencyBaseRate) {
        this.sourceCurrencyBaseRate = sourceCurrencyBaseRate;
    }

    public String getExchangeMarketID() {
        return this.exchangeMarketID;
    }

    public void setExchangeMarketID(String exchangeMarketID) {
        this.exchangeMarketID = exchangeMarketID;
    }

    public String getTargetCurrencyCode() {
        return this.targetCurrencyCode;
    }

    public void setTargetCurrencyCode(String targetCurrencyCode) {
        this.targetCurrencyCode = targetCurrencyCode;
    }

    public String getSourceCurrencyCode() {
        return this.sourceCurrencyCode;
    }

    public void setSourceCurrencyCode(String sourceCurrencyCode) {
        this.sourceCurrencyCode = sourceCurrencyCode;
    }

    public BigDecimal getTargetCurrencyBaseRate() {
        return this.targetCurrencyBaseRate;
    }

    public void setTargetCurrencyBaseRate(BigDecimal targetCurrencyBaseRate) {
        this.targetCurrencyBaseRate = targetCurrencyBaseRate;
    }
}