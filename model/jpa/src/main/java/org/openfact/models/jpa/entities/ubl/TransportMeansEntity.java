package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.CodeType;
import org.openfact.models.ubl.type.IdentifierType;
import org.openfact.models.ubl.type.TextType;

/**
 * A class to describe a particular vehicle or vessel used for the conveyance of
 * goods or persons.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:48 a. m.
 */
public class TransportMeansEntity {

    /**
     * A code signifying the direction of this means of transport.
     */
    private CodeType directionCode;
    /**
     * An identifier for the regular service schedule of this means of
     * transport.
     */
    private IdentifierType journeyID;
    /**
     * Text describing the country in which this means of transport is
     * registered.
     */
    private TextType registrationNationality;
    /**
     * An identifier for the country in which this means of transport is
     * registered.
     */
    private IdentifierType registrationNationalityID;
    /**
     * A code signifying the service regularly provided by the carrier operating
     * this means of transport.
     */
    private CodeType tradeServiceCode;
    /**
     * A code signifying the type of this means of transport (truck, vessel,
     * etc.).
     */
    private CodeType transportMeansTypeCode;
    private List<AirTransportEntity> airTransports = new ArrayList<>();
    private DimensionEntity measurementDimension;
    private List<MaritimeTransportEntity> maritimeTransports = new ArrayList<>();
    private PartyEntity ownerParty;
    private List<RailTransportEntity> railTransports = new ArrayList<>();
    private List<RoadTransportEntity> roadTransports = new ArrayList<>();
    private List<StowageEntity> stowages = new ArrayList<>();

}
