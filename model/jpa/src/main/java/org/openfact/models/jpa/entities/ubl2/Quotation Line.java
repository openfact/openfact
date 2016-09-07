

/**
 * A class to define a line in a Quotation.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:17:16 a. m.
 */
public class Quotation Line {

	/**
	 * An identifier for this quotation line.
	 */
	private Identifier. Type ID;
	/**
	 * The total amount for this quotation line, including allowance charges but net
	 * of taxes.
	 */
	private Amount. Type LineExtensionAmount;
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private Text. Type Note;
	/**
	 * The quantity of the item quoted.
	 */
	private Quantity. Type Quantity;
	/**
	 * An identifier for the line in the Request for Quotation to which this line is a
	 * response.
	 */
	private Identifier. Type RequestForQuotationLineID;
	/**
	 * The total tax amount for this quotation line.
	 */
	private Amount. Type TotalTaxAmount;
	private Document Reference m_Document Reference;
	private Line Item m_Line Item;
	private Line Item Seller Proposed Substitute Line Item;
	private Line Item Alternative Line Item;
	private Line Reference Request Line Reference;

	public Quotation Line(){

	}

	public void finalize() throws Throwable {

	}
	public Line Item getAlternative Line Item(){
		return Alternative Line Item;
	}

	public Document Reference getDocument Reference(){
		return m_Document Reference;
	}

	public Identifier. Type getID(){
		return ID;
	}

	public Line Item getLine Item(){
		return m_Line Item;
	}

	public Amount. Type getLineExtensionAmount(){
		return LineExtensionAmount;
	}

	public Text. Type getNote(){
		return Note;
	}

	public Quantity. Type getQuantity(){
		return Quantity;
	}

	public Line Reference getRequest Line Reference(){
		return Request Line Reference;
	}

	public Identifier. Type getRequestForQuotationLineID(){
		return RequestForQuotationLineID;
	}

	public Line Item getSeller Proposed Substitute Line Item(){
		return Seller Proposed Substitute Line Item;
	}

	public Amount. Type getTotalTaxAmount(){
		return TotalTaxAmount;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAlternative Line Item(Line Item newVal){
		Alternative Line Item = newVal;
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
	public void setLine Item(Line Item newVal){
		m_Line Item = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLineExtensionAmount(Amount. Type newVal){
		LineExtensionAmount = newVal;
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
	public void setQuantity(Quantity. Type newVal){
		Quantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRequest Line Reference(Line Reference newVal){
		Request Line Reference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRequestForQuotationLineID(Identifier. Type newVal){
		RequestForQuotationLineID = newVal;
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
	public void setTotalTaxAmount(Amount. Type newVal){
		TotalTaxAmount = newVal;
	}
}//end Quotation Line