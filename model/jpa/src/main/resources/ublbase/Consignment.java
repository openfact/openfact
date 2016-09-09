

/**
 * A class to describe an identifiable collection of one or more goods items to be
 * transported between the consignor and the consignee. This information may be
 * defined within a transport contract. A consignment may comprise more than one
 * shipment (e.g., when
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:44 a. m.
 */
public class Consignment {

	/**
	 * An indication that the transported goods in this consignment are animal
	 * foodstuffs (true) or not (false).
	 */
	private Indicator. Type AnimalFoodIndicator;
	/**
	 * An identifier for this consignment, assigned by the broker.
	 */
	private Identifier. Type BrokerAssignedID;
	/**
	 * An indication that the transported goods in this consignment are bulk cargoes
	 * (true) or not (false).
	 */
	private Indicator. Type BulkCargoIndicator;
	/**
	 * An identifier for this consignment, assigned by the carrier.
	 */
	private Identifier. Type CarrierAssignedID;
	/**
	 * Service instructions to the carrier, expressed as text.
	 */
	private Text. Type CarrierServiceInstructions;
	/**
	 * The weight upon which a charge is to be based.
	 */
	private Measure. Type ChargeableWeightMeasure;
	/**
	 * The quantity of (consolidated) child consignments
	 */
	private Quantity. Type ChildConsignmentQuantity;
	/**
	 * An identifier for this consignment, assigned by the consignee.
	 */
	private Identifier. Type ConsigneeAssignedID;
	/**
	 * The count in this consignment considering goods items, child consignments,
	 * shipments
	 */
	private Quantity. Type ConsignmentQuantity;
	/**
	 * An identifier for this consignment, assigned by the consignor.
	 */
	private Identifier. Type ConsignorAssignedID;
	/**
	 * An indicator that this consignment can be consolidated (true) or not (false).
	 */
	private Indicator. Type ConsolidatableIndicator;
	/**
	 * An indication that the transported goods in this consignment are containerized
	 * cargoes (true) or not (false).
	 */
	private Indicator. Type ContainerizedIndicator;
	/**
	 * An identifier for this consignment, assigned by the contracted carrier.
	 */
	private Identifier. Type ContractedCarrierAssignedID;
	/**
	 * Service instructions for customs clearance, expressed as text.
	 */
	private Text. Type CustomsClearanceServiceInstructions;
	/**
	 * The total declared value for customs purposes of all the goods in this
	 * consignment, regardless of whether they are subject to the same customs
	 * procedure, tariff/statistical categorization, country information, or duty
	 * regime.
	 */
	private Amount. Type DeclaredCustomsValueAmount;
	/**
	 * The value of this consignment, declared by the shipper or his agent solely for
	 * the purpose of varying the carrier's level of liability from that provided in
	 * the contract of carriage, in case of loss or damage to goods or delayed
	 * delivery.
	 */
	private Amount. Type DeclaredForCarriageValueAmount;
	/**
	 * The value, declared for statistical purposes, of those goods in this
	 * consignment that have the same statistical heading.
	 */
	private Amount. Type DeclaredStatisticsValueAmount;
	/**
	 * A set of delivery instructions relating to this consignment.
	 */
	private Text. Type DeliveryInstructions;
	/**
	 * Service instructions for the forwarder, expressed as text.
	 */
	private Text. Type ForwarderServiceInstructions;
	/**
	 * The monetary amount that has to be or has been paid as calculated under the
	 * applicable trade delivery.
	 */
	private Amount. Type FreeOnBoardValueAmount;
	/**
	 * An identifier for this consignment, assigned by the freight forwarder.
	 */
	private Identifier. Type FreightForwarderAssignedID;
	/**
	 * An indication that the transported goods in this consignment are general
	 * cargoes (true) or not (false).
	 */
	private Indicator. Type GeneralCargoIndicator;
	/**
	 * The total volume of the goods referred to as one consignment.
	 */
	private Measure. Type GrossVolumeMeasure;
	/**
	 * The total declared weight of the goods in this consignment, including packaging
	 * but excluding the carrier's equipment.
	 */
	private Measure. Type GrossWeightMeasure;
	/**
	 * The handling required for this consignment, expressed as a code.
	 */
	private Code. Type HandlingCode;
	/**
	 * The handling required for this consignment, expressed as text.
	 */
	private Text. Type HandlingInstructions;
	/**
	 * Instructions regarding haulage of this consignment, expressed as text.
	 */
	private Text. Type HaulageInstructions;
	/**
	 * An indication that the transported goods in this consignment are subject to an
	 * international regulation concerning the carriage of dangerous goods (true) or
	 * not (false).
	 */
	private Indicator. Type HazardousRiskIndicator;
	/**
	 * An indication that the transported goods in this consignment are for human
	 * consumption (true) or not (false).
	 */
	private Indicator. Type HumanFoodIndicator;
	/**
	 * An identifier assigned to a collection of goods for both import and export.
	 */
	private Identifier. Type ID;
	/**
	 * Free-form text pertinent to this consignment, conveying information that is not
	 * contained explicitly in other structures.
	 */
	private Text. Type Information;
	/**
	 * The amount of the premium payable to an insurance company for insuring the
	 * goods contained in this consignment.
	 */
	private Amount. Type InsurancePremiumAmount;
	/**
	 * The amount covered by insurance for this consignment.
	 */
	private Amount. Type InsuranceValueAmount;
	/**
	 * An indication that the transported goods are livestock (true) or not (false).
	 */
	private Indicator. Type LivestockIndicator;
	/**
	 * The total length in a means of transport or a piece of transport equipment
	 * which, given the width and height of the transport means, will accommodate all
	 * of the consignments in a single consolidation.
	 */
	private Measure. Type LoadingLengthMeasure;
	/**
	 * An identifier for the loading sequence of this consignment.
	 */
	private Identifier. Type LoadingSequenceID;
	/**
	 * The total net weight of the goods in this consignment, exclusive of packaging.
	 */
	private Measure. Type NetNetWeightMeasure;
	/**
	 * The total net volume of all goods items referred to as one consignment.
	 */
	private Measure. Type NetVolumeMeasure;
	/**
	 * The total net weight of all the goods items referred to as one consignment.
	 */
	private Measure. Type NetWeightMeasure;
	/**
	 * An identifier for this consignment, assigned by the performing carrier.
	 */
	private Identifier. Type PerformingCarrierAssignedID;
	/**
	 * Remarks concerning the complete consignment, to be printed on the transport
	 * document.
	 */
	private Text. Type Remarks;
	/**
	 * A sequence identifier for this consignment.
	 */
	private Identifier. Type SequenceID;
	/**
	 * A code signifying the priority or level of service required for this
	 * consignment.
	 */
	private Code. Type ShippingPriorityLevelCode;
	/**
	 * Special instructions relating to this consignment.
	 */
	private Text. Type SpecialInstructions;
	/**
	 * An indication that the transported goods in this consignment require special
	 * security (true) or not (false).
	 */
	private Indicator. Type SpecialSecurityIndicator;
	/**
	 * Special service instructions, expressed as text.
	 */
	private Text. Type SpecialServiceInstructions;
	/**
	 * An indicator that this consignment has been split in transit (true) or not
	 * (false).
	 */
	private Indicator. Type SplitConsignmentIndicator;
	/**
	 * A textual summary description of the consignment.
	 */
	private Text. Type SummaryDescription;
	/**
	 * A code signifying the tariff applied to this consignment.
	 */
	private Code. Type TariffCode;
	/**
	 * Text describing the tariff applied to this consignment.
	 */
	private Text. Type TariffDescription;
	/**
	 * An indication that this consignment will be paid for by a third party (true) or
	 * not (false).
	 */
	private Indicator. Type ThirdPartyPayerIndicator;
	/**
	 * The total number of goods items in this consignment.
	 */
	private Quantity. Type TotalGoodsItemQuantity;
	/**
	 * The total of all invoice amounts declared in this consignment.
	 */
	private Amount. Type TotalInvoiceAmount;
	/**
	 * The total number of packages associated with a Consignment.
	 */
	private Quantity. Type TotalPackagesQuantity;
	/**
	 * The number of pieces of transport handling equipment (pallets, boxes, cases,
	 * etc.) in this consignment.
	 */
	private Quantity. Type TotalTransportHandlingUnitQuantity;
	private Allowance Charge Extra Allowance Charge;
	private Allowance Charge Freight Allowance Charge;
	private Contract Transport Contract;
	private Country Original Departure Country;
	private Country Final Destination Country;
	private Country Transit Country;
	private Customs Declaration m_Customs Declaration;
	private Delivery Terms m_Delivery Terms;
	private Location First Arrival Port Location;
	private Location Last Exit Port Location;
	private Party Bill Of Lading Holder Party;
	private Party Freight Forwarder Party;
	private Party Insurance Party;
	private Party Original Despatch Party;
	private Party Notify Party;
	private Party Carrier Party;
	private Party Importer Party;
	private Party Consignor Party;
	private Party Exporter Party;
	private Party Consignee Party;
	private Consignment Child Consignment;
	private Party Logistics Operator Party;
	private Party Mortgage Holder Party;
	private Party Hazardous Item Notification Party;
	private Party Transport Advisor Party;
	private Party Substitute Carrier Party;
	private Party Performing Carrier Party;
	private Party Final Delivery Party;
	private Payment Terms Collect Payment Terms;
	private Payment Terms Disbursement Payment Terms;
	private Payment Terms Prepaid Payment Terms;
	private Payment Terms m_Payment Terms;
	private Shipment Consolidated Shipment;
	private Shipment Stage On Carriage Shipment Stage;
	private Shipment Stage Pre Carriage Shipment Stage;
	private Shipment Stage Main Carriage Shipment Stage;
	private Transport Event m_Transport Event;
	private Transport Handling Unit m_Transport Handling Unit;
	private Transportation Service Original Despatch Transportation Service;
	private Transportation Service Final Delivery Transportation Service;
	private Status m_Status;
	private Transport Event Requested Pickup Transport Event;
	private Transport Event Requested Delivery Transport Event;
	private Transport Event Planned Pickup Transport Event;
	private Transport Event Planned Delivery Transport Event;

