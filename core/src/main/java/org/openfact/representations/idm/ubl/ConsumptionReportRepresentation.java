package org.openfact.representations.idm.ubl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.QuantityRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A class to describe utility consumption, including details of the environment
 * in which consumption takes place.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:55 a. m.
 */
public class ConsumptionReportRepresentation {

    /**
     * The basic quantity consumed, excluding additional consumption.
     */
    private QuantityRepresentation basicConsumedQuantity;
    /**
     * The level of energy consumed, compared to the average for this residence
     * type and the number of people living in the residence, expressed as text.
     */
    private TextRepresentation consumersEnergyLevel;
    /**
     * The level of energy consumed, compared to the average for this residence
     * type and the number of people living in the residence, expressed as a
     * code.
     */
    private CodeRepresentation consumersEnergyLevelCode;
    /**
     * The type of consumption, expressed as text.
     */
    private TextRepresentation consumptionType;
    /**
     * The type of consumption, expressed as a code.
     */
    private CodeRepresentation consumptionTypeCode;
    /**
     * Text reporting utility consumption.
     */
    private TextRepresentation description;
    /**
     * The type of heating in the residence covered in this report, expressed as
     * text.
     */
    private TextRepresentation heatingType;
    /**
     * The type of heating in the residence covered in this report, expressed as
     * a code.
     */
    private CodeRepresentation heatingTypeCode;
    /**
     * An identifier for this consumption report.
     */
    private IdentifierRepresentation ID;
    /**
     * The type of residence (house, apartment, etc.) covered in this report,
     * expressed as text.
     */
    private TextRepresentation residenceType;
    /**
     * The type of residence (house, apartment, etc.) covered in this report,
     * expressed as a code.
     */
    private CodeRepresentation residenceTypeCode;
    /**
     * The number of people occupying the residence covered by this report.
     */
    private BigDecimal residentOccupantsNumeric;
    /**
     * The total quantity consumed.
     */
    private QuantityRepresentation totalConsumedQuantity;
    private List<ConsumptionHistoryRepresentation> consumptionHistories = new ArrayList<>();
    private List<ConsumptionReportRepresentation> referenceConsumptionReportReferences = new ArrayList<>();
    private List<DocumentReferenceRepresentation> guidanceDocumentReference = new ArrayList<>();
    private List<DocumentReferenceRepresentation> documentReferences = new ArrayList<>();
    private List<PeriodRepresentation> periods = new ArrayList<>();

}
