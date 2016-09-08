package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

/**
 * A template for a required document in a tendering process.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:17 a. m.
 */
public class TenderRequirement {

	/**
	 * Text describing this tender requirement.
	 */
	private String description;
	/**
	 * A name of this tender requirement.
	 */
	private String name;
	private DocumentReference TemplateDocumentReference;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DocumentReference getTemplateDocumentReference() {
		return TemplateDocumentReference;
	}

	public void setTemplateDocumentReference(DocumentReference templateDocumentReference) {
		TemplateDocumentReference = templateDocumentReference;
	}
}// end Tender Requirement