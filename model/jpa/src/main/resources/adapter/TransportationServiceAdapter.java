package adapter;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe a transportation service.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:52 a. m.
 */
public class TransportationServiceAdapter{

	/**
	 * A code signifying the rate class for freight in this transportation service.
	 */
	private CodeType freightRateClassCode;
	/**
	 * The name of this transportation service.
	 */
	private nameType name;
	/**
	 * In a transport contract, the deadline date by which this transportation service
	 * has to be booked. For example, if this service is scheduled for Wednesday 16
	 * February 2011 at 10 a.m. CET, the nomination date might be Tuesday15 February
	 * 2011.
	 */
	private DateType nominationDate;
	/**
	 * In a transport contract, the deadline time by which this transportation service
	 * has to be booked. For example, if this service is scheduled for Wednesday 16
	 * February 2011 at 10 a.m. CET, the nomination date might be Tuesday15 February
	 * 2011 and the nominat
	 */
	private TimeType nominationTime;
	/**
	 * The priority of this transportation service.
	 */
	private TextType priority;
	/**
	 * A number indicating the order of this transportation service in a sequence of
	 * transportation services.
	 */
	private NumericType sequenceNumeric;
	/**
	 * A code signifying the tariff class applicable to this transportation service.
	 */
	private CodeType tariffClassCode;
	/**
	 * Text describing this transportation service.
	 */
	private TextType transportationServiceDescription;
	/**
	 * The Uniform Resource Identifier (URI) of a document providing additional
	 * details regarding this transportation service.
	 */
	private IdentifierType transportationServiceDetailsURIID;
	/**
	 * A code signifying the extent of this transportation service (e.g., door-to-door,
	 * port-to-port).
	 */
	private CodeType transportServiceCode;
	private List<CommodityClassificationAdapter> unsupportedCommodityClassification = new ArrayList<>();
	private List<CommodityClassificationAdapter> supportedCommodityClassification = new ArrayList<>();
	private List<CommodityClassificationAdapter> commodityClassifications = new ArrayList<>();
	private DimensionAdapter totalCapacityDimension;
	private List<EnvironmentalEmissionAdapter> environmentalEmissions = new ArrayList<>();
	private PartyAdapter responsibleTransportServiceProviderParty;
	private PeriodAdapter estimatedDurationPeriod;
	private ServiceFrequencyAdapter scheduledServiceFrequency;
	private List<ShipmentStageAdapter> shipmentStages = new ArrayList<>();
	private List<TransportEquipmentAdapter> unsupportedTransportEquipment = new ArrayList<>();
	private List<TransportEquipmentAdapter> transportEquipments = new ArrayList<>();
	private List<TransportEquipmentAdapter> supportedTransportEquipment = new ArrayList<>();
	private List<TransportEventAdapter> transportEvents = new ArrayList<>();

}
