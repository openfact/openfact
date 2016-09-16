package org.openfact.representations.idm.ubl.common;

import java.math.BigDecimal;
import java.util.List;

public class PaymentTermsRepresentation {
    private String ID;
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

    public String getID() {
        return this.ID;
    }

    public void setID(String ID) {
        this.ID = ID;
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