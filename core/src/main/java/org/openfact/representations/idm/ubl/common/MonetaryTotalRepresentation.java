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

public class MonetaryTotalRepresentation {
    private BigDecimal lineExtensionAmount;
    private BigDecimal taxExclusiveAmount;
    private BigDecimal taxInclusiveAmount;
    private BigDecimal allowanceTotalAmount;
    private BigDecimal chargeTotalAmount;
    private BigDecimal prepaidAmount;
    private BigDecimal payableRoundingAmount;
    private BigDecimal payableAmount;
    private String id;

    public BigDecimal getAllowanceTotalAmount() {
        return this.allowanceTotalAmount;
    }

    public void setAllowanceTotalAmount(BigDecimal allowanceTotalAmount) {
        this.allowanceTotalAmount = allowanceTotalAmount;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getLineExtensionAmount() {
        return this.lineExtensionAmount;
    }

    public void setLineExtensionAmount(BigDecimal lineExtensionAmount) {
        this.lineExtensionAmount = lineExtensionAmount;
    }

    public BigDecimal getChargeTotalAmount() {
        return this.chargeTotalAmount;
    }

    public void setChargeTotalAmount(BigDecimal chargeTotalAmount) {
        this.chargeTotalAmount = chargeTotalAmount;
    }

    public BigDecimal getPayableAmount() {
        return this.payableAmount;
    }

    public void setPayableAmount(BigDecimal payableAmount) {
        this.payableAmount = payableAmount;
    }

    public BigDecimal getTaxExclusiveAmount() {
        return this.taxExclusiveAmount;
    }

    public void setTaxExclusiveAmount(BigDecimal taxExclusiveAmount) {
        this.taxExclusiveAmount = taxExclusiveAmount;
    }

    public BigDecimal getPayableRoundingAmount() {
        return this.payableRoundingAmount;
    }

    public void setPayableRoundingAmount(BigDecimal payableRoundingAmount) {
        this.payableRoundingAmount = payableRoundingAmount;
    }

    public BigDecimal getPrepaidAmount() {
        return this.prepaidAmount;
    }

    public void setPrepaidAmount(BigDecimal prepaidAmount) {
        this.prepaidAmount = prepaidAmount;
    }

    public BigDecimal getTaxInclusiveAmount() {
        return this.taxInclusiveAmount;
    }

    public void setTaxInclusiveAmount(BigDecimal taxInclusiveAmount) {
        this.taxInclusiveAmount = taxInclusiveAmount;
    }
}