package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * A class to describe a project to procure goods, works, or services.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:04 a. m.
 */
public class ProcurementProject {

	/**
	 * Text describing this procurement project.
	 */
	private String Description;
	/**
	 * The estimated overall quantity for this procurement project.
	 */
	private BigDecimal EstimatedOverallContractQuantity;
	/**
	 * Text describing the reimbursement fee for concession procurement
	 * projects.
	 */
	private String FeeDescription;
	/**
	 * An identifier for this procurement project.
	 */
	private String ID;
	/**
	 * A name of this procurement project.
	 */
	private String Name;
	/**
	 * Free-form text applying to the Procurement Project. This element may
	 * contain additional information about the lot/contract that is not
	 * contained explicitly in another structure.
	 */
	private String Note;
	/**
	 * A code signifying the subcategory of the type of work for this project
	 * (e.g., land surveying, IT consulting).
	 */
	private String ProcurementSubTypeCode;
	/**
	 * A code signifying the type of procurement project (e.g., goods, works,
	 * services).
	 */
	private String ProcurementTypeCode;
	/**
	 * The indication of whether or not the control quality is included in the
	 * works project.
	 */
	private String QualityControlCode;
	/**
	 * The requested delivery date for this procurement project.
	 */
	private LocalDate RequestedDeliveryDate;
	/**
	 * The amount of the reimbursement fee for concession procurement projects.
	 */
	private BigDecimal RequiredFeeAmount;
	private CommodityClassification AdditionalCommodityClassification;
	private CommodityClassification MainCommodityClassification;
	private ContractExtension m_ContractExtension;
	private Location RealizedLocation;
	private Period PlannedPeriod;
	private RequestedTenderTotal m_RequestedTenderTotal;
	private RequestForTenderLine m_RequestForTenderLine;

	public ProcurementProject() {

	}

