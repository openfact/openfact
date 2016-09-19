package org.openfact.models.jpa.ubl.common;

public class BinaryObjectAdapter implements BinaryObjectModel, JpaModel<BinaryObjectEntity> {

    protected static final Logger logger = Logger.getLogger(BinaryObjectAdapter.class);
    protected BinaryObjectEntity binaryObject;
    protected EntityManager em;
    protected OpenfactSession session;

    public BinaryObjectAdapter(OpenfactSession session, EntityManager em, BinaryObjectEntity binaryObject) {
        this.session = session;
        this.em = em;
        this.binaryObject = binaryObject;
    }

    byte[] getValue() {
        return this.binaryObject.getValue();
    }

    void setValue(byte[] value) {
        this.binaryObject.setValue(value);
    }

    String getFormat() {
        return this.binaryObject.getFormat();
    }

    void setFormat(String value) {
        this.binaryObject.setFormat(value);
    }

    Byte[] getMimeCode() {
        return this.binaryObject.getMimeCode();
    }

    void setMimeCode(Byte[] value) {
        this.binaryObject.setMimeCode(value);
    }

    String getEncodingCode() {
        return this.binaryObject.getEncodingCode();
    }

    void setEncodingCode(String value) {
        this.binaryObject.setEncodingCode(value);
    }

    String getCharacterSetCode() {
        return this.binaryObject.getCharacterSetCode();
    }

    void setCharacterSetCode(String value) {
        this.binaryObject.setCharacterSetCode(value);
    }

    String getUri() {
        return this.binaryObject.getUri();
    }

    void setUri(String value) {
        this.binaryObject.setUri(value);
    }

    String getFilename() {
        return this.binaryObject.getFilename();
    }

    void setFilename(String value) {
        this.binaryObject.setFilename(value);
    }

    String getId() {
        return this.binaryObject.getId();
    }

    void setId(String value) {
        this.binaryObject.setId(value);
    }

}
