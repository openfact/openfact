package org.openfact.representations.idm.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeType;
import org.openfact.representations.idm.ubl.type.QuantityType;
import org.openfact.representations.idm.ubl.type.TextType;

/**
 * A class to describe the awarding of a tender in a tendering process.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:19 a. m.
 */
public class TenderResultRepresentation {

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
    private TextType description;
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
    private QuantityType receivedElectronicTenderQuantity;
    /**
     * The number of foreing tenders received.
     */
    private QuantityType receivedForeignTenderQuantity;
    /**
     * The total number of tenders received in this tendering process.
     */
    private QuantityType receivedTenderQuantity;
    /**
     * The date on which the awarded contract begins.
     */
    private LocalDate startDate;
    /**
     * A code signifying the result of the tendering process.
     */
    private CodeType tenderResultCode;
    private List<ContractRepresentation> contracts = new ArrayList<>();
    private PeriodRepresentation contractFormalizationPeriod;
    private List<SubcontractTermsRepresentation> subcontractTermses = new ArrayList<>();
    private TenderedProjectRepresentation awardedTenderedProject;
    private List<WinningPartyRepresentation> winningParties = new ArrayList<>();

}
