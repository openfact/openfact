package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A class to describe a transportation service.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:52 a. m.
 */
public class TransportationService {

	/**
	 * A code signifying the rate class for freight in this transportation
	 * service.
	 */
	private String FreightRateClassCode;
	/**
	 * The name of this transportation service.
	 */
	private String Name;
	/**
	 * In a transport contract, the deadline date by which this transportation
	 * service has to be booked. For example, if this service is scheduled for
	 * Wednesday 16 February 2011 at 10 a.m. CET, the nomination date might be
	 * Tuesday15 February 2011.
	 */
	private LocalDate NominationDate;
	/**
	 * In a transport contract, the deadline time by which this transportation
	 * service has to be booked. For example, if this service is scheduled for
	 * Wednesday 16 February 2011 at 10 a.m. CET, the nomination date might be
	 * Tuesday15 February 2011 and the nominat
	 */
	private LocalTime NominationTime;
	/**
	 * The priority of this transportation service.
	 */
	private String Priority;
	/**
	 * A number indicating the order of this transportation service in a
	 * sequence of transportation services.
	 */
	private BigDecimal SequenceNumeric;
	/**
	 * A code signifying the tariff class applicable to this transportation
	 * service.
	 */
	private String TariffClassCode;
	/**
	 * Text describing this transportation service.
	 */
	private String TransportationServiceDescription;
	/**
	 * The Uniform Resource Identifier (URI) of a document providing additional
	 * details regarding this transportation service.
	 */
	private String TransportationServiceDetailsURIID;
	/**
	 * A code signifying the extent of this transportation service (e.g.,
	 * door-to-door, port-to-port).
	 */
	private String TransportServiceCode;
	private CommodityClassification UnsupportedCommodityClassification;
	private CommodityClassification SupportedCommodityClassification;
	private CommodityClassification m_CommodityClassification;
	private Dimension TotalCapacityDimension;
	private EnvironmentalEmission m_EnvironmentalEmission;
	private Party ResponsibleTransportServiceProviderParty;
	private Period EstimatedDuratioPeriod;
	private ServiceFrequency ScheduledServiceFrequency;
	private ShipmentStage m_ShipmentStage;
	private TransportEquipment UnsupportedTransportEquipment;
	private TransportEquipment m_TransportEquipment;
	private TransportEquipment SupportedTransportEquipment;
	private TransportEvent m_TransportEvent;

	/**
	 * @return the freightRateClassCode
	 */
	public String getFreightRateClassCode() {
		return FreightRateClassCode;
	}

