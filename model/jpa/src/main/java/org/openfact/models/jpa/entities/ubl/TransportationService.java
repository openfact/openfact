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
    private String freightRateClassCode;
    /**
     * The name of this transportation service.
     */
    private String name;
    /**
     * In a transport contract, the deadline date by which this transportation
     * service has to be booked. For example, if this service is scheduled for
     * Wednesday 16 February 2011 at 10 a.m. CET, the nomination date might be
     * Tuesday15 February 2011.
     */
    private LocalDate nominationDate;
    /**
     * In a transport contract, the deadline time by which this transportation
     * service has to be booked. For example, if this service is scheduled for
     * Wednesday 16 February 2011 at 10 a.m. CET, the nomination date might be
     * Tuesday15 February 2011 and the nominat
     */
    private LocalTime nominationTime;
    /**
     * The priority of this transportation service.
     */
    private String priority;
    /**
     * A number indicating the order of this transportation service in a
     * sequence of transportation services.
     */
    private BigDecimal sequenceNumeric;
    /**
     * A code signifying the tariff class applicable to this transportation
     * service.
     */
    private String tariffClassCode;
    /**
     * Text describing this transportation service.
     */
    private String transportationServiceDescription;
    /**
     * The Uniform Resource Identifier (URI) of a document providing additional
     * details regarding this transportation service.
     */
    private String transportationServiceDetailsURIID;
    /**
     * A code signifying the extent of this transportation service (e.g.,
     * door-to-door, port-to-port).
     */
    private String transportServiceCode;
    private CommodityClassification unsupportedCommodityClassification;
    private CommodityClassification supportedCommodityClassification;
    private List<CommodityClassification> commodityClassifications = new ArrayList<>();
    private Dimension totalCapacityDimension;
    private List<EnvironmentalEmission> environmentalEmissions = new ArrayList<>();
    private Party responsibleTransportServiceProviderParty;
    private Period estimatedDuratioPeriod;
    private ServiceFrequency scheduledServiceFrequency;
    private List<ShipmentStage> shipmentStages = new ArrayList<>();
    private TransportEquipment unsupportedTransportEquipment;
    private List<TransportEquipment> transportEquipments = new ArrayList<>();
    private TransportEquipment supportedTransportEquipment;
    private List<TransportEvent> transportEvents = new ArrayList<>();

    public String getFreightRateClassCode() {
        return freightRateClassCode;
    }

    public void setFreightRateClassCode(String freightRateClassCode) {
        this.freightRateClassCode = freightRateClassCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getNominationDate() {
        return nominationDate;
    }

    public void setNominationDate(LocalDate nominationDate) {
        this.nominationDate = nominationDate;
    }

    public LocalTime getNominationTime() {
        return nominationTime;
    }

    public void setNominationTime(LocalTime nominationTime) {
        this.nominationTime = nominationTime;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public BigDecimal getSequenceNumeric() {
        return sequenceNumeric;
    }

    public void setSequenceNumeric(BigDecimal sequenceNumeric) {
        this.sequenceNumeric = sequenceNumeric;
    }

    public String getTariffClassCode() {
        return tariffClassCode;
    }

    public void setTariffClassCode(String tariffClassCode) {
        this.tariffClassCode = tariffClassCode;
    }

    public String getTransportationServiceDescription() {
        return transportationServiceDescription;
    }

    public void setTransportationServiceDescription(String transportationServiceDescription) {
        this.transportationServiceDescription = transportationServiceDescription;
    }

    public String getTransportationServiceDetailsURIID() {
        return transportationServiceDetailsURIID;
    }

    public void setTransportationServiceDetailsURIID(String transportationServiceDetailsURIID) {
        this.transportationServiceDetailsURIID = transportationServiceDetailsURIID;
    }

    public String getTransportServiceCode() {
        return transportServiceCode;
    }

    public void setTransportServiceCode(String transportServiceCode) {
        this.transportServiceCode = transportServiceCode;
    }

    public CommodityClassification getUnsupportedCommodityClassification() {
        return unsupportedCommodityClassification;
    }

    public void setUnsupportedCommodityClassification(CommodityClassification unsupportedCommodityClassification) {
        this.unsupportedCommodityClassification = unsupportedCommodityClassification;
    }

    public CommodityClassification getSupportedCommodityClassification() {
        return supportedCommodityClassification;
    }

    public void setSupportedCommodityClassification(CommodityClassification supportedCommodityClassification) {
        this.supportedCommodityClassification = supportedCommodityClassification;
    }

    public List<CommodityClassification> getCommodityClassifications() {
        return commodityClassifications;
    }

    public void setCommodityClassifications(List<CommodityClassification> commodityClassifications) {
        this.commodityClassifications = commodityClassifications;
    }

    public Dimension getTotalCapacityDimension() {
        return totalCapacityDimension;
    }

    public void setTotalCapacityDimension(Dimension totalCapacityDimension) {
        this.totalCapacityDimension = totalCapacityDimension;
    }

    public List<EnvironmentalEmission> getEnvironmentalEmissions() {
        return environmentalEmissions;
    }

    public void setEnvironmentalEmissions(List<EnvironmentalEmission> environmentalEmissions) {
        this.environmentalEmissions = environmentalEmissions;
    }

    public Party getResponsibleTransportServiceProviderParty() {
        return responsibleTransportServiceProviderParty;
    }

    public void setResponsibleTransportServiceProviderParty(Party responsibleTransportServiceProviderParty) {
        this.responsibleTransportServiceProviderParty = responsibleTransportServiceProviderParty;
    }

    public Period getEstimatedDuratioPeriod() {
        return estimatedDuratioPeriod;
    }

    public void setEstimatedDuratioPeriod(Period estimatedDuratioPeriod) {
        this.estimatedDuratioPeriod = estimatedDuratioPeriod;
    }

    public ServiceFrequency getScheduledServiceFrequency() {
        return scheduledServiceFrequency;
    }

    public void setScheduledServiceFrequency(ServiceFrequency scheduledServiceFrequency) {
        this.scheduledServiceFrequency = scheduledServiceFrequency;
    }

    public List<ShipmentStage> getShipmentStages() {
        return shipmentStages;
    }

    public void setShipmentStages(List<ShipmentStage> shipmentStages) {
        this.shipmentStages = shipmentStages;
    }

    public TransportEquipment getUnsupportedTransportEquipment() {
        return unsupportedTransportEquipment;
    }

    public void setUnsupportedTransportEquipment(TransportEquipment unsupportedTransportEquipment) {
        this.unsupportedTransportEquipment = unsupportedTransportEquipment;
    }

    public List<TransportEquipment> getTransportEquipments() {
        return transportEquipments;
    }

    public void setTransportEquipments(List<TransportEquipment> transportEquipments) {
        this.transportEquipments = transportEquipments;
    }

    public TransportEquipment getSupportedTransportEquipment() {
        return supportedTransportEquipment;
    }

    public void setSupportedTransportEquipment(TransportEquipment supportedTransportEquipment) {
        this.supportedTransportEquipment = supportedTransportEquipment;
    }

    public List<TransportEvent> getTransportEvents() {
        return transportEvents;
    }

    public void setTransportEvents(List<TransportEvent> transportEvents) {
        this.transportEvents = transportEvents;
    }
}// end TransportationService