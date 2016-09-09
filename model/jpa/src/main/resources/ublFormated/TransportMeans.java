package org.openfact.models.jpa.entities.ubl;
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
public class TransportMeans{

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
	private List<AirTransport> AirTransports = new ArrayList<>();
	private Dimension MeasurementDimension;
	private List<MaritimeTransport> MaritimeTransports = new ArrayList<>();
	private Party OwnerParty;
	private List<RailTransport> RailTransports = new ArrayList<>();
	private List<RoadTransport> RoadTransports = new ArrayList<>();
	private List<Stowage> Stowages = new ArrayList<>();

}
