package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * A class to define a line in a Receipt Advice.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:17:19 a. m.
 */
public class ReceiptLine {

    /**
     * An identifier for this receipt line.
     */
    private String ID;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private String Note;
    /**
     * The quantity over-supplied, i.e., the quantity over and above the
     * quantity ordered.
     */
    private BigDecimal OversupplyQuantity;
    /**
     * A code signifying the type of a discrepancy in quantity.
     */
    private String QuantityDiscrepancyCode;
    /**
     * The date on which the goods or services were received.
     */
    private LocalDate ReceivedDate;
    /**
     * The quantity received.
     */
    private BigDecimal ReceivedQuantity;
    /**
     * A code signifying the action that the delivery party wishes the despatch
     * party to take as the result of a rejection.
     */
    private String RejectActionCode;
    /**
     * The quantity rejected.
     */
    private BigDecimal RejectedQuantity;
    /**
     * The reason for a rejection, expressed as text.
     */
    private String RejectReason;
    /**
     * The reason for a rejection, expressed as a code.
     */
    private String RejectReasonCode;
    /**
     * A code signifying the action that the delivery party wishes the despatch
     * party to take as the result of a shortage.
     */
    private String ShortageActionCode;
    /**
     * The quantity received short; the difference between the quantity reported
     * despatched and the quantity actually received.
     */
    private BigDecimal ShortQuantity;
    /**
     * A complaint about the timing of delivery, expressed as text.
     */
    private String TimingComplaint;
    /**
     * A complaint about the timing of delivery, expressed as a code.
     */
    private String TimingComplaintCode;
    /**
     * A universally unique identifier for this receipt line.
     */
    private String UUID;
    private List<DocumentReference> documentReferences = new ArrayList<>();
    private List<Item> items = new ArrayList<>();
    private LineReference DespatchLineReference;
    private List<OrderLineReference> orderLineReferences = new ArrayList<>();
    private List<Shipment> shipments = new ArrayList<>();

    /**
     * @return the iD
     */
    public String getID() {
        return ID;
    }

    /**
     * @param iD
     *            the iD to set
     */
    public void setID(String iD) {
        ID = iD;
    }

    /**
     * @return the note
     */
    public String getNote() {
        return Note;
    }

    /**
     * @param note
     *            the note to set
     */
    public void setNote(String note) {
        Note = note;
    }

    /**
     * @return the oversupplyQuantity
     */
    public BigDecimal getOversupplyQuantity() {
        return OversupplyQuantity;
    }

    /**
     * @param oversupplyQuantity
     *            the oversupplyQuantity to set
     */
    public void setOversupplyQuantity(BigDecimal oversupplyQuantity) {
        OversupplyQuantity = oversupplyQuantity;
    }

    /**
     * @return the quantityDiscrepancyCode
     */
    public String getQuantityDiscrepancyCode() {
        return QuantityDiscrepancyCode;
    }

    /**
     * @param quantityDiscrepancyCode
     *            the quantityDiscrepancyCode to set
     */
    public void setQuantityDiscrepancyCode(String quantityDiscrepancyCode) {
        QuantityDiscrepancyCode = quantityDiscrepancyCode;
    }

    /**
     * @return the receivedDate
     */
    public LocalDate getReceivedDate() {
        return ReceivedDate;
    }

    /**
     * @param receivedDate
     *            the receivedDate to set
     */
    public void setReceivedDate(LocalDate receivedDate) {
        ReceivedDate = receivedDate;
    }

    /**
     * @return the receivedQuantity
     */
    public BigDecimal getReceivedQuantity() {
        return ReceivedQuantity;
    }

    /**
     * @param receivedQuantity
     *            the receivedQuantity to set
     */
    public void setReceivedQuantity(BigDecimal receivedQuantity) {
        ReceivedQuantity = receivedQuantity;
    }

    /**
     * @return the rejectActionCode
     */
    public String getRejectActionCode() {
        return RejectActionCode;
    }

