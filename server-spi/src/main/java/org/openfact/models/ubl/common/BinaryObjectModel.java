package org.openfact.models.ubl.common;

public interface BinaryObjectModel {

    Byte[] getValue();

    void setValue(Byte[] value);

    String getFormat();

    void setFormat(String value);

    String getMimeCode();

    void setMimeCode(String value);

    String getEncodingCode();

    void setEncodingCode(String value);

    String getCharacterSetCode();

    void setCharacterSetCode(String value);

    String getUri();

    void setUri(String value);

    String getFilename();

    void setFilename(String value);

    String getId();

    

}
