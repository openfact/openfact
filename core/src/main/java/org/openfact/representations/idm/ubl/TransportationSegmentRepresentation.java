package org.openfact.representations.idm.ubl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.IdentifierType;

/**
 * A class to describe one segment or leg in a transportation service.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:51 a. m.
 */
public class TransportationSegmentRepresentation {

    /**
     * A number indicating the order of this segment in the sequence of
     * transportation segments making up a transportation service.
     */
    private BigDecimal sequenceNumeric;
    /**
     * An identifier for the transport execution plan governing this
     * transportation segment.
     */
    private IdentifierType transportExecutionPlanReferenceID;
    private ConsignmentRepresentation referencedConsignment;
    private PartyRepresentation transportServiceProviderParty;
    private List<ShipmentStageRepresentation> shipmentStages = new ArrayList<>();
    private List<TransportationServiceRepresentation> transportationServices = new ArrayList<>();

}
