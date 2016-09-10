package org.openfact.models.ubl.type;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by lxpary on 08/09/16.
 */
@Embeddable
@Access(AccessType.FIELD)
public class TextType {
	@Column(name = "VALUE")
	protected String value;
	@Column(name = "LANGUAGE_ID")
	protected String languageID;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getLanguageID() {
		return languageID;
	}

	public void setLanguageID(String languageID) {
		this.languageID = languageID;
	}
}
