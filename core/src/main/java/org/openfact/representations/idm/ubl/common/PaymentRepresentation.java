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
import java.time.LocalTime;

public class PaymentRepresentation {
    private String idUbl;
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