package org.openfact.models.jpa.entities.ubl;

import org.openfact.models.jpa.entities.ublType.BinaryObjectType;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to describe an attached document. An attachment can refer to an
 * external document or be included with the document being exchanged.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:12:47 a. m.
 */
public class Attachment {

	/**
	 * A binary large object containing an attached document.
	 */
	private BinaryObjectType embeddedDocumentBinaryObject;
	private List<ExternalReference> externalReferences= new ArrayList<>();

	public Attachment() {

	}

	public BinaryObjectType getEmbeddedDocumentBinaryObject() {
		return embeddedDocumentBinaryObject;
	}

	public void setEmbeddedDocumentBinaryObject(BinaryObjectType embeddedDocumentBinaryObject) {
		this.embeddedDocumentBinaryObject = embeddedDocumentBinaryObject;
	}

	public List<ExternalReference> getExternalReferences() {
		return externalReferences;
	}

	public void setExternalReferences(List<ExternalReference> externalReferences) {
		this.externalReferences = externalReferences;
	}
}