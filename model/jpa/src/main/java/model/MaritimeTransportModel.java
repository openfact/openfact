package model;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe a vessel used for transport by water (including sea, river,
 * and canal).
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:05 a. m.
 */
public class MaritimeTransportModel{

	/**
	 * Gross tonnage is calculated by measuring a ship's volume (from keel to funnel,
	 * to the outside of the hull framing) and applying a mathematical formula and is
	 * used to determine things such as a ship's manning regulations, safety rules,
	 * registration fees an
	 */
	private MeasureType GrossTonnageMeasure;
	/**
	 * Net tonnage is calculated by measuring a ship's internal volume and applying a
	 * mathematical formula and is used to calculate the port duties.
	 */
	private MeasureType NetTonnageMeasure;
	/**
	 * The radio call sign of the vessel.
	 */
	private IdentifierType RadioCallSignID;
	/**
	 * Information about what services a vessel will require when it arrives at a port,
	 * such as refueling, maintenance, waste disposal etc.
	 */
	private TextType ShipsRequirements;
	/**
	 * An identifier for a specific vessel.
	 */
	private IdentifierType VesselID;
	/**
	 * The name of the vessel.
	 */
	private NameType VesselName;
	private DocumentReferenceModel RegistryCertificateDocumentReference;
	private LocationModel RegistryPortLocation;

}
