package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to describe a physical attribute.
 * 
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:16:48 a. m.
 */
public class PhysicalAttribute {

	/**
	 * An identifier for this physical attribute.
	 */
	private String attributeID;
	/**
	 * A description of the physical attribute, expressed as text.
	 */
	private String description;
	/**
	 * A description of the physical attribute, expressed as a code.
	 */
	private String descriptionCode;
	/**
	 * A code signifying the position of this physical attribute.
	 */
	private String positionCode;

	public PhysicalAttribute() {

	}

	public void finalize() throws Throwable {

	}

	public String getAttributeID() {
		return attributeID;
	}

	public void setAttributeID(String attributeID) {
		this.attributeID = attributeID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescriptionCode() {
		return descriptionCode;
	}

	public void setDescriptionCode(String descriptionCode) {
		this.descriptionCode = descriptionCode;
	}

	public String getPositionCode() {
		return positionCode;
	}

	public void setPositionCode(String positionCode) {
		this.positionCode = positionCode;
	}
}// end Physical Attribute