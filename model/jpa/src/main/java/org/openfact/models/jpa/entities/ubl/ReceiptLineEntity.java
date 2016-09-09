package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.DateType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.QuantityType;
import org.openfact.models.jpa.entities.ublType.TextType;

/**
 * A class to define a line in a ReceiptAdvice.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:17:19 a. m.
 */
public class ReceiptLineEntity {

    /**
     * An identifier for this receipt line.
     */
    private IdentifierType ID;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private TextType note;
    /**
     * The quantity over-supplied, i.e., the quantity over and above the
     * quantity ordered.
     */
    private QuantityType oversupplyQuantity;
    /**
     * A code signifying the type of a discrepancy in quantity.
     */
    private CodeType quantityDiscrepancyCode;
    /**
     * The date on which the goods or services were received.
     */
    private DateType receivedDate;
    /**
     * The quantity received.
     */
    private QuantityType receivedQuantity;
    /**
     * A code signifying the action that the delivery party wishes the despatch
     * party to take as the result of a rejection.
     */
    private CodeType rejectActionCode;
    /**
     * The quantity rejected.
     */
    private QuantityType rejectedQuantity;
    /**
     * The reason for a rejection, expressed as text.
     */
    private TextType rejectReason;
    /**
     * The reason for a rejection, expressed as a code.
     */
    private CodeType rejectReasonCode;
    /**
     * A code signifying the action that the delivery party wishes the despatch
     * party to take as the result of a shortage.
     */
    private CodeType shortageActionCode;
    /**
     * The quantity received short; the difference between the quantity reported
     * despatched and the quantity actually received.
     */
    private QuantityType shortQuantity;
    /**
     * A complaint about the timing of delivery, expressed as text.
     */
    private TextType timingComplaint;
    /**
     * A complaint about the timing of delivery, expressed as a code.
     */
    private CodeType timingComplaintCode;
    /**
     * A universally unique identifier for this receipt line.
     */
    private IdentifierType UUID;
    private List<DocumentReferenceEntity> documentReferences = new ArrayList<>();
    private List<ItemEntity> items = new ArrayList<>();
    private LineReferenceEntity despatchLineReference;
    private List<OrderLineReferenceEntity> orderLineReferences = new ArrayList<>();
    private List<ShipmentEntity> shipments = new ArrayList<>();

}