	public Consignment(){

	}

	public void finalize() throws Throwable {

	}
	public Indicator. Type getAnimalFoodIndicator(){
		return AnimalFoodIndicator;
	}

	public Party getBill Of Lading Holder Party(){
		return Bill Of Lading Holder Party;
	}

	public Identifier. Type getBrokerAssignedID(){
		return BrokerAssignedID;
	}

	public Indicator. Type getBulkCargoIndicator(){
		return BulkCargoIndicator;
	}

	public Party getCarrier Party(){
		return Carrier Party;
	}

	public Identifier. Type getCarrierAssignedID(){
		return CarrierAssignedID;
	}

	public Text. Type getCarrierServiceInstructions(){
		return CarrierServiceInstructions;
	}

	public Measure. Type getChargeableWeightMeasure(){
		return ChargeableWeightMeasure;
	}

	public Consignment getChild Consignment(){
		return Child Consignment;
	}

	public Quantity. Type getChildConsignmentQuantity(){
		return ChildConsignmentQuantity;
	}

	public Payment Terms getCollect Payment Terms(){
		return Collect Payment Terms;
	}

	public Party getConsignee Party(){
		return Consignee Party;
	}

	public Identifier. Type getConsigneeAssignedID(){
		return ConsigneeAssignedID;
	}

