package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe an identifiable collection of one or more goods items to be
 * transported between the consignor and the consignee. This information may be
 * defined within a transport contract. A consignment may comprise more than one
 * shipment (e.g., when
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:44 a. m.
 */
public class Consignment{

	/**
	 * An indication that the transported goods in this consignment are animal
	 * foodstuffs (true) or not (false).
	 */
	private boolean AnimalFoodIndicator;
	/**
	 * An identifier for this consignment, assigned by the broker.
	 */
	private IdentifierType BrokerAssignedID;
	/**
	 * An indication that the transported goods in this consignment are bulk cargoes
	 * (true) or not (false).
	 */
	private boolean BulkCargoIndicator;
	/**
	 * An identifier for this consignment, assigned by the carrier.
	 */
	private IdentifierType CarrierAssignedID;
	/**
	 * Service instructions to the carrier, expressed as text.
	 */
	private TextType CarrierServiceInstructions;
	/**
	 * The weight upon which a charge is to be based.
	 */
	private MeasureType ChargeableWeightMeasure;
	/**
	 * The quantity of (consolidated) child consignments
	 */
	private QuantityType ChildConsignmentQuantity;
	/**
	 * An identifier for this consignment, assigned by the consignee.
	 */
	private IdentifierType ConsigneeAssignedID;
	/**
	 * The count in this consignment considering goods items, child consignments,
	 * shipments
	 */
	private QuantityType ConsignmentQuantity;
	/**
	 * An identifier for this consignment, assigned by the consignor.
	 */
	private IdentifierType ConsignorAssignedID;
	/**
	 * An indicator that this consignment can be consolidated (true) or not (false).
	 */
	private boolean ConsolidatableIndicator;
	/**
	 * An indication that the transported goods in this consignment are containerized
	 * cargoes (true) or not (false).
	 */
	private boolean ContainerizedIndicator;
	/**
	 * An identifier for this consignment, assigned by the contracted carrier.
	 */
	private IdentifierType ContractedCarrierAssignedID;
	/**
	 * Service instructions for customs clearance, expressed as text.
	 */
	private TextType CustomsClearanceServiceInstructions;
	/**
	 * The total declared value for customs purposes of all the goods in this
	 * consignment, regardless of whether they are subject to the same customs
	 * procedure, tariff/statistical categorization, country information, or duty
	 * regime.
	 */
	private BigDecimal DeclaredCustomsValueAmount;
	/**
	 * The value of this consignment, declared by the shipper or his agent solely for
	 * the purpose of varying the carrier's level of liability from that provided in
	 * the contract of carriage, in case of loss or damage to goods or delayed
	 * delivery.
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
	private TextType DeliveryInstructions;
	/**
	 * Service instructions for the forwarder, expressed as text.
	 */
	private TextType ForwarderServiceInstructions;
	/**
	 * The monetary amount that has to be or has been paid as calculated under the
	 * applicable trade delivery.
	 */
	private BigDecimal FreeOnBoardValueAmount;
	/**
	 * An identifier for this consignment, assigned by the freight forwarder.
	 */
	private IdentifierType FreightForwarderAssignedID;
	/**
	 * An indication that the transported goods in this consignment are general
	 * cargoes (true) or not (false).
	 */
	private boolean GeneralCargoIndicator;
	/**
	 * The total volume of the goods referred to as one consignment.
	 */
	private MeasureType GrossVolumeMeasure;
	/**
	 * The total declared weight of the goods in this consignment, including packaging
	 * but excluding the carrier's equipment.
	 */
	private MeasureType GrossWeightMeasure;
	/**
	 * The handling required for this consignment, expressed as a code.
	 */
	private CodeType HandlingCode;
	/**
	 * The handling required for this consignment, expressed as text.
	 */
	private TextType HandlingInstructions;
	/**
	 * Instructions regarding haulage of this consignment, expressed as text.
	 */
	private TextType HaulageInstructions;
	/**
	 * An indication that the transported goods in this consignment are subject to an
	 * international regulation concerning the carriage of dangerous goods (true) or
	 * not (false).
	 */
	private boolean HazardousRiskIndicator;
	/**
	 * An indication that the transported goods in this consignment are for human
	 * consumption (true) or not (false).
	 */
	private boolean HumanFoodIndicator;
	/**
	 * An identifier assigned to a collection of goods for both import and export.
	 */
	private IdentifierType ID;
	/**
	 * Free-form text pertinent to this consignment, conveying information that is not
	 * contained explicitly in other structures.
	 */
	private TextType Information;
	/**
	 * The amount of the premium payable to an insurance company for insuring the
	 * goods contained in this consignment.
	 */
	private BigDecimal InsurancePremiumAmount;
	/**
	 * The amount covered by insurance for this consignment.
	 */
	private BigDecimal InsuranceValueAmount;
	/**
	 * An indication that the transported goods are livestock (true) or not (false).
	 */
	private boolean LivestockIndicator;
	/**
	 * The total length in a means of transport or a piece of transport equipment
	 * which, given the width and height of the transport means, will accommodate all
	 * of the consignments in a single consolidation.
	 */
	private MeasureType LoadingLengthMeasure;
	/**
	 * An identifier for the loading sequence of this consignment.
	 */
	private IdentifierType LoadingSequenceID;
	/**
	 * The total net weight of the goods in this consignment, exclusive of packaging.
	 */
	private MeasureType NetNetWeightMeasure;
	/**
	 * The total net volume of all goods items referred to as one consignment.
	 */
	private MeasureType NetVolumeMeasure;
	/**
	 * The total net weight of all the goods items referred to as one consignment.
	 */
	private MeasureType NetWeightMeasure;
	/**
	 * An identifier for this consignment, assigned by the performing carrier.
	 */
	private IdentifierType PerformingCarrierAssignedID;
	/**
	 * Remarks concerning the complete consignment, to be printed on the transport
	 * document.
	 */
	private TextType Remarks;
	/**
	 * A sequence identifier for this consignment.
	 */
	private IdentifierType SequenceID;
	/**
	 * A code signifying the priority or level of service required for this
	 * consignment.
	 */
	private CodeType ShippingPriorityLevelCode;
	/**
	 * Special instructions relating to this consignment.
	 */
	private TextType SpecialInstructions;
	/**
	 * An indication that the transported goods in this consignment require special
	 * security (true) or not (false).
	 */
	private boolean SpecialSecurityIndicator;
	/**
	 * Special service instructions, expressed as text.
	 */
	private TextType SpecialServiceInstructions;
	/**
	 * An indicator that this consignment has been split in transit (true) or not
	 * (false).
	 */
	private boolean SplitConsignmentIndicator;
	/**
	 * A textual summary description of the consignment.
	 */
	private TextType SummaryDescription;
	/**
	 * A code signifying the tariff applied to this consignment.
	 */
	private CodeType TariffCode;
	/**
	 * Text describing the tariff applied to this consignment.
	 */
	private TextType TariffDescription;
	/**
	 * An indication that this consignment will be paid for by a third party (true) or
	 * not (false).
	 */
	private boolean ThirdPartyPayerIndicator;
	/**
	 * The total number of goods items in this consignment.
	 */
	private QuantityType TotalGoodsItemQuantity;
	/**
	 * The total of all invoice amounts declared in this consignment.
	 */
	private BigDecimal TotalInvoiceAmount;
	/**
	 * The total number of packages associated with a Consignment.
	 */
	private QuantityType TotalPackagesQuantity;
	/**
	 * The number of pieces of transport handling equipment (pallets, boxes, cases,
	 * etc.) in this consignment.
	 */
	private QuantityType TotalTransportHandlingUnitQuantity;
	private AllowanceCharge ExtraAllowanceCharge;
	private AllowanceCharge FreightAllowanceCharge;
	private Contract TransportContract;
	private Country OriginalDepartureCountry;
	private Country FinalDestinationCountry;
	private Country TransitCountry;
	private List<CustomsDeclaration> CustomsDeclarations = new ArrayList<>();
	private List<DeliveryTerms> DeliveryTermses = new ArrayList<>();
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
	private List<PaymentTerms> CollectPaymentTerms = new ArrayList<>();
	private List<PaymentTerms> DisbursementPaymentTerms = new ArrayList<>();
	private List<PaymentTerms> PrepaidPaymentTerms = new ArrayList<>();
	private List<PaymentTerms> PaymentTermses = new ArrayList<>();
	private Shipment ConsolidatedShipment;
	private ShipmentStage OnCarriageShipmentStage;
	private ShipmentStage PreCarriageShipmentStage;
	private ShipmentStage MainCarriageShipmentStage;
	private List<TransportEvent> TransportEvents = new ArrayList<>();
	private List<TransportHandlingUnit> TransportHandlingUnits = new ArrayList<>();
	private TransportationService OriginalDespatchTransportationService;
	private TransportationService FinalDeliveryTransportationService;
	private List<Status> Statuses = new ArrayList<>();
	private List<TransportEvent> RequestedPickupTransportEvent = new ArrayList<>();
	private List<TransportEvent> RequestedDeliveryTransportEvent = new ArrayList<>();
	private List<TransportEvent> PlannedPickupTransportEvent = new ArrayList<>();
	private List<TransportEvent> PlannedDeliveryTransportEvent = new ArrayList<>();

}
