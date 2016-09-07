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
	private Text. Type Note;
	/**
	 * A code signifying the substitution status of the item on this order line. The
	 * order line may indicate that the substitute is proposed by the buyer (in Order)
	 * or by the seller (in Order Response) or that a substitution has been made by
	 * the seller (in Order
	 */
	private Substitution Status_ Code. Type SubstitutionStatusCode;
	private Document Reference m_Document Reference;
	private Line Item Seller Proposed Substitute Line Item;
	private Line Item Seller Substituted Line Item;
	private Line Item m_Line Item;
	private Line Item Buyer Proposed Substitute Line Item;
	private Line Reference Catalogue Line Reference;
	private Line Reference Quotation Line Reference;
	private Order Line Reference m_Order Line Reference;

	public Order Line(){

	}

	public void finalize() throws Throwable {

	}
	public Line Item getBuyer Proposed Substitute Line Item(){
		return Buyer Proposed Substitute Line Item;
	}

	public Line Reference getCatalogue Line Reference(){
		return Catalogue Line Reference;
	}

	public Document Reference getDocument Reference(){
		return m_Document Reference;
	}

	public Line Item getLine Item(){
		return m_Line Item;
	}

	public Text. Type getNote(){
		return Note;
	}

	public Order Line Reference getOrder Line Reference(){
		return m_Order Line Reference;
	}

	public Line Reference getQuotation Line Reference(){
		return Quotation Line Reference;
	}

	public Line Item getSeller Proposed Substitute Line Item(){
		return Seller Proposed Substitute Line Item;
	}

	public Line Item getSeller Substituted Line Item(){
		return Seller Substituted Line Item;
	}

	public Substitution Status_ Code. Type getSubstitutionStatusCode(){
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
	public void setCatalogue Line Reference(Line Reference newVal){
		Catalogue Line Reference = newVal;
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
	public void setLine Item(Line Item newVal){
		m_Line Item = newVal;
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
	public void setQuotation Line Reference(Line Reference newVal){
		Quotation Line Reference = newVal;
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
	public void setSubstitutionStatusCode(Substitution Status_ Code. Type newVal){
		SubstitutionStatusCode = newVal;
	}
}//end Order Line