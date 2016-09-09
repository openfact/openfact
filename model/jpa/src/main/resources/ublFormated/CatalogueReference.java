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
public class CatalogueReference{

	/**
	 * Text describing the catalogue.
	 */
	private TextType Description;
	/**
	 * An identifier for a specific catalogue.
	 */
	private IdentifierType ID;
	/**
	 * The date on which the catalogue was issued.
	 */
	private LocalDate IssueDate;
	/**
	 * The time at which the catalogue was issued.
	 */
	private LocalTime IssueTime;
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private TextType Note;
	/**
	 * An identifier for the previous version of the catalogue that is superseded by
	 * this version.
	 */
	private IdentifierType PreviousVersionID;
	/**
	 * The date on which the information in the catalogue was last revised.
	 */
	private LocalDate RevisionDate;
	/**
	 * The time at which the information in the catalogue was last revised.
	 */
	private LocalTime RevisionTime;
	/**
	 * A universally unique identifier for a specific catalogue.
	 */
	private IdentifierType UUID;
	/**
	 * An identifier for the current version of the catalogue.
	 */
	private IdentifierType VersionID;

}
