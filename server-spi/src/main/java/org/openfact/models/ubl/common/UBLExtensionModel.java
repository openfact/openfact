package org.openfact.models.ubl.common;

public interface UBLExtensionModel {

    String getID();

    void setID(String value);

    String getName();

    void setName(String value);

    String getExtensionAgencyID();

    void setExtensionAgencyID(String value);

    String getExtensionAgencyName();

    void setExtensionAgencyName(String value);

    String getExtensionVersionID();

    void setExtensionVersionID(String value);

    String getExtensionAgencyURI();

    void setExtensionAgencyURI(String value);

    String getExtensionURI();

    void setExtensionURI(String value);

    String getExtensionReasonCode();

    void setExtensionReasonCode(String value);

    String getExtensionReason();

    void setExtensionReason(String value);

    ExtensionContentModel getExtensionContent();

    void setExtensionContent(ExtensionContentModel value);

    String getId();

    

}
