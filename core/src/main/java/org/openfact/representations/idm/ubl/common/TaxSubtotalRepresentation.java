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

public class TaxSubtotalRepresentation {
    private BigDecimal taxableAmount;
    private BigDecimal taxAmount;
    private BigDecimal calculationSequenceNumeric;
    private BigDecimal transactionCurrencyTaxAmount;
    private BigDecimal percent;
    private MeasureRepresentation baseUnitMeasure;
    private BigDecimal perUnitAmount;
    private String tierRange;
    private BigDecimal tierRatePercent;
    private TaxCategoryRepresentation taxCategory;
    private String id;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getTaxAmount() {
        return this.taxAmount;
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }

    public BigDecimal getPercent() {
        return this.percent;
    }

    public void setPercent(BigDecimal percent) {
        this.percent = percent;
    }

    public BigDecimal getTaxableAmount() {
        return this.taxableAmount;
    }

    public void setTaxableAmount(BigDecimal taxableAmount) {
        this.taxableAmount = taxableAmount;
    }

    public MeasureRepresentation getBaseUnitMeasure() {
        return this.baseUnitMeasure;
    }

    public void setBaseUnitMeasure(MeasureRepresentation baseUnitMeasure) {
        this.baseUnitMeasure = baseUnitMeasure;
    }

    public BigDecimal getCalculationSequenceNumeric() {
        return this.calculationSequenceNumeric;
    }

    public void setCalculationSequenceNumeric(BigDecimal calculationSequenceNumeric) {
        this.calculationSequenceNumeric = calculationSequenceNumeric;
    }

    public BigDecimal getTransactionCurrencyTaxAmount() {
        return this.transactionCurrencyTaxAmount;
    }

    public void setTransactionCurrencyTaxAmount(BigDecimal transactionCurrencyTaxAmount) {
        this.transactionCurrencyTaxAmount = transactionCurrencyTaxAmount;
    }

    public BigDecimal getPerUnitAmount() {
        return this.perUnitAmount;
    }

    public void setPerUnitAmount(BigDecimal perUnitAmount) {
        this.perUnitAmount = perUnitAmount;
    }

    public TaxCategoryRepresentation getTaxCategory() {
        return this.taxCategory;
    }

    public void setTaxCategory(TaxCategoryRepresentation taxCategory) {
        this.taxCategory = taxCategory;
    }

    public BigDecimal getTierRatePercent() {
        return this.tierRatePercent;
    }

    public void setTierRatePercent(BigDecimal tierRatePercent) {
        this.tierRatePercent = tierRatePercent;
    }

    public String getTierRange() {
        return this.tierRange;
    }

    public void setTierRange(String tierRange) {
        this.tierRange = tierRange;
    }
}