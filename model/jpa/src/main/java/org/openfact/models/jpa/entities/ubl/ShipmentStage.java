package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A class to describe one stage of movement in a transport of goods.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:17:45 a. m.
 */
public class ShipmentStage {

	/**
	 * The total number of crew aboard a transport means.
	 */
	private BigDecimal CrewQuantity;
	/**
	 * Text of instructions relating to demurrage (the case in which a vessel is
	 * prevented from loading or discharging cargo within the stipulated
	 * laytime).
	 */
	private String DemurrageInstructions;
	/**
	 * The estimated date of delivery in this shipment stage.
	 */
	private LocalDate EstimatedDeliveryDate;
	/**
	 * The estimated time of delivery in this shipment stage.
	 */
	private LocalTime EstimatedDeliveryTime;
	/**
	 * An identifier for this shipment stage.
	 */
	private String ID;
	/**
	 * Text of instructions applicable to a shipment stage.
	 */
	private String Instructions;
	/**
	 * An identifier for the loading sequence (of consignments) associated with
	 * this shipment stage.
	 */
	private String LoadingSequenceID;
	/**
	 * An indicator that this stage takes place after the main carriage of the
	 * shipment (true) or not (false).
	 */
	private boolean OnCarriageIndicator;
	/**
	 * The total number of passengers aboard a transport means.
	 */
	private BigDecimal PassengerQuantity;
	/**
	 * An indicator that this stage takes place before the main carriage of the
	 * shipment (true) or not (false).
	 */
	private boolean PreCarriageIndicator;
	/**
	 * The delivery date required by the buyer in this shipment stage.
	 */
	private LocalDate RequiredDeliveryDate;
	/**
	 * The delivery time required by the buyer in this shipment stage.
	 */
	private LocalTime RequiredDeliveryTime;
	/**
	 * Identifies the successive loading sequence (of consignments) associated
	 * with a shipment stage.
	 */
	private String SuccessiveSequenceID;
	/**
	 * A code signifying the direction of transit in this shipment stage.
	 */
	private String TransitDirectionCode;
	/**
	 * A code signifying the kind of transport means (truck, vessel, etc.) used
	 * for this shipment stage.
	 */
	private String TransportMeansTypeCode;
	/**
	 * A code signifying the method of transport used for this shipment stage.
	 */
	private String TransportModeCode;
	private AllowanceCharge FreightAllowanceCharge;
	private Location LoadingPortLocation;
	private Location TransshipPortLocation;
	private Location UnloadingPortLocation;
	private Location FreightChargeLocation;
	private Party CustomsAgentParty;
	private Party TerminalOperatorParty;
	private Party CarrierParty;
	private Period EstimatedTransitPeriod;
	private Period TransitPeriod;
	private Person ReportingPerson;
	private Person ShipsSurgeonPerson;
	private Person MasterPerson;
	private Person CrewMemberPerson;
	private Person DriverPerson;
	private Person PassengerPerson;
	private Person SecurityOfficerPerson;
	private TransportEvent ExportationTransportEvent;
	private TransportEvent ActualArrivalTransportEvent;
	private TransportEvent WarehousingTransportEvent;
	private TransportEvent ExaminationTransportEvent;
	private TransportEvent ActualDepartureTransportEvent;
	private TransportEvent EstimatedDepartureTransportEvent;
	private TransportEvent RequestedDepartureTransportEvent;
	private TransportEvent PlannedWaypointTransportEvent;
	private TransportEvent OptionalTakeoverTransportEvent;
	private TransportEvent AvailabilityTransportEvent;
	private TransportEvent LoadingTransportEvent;
	private TransportEvent TakeoverTransportEvent;
	private TransportEvent RequestedArrivalTransportEvent;
	private TransportEvent RequestedWaypointTransportEvent;
	private TransportEvent PlannedDepartureTransportEvent;
	private TransportEvent PlannedArrivalTransportEvent;
	private TransportEvent DetentionTransportEvent;
	private TransportEvent DischargeTransportEvent;
	private List<TransportEvent> transportEvents = new ArrayList<>();
	private TransportEvent ActualWaypointTransportEvent;
	private TransportEvent DeliveryTransportEvent;
	private TransportEvent ActualPickupTransportEvent;
	private TransportEvent DropoffTransportEvent;
	private TransportEvent ReceiptTransportEvent;
	private TransportEvent AcceptanceTransportEvent;
	private TransportEvent StorageTransportEvent;
	private TransportEvent EstimatedArrivalTransportEvent;
	private List<TransportMeans> transportMeans = new ArrayList<>();

