package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.AmountType;
import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.DateType;
import org.openfact.models.jpa.entities.ublType.QuantityType;
import org.openfact.models.jpa.entities.ublType.TextType;
import org.openfact.models.jpa.entities.ublType.TimeType;

/**
 * A class to describe the awarding of a tender in a tendering process.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:19 a. m.
 */
public class TenderResultEntity {

    /**
     * The monetary value of the advertisement for this tendering process.
     */
    private AmountType AdvertisementAmount;
    /**
     * The date on which this result was formalized.
     */
    private DateType AwardDate;
    /**
     * The time at which this result was formalized.
     */
    private TimeType AwardTime;
    /**
     * Text describing the result of the tendering process.
     */
    private TextType Description;
    /**
     * The most expensive tender received in this tendering process.
     */
    private AmountType HigherTenderAmount;
    /**
     * The least expensive tender received in the tendering process.
     */
    private AmountType LowerTenderAmount;
    /**
     * The number of electronic tenders received.
     */
    private QuantityType ReceivedElectronicTenderQuantity;
    /**
     * The number of foreing tenders received.
     */
    private QuantityType ReceivedForeignTenderQuantity;
    /**
     * The total number of tenders received in this tendering process.
     */
    private QuantityType ReceivedTenderQuantity;
    /**
     * The date on which the awarded contract begins.
     */
    private DateType StartDate;
    /**
     * A code signifying the result of the tendering process.
     */
    private CodeType TenderResultCode;
    private List<ContractEntity> Contracts = new ArrayList<>();
    private PeriodEntity ContractFormalizationPeriod;
    private List<SubcontractTermsEntity> SubcontractTermses = new ArrayList<>();
    private TenderedProjectEntity AwardedTenderedProject;
    private List<WinningPartyEntity> WinningParties = new ArrayList<>();

}
