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

import java.time.LocalDate;

public class CardAccountRepresentation {
    private String primaryAccountNumberID;
    private String networkID;
    private String cardRepresentationCode;
    private LocalDate validityStartDate;
    private LocalDate expiryDate;
    private String issuerID;
    private String issueNumberID;
    private String CV2ID;
    private String cardChipCode;
    private String chipApplicationID;
    private String holderName;
    private String id;

    public String getChipApplicationID() {
        return this.chipApplicationID;
    }

    public void setChipApplicationID(String chipApplicationID) {
        this.chipApplicationID = chipApplicationID;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCardChipCode() {
        return this.cardChipCode;
    }

    public void setCardChipCode(String cardChipCode) {
        this.cardChipCode = cardChipCode;
    }

    public String getIssuerID() {
        return this.issuerID;
    }

    public void setIssuerID(String issuerID) {
        this.issuerID = issuerID;
    }

    public String getIssueNumberID() {
        return this.issueNumberID;
    }

    public void setIssueNumberID(String issueNumberID) {
        this.issueNumberID = issueNumberID;
    }

    public String getCV2ID() {
        return this.CV2ID;
    }

    public void setCV2ID(String CV2ID) {
        this.CV2ID = CV2ID;
    }

    public LocalDate getExpiryDate() {
        return this.expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getNetworkID() {
        return this.networkID;
    }

    public void setNetworkID(String networkID) {
        this.networkID = networkID;
    }

    public String getCardRepresentationCode() {
        return this.cardRepresentationCode;
    }

    public void setCardRepresentationCode(String cardRepresentationCode) {
        this.cardRepresentationCode = cardRepresentationCode;
    }

    public LocalDate getValidityStartDate() {
        return this.validityStartDate;
    }

    public void setValidityStartDate(LocalDate validityStartDate) {
        this.validityStartDate = validityStartDate;
    }

    public String getPrimaryAccountNumberID() {
        return this.primaryAccountNumberID;
    }

    public void setPrimaryAccountNumberID(String primaryAccountNumberID) {
        this.primaryAccountNumberID = primaryAccountNumberID;
    }

    public String getHolderName() {
        return this.holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }
}