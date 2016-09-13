package org.openfact.models.ubl.type;

public interface BinaryObjectModel {

    // protected BinaryObjectMimeCodeContentType mimeCode;

    byte[] getValue();

    void setValue(byte[] value);

    String getFormat();

    void setFormat(String format);

    String getEncodingCode();

    void setEncodingCode(String encodingCode);

    String getCharacterSetCode();

    void setCharacterSetCode(String characterSetCode);

    String getUri();

    void setUri(String uri);

    String getFilename();

    void setFilename(String filename);

}
