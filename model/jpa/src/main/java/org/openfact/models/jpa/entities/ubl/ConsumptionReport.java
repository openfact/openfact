package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

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
	private BigDecimal basicConsumedQuantity;
	/**
	 * The level of energy consumed, compared to the average for this residence
	 * type and the number of people living in the residence, expressed as text.
	 */
	private String consumersEnergyLevel;
	/**
	 * The level of energy consumed, compared to the average for this residence
	 * type and the number of people living in the residence, expressed as a
	 * code.
	 */
	private String consumersEnergyLevelCode;
	/**
	 * The type of consumption, expressed as text.
	 */
	private String consumptionType;
	/**
	 * The type of consumption, expressed as a code.
	 */
	private String consumptionTypeCode;
	/**
	 * Text reporting utility consumption.
	 */
	private String dDescription;
	/**
	 * The type of heating in the residence covered in this report, expressed as
	 * text.
	 */
	private String heatingType;
	/**
	 * The type of heating in the residence covered in this report, expressed as
	 * a code.
	 */
	private String heatingTypeCode;
	/**
	 * An identifier for this consumption report.
	 */
	private String ID;
	/**
	 * The type of residence (house, apartment, etc.) covered in this report,
	 * expressed as text.
	 */
	private String residenceType;
	/**
	 * The type of residence (house, apartment, etc.) covered in this report,
	 * expressed as a code.
	 */
	private String residenceTypeCode;
	/**
	 * The number of people occupying the residence covered by this report.
	 */
	private BigDecimal residentOccupantsNumeric;
	/**
	 * The total quantity consumed.
	 */
	private BigDecimal totalConsumedQuantity;
	private List<ConsumptionHistory> consumptionHistories= new ArrayList<>();
	private List<ConsumptionReportReference> consumptionReportReferences= new ArrayList<>();
	private DocumentReference guidanceDocumentReference;
	private List<DocumentReference> documentReferences= new ArrayList<>();
	private List<Period> periods= new ArrayList<>();

	public ConsumptionReport() {

	}

	public void finalize() throws Throwable {

	}

	public BigDecimal getBasicConsumedQuantity() {
		return basicConsumedQuantity;
	}

	public void setBasicConsumedQuantity(BigDecimal basicConsumedQuantity) {
		this.basicConsumedQuantity = basicConsumedQuantity;
	}

	public String getConsumersEnergyLevel() {
		return consumersEnergyLevel;
	}

	public void setConsumersEnergyLevel(String consumersEnergyLevel) {
		this.consumersEnergyLevel = consumersEnergyLevel;
	}

	public String getConsumersEnergyLevelCode() {
		return consumersEnergyLevelCode;
	}

	public void setConsumersEnergyLevelCode(String consumersEnergyLevelCode) {
		this.consumersEnergyLevelCode = consumersEnergyLevelCode;
	}

	public String getConsumptionType() {
		return consumptionType;
	}

	public void setConsumptionType(String consumptionType) {
		this.consumptionType = consumptionType;
	}

	public String getConsumptionTypeCode() {
		return consumptionTypeCode;
	}

	public void setConsumptionTypeCode(String consumptionTypeCode) {
		this.consumptionTypeCode = consumptionTypeCode;
	}

	public String getdDescription() {
		return dDescription;
	}

	public void setdDescription(String dDescription) {
		this.dDescription = dDescription;
	}

	public String getHeatingType() {
		return heatingType;
	}

	public void setHeatingType(String heatingType) {
		this.heatingType = heatingType;
	}

	public String getHeatingTypeCode() {
		return heatingTypeCode;
	}

	public void setHeatingTypeCode(String heatingTypeCode) {
		this.heatingTypeCode = heatingTypeCode;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getResidenceType() {
		return residenceType;
	}

	public void setResidenceType(String residenceType) {
		this.residenceType = residenceType;
	}

	public String getResidenceTypeCode() {
		return residenceTypeCode;
	}

	public void setResidenceTypeCode(String residenceTypeCode) {
		this.residenceTypeCode = residenceTypeCode;
	}

	public BigDecimal getResidentOccupantsNumeric() {
		return residentOccupantsNumeric;
	}

	public void setResidentOccupantsNumeric(BigDecimal residentOccupantsNumeric) {
		this.residentOccupantsNumeric = residentOccupantsNumeric;
	}

	public BigDecimal getTotalConsumedQuantity() {
		return totalConsumedQuantity;
	}

	public void setTotalConsumedQuantity(BigDecimal totalConsumedQuantity) {
		this.totalConsumedQuantity = totalConsumedQuantity;
	}

	public List<ConsumptionHistory> getConsumptionHistories() {
		return consumptionHistories;
	}

	public void setConsumptionHistories(List<ConsumptionHistory> consumptionHistories) {
		this.consumptionHistories = consumptionHistories;
	}

	public List<ConsumptionReportReference> getConsumptionReportReferences() {
		return consumptionReportReferences;
	}

	public void setConsumptionReportReferences(List<ConsumptionReportReference> consumptionReportReferences) {
		this.consumptionReportReferences = consumptionReportReferences;
	}

	public DocumentReference getGuidanceDocumentReference() {
		return guidanceDocumentReference;
	}

	public void setGuidanceDocumentReference(DocumentReference guidanceDocumentReference) {
		this.guidanceDocumentReference = guidanceDocumentReference;
	}

	public List<DocumentReference> getDocumentReferences() {
		return documentReferences;
	}

	public void setDocumentReferences(List<DocumentReference> documentReferences) {
		this.documentReferences = documentReferences;
	}

	public List<Period> getPeriods() {
		return periods;
	}

	public void setPeriods(List<Period> periods) {
		this.periods = periods;
	}
}// end Consumption Report