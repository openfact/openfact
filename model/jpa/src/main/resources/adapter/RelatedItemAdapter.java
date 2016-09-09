package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe the relationship to an item different from the item
 * associated with the item line in which RelatedItemAdapter is used.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:17:22 a. m.
 */
public class RelatedItemAdapter{

	/**
	 * Text describing the relationship.
	 */
	private TextType description; 
	/**
	 * An identifier for the related item.
	 */
	private IdentifierType ID; 
	/**
	 * The quantity that applies to the relationship.
	 */
	private QuantityType quantity; 

}