    /**
     * @param rejectActionCode
     *            the rejectActionCode to set
     */
    public void setRejectActionCode(String rejectActionCode) {
        RejectActionCode = rejectActionCode;
    }

    /**
     * @return the rejectedQuantity
     */
    public BigDecimal getRejectedQuantity() {
        return RejectedQuantity;
    }

    /**
     * @param rejectedQuantity
     *            the rejectedQuantity to set
     */
    public void setRejectedQuantity(BigDecimal rejectedQuantity) {
        RejectedQuantity = rejectedQuantity;
    }

    /**
     * @return the rejectReason
     */
    public String getRejectReason() {
        return RejectReason;
    }

    /**
     * @param rejectReason
     *            the rejectReason to set
     */
    public void setRejectReason(String rejectReason) {
        RejectReason = rejectReason;
    }

    /**
     * @return the rejectReasonCode
     */
    public String getRejectReasonCode() {
        return RejectReasonCode;
    }

    /**
     * @param rejectReasonCode
     *            the rejectReasonCode to set
     */
    public void setRejectReasonCode(String rejectReasonCode) {
        RejectReasonCode = rejectReasonCode;
    }

    /**
     * @return the shortageActionCode
     */
    public String getShortageActionCode() {
        return ShortageActionCode;
    }

    /**
     * @param shortageActionCode
     *            the shortageActionCode to set
     */
    public void setShortageActionCode(String shortageActionCode) {
        ShortageActionCode = shortageActionCode;
    }

    /**
     * @return the shortQuantity
     */
    public BigDecimal getShortQuantity() {
        return ShortQuantity;
    }

    /**
     * @param shortQuantity
     *            the shortQuantity to set
     */
    public void setShortQuantity(BigDecimal shortQuantity) {
        ShortQuantity = shortQuantity;
    }

    /**
     * @return the timingComplaint
     */
    public String getTimingComplaint() {
        return TimingComplaint;
    }

    /**
     * @param timingComplaint
     *            the timingComplaint to set
     */
    public void setTimingComplaint(String timingComplaint) {
        TimingComplaint = timingComplaint;
    }

    /**
     * @return the timingComplaintCode
     */
    public String getTimingComplaintCode() {
        return TimingComplaintCode;
    }

    /**
     * @param timingComplaintCode
     *            the timingComplaintCode to set
     */
    public void setTimingComplaintCode(String timingComplaintCode) {
        TimingComplaintCode = timingComplaintCode;
    }

    /**
     * @return the uUID
     */
    public String getUUID() {
        return UUID;
    }

    /**
     * @param uUID
     *            the uUID to set
     */
    public void setUUID(String uUID) {
        UUID = uUID;
    }

    /**
     * @return the documentReferences
     */
    public List<DocumentReference> getDocumentReferences() {
        return documentReferences;
    }

    /**
     * @param documentReferences
     *            the documentReferences to set
     */
    public void setDocumentReferences(List<DocumentReference> documentReferences) {
        this.documentReferences = documentReferences;
    }

    /**
     * @return the items
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * @param items
     *            the items to set
     */
    public void setItems(List<Item> items) {
        this.items = items;
    }

    /**
     * @return the despatchLineReference
     */
    public LineReference getDespatchLineReference() {
        return DespatchLineReference;
    }

    /**
     * @param despatchLineReference
     *            the despatchLineReference to set
     */
    public void setDespatchLineReference(LineReference despatchLineReference) {
        DespatchLineReference = despatchLineReference;
    }

    /**
     * @return the orderLineReferences
     */
    public List<OrderLineReference> getOrderLineReferences() {
        return orderLineReferences;
    }

    /**
     * @param orderLineReferences
     *            the orderLineReferences to set
     */
    public void setOrderLineReferences(List<OrderLineReference> orderLineReferences) {
        this.orderLineReferences = orderLineReferences;
    }

    /**
     * @return the shipments
     */
    public List<Shipment> getShipments() {
        return shipments;
    }

    /**
     * @param shipments
     *            the shipments to set
     */
    public void setShipments(List<Shipment> shipments) {
        this.shipments = shipments;
    }

}// end ReceiptLine