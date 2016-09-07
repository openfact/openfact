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
    private BigDecimal AdvertisementAmount;
    /**
     * The date on which this result was formalized.
     */
    private LocalDate AwardDate;
    /**
     * The time at which this result was formalized.
     */
    private LocalTime AwardTime;
    /**
     * Text describing the result of the tendering process.
     */
    private String Description;
    /**
     * The most expensive tender received in this tendering process.
     */
    private BigDecimal HigherTenderAmount;
    /**
     * The least expensive tender received in the tendering process.
     */
    private BigDecimal LowerTenderAmount;
    /**
     * The number of electronic tenders received.
     */
    private BigDecimal ReceivedElectronicTenderQuantity;
    /**
     * The number of foreing tenders received.
     */
    private BigDecimal ReceivedForeignTenderQuantity;
    /**
     * The total number of tenders received in this tendering process.
     */
    private BigDecimal ReceivedTenderQuantity;
    /**
     * The date on which the awarded contract begins.
     */
    private LocalDate StartDate;
    /**
     * A code signifying the result of the tendering process.
     */
    private String TenderResultCode;
    private List<Contract> contracts = new ArrayList<>();
    private Period ContractFormalizationPeriod;
    private List<SubcontractTerms> subcontractTerms = new ArrayList<>();
    private TenderedProject AwardedTenderedProject;
    private List<WinningParty> winningParties = new ArrayList<>();

    /**
     * @return the advertisementAmount
     */
    public BigDecimal getAdvertisementAmount() {
        return AdvertisementAmount;
    }

    /**
     * @param advertisementAmount
     *            the advertisementAmount to set
     */
    public void setAdvertisementAmount(BigDecimal advertisementAmount) {
        AdvertisementAmount = advertisementAmount;
    }

    /**
     * @return the awardDate
     */
    public LocalDate getAwardDate() {
        return AwardDate;
    }

    /**
     * @param awardDate
     *            the awardDate to set
     */
    public void setAwardDate(LocalDate awardDate) {
        AwardDate = awardDate;
    }

    /**
     * @return the awardTime
     */
    public LocalTime getAwardTime() {
        return AwardTime;
    }

    /**
     * @param awardTime
     *            the awardTime to set
     */
    public void setAwardTime(LocalTime awardTime) {
        AwardTime = awardTime;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return Description;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
        Description = description;
    }

    /**
     * @return the higherTenderAmount
     */
    public BigDecimal getHigherTenderAmount() {
        return HigherTenderAmount;
    }

    /**
     * @param higherTenderAmount
     *            the higherTenderAmount to set
     */
    public void setHigherTenderAmount(BigDecimal higherTenderAmount) {
        HigherTenderAmount = higherTenderAmount;
    }

    /**
     * @return the lowerTenderAmount
     */
    public BigDecimal getLowerTenderAmount() {
        return LowerTenderAmount;
    }

    /**
     * @param lowerTenderAmount
     *            the lowerTenderAmount to set
     */
    public void setLowerTenderAmount(BigDecimal lowerTenderAmount) {
        LowerTenderAmount = lowerTenderAmount;
    }

    /**
     * @return the receivedElectronicTenderQuantity
     */
    public BigDecimal getReceivedElectronicTenderQuantity() {
        return ReceivedElectronicTenderQuantity;
    }

    /**
     * @param receivedElectronicTenderQuantity
     *            the receivedElectronicTenderQuantity to set
     */
    public void setReceivedElectronicTenderQuantity(BigDecimal receivedElectronicTenderQuantity) {
        ReceivedElectronicTenderQuantity = receivedElectronicTenderQuantity;
    }

    /**
     * @return the receivedForeignTenderQuantity
     */
    public BigDecimal getReceivedForeignTenderQuantity() {
        return ReceivedForeignTenderQuantity;
    }

    /**
     * @param receivedForeignTenderQuantity
     *            the receivedForeignTenderQuantity to set
     */
    public void setReceivedForeignTenderQuantity(BigDecimal receivedForeignTenderQuantity) {
        ReceivedForeignTenderQuantity = receivedForeignTenderQuantity;
    }

    /**
     * @return the receivedTenderQuantity
     */
    public BigDecimal getReceivedTenderQuantity() {
        return ReceivedTenderQuantity;
    }

    /**
     * @param receivedTenderQuantity
     *            the receivedTenderQuantity to set
     */
    public void setReceivedTenderQuantity(BigDecimal receivedTenderQuantity) {
        ReceivedTenderQuantity = receivedTenderQuantity;
    }

    /**
     * @return the startDate
     */
    public LocalDate getStartDate() {
        return StartDate;
    }

    /**
     * @param startDate
     *            the startDate to set
     */
    public void setStartDate(LocalDate startDate) {
        StartDate = startDate;
    }

    /**
     * @return the tenderResultCode
     */
    public String getTenderResultCode() {
        return TenderResultCode;
    }

    /**
     * @param tenderResultCode
     *            the tenderResultCode to set
     */
    public void setTenderResultCode(String tenderResultCode) {
        TenderResultCode = tenderResultCode;
    }

    /**
     * @return the contracts
     */
    public List<Contract> getContracts() {
        return contracts;
    }

    /**
     * @param contracts
     *            the contracts to set
     */
    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    /**
     * @return the contractFormalizationPeriod
     */
    public Period getContractFormalizationPeriod() {
        return ContractFormalizationPeriod;
    }

    /**
     * @param contractFormalizationPeriod
     *            the contractFormalizationPeriod to set
     */
    public void setContractFormalizationPeriod(Period contractFormalizationPeriod) {
        ContractFormalizationPeriod = contractFormalizationPeriod;
    }

    /**
     * @return the subcontractTerms
     */
    public List<SubcontractTerms> getSubcontractTerms() {
        return subcontractTerms;
    }

    /**
     * @param subcontractTerms
     *            the subcontractTerms to set
     */
    public void setSubcontractTerms(List<SubcontractTerms> subcontractTerms) {
        this.subcontractTerms = subcontractTerms;
    }

    /**
     * @return the awardedTenderedProject
     */
    public TenderedProject getAwardedTenderedProject() {
        return AwardedTenderedProject;
    }

    /**
     * @param awardedTenderedProject
     *            the awardedTenderedProject to set
     */
    public void setAwardedTenderedProject(TenderedProject awardedTenderedProject) {
        AwardedTenderedProject = awardedTenderedProject;
    }

    /**
     * @return the winningParties
     */
    public List<WinningParty> getWinningParties() {
        return winningParties;
    }

    /**
     * @param winningParties
     *            the winningParties to set
     */
    public void setWinningParties(List<WinningParty> winningParties) {
        this.winningParties = winningParties;
    }

}// end TenderResult