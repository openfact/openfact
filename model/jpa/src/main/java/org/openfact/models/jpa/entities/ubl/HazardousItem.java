package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

/**
 * A class to describe a hazardous item.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:29 a. m.
 */
public class HazardousItem {

	/**
	 * Text providing further information about the hazardous substance.
	 */
	private String additionalInformation;
	/**
	 * The name of the category of hazard that applies to the Item.
	 */
	private String categoryName;
	/**
	 * A code signifying the emergency procedures for this hazardous item.
	 */
	private String emergencyProceduresCode;
	/**
	 * An identifier for the hazard class applicable to this hazardous item as
	 * defined by the relevant regulation authority (e.g., the IMDG Class Number
	 * of the SOLAS Convention of IMO and the ADR/RID Class Number for the
	 * road/rail environment).
	 */
	private String hazardClassID;
	/**
	 * A code signifying a kind of hazard for a material.
	 */
	private String hazardousCategoryCode;
	/**
	 * An identifier for this hazardous item.
	 */
	private String ID;
	/**
	 * The number for the lower part of the orange hazard placard required on
	 * the means of transport.
	 */
	private String lowerOrangeHazardPlacardID;
	/**
	 * An identifier to the marking of the Hazardous Item
	 */
	private String markingID;
	/**
	 * A code signifying a medical first aid guide appropriate to this hazardous
	 * item.
	 */
	private String medicalFirstAidGuideCode;
	/**
	 * The volume of this hazardous item, excluding packaging and transport
	 * equipment.
	 */
	private BigDecimal netVolumeMeasure;
	/**
	 * The net weight of this hazardous item, excluding packaging.
	 */
	private BigDecimal netWeightMeasure;
	/**
	 * Text of the placard endorsement that is to be shown on the shipping
	 * papers for this hazardous item. Can also be used for the number of the
	 * orange placard (lower part) required on the means of transport.
	 */
	private String placardEndorsement;
	/**
	 * Text of the placard notation corresponding to the hazard class of this
	 * hazardous item. Can also be the hazard identification number of the
	 * orange placard (upper part) required on the means of transport.
	 */
	private String placardNotation;
	/**
	 * The quantity of goods items in this hazardous item that are hazardous.
	 */
	private BigDecimal quantity;
	/**
	 * The full technical name of a specific hazardous substance contained in
	 * this goods item.
	 */
	private String technicalName;
	/**
	 * The UN code for this kind of hazardous item.
	 */
	private String UNDGCode;
	/**
	 * The number for the upper part of the orange hazard placard required on
	 * the means of transport.
	 */
	private String upperOrangeHazardPlacardID;
	private HazardousGoodsTransit m_HazardousGoodsTransit;
	private Party ContactParty;
	private SecondaryHazard m_SecondaryHazard;
	private Temperature emergencyTemperature;
	private Temperature additionalTemperature;
	private Temperature flashpointTemperature;

	public String getAdditionalInformation() {
		return additionalInformation;
	}

	public void setAdditionalInformation(String additionalInformation) {
		this.additionalInformation = additionalInformation;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getEmergencyProceduresCode() {
		return emergencyProceduresCode;
	}

	public void setEmergencyProceduresCode(String emergencyProceduresCode) {
		this.emergencyProceduresCode = emergencyProceduresCode;
	}

	public String getHazardClassID() {
		return hazardClassID;
	}

	public void setHazardClassID(String hazardClassID) {
		this.hazardClassID = hazardClassID;
	}

	public String getHazardousCategoryCode() {
		return hazardousCategoryCode;
	}

	public void setHazardousCategoryCode(String hazardousCategoryCode) {
		this.hazardousCategoryCode = hazardousCategoryCode;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getLowerOrangeHazardPlacardID() {
		return lowerOrangeHazardPlacardID;
	}

	public void setLowerOrangeHazardPlacardID(String lowerOrangeHazardPlacardID) {
		this.lowerOrangeHazardPlacardID = lowerOrangeHazardPlacardID;
	}

	public String getMarkingID() {
		return markingID;
	}

	public void setMarkingID(String markingID) {
		this.markingID = markingID;
	}

	public String getMedicalFirstAidGuideCode() {
		return medicalFirstAidGuideCode;
	}

	public void setMedicalFirstAidGuideCode(String medicalFirstAidGuideCode) {
		this.medicalFirstAidGuideCode = medicalFirstAidGuideCode;
	}

	public BigDecimal getNetVolumeMeasure() {
		return netVolumeMeasure;
	}

	public void setNetVolumeMeasure(BigDecimal netVolumeMeasure) {
		this.netVolumeMeasure = netVolumeMeasure;
	}

	public BigDecimal getNetWeightMeasure() {
		return netWeightMeasure;
	}

	public void setNetWeightMeasure(BigDecimal netWeightMeasure) {
		this.netWeightMeasure = netWeightMeasure;
	}

	public String getPlacardEndorsement() {
		return placardEndorsement;
	}

	public void setPlacardEndorsement(String placardEndorsement) {
		this.placardEndorsement = placardEndorsement;
	}

	public String getPlacardNotation() {
		return placardNotation;
	}

	public void setPlacardNotation(String placardNotation) {
		this.placardNotation = placardNotation;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public String getTechnicalName() {
		return technicalName;
	}

	public void setTechnicalName(String technicalName) {
		this.technicalName = technicalName;
	}

	public String getUNDGCode() {
		return UNDGCode;
	}

	public void setUNDGCode(String UNDGCode) {
		this.UNDGCode = UNDGCode;
	}

	public String getUpperOrangeHazardPlacardID() {
		return upperOrangeHazardPlacardID;
	}

	public void setUpperOrangeHazardPlacardID(String upperOrangeHazardPlacardID) {
		this.upperOrangeHazardPlacardID = upperOrangeHazardPlacardID;
	}

	public HazardousGoodsTransit getM_HazardousGoodsTransit() {
		return m_HazardousGoodsTransit;
	}

	public void setM_HazardousGoodsTransit(HazardousGoodsTransit m_HazardousGoodsTransit) {
		this.m_HazardousGoodsTransit = m_HazardousGoodsTransit;
	}

	public Party getContactParty() {
		return ContactParty;
	}

	public void setContactParty(Party contactParty) {
		ContactParty = contactParty;
	}

	public SecondaryHazard getM_SecondaryHazard() {
		return m_SecondaryHazard;
	}

	public void setM_SecondaryHazard(SecondaryHazard m_SecondaryHazard) {
		this.m_SecondaryHazard = m_SecondaryHazard;
	}

	public Temperature getEmergencyTemperature() {
		return emergencyTemperature;
	}

	public void setEmergencyTemperature(Temperature emergencyTemperature) {
		this.emergencyTemperature = emergencyTemperature;
	}

	public Temperature getAdditionalTemperature() {
		return additionalTemperature;
	}

	public void setAdditionalTemperature(Temperature additionalTemperature) {
		this.additionalTemperature = additionalTemperature;
	}

	public Temperature getFlashpointTemperature() {
		return flashpointTemperature;
	}

	public void setFlashpointTemperature(Temperature flashpointTemperature) {
		this.flashpointTemperature = flashpointTemperature;
	}
}// end Hazardous Item