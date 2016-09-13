package org.openfact.models.ubl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A class to describe utility consumption, including details of the environment
 * in which consumption takes place.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:55 a. m.
 */
public class ConsumptionReportModel {

    /**
     * The basic quantity consumed, excluding additional consumption.
     */
    private QuantityModel basicConsumedQuantity;
    /**
     * The level of energy consumed, compared to the average for this residence
     * type and the number of people living in the residence, expressed as text.
     */
    private TextModel consumersEnergyLevel;
    /**
     * The level of energy consumed, compared to the average for this residence
     * type and the number of people living in the residence, expressed as a
     * code.
     */
    private CodeModel consumersEnergyLevelCode;
    /**
     * The type of consumption, expressed as text.
     */
    private TextModel consumptionType;
    /**
     * The type of consumption, expressed as a code.
     */
    private CodeModel consumptionTypeCode;
    /**
     * Text reporting utility consumption.
     */
    private TextModel description;
    /**
     * The type of heating in the residence covered in this report, expressed as
     * text.
     */
    private TextModel heatingType;
    /**
     * The type of heating in the residence covered in this report, expressed as
     * a code.
     */
    private CodeModel heatingTypeCode;
    /**
     * An identifier for this consumption report.
     */
    private IdentifierModel ID;
    /**
     * The type of residence (house, apartment, etc.) covered in this report,
     * expressed as text.
     */
    private TextModel residenceType;
    /**
     * The type of residence (house, apartment, etc.) covered in this report,
     * expressed as a code.
     */
    private CodeModel residenceTypeCode;
    /**
     * The number of people occupying the residence covered by this report.
     */
    private BigDecimal residentOccupantsNumeric;
    /**
     * The total quantity consumed.
     */
    private QuantityModel totalConsumedQuantity;
    private List<ConsumptionHistoryModel> consumptionHistories = new ArrayList<>();
    private List<ConsumptionReportModel> referenceConsumptionReportReferences = new ArrayList<>();
    private List<DocumentReferenceModel> guidanceDocumentReference = new ArrayList<>();
    private List<DocumentReferenceModel> documentReferences = new ArrayList<>();
    private List<PeriodModel> periods = new ArrayList<>();

}
