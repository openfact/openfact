package model;
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
	private CodeType DirectionCode;
	/**
	 * An identifier for the regular service schedule of this means of transport.
	 */
	private IdentifierType JourneyID;
	/**
	 * Text describing the country in which this means of transport is registered.
	 */
	private TextType RegistrationNationality;
	/**
	 * An identifier for the country in which this means of transport is registered.
	 */
	private IdentifierType RegistrationNationalityID;
	/**
	 * A code signifying the service regularly provided by the carrier operating this
	 * means of transport.
	 */
	private CodeType TradeServiceCode;
	/**
	 * A code signifying the type of this means of transport (truck, vessel, etc.).
	 */
	private CodeType TransportMeansTypeCode;
	private List<AirTransportModel> AirTransports = new ArrayList<>();
	private DimensionModel MeasurementDimension;
	private List<MaritimeTransportModel> MaritimeTransports = new ArrayList<>();
	private PartyModel OwnerParty;
	private List<RailTransportModel> RailTransports = new ArrayList<>();
	private List<RoadTransportModel> RoadTransports = new ArrayList<>();
	private List<StowageModel> Stowages = new ArrayList<>();

}
