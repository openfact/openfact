package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to describe purchasing, sales, or payment conditions.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:35 a. m.
 */
public class TransactionConditions {

	/**
	 * A code signifying a type of action relating to sales or payment
	 * conditions.
	 */
	private String ActionCode;
	/**
	 * Text describing the transaction conditions.
	 */
	private String Description;
	/**
	 * An identifier for conditions of the transaction, typically purchase/sales
	 * conditions.
	 */
	private String ID;
	private List<DocumentReference> documentReferences = new ArrayList<>();

	/**
	 * @return the actionCode
	 */
	public String getActionCode() {
		return ActionCode;
	}

	/**
	 * @param actionCode
	 *            the actionCode to set
	 */
	public void setActionCode(String actionCode) {
		ActionCode = actionCode;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return Description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		Description = description;
	}

	/**
	 * @return the iD
	 */
	public String getID() {
		return ID;
	}

	/**
	 * @param iD
	 *            the iD to set
	 */
	public void setID(String iD) {
		ID = iD;
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

}// end Transaction Conditions