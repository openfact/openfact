package org.openfact.representations.idm.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A class to describe a particular vehicle or vessel used for the conveyance of
 * goods or persons.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:48 a. m.
 */
public class TransportMeansRepresentation {

    /**
     * A code signifying the direction of this means of transport.
     */
    private CodeRepresentation directionCode;
    /**
     * An identifier for the regular service schedule of this means of
     * transport.
     */
    private IdentifierRepresentation journeyID;
    /**
     * Text describing the country in which this means of transport is
     * registered.
     */
    private TextRepresentation registrationNationality;
    /**
     * An identifier for the country in which this means of transport is
     * registered.
     */
    private IdentifierRepresentation registrationNationalityID;
    /**
     * A code signifying the service regularly provided by the carrier operating
     * this means of transport.
     */
    private CodeRepresentation tradeServiceCode;
    /**
     * A code signifying the type of this means of transport (truck, vessel,
     * etc.).
     */
    private CodeRepresentation transportMeansTypeCode;
    private List<AirTransportRepresentation> airTransports = new ArrayList<>();
    private DimensionRepresentation measurementDimension;
    private List<MaritimeTransportRepresentation> maritimeTransports = new ArrayList<>();
    private PartyRepresentation ownerParty;
    private List<RailTransportRepresentation> railTransports = new ArrayList<>();
    private List<RoadTransportRepresentation> roadTransports = new ArrayList<>();
    private List<StowageRepresentation> stowages = new ArrayList<>();

}
