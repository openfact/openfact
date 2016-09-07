package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

/**
 * A class to define a line in a Quotation.
 * 
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
	 * The total amount for this quotation line, including allowance charges but
	 * net of taxes.
	 */
	private BigDecimal lineExtensionAmount;
	/**
	 * Free-form text conveying information that is not contained explicitly in
	 * other structures.
	 */
	private String note;
	/**
	 * The quantity of the item quoted.
	 */
	private BigDecimal quantity;
	/**
	 * An identifier for the line in the Request for Quotation to which this
	 * line is a response.
	 */
	private String requestForQuotationLineID;
	/**
	 * The total tax amount for this quotation line.
	 */
	private BigDecimal totalTaxAmount;
	private List<DocumentReference> documentReferences = new ArrayList<>();
	private LineItem m_LineItem;
	private LineItem sellerProposedSubstituteLineItem;
	private LineItem alternativeLineItem;
	private LineReference requestLineReference;

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public BigDecimal getLineExtensionAmount() {
		return lineExtensionAmount;
	}

	public void setLineExtensionAmount(BigDecimal lineExtensionAmount) {
		this.lineExtensionAmount = lineExtensionAmount;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public String getRequestForQuotationLineID() {
		return requestForQuotationLineID;
	}

	public void setRequestForQuotationLineID(String requestForQuotationLineID) {
		this.requestForQuotationLineID = requestForQuotationLineID;
	}

	public BigDecimal getTotalTaxAmount() {
		return totalTaxAmount;
	}

	public void setTotalTaxAmount(BigDecimal totalTaxAmount) {
		this.totalTaxAmount = totalTaxAmount;
	}

	public DocumentReference getM_DocumentReference() {
		return m_DocumentReference;
	}

	public void setM_DocumentReference(DocumentReference m_DocumentReference) {
		this.m_DocumentReference = m_DocumentReference;
	}

	public LineItem getM_LineItem() {
		return m_LineItem;
	}

	public void setM_LineItem(LineItem m_LineItem) {
		this.m_LineItem = m_LineItem;
	}

	public LineItem getSellerProposedSubstituteLineItem() {
		return sellerProposedSubstituteLineItem;
	}

	public void setSellerProposedSubstituteLineItem(LineItem sellerProposedSubstituteLineItem) {
		this.sellerProposedSubstituteLineItem = sellerProposedSubstituteLineItem;
	}

	public LineItem getAlternativeLineItem() {
		return alternativeLineItem;
	}

	public void setAlternativeLineItem(LineItem alternativeLineItem) {
		this.alternativeLineItem = alternativeLineItem;
	}

	public LineReference getRequestLineReference() {
		return requestLineReference;
	}

	public void setRequestLineReference(LineReference requestLineReference) {
		this.requestLineReference = requestLineReference;
	}
}// end Quotation Line