package org.openfact.models.jpa.entities.ubl;

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
    private byte[] EmbeddedDocumentBinaryObject;
    private ExternalReference m_ExternalReference;

    public Attachment() {

    }

    /**
     * @return the embeddedDocumentBinaryObject
     */
    public byte[] getEmbeddedDocumentBinaryObject() {
        return EmbeddedDocumentBinaryObject;
    }

    /**
     * @param embeddedDocumentBinaryObject
     *            the embeddedDocumentBinaryObject to set
     */
    public void setEmbeddedDocumentBinaryObject(byte[] embeddedDocumentBinaryObject) {
        EmbeddedDocumentBinaryObject = embeddedDocumentBinaryObject;
    }

    /**
     * @return the m_ExternalReference
     */
    public ExternalReference getM_ExternalReference() {
        return m_ExternalReference;
    }

    /**
     * @param m_ExternalReference
     *            the m_ExternalReference to set
     */
    public void setM_ExternalReference(ExternalReference m_ExternalReference) {
        this.m_ExternalReference = m_ExternalReference;
    }

}