package org.openfact.models.jpa.entities.ubl;


/**
 * A class to define a line in a Quotation.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:17:16 a. m.
 */
public class QuotationLine {

	/**
	 * An identifier for this quotation line.
	 */
	private String ID;
	/**
	 * The total amount for this quotation line, including allowance charges but net
	 * of taxes.
	 */
	private BigDecimal LineExtensionAmount;
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private String Note;
	/**
	 * The quantity of the item quoted.
	 */
	private BigDecimal Quantity;
	/**
	 * An identifier for the line in the Request for Quotation to which this line is a
	 * response.
	 */
	private String RequestForQuotationLineID;
	/**
	 * The total tax amount for this quotation line.
	 */
	private BigDecimal TotalTaxAmount;
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

	public String getID(){
		return ID;
	}

	public Line Item getLine Item(){
		return m_Line Item;
	}

	public BigDecimal getLineExtensionAmount(){
		return LineExtensionAmount;
	}

	public String getNote(){
		return Note;
	}

	public BigDecimal getQuantity(){
		return Quantity;
	}

	public Line Reference getRequest Line Reference(){
		return Request Line Reference;
	}

	public String getRequestForQuotationLineID(){
		return RequestForQuotationLineID;
	}

	public Line Item getSeller Proposed Substitute Line Item(){
		return Seller Proposed Substitute Line Item;
	}

	public BigDecimal getTotalTaxAmount(){
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
	public void setID(String newVal){
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
	public void setLineExtensionAmount(BigDecimal newVal){
		LineExtensionAmount = newVal;
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
	public void setQuantity(BigDecimal newVal){
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
	public void setRequestForQuotationLineID(String newVal){
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
	public void setTotalTaxAmount(BigDecimal newVal){
		TotalTaxAmount = newVal;
	}
}//end Quotation Line