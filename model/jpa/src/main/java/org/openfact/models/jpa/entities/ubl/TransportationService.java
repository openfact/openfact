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
    private List<CommodityClassification> commodityClassifications = new ArrayList<>();
    private Dimension TotalCapacityDimension;
    private List<EnvironmentalEmission> environmentalEmissions = new ArrayList<>();
    private Party ResponsibleTransportServiceProviderParty;
    private Period EstimatedDuratioPeriod;
    private ServiceFrequency ScheduledServiceFrequency;
    private List<ShipmentStage> shipmentStages = new ArrayList<>();
    private TransportEquipment UnsupportedTransportEquipment;
    private List<TransportEquipment> transportEquipments = new ArrayList<>();
    private TransportEquipment SupportedTransportEquipment;
    private List<TransportEvent> transportEvents = new ArrayList<>();

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
    public void setUnsupportedCommodityClassification(
            CommodityClassification unsupportedCommodityClassification) {
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
    public void setSupportedCommodityClassification(
            CommodityClassification supportedCommodityClassification) {
        SupportedCommodityClassification = supportedCommodityClassification;
    }

    /**
     * @return the commodityClassifications
     */
    public List<CommodityClassification> getCommodityClassifications() {
        return commodityClassifications;
    }

    /**
     * @param commodityClassifications
     *            the commodityClassifications to set
     */
    public void setCommodityClassifications(List<CommodityClassification> commodityClassifications) {
        this.commodityClassifications = commodityClassifications;
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
     * @return the environmentalEmissions
     */
    public List<EnvironmentalEmission> getEnvironmentalEmissions() {
        return environmentalEmissions;
    }

    /**
     * @param environmentalEmissions
     *            the environmentalEmissions to set
     */
    public void setEnvironmentalEmissions(List<EnvironmentalEmission> environmentalEmissions) {
        this.environmentalEmissions = environmentalEmissions;
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
     * @return the shipmentStages
     */
    public List<ShipmentStage> getShipmentStages() {
        return shipmentStages;
    }

    /**
     * @param shipmentStages
     *            the shipmentStages to set
     */
    public void setShipmentStages(List<ShipmentStage> shipmentStages) {
        this.shipmentStages = shipmentStages;
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
     * @return the transportEquipments
     */
    public List<TransportEquipment> getTransportEquipments() {
        return transportEquipments;
    }

    /**
     * @param transportEquipments
     *            the transportEquipments to set
     */
    public void setTransportEquipments(List<TransportEquipment> transportEquipments) {
        this.transportEquipments = transportEquipments;
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
     * @return the transportEvents
     */
    public List<TransportEvent> getTransportEvents() {
        return transportEvents;
    }

    /**
     * @param transportEvents
     *            the transportEvents to set
     */
    public void setTransportEvents(List<TransportEvent> transportEvents) {
        this.transportEvents = transportEvents;
    }

}// end TransportationService