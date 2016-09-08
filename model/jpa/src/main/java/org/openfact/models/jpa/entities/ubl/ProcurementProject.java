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
	private String description;
	/**
	 * The estimated overall quantity for this procurement project.
	 */
	private BigDecimal estimatedOverallContractQuantity;
	/**
	 * Text describing the reimbursement fee for concession procurement
	 * projects.
	 */
	private String feeDescription;
	/**
	 * An identifier for this procurement project.
	 */
	private String ID;
	/**
	 * A name of this procurement project.
	 */
	private String name;
	/**
	 * Free-form text applying to the Procurement Project. This element may
	 * contain additional information about the lot/contract that is not
	 * contained explicitly in another structure.
	 */
	private String note;
	/**
	 * A code signifying the subcategory of the type of work for this project
	 * (e.g., land surveying, IT consulting).
	 */
	private String procurementSubTypeCode;
	/**
	 * A code signifying the type of procurement project (e.g., goods, works,
	 * services).
	 */
	private String procurementTypeCode;
	/**
	 * The indication of whether or not the control quality is included in the
	 * works project.
	 */
	private String qualityControlCode;
	/**
	 * The requested delivery date for this procurement project.
	 */
	private LocalDate requestedDeliveryDate;
	/**
	 * The amount of the reimbursement fee for concession procurement projects.
	 */
	private BigDecimal requiredFeeAmount;
	private CommodityClassification additionalCommodityClassification;
	private CommodityClassification mainCommodityClassification;
	private List<ContractExtension> contractExtensions=new ArrayList<>();
	private Location realizedLocation;
	private Period plannedPeriod;
	private List<RequestedTenderTotal> requestedTenderTotals=new ArrayList<>();
	private List<RequestForTenderLine> requestForTenderLine=new ArrayList<>();

	public ProcurementProject() {

	}

	public void finalize() throws Throwable {

	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getEstimatedOverallContractQuantity() {
		return estimatedOverallContractQuantity;
	}

	public void setEstimatedOverallContractQuantity(BigDecimal estimatedOverallContractQuantity) {
		this.estimatedOverallContractQuantity = estimatedOverallContractQuantity;
	}

	public String getFeeDescription() {
		return feeDescription;
	}

	public void setFeeDescription(String feeDescription) {
		this.feeDescription = feeDescription;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getProcurementSubTypeCode() {
		return procurementSubTypeCode;
	}

	public void setProcurementSubTypeCode(String procurementSubTypeCode) {
		this.procurementSubTypeCode = procurementSubTypeCode;
	}

	public String getProcurementTypeCode() {
		return procurementTypeCode;
	}

	public void setProcurementTypeCode(String procurementTypeCode) {
		this.procurementTypeCode = procurementTypeCode;
	}

	public String getQualityControlCode() {
		return qualityControlCode;
	}

	public void setQualityControlCode(String qualityControlCode) {
		this.qualityControlCode = qualityControlCode;
	}

	public LocalDate getRequestedDeliveryDate() {
		return requestedDeliveryDate;
	}

	public void setRequestedDeliveryDate(LocalDate requestedDeliveryDate) {
		this.requestedDeliveryDate = requestedDeliveryDate;
	}

	public BigDecimal getRequiredFeeAmount() {
		return requiredFeeAmount;
	}

	public void setRequiredFeeAmount(BigDecimal requiredFeeAmount) {
		this.requiredFeeAmount = requiredFeeAmount;
	}

	public CommodityClassification getAdditionalCommodityClassification() {
		return additionalCommodityClassification;
	}

	public void setAdditionalCommodityClassification(CommodityClassification additionalCommodityClassification) {
		this.additionalCommodityClassification = additionalCommodityClassification;
	}

	public CommodityClassification getMainCommodityClassification() {
		return mainCommodityClassification;
	}

	public void setMainCommodityClassification(CommodityClassification mainCommodityClassification) {
		this.mainCommodityClassification = mainCommodityClassification;
	}

	public List<ContractExtension> getContractExtensions() {
		return contractExtensions;
	}

	public void setContractExtensions(List<ContractExtension> contractExtensions) {
		this.contractExtensions = contractExtensions;
	}

	public Location getRealizedLocation() {
		return realizedLocation;
	}

	public void setRealizedLocation(Location realizedLocation) {
		this.realizedLocation = realizedLocation;
	}

	public Period getPlannedPeriod() {
		return plannedPeriod;
	}

	public void setPlannedPeriod(Period plannedPeriod) {
		this.plannedPeriod = plannedPeriod;
	}

	public List<RequestedTenderTotal> getRequestedTenderTotals() {
		return requestedTenderTotals;
	}

	public void setRequestedTenderTotals(List<RequestedTenderTotal> requestedTenderTotals) {
		this.requestedTenderTotals = requestedTenderTotals;
	}

	public List<RequestForTenderLine> getRequestForTenderLine() {
		return requestForTenderLine;
	}

	public void setRequestForTenderLine(List<RequestForTenderLine> requestForTenderLine) {
		this.requestForTenderLine = requestForTenderLine;
	}
}// end Procurement Project