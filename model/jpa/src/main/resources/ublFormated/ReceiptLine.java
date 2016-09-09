package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a line in a ReceiptAdvice.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:17:19 a. m.
 */
public class ReceiptLine{

	/**
	 * An identifier for this receipt line.
	 */
	private IdentifierType ID;
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private TextType Note;
	/**
	 * The quantity over-supplied, i.e., the quantity over and above the quantity
	 * ordered.
	 */
	private QuantityType OversupplyQuantity;
	/**
	 * A code signifying the type of a discrepancy in quantity.
	 */
	private CodeType QuantityDiscrepancyCode;
	/**
	 * The date on which the goods or services were received.
	 */
	private DateType ReceivedDate;
	/**
	 * The quantity received.
	 */
	private QuantityType ReceivedQuantity;
	/**
	 * A code signifying the action that the delivery party wishes the despatch party
	 * to take as the result of a rejection.
	 */
	private CodeType RejectActionCode;
	/**
	 * The quantity rejected.
	 */
	private QuantityType RejectedQuantity;
	/**
	 * The reason for a rejection, expressed as text.
	 */
	private TextType RejectReason;
	/**
	 * The reason for a rejection, expressed as a code.
	 */
	private CodeType RejectReasonCode;
	/**
	 * A code signifying the action that the delivery party wishes the despatch party
	 * to take as the result of a shortage.
	 */
	private CodeType ShortageActionCode;
	/**
	 * The quantity received short; the difference between the quantity reported
	 * despatched and the quantity actually received.
	 */
	private QuantityType ShortQuantity;
	/**
	 * A complaint about the timing of delivery, expressed as text.
	 */
	private TextType TimingComplaint;
	/**
	 * A complaint about the timing of delivery, expressed as a code.
	 */
	private CodeType TimingComplaintCode;
	/**
	 * A universally unique identifier for this receipt line.
	 */
	private IdentifierType UUID;
	private List<DocumentReference> DocumentReferences = new ArrayList<>();
	private List<Item> Items = new ArrayList<>();
	private LineReference DespatchLineReference;
	private List<OrderLineReference> OrderLineReferences = new ArrayList<>();
	private List<Shipment> Shipments = new ArrayList<>();

}
