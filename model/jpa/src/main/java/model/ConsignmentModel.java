package model;
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
public class ConsignmentModel{

	/**
	 * An indication that the transported goods in this consignment are animal
	 * foodstuffs (true) or not (false).
	 */
	private IndicatorType AnimalFoodIndicator;
	/**
	 * An identifier for this consignment, assigned by the broker.
	 */
	private IdentifierType BrokerAssignedID;
	/**
	 * An indication that the transported goods in this consignment are bulk cargoes
	 * (true) or not (false).
	 */
	private IndicatorType BulkCargoIndicator;
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
	private IndicatorType ConsolidatableIndicator;
	/**
	 * An indication that the transported goods in this consignment are containerized
	 * cargoes (true) or not (false).
	 */
	private IndicatorType ContainerizedIndicator;
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
	private AmountType DeclaredCustomsValueAmount;
	/**
	 * The value of this consignment, declared by the shipper or his agent solely for
	 * the purpose of varying the carrier's level of liability from that provided in
	 * the contract of carriage, in case of loss or damage to goods or delayed
	 * delivery.
	 */
	private AmountType DeclaredForCarriageValueAmount;
	/**
	 * The value, declared for statistical purposes, of those goods in this
	 * consignment that have the same statistical heading.
	 */
	private AmountType DeclaredStatisticsValueAmount;
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
	private AmountType FreeOnBoardValueAmount;
	/**
	 * An identifier for this consignment, assigned by the freight forwarder.
	 */
	private IdentifierType FreightForwarderAssignedID;
	/**
	 * An indication that the transported goods in this consignment are general
	 * cargoes (true) or not (false).
	 */
	private IndicatorType GeneralCargoIndicator;
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
	private IndicatorType HazardousRiskIndicator;
	/**
	 * An indication that the transported goods in this consignment are for human
	 * consumption (true) or not (false).
	 */
	private IndicatorType HumanFoodIndicator;
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
	private AmountType InsurancePremiumAmount;
	/**
	 * The amount covered by insurance for this consignment.
	 */
	private AmountType InsuranceValueAmount;
	/**
	 * An indication that the transported goods are livestock (true) or not (false).
	 */
	private IndicatorType LivestockIndicator;
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
	private IndicatorType SpecialSecurityIndicator;
	/**
	 * Special service instructions, expressed as text.
	 */
	private TextType SpecialServiceInstructions;
	/**
	 * An indicator that this consignment has been split in transit (true) or not
	 * (false).
	 */
	private IndicatorType SplitConsignmentIndicator;
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
	private IndicatorType ThirdPartyPayerIndicator;
	/**
	 * The total number of goods items in this consignment.
	 */
	private QuantityType TotalGoodsItemQuantity;
	/**
	 * The total of all invoice amounts declared in this consignment.
	 */
	private AmountType TotalInvoiceAmount;
	/**
	 * The total number of packages associated with a Consignment.
	 */
	private QuantityType TotalPackagesQuantity;
	/**
	 * The number of pieces of transport handling equipment (pallets, boxes, cases,
	 * etc.) in this consignment.
	 */
	private QuantityType TotalTransportHandlingUnitQuantity;
	private AllowanceChargeModel ExtraAllowanceCharge;
	private AllowanceChargeModel FreightAllowanceCharge;
	private ContractModel TransportContract;
	private CountryModel OriginalDepartureCountry;
	private CountryModel FinalDestinationCountry;
	private CountryModel TransitCountry;
	private List<CustomsDeclarationModel> CustomsDeclarations = new ArrayList<>();
	private List<DeliveryTermsModel> DeliveryTermses = new ArrayList<>();
	private LocationModel FirstArrivalPortLocation;
	private LocationModel LastExitPortLocation;
	private PartyModel BillOfLadingHolderParty;
	private PartyModel FreightForwarderParty;
	private PartyModel InsuranceParty;
	private PartyModel OriginalDespatchParty;
	private PartyModel NotifyParty;
	private PartyModel CarrierParty;
	private PartyModel ImporterParty;
	private PartyModel ConsignorParty;
	private PartyModel ExporterParty;
	private PartyModel ConsigneeParty;
	private ConsignmentModel ChildConsignment;
	private PartyModel LogisticsOperatorParty;
	private PartyModel MortgageHolderParty;
	private PartyModel HazardousItemNotificationParty;
	private PartyModel TransportAdvisorParty;
	private PartyModel SubstituteCarrierParty;
	private PartyModel PerformingCarrierParty;
	private PartyModel FinalDeliveryParty;
	private List<PaymentTermsModel> CollectPaymentTerms = new ArrayList<>();
	private List<PaymentTermsModel> DisbursementPaymentTerms = new ArrayList<>();
	private List<PaymentTermsModel> PrepaidPaymentTerms = new ArrayList<>();
	private List<PaymentTermsModel> PaymentTermses = new ArrayList<>();
	private ShipmentModel ConsolidatedShipment;
	private ShipmentStageModel OnCarriageShipmentStage;
	private ShipmentStageModel PreCarriageShipmentStage;
	private ShipmentStageModel MainCarriageShipmentStage;
	private List<TransportEventModel> TransportEvents = new ArrayList<>();
	private List<TransportHandlingUnitModel> TransportHandlingUnits = new ArrayList<>();
	private TransportationServiceModel OriginalDespatchTransportationService;
	private TransportationServiceModel FinalDeliveryTransportationService;
	private List<StatusModel> Statuses = new ArrayList<>();
	private List<TransportEventModel> RequestedPickupTransportEvent = new ArrayList<>();
	private List<TransportEventModel> RequestedDeliveryTransportEvent = new ArrayList<>();
	private List<TransportEventModel> PlannedPickupTransportEvent = new ArrayList<>();
	private List<TransportEventModel> PlannedDeliveryTransportEvent = new ArrayList<>();

}
