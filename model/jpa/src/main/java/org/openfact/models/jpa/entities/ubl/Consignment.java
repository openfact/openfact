package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

/**
 * A class to describe an identifiable collection of one or more goods items to
 * be transported between the consignor and the consignee. This information may
 * be defined within a transport contract. A consignment may comprise more than
 * one shipment (e.g., when
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:44 a. m.
 */
public class Consignment {

	/**
	 * An indication that the transported goods in this consignment are animal
	 * foodstuffs (true) or not (false).
	 */
	private boolean animalFoodIndicator;
	/**
	 * An identifier for this consignment, assigned by the broker.
	 */
	private String brokerAssignedID;
	/**
	 * An indication that the transported goods in this consignment are bulk
	 * cargoes (true) or not (false).
	 */
	private boolean bulkCargoIndicator;
	/**
	 * An identifier for this consignment, assigned by the carrier.
	 */
	private String carrierAssignedID;
	/**
	 * Service instructions to the carrier, expressed as text.
	 */
	private String carrierServiceInstructions;
	/**
	 * The weight upon which a charge is to be based.
	 */
	private BigDecimal chargeableWeightMeasure;
	/**
	 * The quantity of (consolidated) child consignments
	 */
	private BigDecimal childConsignmentQuantity;
	/**
	 * An identifier for this consignment, assigned by the consignee.
	 */
	private String consigneeAssignedID;
	/**
	 * The count in this consignment considering goods items, child
	 * consignments, shipments
	 */
	private BigDecimal consignmentQuantity;
	/**
	 * An identifier for this consignment, assigned by the consignor.
	 */
	private String consignorAssignedID;
	/**
	 * An indicator that this consignment can be consolidated (true) or not
	 * (false).
	 */
	private boolean consolidatableIndicator;
	/**
	 * An indication that the transported goods in this consignment are
	 * containerized cargoes (true) or not (false).
	 */
	private boolean containerizedIndicator;
	/**
	 * An identifier for this consignment, assigned by the contracted carrier.
	 */
	private String contractedCarrierAssignedID;
	/**
	 * Service instructions for customs clearance, expressed as text.
	 */
	private String customsClearanceServiceInstructions;
	/**
	 * The total declared value for customs purposes of all the goods in this
	 * consignment, regardless of whether they are subject to the same customs
	 * procedure, tariff/statistical categorization, country information, or
	 * duty regime.
	 */
	private BigDecimal declaredCustomsValueAmount;
	/**
	 * The value of this consignment, declared by the shipper or his agent
	 * solely for the purpose of varying the carrier's level of liability from
	 * that provided in the contract of carriage, in case of loss or damage to
	 * goods or delayed delivery.
	 */
	private BigDecimal declaredForCarriageValueAmount;
	/**
	 * The value, declared for statistical purposes, of those goods in this
	 * consignment that have the same statistical heading.
	 */
	private BigDecimal declaredStatisticsValueAmount;
	/**
	 * A set of delivery instructions relating to this consignment.
	 */
	private String deliveryInstructions;
	/**
	 * Service instructions for the forwarder, expressed as text.
	 */
	private String forwarderServiceInstructions;
	/**
	 * The monetary amount that has to be or has been paid as calculated under
	 * the applicable trade delivery.
	 */
	private BigDecimal freeOnBoardValueAmount;
	/**
	 * An identifier for this consignment, assigned by the freight forwarder.
	 */
	private String freightForwarderAssignedID;
	/**
	 * An indication that the transported goods in this consignment are general
	 * cargoes (true) or not (false).
	 */
	private boolean generalCargoIndicator;
	/**
	 * The total volume of the goods referred to as one consignment.
	 */
	private BigDecimal grossVolumeMeasure;
	/**
	 * The total declared weight of the goods in this consignment, including
	 * packaging but excluding the carrier's equipment.
	 */
	private BigDecimal grossWeightMeasure;
	/**
	 * The handling required for this consignment, expressed as a code.
	 */
	private String handlingCode;
	/**
	 * The handling required for this consignment, expressed as text.
	 */
	private String gandlingInstructions;
	/**
	 * Instructions regarding haulage of this consignment, expressed as text.
	 */
	private String gaulageInstructions;
	/**
	 * An indication that the transported goods in this consignment are subject
	 * to an international regulation concerning the carriage of dangerous goods
	 * (true) or not (false).
	 */
	private boolean hazardousRiskIndicator;
	/**
	 * An indication that the transported goods in this consignment are for
	 * human consumption (true) or not (false).
	 */
	private boolean humanFoodIndicator;
	/**
	 * An identifier assigned to a collection of goods for both import and
	 * export.
	 */
	private String ID;
	/**
	 * Free-form text pertinent to this consignment, conveying information that
	 * is not contained explicitly in other structures.
	 */
	private String information;
	/**
	 * The amount of the premium payable to an insurance company for insuring
	 * the goods contained in this consignment.
	 */
	private BigDecimal insurancePremiumAmount;
	/**
	 * The amount covered by insurance for this consignment.
	 */
	private BigDecimal insuranceValueAmount;
	/**
	 * An indication that the transported goods are livestock (true) or not
	 * (false).
	 */
	private boolean livestockIndicator;
	/**
	 * The total length in a means of transport or a piece of transport
	 * equipment which, given the width and height of the transport means, will
	 * accommodate all of the consignments in a single consolidation.
	 */
	private BigDecimal loadingLengthMeasure;
	/**
	 * An identifier for the loading sequence of this consignment.
	 */
	private String loadingSequenceID;
	/**
	 * The total net weight of the goods in this consignment, exclusive of
	 * packaging.
	 */
	private BigDecimal netNetWeightMeasure;
	/**
	 * The total net volume of all goods items referred to as one consignment.
	 */
	private BigDecimal netVolumeMeasure;
	/**
	 * The total net weight of all the goods items referred to as one
	 * consignment.
	 */
	private BigDecimal netWeightMeasure;
	/**
	 * An identifier for this consignment, assigned by the performing carrier.
	 */
	private String performingCarrierAssignedID;
	/**
	 * Remarks concerning the complete consignment, to be printed on the
	 * transport document.
	 */
	private String remarks;
	/**
	 * A sequence identifier for this consignment.
	 */
	private String sequenceID;
	/**
	 * A code signifying the priority or level of service required for this
	 * consignment.
	 */
	private String shippingPriorityLevelCode;
	/**
	 * Special instructions relating to this consignment.
	 */
	private String specialInstructions;
	/**
	 * An indication that the transported goods in this consignment require
	 * special security (true) or not (false).
	 */
	private boolean specialSecurityIndicator;
	/**
	 * Special service instructions, expressed as text.
	 */
	private String specialServiceInstructions;
	/**
	 * An indicator that this consignment has been split in transit (true) or
	 * not (false).
	 */
	private boolean splitConsignmentIndicator;
	/**
	 * A textual summary description of the consignment.
	 */
	private String summaryDescription;
	/**
	 * A code signifying the tariff applied to this consignment.
	 */
	private String tariffCode;
	/**
	 * Text describing the tariff applied to this consignment.
	 */
	private String tariffDescription;
	/**
	 * An indication that this consignment will be paid for by a third party
	 * (true) or not (false).
	 */
	private boolean thirdPartyPayerIndicator;
	/**
	 * The total number of goods items in this consignment.
	 */
	private BigDecimal totalGoodsItemQuantity;
	/**
	 * The total of all invoice amounts declared in this consignment.
	 */
	private BigDecimal totalInvoiceAmount;
	/**
	 * The total number of packages associated with a Consignment.
	 */
	private BigDecimal totalPackagesQuantity;
	/**
	 * The number of pieces of transport handling equipment (pallets, boxes,
	 * cases, etc.) in this consignment.
	 */
	private BigDecimal totalTransportHandlingUnitQuantity;
	private AllowanceCharge extraAllowanceCharge;
	private AllowanceCharge freightAllowanceCharge;
	private Contract transportContract;
	private Country originalDepartureCountry;
	private Country finalDestinationCountry;
	private Country transitCountry;
	private List<CustomsDeclaration> customsDeclarations= new ArrayList<>();
	private List<DeliveryTerms> deliveryTermss= new ArrayList<>();
	private Location firstArrivalPortLocation;
	private Location lastExitPortLocation;
	private Party billOfLadingHolderParty;
	private Party freightForwarderParty;
	private Party insuranceParty;
	private Party originalDespatchParty;
	private Party notifyParty;
	private Party carrierParty;
	private Party importerParty;
	private Party consignorParty;
	private Party exporterParty;
	private Party consigneeParty;
	private Consignment childConsignment;
	private Party logisticsOperatorParty;
	private Party mortgageHolderParty;
	private Party hazardousItemNotificationParty;
	private Party transportAdvisorParty;
	private Party substituteCarrierParty;
	private Party performingCarrierParty;
	private Party finalDeliveryParty;
	private PaymentTerms collectPaymentTerms;
	private PaymentTerms disbursementPaymentTerms;
	private PaymentTerms prepaidPaymentTerms;
	private List<PaymentTerms> paymentTermss= new ArrayList<>();
	private Shipment consolidatedShipment;
	private ShipmentStage onCarriageShipmentStage;
	private ShipmentStage preCarriageShipmentStage;
	private ShipmentStage mainCarriageShipmentStage;
	private List<TransportEvent> transportEvents= new ArrayList<>();
	private List<TransportHandlingUnit> transportHandlingUnits= new ArrayList<>();
	private TransportationService originalDespatchTransportationService;
	private TransportationService finalDeliveryTransportationService;
	private List<Status> statuss= new ArrayList<>();
	private TransportEvent requestedPickupTransportEvent;
	private TransportEvent requestedDeliveryTransportEvent;
	private TransportEvent plannedPickupTransportEvent;
	private TransportEvent plannedDeliveryTransportEvent;