	public Quantity. Type getConsignmentQuantity(){
		return ConsignmentQuantity;
	}

	public Party getConsignor Party(){
		return Consignor Party;
	}

	public Identifier. Type getConsignorAssignedID(){
		return ConsignorAssignedID;
	}

	public Indicator. Type getConsolidatableIndicator(){
		return ConsolidatableIndicator;
	}

	public Shipment getConsolidated Shipment(){
		return Consolidated Shipment;
	}

	public Indicator. Type getContainerizedIndicator(){
		return ContainerizedIndicator;
	}

	public Identifier. Type getContractedCarrierAssignedID(){
		return ContractedCarrierAssignedID;
	}

	public Customs Declaration getCustoms Declaration(){
		return m_Customs Declaration;
	}

	public Text. Type getCustomsClearanceServiceInstructions(){
		return CustomsClearanceServiceInstructions;
	}

	public Amount. Type getDeclaredCustomsValueAmount(){
		return DeclaredCustomsValueAmount;
	}

	public Amount. Type getDeclaredForCarriageValueAmount(){
		return DeclaredForCarriageValueAmount;
	}

	public Amount. Type getDeclaredStatisticsValueAmount(){
		return DeclaredStatisticsValueAmount;
	}

	public Delivery Terms getDelivery Terms(){
		return m_Delivery Terms;
	}

