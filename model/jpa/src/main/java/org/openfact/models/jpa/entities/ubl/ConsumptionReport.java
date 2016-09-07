package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;

/**
 * A class to describe utility consumption, including details of the environment
 * in which consumption takes place.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:55 a. m.
 */
public class ConsumptionReport {

    /**
     * The basic quantity consumed, excluding additional consumption.
     */
    private BigDecimal BasicConsumedQuantity;
    /**
     * The level of energy consumed, compared to the average for this residence
     * type and the number of people living in the residence, expressed as text.
     */
    private String ConsumersEnergyLevel;
    /**
     * The level of energy consumed, compared to the average for this residence
     * type and the number of people living in the residence, expressed as a
     * code.
     */
    private String ConsumersEnergyLevelCode;
    /**
     * The type of consumption, expressed as text.
     */
    private String ConsumptionType;
    /**
     * The type of consumption, expressed as a code.
     */
    private String ConsumptionTypeCode;
    /**
     * Text reporting utility consumption.
     */
    private String Description;
    /**
     * The type of heating in the residence covered in this report, expressed as
     * text.
     */
    private String HeatingType;
    /**
     * The type of heating in the residence covered in this report, expressed as
     * a code.
     */
    private String HeatingTypeCode;
    /**
     * An identifier for this consumption report.
     */
    private String ID;
    /**
     * The type of residence (house, apartment, etc.) covered in this report,
     * expressed as text.
     */
    private String ResidenceType;
    /**
     * The type of residence (house, apartment, etc.) covered in this report,
     * expressed as a code.
     */
    private String ResidenceTypeCode;
    /**
     * The number of people occupying the residence covered by this report.
     */
    private BigDecimal ResidentOccupantsNumeric;
    /**
     * The total quantity consumed.
     */
    private BigDecimal TotalConsumedQuantity;
    private ConsumptionHistory m_ConsumptionHistory;
    private ConsumptionReportReference m_ConsumptionReportReference;
    private DocumentReference GuidanceDocumentReference;
    private DocumentReference m_DocumentReference;
    private Period m_Period;

    public ConsumptionReport() {

    }

    public void finalize() throws Throwable {

    }

    /**
     * @return the basicConsumedQuantity
     */
    public BigDecimal getBasicConsumedQuantity() {
        return BasicConsumedQuantity;
    }

    /**
     * @param basicConsumedQuantity
     *            the basicConsumedQuantity to set
     */
    public void setBasicConsumedQuantity(BigDecimal basicConsumedQuantity) {
        BasicConsumedQuantity = basicConsumedQuantity;
    }

    /**
     * @return the consumersEnergyLevel
     */
    public String getConsumersEnergyLevel() {
        return ConsumersEnergyLevel;
    }

    /**
     * @param consumersEnergyLevel
     *            the consumersEnergyLevel to set
     */
    public void setConsumersEnergyLevel(String consumersEnergyLevel) {
        ConsumersEnergyLevel = consumersEnergyLevel;
    }

    /**
     * @return the consumersEnergyLevelCode
     */
    public String getConsumersEnergyLevelCode() {
        return ConsumersEnergyLevelCode;
    }

    /**
     * @param consumersEnergyLevelCode
     *            the consumersEnergyLevelCode to set
     */
    public void setConsumersEnergyLevelCode(String consumersEnergyLevelCode) {
        ConsumersEnergyLevelCode = consumersEnergyLevelCode;
    }

    /**
     * @return the consumptionType
     */
    public String getConsumptionType() {
        return ConsumptionType;
    }

    /**
     * @param consumptionType
     *            the consumptionType to set
     */
    public void setConsumptionType(String consumptionType) {
        ConsumptionType = consumptionType;
    }

    /**
     * @return the consumptionTypeCode
     */
    public String getConsumptionTypeCode() {
        return ConsumptionTypeCode;
    }