	public Consignment() {

	}

	public void finalize() throws Throwable {

	}

	public boolean isAnimalFoodIndicator() {
		return animalFoodIndicator;
	}

	public void setAnimalFoodIndicator(boolean animalFoodIndicator) {
		this.animalFoodIndicator = animalFoodIndicator;
	}

	public String getBrokerAssignedID() {
		return brokerAssignedID;
	}

	public void setBrokerAssignedID(String brokerAssignedID) {
		this.brokerAssignedID = brokerAssignedID;
	}

	public boolean isBulkCargoIndicator() {
		return bulkCargoIndicator;
	}

	public void setBulkCargoIndicator(boolean bulkCargoIndicator) {
		this.bulkCargoIndicator = bulkCargoIndicator;
	}

	public String getCarrierAssignedID() {
		return carrierAssignedID;
	}

	public void setCarrierAssignedID(String carrierAssignedID) {
		this.carrierAssignedID = carrierAssignedID;
	}

	public String getCarrierServiceInstructions() {
		return carrierServiceInstructions;
	}

	public void setCarrierServiceInstructions(String carrierServiceInstructions) {
		this.carrierServiceInstructions = carrierServiceInstructions;
	}

	public BigDecimal getChargeableWeightMeasure() {
		return chargeableWeightMeasure;
	}

