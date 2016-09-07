

/**
 * A class to define a line in a Receipt Advice.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:17:19 a. m.
 */
public class ReceiptLine {

	/**
	 * An identifier for this receipt line.
	 */
	private Identifier. Type ID;
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private Text. Type Note;
	/**
	 * The quantity over-supplied, i.e., the quantity over and above the quantity
	 * ordered.
	 */
	private Quantity. Type OversupplyQuantity;
	/**
	 * A code signifying the type of a discrepancy in quantity.
	 */
	private Code. Type QuantityDiscrepancyCode;
	/**
	 * The date on which the goods or services were received.
	 */
	private Date. Type ReceivedDate;
	/**
	 * The quantity received.
	 */
	private Quantity. Type ReceivedQuantity;
	/**
	 * A code signifying the action that the delivery party wishes the despatch party
	 * to take as the result of a rejection.
	 */
	private Code. Type RejectActionCode;
	/**
	 * The quantity rejected.
	 */
	private Quantity. Type RejectedQuantity;
	/**
	 * The reason for a rejection, expressed as text.
	 */
	private Text. Type RejectReason;
	/**
	 * The reason for a rejection, expressed as a code.
	 */
	private Code. Type RejectReasonCode;
	/**
	 * A code signifying the action that the delivery party wishes the despatch party
	 * to take as the result of a shortage.
	 */
	private Code. Type ShortageActionCode;
	/**
	 * The quantity received short; the difference between the quantity reported
	 * despatched and the quantity actually received.
	 */
	private Quantity. Type ShortQuantity;
	/**
	 * A complaint about the timing of delivery, expressed as text.
	 */
	private Text. Type TimingComplaint;
	/**
	 * A complaint about the timing of delivery, expressed as a code.
	 */
	private Code. Type TimingComplaintCode;
	/**
	 * A universally unique identifier for this receipt line.
	 */
	private Identifier. Type UUID;
	private Document Reference m_Document Reference;
	private Item m_Item;
	private Line Reference Despatch Line Reference;
	private Order Line Reference m_Order Line Reference;
	private Shipment m_Shipment;

	public Receipt Line(){

	}

	public void finalize() throws Throwable {

	}
	public Line Reference getDespatch Line Reference(){
		return Despatch Line Reference;
	}

	public Document Reference getDocument Reference(){
		return m_Document Reference;
	}

	public Identifier. Type getID(){
		return ID;
	}

	public Item getItem(){
		return m_Item;
	}

	public Text. Type getNote(){
		return Note;
	}

	public Order Line Reference getOrder Line Reference(){
		return m_Order Line Reference;
	}

	public Quantity. Type getOversupplyQuantity(){
		return OversupplyQuantity;
	}

	public Code. Type getQuantityDiscrepancyCode(){
		return QuantityDiscrepancyCode;
	}

	public Date. Type getReceivedDate(){
		return ReceivedDate;
	}

	public Quantity. Type getReceivedQuantity(){
		return ReceivedQuantity;
	}

	public Code. Type getRejectActionCode(){
		return RejectActionCode;
	}

	public Quantity. Type getRejectedQuantity(){
		return RejectedQuantity;
	}

	public Text. Type getRejectReason(){
		return RejectReason;
	}

	public Code. Type getRejectReasonCode(){
		return RejectReasonCode;
	}

	public Shipment getShipment(){
		return m_Shipment;
	}

	public Code. Type getShortageActionCode(){
		return ShortageActionCode;
	}

	public Quantity. Type getShortQuantity(){
		return ShortQuantity;
	}

	public Text. Type getTimingComplaint(){
		return TimingComplaint;
	}

	public Code. Type getTimingComplaintCode(){
		return TimingComplaintCode;
	}

	public Identifier. Type getUUID(){
		return UUID;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDespatch Line Reference(Line Reference newVal){
		Despatch Line Reference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDocument Reference(Document Reference newVal){
		m_Document Reference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setID(Identifier. Type newVal){
		ID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setItem(Item newVal){
		m_Item = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNote(Text. Type newVal){
		Note = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setOrder Line Reference(Order Line Reference newVal){
		m_Order Line Reference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setOversupplyQuantity(Quantity. Type newVal){
		OversupplyQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setQuantityDiscrepancyCode(Code. Type newVal){
		QuantityDiscrepancyCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setReceivedDate(Date. Type newVal){
		ReceivedDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setReceivedQuantity(Quantity. Type newVal){
		ReceivedQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRejectActionCode(Code. Type newVal){
		RejectActionCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRejectedQuantity(Quantity. Type newVal){
		RejectedQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRejectReason(Text. Type newVal){
		RejectReason = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRejectReasonCode(Code. Type newVal){
		RejectReasonCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setShipment(Shipment newVal){
		m_Shipment = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setShortageActionCode(Code. Type newVal){
		ShortageActionCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setShortQuantity(Quantity. Type newVal){
		ShortQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTimingComplaint(Text. Type newVal){
		TimingComplaint = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTimingComplaintCode(Code. Type newVal){
		TimingComplaintCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setUUID(Identifier. Type newVal){
		UUID = newVal;
	}
}//end Receipt Line