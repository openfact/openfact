package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

/**
 * A class to describe one segment or leg in a transportation service.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:51 a. m.
 */
public class TransportationSegment {

    /**
     * A number indicating the order of this segment in the sequence of
     * transportation segments making up a transportation service.
     */
    private BigDecimal sequenceNumeric;
    /**
     * An identifier for the transport execution plan governing this
     * transportation segment.
     */
    private String transportExecutionPlanReferenceID;
    private Consignment ReferencedConsignment;
    private Party TransportServiceProviderParty;
    private List<ShipmentStage> shipmentStages = new ArrayList<>();
    private List<TransportationService> transportationServices = new ArrayList<>();

    public BigDecimal getSequenceNumeric() {
        return sequenceNumeric;
    }

    public void setSequenceNumeric(BigDecimal sequenceNumeric) {
        this.sequenceNumeric = sequenceNumeric;
    }

    public String getTransportExecutionPlanReferenceID() {
        return transportExecutionPlanReferenceID;
    }

    public void setTransportExecutionPlanReferenceID(String transportExecutionPlanReferenceID) {
        this.transportExecutionPlanReferenceID = transportExecutionPlanReferenceID;
    }

    public Consignment getReferencedConsignment() {
        return ReferencedConsignment;
    }

    public void setReferencedConsignment(Consignment referencedConsignment) {
        ReferencedConsignment = referencedConsignment;
    }

    public Party getTransportServiceProviderParty() {
        return TransportServiceProviderParty;
    }

    public void setTransportServiceProviderParty(Party transportServiceProviderParty) {
        TransportServiceProviderParty = transportServiceProviderParty;
    }

    public List<ShipmentStage> getShipmentStages() {
        return shipmentStages;
    }

    public void setShipmentStages(List<ShipmentStage> shipmentStages) {
        this.shipmentStages = shipmentStages;
    }

    public List<TransportationService> getTransportationServices() {
        return transportationServices;
    }

    public void setTransportationServices(List<TransportationService> transportationServices) {
        this.transportationServices = transportationServices;
    }
}// end Transportation Segment