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
public class ConsignmentModel{

	/**
	 * An indication that the transported goods in this consignment are animal
	 * foodstuffs (true) or not (false).
	 */
	private boolean animalFoodIndicator; 
	/**
	 * An identifier for this consignment, assigned by the broker.
	 */
	private IdentifierType brokerAssignedID; 
	/**
	 * An indication that the transported goods in this consignment are bulk cargoes
	 * (true) or not (false).
	 */
	private boolean bulkCargoIndicator; 
	/**
	 * An identifier for this consignment, assigned by the carrier.
	 */
	private IdentifierType carrierAssignedID; 
	/**
	 * Service instructions to the carrier, expressed as text.
	 */
	private TextType carrierServiceInstructions; 
	/**
	 * The weight upon which a charge is to be based.
	 */
	private MeasureType chargeableWeightMeasure; 
	/**
	 * The quantity of (consolidated) child consignments
	 */
	private QuantityType childConsignmentQuantity; 
	/**
	 * An identifier for this consignment, assigned by the consignee.
	 */
	private IdentifierType consigneeAssignedID; 
	/**
	 * The count in this consignment considering goods items, child consignments,
	 * shipments
	 */
	private QuantityType consignmentQuantity; 
	/**
	 * An identifier for this consignment, assigned by the consignor.
	 */
	private IdentifierType consignorAssignedID; 
	/**
	 * An indicator that this consignment can be consolidated (true) or not (false).
	 */
	private boolean consolidatableIndicator; 
	/**
	 * An indication that the transported goods in this consignment are containerized
	 * cargoes (true) or not (false).
	 */
	private boolean containerizedIndicator; 
	/**
	 * An identifier for this consignment, assigned by the contracted carrier.
	 */
	private IdentifierType contractedCarrierAssignedID; 
	/**
	 * Service instructions for customs clearance, expressed as text.
	 */
	private TextType customsClearanceServiceInstructions; 
	/**
	 * The total declared value for customs purposes of all the goods in this
	 * consignment, regardless of whether they are subject to the same customs
	 * procedure, tariff/statistical categorization, country information, or duty
	 * regime.
	 */
	private BigDecimal declaredCustomsValueAmount; 
	/**
	 * The value of this consignment, declared by the shipper or his agent solely for
	 * the purpose of varying the carrier's level of liability from that provided in
	 * the contract of carriage, in case of loss or damage to goods or delayed
	 * delivery.
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
	private TextType deliveryInstructions; 
	/**
	 * Service instructions for the forwarder, expressed as text.
	 */
	private TextType forwarderServiceInstructions; 
	/**
	 * The monetary amount that has to be or has been paid as calculated under the
	 * applicable trade delivery.
	 */
	private BigDecimal freeOnBoardValueAmount; 
	/**
	 * An identifier for this consignment, assigned by the freight forwarder.
	 */
	private IdentifierType freightForwarderAssignedID; 
	/**
	 * An indication that the transported goods in this consignment are general
	 * cargoes (true) or not (false).
	 */
	private boolean generalCargoIndicator; 
	/**
	 * The total volume of the goods referred to as one consignment.
	 */
	private MeasureType grossVolumeMeasure; 
	/**
	 * The total declared weight of the goods in this consignment, including packaging
	 * but excluding the carrier's equipment.
	 */
	private MeasureType grossWeightMeasure; 
	/**
	 * The handling required for this consignment, expressed as a code.
	 */
	private CodeType handlingCode; 
	/**
	 * The handling required for this consignment, expressed as text.
	 */
	private TextType handlingInstructions; 
	/**
	 * Instructions regarding haulage of this consignment, expressed as text.
	 */
	private TextType haulageInstructions; 
	/**
	 * An indication that the transported goods in this consignment are subject to an
	 * international regulation concerning the carriage of dangerous goods (true) or
	 * not (false).
	 */
	private boolean hazardousRiskIndicator; 
	/**
	 * An indication that the transported goods in this consignment are for human
	 * consumption (true) or not (false).
	 */
	private boolean humanFoodIndicator; 
	/**
	 * An identifier assigned to a collection of goods for both import and export.
	 */
	private IdentifierType ID; 
	/**
	 * Free-form text pertinent to this consignment, conveying information that is not
	 * contained explicitly in other structures.
	 */
	private TextType information; 
	/**
	 * The amount of the premium payable to an insurance company for insuring the
	 * goods contained in this consignment.
	 */
	private BigDecimal insurancePremiumAmount; 
	/**
	 * The amount covered by insurance for this consignment.
	 */
	private BigDecimal insuranceValueAmount; 
	/**
	 * An indication that the transported goods are livestock (true) or not (false).
	 */
	private boolean livestockIndicator; 
	/**
	 * The total length in a means of transport or a piece of transport equipment
	 * which, given the width and height of the transport means, will accommodate all
	 * of the consignments in a single consolidation.
	 */
	private MeasureType loadingLengthMeasure; 
	/**
	 * An identifier for the loading sequence of this consignment.
	 */
	private IdentifierType loadingSequenceID; 
	/**
	 * The total net weight of the goods in this consignment, exclusive of packaging.
	 */
	private MeasureType netNetWeightMeasure; 
	/**
	 * The total net volume of all goods items referred to as one consignment.
	 */
	private MeasureType netVolumeMeasure; 
	/**
	 * The total net weight of all the goods items referred to as one consignment.
	 */
	private MeasureType netWeightMeasure; 
	/**
	 * An identifier for this consignment, assigned by the performing carrier.
	 */
	private IdentifierType performingCarrierAssignedID; 
	/**
	 * remarks concerning the complete consignment, to be printed on the transport
	 * document.
	 */
	private TextType remarks; 
	/**
	 * A sequence identifier for this consignment.
	 */
	private IdentifierType sequenceID; 
	/**
	 * A code signifying the priority or level of service required for this
	 * consignment.
	 */
	private CodeType shippingPriorityLevelCode; 
	/**
	 * Special instructions relating to this consignment.
	 */
	private TextType specialInstructions; 
	/**
	 * An indication that the transported goods in this consignment require special
	 * security (true) or not (false).
	 */
	private boolean specialSecurityIndicator; 
	/**
	 * Special service instructions, expressed as text.
	 */
	private TextType specialServiceInstructions; 
	/**
	 * An indicator that this consignment has been split in transit (true) or not
	 * (false).
	 */
	private boolean splitConsignmentIndicator; 
	/**
	 * A textual summary description of the consignment.
	 */
	private TextType summaryDescription; 
	/**
	 * A code signifying the tariff applied to this consignment.
	 */
	private CodeType tariffCode; 
	/**
	 * Text describing the tariff applied to this consignment.
	 */
	private TextType tariffDescription; 
	/**
	 * An indication that this consignment will be paid for by a third party (true) or
	 * not (false).
	 */
	private boolean thirdPartyPayerIndicator; 
	/**
	 * The total number of goods items in this consignment.
	 */
	private QuantityType totalGoodsItemQuantity; 
	/**
	 * The total of all invoice amounts declared in this consignment.
	 */
	private BigDecimal totalInvoiceAmount; 
	/**
	 * The total number of packages associated with a Consignment.
	 */
	private QuantityType totalPackagesQuantity; 
	/**
	 * The number of pieces of transport handling equipment (pallets, boxes, cases,
	 * etc.) in this consignment.
	 */
	private QuantityType totalTransportHandlingUnitQuantity; 
	private AllowanceChargeModel extraAllowanceCharge; 
	private AllowanceChargeModel freightAllowanceCharge; 
	private ContractModel transportContract; 
	private CountryModel originalDepartureCountry; 
	private CountryModel finalDestinationCountry; 
	private CountryModel transitCountry; 
	private List<CustomsDeclarationModel> customsDeclarations = new ArrayList<>(); 
	private List<DeliveryTermsModel> deliveryTermses = new ArrayList<>(); 
	private LocationModel firstArrivalPortLocation; 
	private LocationModel lastExitPortLocation; 
	private PartyModel billOfLadingHolderParty; 
	private PartyModel freightForwarderParty; 
	private PartyModel insuranceParty; 
	private PartyModel originalDespatchParty; 
	private PartyModel notifyParty; 
	private PartyModel carrierParty; 
	private PartyModel importerParty; 
	private PartyModel consignorParty; 
	private PartyModel exporterParty; 
	private PartyModel consigneeParty; 
	private ConsignmentModel childConsignment; 
	private PartyModel logisticsOperatorParty; 
	private PartyModel mortgageHolderParty; 
	private PartyModel hazardousItemNotificationParty; 
	private PartyModel transportAdvisorParty; 
	private PartyModel substituteCarrierParty; 
	private PartyModel performingCarrierParty; 
	private PartyModel finalDeliveryParty; 
	private List<PaymentTermsModel> collectPaymentTerms = new ArrayList<>(); 
	private List<PaymentTermsModel> disbursementPaymentTerms = new ArrayList<>(); 
	private List<PaymentTermsModel> prepaidPaymentTerms = new ArrayList<>(); 
	private List<PaymentTermsModel> paymentTermses = new ArrayList<>(); 
	private ShipmentModel consolidatedShipment; 
	private ShipmentStageModel onCarriageShipmentStage; 
	private ShipmentStageModel preCarriageShipmentStage; 
	private ShipmentStageModel mainCarriageShipmentStage; 
	private List<TransportEventModel> transportEvents = new ArrayList<>(); 
	private List<TransportHandlingUnitModel> transportHandlingUnits = new ArrayList<>(); 
	private TransportationServiceModel originalDespatchTransportationService; 
	private TransportationServiceModel finalDeliveryTransportationService; 
	private List<StatusModel> statuses = new ArrayList<>(); 
	private List<TransportEventModel> requestedPickupTransportEvent = new ArrayList<>(); 
	private List<TransportEventModel> requestedDeliveryTransportEvent = new ArrayList<>(); 
	private List<TransportEventModel> plannedPickupTransportEvent = new ArrayList<>(); 
	private List<TransportEventModel> plannedDeliveryTransportEvent = new ArrayList<>(); 

}