	public ShipmentStage() {

	}

	public void finalize() throws Throwable {

	}

	/**
	 * @return the crewQuantity
	 */
	public BigDecimal getCrewQuantity() {
		return CrewQuantity;
	}

	/**
	 * @param crewQuantity
	 *            the crewQuantity to set
	 */
	public void setCrewQuantity(BigDecimal crewQuantity) {
		CrewQuantity = crewQuantity;
	}

	/**
	 * @return the demurrageInstructions
	 */
	public String getDemurrageInstructions() {
		return DemurrageInstructions;
	}

	/**
	 * @param demurrageInstructions
	 *            the demurrageInstructions to set
	 */
	public void setDemurrageInstructions(String demurrageInstructions) {
		DemurrageInstructions = demurrageInstructions;
	}

	/**
	 * @return the estimatedDeliveryDate
	 */
	public LocalDate getEstimatedDeliveryDate() {
		return EstimatedDeliveryDate;
	}

	/**
	 * @param estimatedDeliveryDate
	 *            the estimatedDeliveryDate to set
	 */
	public void setEstimatedDeliveryDate(LocalDate estimatedDeliveryDate) {
		EstimatedDeliveryDate = estimatedDeliveryDate;
	}

	/**
	 * @return the estimatedDeliveryTime
	 */
	public LocalTime getEstimatedDeliveryTime() {
		return EstimatedDeliveryTime;
	}

