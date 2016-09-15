package org.openfact.models.ubl.common;

public interface UBLExtensionType {

    IDType getID();

    void setID(IDType value);

    NameTypeCommBas getName();

    void setName(NameTypeCommBas value);

    ExtensionAgencyIDType getExtensionAgencyID();

    void setExtensionAgencyID(ExtensionAgencyIDType value);

    ExtensionAgencyNameType getExtensionAgencyName();

    void setExtensionAgencyName(ExtensionAgencyNameType value);

    ExtensionVersionIDType getExtensionVersionID();

    void setExtensionVersionID(ExtensionVersionIDType value);

    ExtensionAgencyURIType getExtensionAgencyURI();

    void setExtensionAgencyURI(ExtensionAgencyURIType value);

    ExtensionURIType getExtensionURI();

    void setExtensionURI(ExtensionURIType value);

    ExtensionReasonCodeType getExtensionReasonCode();

    void setExtensionReasonCode(ExtensionReasonCodeType value);

    ExtensionReasonType getExtensionReason();

    void setExtensionReason(ExtensionReasonType value);

    ExtensionContentType getExtensionContent();

    void setExtensionContent(ExtensionContentType value);

    String getId();

    void setId(String value);

}
