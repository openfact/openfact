package org.openfact.models.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A class to describe a particular vehicle or vessel used for the conveyance of
 * goods or persons.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:48 a. m.
 */
public class TransportMeansModel {

    /**
     * A code signifying the direction of this means of transport.
     */
    private CodeModel directionCode;
    /**
     * An identifier for the regular service schedule of this means of
     * transport.
     */
    private IdentifierModel journeyID;
    /**
     * Text describing the country in which this means of transport is
     * registered.
     */
    private TextModel registrationNationality;
    /**
     * An identifier for the country in which this means of transport is
     * registered.
     */
    private IdentifierModel registrationNationalityID;
    /**
     * A code signifying the service regularly provided by the carrier operating
     * this means of transport.
     */
    private CodeModel tradeServiceCode;
    /**
     * A code signifying the type of this means of transport (truck, vessel,
     * etc.).
     */
    private CodeModel transportMeansTypeCode;
    private List<AirTransportModel> airTransports = new ArrayList<>();
    private DimensionModel measurementDimension;
    private List<MaritimeTransportModel> maritimeTransports = new ArrayList<>();
    private PartyModel ownerParty;
    private List<RailTransportModel> railTransports = new ArrayList<>();
    private List<RoadTransportModel> roadTransports = new ArrayList<>();
    private List<StowageModel> stowages = new ArrayList<>();

}
