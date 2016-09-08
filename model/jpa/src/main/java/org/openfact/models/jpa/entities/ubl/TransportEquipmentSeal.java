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
	private String condition;
	/**
	 * An identifier for this transport equipment seal.
	 */
	private String id;
	/**
	 * The role of the sealing party.
	 */
	private String sealingPartyType;
	/**
	 * A code signifying the type of party that issues and is responsible for
	 * this transport equipment seal.
	 */
	private String sealIssuerTypeCode;
	/**
	 * A code signifying the condition of this transport equipment seal.
	 */
	private String sealStatusCode;

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSealingPartyType() {
		return sealingPartyType;
	}

	public void setSealingPartyType(String sealingPartyType) {
		this.sealingPartyType = sealingPartyType;
	}

	public String getSealIssuerTypeCode() {
		return sealIssuerTypeCode;
	}

	public void setSealIssuerTypeCode(String sealIssuerTypeCode) {
		this.sealIssuerTypeCode = sealIssuerTypeCode;
	}

	public String getSealStatusCode() {
		return sealStatusCode;
	}

	public void setSealStatusCode(String sealStatusCode) {
		this.sealStatusCode = sealStatusCode;
	}
}// end TransportEquipmentSeal