	public void setChargeableWeightMeasure(BigDecimal chargeableWeightMeasure) {
		this.chargeableWeightMeasure = chargeableWeightMeasure;
	}

	public BigDecimal getChildConsignmentQuantity() {
		return childConsignmentQuantity;
	}

	public void setChildConsignmentQuantity(BigDecimal childConsignmentQuantity) {
		this.childConsignmentQuantity = childConsignmentQuantity;
	}

	public String getConsigneeAssignedID() {
		return consigneeAssignedID;
	}

	public void setConsigneeAssignedID(String consigneeAssignedID) {
		this.consigneeAssignedID = consigneeAssignedID;
	}

	public BigDecimal getConsignmentQuantity() {
		return consignmentQuantity;
	}

	public void setConsignmentQuantity(BigDecimal consignmentQuantity) {
		this.consignmentQuantity = consignmentQuantity;
	}

	public String getConsignorAssignedID() {
		return consignorAssignedID;
	}

	public void setConsignorAssignedID(String consignorAssignedID) {
		this.consignorAssignedID = consignorAssignedID;
	}

	public boolean isConsolidatableIndicator() {
		return consolidatableIndicator;
	}

	public void setConsolidatableIndicator(boolean consolidatableIndicator) {
		this.consolidatableIndicator = consolidatableIndicator;
	}

