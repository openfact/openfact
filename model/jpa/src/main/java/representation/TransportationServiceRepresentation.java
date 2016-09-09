package representation;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe a transportation service.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:52 a. m.
 */
public class TransportationServiceRepresentation{

	/**
	 * A code signifying the rate class for freight in this transportation service.
	 */
	private CodeType FreightRateClassCode;
	/**
	 * The name of this transportation service.
	 */
	private NameType Name;
	/**
	 * In a transport contract, the deadline date by which this transportation service
	 * has to be booked. For example, if this service is scheduled for Wednesday 16
	 * February 2011 at 10 a.m. CET, the nomination date might be Tuesday15 February
	 * 2011.
	 */
	private DateType NominationDate;
	/**
	 * In a transport contract, the deadline time by which this transportation service
	 * has to be booked. For example, if this service is scheduled for Wednesday 16
	 * February 2011 at 10 a.m. CET, the nomination date might be Tuesday15 February
	 * 2011 and the nominat
	 */
	private TimeType NominationTime;
	/**
	 * The priority of this transportation service.
	 */
	private TextType Priority;
	/**
	 * A number indicating the order of this transportation service in a sequence of
	 * transportation services.
	 */
	private NumericType SequenceNumeric;
	/**
	 * A code signifying the tariff class applicable to this transportation service.
	 */
	private CodeType TariffClassCode;
	/**
	 * Text describing this transportation service.
	 */
	private TextType TransportationServiceDescription;
	/**
	 * The Uniform Resource Identifier (URI) of a document providing additional
	 * details regarding this transportation service.
	 */
	private IdentifierType TransportationServiceDetailsURIID;
	/**
	 * A code signifying the extent of this transportation service (e.g., door-to-door,
	 * port-to-port).
	 */
	private CodeType TransportServiceCode;
	private List<CommodityClassificationRepresentation> UnsupportedCommodityClassification = new ArrayList<>();
	private List<CommodityClassificationRepresentation> SupportedCommodityClassification = new ArrayList<>();
	private List<CommodityClassificationRepresentation> CommodityClassifications = new ArrayList<>();
	private DimensionRepresentation TotalCapacityDimension;
	private List<EnvironmentalEmissionRepresentation> EnvironmentalEmissions = new ArrayList<>();
	private PartyRepresentation ResponsibleTransportServiceProviderParty;
	private PeriodRepresentation EstimatedDurationPeriod;
	private ServiceFrequencyRepresentation ScheduledServiceFrequency;
	private List<ShipmentStageRepresentation> ShipmentStages = new ArrayList<>();
	private List<TransportEquipmentRepresentation> UnsupportedTransportEquipment = new ArrayList<>();
	private List<TransportEquipmentRepresentation> TransportEquipments = new ArrayList<>();
	private List<TransportEquipmentRepresentation> SupportedTransportEquipment = new ArrayList<>();
	private List<TransportEventRepresentation> TransportEvents = new ArrayList<>();

}
