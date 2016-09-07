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
	private String note;
	/**
	 * A code signifying the substitution status of the item on this order line.
	 * The order line may indicate that the substitute is proposed by the buyer
	 * (in Order) or by the seller (in Order Response) or that a substitution
	 * has been made by the seller (in Order
	 */
	private String substitutionStatusCode;
	private List<DocumentReference> documentReferences = new ArrayList<>();
	private LineItem sellerProposedSubstituteLineItem;
	private LineItem sellerSubstitutedLineItem;
	private List<LineItem> lineItems = new ArrayList<>();
	private LineItem buyerProposedSubstituteLineItem;
	private LineReference catalogueLineReference;
	private LineReference quotationLineReference;
	private List<OrderLineReference> orderLineReferences = new ArrayList<>();

	public OrderLine() {

	}

	public void finalize() throws Throwable {

	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getSubstitutionStatusCode() {
		return substitutionStatusCode;
	}

	public void setSubstitutionStatusCode(String substitutionStatusCode) {
		this.substitutionStatusCode = substitutionStatusCode;
	}

	public List<DocumentReference> getDocumentReferences() {
		return documentReferences;
	}

	public void setDocumentReferences(List<DocumentReference> documentReferences) {
		this.documentReferences = documentReferences;
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

	public List<LineItem> getLineItems() {
		return lineItems;
	}

	public void setLineItems(List<LineItem> lineItems) {
		this.lineItems = lineItems;
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

	public List<OrderLineReference> getOrderLineReferences() {
		return orderLineReferences;
	}

	public void setOrderLineReferences(List<OrderLineReference> orderLineReferences) {
		this.orderLineReferences = orderLineReferences;
	}
}// end Order Line