	public boolean isContainerizedIndicator() {
		return containerizedIndicator;
	}

	public void setContainerizedIndicator(boolean containerizedIndicator) {
		this.containerizedIndicator = containerizedIndicator;
	}

	public String getContractedCarrierAssignedID() {
		return contractedCarrierAssignedID;
	}

	public void setContractedCarrierAssignedID(String contractedCarrierAssignedID) {
		this.contractedCarrierAssignedID = contractedCarrierAssignedID;
	}

	public String getCustomsClearanceServiceInstructions() {
		return customsClearanceServiceInstructions;
	}

	public void setCustomsClearanceServiceInstructions(String customsClearanceServiceInstructions) {
		this.customsClearanceServiceInstructions = customsClearanceServiceInstructions;
	}

	public BigDecimal getDeclaredCustomsValueAmount() {
		return declaredCustomsValueAmount;
	}

	public void setDeclaredCustomsValueAmount(BigDecimal declaredCustomsValueAmount) {
		this.declaredCustomsValueAmount = declaredCustomsValueAmount;
	}

	public BigDecimal getDeclaredForCarriageValueAmount() {
		return declaredForCarriageValueAmount;
	}

	public void setDeclaredForCarriageValueAmount(BigDecimal declaredForCarriageValueAmount) {
		this.declaredForCarriageValueAmount = declaredForCarriageValueAmount;
	}

	public BigDecimal getDeclaredStatisticsValueAmount() {
		return declaredStatisticsValueAmount;
	}

	public void setDeclaredStatisticsValueAmount(BigDecimal declaredStatisticsValueAmount) {
		this.declaredStatisticsValueAmount = declaredStatisticsValueAmount;
	}

	public String getDeliveryInstructions() {
		return deliveryInstructions;
	}

	public void setDeliveryInstructions(String deliveryInstructions) {
		this.deliveryInstructions = deliveryInstructions;
	}

	public String getForwarderServiceInstructions() {
		return forwarderServiceInstructions;
	}

	public void setForwarderServiceInstructions(String forwarderServiceInstructions) {
		this.forwarderServiceInstructions = forwarderServiceInstructions;
	}

	public BigDecimal getFreeOnBoardValueAmount() {
		return freeOnBoardValueAmount;
	}

	public void setFreeOnBoardValueAmount(BigDecimal freeOnBoardValueAmount) {
		this.freeOnBoardValueAmount = freeOnBoardValueAmount;
	}

	public String getFreightForwarderAssignedID() {
		return freightForwarderAssignedID;
	}

	public void setFreightForwarderAssignedID(String freightForwarderAssignedID) {
		this.freightForwarderAssignedID = freightForwarderAssignedID;
	}

	public boolean isGeneralCargoIndicator() {
		return generalCargoIndicator;
	}

	public void setGeneralCargoIndicator(boolean generalCargoIndicator) {
		this.generalCargoIndicator = generalCargoIndicator;
	}

	public BigDecimal getGrossVolumeMeasure() {
		return grossVolumeMeasure;
	}

	public void setGrossVolumeMeasure(BigDecimal grossVolumeMeasure) {
		this.grossVolumeMeasure = grossVolumeMeasure;
	}

	public BigDecimal getGrossWeightMeasure() {
		return grossWeightMeasure;
	}

	public void setGrossWeightMeasure(BigDecimal grossWeightMeasure) {
		this.grossWeightMeasure = grossWeightMeasure;
	}

	public String getHandlingCode() {
		return handlingCode;
	}

	public void setHandlingCode(String handlingCode) {
		this.handlingCode = handlingCode;
	}

	public String getGandlingInstructions() {
		return gandlingInstructions;
	}

