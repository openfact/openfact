package org.openfact.representations.idm.ubl.common;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class PaymentRepresentation {
    private String ID;
    private BigDecimal paidAmount;
    private LocalDate receivedDate;
    private LocalDate paidDate;
    private LocalTime paidTime;
    private String instructionID;
    private String id;

    public LocalDate getReceivedDate() {
        return this.receivedDate;
    }

    public void setReceivedDate(LocalDate receivedDate) {
        this.receivedDate = receivedDate;
    }

    public LocalDate getPaidDate() {
        return this.paidDate;
    }

    public void setPaidDate(LocalDate paidDate) {
        this.paidDate = paidDate;
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

    public String getInstructionID() {
        return this.instructionID;
    }

    public void setInstructionID(String instructionID) {
        this.instructionID = instructionID;
    }

    public LocalTime getPaidTime() {
        return this.paidTime;
    }

    public void setPaidTime(LocalTime paidTime) {
        this.paidTime = paidTime;
    }

    public BigDecimal getPaidAmount() {
        return this.paidAmount;
    }

    public void setPaidAmount(BigDecimal paidAmount) {
        this.paidAmount = paidAmount;
    }
}