	/**
	 * @param estimatedDeliveryTime
	 *            the estimatedDeliveryTime to set
	 */
	public void setEstimatedDeliveryTime(LocalTime estimatedDeliveryTime) {
		EstimatedDeliveryTime = estimatedDeliveryTime;
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
	 * @return the instructions
	 */
	public String getInstructions() {
		return Instructions;
	}

	/**
	 * @param instructions
	 *            the instructions to set
	 */
	public void setInstructions(String instructions) {
		Instructions = instructions;
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
	 * @return the onCarriageIndicator
	 */
	public boolean isOnCarriageIndicator() {
		return OnCarriageIndicator;
	}

	/**
	 * @param onCarriageIndicator
	 *            the onCarriageIndicator to set
	 */
	public void setOnCarriageIndicator(boolean onCarriageIndicator) {
		OnCarriageIndicator = onCarriageIndicator;
	}

	/**
	 * @return the passengerQuantity
	 */
	public BigDecimal getPassengerQuantity() {
		return PassengerQuantity;
	}

	/**
	 * @param passengerQuantity
	 *            the passengerQuantity to set
	 */
	public void setPassengerQuantity(BigDecimal passengerQuantity) {
		PassengerQuantity = passengerQuantity;
	}

	/**
	 * @return the preCarriageIndicator
	 */
	public boolean isPreCarriageIndicator() {
		return PreCarriageIndicator;
	}

	/**
	 * @param preCarriageIndicator
	 *            the preCarriageIndicator to set
	 */
	public void setPreCarriageIndicator(boolean preCarriageIndicator) {
		PreCarriageIndicator = preCarriageIndicator;
	}

	/**
	 * @return the requiredDeliveryDate
	 */
	public LocalDate getRequiredDeliveryDate() {
		return RequiredDeliveryDate;
	}

	/**
	 * @param requiredDeliveryDate
	 *            the requiredDeliveryDate to set
	 */
	public void setRequiredDeliveryDate(LocalDate requiredDeliveryDate) {
		RequiredDeliveryDate = requiredDeliveryDate;
	}

	/**
	 * @return the requiredDeliveryTime
	 */
	public LocalTime getRequiredDeliveryTime() {
		return RequiredDeliveryTime;
	}

	/**
	 * @param requiredDeliveryTime
	 *            the requiredDeliveryTime to set
	 */
	public void setRequiredDeliveryTime(LocalTime requiredDeliveryTime) {
		RequiredDeliveryTime = requiredDeliveryTime;
	}

	/**
	 * @return the successiveSequenceID
	 */
	public String getSuccessiveSequenceID() {
		return SuccessiveSequenceID;
	}

	/**
	 * @param successiveSequenceID
	 *            the successiveSequenceID to set
	 */
	public void setSuccessiveSequenceID(String successiveSequenceID) {
		SuccessiveSequenceID = successiveSequenceID;
	}

	/**
	 * @return the transitDirectionCode
	 */
	public String getTransitDirectionCode() {
		return TransitDirectionCode;
	}

	/**
	 * @param transitDirectionCode
	 *            the transitDirectionCode to set
	 */
	public void setTransitDirectionCode(String transitDirectionCode) {
		TransitDirectionCode = transitDirectionCode;
	}

	/**
	 * @return the transportMeansTypeCode
	 */
	public String getTransportMeansTypeCode() {
		return TransportMeansTypeCode;
	}

	/**
	 * @param transportMeansTypeCode
	 *            the transportMeansTypeCode to set
	 */
	public void setTransportMeansTypeCode(String transportMeansTypeCode) {
		TransportMeansTypeCode = transportMeansTypeCode;
	}

	/**
	 * @return the transportModeCode
	 */
	public String getTransportModeCode() {
		return TransportModeCode;
	}

	/**
	 * @param transportModeCode
	 *            the transportModeCode to set
	 */
	public void setTransportModeCode(String transportModeCode) {
		TransportModeCode = transportModeCode;
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
	 * @return the loadingPortLocation
	 */
	public Location getLoadingPortLocation() {
		return LoadingPortLocation;
	}

	/**
	 * @param loadingPortLocation
	 *            the loadingPortLocation to set
	 */
	public void setLoadingPortLocation(Location loadingPortLocation) {
		LoadingPortLocation = loadingPortLocation;
	}

	/**
	 * @return the transshipPortLocation
	 */
	public Location getTransshipPortLocation() {
		return TransshipPortLocation;
	}

	/**
	 * @param transshipPortLocation
	 *            the transshipPortLocation to set
	 */
	public void setTransshipPortLocation(Location transshipPortLocation) {
		TransshipPortLocation = transshipPortLocation;
	}

	/**
	 * @return the unloadingPortLocation
	 */
	public Location getUnloadingPortLocation() {
		return UnloadingPortLocation;
	}

	/**
	 * @param unloadingPortLocation
	 *            the unloadingPortLocation to set
	 */
	public void setUnloadingPortLocation(Location unloadingPortLocation) {
		UnloadingPortLocation = unloadingPortLocation;
	}

	/**
	 * @return the freightChargeLocation
	 */
	public Location getFreightChargeLocation() {
		return FreightChargeLocation;
	}

	/**
	 * @param freightChargeLocation
	 *            the freightChargeLocation to set
	 */
	public void setFreightChargeLocation(Location freightChargeLocation) {
		FreightChargeLocation = freightChargeLocation;
	}

	/**
	 * @return the customsAgentParty
	 */
	public Party getCustomsAgentParty() {
		return CustomsAgentParty;
	}

	/**
	 * @param customsAgentParty
	 *            the customsAgentParty to set
	 */
	public void setCustomsAgentParty(Party customsAgentParty) {
		CustomsAgentParty = customsAgentParty;
	}

	/**
	 * @return the terminalOperatorParty
	 */
	public Party getTerminalOperatorParty() {
		return TerminalOperatorParty;
	}

	/**
	 * @param terminalOperatorParty
	 *            the terminalOperatorParty to set
	 */
	public void setTerminalOperatorParty(Party terminalOperatorParty) {
		TerminalOperatorParty = terminalOperatorParty;
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
	 * @return the estimatedTransitPeriod
	 */
	public Period getEstimatedTransitPeriod() {
		return EstimatedTransitPeriod;
	}

	/**
	 * @param estimatedTransitPeriod
	 *            the estimatedTransitPeriod to set
	 */
	public void setEstimatedTransitPeriod(Period estimatedTransitPeriod) {
		EstimatedTransitPeriod = estimatedTransitPeriod;
	}

	/**
	 * @return the transitPeriod
	 */
	public Period getTransitPeriod() {
		return TransitPeriod;
	}

	/**
	 * @param transitPeriod
	 *            the transitPeriod to set
	 */
	public void setTransitPeriod(Period transitPeriod) {
		TransitPeriod = transitPeriod;
	}

	/**
	 * @return the reportingPerson
	 */
	public Person getReportingPerson() {
		return ReportingPerson;
	}

	/**
	 * @param reportingPerson
	 *            the reportingPerson to set
	 */
	public void setReportingPerson(Person reportingPerson) {
		ReportingPerson = reportingPerson;
	}

	/**
	 * @return the shipsSurgeonPerson
	 */
	public Person getShipsSurgeonPerson() {
		return ShipsSurgeonPerson;
	}

	/**
	 * @param shipsSurgeonPerson
	 *            the shipsSurgeonPerson to set
	 */
	public void setShipsSurgeonPerson(Person shipsSurgeonPerson) {
		ShipsSurgeonPerson = shipsSurgeonPerson;
	}

	/**
	 * @return the masterPerson
	 */
	public Person getMasterPerson() {
		return MasterPerson;
	}

	/**
	 * @param masterPerson
	 *            the masterPerson to set
	 */
	public void setMasterPerson(Person masterPerson) {
		MasterPerson = masterPerson;
	}

	/**
	 * @return the crewMemberPerson
	 */
	public Person getCrewMemberPerson() {
		return CrewMemberPerson;
	}

	/**
	 * @param crewMemberPerson
	 *            the crewMemberPerson to set
	 */
	public void setCrewMemberPerson(Person crewMemberPerson) {
		CrewMemberPerson = crewMemberPerson;
	}

	/**
	 * @return the driverPerson
	 */
	public Person getDriverPerson() {
		return DriverPerson;
	}

	/**
	 * @param driverPerson
	 *            the driverPerson to set
	 */
	public void setDriverPerson(Person driverPerson) {
		DriverPerson = driverPerson;
	}

	/**
	 * @return the passengerPerson
	 */
	public Person getPassengerPerson() {
		return PassengerPerson;
	}

	/**
	 * @param passengerPerson
	 *            the passengerPerson to set
	 */
	public void setPassengerPerson(Person passengerPerson) {
		PassengerPerson = passengerPerson;
	}

	/**
	 * @return the securityOfficerPerson
	 */
	public Person getSecurityOfficerPerson() {
		return SecurityOfficerPerson;
	}

	/**
	 * @param securityOfficerPerson
	 *            the securityOfficerPerson to set
	 */
	public void setSecurityOfficerPerson(Person securityOfficerPerson) {
		SecurityOfficerPerson = securityOfficerPerson;
	}

	/**
	 * @return the exportationTransportEvent
	 */
	public TransportEvent getExportationTransportEvent() {
		return ExportationTransportEvent;
	}

	/**
	 * @param exportationTransportEvent
	 *            the exportationTransportEvent to set
	 */
	public void setExportationTransportEvent(TransportEvent exportationTransportEvent) {
		ExportationTransportEvent = exportationTransportEvent;
	}

	/**
	 * @return the actualArrivalTransportEvent
	 */
	public TransportEvent getActualArrivalTransportEvent() {
		return ActualArrivalTransportEvent;
	}

	/**
	 * @param actualArrivalTransportEvent
	 *            the actualArrivalTransportEvent to set
	 */
	public void setActualArrivalTransportEvent(TransportEvent actualArrivalTransportEvent) {
		ActualArrivalTransportEvent = actualArrivalTransportEvent;
	}

	/**
	 * @return the warehousingTransportEvent
	 */
	public TransportEvent getWarehousingTransportEvent() {
		return WarehousingTransportEvent;
	}

	/**
	 * @param warehousingTransportEvent
	 *            the warehousingTransportEvent to set
	 */
	public void setWarehousingTransportEvent(TransportEvent warehousingTransportEvent) {
		WarehousingTransportEvent = warehousingTransportEvent;
	}

	/**
	 * @return the examinationTransportEvent
	 */
	public TransportEvent getExaminationTransportEvent() {
		return ExaminationTransportEvent;
	}

	/**
	 * @param examinationTransportEvent
	 *            the examinationTransportEvent to set
	 */
	public void setExaminationTransportEvent(TransportEvent examinationTransportEvent) {
		ExaminationTransportEvent = examinationTransportEvent;
	}

	/**
	 * @return the actualDepartureTransportEvent
	 */
	public TransportEvent getActualDepartureTransportEvent() {
		return ActualDepartureTransportEvent;
	}

	/**
	 * @param actualDepartureTransportEvent
	 *            the actualDepartureTransportEvent to set
	 */
	public void setActualDepartureTransportEvent(TransportEvent actualDepartureTransportEvent) {
		ActualDepartureTransportEvent = actualDepartureTransportEvent;
	}

	/**
	 * @return the estimatedDepartureTransportEvent
	 */
	public TransportEvent getEstimatedDepartureTransportEvent() {
		return EstimatedDepartureTransportEvent;
	}

	/**
	 * @param estimatedDepartureTransportEvent
	 *            the estimatedDepartureTransportEvent to set
	 */
	public void setEstimatedDepartureTransportEvent(TransportEvent estimatedDepartureTransportEvent) {
		EstimatedDepartureTransportEvent = estimatedDepartureTransportEvent;
	}

	/**
	 * @return the requestedDepartureTransportEvent
	 */
	public TransportEvent getRequestedDepartureTransportEvent() {
		return RequestedDepartureTransportEvent;
	}

	/**
	 * @param requestedDepartureTransportEvent
	 *            the requestedDepartureTransportEvent to set
	 */
	public void setRequestedDepartureTransportEvent(TransportEvent requestedDepartureTransportEvent) {
		RequestedDepartureTransportEvent = requestedDepartureTransportEvent;
	}

	/**
	 * @return the plannedWaypointTransportEvent
	 */
	public TransportEvent getPlannedWaypointTransportEvent() {
		return PlannedWaypointTransportEvent;
	}

	/**
	 * @param plannedWaypointTransportEvent
	 *            the plannedWaypointTransportEvent to set
	 */
	public void setPlannedWaypointTransportEvent(TransportEvent plannedWaypointTransportEvent) {
		PlannedWaypointTransportEvent = plannedWaypointTransportEvent;
	}

	/**
	 * @return the optionalTakeoverTransportEvent
	 */
	public TransportEvent getOptionalTakeoverTransportEvent() {
		return OptionalTakeoverTransportEvent;
	}

	/**
	 * @param optionalTakeoverTransportEvent
	 *            the optionalTakeoverTransportEvent to set
	 */
	public void setOptionalTakeoverTransportEvent(TransportEvent optionalTakeoverTransportEvent) {
		OptionalTakeoverTransportEvent = optionalTakeoverTransportEvent;
	}

	/**
	 * @return the availabilityTransportEvent
	 */
	public TransportEvent getAvailabilityTransportEvent() {
		return AvailabilityTransportEvent;
	}

	/**
	 * @param availabilityTransportEvent
	 *            the availabilityTransportEvent to set
	 */
	public void setAvailabilityTransportEvent(TransportEvent availabilityTransportEvent) {
		AvailabilityTransportEvent = availabilityTransportEvent;
	}

	/**
	 * @return the loadingTransportEvent
	 */
	public TransportEvent getLoadingTransportEvent() {
		return LoadingTransportEvent;
	}

	/**
	 * @param loadingTransportEvent
	 *            the loadingTransportEvent to set
	 */
	public void setLoadingTransportEvent(TransportEvent loadingTransportEvent) {
		LoadingTransportEvent = loadingTransportEvent;
	}

	/**
	 * @return the takeoverTransportEvent
	 */
	public TransportEvent getTakeoverTransportEvent() {
		return TakeoverTransportEvent;
	}

	/**
	 * @param takeoverTransportEvent
	 *            the takeoverTransportEvent to set
	 */
	public void setTakeoverTransportEvent(TransportEvent takeoverTransportEvent) {
		TakeoverTransportEvent = takeoverTransportEvent;
	}

	/**
	 * @return the requestedArrivalTransportEvent
	 */
	public TransportEvent getRequestedArrivalTransportEvent() {
		return RequestedArrivalTransportEvent;
	}

	/**
	 * @param requestedArrivalTransportEvent
	 *            the requestedArrivalTransportEvent to set
	 */
	public void setRequestedArrivalTransportEvent(TransportEvent requestedArrivalTransportEvent) {
		RequestedArrivalTransportEvent = requestedArrivalTransportEvent;
	}

	/**
	 * @return the requestedWaypointTransportEvent
	 */
	public TransportEvent getRequestedWaypointTransportEvent() {
		return RequestedWaypointTransportEvent;
	}

	/**
	 * @param requestedWaypointTransportEvent
	 *            the requestedWaypointTransportEvent to set
	 */
	public void setRequestedWaypointTransportEvent(TransportEvent requestedWaypointTransportEvent) {
		RequestedWaypointTransportEvent = requestedWaypointTransportEvent;
	}

	/**
	 * @return the plannedDepartureTransportEvent
	 */
	public TransportEvent getPlannedDepartureTransportEvent() {
		return PlannedDepartureTransportEvent;
	}

	/**
	 * @param plannedDepartureTransportEvent
	 *            the plannedDepartureTransportEvent to set
	 */
	public void setPlannedDepartureTransportEvent(TransportEvent plannedDepartureTransportEvent) {
		PlannedDepartureTransportEvent = plannedDepartureTransportEvent;
	}

	/**
	 * @return the plannedArrivalTransportEvent
	 */
	public TransportEvent getPlannedArrivalTransportEvent() {
		return PlannedArrivalTransportEvent;
	}

	/**
	 * @param plannedArrivalTransportEvent
	 *            the plannedArrivalTransportEvent to set
	 */
	public void setPlannedArrivalTransportEvent(TransportEvent plannedArrivalTransportEvent) {
		PlannedArrivalTransportEvent = plannedArrivalTransportEvent;
	}

	/**
	 * @return the detentionTransportEvent
	 */
	public TransportEvent getDetentionTransportEvent() {
		return DetentionTransportEvent;
	}

	/**
	 * @param detentionTransportEvent
	 *            the detentionTransportEvent to set
	 */
	public void setDetentionTransportEvent(TransportEvent detentionTransportEvent) {
		DetentionTransportEvent = detentionTransportEvent;
	}

	/**
	 * @return the dischargeTransportEvent
	 */
	public TransportEvent getDischargeTransportEvent() {
		return DischargeTransportEvent;
	}

	/**
	 * @param dischargeTransportEvent
	 *            the dischargeTransportEvent to set
	 */
	public void setDischargeTransportEvent(TransportEvent dischargeTransportEvent) {
		DischargeTransportEvent = dischargeTransportEvent;
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
	 * @return the actualWaypointTransportEvent
	 */
	public TransportEvent getActualWaypointTransportEvent() {
		return ActualWaypointTransportEvent;
	}

	/**
	 * @param actualWaypointTransportEvent
	 *            the actualWaypointTransportEvent to set
	 */
	public void setActualWaypointTransportEvent(TransportEvent actualWaypointTransportEvent) {
		ActualWaypointTransportEvent = actualWaypointTransportEvent;
	}

	/**
	 * @return the deliveryTransportEvent
	 */
	public TransportEvent getDeliveryTransportEvent() {
		return DeliveryTransportEvent;
	}

	/**
	 * @param deliveryTransportEvent
	 *            the deliveryTransportEvent to set
	 */
	public void setDeliveryTransportEvent(TransportEvent deliveryTransportEvent) {
		DeliveryTransportEvent = deliveryTransportEvent;
	}

	/**
	 * @return the actualPickupTransportEvent
	 */
	public TransportEvent getActualPickupTransportEvent() {
		return ActualPickupTransportEvent;
	}

	/**
	 * @param actualPickupTransportEvent
	 *            the actualPickupTransportEvent to set
	 */
	public void setActualPickupTransportEvent(TransportEvent actualPickupTransportEvent) {
		ActualPickupTransportEvent = actualPickupTransportEvent;
	}

	/**
	 * @return the dropoffTransportEvent
	 */
	public TransportEvent getDropoffTransportEvent() {
		return DropoffTransportEvent;
	}

	/**
	 * @param dropoffTransportEvent
	 *            the dropoffTransportEvent to set
	 */
	public void setDropoffTransportEvent(TransportEvent dropoffTransportEvent) {
		DropoffTransportEvent = dropoffTransportEvent;
	}

	/**
	 * @return the receiptTransportEvent
	 */
	public TransportEvent getReceiptTransportEvent() {
		return ReceiptTransportEvent;
	}

	/**
	 * @param receiptTransportEvent
	 *            the receiptTransportEvent to set
	 */
	public void setReceiptTransportEvent(TransportEvent receiptTransportEvent) {
		ReceiptTransportEvent = receiptTransportEvent;
	}

	/**
	 * @return the acceptanceTransportEvent
	 */
	public TransportEvent getAcceptanceTransportEvent() {
		return AcceptanceTransportEvent;
	}

	/**
	 * @param acceptanceTransportEvent
	 *            the acceptanceTransportEvent to set
	 */
	public void setAcceptanceTransportEvent(TransportEvent acceptanceTransportEvent) {
		AcceptanceTransportEvent = acceptanceTransportEvent;
	}

	/**
	 * @return the storageTransportEvent
	 */
	public TransportEvent getStorageTransportEvent() {
		return StorageTransportEvent;
	}

	/**
	 * @param storageTransportEvent
	 *            the storageTransportEvent to set
	 */
	public void setStorageTransportEvent(TransportEvent storageTransportEvent) {
		StorageTransportEvent = storageTransportEvent;
	}

	/**
	 * @return the estimatedArrivalTransportEvent
	 */
	public TransportEvent getEstimatedArrivalTransportEvent() {
		return EstimatedArrivalTransportEvent;
	}

	/**
	 * @param estimatedArrivalTransportEvent
	 *            the estimatedArrivalTransportEvent to set
	 */
	public void setEstimatedArrivalTransportEvent(TransportEvent estimatedArrivalTransportEvent) {
		EstimatedArrivalTransportEvent = estimatedArrivalTransportEvent;
	}

	/**
	 * @return the m_TransportMeans
	 */
	public TransportMeans getM_TransportMeans() {
		return m_TransportMeans;
	}

	/**
	 * @param m_TransportMeans
	 *            the m_TransportMeans to set
	 */
	public void setM_TransportMeans(TransportMeans m_TransportMeans) {
		this.m_TransportMeans = m_TransportMeans;
	}

}// end Shipment Stage