	/**
	 * @param freightRateClassCode
	 *            the freightRateClassCode to set
	 */
	public void setFreightRateClassCode(String freightRateClassCode) {
		FreightRateClassCode = freightRateClassCode;
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
	 * @return the nominationDate
	 */
	public LocalDate getNominationDate() {
		return NominationDate;
	}

	/**
	 * @param nominationDate
	 *            the nominationDate to set
	 */
	public void setNominationDate(LocalDate nominationDate) {
		NominationDate = nominationDate;
	}

	/**
	 * @return the nominationTime
	 */
	public LocalTime getNominationTime() {
		return NominationTime;
	}

	/**
	 * @param nominationTime
	 *            the nominationTime to set
	 */
	public void setNominationTime(LocalTime nominationTime) {
		NominationTime = nominationTime;
	}

	/**
	 * @return the priority
	 */
	public String getPriority() {
		return Priority;
	}

	/**
	 * @param priority
	 *            the priority to set
	 */
	public void setPriority(String priority) {
		Priority = priority;
	}

	/**
	 * @return the sequenceNumeric
	 */
	public BigDecimal getSequenceNumeric() {
		return SequenceNumeric;
	}

	/**
	 * @param sequenceNumeric
	 *            the sequenceNumeric to set
	 */
	public void setSequenceNumeric(BigDecimal sequenceNumeric) {
		SequenceNumeric = sequenceNumeric;
	}

	/**
	 * @return the tariffClassCode
	 */
	public String getTariffClassCode() {
		return TariffClassCode;
	}

	/**
	 * @param tariffClassCode
	 *            the tariffClassCode to set
	 */
	public void setTariffClassCode(String tariffClassCode) {
		TariffClassCode = tariffClassCode;
	}

	/**
	 * @return the transportationServiceDescription
	 */
	public String getTransportationServiceDescription() {
		return TransportationServiceDescription;
	}

	/**
	 * @param transportationServiceDescription
	 *            the transportationServiceDescription to set
	 */
	public void setTransportationServiceDescription(String transportationServiceDescription) {
		TransportationServiceDescription = transportationServiceDescription;
	}

	/**
	 * @return the transportationServiceDetailsURIID
	 */
	public String getTransportationServiceDetailsURIID() {
		return TransportationServiceDetailsURIID;
	}

	/**
	 * @param transportationServiceDetailsURIID
	 *            the transportationServiceDetailsURIID to set
	 */
	public void setTransportationServiceDetailsURIID(String transportationServiceDetailsURIID) {
		TransportationServiceDetailsURIID = transportationServiceDetailsURIID;
	}

	/**
	 * @return the transportServiceCode
	 */
	public String getTransportServiceCode() {
		return TransportServiceCode;
	}

	/**
	 * @param transportServiceCode
	 *            the transportServiceCode to set
	 */
	public void setTransportServiceCode(String transportServiceCode) {
		TransportServiceCode = transportServiceCode;
	}

	/**
	 * @return the unsupportedCommodityClassification
	 */
	public CommodityClassification getUnsupportedCommodityClassification() {
		return UnsupportedCommodityClassification;
	}

	/**
	 * @param unsupportedCommodityClassification
	 *            the unsupportedCommodityClassification to set
	 */
	public void setUnsupportedCommodityClassification(CommodityClassification unsupportedCommodityClassification) {
		UnsupportedCommodityClassification = unsupportedCommodityClassification;
	}

	/**
	 * @return the supportedCommodityClassification
	 */
	public CommodityClassification getSupportedCommodityClassification() {
		return SupportedCommodityClassification;
	}

	/**
	 * @param supportedCommodityClassification
	 *            the supportedCommodityClassification to set
	 */
	public void setSupportedCommodityClassification(CommodityClassification supportedCommodityClassification) {
		SupportedCommodityClassification = supportedCommodityClassification;
	}

	/**
	 * @return the m_CommodityClassification
	 */
	public CommodityClassification getM_CommodityClassification() {
		return m_CommodityClassification;
	}

	/**
	 * @param m_CommodityClassification
	 *            the m_CommodityClassification to set
	 */
	public void setM_CommodityClassification(CommodityClassification m_CommodityClassification) {
		this.m_CommodityClassification = m_CommodityClassification;
	}

	/**
	 * @return the totalCapacityDimension
	 */
	public Dimension getTotalCapacityDimension() {
		return TotalCapacityDimension;
	}

	/**
	 * @param totalCapacityDimension
	 *            the totalCapacityDimension to set
	 */
	public void setTotalCapacityDimension(Dimension totalCapacityDimension) {
		TotalCapacityDimension = totalCapacityDimension;
	}

	/**
	 * @return the m_EnvironmentalEmission
	 */
	public EnvironmentalEmission getM_EnvironmentalEmission() {
		return m_EnvironmentalEmission;
	}

	/**
	 * @param m_EnvironmentalEmission
	 *            the m_EnvironmentalEmission to set
	 */
	public void setM_EnvironmentalEmission(EnvironmentalEmission m_EnvironmentalEmission) {
		this.m_EnvironmentalEmission = m_EnvironmentalEmission;
	}

	/**
	 * @return the responsibleTransportServiceProviderParty
	 */
	public Party getResponsibleTransportServiceProviderParty() {
		return ResponsibleTransportServiceProviderParty;
	}

	/**
	 * @param responsibleTransportServiceProviderParty
	 *            the responsibleTransportServiceProviderParty to set
	 */
	public void setResponsibleTransportServiceProviderParty(Party responsibleTransportServiceProviderParty) {
		ResponsibleTransportServiceProviderParty = responsibleTransportServiceProviderParty;
	}

	/**
	 * @return the estimatedDuratioPeriod
	 */
	public Period getEstimatedDuratioPeriod() {
		return EstimatedDuratioPeriod;
	}

	/**
	 * @param estimatedDuratioPeriod
	 *            the estimatedDuratioPeriod to set
	 */
	public void setEstimatedDuratioPeriod(Period estimatedDuratioPeriod) {
		EstimatedDuratioPeriod = estimatedDuratioPeriod;
	}

	/**
	 * @return the scheduledServiceFrequency
	 */
	public ServiceFrequency getScheduledServiceFrequency() {
		return ScheduledServiceFrequency;
	}

	/**
	 * @param scheduledServiceFrequency
	 *            the scheduledServiceFrequency to set
	 */
	public void setScheduledServiceFrequency(ServiceFrequency scheduledServiceFrequency) {
		ScheduledServiceFrequency = scheduledServiceFrequency;
	}

	/**
	 * @return the m_ShipmentStage
	 */
	public ShipmentStage getM_ShipmentStage() {
		return m_ShipmentStage;
	}

	/**
	 * @param m_ShipmentStage
	 *            the m_ShipmentStage to set
	 */
	public void setM_ShipmentStage(ShipmentStage m_ShipmentStage) {
		this.m_ShipmentStage = m_ShipmentStage;
	}

	/**
	 * @return the unsupportedTransportEquipment
	 */
	public TransportEquipment getUnsupportedTransportEquipment() {
		return UnsupportedTransportEquipment;
	}

	/**
	 * @param unsupportedTransportEquipment
	 *            the unsupportedTransportEquipment to set
	 */
	public void setUnsupportedTransportEquipment(TransportEquipment unsupportedTransportEquipment) {
		UnsupportedTransportEquipment = unsupportedTransportEquipment;
	}

	/**
	 * @return the m_TransportEquipment
	 */
	public TransportEquipment getM_TransportEquipment() {
		return m_TransportEquipment;
	}

	/**
	 * @param m_TransportEquipment
	 *            the m_TransportEquipment to set
	 */
	public void setM_TransportEquipment(TransportEquipment m_TransportEquipment) {
		this.m_TransportEquipment = m_TransportEquipment;
	}

	/**
	 * @return the supportedTransportEquipment
	 */
	public TransportEquipment getSupportedTransportEquipment() {
		return SupportedTransportEquipment;
	}

	/**
	 * @param supportedTransportEquipment
	 *            the supportedTransportEquipment to set
	 */
	public void setSupportedTransportEquipment(TransportEquipment supportedTransportEquipment) {
		SupportedTransportEquipment = supportedTransportEquipment;
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

}// end TransportationService