	public void finalize() throws Throwable {

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
	 * @return the estimatedOverallContractQuantity
	 */
	public BigDecimal getEstimatedOverallContractQuantity() {
		return EstimatedOverallContractQuantity;
	}

	/**
	 * @param estimatedOverallContractQuantity
	 *            the estimatedOverallContractQuantity to set
	 */
	public void setEstimatedOverallContractQuantity(BigDecimal estimatedOverallContractQuantity) {
		EstimatedOverallContractQuantity = estimatedOverallContractQuantity;
	}

	/**
	 * @return the feeDescription
	 */
	public String getFeeDescription() {
		return FeeDescription;
	}

	/**
	 * @param feeDescription
	 *            the feeDescription to set
	 */
	public void setFeeDescription(String feeDescription) {
		FeeDescription = feeDescription;
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
	 * @return the name
	 */
	public String getName() {
		return Name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		Name = name;
	}

	/**
	 * @return the note
	 */
	public String getNote() {
		return Note;
	}

	/**
	 * @param note
	 *            the note to set
	 */
	public void setNote(String note) {
		Note = note;
	}

	/**
	 * @return the procurementSubTypeCode
	 */
	public String getProcurementSubTypeCode() {
		return ProcurementSubTypeCode;
	}

	/**
	 * @param procurementSubTypeCode
	 *            the procurementSubTypeCode to set
	 */
	public void setProcurementSubTypeCode(String procurementSubTypeCode) {
		ProcurementSubTypeCode = procurementSubTypeCode;
	}

	/**
	 * @return the procurementTypeCode
	 */
	public String getProcurementTypeCode() {
		return ProcurementTypeCode;
	}

	/**
	 * @param procurementTypeCode
	 *            the procurementTypeCode to set
	 */
	public void setProcurementTypeCode(String procurementTypeCode) {
		ProcurementTypeCode = procurementTypeCode;
	}

	/**
	 * @return the qualityControlCode
	 */
	public String getQualityControlCode() {
		return QualityControlCode;
	}

	/**
	 * @param qualityControlCode
	 *            the qualityControlCode to set
	 */
	public void setQualityControlCode(String qualityControlCode) {
		QualityControlCode = qualityControlCode;
	}

	/**
	 * @return the requestedDeliveryDate
	 */
	public LocalDate getRequestedDeliveryDate() {
		return RequestedDeliveryDate;
	}

	/**
	 * @param requestedDeliveryDate
	 *            the requestedDeliveryDate to set
	 */
	public void setRequestedDeliveryDate(LocalDate requestedDeliveryDate) {
		RequestedDeliveryDate = requestedDeliveryDate;
	}

	/**
	 * @return the requiredFeeAmount
	 */
	public BigDecimal getRequiredFeeAmount() {
		return RequiredFeeAmount;
	}

	/**
	 * @param requiredFeeAmount
	 *            the requiredFeeAmount to set
	 */
	public void setRequiredFeeAmount(BigDecimal requiredFeeAmount) {
		RequiredFeeAmount = requiredFeeAmount;
	}

	/**
	 * @return the additionalCommodityClassification
	 */
	public CommodityClassification getAdditionalCommodityClassification() {
		return AdditionalCommodityClassification;
	}

	/**
	 * @param additionalCommodityClassification
	 *            the additionalCommodityClassification to set
	 */
	public void setAdditionalCommodityClassification(CommodityClassification additionalCommodityClassification) {
		AdditionalCommodityClassification = additionalCommodityClassification;
	}

	/**
	 * @return the mainCommodityClassification
	 */
	public CommodityClassification getMainCommodityClassification() {
		return MainCommodityClassification;
	}

	/**
	 * @param mainCommodityClassification
	 *            the mainCommodityClassification to set
	 */
	public void setMainCommodityClassification(CommodityClassification mainCommodityClassification) {
		MainCommodityClassification = mainCommodityClassification;
	}

	/**
	 * @return the m_ContractExtension
	 */
	public ContractExtension getM_ContractExtension() {
		return m_ContractExtension;
	}

	/**
	 * @param m_ContractExtension
	 *            the m_ContractExtension to set
	 */
	public void setM_ContractExtension(ContractExtension m_ContractExtension) {
		this.m_ContractExtension = m_ContractExtension;
	}

	/**
	 * @return the realizedLocation
	 */
	public Location getRealizedLocation() {
		return RealizedLocation;
	}

	/**
	 * @param realizedLocation
	 *            the realizedLocation to set
	 */
	public void setRealizedLocation(Location realizedLocation) {
		RealizedLocation = realizedLocation;
	}

	/**
	 * @return the plannedPeriod
	 */
	public Period getPlannedPeriod() {
		return PlannedPeriod;
	}

	/**
	 * @param plannedPeriod
	 *            the plannedPeriod to set
	 */
	public void setPlannedPeriod(Period plannedPeriod) {
		PlannedPeriod = plannedPeriod;
	}

	/**
	 * @return the m_RequestedTenderTotal
	 */
	public RequestedTenderTotal getM_RequestedTenderTotal() {
		return m_RequestedTenderTotal;
	}

	/**
	 * @param m_RequestedTenderTotal
	 *            the m_RequestedTenderTotal to set
	 */
	public void setM_RequestedTenderTotal(RequestedTenderTotal m_RequestedTenderTotal) {
		this.m_RequestedTenderTotal = m_RequestedTenderTotal;
	}

	/**
	 * @return the m_RequestForTenderLine
	 */
	public RequestForTenderLine getM_RequestForTenderLine() {
		return m_RequestForTenderLine;
	}

	/**
	 * @param m_RequestForTenderLine
	 *            the m_RequestForTenderLine to set
	 */
	public void setM_RequestForTenderLine(RequestForTenderLine m_RequestForTenderLine) {
		this.m_RequestForTenderLine = m_RequestForTenderLine;
	}

}// end Procurement Project