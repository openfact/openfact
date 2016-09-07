package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

/**
 * A class to define a line in a Request for Tender describing an item of goods
 * or a service solicited in the Request for Tender.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:29 a. m.
 */
public class RequestForTenderLine {

	/**
	 * The estimated total amount of the deliverable.
	 */
	private BigDecimal EstimatedAmount;
	/**
	 * An identifier for this request for tender line.
	 */
	private String ID;
	/**
	 * The maximum amount allowed for this deliverable.
	 */
	private BigDecimal MaximumAmount;
	/**
	 * The maximum quantity of the item associated with this request for tender
	 * line.
	 */
	private BigDecimal MaximumQuantity;
	/**
	 * The minimum amount allowed for this deliverable.
	 */
	private BigDecimal MinimumAmount;
	/**
	 * The minimum quantity of the item associated with this request for tender
	 * line.
	 */
	private BigDecimal MinimumQuantity;
	/**
	 * Free-form text conveying information that is not contained explicitly in
	 * other structures.
	 */
	private String Note;
	/**
	 * The quantity of the item for which a tender is requested in this line.
	 */
	private BigDecimal Quantity;
	/**
	 * Indicates whether the amounts are taxes included (true) or not (false).
	 */
	private boolean TaxIncludedIndicator;
	/**
	 * A universally unique identifier for this request for tender line.
	 */
	private String UUID;
	private List<DocumentReference> documentReferences = new ArrayList<>();
	private List<Item> items = new ArrayList<>();
	private ItemLocationQuantity RequiredItemLocationQuantity;
	private Period DeliveryPeriod;
	private Period WarrantyValidityPeriod;
	private RequestForTenderLine SubRequestForTenderLine;

	public RequestForTenderLine() {

	}

	public void finalize() throws Throwable {

	}

	public Period getDeliveryPeriod() {
		return DeliveryPeriod;
	}

	public DocumentReference getDocumentReference() {
		return m_DocumentReference;
	}

	public BigDecimal getEstimatedAmount() {
		return EstimatedAmount;
	}

	public String getID() {
		return ID;
	}

	public Item getItem() {
		return m_Item;
	}

	public BigDecimal getMaximumAmount() {
		return MaximumAmount;
	}

	public BigDecimal getMaximumQuantity() {
		return MaximumQuantity;
	}

	public BigDecimal getMinimumAmount() {
		return MinimumAmount;
	}

	public BigDecimal getMinimumQuantity() {
		return MinimumQuantity;
	}

	public String getNote() {
		return Note;
	}

	public BigDecimal getQuantity() {
		return Quantity;
	}

	/**
	 * @return the m_DocumentReference
	 */
	public DocumentReference getM_DocumentReference() {
		return m_DocumentReference;
	}

	/**
	 * @param m_DocumentReference
	 *            the m_DocumentReference to set
	 */
	public void setM_DocumentReference(DocumentReference m_DocumentReference) {
		this.m_DocumentReference = m_DocumentReference;
	}

	/**
	 * @return the m_Item
	 */
	public Item getM_Item() {
		return m_Item;
	}

	/**
	 * @param m_Item
	 *            the m_Item to set
	 */
	public void setM_Item(Item m_Item) {
		this.m_Item = m_Item;
	}

	/**
	 * @return the requiredItemLocationQuantity
	 */
	public ItemLocationQuantity getRequiredItemLocationQuantity() {
		return RequiredItemLocationQuantity;
	}

	/**
	 * @param requiredItemLocationQuantity
	 *            the requiredItemLocationQuantity to set
	 */
	public void setRequiredItemLocationQuantity(ItemLocationQuantity requiredItemLocationQuantity) {
		RequiredItemLocationQuantity = requiredItemLocationQuantity;
	}

	/**
	 * @return the warrantyValidityPeriod
	 */
	public Period getWarrantyValidityPeriod() {
		return WarrantyValidityPeriod;
	}

	/**
	 * @param warrantyValidityPeriod
	 *            the warrantyValidityPeriod to set
	 */
	public void setWarrantyValidityPeriod(Period warrantyValidityPeriod) {
		WarrantyValidityPeriod = warrantyValidityPeriod;
	}

	/**
	 * @return the subRequestForTenderLine
	 */
	public RequestForTenderLine getSubRequestForTenderLine() {
		return SubRequestForTenderLine;
	}

	/**
	 * @param subRequestForTenderLine
	 *            the subRequestForTenderLine to set
	 */
	public void setSubRequestForTenderLine(RequestForTenderLine subRequestForTenderLine) {
		SubRequestForTenderLine = subRequestForTenderLine;
	}

	/**
	 * @param deliveryPeriod
	 *            the deliveryPeriod to set
	 */
	public void setDeliveryPeriod(Period deliveryPeriod) {
		DeliveryPeriod = deliveryPeriod;
	}

	public boolean getTaxIncludedIndicator() {
		return TaxIncludedIndicator;
	}

	public String getUUID() {
		return UUID;
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
	public void setEstimatedAmount(BigDecimal newVal) {
		EstimatedAmount = newVal;
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
	public void setMaximumAmount(BigDecimal newVal) {
		MaximumAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMaximumQuantity(BigDecimal newVal) {
		MaximumQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMinimumAmount(BigDecimal newVal) {
		MinimumAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMinimumQuantity(BigDecimal newVal) {
		MinimumQuantity = newVal;
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
	public void setQuantity(BigDecimal newVal) {
		Quantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTaxIncludedIndicator(boolean newVal) {
		TaxIncludedIndicator = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setUUID(String newVal) {
		UUID = newVal;
	}
}// end Request For TenderLine