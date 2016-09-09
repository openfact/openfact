package model;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe a specific, trackable instance of an item.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:45 a. m.
 */
public class ItemInstanceModel{

	/**
	 * The date before which it is best to use this item instance.
	 */
	private DateType BestBeforeDate;
	/**
	 * The date on which this item instance was manufactured.
	 */
	private DateType ManufactureDate;
	/**
	 * The time at which this item instance was manufactured.
	 */
	private TimeType ManufactureTime;
	/**
	 * An identifier used for tracing this item instance, such as the EPC number used
	 * in RFID.
	 */
	private IdentifierType ProductTraceID;
	/**
	 * The registration identifier of this item instance.
	 */
	private IdentifierType RegistrationID;
	/**
	 * The serial number of this item instance.
	 */
	private IdentifierType SerialID;
	private ItemPropertyModel AdditionalItemProperty;
	private List<LotIdentificationModel> LotIdentifications = new ArrayList<>();

}
