package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to describe a device (a transport equipment seal) for securing the
 * doors of a shipping container.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:39 a. m.
 */
public class TransportEquipmentSeal {

	/**
	 * The condition of this transport equipment seal.
	 */
	private String Condition;
	/**
	 * An identifier for this transport equipment seal.
	 */
	private String ID;
	/**
	 * The role of the sealing party.
	 */
	private String SealingPartyType;
	/**
	 * A code signifying the type of party that issues and is responsible for
	 * this transport equipment seal.
	 */
	private String SealIssuerTypeCode;
	/**
	 * A code signifying the condition of this transport equipment seal.
	 */
	private String SealStatusCode;

	/**
	 * @return the condition
	 */
	public String getCondition() {
		return Condition;
	}

	/**
	 * @param condition
	 *            the condition to set
	 */
	public void setCondition(String condition) {
		Condition = condition;
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
	 * @return the sealingPartyType
	 */
	public String getSealingPartyType() {
		return SealingPartyType;
	}

	/**
	 * @param sealingPartyType
	 *            the sealingPartyType to set
	 */
	public void setSealingPartyType(String sealingPartyType) {
		SealingPartyType = sealingPartyType;
	}

	/**
	 * @return the sealIssuerTypeCode
	 */
	public String getSealIssuerTypeCode() {
		return SealIssuerTypeCode;
	}

	/**
	 * @param sealIssuerTypeCode
	 *            the sealIssuerTypeCode to set
	 */
	public void setSealIssuerTypeCode(String sealIssuerTypeCode) {
		SealIssuerTypeCode = sealIssuerTypeCode;
	}

	/**
	 * @return the sealStatusCode
	 */
	public String getSealStatusCode() {
		return SealStatusCode;
	}

	/**
	 * @param sealStatusCode
	 *            the sealStatusCode to set
	 */
	public void setSealStatusCode(String sealStatusCode) {
		SealStatusCode = sealStatusCode;
	}

}// end TransportEquipmentSeal