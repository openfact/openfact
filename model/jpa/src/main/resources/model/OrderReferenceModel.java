package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a reference to an Order.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:18 a. m.
 */
public class OrderReferenceModel{

	/**
	 * Indicates whether the referenced OrderModel is a copy (true) or the original (false).
	 */
	private boolean copyIndicator; 
	/**
	 * Text used for tagging purchasing card transactions.
	 */
	private TextType customerReference; 
	/**
	 * An identifier for this order reference, assigned by the buyer.
	 */
	private IdentifierType ID; 
	/**
	 * The date on which the referenced OrderModel was issued.
	 */
	private LocalDate issueDate; 
	/**
	 * The time at which the referenced OrderModel was issued.
	 */
	private LocalTime issueTime; 
	/**
	 * A code signifying the type of the referenced Order.
	 */
	private CodeType orderTypeCode; 
	/**
	 * An identifier for this order reference, assigned by the seller.
	 */
	private IdentifierType salesOrderID; 
	/**
	 * A universally unique identifier for this order reference.
	 */
	private IdentifierType UUID; 
	private List<DocumentReferenceModel> documentReferences = new ArrayList<>(); 

}
