package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A class to describe the awarding of a tender in a tendering process.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:19 a. m.
 */
public class TenderResult {

    /**
     * The monetary value of the advertisement for this tendering process.
     */
    private BigDecimal advertisementAmount;
    /**
     * The date on which this result was formalized.
     */
    private LocalDate awardDate;
    /**
     * The time at which this result was formalized.
     */
    private LocalTime awardTime;
    /**
     * Text describing the result of the tendering process.
     */
    private String description;
    /**
     * The most expensive tender received in this tendering process.
     */
    private BigDecimal higherTenderAmount;
    /**
     * The least expensive tender received in the tendering process.
     */
    private BigDecimal lowerTenderAmount;
    /**
     * The number of electronic tenders received.
     */
    private BigDecimal receivedElectronicTenderQuantity;
    /**
     * The number of foreing tenders received.
     */
    private BigDecimal receivedForeignTenderQuantity;
    /**
     * The total number of tenders received in this tendering process.
     */
    private BigDecimal receivedTenderQuantity;
    /**
     * The date on which the awarded contract begins.
     */
    private LocalDate startDate;
    /**
     * A code signifying the result of the tendering process.
     */
    private String tenderResultCode;
    private List<Contract> contracts = new ArrayList<>();
    private Period contractFormalizationPeriod;
    private List<SubcontractTerms> subcontractTerms = new ArrayList<>();
    private TenderedProject awardedTenderedProject;
    private List<WinningParty> winningParties = new ArrayList<>();

    public BigDecimal getAdvertisementAmount() {
        return advertisementAmount;
    }

    public void setAdvertisementAmount(BigDecimal advertisementAmount) {
        this.advertisementAmount = advertisementAmount;
    }

    public LocalDate getAwardDate() {
        return awardDate;
    }

    public void setAwardDate(LocalDate awardDate) {
        this.awardDate = awardDate;
    }

    public LocalTime getAwardTime() {
        return awardTime;
    }

    public void setAwardTime(LocalTime awardTime) {
        this.awardTime = awardTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getHigherTenderAmount() {
        return higherTenderAmount;
    }

    public void setHigherTenderAmount(BigDecimal higherTenderAmount) {
        this.higherTenderAmount = higherTenderAmount;
    }

    public BigDecimal getLowerTenderAmount() {
        return lowerTenderAmount;
    }

    public void setLowerTenderAmount(BigDecimal lowerTenderAmount) {
        this.lowerTenderAmount = lowerTenderAmount;
    }

    public BigDecimal getReceivedElectronicTenderQuantity() {
        return receivedElectronicTenderQuantity;
    }

    public void setReceivedElectronicTenderQuantity(BigDecimal receivedElectronicTenderQuantity) {
        this.receivedElectronicTenderQuantity = receivedElectronicTenderQuantity;
    }

    public BigDecimal getReceivedForeignTenderQuantity() {
        return receivedForeignTenderQuantity;
    }

    public void setReceivedForeignTenderQuantity(BigDecimal receivedForeignTenderQuantity) {
        this.receivedForeignTenderQuantity = receivedForeignTenderQuantity;
    }

    public BigDecimal getReceivedTenderQuantity() {
        return receivedTenderQuantity;
    }

    public void setReceivedTenderQuantity(BigDecimal receivedTenderQuantity) {
        this.receivedTenderQuantity = receivedTenderQuantity;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getTenderResultCode() {
        return tenderResultCode;
    }

    public void setTenderResultCode(String tenderResultCode) {
        this.tenderResultCode = tenderResultCode;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    public Period getContractFormalizationPeriod() {
        return contractFormalizationPeriod;
    }

    public void setContractFormalizationPeriod(Period contractFormalizationPeriod) {
        this.contractFormalizationPeriod = contractFormalizationPeriod;
    }

    public List<SubcontractTerms> getSubcontractTerms() {
        return subcontractTerms;
    }

    public void setSubcontractTerms(List<SubcontractTerms> subcontractTerms) {
        this.subcontractTerms = subcontractTerms;
    }

    public TenderedProject getAwardedTenderedProject() {
        return awardedTenderedProject;
    }

    public void setAwardedTenderedProject(TenderedProject awardedTenderedProject) {
        this.awardedTenderedProject = awardedTenderedProject;
    }

    public List<WinningParty> getWinningParties() {
        return winningParties;
    }

    public void setWinningParties(List<WinningParty> winningParties) {
        this.winningParties = winningParties;
    }
}// end TenderResult