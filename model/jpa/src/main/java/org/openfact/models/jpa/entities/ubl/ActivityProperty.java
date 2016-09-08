package org.openfact.models.jpa.entities.ubl;


import org.openfact.models.jpa.entities.ublType.NameType;
import org.openfact.models.jpa.entities.ublType.TextType;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to define a name/value pair for a property of an inventory planning
 * activity.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:12:36 a. m.
 */
public class ActivityProperty {

	/**
	 * The name of this activity property.
	 */
	private NameType name;

	/**
	 * The value of this activity property.
	 */
	private TextType value;

	public NameType getName() {
		return name;
	}

	public void setName(NameType name) {
		this.name = name;
	}

	public TextType getValue() {
		return value;
	}

	public void setValue(TextType value) {
		this.value = value;
	}
}