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
	private boolean AnimalFoodIndicator;
	/**
	 * An identifier for this consignment, assigned by the broker.
	 */
	private String BrokerAssignedID;
	/**
	 * An indication that the transported goods in this consignment are bulk
	 * cargoes (true) or not (false).
	 */
	private boolean BulkCargoIndicator;
	/**
	 * An identifier for this consignment, assigned by the carrier.
	 */
	private String CarrierAssignedID;
	/**
	 * Service instructions to the carrier, expressed as text.
	 */
	private String CarrierServiceInstructions;
	/**
	 * The weight upon which a charge is to be based.
	 */
	private BigDecimal ChargeableWeightMeasure;
	/**
	 * The quantity of (consolidated) child consignments
	 */
	private BigDecimal ChildConsignmentQuantity;
	/**
	 * An identifier for this consignment, assigned by the consignee.
	 */
	private String ConsigneeAssignedID;
	/**
	 * The count in this consignment considering goods items, child
	 * consignments, shipments
	 */
	private BigDecimal ConsignmentQuantity;
	/**
	 * An identifier for this consignment, assigned by the consignor.
	 */
	private String ConsignorAssignedID;
	/**
	 * An indicator that this consignment can be consolidated (true) or not
	 * (false).
	 */
	private boolean ConsolidatableIndicator;
	/**
	 * An indication that the transported goods in this consignment are
	 * containerized cargoes (true) or not (false).
	 */
	private boolean ContainerizedIndicator;
	/**
	 * An identifier for this consignment, assigned by the contracted carrier.
	 */
	private String ContractedCarrierAssignedID;
	/**
	 * Service instructions for customs clearance, expressed as text.
	 */
	private String CustomsClearanceServiceInstructions;
	/**
	 * The total declared value for customs purposes of all the goods in this
	 * consignment, regardless of whether they are subject to the same customs
	 * procedure, tariff/statistical categorization, country information, or
	 * duty regime.
	 */
	private BigDecimal DeclaredCustomsValueAmount;
	/**
	 * The value of this consignment, declared by the shipper or his agent
	 * solely for the purpose of varying the carrier's level of liability from
	 * that provided in the contract of carriage, in case of loss or damage to
	 * goods or delayed delivery.
	 */
	private BigDecimal DeclaredForCarriageValueAmount;
	/**
	 * The value, declared for statistical purposes, of those goods in this
	 * consignment that have the same statistical heading.
	 */
	private BigDecimal DeclaredStatisticsValueAmount;
	/**
	 * A set of delivery instructions relating to this consignment.
	 */
	private String DeliveryInstructions;
	/**
	 * Service instructions for the forwarder, expressed as text.
	 */
	private String ForwarderServiceInstructions;
	/**
	 * The monetary amount that has to be or has been paid as calculated under
	 * the applicable trade delivery.
	 */
	private BigDecimal FreeOnBoardValueAmount;
	/**
	 * An identifier for this consignment, assigned by the freight forwarder.
	 */
	private String FreightForwarderAssignedID;
	/**
	 * An indication that the transported goods in this consignment are general
	 * cargoes (true) or not (false).
	 */
	private boolean GeneralCargoIndicator;
	/**
	 * The total volume of the goods referred to as one consignment.
	 */
	private BigDecimal GrossVolumeMeasure;
	/**
	 * The total declared weight of the goods in this consignment, including
	 * packaging but excluding the carrier's equipment.
	 */
	private BigDecimal GrossWeightMeasure;
	/**
	 * The handling required for this consignment, expressed as a code.
	 */
	private String HandlingCode;
	/**
	 * The handling required for this consignment, expressed as text.
	 */
	private String HandlingInstructions;
	/**
	 * Instructions regarding haulage of this consignment, expressed as text.
	 */
	private String HaulageInstructions;
	/**
	 * An indication that the transported goods in this consignment are subject
	 * to an international regulation concerning the carriage of dangerous goods
	 * (true) or not (false).
	 */
	private boolean HazardousRiskIndicator;
	/**
	 * An indication that the transported goods in this consignment are for
	 * human consumption (true) or not (false).
	 */
	private boolean HumanFoodIndicator;
	/**
	 * An identifier assigned to a collection of goods for both import and
	 * export.
	 */
	private String ID;
	/**
	 * Free-form text pertinent to this consignment, conveying information that
	 * is not contained explicitly in other structures.
	 */
	private String Information;
	/**
	 * The amount of the premium payable to an insurance company for insuring
	 * the goods contained in this consignment.
	 */
	private BigDecimal InsurancePremiumAmount;
	/**
	 * The amount covered by insurance for this consignment.
	 */
	private BigDecimal InsuranceValueAmount;
	/**
	 * An indication that the transported goods are livestock (true) or not
	 * (false).
	 */
	private boolean LivestockIndicator;
	/**
	 * The total length in a means of transport or a piece of transport
	 * equipment which, given the width and height of the transport means, will
	 * accommodate all of the consignments in a single consolidation.
	 */
	private BigDecimal LoadingLengthMeasure;
	/**
	 * An identifier for the loading sequence of this consignment.
	 */
	private String LoadingSequenceID;
	/**
	 * The total net weight of the goods in this consignment, exclusive of
	 * packaging.
	 */
	private BigDecimal NetNetWeightMeasure;
	/**
	 * The total net volume of all goods items referred to as one consignment.
	 */
	private BigDecimal NetVolumeMeasure;
	/**
	 * The total net weight of all the goods items referred to as one
	 * consignment.
	 */
	private BigDecimal NetWeightMeasure;
	/**
	 * An identifier for this consignment, assigned by the performing carrier.
	 */
	private String PerformingCarrierAssignedID;
	/**
	 * Remarks concerning the complete consignment, to be printed on the
	 * transport document.
	 */
	private String Remarks;
	/**
	 * A sequence identifier for this consignment.
	 */
	private String SequenceID;
	/**
	 * A code signifying the priority or level of service required for this
	 * consignment.
	 */
	private String ShippingPriorityLevelCode;
	/**
	 * Special instructions relating to this consignment.
	 */
	private String SpecialInstructions;
	/**
	 * An indication that the transported goods in this consignment require
	 * special security (true) or not (false).
	 */
	private boolean SpecialSecurityIndicator;
	/**
	 * Special service instructions, expressed as text.
	 */
	private String SpecialServiceInstructions;
	/**
	 * An indicator that this consignment has been split in transit (true) or
	 * not (false).
	 */
	private boolean SplitConsignmentIndicator;
	/**
	 * A textual summary description of the consignment.
	 */
	private String SummaryDescription;
	/**
	 * A code signifying the tariff applied to this consignment.
	 */
	private String TariffCode;
	/**
	 * Text describing the tariff applied to this consignment.
	 */
	private String TariffDescription;
	/**
	 * An indication that this consignment will be paid for by a third party
	 * (true) or not (false).
	 */
	private boolean ThirdPartyPayerIndicator;
	/**
	 * The total number of goods items in this consignment.
	 */
	private BigDecimal TotalGoodsItemQuantity;
	/**
	 * The total of all invoice amounts declared in this consignment.
	 */
	private BigDecimal TotalInvoiceAmount;
	/**
	 * The total number of packages associated with a Consignment.
	 */
	private BigDecimal TotalPackagesQuantity;
	/**
	 * The number of pieces of transport handling equipment (pallets, boxes,
	 * cases, etc.) in this consignment.
	 */
	private BigDecimal TotalTransportHandlingUnitQuantity;
	private AllowanceCharge ExtraAllowanceCharge;
	private AllowanceCharge FreightAllowanceCharge;
	private Contract TransportContract;
	private Country OriginalDepartureCountry;
	private Country FinalDestinationCountry;
	private Country TransitCountry;
	private CustomsDeclaration m_CustomsDeclaration;
	private List<DeliveryTerms> deliveryTerms = new ArrayList<>(); 
	private Location FirstArrivalPortLocation;
	private Location LastExitPortLocation;
	private Party BillOfLadingHolderParty;
	private Party FreightForwarderParty;
	private Party InsuranceParty;
	private Party OriginalDespatchParty;
	private Party NotifyParty;
	private Party CarrierParty;
	private Party ImporterParty;
	private Party ConsignorParty;
	private Party ExporterParty;
	private Party ConsigneeParty;
	private Consignment ChildConsignment;
	private Party LogisticsOperatorParty;
	private Party MortgageHolderParty;
	private Party HazardousItemNotificationParty;
	private Party TransportAdvisorParty;
	private Party SubstituteCarrierParty;
	private Party PerformingCarrierParty;
	private Party FinalDeliveryParty;
	private PaymentTerms CollectPaymentTerms;
	private PaymentTerms DisbursementPaymentTerms;
	private PaymentTerms PrepaidPaymentTerms;
	private List<PaymentTerms> paymentTerms = new ArrayList<>();
	private Shipment ConsolidatedShipment;
	private ShipmentStage OnCarriageShipmentStage;
	private ShipmentStage PreCarriageShipmentStage;
	private ShipmentStage MainCarriageShipmentStage;
	private List<TransportEvent> transportEvents = new ArrayList<>();
	private TransportHandlingUnit m_TransportHandlingUnit;
	private TransportationService OriginalDespatchTransportationService;
	private TransportationService FinalDeliveryTransportationService;
	private Status m_Status;
	private TransportEvent RequestedPickupTransportEvent;
	private TransportEvent RequestedDeliveryTransportEvent;
	private TransportEvent PlannedPickupTransportEvent;
	private TransportEvent PlannedDeliveryTransportEvent;

	public Consignment() {

	}

	public void finalize() throws Throwable {

	}

	/**
	 * @return the animalFoodIndicator
	 */
	public boolean isAnimalFoodIndicator() {
		return AnimalFoodIndicator;
	}

	/**
	 * @param animalFoodIndicator
	 *            the animalFoodIndicator to set
	 */
	public void setAnimalFoodIndicator(boolean animalFoodIndicator) {
		AnimalFoodIndicator = animalFoodIndicator;
	}

	/**
	 * @return the brokerAssignedID
	 */
	public String getBrokerAssignedID() {
		return BrokerAssignedID;
	}

	/**
	 * @param brokerAssignedID
	 *            the brokerAssignedID to set
	 */
	public void setBrokerAssignedID(String brokerAssignedID) {
		BrokerAssignedID = brokerAssignedID;
	}

	/**
	 * @return the bulkCargoIndicator
	 */
	public boolean isBulkCargoIndicator() {
		return BulkCargoIndicator;
	}

	/**
	 * @param bulkCargoIndicator
	 *            the bulkCargoIndicator to set
	 */
	public void setBulkCargoIndicator(boolean bulkCargoIndicator) {
		BulkCargoIndicator = bulkCargoIndicator;
	}

	/**
	 * @return the carrierAssignedID
	 */
	public String getCarrierAssignedID() {
		return CarrierAssignedID;
	}

	/**
	 * @param carrierAssignedID
	 *            the carrierAssignedID to set
	 */
	public void setCarrierAssignedID(String carrierAssignedID) {
		CarrierAssignedID = carrierAssignedID;
	}

	/**
	 * @return the carrierServiceInstructions
	 */
	public String getCarrierServiceInstructions() {
		return CarrierServiceInstructions;
	}

	/**
	 * @param carrierServiceInstructions
	 *            the carrierServiceInstructions to set
	 */
	public void setCarrierServiceInstructions(String carrierServiceInstructions) {
		CarrierServiceInstructions = carrierServiceInstructions;
	}

	/**
	 * @return the chargeableWeightMeasure
	 */
	public BigDecimal getChargeableWeightMeasure() {
		return ChargeableWeightMeasure;
	}

	/**
	 * @param chargeableWeightMeasure
	 *            the chargeableWeightMeasure to set
	 */
	public void setChargeableWeightMeasure(BigDecimal chargeableWeightMeasure) {
		ChargeableWeightMeasure = chargeableWeightMeasure;
	}

	/**
	 * @return the childConsignmentQuantity
	 */
	public BigDecimal getChildConsignmentQuantity() {
		return ChildConsignmentQuantity;
	}

	/**
	 * @param childConsignmentQuantity
	 *            the childConsignmentQuantity to set
	 */
	public void setChildConsignmentQuantity(BigDecimal childConsignmentQuantity) {
		ChildConsignmentQuantity = childConsignmentQuantity;
	}

	/**
	 * @return the consigneeAssignedID
	 */
	public String getConsigneeAssignedID() {
		return ConsigneeAssignedID;
	}

	/**
	 * @param consigneeAssignedID
	 *            the consigneeAssignedID to set
	 */
	public void setConsigneeAssignedID(String consigneeAssignedID) {
		ConsigneeAssignedID = consigneeAssignedID;
	}

	/**
	 * @return the consignmentQuantity
	 */
	public BigDecimal getConsignmentQuantity() {
		return ConsignmentQuantity;
	}

	/**
	 * @param consignmentQuantity
	 *            the consignmentQuantity to set
	 */
	public void setConsignmentQuantity(BigDecimal consignmentQuantity) {
		ConsignmentQuantity = consignmentQuantity;
	}

	/**
	 * @return the consignorAssignedID
	 */
	public String getConsignorAssignedID() {
		return ConsignorAssignedID;
	}

	/**
	 * @param consignorAssignedID
	 *            the consignorAssignedID to set
	 */
	public void setConsignorAssignedID(String consignorAssignedID) {
		ConsignorAssignedID = consignorAssignedID;
	}

	/**
	 * @return the consolidatableIndicator
	 */
	public boolean isConsolidatableIndicator() {
		return ConsolidatableIndicator;
	}

	/**
	 * @param consolidatableIndicator
	 *            the consolidatableIndicator to set
	 */
	public void setConsolidatableIndicator(boolean consolidatableIndicator) {
		ConsolidatableIndicator = consolidatableIndicator;
	}

	/**
	 * @return the containerizedIndicator
	 */
	public boolean isContainerizedIndicator() {
		return ContainerizedIndicator;
	}

	/**
	 * @param containerizedIndicator
	 *            the containerizedIndicator to set
	 */
	public void setContainerizedIndicator(boolean containerizedIndicator) {
		ContainerizedIndicator = containerizedIndicator;
	}

	/**
	 * @return the contractedCarrierAssignedID
	 */
	public String getContractedCarrierAssignedID() {
		return ContractedCarrierAssignedID;
	}

	/**
	 * @param contractedCarrierAssignedID
	 *            the contractedCarrierAssignedID to set
	 */
	public void setContractedCarrierAssignedID(String contractedCarrierAssignedID) {
		ContractedCarrierAssignedID = contractedCarrierAssignedID;
	}

	/**
	 * @return the customsClearanceServiceInstructions
	 */
	public String getCustomsClearanceServiceInstructions() {
		return CustomsClearanceServiceInstructions;
	}

	/**
	 * @param customsClearanceServiceInstructions
	 *            the customsClearanceServiceInstructions to set
	 */
	public void setCustomsClearanceServiceInstructions(String customsClearanceServiceInstructions) {
		CustomsClearanceServiceInstructions = customsClearanceServiceInstructions;
	}

	/**
	 * @return the declaredCustomsValueAmount
	 */
	public BigDecimal getDeclaredCustomsValueAmount() {
		return DeclaredCustomsValueAmount;
	}

	/**
	 * @param declaredCustomsValueAmount
	 *            the declaredCustomsValueAmount to set
	 */
	public void setDeclaredCustomsValueAmount(BigDecimal declaredCustomsValueAmount) {
		DeclaredCustomsValueAmount = declaredCustomsValueAmount;
	}

	/**
	 * @return the declaredForCarriageValueAmount
	 */
	public BigDecimal getDeclaredForCarriageValueAmount() {
		return DeclaredForCarriageValueAmount;
	}

	/**
	 * @param declaredForCarriageValueAmount
	 *            the declaredForCarriageValueAmount to set
	 */
	public void setDeclaredForCarriageValueAmount(BigDecimal declaredForCarriageValueAmount) {
		DeclaredForCarriageValueAmount = declaredForCarriageValueAmount;
	}

	/**
	 * @return the declaredStatisticsValueAmount
	 */
	public BigDecimal getDeclaredStatisticsValueAmount() {
		return DeclaredStatisticsValueAmount;
	}

	/**
	 * @param declaredStatisticsValueAmount
	 *            the declaredStatisticsValueAmount to set
	 */
	public void setDeclaredStatisticsValueAmount(BigDecimal declaredStatisticsValueAmount) {
		DeclaredStatisticsValueAmount = declaredStatisticsValueAmount;
	}

	/**
	 * @return the deliveryInstructions
	 */
	public String getDeliveryInstructions() {
		return DeliveryInstructions;
	}

	/**
	 * @param deliveryInstructions
	 *            the deliveryInstructions to set
	 */
	public void setDeliveryInstructions(String deliveryInstructions) {
		DeliveryInstructions = deliveryInstructions;
	}

	/**
	 * @return the forwarderServiceInstructions
	 */
	public String getForwarderServiceInstructions() {
		return ForwarderServiceInstructions;
	}

	/**
	 * @param forwarderServiceInstructions
	 *            the forwarderServiceInstructions to set
	 */
	public void setForwarderServiceInstructions(String forwarderServiceInstructions) {
		ForwarderServiceInstructions = forwarderServiceInstructions;
	}

	/**
	 * @return the freeOnBoardValueAmount
	 */
	public BigDecimal getFreeOnBoardValueAmount() {
		return FreeOnBoardValueAmount;
	}

	/**
	 * @param freeOnBoardValueAmount
	 *            the freeOnBoardValueAmount to set
	 */
	public void setFreeOnBoardValueAmount(BigDecimal freeOnBoardValueAmount) {
		FreeOnBoardValueAmount = freeOnBoardValueAmount;
	}

	/**
	 * @return the freightForwarderAssignedID
	 */
	public String getFreightForwarderAssignedID() {
		return FreightForwarderAssignedID;
	}

	/**
	 * @param freightForwarderAssignedID
	 *            the freightForwarderAssignedID to set
	 */
	public void setFreightForwarderAssignedID(String freightForwarderAssignedID) {
		FreightForwarderAssignedID = freightForwarderAssignedID;
	}

	/**
	 * @return the generalCargoIndicator
	 */
	public boolean isGeneralCargoIndicator() {
		return GeneralCargoIndicator;
	}

	/**
	 * @param generalCargoIndicator
	 *            the generalCargoIndicator to set
	 */
	public void setGeneralCargoIndicator(boolean generalCargoIndicator) {
		GeneralCargoIndicator = generalCargoIndicator;
	}

	/**
	 * @return the grossVolumeMeasure
	 */
	public BigDecimal getGrossVolumeMeasure() {
		return GrossVolumeMeasure;
	}

	/**
	 * @param grossVolumeMeasure
	 *            the grossVolumeMeasure to set
	 */
	public void setGrossVolumeMeasure(BigDecimal grossVolumeMeasure) {
		GrossVolumeMeasure = grossVolumeMeasure;
	}

	/**
	 * @return the grossWeightMeasure
	 */
	public BigDecimal getGrossWeightMeasure() {
		return GrossWeightMeasure;
	}

	/**
	 * @param grossWeightMeasure
	 *            the grossWeightMeasure to set
	 */
	public void setGrossWeightMeasure(BigDecimal grossWeightMeasure) {
		GrossWeightMeasure = grossWeightMeasure;
	}

	/**
	 * @return the handlingCode
	 */
	public String getHandlingCode() {
		return HandlingCode;
	}

	/**
	 * @param handlingCode
	 *            the handlingCode to set
	 */
	public void setHandlingCode(String handlingCode) {
		HandlingCode = handlingCode;
	}

	/**
	 * @return the handlingInstructions
	 */
	public String getHandlingInstructions() {
		return HandlingInstructions;
	}

	/**
	 * @param handlingInstructions
	 *            the handlingInstructions to set
	 */
	public void setHandlingInstructions(String handlingInstructions) {
		HandlingInstructions = handlingInstructions;
	}

	/**
	 * @return the haulageInstructions
	 */
	public String getHaulageInstructions() {
		return HaulageInstructions;
	}

	/**
	 * @param haulageInstructions
	 *            the haulageInstructions to set
	 */
	public void setHaulageInstructions(String haulageInstructions) {
		HaulageInstructions = haulageInstructions;
	}

	/**
	 * @return the hazardousRiskIndicator
	 */
	public boolean isHazardousRiskIndicator() {
		return HazardousRiskIndicator;
	}

	/**
	 * @param hazardousRiskIndicator
	 *            the hazardousRiskIndicator to set
	 */
	public void setHazardousRiskIndicator(boolean hazardousRiskIndicator) {
		HazardousRiskIndicator = hazardousRiskIndicator;
	}

	/**
	 * @return the humanFoodIndicator
	 */
	public boolean isHumanFoodIndicator() {
		return HumanFoodIndicator;
	}

	/**
	 * @param humanFoodIndicator
	 *            the humanFoodIndicator to set
	 */
	public void setHumanFoodIndicator(boolean humanFoodIndicator) {
		HumanFoodIndicator = humanFoodIndicator;
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
	 * @return the information
	 */
	public String getInformation() {
		return Information;
	}

	/**
	 * @param information
	 *            the information to set
	 */
	public void setInformation(String information) {
		Information = information;
	}

	/**
	 * @return the insurancePremiumAmount
	 */
	public BigDecimal getInsurancePremiumAmount() {
		return InsurancePremiumAmount;
	}

	/**
	 * @param insurancePremiumAmount
	 *            the insurancePremiumAmount to set
	 */
	public void setInsurancePremiumAmount(BigDecimal insurancePremiumAmount) {
		InsurancePremiumAmount = insurancePremiumAmount;
	}

	/**
	 * @return the insuranceValueAmount
	 */
	public BigDecimal getInsuranceValueAmount() {
		return InsuranceValueAmount;
	}

	/**
	 * @param insuranceValueAmount
	 *            the insuranceValueAmount to set
	 */
	public void setInsuranceValueAmount(BigDecimal insuranceValueAmount) {
		InsuranceValueAmount = insuranceValueAmount;
	}

	/**
	 * @return the livestockIndicator
	 */
	public boolean isLivestockIndicator() {
		return LivestockIndicator;
	}

	/**
	 * @param livestockIndicator
	 *            the livestockIndicator to set
	 */
	public void setLivestockIndicator(boolean livestockIndicator) {
		LivestockIndicator = livestockIndicator;
	}

	/**
	 * @return the loadingLengthMeasure
	 */
	public BigDecimal getLoadingLengthMeasure() {
		return LoadingLengthMeasure;
	}

	/**
	 * @param loadingLengthMeasure
	 *            the loadingLengthMeasure to set
	 */
	public void setLoadingLengthMeasure(BigDecimal loadingLengthMeasure) {
		LoadingLengthMeasure = loadingLengthMeasure;
	}

	/**
	 * @return the loadingSequenceID
	 */
	public String getLoadingSequenceID() {
		return LoadingSequenceID;
	}

	/**
	 * @param loadingSequenceID
	 *            the loadingSequenceID to set
	 */
	public void setLoadingSequenceID(String loadingSequenceID) {
		LoadingSequenceID = loadingSequenceID;
	}

	/**
	 * @return the netNetWeightMeasure
	 */
	public BigDecimal getNetNetWeightMeasure() {
		return NetNetWeightMeasure;
	}

	/**
	 * @param netNetWeightMeasure
	 *            the netNetWeightMeasure to set
	 */
	public void setNetNetWeightMeasure(BigDecimal netNetWeightMeasure) {
		NetNetWeightMeasure = netNetWeightMeasure;
	}

	/**
	 * @return the netVolumeMeasure
	 */
	public BigDecimal getNetVolumeMeasure() {
		return NetVolumeMeasure;
	}

	/**
	 * @param netVolumeMeasure
	 *            the netVolumeMeasure to set
	 */
	public void setNetVolumeMeasure(BigDecimal netVolumeMeasure) {
		NetVolumeMeasure = netVolumeMeasure;
	}

	/**
	 * @return the netWeightMeasure
	 */
	public BigDecimal getNetWeightMeasure() {
		return NetWeightMeasure;
	}

	/**
	 * @param netWeightMeasure
	 *            the netWeightMeasure to set
	 */
	public void setNetWeightMeasure(BigDecimal netWeightMeasure) {
		NetWeightMeasure = netWeightMeasure;
	}

	/**
	 * @return the performingCarrierAssignedID
	 */
	public String getPerformingCarrierAssignedID() {
		return PerformingCarrierAssignedID;
	}

	/**
	 * @param performingCarrierAssignedID
	 *            the performingCarrierAssignedID to set
	 */
	public void setPerformingCarrierAssignedID(String performingCarrierAssignedID) {
		PerformingCarrierAssignedID = performingCarrierAssignedID;
	}

	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return Remarks;
	}

	/**
	 * @param remarks
	 *            the remarks to set
	 */
	public void setRemarks(String remarks) {
		Remarks = remarks;
	}

	/**
	 * @return the sequenceID
	 */
	public String getSequenceID() {
		return SequenceID;
	}

	/**
	 * @param sequenceID
	 *            the sequenceID to set
	 */
	public void setSequenceID(String sequenceID) {
		SequenceID = sequenceID;
	}

	/**
	 * @return the shippingPriorityLevelCode
	 */
	public String getShippingPriorityLevelCode() {
		return ShippingPriorityLevelCode;
	}

	/**
	 * @param shippingPriorityLevelCode
	 *            the shippingPriorityLevelCode to set
	 */
	public void setShippingPriorityLevelCode(String shippingPriorityLevelCode) {
		ShippingPriorityLevelCode = shippingPriorityLevelCode;
	}

	/**
	 * @return the specialInstructions
	 */
	public String getSpecialInstructions() {
		return SpecialInstructions;
	}

	/**
	 * @param specialInstructions
	 *            the specialInstructions to set
	 */
	public void setSpecialInstructions(String specialInstructions) {
		SpecialInstructions = specialInstructions;
	}

	/**
	 * @return the specialSecurityIndicator
	 */
	public boolean isSpecialSecurityIndicator() {
		return SpecialSecurityIndicator;
	}

	/**
	 * @param specialSecurityIndicator
	 *            the specialSecurityIndicator to set
	 */
	public void setSpecialSecurityIndicator(boolean specialSecurityIndicator) {
		SpecialSecurityIndicator = specialSecurityIndicator;
	}

	/**
	 * @return the specialServiceInstructions
	 */
	public String getSpecialServiceInstructions() {
		return SpecialServiceInstructions;
	}

	/**
	 * @param specialServiceInstructions
	 *            the specialServiceInstructions to set
	 */
	public void setSpecialServiceInstructions(String specialServiceInstructions) {
		SpecialServiceInstructions = specialServiceInstructions;
	}

	/**
	 * @return the splitConsignmentIndicator
	 */
	public boolean isSplitConsignmentIndicator() {
		return SplitConsignmentIndicator;
	}

	/**
	 * @param splitConsignmentIndicator
	 *            the splitConsignmentIndicator to set
	 */
	public void setSplitConsignmentIndicator(boolean splitConsignmentIndicator) {
		SplitConsignmentIndicator = splitConsignmentIndicator;
	}

	/**
	 * @return the summaryDescription
	 */
	public String getSummaryDescription() {
		return SummaryDescription;
	}

	/**
	 * @param summaryDescription
	 *            the summaryDescription to set
	 */
	public void setSummaryDescription(String summaryDescription) {
		SummaryDescription = summaryDescription;
	}

	/**
	 * @return the tariffCode
	 */
	public String getTariffCode() {
		return TariffCode;
	}

	/**
	 * @param tariffCode
	 *            the tariffCode to set
	 */
	public void setTariffCode(String tariffCode) {
		TariffCode = tariffCode;
	}

	/**
	 * @return the tariffDescription
	 */
	public String getTariffDescription() {
		return TariffDescription;
	}

	/**
	 * @param tariffDescription
	 *            the tariffDescription to set
	 */
	public void setTariffDescription(String tariffDescription) {
		TariffDescription = tariffDescription;
	}

	/**
	 * @return the thirdPartyPayerIndicator
	 */
	public boolean isThirdPartyPayerIndicator() {
		return ThirdPartyPayerIndicator;
	}

	/**
	 * @param thirdPartyPayerIndicator
	 *            the thirdPartyPayerIndicator to set
	 */
	public void setThirdPartyPayerIndicator(boolean thirdPartyPayerIndicator) {
		ThirdPartyPayerIndicator = thirdPartyPayerIndicator;
	}

	/**
	 * @return the totalGoodsItemQuantity
	 */
	public BigDecimal getTotalGoodsItemQuantity() {
		return TotalGoodsItemQuantity;
	}

	/**
	 * @param totalGoodsItemQuantity
	 *            the totalGoodsItemQuantity to set
	 */
	public void setTotalGoodsItemQuantity(BigDecimal totalGoodsItemQuantity) {
		TotalGoodsItemQuantity = totalGoodsItemQuantity;
	}

	/**
	 * @return the totalInvoiceAmount
	 */
	public BigDecimal getTotalInvoiceAmount() {
		return TotalInvoiceAmount;
	}

	/**
	 * @param totalInvoiceAmount
	 *            the totalInvoiceAmount to set
	 */
	public void setTotalInvoiceAmount(BigDecimal totalInvoiceAmount) {
		TotalInvoiceAmount = totalInvoiceAmount;
	}

	/**
	 * @return the totalPackagesQuantity
	 */
	public BigDecimal getTotalPackagesQuantity() {
		return TotalPackagesQuantity;
	}

	/**
	 * @param totalPackagesQuantity
	 *            the totalPackagesQuantity to set
	 */
	public void setTotalPackagesQuantity(BigDecimal totalPackagesQuantity) {
		TotalPackagesQuantity = totalPackagesQuantity;
	}

	/**
	 * @return the totalTransportHandlingUnitQuantity
	 */
	public BigDecimal getTotalTransportHandlingUnitQuantity() {
		return TotalTransportHandlingUnitQuantity;
	}

	/**
	 * @param totalTransportHandlingUnitQuantity
	 *            the totalTransportHandlingUnitQuantity to set
	 */
	public void setTotalTransportHandlingUnitQuantity(BigDecimal totalTransportHandlingUnitQuantity) {
		TotalTransportHandlingUnitQuantity = totalTransportHandlingUnitQuantity;
	}

	/**
	 * @return the extraAllowanceCharge
	 */
	public AllowanceCharge getExtraAllowanceCharge() {
		return ExtraAllowanceCharge;
	}

	/**
	 * @param extraAllowanceCharge
	 *            the extraAllowanceCharge to set
	 */
	public void setExtraAllowanceCharge(AllowanceCharge extraAllowanceCharge) {
		ExtraAllowanceCharge = extraAllowanceCharge;
	}

	/**
	 * @return the freightAllowanceCharge
	 */
	public AllowanceCharge getFreightAllowanceCharge() {
		return FreightAllowanceCharge;
	}

	/**
	 * @param freightAllowanceCharge
	 *            the freightAllowanceCharge to set
	 */
	public void setFreightAllowanceCharge(AllowanceCharge freightAllowanceCharge) {
		FreightAllowanceCharge = freightAllowanceCharge;
	}

	/**
	 * @return the transportContract
	 */
	public Contract getTransportContract() {
		return TransportContract;
	}

	/**
	 * @param transportContract
	 *            the transportContract to set
	 */
	public void setTransportContract(Contract transportContract) {
		TransportContract = transportContract;
	}

	/**
	 * @return the originalDepartureCountry
	 */
	public Country getOriginalDepartureCountry() {
		return OriginalDepartureCountry;
	}

	/**
	 * @param originalDepartureCountry
	 *            the originalDepartureCountry to set
	 */
	public void setOriginalDepartureCountry(Country originalDepartureCountry) {
		OriginalDepartureCountry = originalDepartureCountry;
	}

	/**
	 * @return the finalDestinationCountry
	 */
	public Country getFinalDestinationCountry() {
		return FinalDestinationCountry;
	}

	/**
	 * @param finalDestinationCountry
	 *            the finalDestinationCountry to set
	 */
	public void setFinalDestinationCountry(Country finalDestinationCountry) {
		FinalDestinationCountry = finalDestinationCountry;
	}

	/**
	 * @return the transitCountry
	 */
	public Country getTransitCountry() {
		return TransitCountry;
	}

	/**
	 * @param transitCountry
	 *            the transitCountry to set
	 */
	public void setTransitCountry(Country transitCountry) {
		TransitCountry = transitCountry;
	}

	/**
	 * @return the m_CustomsDeclaration
	 */
	public CustomsDeclaration getM_CustomsDeclaration() {
		return m_CustomsDeclaration;
	}

	/**
	 * @param m_CustomsDeclaration
	 *            the m_CustomsDeclaration to set
	 */
	public void setM_CustomsDeclaration(CustomsDeclaration m_CustomsDeclaration) {
		this.m_CustomsDeclaration = m_CustomsDeclaration;
	}

	/**
	 * @return the m_DeliveryTerms
	 */
	public DeliveryTerms getM_DeliveryTerms() {
		return m_DeliveryTerms;
	}

	/**
	 * @param m_DeliveryTerms
	 *            the m_DeliveryTerms to set
	 */
	public void setM_DeliveryTerms(DeliveryTerms m_DeliveryTerms) {
		this.m_DeliveryTerms = m_DeliveryTerms;
	}

	/**
	 * @return the firstArrivalPortLocation
	 */
	public Location getFirstArrivalPortLocation() {
		return FirstArrivalPortLocation;
	}

	/**
	 * @param firstArrivalPortLocation
	 *            the firstArrivalPortLocation to set
	 */
	public void setFirstArrivalPortLocation(Location firstArrivalPortLocation) {
		FirstArrivalPortLocation = firstArrivalPortLocation;
	}

	/**
	 * @return the lastExitPortLocation
	 */
	public Location getLastExitPortLocation() {
		return LastExitPortLocation;
	}

	/**
	 * @param lastExitPortLocation
	 *            the lastExitPortLocation to set
	 */
	public void setLastExitPortLocation(Location lastExitPortLocation) {
		LastExitPortLocation = lastExitPortLocation;
	}

	/**
	 * @return the billOfLadingHolderParty
	 */
	public Party getBillOfLadingHolderParty() {
		return BillOfLadingHolderParty;
	}

	/**
	 * @param billOfLadingHolderParty
	 *            the billOfLadingHolderParty to set
	 */
	public void setBillOfLadingHolderParty(Party billOfLadingHolderParty) {
		BillOfLadingHolderParty = billOfLadingHolderParty;
	}

	/**
	 * @return the freightForwarderParty
	 */
	public Party getFreightForwarderParty() {
		return FreightForwarderParty;
	}

	/**
	 * @param freightForwarderParty
	 *            the freightForwarderParty to set
	 */
	public void setFreightForwarderParty(Party freightForwarderParty) {
		FreightForwarderParty = freightForwarderParty;
	}

	/**
	 * @return the insuranceParty
	 */
	public Party getInsuranceParty() {
		return InsuranceParty;
	}

	/**
	 * @param insuranceParty
	 *            the insuranceParty to set
	 */
	public void setInsuranceParty(Party insuranceParty) {
		InsuranceParty = insuranceParty;
	}

	/**
	 * @return the originalDespatchParty
	 */
	public Party getOriginalDespatchParty() {
		return OriginalDespatchParty;
	}

	/**
	 * @param originalDespatchParty
	 *            the originalDespatchParty to set
	 */
	public void setOriginalDespatchParty(Party originalDespatchParty) {
		OriginalDespatchParty = originalDespatchParty;
	}

	/**
	 * @return the notifyParty
	 */
	public Party getNotifyParty() {
		return NotifyParty;
	}

	/**
	 * @param notifyParty
	 *            the notifyParty to set
	 */
	public void setNotifyParty(Party notifyParty) {
		NotifyParty = notifyParty;
	}

	/**
	 * @return the carrierParty
	 */
	public Party getCarrierParty() {
		return CarrierParty;
	}

	/**
	 * @param carrierParty
	 *            the carrierParty to set
	 */
	public void setCarrierParty(Party carrierParty) {
		CarrierParty = carrierParty;
	}

	/**
	 * @return the importerParty
	 */
	public Party getImporterParty() {
		return ImporterParty;
	}

	/**
	 * @param importerParty
	 *            the importerParty to set
	 */
	public void setImporterParty(Party importerParty) {
		ImporterParty = importerParty;
	}

	/**
	 * @return the consignorParty
	 */
	public Party getConsignorParty() {
		return ConsignorParty;
	}

	/**
	 * @param consignorParty
	 *            the consignorParty to set
	 */
	public void setConsignorParty(Party consignorParty) {
		ConsignorParty = consignorParty;
	}

	/**
	 * @return the exporterParty
	 */
	public Party getExporterParty() {
		return ExporterParty;
	}

	/**
	 * @param exporterParty
	 *            the exporterParty to set
	 */
	public void setExporterParty(Party exporterParty) {
		ExporterParty = exporterParty;
	}

	/**
	 * @return the consigneeParty
	 */
	public Party getConsigneeParty() {
		return ConsigneeParty;
	}

	/**
	 * @param consigneeParty
	 *            the consigneeParty to set
	 */
	public void setConsigneeParty(Party consigneeParty) {
		ConsigneeParty = consigneeParty;
	}

	/**
	 * @return the childConsignment
	 */
	public Consignment getChildConsignment() {
		return ChildConsignment;
	}

	/**
	 * @param childConsignment
	 *            the childConsignment to set
	 */
	public void setChildConsignment(Consignment childConsignment) {
		ChildConsignment = childConsignment;
	}

	/**
	 * @return the logisticsOperatorParty
	 */
	public Party getLogisticsOperatorParty() {
		return LogisticsOperatorParty;
	}

	/**
	 * @param logisticsOperatorParty
	 *            the logisticsOperatorParty to set
	 */
	public void setLogisticsOperatorParty(Party logisticsOperatorParty) {
		LogisticsOperatorParty = logisticsOperatorParty;
	}

	/**
	 * @return the mortgageHolderParty
	 */
	public Party getMortgageHolderParty() {
		return MortgageHolderParty;
	}

	/**
	 * @param mortgageHolderParty
	 *            the mortgageHolderParty to set
	 */
	public void setMortgageHolderParty(Party mortgageHolderParty) {
		MortgageHolderParty = mortgageHolderParty;
	}

	/**
	 * @return the hazardousItemNotificationParty
	 */
	public Party getHazardousItemNotificationParty() {
		return HazardousItemNotificationParty;
	}

	/**
	 * @param hazardousItemNotificationParty
	 *            the hazardousItemNotificationParty to set
	 */
	public void setHazardousItemNotificationParty(Party hazardousItemNotificationParty) {
		HazardousItemNotificationParty = hazardousItemNotificationParty;
	}

	/**
	 * @return the transportAdvisorParty
	 */
	public Party getTransportAdvisorParty() {
		return TransportAdvisorParty;
	}

	/**
	 * @param transportAdvisorParty
	 *            the transportAdvisorParty to set
	 */
	public void setTransportAdvisorParty(Party transportAdvisorParty) {
		TransportAdvisorParty = transportAdvisorParty;
	}

	/**
	 * @return the substituteCarrierParty
	 */
	public Party getSubstituteCarrierParty() {
		return SubstituteCarrierParty;
	}

	/**
	 * @param substituteCarrierParty
	 *            the substituteCarrierParty to set
	 */
	public void setSubstituteCarrierParty(Party substituteCarrierParty) {
		SubstituteCarrierParty = substituteCarrierParty;
	}

	/**
	 * @return the performingCarrierParty
	 */
	public Party getPerformingCarrierParty() {
		return PerformingCarrierParty;
	}

	/**
	 * @param performingCarrierParty
	 *            the performingCarrierParty to set
	 */
	public void setPerformingCarrierParty(Party performingCarrierParty) {
		PerformingCarrierParty = performingCarrierParty;
	}

	/**
	 * @return the finalDeliveryParty
	 */
	public Party getFinalDeliveryParty() {
		return FinalDeliveryParty;
	}

	/**
	 * @param finalDeliveryParty
	 *            the finalDeliveryParty to set
	 */
	public void setFinalDeliveryParty(Party finalDeliveryParty) {
		FinalDeliveryParty = finalDeliveryParty;
	}

	/**
	 * @return the collectPaymentTerms
	 */
	public PaymentTerms getCollectPaymentTerms() {
		return CollectPaymentTerms;
	}

	/**
	 * @param collectPaymentTerms
	 *            the collectPaymentTerms to set
	 */
	public void setCollectPaymentTerms(PaymentTerms collectPaymentTerms) {
		CollectPaymentTerms = collectPaymentTerms;
	}

	/**
	 * @return the disbursementPaymentTerms
	 */
	public PaymentTerms getDisbursementPaymentTerms() {
		return DisbursementPaymentTerms;
	}

	/**
	 * @param disbursementPaymentTerms
	 *            the disbursementPaymentTerms to set
	 */
	public void setDisbursementPaymentTerms(PaymentTerms disbursementPaymentTerms) {
		DisbursementPaymentTerms = disbursementPaymentTerms;
	}

	/**
	 * @return the prepaidPaymentTerms
	 */
	public PaymentTerms getPrepaidPaymentTerms() {
		return PrepaidPaymentTerms;
	}

	/**
	 * @param prepaidPaymentTerms
	 *            the prepaidPaymentTerms to set
	 */
	public void setPrepaidPaymentTerms(PaymentTerms prepaidPaymentTerms) {
		PrepaidPaymentTerms = prepaidPaymentTerms;
	}

	/**
	 * @return the m_PaymentTerms
	 */
	public PaymentTerms getM_PaymentTerms() {
		return m_PaymentTerms;
	}

	/**
	 * @param m_PaymentTerms
	 *            the m_PaymentTerms to set
	 */
	public void setM_PaymentTerms(PaymentTerms m_PaymentTerms) {
		this.m_PaymentTerms = m_PaymentTerms;
	}

	/**
	 * @return the consolidatedShipment
	 */
	public Shipment getConsolidatedShipment() {
		return ConsolidatedShipment;
	}

	/**
	 * @param consolidatedShipment
	 *            the consolidatedShipment to set
	 */
	public void setConsolidatedShipment(Shipment consolidatedShipment) {
		ConsolidatedShipment = consolidatedShipment;
	}

	/**
	 * @return the onCarriageShipmentStage
	 */
	public ShipmentStage getOnCarriageShipmentStage() {
		return OnCarriageShipmentStage;
	}

	/**
	 * @param onCarriageShipmentStage
	 *            the onCarriageShipmentStage to set
	 */
	public void setOnCarriageShipmentStage(ShipmentStage onCarriageShipmentStage) {
		OnCarriageShipmentStage = onCarriageShipmentStage;
	}

	/**
	 * @return the preCarriageShipmentStage
	 */
	public ShipmentStage getPreCarriageShipmentStage() {
		return PreCarriageShipmentStage;
	}

	/**
	 * @param preCarriageShipmentStage
	 *            the preCarriageShipmentStage to set
	 */
	public void setPreCarriageShipmentStage(ShipmentStage preCarriageShipmentStage) {
		PreCarriageShipmentStage = preCarriageShipmentStage;
	}

	/**
	 * @return the mainCarriageShipmentStage
	 */
	public ShipmentStage getMainCarriageShipmentStage() {
		return MainCarriageShipmentStage;
	}

	/**
	 * @param mainCarriageShipmentStage
	 *            the mainCarriageShipmentStage to set
	 */
	public void setMainCarriageShipmentStage(ShipmentStage mainCarriageShipmentStage) {
		MainCarriageShipmentStage = mainCarriageShipmentStage;
	}

	/**
	 * @return the m_TransportEvent
	 */
	public TransportEvent getM_TransportEvent() {
		return m_TransportEvent;
	}

	/**
	 * @param m_TransportEvent
	 *            the m_TransportEvent to set
	 */
	public void setM_TransportEvent(TransportEvent m_TransportEvent) {
		this.m_TransportEvent = m_TransportEvent;
	}

	/**
	 * @return the m_TransportHandlingUnit
	 */
	public TransportHandlingUnit getM_TransportHandlingUnit() {
		return m_TransportHandlingUnit;
	}

	/**
	 * @param m_TransportHandlingUnit
	 *            the m_TransportHandlingUnit to set
	 */
	public void setM_TransportHandlingUnit(TransportHandlingUnit m_TransportHandlingUnit) {
		this.m_TransportHandlingUnit = m_TransportHandlingUnit;
	}

	/**
	 * @return the originalDespatchTransportationService
	 */
	public TransportationService getOriginalDespatchTransportationService() {
		return OriginalDespatchTransportationService;
	}

	/**
	 * @param originalDespatchTransportationService
	 *            the originalDespatchTransportationService to set
	 */
	public void setOriginalDespatchTransportationService(TransportationService originalDespatchTransportationService) {
		OriginalDespatchTransportationService = originalDespatchTransportationService;
	}

	/**
	 * @return the finalDeliveryTransportationService
	 */
	public TransportationService getFinalDeliveryTransportationService() {
		return FinalDeliveryTransportationService;
	}

	/**
	 * @param finalDeliveryTransportationService
	 *            the finalDeliveryTransportationService to set
	 */
	public void setFinalDeliveryTransportationService(TransportationService finalDeliveryTransportationService) {
		FinalDeliveryTransportationService = finalDeliveryTransportationService;
	}

	/**
	 * @return the m_Status
	 */
	public Status getM_Status() {
		return m_Status;
	}

	/**
	 * @param m_Status
	 *            the m_Status to set
	 */
	public void setM_Status(Status m_Status) {
		this.m_Status = m_Status;
	}

	/**
	 * @return the requestedPickupTransportEvent
	 */
	public TransportEvent getRequestedPickupTransportEvent() {
		return RequestedPickupTransportEvent;
	}

	/**
	 * @param requestedPickupTransportEvent
	 *            the requestedPickupTransportEvent to set
	 */
	public void setRequestedPickupTransportEvent(TransportEvent requestedPickupTransportEvent) {
		RequestedPickupTransportEvent = requestedPickupTransportEvent;
	}

	/**
	 * @return the requestedDeliveryTransportEvent
	 */
	public TransportEvent getRequestedDeliveryTransportEvent() {
		return RequestedDeliveryTransportEvent;
	}

	/**
	 * @param requestedDeliveryTransportEvent
	 *            the requestedDeliveryTransportEvent to set
	 */
	public void setRequestedDeliveryTransportEvent(TransportEvent requestedDeliveryTransportEvent) {
		RequestedDeliveryTransportEvent = requestedDeliveryTransportEvent;
	}

	/**
	 * @return the plannedPickupTransportEvent
	 */
	public TransportEvent getPlannedPickupTransportEvent() {
		return PlannedPickupTransportEvent;
	}

	/**
	 * @param plannedPickupTransportEvent
	 *            the plannedPickupTransportEvent to set
	 */
	public void setPlannedPickupTransportEvent(TransportEvent plannedPickupTransportEvent) {
		PlannedPickupTransportEvent = plannedPickupTransportEvent;
	}

	/**
	 * @return the plannedDeliveryTransportEvent
	 */
	public TransportEvent getPlannedDeliveryTransportEvent() {
		return PlannedDeliveryTransportEvent;
	}

	/**
	 * @param plannedDeliveryTransportEvent
	 *            the plannedDeliveryTransportEvent to set
	 */
	public void setPlannedDeliveryTransportEvent(TransportEvent plannedDeliveryTransportEvent) {
		PlannedDeliveryTransportEvent = plannedDeliveryTransportEvent;
	}

}// end Consignment