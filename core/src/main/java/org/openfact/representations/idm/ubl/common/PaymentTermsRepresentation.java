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
import java.util.List;

public class PaymentTermsRepresentation {
    private String idUbl;
    private String paymentMeansID;
    private String prepaidPaymentReferenceID;
    private List<String> note;
    private String referenceEventCode;
    private BigDecimal settlementDiscountPercent;
    private BigDecimal penaltySurchargePercent;
    private BigDecimal amount;
    private PeriodRepresentation settlementPeriod;
    private PeriodRepresentation penaltyPeriod;
    private String id;

    public PeriodRepresentation getSettlementPeriod() {
        return this.settlementPeriod;
    }

    public void setSettlementPeriod(PeriodRepresentation settlementPeriod) {
        this.settlementPeriod = settlementPeriod;
    }

    public String getIdUbl() {
        return this.idUbl;
    }

    public void setIdUbl(String idUbl) {
        this.idUbl = idUbl;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPaymentMeansID() {
        return this.paymentMeansID;
    }

    public void setPaymentMeansID(String paymentMeansID) {
        this.paymentMeansID = paymentMeansID;
    }

    public String getReferenceEventCode() {
        return this.referenceEventCode;
    }

    public void setReferenceEventCode(String referenceEventCode) {
        this.referenceEventCode = referenceEventCode;
    }

    public PeriodRepresentation getPenaltyPeriod() {
        return this.penaltyPeriod;
    }

    public void setPenaltyPeriod(PeriodRepresentation penaltyPeriod) {
        this.penaltyPeriod = penaltyPeriod;
    }

    public String getPrepaidPaymentReferenceID() {
        return this.prepaidPaymentReferenceID;
    }

    public void setPrepaidPaymentReferenceID(String prepaidPaymentReferenceID) {
        this.prepaidPaymentReferenceID = prepaidPaymentReferenceID;
    }

    public List<String> getNote() {
        return this.note;
    }

    public void setNote(List<String> note) {
        this.note = note;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getSettlementDiscountPercent() {
        return this.settlementDiscountPercent;
    }

    public void setSettlementDiscountPercent(BigDecimal settlementDiscountPercent) {
        this.settlementDiscountPercent = settlementDiscountPercent;
    }

    public BigDecimal getPenaltySurchargePercent() {
        return this.penaltySurchargePercent;
    }

    public void setPenaltySurchargePercent(BigDecimal penaltySurchargePercent) {
        this.penaltySurchargePercent = penaltySurchargePercent;
    }
}