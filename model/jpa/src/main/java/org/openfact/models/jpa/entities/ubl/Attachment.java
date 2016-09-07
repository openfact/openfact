package org.openfact.models.jpa.entities.ubl;

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
	private byte[] embeddedDocumentBinaryObject;
	private List<ExternalReference> ExternalReferences= new ArrayList<>();

	public Attachment() {

	}

	/**
	 * @return the embeddedDocumentBinaryObject
	 */
	public byte[] getEmbeddedDocumentBinaryObject() {
		return embeddedDocumentBinaryObject;
	}

	/**
	 * @param embeddedDocumentBinaryObject
	 *            the embeddedDocumentBinaryObject to set
	 */
	public void setEmbeddedDocumentBinaryObject(byte[] embeddedDocumentBinaryObject) {
		embeddedDocumentBinaryObject = embeddedDocumentBinaryObject;
	}

	public List<ExternalReference> getExternalReferences() {
		return ExternalReferences;
	}

	public void setExternalReferences(List<ExternalReference> externalReferences) {
		ExternalReferences = externalReferences;
	}
}