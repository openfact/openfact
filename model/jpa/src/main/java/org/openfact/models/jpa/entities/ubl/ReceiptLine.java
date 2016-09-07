package org.openfact.models.jpa.entities.ubl;

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
	private DocumentReference m_DocumentReference;
	private Item m_Item;
	private LineReference DespatchLineReference;
	private OrderLineReference m_OrderLineReference;
	private Shipment m_Shipment;

	public ReceiptLine() {

	}

	public void finalize() throws Throwable {

	}

	public LineReference getDespatchLineReference() {
		return DespatchLineReference;
	}

	public DocumentReference getDocumentReference() {
		return m_DocumentReference;
	}

	public String getID() {
		return ID;
	}

	public Item getItem() {
		return m_Item;
	}

	public String getNote() {
		return Note;
	}

	public OrderLineReference getOrderLineReference() {
		return m_OrderLineReference;
	}

	public BigDecimal getOversupplyQuantity() {
		return OversupplyQuantity;
	}

	public String getQuantityDiscrepancyCode() {
		return QuantityDiscrepancyCode;
	}

	public LocalDate getReceivedDate() {
		return ReceivedDate;
	}

	public BigDecimal getReceivedQuantity() {
		return ReceivedQuantity;
	}

	public String getRejectActionCode() {
		return RejectActionCode;
	}

	public BigDecimal getRejectedQuantity() {
		return RejectedQuantity;
	}

	public String getRejectReason() {
		return RejectReason;
	}

	public String getRejectReasonCode() {
		return RejectReasonCode;
	}

	public Shipment getShipment() {
		return m_Shipment;
	}

	public String getShortageActionCode() {
		return ShortageActionCode;
	}

	public BigDecimal getShortQuantity() {
		return ShortQuantity;
	}

	public String getTimingComplaint() {
		return TimingComplaint;
	}

	public String getTimingComplaintCode() {
		return TimingComplaintCode;
	}

	public String getUUID() {
		return UUID;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDespatchLineReference(LineReference newVal) {
		DespatchLineReference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDocumentReference(DocumentReference newVal) {
		m_DocumentReference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setID(String newVal) {
		ID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setItem(Item newVal) {
		m_Item = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNote(String newVal) {
		Note = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setOrderLineReference(OrderLineReference newVal) {
		m_OrderLineReference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setOversupplyQuantity(BigDecimal newVal) {
		OversupplyQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setQuantityDiscrepancyCode(String newVal) {
		QuantityDiscrepancyCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setReceivedDate(LocalDate newVal) {
		ReceivedDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setReceivedQuantity(BigDecimal newVal) {
		ReceivedQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRejectActionCode(String newVal) {
		RejectActionCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRejectedQuantity(BigDecimal newVal) {
		RejectedQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRejectReason(String newVal) {
		RejectReason = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRejectReasonCode(String newVal) {
		RejectReasonCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setShipment(Shipment newVal) {
		m_Shipment = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setShortageActionCode(String newVal) {
		ShortageActionCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setShortQuantity(BigDecimal newVal) {
		ShortQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTimingComplaint(String newVal) {
		TimingComplaint = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTimingComplaintCode(String newVal) {
		TimingComplaintCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setUUID(String newVal) {
		UUID = newVal;
	}
}// end ReceiptLine