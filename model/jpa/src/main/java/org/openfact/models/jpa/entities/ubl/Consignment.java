package org.openfact.models.jpa.entities.ubl;

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
    private Measure.Type ChargeableWeightMeasure;
    /**
     * The quantity of (consolidated) child consignments
     */
    private Quantity.Type ChildConsignmentQuantity;
    /**
     * An identifier for this consignment, assigned by the consignee.
     */
    private String ConsigneeAssignedID;
    /**
     * The count in this consignment considering goods items, child
     * consignments, shipments
     */
    private Quantity.Type ConsignmentQuantity;
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
    private Measure.Type GrossVolumeMeasure;
    /**
     * The total declared weight of the goods in this consignment, including
     * packaging but excluding the carrier's equipment.
     */
    private Measure.Type GrossWeightMeasure;
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
    private Measure.Type LoadingLengthMeasure;
    /**
     * An identifier for the loading sequence of this consignment.
     */
    private String LoadingSequenceID;
    /**
     * The total net weight of the goods in this consignment, exclusive of
     * packaging.
     */
    private Measure.Type NetNetWeightMeasure;
    /**
     * The total net volume of all goods items referred to as one consignment.
     */
    private Measure.Type NetVolumeMeasure;
    /**
     * The total net weight of all the goods items referred to as one
     * consignment.
     */
    private Measure.Type NetWeightMeasure;
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
    private Quantity.Type TotalGoodsItemQuantity;
    /**
     * The total of all invoice amounts declared in this consignment.
     */
    private BigDecimal TotalInvoiceAmount;
    /**
     * The total number of packages associated with a Consignment.
     */
    private Quantity.Type TotalPackagesQuantity;
    /**
     * The number of pieces of transport handling equipment (pallets, boxes,
     * cases, etc.) in this consignment.
     */
    private Quantity.Type TotalTransportHandlingUnitQuantity;
    private Allowance Charge
    Extra Allowance Charge;
    private Allowance Charge
    Freight Allowance Charge;
    private Contract Transport Contract;
    private Country Original
    Departure Country;
    private Country Final
    Destination Country;
    private Country Transit Country;
    private CustomsDeclaration
    m_CustomsDeclaration;
    private Delivery Terms
    m_Delivery Terms;
    private Location First
    Arrival Port Location;
    private Location Last
    Exit Port Location;
    private Party Bill
    Of Lading
    Holder Party;
    private Party Freight
    Forwarder Party;
    private Party Insurance Party;
    private Party Original
    Despatch Party;
    private Party Notify Party;
    private Party Carrier Party;
    private Party Importer Party;
    private Party Consignor Party;
    private Party Exporter Party;
    private Party Consignee Party;
    private Consignment Child Consignment;
    private Party Logistics
    Operator Party;
    private Party Mortgage
    Holder Party;
    private Party Hazardous
    Item Notification Party;
    private Party Transport
    Advisor Party;
    private Party Substitute
    Carrier Party;
    private Party Performing
    Carrier Party;
    private Party Final
    Delivery Party;
    private PaymentTerms
    Collect PaymentTerms;
    private PaymentTerms
    Disbursement PaymentTerms;
    private PaymentTerms
    Prepaid PaymentTerms;
    private PaymentTerms
    m_PaymentTerms;
    private Shipment Consolidated Shipment;
    private Shipment Stage
    On Carriage
    Shipment Stage;
    private Shipment Stage
    Pre Carriage
    Shipment Stage;
    private Shipment Stage
    Main Carriage
    Shipment Stage;
    private TransportEvent
    m_TransportEvent;
    private Transport Handling
    Unit m_Transport
    Handling Unit;
    private TransportationService
    Original Despatch
    TransportationService;
    private TransportationService
    Final Delivery
    TransportationService;
    private Status m_Status;
    private TransportEvent
    Requested Pickup
    TransportEvent;
    private TransportEvent
    Requested Delivery
    TransportEvent;
    private TransportEvent
    Planned Pickup
    TransportEvent;
    private TransportEvent
    Planned Delivery
    TransportEvent;

    public Consignment() {

    }

    public void finalize() throws Throwable {

    }

    public boolean getAnimalFoodIndicator() {
        return AnimalFoodIndicator;
    }

    public Party getBill
    Of Lading

    Holder Party(){
		return Bill Of Lading Holder Party;
	}

    public String getBrokerAssignedID() {
        return BrokerAssignedID;
    }

    public boolean getBulkCargoIndicator() {
        return BulkCargoIndicator;
    }

    public Party getCarrier

    Party(){
		return Carrier Party;
	}

    public String getCarrierAssignedID() {
        return CarrierAssignedID;
    }

    public String getCarrierServiceInstructions() {
        return CarrierServiceInstructions;
    }

    public Measure.Type getChargeableWeightMeasure() {
        return ChargeableWeightMeasure;
    }

    public Consignment getChild

    Consignment() {
        return Child Consignment;
    }

    public Quantity.Type getChildConsignmentQuantity() {
        return ChildConsignmentQuantity;
    }

    public PaymentTerms
    getCollect Payment

    Terms(){
		return Collect PaymentTerms;
	}

    public Party getConsignee

    Party(){
		return Consignee Party;
	}

    public String getConsigneeAssignedID() {
        return ConsigneeAssignedID;
    }

    public Quantity.Type getConsignmentQuantity() {
        return ConsignmentQuantity;
    }

    public Party getConsignor

    Party(){
		return Consignor Party;
	}

    public String getConsignorAssignedID() {
        return ConsignorAssignedID;
    }

    public boolean getConsolidatableIndicator() {
        return ConsolidatableIndicator;
    }

    public Shipment getConsolidated

    Shipment(){
		return Consolidated Shipment;
	}

    public boolean getContainerizedIndicator() {
        return ContainerizedIndicator;
    }

    public String getContractedCarrierAssignedID() {
        return ContractedCarrierAssignedID;
    }

    public CustomsDeclaration

    getCustomsDeclaration() {
        return m_CustomsDeclaration;
    }

    public String getCustomsClearanceServiceInstructions() {
        return CustomsClearanceServiceInstructions;
    }

    public BigDecimal getDeclaredCustomsValueAmount() {
        return DeclaredCustomsValueAmount;
    }

    public BigDecimal getDeclaredForCarriageValueAmount() {
        return DeclaredForCarriageValueAmount;
    }

    public BigDecimal getDeclaredStatisticsValueAmount() {
        return DeclaredStatisticsValueAmount;
    }

    public Delivery Terms

    getDelivery Terms() {
        return m_Delivery Terms;
    }

    public String getDeliveryInstructions() {
        return DeliveryInstructions;
    }

    public PaymentTerms
    getDisbursement Payment

    Terms(){
		return Disbursement PaymentTerms;
	}

    public Party getExporter

    Party(){
		return Exporter Party;
	}

    public Allowance Charge
    getExtra Allowance

    Charge(){
		return Extra Allowance Charge;
	}

    public Party getFinal

    Delivery Party() {
        return Final Delivery Party;
    }

    public TransportationService
    getFinal Delivery

    TransportationService(){
		return Final Delivery TransportationService;
	}

    public Country getFinal

    Destination Country() {
        return Final Destination Country;
    }

    public Location getFirst
    Arrival Port

    Location(){
		return First Arrival Port Location;
	}

    public String getForwarderServiceInstructions() {
        return ForwarderServiceInstructions;
    }

    public BigDecimal getFreeOnBoardValueAmount() {
        return FreeOnBoardValueAmount;
    }

    public Allowance Charge
    getFreight Allowance

    Charge(){
		return Freight Allowance Charge;
	}

    public Party getFreight

    Forwarder Party() {
        return Freight Forwarder Party;
    }

    public String getFreightForwarderAssignedID() {
        return FreightForwarderAssignedID;
    }

    public boolean getGeneralCargoIndicator() {
        return GeneralCargoIndicator;
    }

    public Measure.Type getGrossVolumeMeasure() {
        return GrossVolumeMeasure;
    }

    public Measure.Type getGrossWeightMeasure() {
        return GrossWeightMeasure;
    }

    public String getHandlingCode() {
        return HandlingCode;
    }

    public String getHandlingInstructions() {
        return HandlingInstructions;
    }

    public String getHaulageInstructions() {
        return HaulageInstructions;
    }

    public Party getHazardous
    Item Notification

    Party(){
		return Hazardous Item Notification Party;
	}

    public boolean getHazardousRiskIndicator() {
        return HazardousRiskIndicator;
    }

    public boolean getHumanFoodIndicator() {
        return HumanFoodIndicator;
    }

    public String getID() {
        return ID;
    }

    public Party getImporter

    Party(){
		return Importer Party;
	}

    public String getInformation() {
        return Information;
    }

    public Party getInsurance

    Party(){
		return Insurance Party;
	}

    public BigDecimal getInsurancePremiumAmount() {
        return InsurancePremiumAmount;
    }

    public BigDecimal getInsuranceValueAmount() {
        return InsuranceValueAmount;
    }

    public Location getLast
    Exit Port

    Location(){
		return Last Exit Port Location;
	}

    public boolean getLivestockIndicator() {
        return LivestockIndicator;
    }

    public Measure.Type getLoadingLengthMeasure() {
        return LoadingLengthMeasure;
    }

    public String getLoadingSequenceID() {
        return LoadingSequenceID;
    }

    public Party getLogistics

    Operator Party() {
        return Logistics Operator Party;
    }

    public Shipment Stage
    getMain Carriage

    Shipment Stage(){
		return Main Carriage Shipment Stage;
	}

    public Party getMortgage

    Holder Party() {
        return Mortgage Holder Party;
    }

    public Measure.Type getNetNetWeightMeasure() {
        return NetNetWeightMeasure;
    }

    public Measure.Type getNetVolumeMeasure() {
        return NetVolumeMeasure;
    }

    public Measure.Type getNetWeightMeasure() {
        return NetWeightMeasure;
    }

    public Party getNotify

    Party(){
		return Notify Party;
	}

    public Shipment Stage
    getOn Carriage

    Shipment Stage(){
		return On Carriage Shipment Stage;
	}

    public Country getOriginal

    Departure Country() {
        return Original Departure Country;
    }

    public Party getOriginal

    Despatch Party() {
        return Original Despatch Party;
    }

    public TransportationService
    getOriginal Despatch

    TransportationService(){
		return Original Despatch TransportationService;
	}

    public PaymentTerms

    getPaymentTerms() {
        return m_PaymentTerms;
    }

    public Party getPerforming

    Carrier Party() {
        return Performing Carrier Party;
    }

    public String getPerformingCarrierAssignedID() {
        return PerformingCarrierAssignedID;
    }

    public TransportEvent
    getPlanned Delivery

    TransportEvent(){
		return Planned Delivery TransportEvent;
	}

    public TransportEvent
    getPlanned Pickup

    TransportEvent(){
		return Planned Pickup TransportEvent;
	}

    public Shipment Stage
    getPre Carriage

    Shipment Stage(){
		return Pre Carriage Shipment Stage;
	}

    public PaymentTerms
    getPrepaid Payment

    Terms(){
		return Prepaid PaymentTerms;
	}

    public String getRemarks() {
        return Remarks;
    }

    public TransportEvent
    getRequested Delivery

    TransportEvent(){
		return Requested Delivery TransportEvent;
	}

    public TransportEvent
    getRequested Pickup

    TransportEvent() {
        return Requested Pickup TransportEvent;
    }

    public String getSequenceID() {
        return SequenceID;
    }

    public String getShippingPriorityLevelCode() {
        return ShippingPriorityLevelCode;
    }

    public String getSpecialInstructions() {
        return SpecialInstructions;
    }

    public boolean getSpecialSecurityIndicator() {
        return SpecialSecurityIndicator;
    }

    public String getSpecialServiceInstructions() {
        return SpecialServiceInstructions;
    }

    public boolean getSplitConsignmentIndicator() {
        return SplitConsignmentIndicator;
    }

    public Status getStatus() {
        return m_Status;
    }

    public Party getSubstitute

    Carrier Party() {
        return Substitute Carrier Party;
    }

    public String getSummaryDescription() {
        return SummaryDescription;
    }

    public String getTariffCode() {
        return TariffCode;
    }

    public String getTariffDescription() {
        return TariffDescription;
    }

    public boolean getThirdPartyPayerIndicator() {
        return ThirdPartyPayerIndicator;
    }

    public Quantity.Type getTotalGoodsItemQuantity() {
        return TotalGoodsItemQuantity;
    }

    public BigDecimal getTotalInvoiceAmount() {
        return TotalInvoiceAmount;
    }

    public Quantity.Type getTotalPackagesQuantity() {
        return TotalPackagesQuantity;
    }

    public Quantity.Type getTotalTransportHandlingUnitQuantity() {
        return TotalTransportHandlingUnitQuantity;
    }

    public Country getTransit

    Country(){
		return Transit Country;
	}

    public Party getTransport

    Advisor Party() {
        return Transport Advisor Party;
    }

    public Contract getTransport

    Contract(){
		return Transport Contract;
	}

    public TransportEvent

    getTransportEvent() {
        return m_TransportEvent;
    }

    public Transport Handling
    Unit getTransport

    Handling Unit() {
        return m_Transport Handling Unit;
    }

    /**
     * 
     * @param newVal
     */
    public void setAnimalFoodIndicator(boolean newVal) {
        AnimalFoodIndicator = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setBill
    Of Lading

    Holder Party(Party newVal) {
        Bill Of Lading Holder Party=newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setBrokerAssignedID(String newVal) {
        BrokerAssignedID = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setBulkCargoIndicator(boolean newVal) {
        BulkCargoIndicator = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setCarrier

    Party(Party newVal){
		Carrier Party = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setCarrierAssignedID(String newVal) {
        CarrierAssignedID = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setCarrierServiceInstructions(String newVal) {
        CarrierServiceInstructions = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setChargeableWeightMeasure(Measure.Type newVal) {
        ChargeableWeightMeasure = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setChild

    Consignment(Consignment newVal) {
        Child Consignment = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setChildConsignmentQuantity(Quantity.Type newVal) {
        ChildConsignmentQuantity = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setCollect

    PaymentTerms(PaymentTerms newVal) {
        Collect PaymentTerms=newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setConsignee

    Party(Party newVal){
		Consignee Party = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setConsigneeAssignedID(String newVal) {
        ConsigneeAssignedID = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setConsignmentQuantity(Quantity.Type newVal) {
        ConsignmentQuantity = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setConsignor

    Party(Party newVal){
		Consignor Party = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setConsignorAssignedID(String newVal) {
        ConsignorAssignedID = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setConsolidatableIndicator(boolean newVal) {
        ConsolidatableIndicator = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setConsolidated

    Shipment(Shipment newVal){
		Consolidated Shipment = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setContainerizedIndicator(boolean newVal) {
        ContainerizedIndicator = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setContractedCarrierAssignedID(String newVal) {
        ContractedCarrierAssignedID = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setCustoms

    Declaration(CustomsDeclaration newVal){
		m_CustomsDeclaration = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setCustomsClearanceServiceInstructions(String newVal) {
        CustomsClearanceServiceInstructions = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setDeclaredCustomsValueAmount(BigDecimal newVal) {
        DeclaredCustomsValueAmount = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setDeclaredForCarriageValueAmount(BigDecimal newVal) {
        DeclaredForCarriageValueAmount = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setDeclaredStatisticsValueAmount(BigDecimal newVal) {
        DeclaredStatisticsValueAmount = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setDelivery

    Terms(Delivery Terms newVal){
		m_Delivery Terms = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setDeliveryInstructions(String newVal) {
        DeliveryInstructions = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setDisbursement

    PaymentTerms(PaymentTerms newVal) {
        Disbursement PaymentTerms=newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setExporter

    Party(Party newVal){
		Exporter Party = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setExtra

    Allowance Charge(Allowance Charge newVal) {
        Extra Allowance Charge=newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setFinal

    Delivery Party(Party newVal) {
        Final Delivery Party=newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setFinal
    Delivery Transportation

    Service(TransportationService newVal){
		Final Delivery TransportationService = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setFinal

    Destination Country(Country newVal) {
        Final Destination Country=newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setFirst
    Arrival Port

    Location(Location newVal){
		First Arrival Port Location = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setForwarderServiceInstructions(String newVal) {
        ForwarderServiceInstructions = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setFreeOnBoardValueAmount(BigDecimal newVal) {
        FreeOnBoardValueAmount = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setFreight

    Allowance Charge(Allowance Charge newVal) {
        Freight Allowance Charge=newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setFreight

    Forwarder Party(Party newVal) {
        Freight Forwarder Party=newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setFreightForwarderAssignedID(String newVal) {
        FreightForwarderAssignedID = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setGeneralCargoIndicator(boolean newVal) {
        GeneralCargoIndicator = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setGrossVolumeMeasure(Measure.Type newVal) {
        GrossVolumeMeasure = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setGrossWeightMeasure(Measure.Type newVal) {
        GrossWeightMeasure = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setHandlingCode(String newVal) {
        HandlingCode = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setHandlingInstructions(String newVal) {
        HandlingInstructions = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setHaulageInstructions(String newVal) {
        HaulageInstructions = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setHazardous
    Item Notification

    Party(Party newVal){
		Hazardous Item Notification Party = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setHazardousRiskIndicator(boolean newVal) {
        HazardousRiskIndicator = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setHumanFoodIndicator(boolean newVal) {
        HumanFoodIndicator = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setID(String newVal) {
        ID = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setImporter

    Party(Party newVal){
		Importer Party = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setInformation(String newVal) {
        Information = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setInsurance

    Party(Party newVal){
		Insurance Party = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setInsurancePremiumAmount(BigDecimal newVal) {
        InsurancePremiumAmount = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setInsuranceValueAmount(BigDecimal newVal) {
        InsuranceValueAmount = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setLast
    Exit Port

    Location(Location newVal){
		Last Exit Port Location = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setLivestockIndicator(boolean newVal) {
        LivestockIndicator = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setLoadingLengthMeasure(Measure.Type newVal) {
        LoadingLengthMeasure = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setLoadingSequenceID(String newVal) {
        LoadingSequenceID = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setLogistics

    Operator Party(Party newVal) {
        Logistics Operator Party=newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setMain
    Carriage Shipment

    Stage(Shipment Stage newVal){
		Main Carriage Shipment Stage = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setMortgage

    Holder Party(Party newVal) {
        Mortgage Holder Party=newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setNetNetWeightMeasure(Measure.Type newVal) {
        NetNetWeightMeasure = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setNetVolumeMeasure(Measure.Type newVal) {
        NetVolumeMeasure = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setNetWeightMeasure(Measure.Type newVal) {
        NetWeightMeasure = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setNotify

    Party(Party newVal){
		Notify Party = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setOn
    Carriage Shipment

    Stage(Shipment Stage newVal){
		On Carriage Shipment Stage = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setOriginal

    Departure Country(Country newVal) {
        Original Departure Country=newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setOriginal

    Despatch Party(Party newVal) {
        Original Despatch Party=newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setOriginal
    Despatch Transportation

    Service(TransportationService newVal){
		Original Despatch TransportationService = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setPayment

    Terms(PaymentTerms newVal){
		m_PaymentTerms = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setPerforming

    Carrier Party(Party newVal) {
        Performing Carrier Party=newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setPerformingCarrierAssignedID(String newVal) {
        PerformingCarrierAssignedID = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setPlanned
    Delivery Transport

    Event(TransportEvent newVal){
		Planned Delivery TransportEvent = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setPlanned
    Pickup Transport

    Event(TransportEvent newVal){
		Planned Pickup TransportEvent = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setPre
    Carriage Shipment

    Stage(Shipment Stage newVal){
		Pre Carriage Shipment Stage = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setPrepaid

    PaymentTerms(PaymentTerms newVal) {
        Prepaid PaymentTerms=newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setRemarks(String newVal) {
        Remarks = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setRequested
    Delivery Transport

    Event(TransportEvent newVal){
		Requested Delivery TransportEvent = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setRequested
    Pickup Transport

    Event(TransportEvent newVal){
		Requested Pickup TransportEvent = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setSequenceID(String newVal) {
        SequenceID = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setShippingPriorityLevelCode(String newVal) {
        ShippingPriorityLevelCode = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setSpecialInstructions(String newVal) {
        SpecialInstructions = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setSpecialSecurityIndicator(boolean newVal) {
        SpecialSecurityIndicator = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setSpecialServiceInstructions(String newVal) {
        SpecialServiceInstructions = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setSplitConsignmentIndicator(boolean newVal) {
        SplitConsignmentIndicator = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setStatus(Status newVal) {
        m_Status = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setSubstitute

    Carrier Party(Party newVal) {
        Substitute Carrier Party=newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setSummaryDescription(String newVal) {
        SummaryDescription = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setTariffCode(String newVal) {
        TariffCode = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setTariffDescription(String newVal) {
        TariffDescription = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setThirdPartyPayerIndicator(boolean newVal) {
        ThirdPartyPayerIndicator = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setTotalGoodsItemQuantity(Quantity.Type newVal) {
        TotalGoodsItemQuantity = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setTotalInvoiceAmount(BigDecimal newVal) {
        TotalInvoiceAmount = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setTotalPackagesQuantity(Quantity.Type newVal) {
        TotalPackagesQuantity = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setTotalTransportHandlingUnitQuantity(Quantity.Type newVal) {
        TotalTransportHandlingUnitQuantity = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setTransit

    Country(Country newVal){
		Transit Country = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setTransport

    Advisor Party(Party newVal) {
        Transport Advisor Party=newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setTransport

    Contract(Contract newVal){
		Transport Contract = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setTransport

    Event(TransportEvent newVal){
		m_TransportEvent = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setTransport

    Handling Unit(Transport Handling Unit newVal) {
        m_Transport Handling Unit=newVal;}
}// end Consignment