package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a reference to a catalogue.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:23 a. m.
 */
public class CatalogueReferenceRepresentation{

	/**
	 * Text describing the catalogue.
	 */
	private TextType description; 
	/**
	 * An identifier for a specific catalogue.
	 */
	private IdentifierType ID; 
	/**
	 * The date on which the catalogue was issued.
	 */
	private LocalDate issueDate; 
	/**
	 * The time at which the catalogue was issued.
	 */
	private LocalTime issueTime; 
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private TextType note; 
	/**
	 * An identifier for the previous version of the catalogue that is superseded by
	 * this version.
	 */
	private IdentifierType previousVersionID; 
	/**
	 * The date on which the information in the catalogue was last revised.
	 */
	private LocalDate revisionDate; 
	/**
	 * The time at which the information in the catalogue was last revised.
	 */
	private LocalTime revisionTime; 
	/**
	 * A universally unique identifier for a specific catalogue.
	 */
	private IdentifierType UUID; 
	/**
	 * An identifier for the current version of the catalogue.
	 */
	private IdentifierType versionID; 

}
