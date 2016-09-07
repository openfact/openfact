package org.openfact.models.jpa.entities.ubl;


/**
 * A class to define a line in an order document (e.g., Order, Order Change, or
 * Order Response) describing an item being ordered.
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:16:15 a. m.
 */
public class OrderLine {

	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private String Note;
	/**
	 * A code signifying the substitution status of the item on this order line. The
	 * order line may indicate that the substitute is proposed by the buyer (in Order)
	 * or by the seller (in Order Response) or that a substitution has been made by
	 * the seller (in Order
	 */
	private Substitution Status_ String SubstitutionStatusCode;
	private DocumentReference m_DocumentReference;
	private Line Item Seller Proposed Substitute Line Item;
	private Line Item Seller Substituted Line Item;
	private Line Item m_Line Item;
	private Line Item Buyer Proposed Substitute Line Item;
	private LineReference Catalogue LineReference;
	private LineReference Quotation LineReference;
	private OrderLineReference m_OrderLineReference;

	public Order Line(){

	}

	public void finalize() throws Throwable {

	}
	public Line Item getBuyer Proposed Substitute Line Item(){
		return Buyer Proposed Substitute Line Item;
	}

	public LineReference getCatalogue LineReference(){
		return Catalogue LineReference;
	}

	public DocumentReference getDocumentReference(){
		return m_DocumentReference;
	}

	public Line Item getLine Item(){
		return m_Line Item;
	}

	public String getNote(){
		return Note;
	}

	public OrderLineReference getOrderLineReference(){
		return m_OrderLineReference;
	}

	public LineReference getQuotation LineReference(){
		return Quotation LineReference;
	}

	public Line Item getSeller Proposed Substitute Line Item(){
		return Seller Proposed Substitute Line Item;
	}

	public Line Item getSeller Substituted Line Item(){
		return Seller Substituted Line Item;
	}

	public Substitution Status_ String getSubstitutionStatusCode(){
		return SubstitutionStatusCode;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setBuyer Proposed Substitute Line Item(Line Item newVal){
		Buyer Proposed Substitute Line Item = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCatalogue LineReference(LineReference newVal){
		Catalogue LineReference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDocumentReference(DocumentReference newVal){
		m_DocumentReference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLine Item(Line Item newVal){
		m_Line Item = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNote(String newVal){
		Note = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setOrderLineReference(OrderLineReference newVal){
		m_OrderLineReference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setQuotation LineReference(LineReference newVal){
		Quotation LineReference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSeller Proposed Substitute Line Item(Line Item newVal){
		Seller Proposed Substitute Line Item = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSeller Substituted Line Item(Line Item newVal){
		Seller Substituted Line Item = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSubstitutionStatusCode(Substitution Status_ String newVal){
		SubstitutionStatusCode = newVal;
	}
}//end Order Line