	public Text. Type getDeliveryInstructions(){
		return DeliveryInstructions;
	}

	public Payment Terms getDisbursement Payment Terms(){
		return Disbursement Payment Terms;
	}

	public Party getExporter Party(){
		return Exporter Party;
	}

	public Allowance Charge getExtra Allowance Charge(){
		return Extra Allowance Charge;
	}

	public Party getFinal Delivery Party(){
		return Final Delivery Party;
	}

	public Transportation Service getFinal Delivery Transportation Service(){
		return Final Delivery Transportation Service;
	}

	public Country getFinal Destination Country(){
		return Final Destination Country;
	}

	public Location getFirst Arrival Port Location(){
		return First Arrival Port Location;
	}

	public Text. Type getForwarderServiceInstructions(){
		return ForwarderServiceInstructions;
	}

	public Amount. Type getFreeOnBoardValueAmount(){
		return FreeOnBoardValueAmount;
	}

	public Allowance Charge getFreight Allowance Charge(){
		return Freight Allowance Charge;
	}

	public Party getFreight Forwarder Party(){
		return Freight Forwarder Party;
	}

	public Identifier. Type getFreightForwarderAssignedID(){
		return FreightForwarderAssignedID;
	}

	public Indicator. Type getGeneralCargoIndicator(){
		return GeneralCargoIndicator;
	}

	public Measure. Type getGrossVolumeMeasure(){
		return GrossVolumeMeasure;
	}

	public Measure. Type getGrossWeightMeasure(){
		return GrossWeightMeasure;
	}

	public Code. Type getHandlingCode(){
		return HandlingCode;
	}

	public Text. Type getHandlingInstructions(){
		return HandlingInstructions;
	}

	public Text. Type getHaulageInstructions(){
		return HaulageInstructions;
	}

	public Party getHazardous Item Notification Party(){
		return Hazardous Item Notification Party;
	}

	public Indicator. Type getHazardousRiskIndicator(){
		return HazardousRiskIndicator;
	}

	public Indicator. Type getHumanFoodIndicator(){
		return HumanFoodIndicator;
	}

	public Identifier. Type getID(){
		return ID;
	}

	public Party getImporter Party(){
		return Importer Party;
	}

	public Text. Type getInformation(){
		return Information;
	}

	public Party getInsurance Party(){
		return Insurance Party;
	}

	public Amount. Type getInsurancePremiumAmount(){
		return InsurancePremiumAmount;
	}

	public Amount. Type getInsuranceValueAmount(){
		return InsuranceValueAmount;
	}

	public Location getLast Exit Port Location(){
		return Last Exit Port Location;
	}

	public Indicator. Type getLivestockIndicator(){
		return LivestockIndicator;
	}

	public Measure. Type getLoadingLengthMeasure(){
		return LoadingLengthMeasure;
	}

	public Identifier. Type getLoadingSequenceID(){
		return LoadingSequenceID;
	}

	public Party getLogistics Operator Party(){
		return Logistics Operator Party;
	}

	public Shipment Stage getMain Carriage Shipment Stage(){
		return Main Carriage Shipment Stage;
	}