    /**
     * @param consumptionTypeCode
     *            the consumptionTypeCode to set
     */
    public void setConsumptionTypeCode(String consumptionTypeCode) {
        ConsumptionTypeCode = consumptionTypeCode;
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
     * @return the heatingType
     */
    public String getHeatingType() {
        return HeatingType;
    }

    /**
     * @param heatingType
     *            the heatingType to set
     */
    public void setHeatingType(String heatingType) {
        HeatingType = heatingType;
    }

    /**
     * @return the heatingTypeCode
     */
    public String getHeatingTypeCode() {
        return HeatingTypeCode;
    }

    /**
     * @param heatingTypeCode
     *            the heatingTypeCode to set
     */
    public void setHeatingTypeCode(String heatingTypeCode) {
        HeatingTypeCode = heatingTypeCode;
    }

    /**
     * @return the iD
     */
    public String getID() {
        return ID;
    }

    /**
     * @param iD
     *            the iD to set
     */
    public void setID(String iD) {
        ID = iD;
    }

    /**
     * @return the residenceType
     */
    public String getResidenceType() {
        return ResidenceType;
    }

    /**
     * @param residenceType
     *            the residenceType to set
     */
    public void setResidenceType(String residenceType) {
        ResidenceType = residenceType;
    }

    /**
     * @return the residenceTypeCode
     */
    public String getResidenceTypeCode() {
        return ResidenceTypeCode;
    }

    /**
     * @param residenceTypeCode
     *            the residenceTypeCode to set
     */
    public void setResidenceTypeCode(String residenceTypeCode) {
        ResidenceTypeCode = residenceTypeCode;
    }

    /**
     * @return the residentOccupantsNumeric
     */
    public BigDecimal getResidentOccupantsNumeric() {
        return ResidentOccupantsNumeric;
    }

    /**
     * @param residentOccupantsNumeric
     *            the residentOccupantsNumeric to set
     */
    public void setResidentOccupantsNumeric(BigDecimal residentOccupantsNumeric) {
        ResidentOccupantsNumeric = residentOccupantsNumeric;
    }

    /**
     * @return the totalConsumedQuantity
     */
    public BigDecimal getTotalConsumedQuantity() {
        return TotalConsumedQuantity;
    }

    /**
     * @param totalConsumedQuantity
     *            the totalConsumedQuantity to set
     */
    public void setTotalConsumedQuantity(BigDecimal totalConsumedQuantity) {
        TotalConsumedQuantity = totalConsumedQuantity;
    }

    /**
     * @return the m_ConsumptionHistory
     */
    public ConsumptionHistory getM_ConsumptionHistory() {
        return m_ConsumptionHistory;
    }

    /**
     * @param m_ConsumptionHistory
     *            the m_ConsumptionHistory to set
     */
    public void setM_ConsumptionHistory(ConsumptionHistory m_ConsumptionHistory) {
        this.m_ConsumptionHistory = m_ConsumptionHistory;
    }

    /**
     * @return the m_ConsumptionReportReference
     */
    public ConsumptionReportReference getM_ConsumptionReportReference() {
        return m_ConsumptionReportReference;
    }

    /**
     * @param m_ConsumptionReportReference
     *            the m_ConsumptionReportReference to set
     */
    public void setM_ConsumptionReportReference(ConsumptionReportReference m_ConsumptionReportReference) {
        this.m_ConsumptionReportReference = m_ConsumptionReportReference;
    }

    /**
     * @return the guidanceDocumentReference
     */
    public DocumentReference getGuidanceDocumentReference() {
        return GuidanceDocumentReference;
    }

    /**
     * @param guidanceDocumentReference
     *            the guidanceDocumentReference to set
     */
    public void setGuidanceDocumentReference(DocumentReference guidanceDocumentReference) {
        GuidanceDocumentReference = guidanceDocumentReference;
    }

    /**
     * @return the m_DocumentReference
     */
    public DocumentReference getM_DocumentReference() {
        return m_DocumentReference;
    }

    /**
     * @param m_DocumentReference
     *            the m_DocumentReference to set
     */
    public void setM_DocumentReference(DocumentReference m_DocumentReference) {
        this.m_DocumentReference = m_DocumentReference;
    }

    /**
     * @return the m_Period
     */
    public Period getM_Period() {
        return m_Period;
    }

    /**
     * @param m_Period
     *            the m_Period to set
     */
    public void setM_Period(Period m_Period) {
        this.m_Period = m_Period;
    }

}// end Consumption Report