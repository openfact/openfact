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