	public Party getMortgage Holder Party(){
		return Mortgage Holder Party;
	}

	public Measure. Type getNetNetWeightMeasure(){
		return NetNetWeightMeasure;
	}

	public Measure. Type getNetVolumeMeasure(){
		return NetVolumeMeasure;
	}

	public Measure. Type getNetWeightMeasure(){
		return NetWeightMeasure;
	}

	public Party getNotify Party(){
		return Notify Party;
	}

	public Shipment Stage getOn Carriage Shipment Stage(){
		return On Carriage Shipment Stage;
	}

	public Country getOriginal Departure Country(){
		return Original Departure Country;
	}

	public Party getOriginal Despatch Party(){
		return Original Despatch Party;
	}

	public Transportation Service getOriginal Despatch Transportation Service(){
		return Original Despatch Transportation Service;
	}

	public Payment Terms getPayment Terms(){
		return m_Payment Terms;
	}

	public Party getPerforming Carrier Party(){
		return Performing Carrier Party;
	}

	public Identifier. Type getPerformingCarrierAssignedID(){
		return PerformingCarrierAssignedID;
	}

	public Transport Event getPlanned Delivery Transport Event(){
		return Planned Delivery Transport Event;
	}

	public Transport Event getPlanned Pickup Transport Event(){
		return Planned Pickup Transport Event;
	}

	public Shipment Stage getPre Carriage Shipment Stage(){
		return Pre Carriage Shipment Stage;
	}

	public Payment Terms getPrepaid Payment Terms(){
		return Prepaid Payment Terms;
	}

	public Text. Type getRemarks(){
		return Remarks;
	}

	public Transport Event getRequested Delivery Transport Event(){
		return Requested Delivery Transport Event;
	}

	public Transport Event getRequested Pickup Transport Event(){
		return Requested Pickup Transport Event;
	}

	public Identifier. Type getSequenceID(){
		return SequenceID;
	}

	public Code. Type getShippingPriorityLevelCode(){
		return ShippingPriorityLevelCode;
	}

	public Text. Type getSpecialInstructions(){
		return SpecialInstructions;
	}

	public Indicator. Type getSpecialSecurityIndicator(){
		return SpecialSecurityIndicator;
	}

	public Text. Type getSpecialServiceInstructions(){
		return SpecialServiceInstructions;
	}

	public Indicator. Type getSplitConsignmentIndicator(){
		return SplitConsignmentIndicator;
	}

	public Status getStatus(){
		return m_Status;
	}

	public Party getSubstitute Carrier Party(){
		return Substitute Carrier Party;
	}

	public Text. Type getSummaryDescription(){
		return SummaryDescription;
	}

	public Code. Type getTariffCode(){
		return TariffCode;
	}

	public Text. Type getTariffDescription(){
		return TariffDescription;
	}

	public Indicator. Type getThirdPartyPayerIndicator(){
		return ThirdPartyPayerIndicator;
	}

	public Quantity. Type getTotalGoodsItemQuantity(){
		return TotalGoodsItemQuantity;
	}

	public Amount. Type getTotalInvoiceAmount(){
		return TotalInvoiceAmount;
	}

	public Quantity. Type getTotalPackagesQuantity(){
		return TotalPackagesQuantity;
	}

	public Quantity. Type getTotalTransportHandlingUnitQuantity(){
		return TotalTransportHandlingUnitQuantity;
	}

	public Country getTransit Country(){
		return Transit Country;
	}

	public Party getTransport Advisor Party(){
		return Transport Advisor Party;
	}

	public Contract getTransport Contract(){
		return Transport Contract;
	}

	public Transport Event getTransport Event(){
		return m_Transport Event;
	}

