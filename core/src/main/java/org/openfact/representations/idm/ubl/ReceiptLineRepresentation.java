package org.openfact.representations.idm.ubl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.QuantityRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A class to define a line in a ReceiptAdvice.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:17:19 a. m.
 */
public class ReceiptLineRepresentation {

    /**
     * An identifier for this receipt line.
     */
    private IdentifierRepresentation ID;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private TextRepresentation note;
    /**
     * The quantity over-supplied, i.e., the quantity over and above the
     * quantity ordered.
     */
    private QuantityRepresentation oversupplyQuantity;
    /**
     * A code signifying the type of a discrepancy in quantity.
     */
    private CodeRepresentation quantityDiscrepancyCode;
    /**
     * The date on which the goods or services were received.
     */
    private LocalDate receivedDate;
    /**
     * The quantity received.
     */
    private QuantityRepresentation receivedQuantity;
    /**
     * A code signifying the action that the delivery party wishes the despatch
     * party to take as the result of a rejection.
     */
    private CodeRepresentation rejectActionCode;
    /**
     * The quantity rejected.
     */
    private QuantityRepresentation rejectedQuantity;
    /**
     * The reason for a rejection, expressed as text.
     */
    private TextRepresentation rejectReason;
    /**
     * The reason for a rejection, expressed as a code.
     */
    private CodeRepresentation rejectReasonCode;
    /**
     * A code signifying the action that the delivery party wishes the despatch
     * party to take as the result of a shortage.
     */
    private CodeRepresentation shortageActionCode;
    /**
     * The quantity received short; the difference between the quantity reported
     * despatched and the quantity actually received.
     */
    private QuantityRepresentation shortQuantity;
    /**
     * A complaint about the timing of delivery, expressed as text.
     */
    private TextRepresentation timingComplaint;
    /**
     * A complaint about the timing of delivery, expressed as a code.
     */
    private CodeRepresentation timingComplaintCode;
    /**
     * A universally unique identifier for this receipt line.
     */
    private IdentifierRepresentation UUID;
    private List<DocumentReferenceRepresentation> documentReferences = new ArrayList<>();
    private List<ItemRepresentation> items = new ArrayList<>();
    private LineReferenceRepresentation despatchLineReference;
    private List<OrderLineReferenceRepresentation> orderLineReferences = new ArrayList<>();
    private List<ShipmentRepresentation> shipments = new ArrayList<>();

}