	public void setGandlingInstructions(String gandlingInstructions) {
		this.gandlingInstructions = gandlingInstructions;
	}

	public String getGaulageInstructions() {
		return gaulageInstructions;
	}

	public void setGaulageInstructions(String gaulageInstructions) {
		this.gaulageInstructions = gaulageInstructions;
	}

	public boolean isHazardousRiskIndicator() {
		return hazardousRiskIndicator;
	}

	public void setHazardousRiskIndicator(boolean hazardousRiskIndicator) {
		this.hazardousRiskIndicator = hazardousRiskIndicator;
	}

	public boolean isHumanFoodIndicator() {
		return humanFoodIndicator;
	}

	public void setHumanFoodIndicator(boolean humanFoodIndicator) {
		this.humanFoodIndicator = humanFoodIndicator;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public BigDecimal getInsurancePremiumAmount() {
		return insurancePremiumAmount;
	}

	public void setInsurancePremiumAmount(BigDecimal insurancePremiumAmount) {
		this.insurancePremiumAmount = insurancePremiumAmount;
	}

	public BigDecimal getInsuranceValueAmount() {
		return insuranceValueAmount;
	}

	public void setInsuranceValueAmount(BigDecimal insuranceValueAmount) {
		this.insuranceValueAmount = insuranceValueAmount;
	}

	public boolean isLivestockIndicator() {
		return livestockIndicator;
	}

	public void setLivestockIndicator(boolean livestockIndicator) {
		this.livestockIndicator = livestockIndicator;
	}

	public BigDecimal getLoadingLengthMeasure() {
		return loadingLengthMeasure;
	}

	public void setLoadingLengthMeasure(BigDecimal loadingLengthMeasure) {
		this.loadingLengthMeasure = loadingLengthMeasure;
	}

	public String getLoadingSequenceID() {
		return loadingSequenceID;
	}

	public void setLoadingSequenceID(String loadingSequenceID) {
		this.loadingSequenceID = loadingSequenceID;
	}

	public BigDecimal getNetNetWeightMeasure() {
		return netNetWeightMeasure;
	}

	public void setNetNetWeightMeasure(BigDecimal netNetWeightMeasure) {
		this.netNetWeightMeasure = netNetWeightMeasure;
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

	public String getPerformingCarrierAssignedID() {
		return performingCarrierAssignedID;
	}

	public void setPerformingCarrierAssignedID(String performingCarrierAssignedID) {
		this.performingCarrierAssignedID = performingCarrierAssignedID;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getSequenceID() {
		return sequenceID;
	}

	public void setSequenceID(String sequenceID) {
		this.sequenceID = sequenceID;
	}

	public String getShippingPriorityLevelCode() {
		return shippingPriorityLevelCode;
	}

	public void setShippingPriorityLevelCode(String shippingPriorityLevelCode) {
		this.shippingPriorityLevelCode = shippingPriorityLevelCode;
	}

	public String getSpecialInstructions() {
		return specialInstructions;
	}

	public void setSpecialInstructions(String specialInstructions) {
		this.specialInstructions = specialInstructions;
	}

	public boolean isSpecialSecurityIndicator() {
		return specialSecurityIndicator;
	}

	public void setSpecialSecurityIndicator(boolean specialSecurityIndicator) {
		this.specialSecurityIndicator = specialSecurityIndicator;
	}

	public String getSpecialServiceInstructions() {
		return specialServiceInstructions;
	}

	public void setSpecialServiceInstructions(String specialServiceInstructions) {
		this.specialServiceInstructions = specialServiceInstructions;
	}

	public boolean isSplitConsignmentIndicator() {
		return splitConsignmentIndicator;
	}

	public void setSplitConsignmentIndicator(boolean splitConsignmentIndicator) {
		this.splitConsignmentIndicator = splitConsignmentIndicator;
	}

	public String getSummaryDescription() {
		return summaryDescription;
	}

	public void setSummaryDescription(String summaryDescription) {
		this.summaryDescription = summaryDescription;
	}

	public String getTariffCode() {
		return tariffCode;
	}

	public void setTariffCode(String tariffCode) {
		this.tariffCode = tariffCode;
	}

	public String getTariffDescription() {
		return tariffDescription;
	}

	public void setTariffDescription(String tariffDescription) {
		this.tariffDescription = tariffDescription;
	}

	public boolean isThirdPartyPayerIndicator() {
		return thirdPartyPayerIndicator;
	}

	public void setThirdPartyPayerIndicator(boolean thirdPartyPayerIndicator) {
		this.thirdPartyPayerIndicator = thirdPartyPayerIndicator;
	}

	public BigDecimal getTotalGoodsItemQuantity() {
		return totalGoodsItemQuantity;
	}

	public void setTotalGoodsItemQuantity(BigDecimal totalGoodsItemQuantity) {
		this.totalGoodsItemQuantity = totalGoodsItemQuantity;
	}

	public BigDecimal getTotalInvoiceAmount() {
		return totalInvoiceAmount;
	}

	public void setTotalInvoiceAmount(BigDecimal totalInvoiceAmount) {
		this.totalInvoiceAmount = totalInvoiceAmount;
	}

	public BigDecimal getTotalPackagesQuantity() {
		return totalPackagesQuantity;
	}

	public void setTotalPackagesQuantity(BigDecimal totalPackagesQuantity) {
		this.totalPackagesQuantity = totalPackagesQuantity;
	}

	public BigDecimal getTotalTransportHandlingUnitQuantity() {
		return totalTransportHandlingUnitQuantity;
	}

	public void setTotalTransportHandlingUnitQuantity(BigDecimal totalTransportHandlingUnitQuantity) {
		this.totalTransportHandlingUnitQuantity = totalTransportHandlingUnitQuantity;
	}

	public AllowanceCharge getExtraAllowanceCharge() {
		return extraAllowanceCharge;
	}

	public void setExtraAllowanceCharge(AllowanceCharge extraAllowanceCharge) {
		this.extraAllowanceCharge = extraAllowanceCharge;
	}

	public AllowanceCharge getFreightAllowanceCharge() {
		return freightAllowanceCharge;
	}

	public void setFreightAllowanceCharge(AllowanceCharge freightAllowanceCharge) {
		this.freightAllowanceCharge = freightAllowanceCharge;
	}

	public Contract getTransportContract() {
		return transportContract;
	}

	public void setTransportContract(Contract transportContract) {
		this.transportContract = transportContract;
	}

	public Country getOriginalDepartureCountry() {
		return originalDepartureCountry;
	}

	public void setOriginalDepartureCountry(Country originalDepartureCountry) {
		this.originalDepartureCountry = originalDepartureCountry;
	}

	public Country getFinalDestinationCountry() {
		return finalDestinationCountry;
	}

	public void setFinalDestinationCountry(Country finalDestinationCountry) {
		this.finalDestinationCountry = finalDestinationCountry;
	}

	public Country getTransitCountry() {
		return transitCountry;
	}

	public void setTransitCountry(Country transitCountry) {
		this.transitCountry = transitCountry;
	}

	public List<CustomsDeclaration> getCustomsDeclarations() {
		return customsDeclarations;
	}

	public void setCustomsDeclarations(List<CustomsDeclaration> customsDeclarations) {
		this.customsDeclarations = customsDeclarations;
	}

	public List<DeliveryTerms> getDeliveryTermss() {
		return deliveryTermss;
	}

	public void setDeliveryTermss(List<DeliveryTerms> deliveryTermss) {
		this.deliveryTermss = deliveryTermss;
	}

	public Location getFirstArrivalPortLocation() {
		return firstArrivalPortLocation;
	}

	public void setFirstArrivalPortLocation(Location firstArrivalPortLocation) {
		this.firstArrivalPortLocation = firstArrivalPortLocation;
	}

	public Location getLastExitPortLocation() {
		return lastExitPortLocation;
	}

	public void setLastExitPortLocation(Location lastExitPortLocation) {
		this.lastExitPortLocation = lastExitPortLocation;
	}

	public Party getBillOfLadingHolderParty() {
		return billOfLadingHolderParty;
	}

	public void setBillOfLadingHolderParty(Party billOfLadingHolderParty) {
		this.billOfLadingHolderParty = billOfLadingHolderParty;
	}

	public Party getFreightForwarderParty() {
		return freightForwarderParty;
	}

	public void setFreightForwarderParty(Party freightForwarderParty) {
		this.freightForwarderParty = freightForwarderParty;
	}

	public Party getInsuranceParty() {
		return insuranceParty;
	}

	public void setInsuranceParty(Party insuranceParty) {
		this.insuranceParty = insuranceParty;
	}

	public Party getOriginalDespatchParty() {
		return originalDespatchParty;
	}

	public void setOriginalDespatchParty(Party originalDespatchParty) {
		this.originalDespatchParty = originalDespatchParty;
	}

	public Party getNotifyParty() {
		return notifyParty;
	}

	public void setNotifyParty(Party notifyParty) {
		this.notifyParty = notifyParty;
	}

	public Party getCarrierParty() {
		return carrierParty;
	}

	public void setCarrierParty(Party carrierParty) {
		this.carrierParty = carrierParty;
	}

	public Party getImporterParty() {
		return importerParty;
	}

	public void setImporterParty(Party importerParty) {
		this.importerParty = importerParty;
	}

	public Party getConsignorParty() {
		return consignorParty;
	}

	public void setConsignorParty(Party consignorParty) {
		this.consignorParty = consignorParty;
	}

	public Party getExporterParty() {
		return exporterParty;
	}

	public void setExporterParty(Party exporterParty) {
		this.exporterParty = exporterParty;
	}

	public Party getConsigneeParty() {
		return consigneeParty;
	}

	public void setConsigneeParty(Party consigneeParty) {
		this.consigneeParty = consigneeParty;
	}

	public Consignment getChildConsignment() {
		return childConsignment;
	}

	public void setChildConsignment(Consignment childConsignment) {
		this.childConsignment = childConsignment;
	}

	public Party getLogisticsOperatorParty() {
		return logisticsOperatorParty;
	}

	public void setLogisticsOperatorParty(Party logisticsOperatorParty) {
		this.logisticsOperatorParty = logisticsOperatorParty;
	}

	public Party getMortgageHolderParty() {
		return mortgageHolderParty;
	}

	public void setMortgageHolderParty(Party mortgageHolderParty) {
		this.mortgageHolderParty = mortgageHolderParty;
	}

	public Party getHazardousItemNotificationParty() {
		return hazardousItemNotificationParty;
	}

	public void setHazardousItemNotificationParty(Party hazardousItemNotificationParty) {
		this.hazardousItemNotificationParty = hazardousItemNotificationParty;
	}

	public Party getTransportAdvisorParty() {
		return transportAdvisorParty;
	}

	public void setTransportAdvisorParty(Party transportAdvisorParty) {
		this.transportAdvisorParty = transportAdvisorParty;
	}

	public Party getSubstituteCarrierParty() {
		return substituteCarrierParty;
	}

	public void setSubstituteCarrierParty(Party substituteCarrierParty) {
		this.substituteCarrierParty = substituteCarrierParty;
	}

	public Party getPerformingCarrierParty() {
		return performingCarrierParty;
	}

	public void setPerformingCarrierParty(Party performingCarrierParty) {
		this.performingCarrierParty = performingCarrierParty;
	}

	public Party getFinalDeliveryParty() {
		return finalDeliveryParty;
	}

	public void setFinalDeliveryParty(Party finalDeliveryParty) {
		this.finalDeliveryParty = finalDeliveryParty;
	}

	public PaymentTerms getCollectPaymentTerms() {
		return collectPaymentTerms;
	}

	public void setCollectPaymentTerms(PaymentTerms collectPaymentTerms) {
		this.collectPaymentTerms = collectPaymentTerms;
	}

	public PaymentTerms getDisbursementPaymentTerms() {
		return disbursementPaymentTerms;
	}

	public void setDisbursementPaymentTerms(PaymentTerms disbursementPaymentTerms) {
		this.disbursementPaymentTerms = disbursementPaymentTerms;
	}

	public PaymentTerms getPrepaidPaymentTerms() {
		return prepaidPaymentTerms;
	}

	public void setPrepaidPaymentTerms(PaymentTerms prepaidPaymentTerms) {
		this.prepaidPaymentTerms = prepaidPaymentTerms;
	}

	public List<PaymentTerms> getPaymentTermss() {
		return paymentTermss;
	}

	public void setPaymentTermss(List<PaymentTerms> paymentTermss) {
		this.paymentTermss = paymentTermss;
	}

	public Shipment getConsolidatedShipment() {
		return consolidatedShipment;
	}

	public void setConsolidatedShipment(Shipment consolidatedShipment) {
		this.consolidatedShipment = consolidatedShipment;
	}

	public ShipmentStage getOnCarriageShipmentStage() {
		return onCarriageShipmentStage;
	}

	public void setOnCarriageShipmentStage(ShipmentStage onCarriageShipmentStage) {
		this.onCarriageShipmentStage = onCarriageShipmentStage;
	}

	public ShipmentStage getPreCarriageShipmentStage() {
		return preCarriageShipmentStage;
	}

	public void setPreCarriageShipmentStage(ShipmentStage preCarriageShipmentStage) {
		this.preCarriageShipmentStage = preCarriageShipmentStage;
	}

	public ShipmentStage getMainCarriageShipmentStage() {
		return mainCarriageShipmentStage;
	}

	public void setMainCarriageShipmentStage(ShipmentStage mainCarriageShipmentStage) {
		this.mainCarriageShipmentStage = mainCarriageShipmentStage;
	}

	public List<TransportEvent> getTransportEvents() {
		return transportEvents;
	}

	public void setTransportEvents(List<TransportEvent> transportEvents) {
		this.transportEvents = transportEvents;
	}

	public List<TransportHandlingUnit> getTransportHandlingUnits() {
		return transportHandlingUnits;
	}

	public void setTransportHandlingUnits(List<TransportHandlingUnit> transportHandlingUnits) {
		this.transportHandlingUnits = transportHandlingUnits;
	}

	public TransportationService getOriginalDespatchTransportationService() {
		return originalDespatchTransportationService;
	}

	public void setOriginalDespatchTransportationService(TransportationService originalDespatchTransportationService) {
		this.originalDespatchTransportationService = originalDespatchTransportationService;
	}

	public TransportationService getFinalDeliveryTransportationService() {
		return finalDeliveryTransportationService;
	}

	public void setFinalDeliveryTransportationService(TransportationService finalDeliveryTransportationService) {
		this.finalDeliveryTransportationService = finalDeliveryTransportationService;
	}

	public List<Status> getStatuss() {
		return statuss;
	}

	public void setStatuss(List<Status> statuss) {
		this.statuss = statuss;
	}

	public TransportEvent getRequestedPickupTransportEvent() {
		return requestedPickupTransportEvent;
	}

	public void setRequestedPickupTransportEvent(TransportEvent requestedPickupTransportEvent) {
		this.requestedPickupTransportEvent = requestedPickupTransportEvent;
	}

	public TransportEvent getRequestedDeliveryTransportEvent() {
		return requestedDeliveryTransportEvent;
	}

	public void setRequestedDeliveryTransportEvent(TransportEvent requestedDeliveryTransportEvent) {
		this.requestedDeliveryTransportEvent = requestedDeliveryTransportEvent;
	}

	public TransportEvent getPlannedPickupTransportEvent() {
		return plannedPickupTransportEvent;
	}

	public void setPlannedPickupTransportEvent(TransportEvent plannedPickupTransportEvent) {
		this.plannedPickupTransportEvent = plannedPickupTransportEvent;
	}

	public TransportEvent getPlannedDeliveryTransportEvent() {
		return plannedDeliveryTransportEvent;
	}

	public void setPlannedDeliveryTransportEvent(TransportEvent plannedDeliveryTransportEvent) {
		this.plannedDeliveryTransportEvent = plannedDeliveryTransportEvent;
	}
}// end Consignment