	public Transport Handling Unit getTransport Handling Unit(){
		return m_Transport Handling Unit;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAnimalFoodIndicator(Indicator. Type newVal){
		AnimalFoodIndicator = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setBill Of Lading Holder Party(Party newVal){
		Bill Of Lading Holder Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setBrokerAssignedID(Identifier. Type newVal){
		BrokerAssignedID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setBulkCargoIndicator(Indicator. Type newVal){
		BulkCargoIndicator = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCarrier Party(Party newVal){
		Carrier Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCarrierAssignedID(Identifier. Type newVal){
		CarrierAssignedID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCarrierServiceInstructions(Text. Type newVal){
		CarrierServiceInstructions = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setChargeableWeightMeasure(Measure. Type newVal){
		ChargeableWeightMeasure = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setChild Consignment(Consignment newVal){
		Child Consignment = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setChildConsignmentQuantity(Quantity. Type newVal){
		ChildConsignmentQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCollect Payment Terms(Payment Terms newVal){
		Collect Payment Terms = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setConsignee Party(Party newVal){
		Consignee Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setConsigneeAssignedID(Identifier. Type newVal){
		ConsigneeAssignedID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setConsignmentQuantity(Quantity. Type newVal){
		ConsignmentQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setConsignor Party(Party newVal){
		Consignor Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setConsignorAssignedID(Identifier. Type newVal){
		ConsignorAssignedID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setConsolidatableIndicator(Indicator. Type newVal){
		ConsolidatableIndicator = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setConsolidated Shipment(Shipment newVal){
		Consolidated Shipment = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setContainerizedIndicator(Indicator. Type newVal){
		ContainerizedIndicator = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setContractedCarrierAssignedID(Identifier. Type newVal){
		ContractedCarrierAssignedID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCustoms Declaration(Customs Declaration newVal){
		m_Customs Declaration = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCustomsClearanceServiceInstructions(Text. Type newVal){
		CustomsClearanceServiceInstructions = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDeclaredCustomsValueAmount(Amount. Type newVal){
		DeclaredCustomsValueAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDeclaredForCarriageValueAmount(Amount. Type newVal){
		DeclaredForCarriageValueAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDeclaredStatisticsValueAmount(Amount. Type newVal){
		DeclaredStatisticsValueAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDelivery Terms(Delivery Terms newVal){
		m_Delivery Terms = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDeliveryInstructions(Text. Type newVal){
		DeliveryInstructions = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDisbursement Payment Terms(Payment Terms newVal){
		Disbursement Payment Terms = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setExporter Party(Party newVal){
		Exporter Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setExtra Allowance Charge(Allowance Charge newVal){
		Extra Allowance Charge = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFinal Delivery Party(Party newVal){
		Final Delivery Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFinal Delivery Transportation Service(Transportation Service newVal){
		Final Delivery Transportation Service = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFinal Destination Country(Country newVal){
		Final Destination Country = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFirst Arrival Port Location(Location newVal){
		First Arrival Port Location = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setForwarderServiceInstructions(Text. Type newVal){
		ForwarderServiceInstructions = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFreeOnBoardValueAmount(Amount. Type newVal){
		FreeOnBoardValueAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFreight Allowance Charge(Allowance Charge newVal){
		Freight Allowance Charge = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFreight Forwarder Party(Party newVal){
		Freight Forwarder Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFreightForwarderAssignedID(Identifier. Type newVal){
		FreightForwarderAssignedID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setGeneralCargoIndicator(Indicator. Type newVal){
		GeneralCargoIndicator = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setGrossVolumeMeasure(Measure. Type newVal){
		GrossVolumeMeasure = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setGrossWeightMeasure(Measure. Type newVal){
		GrossWeightMeasure = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setHandlingCode(Code. Type newVal){
		HandlingCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setHandlingInstructions(Text. Type newVal){
		HandlingInstructions = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setHaulageInstructions(Text. Type newVal){
		HaulageInstructions = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setHazardous Item Notification Party(Party newVal){
		Hazardous Item Notification Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setHazardousRiskIndicator(Indicator. Type newVal){
		HazardousRiskIndicator = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setHumanFoodIndicator(Indicator. Type newVal){
		HumanFoodIndicator = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setID(Identifier. Type newVal){
		ID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setImporter Party(Party newVal){
		Importer Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setInformation(Text. Type newVal){
		Information = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setInsurance Party(Party newVal){
		Insurance Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setInsurancePremiumAmount(Amount. Type newVal){
		InsurancePremiumAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setInsuranceValueAmount(Amount. Type newVal){
		InsuranceValueAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLast Exit Port Location(Location newVal){
		Last Exit Port Location = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLivestockIndicator(Indicator. Type newVal){
		LivestockIndicator = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLoadingLengthMeasure(Measure. Type newVal){
		LoadingLengthMeasure = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLoadingSequenceID(Identifier. Type newVal){
		LoadingSequenceID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLogistics Operator Party(Party newVal){
		Logistics Operator Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMain Carriage Shipment Stage(Shipment Stage newVal){
		Main Carriage Shipment Stage = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMortgage Holder Party(Party newVal){
		Mortgage Holder Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNetNetWeightMeasure(Measure. Type newVal){
		NetNetWeightMeasure = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNetVolumeMeasure(Measure. Type newVal){
		NetVolumeMeasure = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNetWeightMeasure(Measure. Type newVal){
		NetWeightMeasure = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNotify Party(Party newVal){
		Notify Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setOn Carriage Shipment Stage(Shipment Stage newVal){
		On Carriage Shipment Stage = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setOriginal Departure Country(Country newVal){
		Original Departure Country = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setOriginal Despatch Party(Party newVal){
		Original Despatch Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setOriginal Despatch Transportation Service(Transportation Service newVal){
		Original Despatch Transportation Service = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPayment Terms(Payment Terms newVal){
		m_Payment Terms = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPerforming Carrier Party(Party newVal){
		Performing Carrier Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPerformingCarrierAssignedID(Identifier. Type newVal){
		PerformingCarrierAssignedID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPlanned Delivery Transport Event(Transport Event newVal){
		Planned Delivery Transport Event = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPlanned Pickup Transport Event(Transport Event newVal){
		Planned Pickup Transport Event = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPre Carriage Shipment Stage(Shipment Stage newVal){
		Pre Carriage Shipment Stage = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPrepaid Payment Terms(Payment Terms newVal){
		Prepaid Payment Terms = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRemarks(Text. Type newVal){
		Remarks = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRequested Delivery Transport Event(Transport Event newVal){
		Requested Delivery Transport Event = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRequested Pickup Transport Event(Transport Event newVal){
		Requested Pickup Transport Event = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSequenceID(Identifier. Type newVal){
		SequenceID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setShippingPriorityLevelCode(Code. Type newVal){
		ShippingPriorityLevelCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSpecialInstructions(Text. Type newVal){
		SpecialInstructions = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSpecialSecurityIndicator(Indicator. Type newVal){
		SpecialSecurityIndicator = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSpecialServiceInstructions(Text. Type newVal){
		SpecialServiceInstructions = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSplitConsignmentIndicator(Indicator. Type newVal){
		SplitConsignmentIndicator = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setStatus(Status newVal){
		m_Status = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSubstitute Carrier Party(Party newVal){
		Substitute Carrier Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSummaryDescription(Text. Type newVal){
		SummaryDescription = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTariffCode(Code. Type newVal){
		TariffCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTariffDescription(Text. Type newVal){
		TariffDescription = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setThirdPartyPayerIndicator(Indicator. Type newVal){
		ThirdPartyPayerIndicator = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTotalGoodsItemQuantity(Quantity. Type newVal){
		TotalGoodsItemQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTotalInvoiceAmount(Amount. Type newVal){
		TotalInvoiceAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTotalPackagesQuantity(Quantity. Type newVal){
		TotalPackagesQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTotalTransportHandlingUnitQuantity(Quantity. Type newVal){
		TotalTransportHandlingUnitQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTransit Country(Country newVal){
		Transit Country = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTransport Advisor Party(Party newVal){
		Transport Advisor Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTransport Contract(Contract newVal){
		Transport Contract = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTransport Event(Transport Event newVal){
		m_Transport Event = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTransport Handling Unit(Transport Handling Unit newVal){
		m_Transport Handling Unit = newVal;
	}
}//end Consignment