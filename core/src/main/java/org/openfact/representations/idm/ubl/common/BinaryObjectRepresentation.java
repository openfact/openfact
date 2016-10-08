package org.openfact.representations.idm.ubl.common;

public class BinaryObjectRepresentation {
    private Byte[] value;
    private String format;
    private String mimeCode;
    private String encodingCode;
    private String characterSetCode;
    private String uri;
    private String filename;
    private String id;

    public String getEncodingCode() {
        return this.encodingCode;
    }

    public void setEncodingCode(String encodingCode) {
        this.encodingCode = encodingCode;
    }

    public String getFilename() {
        return this.filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCharacterSetCode() {
        return this.characterSetCode;
    }

    public void setCharacterSetCode(String characterSetCode) {
        this.characterSetCode = characterSetCode;
    }

    public String getMimeCode() {
        return this.mimeCode;
    }

    public void setMimeCode(String mimeCode) {
        this.mimeCode = mimeCode;
    }

    public String getUri() {
        return this.uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getFormat() {
        return this.format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Byte[] getValue() {
        return this.value;
    }

    public void setValue(Byte[] value) {
        this.value = value;
    }
}