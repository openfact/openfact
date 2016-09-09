package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.NumericType;

/**
 * A class to describe one segment or leg in a transportation service.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:51 a. m.
 */
public class TransportationSegmentEntity {

    /**
     * A number indicating the order of this segment in the sequence of
     * transportation segments making up a transportation service.
     */
    private NumericType sequenceNumeric;
    /**
     * An identifier for the transport execution plan governing this
     * transportation segment.
     */
    private IdentifierType transportExecutionPlanReferenceID;
    private ConsignmentEntity referencedConsignment;
    private PartyEntity transportServiceProviderParty;
    private List<ShipmentStageEntity> shipmentStages = new ArrayList<>();
    private List<TransportationServiceEntity> transportationServices = new ArrayList<>();

}
