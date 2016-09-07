package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to define a line in an order document (e.g., Order, Order Change, or
 * Order Response) describing an item being ordered.
 * 
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:16:15 a. m.
 */
public class OrderLine {

	/**
	 * Free-form text conveying information that is not contained explicitly in
	 * other structures.
	 */
	private String Note;
	/**
	 * A code signifying the substitution status of the item on this order line.
	 * The order line may indicate that the substitute is proposed by the buyer
	 * (in Order) or by the seller (in Order Response) or that a substitution
	 * has been made by the seller (in Order
	 */
	private String SubstitutionStatusCode;
	private List<DocumentReference> documentReferences = new ArrayList<>();
	private LineItem sellerProposedSubstituteLineItem;
	private LineItem sellerSubstitutedLineItem;
	private LineItem m_LineItem;
	private LineItem buyerProposedSubstituteLineItem;
	private LineReference catalogueLineReference;
	private LineReference quotationLineReference;
	private OrderLineReference m_OrderLineReference;

	public OrderLine() {

	}

	public void finalize() throws Throwable {

	}

	public String getNote() {
		return Note;
	}

	public void setNote(String note) {
		Note = note;
	}

	public String getSubstitutionStatusCode() {
		return SubstitutionStatusCode;
	}

	public void setSubstitutionStatusCode(String substitutionStatusCode) {
		SubstitutionStatusCode = substitutionStatusCode;
	}

	public DocumentReference getM_DocumentReference() {
		return m_DocumentReference;
	}

	public void setM_DocumentReference(DocumentReference m_DocumentReference) {
		this.m_DocumentReference = m_DocumentReference;
	}

	public LineItem getSellerProposedSubstituteLineItem() {
		return sellerProposedSubstituteLineItem;
	}

	public void setSellerProposedSubstituteLineItem(LineItem sellerProposedSubstituteLineItem) {
		this.sellerProposedSubstituteLineItem = sellerProposedSubstituteLineItem;
	}

	public LineItem getSellerSubstitutedLineItem() {
		return sellerSubstitutedLineItem;
	}

	public void setSellerSubstitutedLineItem(LineItem sellerSubstitutedLineItem) {
		this.sellerSubstitutedLineItem = sellerSubstitutedLineItem;
	}

	public LineItem getM_LineItem() {
		return m_LineItem;
	}

	public void setM_LineItem(LineItem m_LineItem) {
		this.m_LineItem = m_LineItem;
	}

	public LineItem getBuyerProposedSubstituteLineItem() {
		return buyerProposedSubstituteLineItem;
	}

	public void setBuyerProposedSubstituteLineItem(LineItem buyerProposedSubstituteLineItem) {
		this.buyerProposedSubstituteLineItem = buyerProposedSubstituteLineItem;
	}

	public LineReference getCatalogueLineReference() {
		return catalogueLineReference;
	}

	public void setCatalogueLineReference(LineReference catalogueLineReference) {
		this.catalogueLineReference = catalogueLineReference;
	}

	public LineReference getQuotationLineReference() {
		return quotationLineReference;
	}

	public void setQuotationLineReference(LineReference quotationLineReference) {
		this.quotationLineReference = quotationLineReference;
	}

	public OrderLineReference getM_OrderLineReference() {
		return m_OrderLineReference;
	}

	public void setM_OrderLineReference(OrderLineReference m_OrderLineReference) {
		this.m_OrderLineReference = m_OrderLineReference;
	}
}// end Order Line