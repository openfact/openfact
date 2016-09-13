package org.openfact.representations.idm.ubl.type;

public class BinaryObjectRepresentation {
    protected byte[] value;
    protected String format;

    // protected BinaryObjectMimeCodeContentType mimeCode;

    protected String encodingCode;
    protected String characterSetCode;
    protected String uri;
    protected String filename;

    public byte[] getValue() {
        return value;
    }

    public void setValue(byte[] value) {
        this.value = value;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getEncodingCode() {
        return encodingCode;
    }

    public void setEncodingCode(String encodingCode) {
        this.encodingCode = encodingCode;
    }

    public String getCharacterSetCode() {
        return characterSetCode;
    }

    public void setCharacterSetCode(String characterSetCode) {
        this.characterSetCode = characterSetCode;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
