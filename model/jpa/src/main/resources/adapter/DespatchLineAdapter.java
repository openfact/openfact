package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a line in a DespatchAdvice.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:29 a. m.
 */
public class DespatchLineAdapter{

	/**
	 * The quantity on back order at the supplier.
	 */
	private QuantityType backorderQuantity; 
	/**
	 * The reason for the back order.
	 */
	private TextType backorderReason; 
	/**
	 * The quantity despatched (picked up).
	 */
	private QuantityType deliveredQuantity; 
	/**
	 * An identifier for this despatch line.
	 */
	private IdentifierType ID; 
	/**
	 * A code signifying the status of this despatch line with respect to its original
	 * state.
	 */
	private LineStatusCodeType lineStatusCode; 
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private TextType note; 
	/**
	 * The quantity outstanding (which will follow in a later despatch).
	 */
	private QuantityType outstandingQuantity; 
	/**
	 * The reason for the outstanding quantity.
	 */
	private TextType outstandingReason; 
	/**
	 * The quantity over-supplied, i.e., the quantity over and above that ordered.
	 */
	private QuantityType oversupplyQuantity; 
	/**
	 * A universally unique identifier for this despatch line.
	 */
	private IdentifierType UUID; 
	private List<DocumentReferenceAdapter> documentReferences = new ArrayList<>(); 
	private List<ItemAdapter> items = new ArrayList<>(); 
	private List<OrderLineReferenceAdapter> orderLineReferences = new ArrayList<>(); 
	private List<ShipmentAdapter> shipments = new ArrayList<>(); 

}
