package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe a particular vehicle or vessel used for the conveyance of
 * goods or persons.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:48 a. m.
 */
public class TransportMeansModel{

	/**
	 * A code signifying the direction of this means of transport.
	 */
	private CodeType directionCode; 
	/**
	 * An identifier for the regular service schedule of this means of transport.
	 */
	private IdentifierType journeyID; 
	/**
	 * Text describing the country in which this means of transport is registered.
	 */
	private TextType registrationNationality; 
	/**
	 * An identifier for the country in which this means of transport is registered.
	 */
	private IdentifierType registrationNationalityID; 
	/**
	 * A code signifying the service regularly provided by the carrier operating this
	 * means of transport.
	 */
	private CodeType tradeServiceCode; 
	/**
	 * A code signifying the type of this means of transport (truck, vessel, etc.).
	 */
	private CodeType transportMeansTypeCode; 
	private List<AirTransportModel> airTransports = new ArrayList<>(); 
	private DimensionModel measurementDimension; 
	private List<MaritimeTransportModel> maritimeTransports = new ArrayList<>(); 
	private PartyModel ownerParty; 
	private List<RailTransportModel> railTransports = new ArrayList<>(); 
	private List<RoadTransportModel> roadTransports = new ArrayList<>(); 
	private List<StowageModel> stowages = new ArrayList<>(); 

}
