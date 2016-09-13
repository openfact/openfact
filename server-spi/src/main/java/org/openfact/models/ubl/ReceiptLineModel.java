package org.openfact.models.ubl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A class to define a line in a ReceiptAdvice.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:17:19 a. m.
 */
public class ReceiptLineModel {

    /**
     * An identifier for this receipt line.
     */
    private IdentifierModel ID;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private TextModel note;
    /**
     * The quantity over-supplied, i.e., the quantity over and above the
     * quantity ordered.
     */
    private QuantityModel oversupplyQuantity;
    /**
     * A code signifying the type of a discrepancy in quantity.
     */
    private CodeModel quantityDiscrepancyCode;
    /**
     * The date on which the goods or services were received.
     */
    private LocalDate receivedDate;
    /**
     * The quantity received.
     */
    private QuantityModel receivedQuantity;
    /**
     * A code signifying the action that the delivery party wishes the despatch
     * party to take as the result of a rejection.
     */
    private CodeModel rejectActionCode;
    /**
     * The quantity rejected.
     */
    private QuantityModel rejectedQuantity;
    /**
     * The reason for a rejection, expressed as text.
     */
    private TextModel rejectReason;
    /**
     * The reason for a rejection, expressed as a code.
     */
    private CodeModel rejectReasonCode;
    /**
     * A code signifying the action that the delivery party wishes the despatch
     * party to take as the result of a shortage.
     */
    private CodeModel shortageActionCode;
    /**
     * The quantity received short; the difference between the quantity reported
     * despatched and the quantity actually received.
     */
    private QuantityModel shortQuantity;
    /**
     * A complaint about the timing of delivery, expressed as text.
     */
    private TextModel timingComplaint;
    /**
     * A complaint about the timing of delivery, expressed as a code.
     */
    private CodeModel timingComplaintCode;
    /**
     * A universally unique identifier for this receipt line.
     */
    private IdentifierModel UUID;
    private List<DocumentReferenceModel> documentReferences = new ArrayList<>();
    private List<ItemModel> items = new ArrayList<>();
    private LineReferenceModel despatchLineReference;
    private List<OrderLineReferenceModel> orderLineReferences = new ArrayList<>();
    private List<ShipmentModel> shipments = new ArrayList<>();

}
